package project.parking_app.data.parkingStrategyComponent.chainOfResponsibilityComponent;

import project.parking_app.data.vehicleComponent.Vehicle;

public abstract class ParkingProcessing {
    ParkingProcessing nextStep;

    ParkingProcessing(ParkingProcessing nextStep) {
        this.nextStep = nextStep;
    }

    public abstract int parkVehicle(Vehicle vehicle);
}
