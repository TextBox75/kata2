package tests;

import org.junit.jupiter.api.Test;
import software.ulpgc.katas.io.PassengerReader;
import software.ulpgc.katas.io.URLPassengerReader;
import software.ulpgc.katas.model.Passenger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class URLPassengerReaderTest {
    @Test
    public void testURLReader() throws MalformedURLException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/Titanic.csv");
        PassengerReader reader = new URLPassengerReader(url);
        List<Passenger> Passengers = reader.ReadAllPassengers();
        assertEquals(1313, Passengers.size());
    }

    @Test
    public void testInvalidURL() throws MalformedURLException {
        assertThrows(MalformedURLException.class, () -> new URL("nonexistanturl.com"));
    }
}
