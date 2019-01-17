package project.parking_app.data.parkingLotComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import project.parking_app.data.utils.RowType;
import project.parking_app.data.utils.SpotType;

public class Row {
    private List<Spot> spots;
    private HashMap<SpotType, Integer> statistics;
    private RowType rowType;

    public Row(ArrayList<Spot> spots, RowType rowType) {
        this.spots = spots;
        this.rowType = rowType;
    }

    public HashMap<SpotType, Integer> getStatistics() {
        return statistics;
    }

    void setStatistics(HashMap<SpotType, Integer> statistics) {
        this.statistics = statistics;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void displayStatistics() {
        System.out.println(statistics.get(SpotType.SMALL) + "small " + statistics.get(SpotType.COMPACT) + "compact "
                + statistics.get(SpotType.LARGE) + "large ");
    }

    public RowType getRowType() {
        return rowType;
    }
}
