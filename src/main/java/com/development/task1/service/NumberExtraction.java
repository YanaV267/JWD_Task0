package com.development.task1.service;

import com.development.task1.entity.CustomNumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberExtraction {
    private static final String number = "[0-9]+";
    private static final Logger logger = LogManager.getLogger(CustomNumber.class.getSimpleName());

    public NumberExtraction() {
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
            return new CustomNumber[0];
        }
    }

    public CustomNumber[] checkData(String data) {
        String[] values = data.split("/");
        if (values.length == 0) {
            return new CustomNumber[0];
        }
        CustomNumber[] customNumbers = new CustomNumber[values.length];
        int flag = 0;
        for (String value : values) {
            if (!value.matches(number)) {
                return new CustomNumber[0];
            } else {
                CustomNumber customNumber = new CustomNumber(value);
                customNumbers[flag++] = customNumber;
            }
        }
        return customNumbers;
    }
}
