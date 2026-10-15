package tests;

import org.junit.jupiter.api.Test;
import software.ulpgc.katas.io.*;
import software.ulpgc.katas.model.Passenger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FilePassengerWriterTest {
    @Test
    public void testFile() throws IOException {
        PassengerReader reader = new FilePassengerReader(new File("./io/Titanic.csv"));
        List<Passenger> Passengers = reader.ReadAllPassengers();

        PassengerMetrics metrics = new PassengerMetrics(Passengers);
        int survived = metrics.countSurvivedPassengers();

        PassengerWriter writer = new FilePassengerWriter("./io/Passenger-output.txt");
        writer.WriteLine("Survived " + survived);
        assertTrue(Files.exists(Path.of("./io/Passenger-output.txt")));

        assertArrayEquals("Survived 450".getBytes(), Files.readAllBytes(Path.of("./io/Passenger-output.txt")));
    }

    @Test
    public void testURL() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/Titanic.csv");
        PassengerReader reader = new URLPassengerReader(url);
        List<Passenger> Passengers = reader.ReadAllPassengers();

        PassengerMetrics metrics = new PassengerMetrics(Passengers);
        int survived = metrics.countSurvivedPassengers();

        PassengerWriter writer = new FilePassengerWriter("./io/Passenger-output.txt");
        writer.WriteLine("Survived " + survived);
        assertTrue(Files.exists(Path.of("./io/Passenger-output.txt")));

        assertArrayEquals("Survived 450".getBytes(), Files.readAllBytes(Path.of("./io/Passenger-output.txt")));
    }
}