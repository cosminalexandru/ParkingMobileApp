package project.parking_app.screens.parkingLotScreen;

public class ParkingLotPresenter implements ParkingActivityContract.Presenter {
    private ParkingActivityContract.View view;

    ParkingLotPresenter(ParkingActivityContract.View view) {
        this.view = view;

    }

    @Override
    public void onFabClick() {
        view.goToActionScreen();
    }
}
