package com.blueglobule.blockwars.controler.command;

import com.blueglobule.blockwars.game.GameEngine;

public abstract class EngineCommand implements Command {

    protected GameEngine gameEngine;

    public EngineCommand(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }
}
