package com.blueglobule.blockwars.controler.command;


import com.blueglobule.blockwars.game.component.graphics.GraphicsMeasurement;

public class UpdateMeasurementCommand implements Command {

    private GraphicsMeasurement measurement;
    private int width;
    private int height;

    public UpdateMeasurementCommand(GraphicsMeasurement measurement, int width, int height) {
        this.measurement = measurement;
        this.width = width;
        this.height = height;
    }

    @Override
    public void execute() {
        measurement.update(width, height);
    }
}
