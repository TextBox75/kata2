package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Car;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FileCarWriter implements CarWriter {

    private final List<Car> cars;

    public FileCarWriter(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void WriteManuals(int manuals) {
        try {
            FileOutputStream fos = new FileOutputStream("./car-output.txt");
            fos.write("Manual cars read: ".getBytes());
            fos.write(String.valueOf(manuals).getBytes());
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
