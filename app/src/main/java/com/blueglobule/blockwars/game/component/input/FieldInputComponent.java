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

    //TODO: Move this to field, component do not have intrinsic attribute
    private Block selectedBlock;
    private Column selectedColumn;

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
        if (null == selectedBlock && graphicsMeasurement.isInField(x, y)) {
            int columnIndex = graphicsMeasurement.translateToColumnIndex(x);
            float altitude = graphicsMeasurement.translateToAltitude(y);
            Column column = field.get(columnIndex);
            Block block = column.retrieve(altitude);

            if(null != block && block.isLanded()) {
                selectedBlock = block;
                selectedColumn = column;
                block.setState(Block.State.FIRED);
            }
        }
    }

    private void actionMove(Field field, float x, float y) {
        if(null != selectedBlock) {
            float altitude = graphicsMeasurement.translateToAltitude(y);
            if (altitude < 0) {
                altitude = 0;
            } else if (altitude > selectedColumn.ground() - 1) {
                altitude = selectedColumn.ground() - 1;
            }

            selectedBlock.setAltitude(altitude);
        }
    }

    private void actionUp(Field field) {
        selectedBlock = null;
        selectedColumn = null;
    }

    public ConcurrentLinkedQueue<MotionEvent> getInputsQueue() {
        return inputs;
    }
}
