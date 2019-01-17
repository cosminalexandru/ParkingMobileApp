package project.parking_app.data.parkingLotComponent;

import project.parking_app.data.utils.SpotType;

public class Spot {
    private static Integer numberOfSpots = 0;
    private SpotType type;
    private Boolean availability;
    private Integer spotNumber;
    private Integer rowNumber;

    public Spot(SpotType type, Integer rowNumber) {
        this.type = type;
        this.spotNumber = ++numberOfSpots;
        this.rowNumber = rowNumber;
        this.availability = true;
    }


    public SpotType getType() {
        return type;
    }

    public void setType(SpotType type) {
        this.type = type;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Integer getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(Integer spotNumber) {
        this.spotNumber = spotNumber;
    }

}
