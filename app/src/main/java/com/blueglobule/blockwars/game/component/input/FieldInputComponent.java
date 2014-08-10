package com.blueglobule.blockwars.game.component.input;

import android.util.Log;
import android.view.MotionEvent;

import com.blueglobule.blockwars.game.component.InputComponent;
import com.blueglobule.blockwars.game.entity.Block;
import com.blueglobule.blockwars.game.entity.Column;
import com.blueglobule.blockwars.game.entity.Field;

import java.util.concurrent.ConcurrentLinkedQueue;

public class FieldInputComponent extends InputComponent<Field> {

    private ConcurrentLinkedQueue<MotionEvent> inputs = new ConcurrentLinkedQueue<MotionEvent>();

    public FieldInputComponent(ConcurrentLinkedQueue<MotionEvent> inputsQueue) {
        this.inputs = inputsQueue;
    }

    @Override
    public void update(Field field) {
        while (!inputs.isEmpty()) {
            MotionEvent event = inputs.poll();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    actionDown(field, event.getX(), event.getY());
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionMove(field, event.getX(), event.getY());
                    break;
                case MotionEvent.ACTION_UP:
                    actionUp(field);
                    break;
                default:
                    break;
            }
        }
    }

    private void actionDown(Field field, float x, float y) {

        if (!field.hasSelection() && graphicsMeasurement.isInField(x, y)) {
            int columnIndex = graphicsMeasurement.translateToColumnIndex(x);
            float altitude = graphicsMeasurement.translateToAltitude(y);
            field.select(columnIndex, altitude);
            if(field.hasSelection()) {
                field.selectedBlock().setSelectedAltitude(altitude-Field.UNIT/2);
            }
        }
    }

    private void actionMove(Field field, float x, float y) {
        if(field.hasSelection()) {
            float altitude = graphicsMeasurement.translateToAltitude(y);
            field.selectedBlock().setSelectedAltitude(altitude-Field.UNIT/2);
        }
    }

    private void actionUp(Field field) {
        if(field.hasSelection()) {
            field.unselect();
        }
    }

    public ConcurrentLinkedQueue<MotionEvent> getInputsQueue() {
        return inputs;
    }
}
