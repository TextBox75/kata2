package software.ulpgc.katas;

import software.ulpgc.katas.io.*;
import software.ulpgc.katas.model.Passenger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {
    static void main() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/Titanic.csv");
        PassengerReader urlReader = new URLPassengerReader(url);
        PassengerReader fileReader = new FilePassengerReader(new File("./Titanic.csv"));

        List<Passenger> urlPassengers = urlReader.ReadAllPassengers();
        List<Passenger> filePassengers = fileReader.ReadAllPassengers();

        PassengerMetrics urlMetrics = new PassengerMetrics(urlPassengers);
        PassengerMetrics fileMetrics = new PassengerMetrics(filePassengers);

        PassengerWriter urlConsoleWriter = new ConsolePassengerWriter();
        PassengerWriter urlFileWriter = new FilePassengerWriter("./url-passenger-output.txt");

        PassengerWriter fileConsoleWriter = new ConsolePassengerWriter();
        PassengerWriter fileFileWriter = new FilePassengerWriter("./file-passenger-output.txt");

        int urlSurvived = urlMetrics.countSurvivedPassengers();
        int fileSurvived = fileMetrics.countSurvivedPassengers();

        urlConsoleWriter.WriteLine(urlSurvived + " Survived");
        fileConsoleWriter.WriteLine(fileSurvived + " Survived");

        urlFileWriter.WriteLine(urlSurvived + " Survived");
        fileFileWriter.WriteLine(fileSurvived + " Survived");
    }
}