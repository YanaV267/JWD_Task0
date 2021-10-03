package test.development.task0.creator;

import com.development.task0.creator.impl.NumberCreatorImpl;
import com.development.task0.entity.CustomNumber;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberCreatorTest {

    @Test
    public void createNumber() {
        double expected = 15;
        NumberCreatorImpl numberCreator = new NumberCreatorImpl();
        CustomNumber number = numberCreator.createNumber(15);
        Assert.assertEquals(number.getValue(), expected, "invalid creating of number object");
    }
}
