package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Car;

import java.io.IOException;
import java.util.List;

public interface CarReader {
    List<Car> ReadAllCars() throws IOException;
}
