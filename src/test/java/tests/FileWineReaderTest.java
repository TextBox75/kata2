package tests;

import org.junit.jupiter.api.Test;
import software.ulpgc.katas.io.WineReader;
import software.ulpgc.katas.io.FileWineReader;
import software.ulpgc.katas.model.Wine;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileWineReaderTest {
    @Test
    public void testFileReader() {
        WineReader reader = new FileWineReader(new File("./io/wine_fraud.csv"));
        List<Wine> Wines = reader.ReadAllWines();
        assertEquals(6497, Wines.size());
    }

    @Test
    public void testFileReordered() {
        WineReader reader = new FileWineReader(new File("./io/wine-reordered.csv"));
        List<Wine> Wines = reader.ReadAllWines();
        assertEquals(6497, Wines.size());
    }

    @Test
    public void testFileNonExistant() {
        WineReader reader = new FileWineReader(new File("./io/non-existent-file.csv"));
        assertThrows(RuntimeException.class, () -> reader.ReadAllWines());
    }

    @Test
    public void testFileEmpty() {
        WineReader reader = new FileWineReader(new File("./io/empty-file.csv"));
        List<Wine> Wines = reader.ReadAllWines();
        assertEquals(0, Wines.size());
    }

    @Test
    public void testMalformedRow() {
        WineReader reader = new FileWineReader(new File("./io/wine-malformed-row.csv"));
        assertThrows(IllegalArgumentException.class, () -> reader.ReadAllWines());
    }
}