package project.parking_app.data.parkingStrategyComponent.chainOfResponsibilityComponent;

import project.parking_app.data.parkingLotComponent.Level;
import project.parking_app.data.parkingLotComponent.ParkingLot;
import project.parking_app.data.parkingLotComponent.Row;
import project.parking_app.data.parkingLotComponent.Spot;
import project.parking_app.data.utils.SpotType;
import project.parking_app.data.vehicleComponent.Motorcycle;
import project.parking_app.data.vehicleComponent.Vehicle;

public class SmallSpotsParking extends ParkingProcessing {

    public SmallSpotsParking(ParkingProcessing next) {
        super(next);
    }

    @Override
    public int parkVehicle(Vehicle vehicle) {
        if (vehicle instanceof Motorcycle) {
            ParkingLot parkingLot = ParkingLot.getInstance();
            for (Level level : parkingLot.getLevels()) {
                for (Row row : level.getRows()) {
                    if (row.getStatistics().get(SpotType.SMALL) > 0) {
                        for (Spot spot : row.getSpots()) {
                            if (spot.getType() == SpotType.SMALL && spot.getAvailability()) {
                                ((Motorcycle) vehicle).setParkingSpotNumber(spot.getSpotNumber());
                                spot.setAvailability(false);
                                row.getStatistics().put(spot.getType(), row.getStatistics().get(spot.getType()) - 1);
                                return spot.getSpotNumber();
                            }
                        }
                    }
                }
            }
        } else if (nextStep != null)
            return nextStep.parkVehicle(vehicle);
        return -1;
    }
}
