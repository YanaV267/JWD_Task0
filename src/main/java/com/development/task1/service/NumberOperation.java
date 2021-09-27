package com.development.task1.service;

import com.development.task1.entity.CustomDoubleNumber;
import com.development.task1.entity.CustomIntegerNumber;
import com.development.task1.entity.CustomNumber;
import com.development.task1.entity.NumberType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberOperation {
    private static final Logger logger = LogManager.getLogger(CustomNumber.class.getSimpleName());

    public NumberOperation() {

    }

    public double addition(CustomNumber[] customNumbers) {
        double result = 0;
        for (CustomNumber customNumber : customNumbers) {
            result += getNumberValue(customNumber);
        }
        return result;
    }

    public double subtraction(CustomNumber[] customNumbers) {
        double result = getNumberValue(customNumbers[0]);
        for (int i = 1; i < customNumbers.length; i++) {
            result -= getNumberValue(customNumbers[i]);
        }
        return result;
    }

    public int multiplication(CustomNumber[] customNumbers) {
        int result = 1;
        for (CustomNumber customNumber : customNumbers) {
            result *= getNumberValue(customNumber);
        }
        return result;
    }

    public double division(CustomNumber[] customNumbers) {
        double result = getNumberValue(customNumbers[0]);
        for (int i = 1; i < customNumbers.length; i++) {
            if (getNumberValue(customNumbers[i]) == 0) {
                logger.error("среди чисел для деления есть ноль - запрещённая операция");
                result = 0;
                break;
            } else {
                result /= getNumberValue(customNumbers[i]);
            }
        }
        return result;
    }

    public double getNumberValue(CustomNumber customNumber){
        if (customNumber.getType().compareTo(NumberType.INTEGER) == 0) {
            CustomIntegerNumber customIntegerNumber = (CustomIntegerNumber) customNumber;
            return customIntegerNumber.getValue();
        } else {
            CustomDoubleNumber customDoubleNumber = (CustomDoubleNumber) customNumber;
            return customDoubleNumber.getValue();
        }
    }
}
