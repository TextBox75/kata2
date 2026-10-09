package software.ulpgc.katas;

import software.ulpgc.katas.io.CarReader;
import software.ulpgc.katas.io.FileCarReader;

import java.io.File;
import java.io.IOException;

public class Main {
    static void main() throws IOException {
        CarReader reader = new FileCarReader(new File("car.csv"));
        System.out.println(reader.ReadAllCars());
    }
}
