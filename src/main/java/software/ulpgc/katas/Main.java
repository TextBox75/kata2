package software.ulpgc.katas;

import software.ulpgc.katas.io.FileWineReader;
import software.ulpgc.katas.io.WineReader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {
    static void main() {
        WineReader reader = new FileWineReader(new File("./wine_fraud.csv"));
        reader.ReadAllWines();
    }
}
