package com.blueglobule.blockwars;

import android.app.Activity;
import android.os.Bundle;

import com.blueglobule.blockwars.controler.Controller;
import com.blueglobule.blockwars.controler.GameView;
import com.blueglobule.blockwars.game.entity.Rule;
import com.blueglobule.blockwars.game.theme.ThemeLoader;
import com.blueglobule.blockwars.locator.Locators;
import com.blueglobule.blockwars.locator.RuleLocator;
import com.blueglobule.blockwars.locator.ThemeLocator;
import com.blueglobule.blockwars.service.RandomService;
import com.blueglobule.blockwars.tool.Timer;


public class BlockWarsActivity extends Activity {

    private GameView gameView;

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initServices();
        initGraphics();

        gameView = (GameView) findViewById(R.id.game_view);
        controller = new Controller();

        gameView.init(controller);


        Rule rule = new RuleBuilder().build();
        RuleLocator.provide(rule);

        controller.startGame();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void initServices() {
        Locators.random.provide(new RandomService());
    }

    public void initGraphics() {
        ThemeLoader loader = new ThemeLoader(this);
        ThemeLocator.provide(loader.load(R.style.BaseGameTheme));
    }
}
