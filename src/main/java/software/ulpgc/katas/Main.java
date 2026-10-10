package software.ulpgc.katas;

import software.ulpgc.katas.io.*;
import software.ulpgc.katas.model.Car;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static software.ulpgc.katas.model.Transmission.*;

public class Main {
    static void main() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/car.csv");
        CarReader reader = new URLCarReader(url);
        List<Car> cars = reader.ReadAllCars();

        int manuals = 0;
        for (Car car : cars) {
            if (car.transmissionType() == Manual) {
                manuals++;
            }
        }

        CarWriter writer = new ConsoleCarWriter(cars);
        CarWriter FileWriter = new FileCarWriter(cars);
        writer.WriteManuals(manuals);
        FileWriter.WriteManuals(manuals);
    }
}
