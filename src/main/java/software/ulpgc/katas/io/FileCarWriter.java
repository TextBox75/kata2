package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Car;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class FileCarWriter implements CarWriter {

    private final List<Car> cars;

    public FileCarWriter(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void Write() {
        try {
            FileOutputStream fos = new FileOutputStream("./car-output.txt");
            for (Car car : cars) {
                WriteCar(fos, car);
            }
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void WriteCar(FileOutputStream fos, Car car) throws IOException, IllegalAccessException {
        for (Field field : car.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            WriteCar(fos, field.get(car));
        }
        fos.write('\n');
    }

    private void WriteCar(FileOutputStream fos, Object field) throws IOException {
        fos.write(field.toString().getBytes());
        fos.write(' ');
    }
}
