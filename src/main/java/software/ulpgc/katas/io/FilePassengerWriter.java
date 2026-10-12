package software.ulpgc.katas.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FilePassengerWriter implements PassengerWriter {

    private final String fileName;

    public FilePassengerWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void WriteLine(String line) {
        try {
            FileOutputStream fos = new FileOutputStream(this.fileName);
            fos.write(line.getBytes());
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}