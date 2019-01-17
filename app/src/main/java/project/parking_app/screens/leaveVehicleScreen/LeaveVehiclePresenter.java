package project.parking_app.screens.leaveVehicleScreen;

import java.util.HashMap;

import project.parking_app.data.parkingLotComponent.Level;
import project.parking_app.data.parkingLotComponent.ParkingLot;
import project.parking_app.data.parkingLotComponent.Row;
import project.parking_app.data.parkingLotComponent.Spot;
import project.parking_app.data.utils.SpotType;

public class LeaveVehiclePresenter implements LeaveVehicleContract.Presenter {
    private LeaveVehicleContract.View view;

    LeaveVehiclePresenter(LeaveVehicleContract.View view) {
        this.view = view;
    }

    @Override
    public void onFreeSpotPressed(String plateNumber) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        if (parkingLot.getRegister().containsKey(plateNumber)) {
            for (Level level : parkingLot.getLevels())
                for (Row row : level.getRows())
                    for (Spot spot : row.getSpots()) {
                        if (spot.getSpotNumber().equals(parkingLot.getRegister().get(plateNumber))) {
                            spot.setAvailability(true);
                            HashMap<SpotType, Integer> statistics = row.getStatistics();
                            switch (spot.getType()) {
                                case COMPACT:
                                    statistics.put(SpotType.COMPACT, statistics.get(SpotType.COMPACT) + 1);
                                    break;
                                case LARGE:
                                    statistics.put(SpotType.LARGE, statistics.get(SpotType.LARGE) + 1);
                                    break;
                                case SMALL:
                                    statistics.put(SpotType.SMALL, statistics.get(SpotType.SMALL) + 1);
                                    break;
                                default:
                                    break;
                            }


                        }
                    }

            HashMap<String, Integer> register = parkingLot.getRegister();
            register.remove(plateNumber);
            parkingLot.setRegister(register);
            view.successfullClear();
        } else
            view.invalidPlateNumber();

    }

    @Override
    public void onGoToParkingLotPressed() {
        view.goToParkingLot();
    }
}
