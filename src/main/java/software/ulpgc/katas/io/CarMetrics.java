package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Car;
import software.ulpgc.katas.model.Transmission;

import java.util.List;

public class CarMetrics {

    List<Car> cars;

    public CarMetrics(List<Car> cars) {
        this.cars = cars;
    }

    public int countManuals() {
        int manuals = 0;
        for (Car car: cars) {
            if (car.transmissionType() == Transmission.Manual) {
                manuals++;
            }
        }
        return manuals;
    }
}
