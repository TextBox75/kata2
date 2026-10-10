package software.ulpgc.katas;

import software.ulpgc.katas.io.*;
import software.ulpgc.katas.model.Passenger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {
    static void main() {
        PassengerReader reader = new FilePassengerReader(new File("./Titanic.csv"));
        List<Passenger> passengers = reader.ReadAllPassengers();

        PassengerMetrics metrics = new PassengerMetrics(passengers);
        int survived = metrics.countSurvivedPassengers();

        ConsolePassengerWriter consoleWriter = new ConsolePassengerWriter();
        FilePassengerWriter fileWriter = new FilePassengerWriter();
        consoleWriter.WriteLine("Survived: " + survived);
        fileWriter.WriteLine("Survived: " + survived);
    }
}
