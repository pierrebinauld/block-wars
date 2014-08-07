package com.blueglobule.blockwars.locator;

import com.blueglobule.blockwars.game.entity.GraphicsMeasurement;

public class GraphicsMeasurementLocator {

    private static GraphicsMeasurement measurement;

    public static GraphicsMeasurement getGraphicsMeasurement() {
        return measurement;
    }

    public static void provide(GraphicsMeasurement measurement) {
        GraphicsMeasurementLocator.measurement = measurement;
    }
}
