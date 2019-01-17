package project.parking_app.data.vehicleComponent;

import project.parking_app.data.utils.VehicleType;

public class VehicleFactory {
    public Vehicle getVehicle(VehicleType vehicleType, String numberPlate) {
        switch (vehicleType) {
            case BUS:
                return new Bus(numberPlate);
            case CAR:
                return new Car(numberPlate);
            case MOTORCYCLE:
                return new Motorcycle(numberPlate);
            default:
                return null;
        }
    }
}
