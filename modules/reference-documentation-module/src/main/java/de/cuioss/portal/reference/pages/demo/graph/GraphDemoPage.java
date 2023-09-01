package de.cuioss.portal.reference.pages.demo.graph;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.cuioss.jsf.jqplot.JqPlot;
import de.cuioss.jsf.jqplot.js.types.JsDouble;
import de.cuioss.jsf.jqplot.layout.Grid;
import de.cuioss.jsf.jqplot.layout.Location;
import de.cuioss.jsf.jqplot.layout.Series;
import de.cuioss.jsf.jqplot.layout.Title;
import de.cuioss.jsf.jqplot.model.Seria;
import de.cuioss.jsf.jqplot.model.SeriesData;
import de.cuioss.jsf.jqplot.options.Options;
import de.cuioss.jsf.jqplot.options.legend.Legend;
import de.cuioss.jsf.jqplot.options.legend.Placement;
import de.cuioss.jsf.jqplot.renderer.marker.MarkerRendererOptions;
import de.cuioss.jsf.jqplot.renderer.marker.PointStyle;
import de.cuioss.test.generator.Generators;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class GraphDemoPage implements Serializable {

    private static final long serialVersionUID = 6009604591051816282L;

    @Getter
    private JqPlot simpleLineChart;

    private final SeriesData twoLineSeriaData = initGraphData();

    @Getter
    private JqPlot twoLinesChart;

    @Getter
    @Setter
    private String twoLinesGrapTitel = "Two Lines graph title";

    @Getter
    @Setter
    private String firstSeriaColor = "red";
    @Getter
    @Setter
    private String firstSeriaLabel = "First Seria";

    @PostConstruct
    public void intiBean() {
        simpleLineChart = initSimpleLineChart();
        twoLinesChart = initTwoLinesChart();
    }

    private JqPlot initSimpleLineChart() {
        final var data = new SeriesData();
        final var doublesGenerator = Generators.doubles(-50.0, 50.0);
        final var dataItem = new Seria<JsDouble, JsDouble>();
        for (var i = -10; i < 11; i++) {
            dataItem.addAsTuple(new JsDouble(1.0 * i), new JsDouble(doublesGenerator.next()));
        }
        data.addSeriaDataIfNotNull(dataItem);
        return new JqPlot("simpleChart", data);
    }

    private JqPlot initTwoLinesChart() {
        final var twoLineGraphOptions = new Options();

        final var gridAdaptations = new Grid();
        gridAdaptations.setBackground("#fff");
        gridAdaptations.setBorderColor("#ccc");
        gridAdaptations.setShadow(false);
        gridAdaptations.setBorderWidth(0.0);

        twoLineGraphOptions.setGrid(gridAdaptations);

        twoLineGraphOptions.setTitle(new Title(twoLinesGrapTitel));

        final var legend = new Legend().setShow(true).setPlacement(Placement.OUTSIDE).setLocation(Location.NW);
        legend.getRendererOptions().setNumberRows(2);
        twoLineGraphOptions.setLegend(legend);

        // adaptation of seria (aka. Ticks) does follow the order of added seria data
        twoLineGraphOptions.addSeriaOption(Series.createAsListElement().setColor(firstSeriaColor)
                .setLabel(firstSeriaLabel).setMarkerOptions(new MarkerRendererOptions().setStyle(PointStyle.CIRCLE)));

        return new JqPlot("twoLinesChart", twoLineSeriaData, twoLineGraphOptions);
    }

    private static SeriesData initGraphData() {

        final var data = new SeriesData();

        final var dataSeria1 = new Seria<JsDouble, JsDouble>();
        final var dataSeria2 = new Seria<JsDouble, JsDouble>();
        final var maxCount = 20;
        for (var i = 0; i < maxCount + 1; i++) {
            dataSeria1.addAsTuple(new JsDouble(1.0 * i), new JsDouble(1.0 * i));
            dataSeria2.addAsTuple(new JsDouble(1.0 * i), new JsDouble(1.0 * (maxCount - i)));
        }
        data.addSeriaDataIfNotNull(dataSeria1);
        data.addSeriaDataIfNotNull(dataSeria2);

        return data;
    }

    public void updateModel() {
        twoLinesChart = initTwoLinesChart();
    }

}
