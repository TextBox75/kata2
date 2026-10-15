package tests;

import org.junit.jupiter.api.Test;
import software.ulpgc.katas.io.*;
import software.ulpgc.katas.model.Wine;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleWineWriterTest {
    @Test
    public void testFile(){
        WineReader reader = new FileWineReader(new File("./io/wine_fraud.csv"));
        List<Wine> Wines = reader.ReadAllWines();

        WineMetrics metrics = new WineMetrics(Wines);
        int legit = metrics.countLegit();

        WineWriter writer = new ConsoleWineWriter();
        writer.WriteLine("Legit " +  legit);
        assertEquals(6251, legit);
    }

    @Test
    public void testURL() throws MalformedURLException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/wine_fraud.csv");
        WineReader reader = new URLWineReader(url);
        List<Wine> Wines = reader.ReadAllWines();

        WineMetrics metrics = new WineMetrics(Wines);
        int legit = metrics.countLegit();

        WineWriter writer = new ConsoleWineWriter();
        writer.WriteLine("Legit " + legit);
        assertEquals(6251, legit);
    }
}