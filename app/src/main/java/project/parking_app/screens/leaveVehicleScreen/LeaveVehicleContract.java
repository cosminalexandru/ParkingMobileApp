package project.parking_app.screens.leaveVehicleScreen;

public interface LeaveVehicleContract {
    interface View {
        void successfullClear();

        void invalidPlateNumber();

        void goToParkingLot();
    }

    interface Presenter {
        void onFreeSpotPressed(String plateNumber);

        void onGoToParkingLotPressed();
    }
}
