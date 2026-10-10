package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Passenger;

import java.util.List;

public class PassengerMetrics {

    List<Passenger> Passengers;

    public PassengerMetrics(List<Passenger> Passengers) {
        this.Passengers = Passengers;
    }

    public int countSurvivedPassengers() {
        int count = 0;
        for (Passenger passenger : Passengers) {
            if (passenger.survived() == 1) {
                count++;
            }
        }
        return count;
    }
}
