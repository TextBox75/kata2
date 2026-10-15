package tests;

import org.junit.jupiter.api.Test;
import software.ulpgc.katas.io.*;
import software.ulpgc.katas.model.Passenger;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsolePassengerWriterTest {
    @Test
    public void testFile(){
        PassengerReader reader = new FilePassengerReader(new File("./io/Titanic.csv"));
        List<Passenger> Passengers = reader.ReadAllPassengers();

        PassengerMetrics metrics = new PassengerMetrics(Passengers);
        int survived = metrics.countSurvivedPassengers();

        PassengerWriter writer = new ConsolePassengerWriter();
        writer.WriteLine("Survived " +  survived);
        assertEquals(450, survived);
    }

    @Test
    public void testURL() throws MalformedURLException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/Titanic.csv");
        PassengerReader reader = new URLPassengerReader(url);
        List<Passenger> Passengers = reader.ReadAllPassengers();

        PassengerMetrics metrics = new PassengerMetrics(Passengers);
        int survived = metrics.countSurvivedPassengers();

        PassengerWriter writer = new ConsolePassengerWriter();
        writer.WriteLine("Survived " + survived);
        assertEquals(450, survived);
    }
}