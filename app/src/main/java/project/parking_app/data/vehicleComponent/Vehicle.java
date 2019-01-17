package project.parking_app.data.vehicleComponent;

import java.util.ArrayList;

import project.parking_app.data.utils.SpotType;

public interface Vehicle {
    ArrayList<SpotType> parkingSpotNeeded();
}
