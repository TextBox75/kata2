package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Car;

import java.io.PrintWriter;
import java.util.List;

public class ConsoleCarWriter implements CarWriter {

    private final List<Car> cars;

    public ConsoleCarWriter(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void Write() {
        for (Car car : this.cars) {
            PrintCar(car);
        }
    }

    private void PrintCar(Car car) {
        System.out.println("name: " + car.name());
        System.out.println("year: " + car.year());
        System.out.println("kilometers: " + car.kilometers());
        System.out.println("fuel type: " + car.fuelType());
        System.out.println("transmission type: " + car.transmissionType());
        System.out.println("----------------------------");
    }
}
