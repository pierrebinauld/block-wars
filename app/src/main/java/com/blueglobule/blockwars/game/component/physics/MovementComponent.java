package com.blueglobule.blockwars.game.component.physics;

import android.util.Log;

import com.blueglobule.blockwars.game.component.PhysicsComponent;
import com.blueglobule.blockwars.game.entity.Column;
import com.blueglobule.blockwars.game.entity.Field;
import com.blueglobule.blockwars.game.entity.Lane;

public class MovementComponent extends PhysicsComponent<Field> {

    @Override
    public void init(Field field) {
        for (Lane lane : field) {
            lane.setTimeToResetShip(rule.getTimeToResetShip());
        }
    }

    @Override
    public void update(Field field) {
        for (Lane lane : field) {
            int i = 0;
            Column landingColumn = null;
            boolean noFlyingColumn = true;

            while (i < lane.size()) {
                Column column = lane.get(i);
                column.setY(i);

                movementChangement(column);

                if (column.isLanded()) {
                    landingColumn = idle(column);
                } else {
                    landingColumn = fly(column, landingColumn);
                }

//                landingColumn = column;
                noFlyingColumn &= landingColumn.movement() != Column.Movement.FLYING;

                i = column.y() + 1;
            }

            if(!noFlyingColumn && lane.size() > 0) {
                Log.d("MC", "Flying: "+noFlyingColumn);
                lane.resetTimeToResetShip();
            } else if (lane.isTimeToResetShip()) {
                Log.d("MC", "Time: "+lane.isTimeToResetShip());
                lane.resetShip();
                lane.resetTimeToResetShip();
            }

        }
    }

    private void movementChangement(Column column) {
        if (column.movementHasChanged()) {
            column.movementChangementPerformed();

            switch (column.movement()) {
                case LANDING:
                    landing(column);
                    break;
                case FALLING:
                    falling(column);
                    break;
                case LAUNCHING:
                    launching(column);
                    break;
                case FLYING:
                    flying(column);
                    break;
                default:
                    break;
            }
        }
    }

    public Column idle(Column column) {



        return column;
    }

    public Column fly(Column column, Column landingColumn) {
        column.move();

        float landingAltitude = null != landingColumn ? landingColumn.topAltitude() : 0;
        if (column.floorAltitude() <= landingAltitude) {
            if(null == landingColumn || landingColumn.isLanded() && column.movement() == Column.Movement.FLYING) {
                //TODO: Set a movement and manage right now ?
                column.setMovement(Column.Movement.LANDING);
                landing(column);
                column.setAltitude(landingAltitude);
                column.movementChangementPerformed();
            } else {
                column = landingColumn.merge(column);
            }
        }

        return column;
    }

    public void landing(Column column) {
        column.setAcceleration(0f);
        column.setSpeed(0f);
        column.setLanded(true);
    }


    public void falling(Column column) {
        column.setAcceleration(gravity(column));
        column.setSpeed(0f);
        column.setMinSpeedLimit(-10f); //TODO: Magic Number !
        column.setLanded(false);
    }

    public void launching(Column column) {
        column.setAcceleration(0f);
        column.setLanded(false);
        column.setMovement(Column.Movement.FLYING);
    }

    public void flying(Column column) {
        column.setAcceleration(gravity(column));
        column.setMinSpeedLimit(-0.05f); //TODO: Magic Number !
        column.setLanded(false);
    }

    private float gravity(Column column) {
        return column.size() * rule.getGravity();
    }
}
