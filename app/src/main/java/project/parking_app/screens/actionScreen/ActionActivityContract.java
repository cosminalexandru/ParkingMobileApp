package project.parking_app.screens.actionScreen;

public interface ActionActivityContract {
    interface Presenter {
        void onParkCarBtnPressed();

        void onFreeSpotBtnPressed();
    }

    interface View {
        void goToParkCarScreen();

        void goToFreeSpotScreen();
    }
}
