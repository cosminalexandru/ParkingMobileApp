package project.parking_app.data.parkingLotComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import project.parking_app.data.utils.RowType;
import project.parking_app.data.utils.SpotType;

public class ParkingLot {
    private static ParkingLot parkingLotInstance = null;
    private List<Level> levels;
    private HashMap<String, Integer> register;

    private ParkingLot() {
        this.levels = new ArrayList<>();
        this.register = new HashMap<>();
    }

    public static ParkingLot getInstance() {
        if (parkingLotInstance == null)
            parkingLotInstance = new ParkingLot();
        return parkingLotInstance;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void createParking() {
        final int levelNumber = 4, rowNumber = 6, largeSpots = 10, compactSpots = 20;
        for (int level = 0; level < levelNumber; level++) {
            ArrayList<Row> rows = new ArrayList<>();
            for (int parkingRow = 0; parkingRow < rowNumber; parkingRow++) {
                ArrayList<Spot> rowSpots = new ArrayList<>();
                HashMap<SpotType, Integer> statistics = new HashMap<>();
                statistics.put(SpotType.SMALL, 2);
                statistics.put(SpotType.COMPACT, 0);
                statistics.put(SpotType.LARGE, 0);
                rowSpots.add(new Spot(SpotType.SMALL, parkingRow + 1));
                int spotsNumbersPerRow = (parkingRow == 0 || parkingRow == rowNumber - 1) ? largeSpots : compactSpots;
                SpotType spotType = (parkingRow == 0 || parkingRow == rowNumber - 1) ? SpotType.LARGE : SpotType.COMPACT;
                if ((parkingRow == 0 || parkingRow == rowNumber - 1)) {
                    statistics.put(SpotType.LARGE, largeSpots);
                } else {
                    statistics.put(SpotType.COMPACT, compactSpots);
                }
                RowType rowType = (parkingRow == 0 || parkingRow == rowNumber - 1) ? RowType.BIG : RowType.COMPACT;
                for (int spotNumber = 0; spotNumber < spotsNumbersPerRow; spotNumber++) {
                    rowSpots.add(new Spot(spotType, parkingRow + 1));
                }
                rowSpots.add(new Spot(SpotType.SMALL, parkingRow + 1));
                Row currentRow = new Row(rowSpots, rowType);
                currentRow.setStatistics(statistics);
                rows.add(currentRow);
            }
            levels.add(new Level(rows, level));
        }
    }

    public HashMap<String, Integer> getRegister() {
        return register;
    }

    public void setRegister(HashMap<String, Integer> register) {
        this.register = register;
    }
}

