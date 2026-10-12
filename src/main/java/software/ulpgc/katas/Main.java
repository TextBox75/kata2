package software.ulpgc.katas;

import software.ulpgc.katas.io.*;
import software.ulpgc.katas.model.Wine;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {
    static void main() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/wine_fraud.csv");
        WineReader urlReader = new URLWineReader(url);
        WineReader fileReader = new FileWineReader(new File("./wine_fraud.csv"));

        List<Wine> urlWines = urlReader.ReadAllWines();
        List<Wine> fileWines = fileReader.ReadAllWines();

        WineMetrics urlMetrics = new WineMetrics(urlWines);
        WineMetrics fileMetrics = new WineMetrics(fileWines);

        WineWriter urlConsoleWriter = new ConsoleWineWriter();
        WineWriter urlFileWriter = new FileWineWriter("./url-wine-output.txt");

        WineWriter fileConsoleWriter = new ConsoleWineWriter();
        WineWriter fileFileWriter = new FileWineWriter("./file-wine-output.txt");

        int urlLegit = urlMetrics.countLegit();
        int fileLegit = fileMetrics.countLegit();

        urlConsoleWriter.WriteLine(urlLegit + " Legit");
        fileConsoleWriter.WriteLine(fileLegit + " Legit");

        urlFileWriter.WriteLine(urlLegit + " Legit");
        fileFileWriter.WriteLine(fileLegit + " Legit");
    }
}