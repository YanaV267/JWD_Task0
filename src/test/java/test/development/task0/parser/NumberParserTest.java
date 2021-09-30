package test.development.task0.parser;

import com.development.task0.entity.CustomNumber;
import com.development.task0.exception.CustomNumberException;
import com.development.task0.parser.impl.NumberParserImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberParserTest{
    static final Logger LOGGER = LogManager.getLogger(CustomNumber.class.getSimpleName());

    @Test
    public void parseNumber() throws CustomNumberException {
        String[] numbers = {"15", "0..5", "-3"};
        NumberParserImpl numberParser = new NumberParserImpl();
        CustomNumber[] customNumbers = numberParser.parseNumber(numbers);
        Assert.assertEquals(customNumbers[1].getValue(), 0.5);
        LOGGER.info("тест извлечения чисел из файла прошёл успешно");
    }
}
