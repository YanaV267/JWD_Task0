package com.development.task0.service.impl;

import com.development.task0.entity.CustomNumber;
import com.development.task0.service.NumberOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberOperationImpl implements NumberOperation {
    private static final Logger logger = LogManager.getLogger(CustomNumber.class.getSimpleName());

    @Override
    public double addition(CustomNumber[] customNumbers) {
        double result = 0;
        for (CustomNumber customNumber : customNumbers) {
            result += customNumber.getValue();
        }
        return result;
    }

    @Override
    public double subtraction(CustomNumber[] customNumbers) {
        double result = customNumbers.length == 0 ? 0 : customNumbers[0].getValue();
        for (int i = 1; i < customNumbers.length; i++) {
            result -= customNumbers[i].getValue();
        }
        return result;
    }

    @Override
    public int multiplication(CustomNumber[] customNumbers) {
        int result = 1;
        for (CustomNumber customNumber : customNumbers) {
            result *= customNumber.getValue();
        }
        return result;
    }

    @Override
    public double division(CustomNumber[] customNumbers) {
        double result = customNumbers.length == 0 ? 0 : customNumbers[0].getValue();
        for (int i = 1; i < customNumbers.length; i++) {
            if (customNumbers[i].getValue() == 0) {
                logger.error("a zero was found across the numbers - forbidden operation");
            } else {
                result /= customNumbers[i].getValue();
            }
        }
        return result;
    }
}
