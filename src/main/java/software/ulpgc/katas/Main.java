package software.ulpgc.katas;

import software.ulpgc.katas.io.*;
import software.ulpgc.katas.model.Passenger;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {
    static void main() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/Passenger .csv");
        PassengerReader reader = new URLPassengerReader(url);
        List<Passenger> Passengers = reader.ReadAllPassengers();

        PassengerMetrics metrics = new PassengerMetrics(Passengers);
        PassengerWriter writer = new ConsolePassengerWriter();
        PassengerWriter FileWriter = new FilePassengerWriter();

        int survived = metrics.countSurvivedPassengers();
        writer.WriteLine("survived passengers: " + survived);
        FileWriter.WriteLine("survived passengers: " + survived);
    }
}