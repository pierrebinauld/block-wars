package com.blueglobule.blockwars.controler.command;


import com.blueglobule.blockwars.locator.GraphicsMeasurementLocator;

public class UpdateMeasurementCommand implements Command {

    private int width;
    private int height;

    public UpdateMeasurementCommand(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void execute() {
        GraphicsMeasurementLocator.getGraphicsMeasurement().update(width, height);
    }
}
