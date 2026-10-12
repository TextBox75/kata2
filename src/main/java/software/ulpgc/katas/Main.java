package software.ulpgc.katas;

import software.ulpgc.katas.io.*;

import java.io.File;

public class Main {
    static void main() {
        WineReader reader = new FileWineReader(new File("./wine_fraud.csv"));
        WineMetrics metrics = new WineMetrics(reader.ReadAllWines());
        WineWriter writer = new ConsoleWineWriter();
        WineWriter fileWriter = new FileWineWriter();
        writer.WriteLine("legit: " + metrics.countLegit());
        fileWriter.WriteLine("legit: " + metrics.countLegit());
    }
}
