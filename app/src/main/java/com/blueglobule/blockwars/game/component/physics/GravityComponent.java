package com.blueglobule.blockwars.game.component.physics;

import com.blueglobule.blockwars.game.component.PhysicsComponent;
import com.blueglobule.blockwars.game.entity.Column;
import com.blueglobule.blockwars.game.entity.Field;
import com.blueglobule.blockwars.game.entity.Lane;

public class GravityComponent extends PhysicsComponent<Field> {

    @Override
    public void init(Field field) {

    }

    @Override
    public void update(Field field) {
        for (Lane lane : field) {
            int i = 0;
            Column landingColumn = null;
            float landingAltitude = lane.landingAltitude();
            while (i < lane.size()) {
                Column column = lane.get(i);
                column.setY(i);

                movementChangement(column);

                if (!column.isLanded()) {
                    column.move();

                    if (column.floorAltitude() <= landingAltitude) {
                        if (null == landingColumn) {
                            lane.land(column);
                        } else {
                            column = landingColumn.land(column);
                        }
                    }
                }

                landingColumn = column;
                landingAltitude = column.landingAltitude();

                i = column.y() + 1;
            }
        }
    }

    private void movementChangement(Column column) {
        if (column.movementHasChanged()) {
            column.movementChangementPerformed();

            switch (column.movement()) {
                case LANDED:
                    landed(column);
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

    public void landed(Column column) {
        column.setAcceleration(0f);
        column.setSpeed(0f);
        column.setLanded(true);
    }


    public void falling(Column column) {
        column.setAcceleration(rule.getGravity());
        column.setSpeed(0f);
        column.setMinSpeedLimit(-10f); //TODO: Magic Number !
        column.setLanded(false);
    }

    public void launching(Column column) {
        column.setAcceleration(column.impulsion() * 0.1f); //TODO: Magic Number !
        column.setLanded(false);
        column.setMovement(Column.Movement.FLYING);
    }

    public void flying(Column column) {
        column.setAcceleration(rule.getGravity());
        column.setMinSpeedLimit(-0.05f);
        column.setLanded(false);
    }
}
