package test.development.task0.parser;

import com.development.task0.entity.CustomNumber;
import com.development.task0.exception.CustomNumberException;
import com.development.task0.parser.impl.NumberParserImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberParserTest {

    @Test
    public void parseNumber() throws CustomNumberException {
        double expected = 0.5;
        String[] numbers = {"15", "0..5", "-3"};
        NumberParserImpl numberParser = new NumberParserImpl();
        CustomNumber[] customNumbers = numberParser.parseNumber(numbers);
        Assert.assertEquals(customNumbers[1].getValue(), expected);
    }
}
