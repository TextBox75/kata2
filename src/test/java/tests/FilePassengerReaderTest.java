package tests;

import org.junit.jupiter.api.Test;
import software.ulpgc.katas.io.PassengerReader;
import software.ulpgc.katas.io.FilePassengerReader;
import software.ulpgc.katas.model.Passenger;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilePassengerReaderTest {
    @Test
    public void testFileReader() {
        PassengerReader reader = new FilePassengerReader(new File("./io/Titanic.csv"));
        List<Passenger> Passengers = reader.ReadAllPassengers();
        assertEquals(1313, Passengers.size());
    }

    @Test
    public void testFileReordered() {
        PassengerReader reader = new FilePassengerReader(new File("./io/Titanic-reordered.csv"));
        List<Passenger> Passengers = reader.ReadAllPassengers();
        assertEquals(1313, Passengers.size());
    }

    @Test
    public void testFileNonExistant() {
        PassengerReader reader = new FilePassengerReader(new File("./io/non-existent-file.csv"));
        assertThrows(RuntimeException.class, () -> reader.ReadAllPassengers());
    }

    @Test
    public void testFileEmpty() {
        PassengerReader reader = new FilePassengerReader(new File("./io/empty-file.csv"));
        List<Passenger> Passengers = reader.ReadAllPassengers();
        assertEquals(0, Passengers.size());
    }

    @Test
    public void testMalformedRow() {
        PassengerReader reader = new FilePassengerReader(new File("./io/Titanic-malformed-row.csv"));
        assertThrows(IllegalArgumentException.class, () -> reader.ReadAllPassengers());
    }
}