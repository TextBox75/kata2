package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Car;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.List;

public class ConsoleCarWriter implements CarWriter {

    private final List<Car> cars;

    public ConsoleCarWriter(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void Write() {
        for (Car car : this.cars) {
            try {
                PrintCar(car);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void PrintCar(Car car) throws IllegalAccessException {
        for (Field field : car.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            PrintCar(field.get(car));
        }
        System.out.print('\n');
    }

    private void PrintCar(Object field) {
        System.out.print(field.toString());
        System.out.print(' ');
    }
}
