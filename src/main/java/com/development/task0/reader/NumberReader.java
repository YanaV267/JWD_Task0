package com.development.task0.reader;

import com.development.task0.exception.CustomNumberException;

public interface NumberReader {
    String[] readNumbers(String path) throws CustomNumberException;
}
