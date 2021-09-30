package test.development.task0.creator;

import com.development.task0.creator.impl.NumberCreatorImpl;
import com.development.task0.entity.CustomNumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberCreatorTest {
    static final Logger LOGGER = LogManager.getLogger(CustomNumber.class.getSimpleName());

    @Test
    public void createNumber() {
        double expected = 15;
        NumberCreatorImpl numberCreator = new NumberCreatorImpl();
        CustomNumber number = numberCreator.createNumber(15);
        Assert.assertEquals(number.getValue(), expected);
        LOGGER.info("тест создания объекта числа прошёл успешно");
    }
}
