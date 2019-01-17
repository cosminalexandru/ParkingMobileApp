package project.parking_app.screens.parkCarScreen;

import java.util.HashMap;

import project.parking_app.data.parkingLotComponent.ParkingLot;
import project.parking_app.data.parkingStrategyComponent.ParkingCarCompact;
import project.parking_app.data.parkingStrategyComponent.ParkingCarOptimal;
import project.parking_app.data.parkingStrategyComponent.ParkingContext;
import project.parking_app.data.utils.DateHelper;
import project.parking_app.data.utils.VehicleType;
import project.parking_app.data.vehicleComponent.Vehicle;
import project.parking_app.data.vehicleComponent.VehicleFactory;

public class ParkVehiclePresenter implements ParkVehicleContract.Presenter {
    private ParkVehicleContract.View view;

    public ParkVehiclePresenter(ParkVehicleContract.View view) {
        this.view = view;
    }

    @Override
    public void selectBusPressed() {
        view.selectBus();
    }

    @Override
    public void selectMotoPressed() {
        view.selectMoto();
    }

    @Override
    public void selectCarPressed() {
        view.selectCar();
    }

    @Override
    public void parkPressed(String numberPlate, VehicleType vehicleType) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        if (parkingLot.getRegister().containsKey(numberPlate))
            view.alreadyExists();
        else {
            VehicleFactory vehicleFactory = new VehicleFactory();
            ParkingContext parkingContext = new ParkingContext();
            if (DateHelper.isItBusyPeriod())
                parkingContext.setParkingStrategy(new ParkingCarOptimal());
            else
                parkingContext.setParkingStrategy(new ParkingCarCompact());
            Vehicle vehicle = vehicleFactory.getVehicle(vehicleType, numberPlate);
            int spotNumber = parkingContext.parkVehicle(vehicle);
            if (spotNumber != -1) {
                HashMap<String, Integer> register = parkingLot.getRegister();
                register.put(numberPlate, spotNumber);
                parkingLot.setRegister(register);
            }
            view.parkCar(spotNumber, vehicleType);
        }

    }
}
