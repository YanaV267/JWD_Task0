package com.development.task0.service;

import com.development.task0.entity.CustomNumber;

public interface NumberOperation {
    double addition(CustomNumber[] customNumbers);
    double subtraction(CustomNumber[] customNumbers);
    int multiplication(CustomNumber[] customNumbers);
    double division(CustomNumber[] customNumbers);
}
