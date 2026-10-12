package software.ulpgc.katas.io;

public class ConsoleWineWriter implements WineWriter {
    @Override
    public void WriteLine(String line) {
        System.out.println(line);
    }
}