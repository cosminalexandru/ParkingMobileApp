package project.parking_app.data.vehicleComponent;

import java.util.ArrayList;

import project.parking_app.data.utils.SpotType;

public class Motorcycle implements Vehicle {
    private String numberPlate;
    private int parkingSpotNumber;

    Motorcycle(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(int parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    @Override
    public ArrayList<SpotType> parkingSpotNeeded() {
        ArrayList<SpotType> specificParkingLots = new ArrayList<>();
        specificParkingLots.add(SpotType.SMALL);
        specificParkingLots.add(SpotType.COMPACT);
        specificParkingLots.add(SpotType.LARGE);
        return specificParkingLots;
    }
}
