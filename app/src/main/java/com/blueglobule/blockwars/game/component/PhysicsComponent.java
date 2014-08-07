package com.blueglobule.blockwars.game.component;


import com.blueglobule.blockwars.game.entity.Rule;
import com.blueglobule.blockwars.locator.RuleLocator;

public abstract class PhysicsComponent<Entity> {

   protected Rule rule = RuleLocator.getRule();

    public abstract void init(Entity entity);
    public abstract void update(Entity entity);
}
