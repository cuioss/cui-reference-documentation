package de.cuioss.portal.reference.pages;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import de.cuioss.tools.collect.CollectionLiterals;
import de.cuioss.tools.io.IOStreams;
import de.cuioss.tools.logging.CuiLogger;
import de.cuioss.tools.string.Splitter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

/**
 * Reads a text file {@code META-INF/modules-default-config/list.txt}, that
 * contains all relative paths to a module default config file. The file can
 * either be a {@code properties} or {@code yaml} file.
 *
 * A list of {@link DefaultConfigSource}s is provided, each representing an
 * abstract description of the default config.
 *
 * @author i001469
 */
@Named
@ApplicationScoped
@EqualsAndHashCode
@ToString
public class ConfigDocuBean {

    private static final CuiLogger log = new CuiLogger(ConfigDocuBean.class);

    private static final String RESOURCE_PATH = "META-INF/modules-default-config/";
    private static final String RESOURCES_LIST_PATH = RESOURCE_PATH + "list.txt";

    @Getter
    private List<DefaultConfigSource> defaultConfigSources;

    /**
     * Loads all {@code META-INF/microprofile-config.properties} and
     * {@code META-INF/microprofile-config.yaml}
     * {@link org.eclipse.microprofile.config.spi.ConfigSource}s.
     *
     * @return
     */
    @PostConstruct
    void init() {
        final List<DefaultConfigSource> sources = new ArrayList<>();
        try {
            final var classLoader = Thread.currentThread().getContextClassLoader();
            try (var is = classLoader.getResourceAsStream(RESOURCES_LIST_PATH)) {
                final var listFileContent = IOStreams.toString(is);
                // We are using comma to separate each module config. This is set in
                // maven-antrun "pathconvert".
                final var paths = Splitter.on(',').splitToList(listFileContent);
                paths.stream().map(ConfigDocuBean::toDefaultConfigSource).forEach(sources::add);
            }
        } catch (Exception e) {
            log.error("Could not load default config sources", e);
        }

        defaultConfigSources = CollectionLiterals.immutableList(sources);
    }

    private static DefaultConfigSource toDefaultConfigSource(String path) {
        log.info("module default config found: {}", path);

        // path must start with "/" in order to be loaded as classpath resource, see:
        // com.icw.ehf.cui.dev.ui.components.SourceCodeComponent.resolvePath
        var moduleName = path.substring(RESOURCE_PATH.length() + 1, path.lastIndexOf("/"));

        return new DefaultConfigSource(path, moduleName, resolveStyle(path));
    }

    private static String resolveStyle(String path) {
        if (null == path) {
            return null;
        }
        if (path.endsWith(".properties")) {
            return "lang-properties";
        }
        if (path.endsWith(".yaml") || path.endsWith(".yml")) {
            return "lang-yaml";
        }
        log.warn("Unknown source path: {}", path);
        return null;
    }

    @Value
    public static class DefaultConfigSource {
        final String path;
        final String moduleName;
        final String lang;
    }
}
