package project.parking_app.screens.parkCarScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import project.parking_app.R;
import project.parking_app.data.utils.VehicleType;
import project.parking_app.screens.parkingLotScreen.ParkingLotActivity;

public class ParkVehicleActivity extends AppCompatActivity implements ParkVehicleContract.View {

    private ImageButton imgbtnCar, imgbtnMoto, imgbtnBus;
    private TextView tvNumberPlate, tvSpotNumber, tvLevel;
    private ImageView imageViewVehicleType;
    private ViewFlipper viewFlipper;
    private VehicleType vehicleType = VehicleType.CAR;
    private ParkVehiclePresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_vehicle);
        imgbtnCar = findViewById(R.id.car);
        imgbtnBus = findViewById(R.id.bus);
        imgbtnMoto = findViewById(R.id.moto);
        Button btnPark = findViewById(R.id.btn_park);
        tvNumberPlate = findViewById(R.id.number_plate);
        tvSpotNumber = findViewById(R.id.tv_spot_number);
        tvLevel = findViewById(R.id.tv_level_number);
        imageViewVehicleType = findViewById(R.id.iv_vehicle);
        viewFlipper = findViewById(R.id.viewFlipper);
        Button btnGoToParkingLot = findViewById(R.id.btn_go_to_parking);

        presenter = new ParkVehiclePresenter(this);

        imgbtnMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.selectMotoPressed();
            }
        });

        imgbtnBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.selectBusPressed();
            }
        });

        imgbtnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.selectCarPressed();
            }
        });

        btnPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberPlate = tvNumberPlate.getText().toString();
                if (numberPlate.length() > 6)
                    presenter.parkPressed(numberPlate, vehicleType);
                else
                    Toast.makeText(v.getContext(), "Invalid plate number", Toast.LENGTH_LONG).show();
            }
        });

        btnGoToParkingLot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ParkingLotActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void selectBus() {
        vehicleType = VehicleType.BUS;
        imgbtnBus.setImageResource(R.drawable.bus_black);
        imgbtnCar.setImageResource(R.drawable.car_white);
        imgbtnMoto.setImageResource(R.drawable.moto_white);
    }

    @Override
    public void selectCar() {
        vehicleType = VehicleType.CAR;
        imgbtnBus.setImageResource(R.drawable.bus_white);
        imgbtnCar.setImageResource(R.drawable.car_black);
        imgbtnMoto.setImageResource(R.drawable.moto_white);
    }

    @Override
    public void selectMoto() {
        vehicleType = VehicleType.MOTORCYCLE;
        imgbtnBus.setImageResource(R.drawable.bus_white);
        imgbtnCar.setImageResource(R.drawable.car_white);
        imgbtnMoto.setImageResource(R.drawable.moto_black);
    }

    @Override
    public void parkCar(int parkResult, VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                imageViewVehicleType.setImageResource(R.drawable.car_black);
                break;
            case BUS:
                imageViewVehicleType.setImageResource(R.drawable.bus_black);
                break;
            case MOTORCYCLE:
                imageViewVehicleType.setImageResource(R.drawable.moto_black);
                break;
            default:
                break;

        }

        if (parkResult != -1) {
            int level = -1;
            if (parkResult >= 1 && parkResult <= 112)
                level = 0;
            else if (parkResult >= 113 && parkResult <= 224)
                level = 1;
            else if (parkResult >= 225 && parkResult <= 336)
                level = 2;
            else if (parkResult >= 337 && parkResult <= 448)
                level = 3;

            while (parkResult > 112)
                parkResult -= 112;
            tvSpotNumber.setText("Spot: " + Integer.toString(parkResult));
            tvLevel.setText("Level: " + Integer.toString(level));
        } else {
            tvLevel.setText("No available spots!");
            tvSpotNumber.setText("");
        }

        viewFlipper.setDisplayedChild(1);

    }

    @Override
    public void alreadyExists() {
        Toast.makeText(this, "Already exists", Toast.LENGTH_LONG).show();

    }
}