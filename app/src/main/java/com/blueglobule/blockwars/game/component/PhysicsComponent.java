package com.blueglobule.blockwars.game.component;


import com.blueglobule.blockwars.locator.RuleLocator;

public abstract class PhysicsComponent<Entity> extends RuleLocator{

   public abstract void update(Entity entity);
}
