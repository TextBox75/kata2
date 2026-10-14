package tests;

import org.junit.jupiter.api.Test;
import software.ulpgc.katas.io.CarReader;
import software.ulpgc.katas.io.FileCarReader;
import software.ulpgc.katas.model.Car;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileCarReaderTest {
    @Test
    public void testFileReader() {
        CarReader reader = new FileCarReader(new File("./io/car.csv"));
        List<Car> cars = reader.ReadAllCars();
        assertEquals(301, cars.size());
    }

    @Test
    public void testFileReordered() {
        CarReader reader = new FileCarReader(new File("./io/car-reordered.csv"));
        List<Car> cars = reader.ReadAllCars();
        assertEquals(301, cars.size());
    }

    @Test
    public void testFileNonExistant() {
        CarReader reader = new FileCarReader(new File("./io/non-existent-file.csv"));
        assertThrows(RuntimeException.class, () -> reader.ReadAllCars());
    }

    @Test
    public void testFileEmpty() {
        CarReader reader = new FileCarReader(new File("./io/empty-file.csv"));
        List<Car> cars = reader.ReadAllCars();
        assertEquals(0, cars.size());
    }

    @Test
    public void testMalformedRow() {
        CarReader reader = new FileCarReader(new File("./io/malformed-row.csv"));
        assertThrows(IllegalArgumentException.class, () -> reader.ReadAllCars());
    }
}
