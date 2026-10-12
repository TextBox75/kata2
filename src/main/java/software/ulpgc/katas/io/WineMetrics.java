package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Wine;

import java.util.List;

import static software.ulpgc.katas.model.WineQuality.Legit;

public class WineMetrics {

    private final List<Wine> Wines;

    public WineMetrics(List<Wine> Wines) {
        this.Wines = Wines;
    }

    public int countLegit() {
        int legit = 0;
        for (Wine Wine : Wines) {
            if (Wine.quality() == Legit) {
                legit++;
            }
        }
        return legit;
    }
}