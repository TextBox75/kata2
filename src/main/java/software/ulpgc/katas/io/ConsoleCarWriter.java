package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Car;

import java.util.List;

public class ConsoleCarWriter implements CarWriter {
    @Override
    public void WriteLine(String line) {
        System.out.println(line);
    }
}
