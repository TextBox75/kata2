package software.ulpgc.katas.io;

public class ConsolePassengerWriter implements  PassengerWriter {
    @Override
    public void WriteLine(String line) {
        System.out.println(line);
    }
}
