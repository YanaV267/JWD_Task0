package com.development.task1.service;

import com.development.task1.entity.CustomIntegerNumber;
import com.development.task1.entity.CustomNumber;
import com.development.task1.entity.NumberType;
import com.development.task1.factory.NumberFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberExtraction {
    private static final String intCustomNumber = "[0-9]+";
    private static final String doubleCustomNumber = "[0-9]+\\.[0-9]+";
    private static final Logger logger = LogManager.getLogger(CustomNumber.class.getSimpleName());
    private final NumberFactory numberFactory;

    public NumberExtraction() {
        numberFactory = new NumberFactory();
    }

    public CustomNumber[] getFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/numbers.txt"))) {
            String fileData = reader.readLine();
            CustomNumber[] customNumbers = checkData(fileData);
            if (customNumbers.length == 0) {
                logger.error("неверный формат полученных данных");
            }
            return customNumbers;
        } catch (IOException exception) {
            exception.printStackTrace();
            return new CustomIntegerNumber[0];
        }
    }

    private CustomNumber[] checkData(String data) {
        String[] values = data.split("/");
        if (values.length == 0) {
            return new CustomIntegerNumber[0];
        }
        CustomNumber[] customNumbers = new CustomNumber[values.length];
        int flag = 0;
        for (String value : values) {
            customNumbers[flag] = getNumber(value);
            if (customNumbers[flag] == null) {
                return new CustomIntegerNumber[0];
            }
            flag++;
        }
        return customNumbers;
    }

    private CustomNumber getNumber(String value) {
        CustomNumber customNumber;
        if (value.matches(intCustomNumber)) {
            customNumber = numberFactory.createNumber(NumberType.INTEGER, value);
            customNumber.setType(NumberType.INTEGER);
        } else if (value.matches(doubleCustomNumber)) {
            customNumber = numberFactory.createNumber(NumberType.DOUBLE, value);
            customNumber.setType(NumberType.DOUBLE);
        } else {
            logger.error("неверный формат данных");
            customNumber = null;
        }
        return customNumber;
    }
}
