package com.blueglobule.blockwars.game.entity;

import java.util.LinkedList;

public abstract class Runway<F> extends LinkedList<F> {

    public abstract Column land(Column column);

    public abstract float landingAltitude();

}
