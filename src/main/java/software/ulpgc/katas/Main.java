package software.ulpgc.katas;

import software.ulpgc.katas.io.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    static void main() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/car.csv");
        CarReader reader = new URLCarReader(url);
        CarWriter writer = new ConsoleCarWriter(reader.ReadAllCars());
        CarWriter FileWriter = new FileCarWriter(reader.ReadAllCars());

        try {
            writer.Write();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        try {
            FileWriter.Write();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
