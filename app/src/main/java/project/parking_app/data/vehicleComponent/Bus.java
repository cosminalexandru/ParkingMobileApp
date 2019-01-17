package project.parking_app.data.vehicleComponent;

import java.util.ArrayList;

import project.parking_app.data.utils.SpotType;

public class Bus implements Vehicle {
    private String numberPlate;
    private int parkingSpotNumber;

    Bus(String numberPlate) {
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
        specificParkingLots.add(SpotType.LARGE);
        return specificParkingLots;
    }
}
