package de.cuioss.portal.reference.pages.components.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class DataTableProvider implements Serializable {

    @Serial
    private static final long serialVersionUID = -2113180124386077469L;

    private final List<Entry> content = new ArrayList<>();

    private int lastCounter = 0;

    @PostConstruct
    public void initPage() {
        content.addAll(generateData());
    }

    private List<Entry> generateData() {
        lastCounter = 0;
        final var result = new ArrayList<Entry>();
        for (var i = 0; i < 5; i++) {
            ++lastCounter;
            result.add(new Entry(lastCounter + "123", "Data Content " + lastCounter));
        }
        return result;
    }

    @Data
    public class Entry implements Serializable {

        @Serial
        private static final long serialVersionUID = -1610924280129397035L;

        private final String column1;

        private final String column2;
    }

    public List<Entry> getData() {
        return content;
    }

    public void addAdditionalLine() {
        ++lastCounter;
        content.add(new Entry(lastCounter + "123", "Data Content " + lastCounter));
    }

    public void reset() {
        content.clear();
        content.addAll(generateData());
    }

}
