package com.blueglobule.blockwars.service.locator;

import com.blueglobule.blockwars.service.RandomService;

public class RandomServiceLocator extends ServiceLocator<RandomService> {

    @Override
    protected RandomService buildNullService() {
        return null;
    }
};