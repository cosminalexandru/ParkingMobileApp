package project.parking_app.data.parkingLotComponent;

import java.util.List;

public class Level {
    private List<Row> rows;
    private Integer levelNumber;

    public Level(List<Row> rows, Integer levelNumber) {
        this.rows = rows;
        this.levelNumber = levelNumber;
    }

    public List<Row> getRows() {
        return rows;
    }

    public Integer getLevelNumber() {
        return levelNumber;
    }
}
