package com.development.task1.factory;

import com.development.task1.entity.CustomDoubleNumber;
import com.development.task1.entity.CustomIntegerNumber;
import com.development.task1.entity.CustomNumber;
import com.development.task1.entity.NumberType;

public class NumberFactory {
    public NumberFactory(){
    }

    public CustomNumber createNumber(NumberType numberType, String value){
        CustomNumber customNumber;
        switch (numberType){
            case INTEGER -> customNumber = new CustomIntegerNumber(value);
            case DOUBLE -> customNumber = new CustomDoubleNumber(value);
            default -> throw new IllegalStateException("Unexpected value: " + numberType);
        }
        return customNumber;
    }
}
