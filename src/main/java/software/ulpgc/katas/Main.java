package software.ulpgc.katas;

import software.ulpgc.katas.io.*;
import software.ulpgc.katas.model.Car;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {
    static void main() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/car.csv");
        CarReader reader = new URLCarReader(url);
        List<Car> cars = reader.ReadAllCars();

        CarMetrics metrics = new CarMetrics(cars);
        CarWriter writer = new ConsoleCarWriter();
        CarWriter FileWriter = new FileCarWriter();

        int manuals = metrics.countManuals();
        writer.WriteLine("Manual cars: " + manuals);
        FileWriter.WriteLine("Manual cars: " + manuals);
    }
}
