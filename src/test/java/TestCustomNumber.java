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

    public boolean extractNumbers(){
        customNumbers = numberExtraction.getFromFile();
        if (customNumbers.length == 0) {
            logger.error("нет данных для обработки");
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void testExtractingNumbers() {
        if(extractNumbers()){
            return;
        }
        logger.info("первое число - " + numberOperation.getNumberValue(customNumbers[0]));
        logger.info("второе число - " + numberOperation.getNumberValue(customNumbers[1]));
        Assert.assertEquals(numberOperation.getNumberValue(customNumbers[0]), 18);
        logger.info("извлечение чисел из файла прошло успешно");
    }

    @Test
    public void testAddition() {
        if(extractNumbers()){
            return;
        }
        Assert.assertEquals(numberOperation.addition(customNumbers), 30);
        logger.info("тест сложения чисел прошёл успешно");
    }

    @Test
    public void testSubtraction() {
        if(extractNumbers()){
            return;
        }
        Assert.assertEquals(numberOperation.subtraction(customNumbers), 6);
        logger.info("тест вычитания из первого числа остальных чисел прошёл успешно");
    }

    @Test
    public void testMultiplication() {
        if(extractNumbers()){
            return;
        }
        Assert.assertEquals(numberOperation.multiplication(customNumbers), 216);
        logger.info("тест умножения чисел прошёл успешно");
    }

    @Test
    public void testDivision() {
        if(extractNumbers()){
            return;
        }
        Assert.assertEquals(numberOperation.division(customNumbers), 30);
        logger.info("тест деления первого числа на остальные числа прошёл успешно");
    }
}
