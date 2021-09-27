import com.development.task1.entity.CustomNumber;
import com.development.task1.service.NumberExtraction;
import com.development.task1.service.NumberOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCustomNumber {
    private CustomNumber[] customNumbers;
    private final NumberExtraction numberExtraction = new NumberExtraction();
    private final NumberOperation numberOperation = new NumberOperation();
    private final Logger logger = LogManager.getLogger(CustomNumber.class.getSimpleName());

    @Test
    public void testExtractingNumbers() {
        customNumbers = numberExtraction.getFromFile();
        if (customNumbers.length == 0) {
            logger.error("нет данных для обработки");
            return;
        }
        logger.info("первое значение = " + customNumbers[0].getValue());
        logger.info("второе значение = " + customNumbers[1].getValue());
        Assert.assertEquals(numberExtraction.getFromFile()[1].getValue(), 12);
        logger.info("извлечение чисел из файла прошло успешно");
    }

    @Test
    public void testAddition() {
        testExtractingNumbers();
        Assert.assertEquals(numberOperation.addition(customNumbers), 30);
        logger.info("тест сложения чисел прошёл успешно");
    }

    @Test
    public void testSubtraction() {
        testExtractingNumbers();
        Assert.assertEquals(numberOperation.subtraction(customNumbers), 6);
        logger.info("тест вычитания из первого числа остальных чисел прошёл успешно");
    }

    @Test
    public void testMultiplication() {
        testExtractingNumbers();
        Assert.assertEquals(numberOperation.multiplication(customNumbers), 216);
        logger.info("тест умножения чисел прошёл успешно");
    }

    @Test
    public void testDivision() {
        testExtractingNumbers();
        Assert.assertEquals(numberOperation.division(customNumbers), 1.5);
        logger.info("тест деления первого числа на остальные числа прошёл успешно");
    }
}
