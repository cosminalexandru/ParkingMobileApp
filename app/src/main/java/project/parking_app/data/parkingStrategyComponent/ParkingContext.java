package project.parking_app.data.parkingStrategyComponent;

import project.parking_app.data.vehicleComponent.Vehicle;

public class ParkingContext {
    private ParkingStrategy strategy;

    public void setParkingStrategy(ParkingStrategy strategy) {
        this.strategy = strategy;
    }

    public int parkVehicle(Vehicle vehicle) {
        return strategy.parkVehicle(vehicle);
    }
}
