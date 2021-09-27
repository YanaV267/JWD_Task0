package com.development.task1.factory;

import com.development.task1.entity.CustomNumber;

public class NumberFactory {
    public NumberFactory(){
    }

    public CustomNumber createNumber(){
        return new CustomNumber();
    }

    public CustomNumber createNumber(String value){
        return new CustomNumber(value);
    }
}
