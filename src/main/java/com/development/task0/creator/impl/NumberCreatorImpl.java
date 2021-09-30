package com.development.task0.creator.impl;

import com.development.task0.creator.NumberCreator;
import com.development.task0.entity.CustomNumber;

public class NumberCreatorImpl implements NumberCreator {

    @Override
    public CustomNumber createNumber(double value) {
        return new CustomNumber(value);
    }
}
