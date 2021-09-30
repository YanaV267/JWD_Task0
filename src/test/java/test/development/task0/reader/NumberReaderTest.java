package test.development.task0.reader;

import com.development.task0.entity.CustomNumber;
import com.development.task0.exception.CustomNumberException;
import com.development.task0.reader.impl.NumberReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberReaderTest {
    static final Logger LOGGER = LogManager.getLogger(CustomNumber.class.getSimpleName());

    @Test
    public void readNumbers() throws CustomNumberException {
        NumberReaderImpl numberReader = new NumberReaderImpl();
        String[] readNumbers = numberReader.readNumbers("src/main/resources/data/numbers.txt");
        Assert.assertEquals(readNumbers[0], "18");
        LOGGER.info("тест извлечения чисел из файла прошёл успешно");
    }
}
