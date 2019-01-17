package project.parking_app.screens.leaveVehicleScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import project.parking_app.R;
import project.parking_app.screens.parkingLotScreen.ParkingLotActivity;

public class LeaveVehicleActivity extends AppCompatActivity implements LeaveVehicleContract.View {

    private EditText spotNumber;
    private Button btnFreeSpot, btnGoToParkingLot;
    private LeaveVehiclePresenter presenter;
    private ViewFlipper viewFlipper;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_vehicle);
        spotNumber = findViewById(R.id.et_plate_number);
        btnFreeSpot = findViewById(R.id.btn_free_spot);
        tvMessage = findViewById(R.id.tv_message);
        btnGoToParkingLot = findViewById(R.id.btn_go_to_parking);
        viewFlipper = findViewById(R.id.viewFlipperLeave);
        presenter = new LeaveVehiclePresenter(this);

        btnGoToParkingLot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onGoToParkingLotPressed();
            }
        });

        btnFreeSpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plateNumber = spotNumber.getText().toString();
                if (plateNumber.length() > 6)
                    presenter.onFreeSpotPressed(plateNumber);
                else
                    Toast.makeText(v.getContext(), "Invalid plate number", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void successfullClear() {

        tvMessage.setText("Success");
        viewFlipper.setDisplayedChild(1);
    }

    @Override
    public void invalidPlateNumber() {
        Toast.makeText(this, "This number doesn't exists in Register", Toast.LENGTH_LONG).show();
    }

    @Override
    public void goToParkingLot() {
        Intent intent = new Intent(this, ParkingLotActivity.class);
        startActivity(intent);
    }
}
