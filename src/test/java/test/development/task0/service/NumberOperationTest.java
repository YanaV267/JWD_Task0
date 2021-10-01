package test.development.task0.service;

import com.development.task0.entity.CustomNumber;
import com.development.task0.exception.CustomNumberException;
import com.development.task0.parser.impl.NumberParserImpl;
import com.development.task0.reader.impl.NumberReaderImpl;
import com.development.task0.service.impl.NumberOperationImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NumberOperationTest {
    static final Logger LOGGER = LogManager.getLogger(CustomNumber.class.getSimpleName());
    private final NumberOperationImpl numberOperation = new NumberOperationImpl();
    private CustomNumber[] customNumbers;

    @BeforeTest
    public void init(){
        NumberReaderImpl numberReader = new NumberReaderImpl();
        NumberParserImpl numberParser = new NumberParserImpl();
        try {
            String[] readNumbers = numberReader.readNumbers("data/numbers.txt");
            customNumbers = numberParser.parseNumber(readNumbers);
        } catch (CustomNumberException exception) {
            LOGGER.error("error of extracting numbers " + exception.getMessage());
        }
    }

    @Test
    public void addition() {
        double expected = 12;
        double assigned = numberOperation.addition(customNumbers);
        Assert.assertEquals(assigned, expected);
    }

    @Test
    public void subtraction() {
        double expected = 24;
        double assigned = numberOperation.subtraction(customNumbers);
        Assert.assertEquals(assigned, expected);
    }

    @Test
    public void multiplication() {
        double expected = 216;
        double assigned = numberOperation.multiplication(customNumbers);
        Assert.assertEquals(assigned, expected);
    }

    @Test
    public void division() {
        double expected = 2;
        double actual = numberOperation.division(customNumbers);
        Assert.assertEquals(actual, expected);
    }
}
