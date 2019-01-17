package project.parking_app.screens.actionScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import project.parking_app.R;
import project.parking_app.screens.leaveVehicleScreen.LeaveVehicleActivity;
import project.parking_app.screens.parkCarScreen.ParkVehicleActivity;

public class ActionActivity extends AppCompatActivity implements ActionActivityContract.View {

    private ActionActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        presenter = new ActionActivityPresenter(this);

        Button btnParkVehicle = findViewById(R.id.btn_park_vehicle);
        Button btnFreeSpot = findViewById(R.id.btn_free_spot);
        btnParkVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onParkCarBtnPressed();
            }
        });
        btnFreeSpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onFreeSpotBtnPressed();
            }
        });
    }

    @Override
    public void goToParkCarScreen() {

        Intent intent = new Intent(this, ParkVehicleActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToFreeSpotScreen() {
        Intent intent = new Intent(this, LeaveVehicleActivity.class);
        startActivity(intent);
    }
}
