package com.development.task0.parser;

import com.development.task0.entity.CustomNumber;
import com.development.task0.exception.CustomNumberException;

public interface NumberParser {
    CustomNumber[] parseNumber(String[] numberValues) throws CustomNumberException;
}
