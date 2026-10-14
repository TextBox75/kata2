package tests;

import org.junit.jupiter.api.Test;
import software.ulpgc.katas.io.*;
import software.ulpgc.katas.model.Car;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleCarWriterTest {
    @Test
    public void testFile(){
        CarReader reader = new FileCarReader(new File("./io/car.csv"));
        List<Car> cars = reader.ReadAllCars();

        CarMetrics metrics = new CarMetrics(cars);
        int manuals = metrics.countManuals();

        CarWriter writer = new ConsoleCarWriter();
        writer.WriteLine("Manuals " +  manuals);
        assertEquals(261, manuals);
    }

    @Test
    public void testURL() throws MalformedURLException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/car.csv");
        CarReader reader = new URLCarReader(url);
        List<Car> cars = reader.ReadAllCars();

        CarMetrics metrics = new CarMetrics(cars);
        int manuals = metrics.countManuals();

        CarWriter writer = new ConsoleCarWriter();
        writer.WriteLine("Manuals " + manuals);
        assertEquals(261, manuals);
    }
}
