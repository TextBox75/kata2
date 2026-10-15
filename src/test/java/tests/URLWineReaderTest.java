package tests;

import org.junit.jupiter.api.Test;
import software.ulpgc.katas.io.WineReader;
import software.ulpgc.katas.io.URLWineReader;
import software.ulpgc.katas.model.Wine;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class URLWineReaderTest {
    @Test
    public void testURLReader() throws MalformedURLException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/wine_fraud.csv");
        WineReader reader = new URLWineReader(url);
        List<Wine> Wines = reader.ReadAllWines();
        assertEquals(6497, Wines.size());
    }

    @Test
    public void testInvalidURL() throws MalformedURLException {
        assertThrows(MalformedURLException.class, () -> new URL("nonexistanturl.com"));
    }
}