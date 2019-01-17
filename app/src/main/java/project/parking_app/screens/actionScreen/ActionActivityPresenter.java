package project.parking_app.screens.actionScreen;

public class ActionActivityPresenter implements ActionActivityContract.Presenter {
    private ActionActivityContract.View view;

    ActionActivityPresenter(ActionActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void onParkCarBtnPressed() {
        view.goToParkCarScreen();
    }

    @Override
    public void onFreeSpotBtnPressed() {
        view.goToFreeSpotScreen();
    }
}
