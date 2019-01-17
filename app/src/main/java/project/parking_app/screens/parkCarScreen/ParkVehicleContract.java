package project.parking_app.screens.parkCarScreen;

import project.parking_app.data.utils.VehicleType;

public interface ParkVehicleContract {
    interface View {
        void selectBus();

        void selectCar();

        void selectMoto();

        void parkCar(int parkResult, VehicleType vehicleType);

        void alreadyExists();
    }

    interface Presenter {
        void selectBusPressed();

        void selectMotoPressed();

        void selectCarPressed();

        void parkPressed(String numberPlate, VehicleType vehicleType);
    }
}
