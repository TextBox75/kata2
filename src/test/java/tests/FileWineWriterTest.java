package tests;

import org.junit.jupiter.api.Test;
import software.ulpgc.katas.io.*;
import software.ulpgc.katas.model.Wine;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileWineWriterTest {
    @Test
    public void testFile() throws IOException {
        WineReader reader = new FileWineReader(new File("./io/wine_fraud.csv"));
        List<Wine> Wines = reader.ReadAllWines();

        WineMetrics metrics = new WineMetrics(Wines);
        int legit = metrics.countLegit();

        WineWriter writer = new FileWineWriter("./io/Wine-output.txt");
        writer.WriteLine("Legit " + legit);
        assertTrue(Files.exists(Path.of("./io/Wine-output.txt")));

        assertArrayEquals("Legit 6251".getBytes(), Files.readAllBytes(Path.of("./io/Wine-output.txt")));
    }

    @Test
    public void testURL() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/wine_fraud.csv");
        WineReader reader = new URLWineReader(url);
        List<Wine> Wines = reader.ReadAllWines();

        WineMetrics metrics = new WineMetrics(Wines);
        int legit = metrics.countLegit();

        WineWriter writer = new FileWineWriter("./io/Wine-output.txt");
        writer.WriteLine("Legit " + legit);
        assertTrue(Files.exists(Path.of("./io/Wine-output.txt")));

        assertArrayEquals("Legit 6251".getBytes(), Files.readAllBytes(Path.of("./io/Wine-output.txt")));
    }
}