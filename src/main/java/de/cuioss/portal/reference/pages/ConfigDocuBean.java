/*
 * Copyright © 2025 CUI-OpenSource-Software (info@cuioss.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.cuioss.portal.reference.pages;

import de.cuioss.tools.logging.CuiLogger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import org.primefaces.util.IOUtils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Reads a text file {@code META-INF/modules-default-config/list.txt}, that
 * contains all relative paths to a module default config file. The file can
 * either be a {@code properties} or {@code yaml} file.
 * <p>
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

    private static final CuiLogger LOGGER = new CuiLogger(ConfigDocuBean.class);
    private static final String NAME_KEY = "config_name";
    private static final String RESOURCE_PATH = "META-INF/microprofile-config.properties";

    @Getter
    private List<DefaultConfigSource> defaultConfigSources;

    /**
     * Loads all {@code META-INF/microprofile-config.properties} if the properties contain the key {@value NAME_KEY}
     */
    @PostConstruct
    void init() {
        defaultConfigSources = new ArrayList<>();
        final var classLoader = Thread.currentThread().getContextClassLoader();
        try (var resources = classLoader.resources(RESOURCE_PATH)) {
            resources.forEach(file -> {
                Properties properties = new Properties();
                try {
                    properties.load(file.openStream());
                    if (properties.containsKey(NAME_KEY)) {
                        String name = properties.getProperty(NAME_KEY);
                        // cui-rewrite:disable CuiLogRecordPatternRecipe
                        LOGGER.info("Adding properties %s", name);
                        defaultConfigSources.add(new DefaultConfigSource(file, name, "lang-properties", IOUtils.toString(file.openStream(), StandardCharsets.UTF_8)));
                    }
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });
        } catch (UncheckedIOException e) {
            // cui-rewrite:disable CuiLogRecordPatternRecipe
            LOGGER.error(e, "Could not load default config sources");
        }
    }

    @Value
    public static class DefaultConfigSource {
        URL path;
        String name;
        String lang;
        String content;
    }
}
