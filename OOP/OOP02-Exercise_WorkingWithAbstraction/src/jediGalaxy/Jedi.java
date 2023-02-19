package jediGalaxy;

public class Jedi {

    private Galaxy galaxy;
    private long points;

    public Jedi(Galaxy galaxy) {
        this.galaxy = galaxy;
        this.points = 0;
    }

    public void collectStars(int row, int col) {
        while (row >= 0 && col < galaxy.getLength(1)) {
            if (row < galaxy.getLength()
                    && col >= 0 && col < galaxy.getLength(0)) {
                points += galaxy.getStar(row, col);
            }
            col++;
            row--;
        }
    }

    public long getPoints() {
        return points;
    }
}
