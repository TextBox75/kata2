package software.ulpgc.katas.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWineWriter implements WineWriter {
    @Override
    public void WriteLine(String line) {
        try {
            FileOutputStream fos = new FileOutputStream("./wine-output.txt");
            fos.write(line.getBytes());
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}