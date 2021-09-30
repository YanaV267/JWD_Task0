package test.development.task0.service;

import com.development.task0.entity.CustomNumber;
import com.development.task0.exception.CustomNumberException;
import com.development.task0.parser.impl.NumberParserImpl;
import com.development.task0.reader.impl.NumberReaderImpl;
import com.development.task0.service.impl.NumberOperationImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberOperationTest {
    static final Logger LOGGER = LogManager.getLogger(CustomNumber.class.getSimpleName());
    private final NumberOperationImpl numberOperation = new NumberOperationImpl();
    private CustomNumber[] customNumbers;

    {
        NumberReaderImpl numberReader = new NumberReaderImpl();
        NumberParserImpl numberParser = new NumberParserImpl();
        try {
            String[] readNumbers = numberReader.readNumbers("src/main/resources/data/numbers.txt");
            customNumbers = numberParser.parseNumber(readNumbers);
        } catch (CustomNumberException exception) {
            LOGGER.error("ошибка извлечения чисел " + exception.getMessage());
        }
    }

    @Test
    public void addition() {
        double assigned = numberOperation.addition(customNumbers);
        double expected = 12;
        Assert.assertEquals(assigned, expected);
        LOGGER.info("тест суммирования чисел прошёл успешно");
    }

    @Test
    public void subtraction() {
        double assigned = numberOperation.subtraction(customNumbers);
        double expected = 24;
        Assert.assertEquals(assigned, expected);
        LOGGER.info("тест вычитания из первого полученного числа остальных чисел прошёл успешно");
    }

    @Test
    public void multiplication() {
        double assigned = numberOperation.multiplication(customNumbers);
        double expected = 216;
        Assert.assertEquals(assigned, expected);
        LOGGER.info("тест перемножения чисел прошёл успешно");
    }

    @Test
    public void division() {
        double assigned = numberOperation.division(customNumbers);
        double expected = 2;
        Assert.assertEquals(assigned, expected);
        LOGGER.info("тест деления первого полученного числа на остальные числа прошёл успешно");
    }
}
