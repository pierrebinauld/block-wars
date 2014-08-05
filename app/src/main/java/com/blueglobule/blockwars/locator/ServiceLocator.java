package com.blueglobule.blockwars.locator;

public class ServiceLocator<Service> extends ObjectLocator<Service> {

    private Service nullService;

    public ServiceLocator(Service nullService) {
        this.nullService = nullService;
    }

    public void provide(Service service) {
        if (null == service) {
            super.provide(nullService);
        } else {
            super.provide(service);
        }
    }

}
