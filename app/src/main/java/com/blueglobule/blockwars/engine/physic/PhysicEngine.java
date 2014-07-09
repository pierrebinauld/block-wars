package com.blueglobule.blockwars.engine.physic;

import com.blueglobule.blockwars.model.Game;
import com.blueglobule.blockwars.engine.Engine;

public class PhysicEngine extends Engine implements Runnable {

    private Game game;

    public PhysicEngine(Game game) {
        this.game = game;
    }

    @Override
    public void doRun() {

    }
}
