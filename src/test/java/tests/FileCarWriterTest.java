package tests;

import org.junit.jupiter.api.Test;
import software.ulpgc.katas.io.*;
import software.ulpgc.katas.model.Car;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileCarWriterTest {
    @Test
    public void testFile() throws IOException {
        CarReader reader = new FileCarReader(new File("./io/car.csv"));
        List<Car> cars = reader.ReadAllCars();

        CarMetrics metrics = new CarMetrics(cars);
        int manuals = metrics.countManuals();

        CarWriter writer = new FileCarWriter("./io/car-output.txt");
        writer.WriteLine("Manuals " + manuals);
        assertTrue(Files.exists(Path.of("./io/car-output.txt")));

        assertArrayEquals("Manuals 261".getBytes(), Files.readAllBytes(Path.of("./io/car-output.txt")));
    }

    @Test
    public void testURL() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/car.csv");
        CarReader reader = new URLCarReader(url);
        List<Car> cars = reader.ReadAllCars();

        CarMetrics metrics = new CarMetrics(cars);
        int manuals = metrics.countManuals();

        CarWriter writer = new FileCarWriter("./io/car-output.txt");
        writer.WriteLine("Manuals " + manuals);
        assertTrue(Files.exists(Path.of("./io/car-output.txt")));

        assertArrayEquals("Manuals 261".getBytes(), Files.readAllBytes(Path.of("./io/car-output.txt")));
    }
}
