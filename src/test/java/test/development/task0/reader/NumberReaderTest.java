package test.development.task0.reader;

import com.development.task0.exception.CustomNumberException;
import com.development.task0.reader.impl.NumberReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberReaderTest {

    @Test
    public void readNumbers() throws CustomNumberException {
        String expected = "18";
        NumberReaderImpl numberReader = new NumberReaderImpl();
        String[] readNumbers = numberReader.readNumbers("data/numbers.txt");
        Assert.assertEquals(readNumbers[0], expected);
    }
}
