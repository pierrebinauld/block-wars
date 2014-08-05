package com.blueglobule.blockwars.locator;


public class ObjectLocator<Object> {

    private Object object;

    public Object get() {
        return object;
    }

    public void provide(Object object) {
        this.object = object;
    }
}
