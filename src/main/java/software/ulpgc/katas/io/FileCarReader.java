package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Car;
import software.ulpgc.katas.model.Fuel;
import software.ulpgc.katas.model.Transmission;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCarReader implements CarReader {

    private final File carFile;

    public FileCarReader(File carFile) {
        this.carFile = carFile;
    }

    @Override
    public List<Car> ReadAllCars() throws IOException {
        try (FileInputStream is = new FileInputStream(carFile)) {
            List<Car> cars = ReadLines(is);
            is.close();
            return cars;
        }
    }

    private List<Car> ReadLines(FileInputStream stream) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(stream)) {
            return ReadLines(new BufferedReader(isr));
        }
    }

    private List<Car> ReadLines(Reader reader) throws IOException {
        return ReadLines(reader.readAllLines());
    }

    private List<Car> ReadLines(List<String> lines) {
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            cars.add(ReadLines(lines.get(i)));
        }

        return cars;
    }

    private Car ReadLines(String line) {
        return ReadLines(line.split(","));
    }

    private Car ReadLines(String[] fields) {
        return new Car(
                fields[0],
                Integer.parseInt(fields[1]),
                Integer.parseInt(fields[4]),
                FuelOf(fields[5]),
                TransmissionOf(fields[7])
        );
    }

    private Transmission TransmissionOf(String transmissionType) {
        return Transmission.valueOf(transmissionType);
    }

    private Fuel FuelOf(String fuelType) {
        return Fuel.valueOf(fuelType);
    }
}