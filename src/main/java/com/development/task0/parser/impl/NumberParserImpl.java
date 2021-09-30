package com.development.task0.parser.impl;

import com.development.task0.creator.impl.NumberCreatorImpl;
import com.development.task0.entity.CustomNumber;
import com.development.task0.exception.CustomNumberException;
import com.development.task0.parser.NumberParser;
import com.development.task0.validator.NumberValidator;

public class NumberParserImpl implements NumberParser {
    private final NumberCreatorImpl numberCreator = new NumberCreatorImpl();

    @Override
    public CustomNumber[] parseNumber(String[] numberValues) throws CustomNumberException {
        if (!NumberValidator.checkSize(numberValues)) {
            throw new CustomNumberException("Данных в файле нет");
        }
        CustomNumber[] customNumbers = new CustomNumber[numberValues.length];
        int index = 0;
        for (String numberValue : numberValues) {
            if (NumberValidator.checkNumberValue(numberValue)) {
                double value = Double.parseDouble(numberValue);
                customNumbers[index++] = numberCreator.createNumber(value);
            }
        }
        return customNumbers;
    }
}
