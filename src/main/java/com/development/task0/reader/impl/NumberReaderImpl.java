package com.development.task0.reader.impl;

import com.development.task0.entity.CustomNumber;
import com.development.task0.exception.CustomNumberException;
import com.development.task0.reader.NumberReader;
import com.development.task0.validator.NumberValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberReaderImpl implements NumberReader {
    static final Logger LOGGER = LogManager.getLogger(CustomNumber.class.getSimpleName());
    private static final String DELIMITER = "/";

    @Override
    public String[] readNumbers(String path) throws CustomNumberException {
        if (!NumberValidator.checkFile(path)) {
            throw new CustomNumberException("файл " + path + " в заданной директории не существует");
        }
        String[] numbers = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String fileData;
            while ((fileData = reader.readLine()) != null && numbers == null) {
                numbers = fileData.split(DELIMITER);
            }
        } catch (IOException exception) {
            throw new CustomNumberException("ошибка чтения файла " + path, exception);
        }
        return numbers;
    }
}
