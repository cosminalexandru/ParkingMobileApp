package project.parking_app.data.parkingStrategyComponent;

import project.parking_app.data.parkingLotComponent.Level;
import project.parking_app.data.parkingLotComponent.ParkingLot;
import project.parking_app.data.parkingLotComponent.Row;
import project.parking_app.data.parkingLotComponent.Spot;
import project.parking_app.data.utils.SpotType;
import project.parking_app.data.vehicleComponent.Bus;
import project.parking_app.data.vehicleComponent.Car;
import project.parking_app.data.vehicleComponent.Motorcycle;
import project.parking_app.data.vehicleComponent.Vehicle;

public class ParkingCarCompact implements ParkingStrategy {
    @Override
    public int parkVehicle(Vehicle vehicle) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        for (Level level : parkingLot.getLevels())
            for (Row row : level.getRows())
                for (Spot spot : row.getSpots()) {
                    if (vehicle.parkingSpotNeeded().contains(spot.getType()) && spot.getAvailability()) {
                        if (vehicle instanceof Car) {
                            ((Car) vehicle).setParkingSpotNumber(spot.getSpotNumber());
                            spot.setAvailability(false);
                            row.getStatistics().put(spot.getType(), row.getStatistics().get(spot.getType()) - 1);
                            return spot.getSpotNumber();
                        } else if (vehicle instanceof Motorcycle) {
                            ((Motorcycle) vehicle).setParkingSpotNumber(spot.getSpotNumber());
                            spot.setAvailability(false);
                            row.getStatistics().put(spot.getType(), row.getStatistics().get(spot.getType()) - 1);
                            break;
                        } else if (vehicle instanceof Bus) {
                            if (row.getStatistics().get(SpotType.LARGE) >= 5) {
                                ((Bus) vehicle).setParkingSpotNumber(spot.getSpotNumber());
                                spot.setAvailability(false);
                                row.getStatistics().put(spot.getType(), row.getStatistics().get(spot.getType()) - 1);
                                return spot.getSpotNumber();
                            }
                        }
                    }
                }
        return -1;
    }
}

