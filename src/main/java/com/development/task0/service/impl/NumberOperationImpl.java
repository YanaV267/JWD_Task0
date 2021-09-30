package com.development.task0.service.impl;

import com.development.task0.entity.CustomNumber;
import com.development.task0.service.NumberOperation;
import com.development.task0.validator.NumberValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberOperationImpl implements NumberOperation {
    private static final Logger logger = LogManager.getLogger(CustomNumber.class.getSimpleName());

    @Override
    public double addition(CustomNumber[] customNumbers) {
        double result = 0;
        for (CustomNumber customNumber : customNumbers) {
            if (!NumberValidator.checkNumber(customNumber)) {
                continue;
            }
            result += customNumber.getValue();
        }
        return result;
    }

    @Override
    public double subtraction(CustomNumber[] customNumbers) {
        double result = NumberValidator.checkNumber(customNumbers[0]) ? customNumbers[0].getValue() : 0;
        for (int i = 1; i < customNumbers.length; i++) {
            if (!NumberValidator.checkNumber(customNumbers[i])) {
                continue;
            }
            result -= customNumbers[i].getValue();
        }
        return result;
    }

    @Override
    public int multiplication(CustomNumber[] customNumbers) {
        int result = 1;
        for (CustomNumber customNumber : customNumbers) {
            if (!NumberValidator.checkNumber(customNumber)) {
                continue;
            }
            result *= customNumber.getValue();
        }
        return result;
    }

    @Override
    public double division(CustomNumber[] customNumbers) {
        double result = NumberValidator.checkNumber(customNumbers[0]) ? customNumbers[0].getValue() : 0;
        for (int i = 1; i < customNumbers.length; i++) {
            if (!NumberValidator.checkNumber(customNumbers[i])) {
                continue;
            }
            if (customNumbers[i].getValue() == 0) {
                logger.error("среди чисел для деления есть ноль - запрещённая операция");
            } else {
                result /= customNumbers[i].getValue();
            }
        }
        return result;
    }
}
