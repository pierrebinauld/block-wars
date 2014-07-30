package com.blueglobule.blockwars.service.locator;

import com.blueglobule.blockwars.service.TimeService;

public class TimeServiceLocator extends ServiceLocator<TimeService> {

    @Override
    protected TimeService buildNullService() {
        return null;
    }
}
