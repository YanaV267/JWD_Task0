package com.development.task0.reader.impl;

import com.development.task0.exception.CustomNumberException;
import com.development.task0.reader.NumberReader;
import com.development.task0.validator.NumberValidator;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class NumberReaderImpl implements NumberReader {
    private static final String DELIMITER = "/";

    @Override
    public String[] readNumbers(String path) throws CustomNumberException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        if (inputStream == null) {
            throw new CustomNumberException("file " + path + " doesn't exits in current directory");
        }
        String[] numbers = null;
        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String fileData;
            if ((fileData = reader.readLine()) != null) {
                numbers = fileData.split(DELIMITER);
            }
        } catch (IOException exception) {
            throw new CustomNumberException("error of reading file " + path, exception);
        }
        return numbers;
    }
}
