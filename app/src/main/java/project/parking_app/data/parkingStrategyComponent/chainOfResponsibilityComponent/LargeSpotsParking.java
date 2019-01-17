package project.parking_app.data.parkingStrategyComponent.chainOfResponsibilityComponent;

import project.parking_app.data.parkingLotComponent.Level;
import project.parking_app.data.parkingLotComponent.ParkingLot;
import project.parking_app.data.parkingLotComponent.Row;
import project.parking_app.data.parkingLotComponent.Spot;
import project.parking_app.data.utils.SpotType;
import project.parking_app.data.vehicleComponent.Bus;
import project.parking_app.data.vehicleComponent.Car;
import project.parking_app.data.vehicleComponent.Motorcycle;
import project.parking_app.data.vehicleComponent.Vehicle;

public class LargeSpotsParking extends ParkingProcessing {

    public LargeSpotsParking(ParkingProcessing next) {
        super(next);
    }

    @Override
    public int parkVehicle(Vehicle vehicle) {
        if (vehicle instanceof Motorcycle || vehicle instanceof Car) {
            ParkingLot parkingLot = ParkingLot.getInstance();
            for (Level level : parkingLot.getLevels()) {
                for (Row row : level.getRows()) {
                    if (row.getStatistics().get(SpotType.LARGE) > 0) {
                        for (Spot spot : row.getSpots()) {
                            if (spot.getType() == SpotType.LARGE && spot.getAvailability()) {
                                if (vehicle instanceof Motorcycle)
                                    ((Motorcycle) vehicle).setParkingSpotNumber(spot.getSpotNumber());
                                else
                                    ((Car) vehicle).setParkingSpotNumber(spot.getSpotNumber());
                                spot.setAvailability(false);
                                row.getStatistics().put(spot.getType(), row.getStatistics().get(spot.getType()) - 1);
                                return spot.getSpotNumber();
                            }
                        }
                    }
                }
            }
        } else if (vehicle instanceof Bus) {
            ParkingLot parkingLot = ParkingLot.getInstance();
            for (Level level : parkingLot.getLevels()) {
                int largeSpotsAvailableOnFirstRow = level.getRows().get(0).getStatistics().get(SpotType.LARGE);
                if (largeSpotsAvailableOnFirstRow >= 5) {
                    for (Spot spot : level.getRows().get(0).getSpots()) {
                        if (spot.getAvailability() && spot.getType() == vehicle.parkingSpotNeeded().get(0)) {
                            ((Bus) vehicle).setParkingSpotNumber(spot.getSpotNumber());
                            spot.setAvailability(false);
                            level.getRows().get(0).getStatistics().put(spot.getType(),
                                    largeSpotsAvailableOnFirstRow - 1);
                            return spot.getSpotNumber();
                        }
                    }
                }

                int largeSpotsAvailableOnLastRow = level.getRows().get(5).getStatistics().get(SpotType.LARGE);
                if (largeSpotsAvailableOnLastRow >= 5) {
                    for (Spot spot : level.getRows().get(5).getSpots()) {
                        if (spot.getAvailability() && spot.getType() == vehicle.parkingSpotNeeded().get(0)) {
                            ((Bus) vehicle).setParkingSpotNumber(spot.getSpotNumber());
                            spot.setAvailability(false);
                            level.getRows().get(5).getStatistics().put(spot.getType(),
                                    largeSpotsAvailableOnLastRow - 1);
                            return spot.getSpotNumber();
                        }
                    }
                }
            }
        } else if (nextStep != null)
            return nextStep.parkVehicle(vehicle);
        return -1;
    }
}
