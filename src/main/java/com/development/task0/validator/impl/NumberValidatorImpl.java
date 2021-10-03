package com.development.task0.validator.impl;

import com.development.task0.entity.CustomNumber;
import com.development.task0.validator.NumberValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberValidatorImpl implements NumberValidator {
    static final Logger LOGGER = LogManager.getLogger(CustomNumber.class.getSimpleName());
    private static final String NUMBER_REGEX = "[-]?\\d+\\.?\\d*";

    public boolean checkNumberValue(String numberValue) {
        if (numberValue.matches(NUMBER_REGEX)) {
            return true;
        } else {
            LOGGER.error("wrong data format {}", numberValue);
            return false;
        }
    }
}
