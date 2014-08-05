package com.blueglobule.blockwars.service;

import java.util.Random;

public class RandomService {

    Random random = new Random();

    public int random(int min, int max) {
        return random.nextInt((max - min)) + min;
    }
}
