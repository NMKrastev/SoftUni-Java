package viceCity.models.guns;

public class Pistol extends BaseGun {

    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;
    private static final int PISTOL_SHOT = 1;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {

        if (canFire()) {
            setBulletsPerBarrel(getBulletsPerBarrel() - PISTOL_SHOT);
            if (getBulletsPerBarrel() == 0) {
                if (getTotalBullets() > BULLETS_PER_BARREL) {
                    setBulletsPerBarrel(BULLETS_PER_BARREL);
                    setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
                } else if (getTotalBullets() > 0) {
                    setBulletsPerBarrel(getTotalBullets());
                    setTotalBullets(0);
                } else {
                    setCanFire(false);
                }
            }
        }

        return PISTOL_SHOT;
    }
}
