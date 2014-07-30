package com.blueglobule.blockwars.service.locator;

public abstract class ServiceLocator<Service> {

    private Service service;
    private Service nullService;

    protected ServiceLocator() {
        this.nullService = buildNullService();
    }

    protected abstract Service buildNullService();

    public Service getService() {
        return service;
    }

    public void provide(Service service) {
        if (null == service) {
            service = nullService;
        } else {
            service = service;
        }
    }

}
