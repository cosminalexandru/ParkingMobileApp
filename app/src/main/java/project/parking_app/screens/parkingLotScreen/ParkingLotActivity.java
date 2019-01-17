package project.parking_app.screens.parkingLotScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import project.parking_app.R;
import project.parking_app.data.parkingLotComponent.Level;
import project.parking_app.data.parkingLotComponent.ParkingLot;
import project.parking_app.data.parkingLotComponent.Row;
import project.parking_app.screens.actionScreen.ActionActivity;

public class ParkingLotActivity extends AppCompatActivity implements ParkingActivityContract.View {

    private FloatingActionButton fab;
    private ParkingActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_lot);
        fab = findViewById(R.id.fab);
        RecyclerView recyclerView = findViewById(R.id.rv);
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.createParking();
        List<Object> recyclerViewList = new ArrayList<>();
        List<Level> list = parkingLot.getLevels();
        for (Level level : list) {
            recyclerViewList.add(level);
            for (Row row : level.getRows())
                recyclerViewList.add(row);
        }

        presenter = new ParkingLotPresenter(this);
        ParkingLotAdapter adapter = new ParkingLotAdapter(recyclerViewList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && fab.getVisibility() == View.VISIBLE) {
                    fab.hide();
                } else if (dy < 0 && fab.getVisibility() != View.VISIBLE) {
                    fab.show();
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onFabClick();
            }
        });

    }


    @Override
    public void goToActionScreen() {
        Intent intent = new Intent(this, ActionActivity.class);
        startActivity(intent);
    }
}
