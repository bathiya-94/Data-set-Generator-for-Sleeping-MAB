import models.FileReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class FileReaderTest
{
    @Test
    public  void testDelayRead() throws IOException {
        FileReader fileReader = new FileReader();
        List<Integer> delayList = fileReader.getDelaysArray();

        System.out.println(delayList);

    }

    @Test
    public  void  testActiveMTDRead() throws IOException {
        FileReader fileReader = new FileReader();
        List<Integer> activeMTDs =  fileReader.getActiveMTDs();

        System.out.println(activeMTDs);

    }
}
