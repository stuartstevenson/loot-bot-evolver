package com.sjs.lootbotga.provider;

import org.springframework.stereotype.Component;

@Component
public class RandomProviderImpl implements RandomProvider {
    @Override
    public double random() {
        return Math.random();
    }
}
