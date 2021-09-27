package com.development.task1.service;

import com.development.task1.entity.CustomNumber;

public class NumberOperation {
    public NumberOperation(){

    }

    public int addition(CustomNumber[] customNumbers) {
        int result = 0;
        for (CustomNumber customNumber : customNumbers) {
            result += customNumber.getValue();
        }
        return result;
    }

    public int subtraction(CustomNumber[] customNumbers) {
        int result = customNumbers[0].getValue();
        for (int i = 1; i < customNumbers.length; i++) {
            result -= customNumbers[i].getValue();
        }
        return result;
    }

    public int multiplication(CustomNumber[] customNumbers) {
        int result = 1;
        for (CustomNumber customNumber : customNumbers) {
            result *= customNumber.getValue();
        }
        return result;
    }

    public double division(CustomNumber[] customNumbers) {
        double result = customNumbers[0].getValue();
        for (int i = 1; i < customNumbers.length; i++) {
            result /= customNumbers[i].getValue();
        }
        return result;
    }
}
