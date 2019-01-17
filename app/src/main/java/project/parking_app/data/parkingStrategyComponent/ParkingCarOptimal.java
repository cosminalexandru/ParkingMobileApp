package project.parking_app.data.parkingStrategyComponent;

import project.parking_app.data.parkingStrategyComponent.chainOfResponsibilityComponent.CompactSpotsParking;
import project.parking_app.data.parkingStrategyComponent.chainOfResponsibilityComponent.LargeSpotsParking;
import project.parking_app.data.parkingStrategyComponent.chainOfResponsibilityComponent.SmallSpotsParking;
import project.parking_app.data.vehicleComponent.Vehicle;

public class ParkingCarOptimal implements ParkingStrategy {
    @Override
    public int parkVehicle(Vehicle vehicle) {
        LargeSpotsParking tryLargeSpots = new LargeSpotsParking(null);
        CompactSpotsParking tryCompactSpots = new CompactSpotsParking(tryLargeSpots);
        SmallSpotsParking trySmallSpots = new SmallSpotsParking(tryCompactSpots);
        return trySmallSpots.parkVehicle(vehicle);
    }
}
