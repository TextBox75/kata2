package software.ulpgc.katas;

import software.ulpgc.katas.io.FileWineReader;
import software.ulpgc.katas.io.FileWineWriter;
import software.ulpgc.katas.io.WineReader;
import software.ulpgc.katas.io.WineWriter;

import java.io.File;
import java.util.Objects;

public class Main {
    static void main() {
        WineReader reader = new FileWineReader(new File("./wine_fraud.csv"));
        reader.ReadAllWines();
    }
}
