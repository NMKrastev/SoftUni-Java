package A5_JediGalaxy;

public class Evil {

    private Galaxy galaxy;

    public Evil(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public void destroyStars(int row, int col) {
        while (row >= 0 && col >= 0) {
            if (row < galaxy.getLength()
                    && col < galaxy.getLength(row)) {
                galaxy.setStar(row, col, 0);
            }
            row--;
            col--;
        }
    }
}
