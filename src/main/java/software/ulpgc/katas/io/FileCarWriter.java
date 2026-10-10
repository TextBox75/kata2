package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Car;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FileCarWriter implements CarWriter {
    @Override
    public void WriteLine(String line) {
        try {
            FileOutputStream fos = new FileOutputStream("./car-output.txt");
            fos.write(line.getBytes());
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
