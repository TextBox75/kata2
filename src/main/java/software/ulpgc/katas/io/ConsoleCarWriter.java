package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Car;

import java.util.List;

public class ConsoleCarWriter implements CarWriter {

    private final List<Car> cars;

    public ConsoleCarWriter(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void WriteManuals(int manuals) {
        System.out.println("Manual cars read: " + manuals);
    }
}
