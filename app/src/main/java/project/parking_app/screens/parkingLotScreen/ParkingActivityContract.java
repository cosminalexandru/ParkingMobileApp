package project.parking_app.screens.parkingLotScreen;

public interface ParkingActivityContract {

    interface View {
        void goToActionScreen();
    }

    interface Presenter {
        void onFabClick();
    }
}
