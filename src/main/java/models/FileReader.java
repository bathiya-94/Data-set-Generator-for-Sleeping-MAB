package models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DelayReader {
    public List<Integer> getDelaysArray() throws IOException {
        List<String>  inputArray = Files.readAllLines(Paths.get("src/main/resources/maximumTolerableDelays.txt"));
        List<Integer> maximumTolerableDelays = new ArrayList<>();

        for (String elem:inputArray
             ) {
            maximumTolerableDelays.add(Integer.parseInt(elem));
        }

        return  maximumTolerableDelays;
    }

}
