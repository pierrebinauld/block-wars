package com.blueglobule.blockwars.controler.command;

import com.blueglobule.blockwars.game.GameEngine;
import com.blueglobule.blockwars.game.entity.GameState;

public class ChangeEntityCommand extends EngineCommand {

    private GameState gameState;

    public ChangeEntityCommand(GameEngine gameEngine, GameState gameState) {
        super(gameEngine);
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        gameEngine.setGameState(gameState);
    }
}
