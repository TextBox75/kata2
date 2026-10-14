package tests;

import org.junit.jupiter.api.Test;
import software.ulpgc.katas.io.CarReader;
import software.ulpgc.katas.io.URLCarReader;
import software.ulpgc.katas.model.Car;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class URLCarReaderTest {
    @Test
    public void testURLReader() throws MalformedURLException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/car.csv");
        CarReader reader = new URLCarReader(url);
        List<Car> cars = reader.ReadAllCars();
        assertEquals(301, cars.size());
    }

    @Test
    public void testInvalidURL() throws MalformedURLException {
        assertThrows(MalformedURLException.class, () -> new URL("nonexistanturl.com"));
    }
}
