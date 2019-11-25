import models.FileReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class DelayReaderTest
{
    @Test
    public  void testDelayRead() throws IOException {
        FileReader delayReader = new FileReader();
        List<Integer> delayList = delayReader.getDelaysArray();

        System.out.println(delayList);

    }
}
