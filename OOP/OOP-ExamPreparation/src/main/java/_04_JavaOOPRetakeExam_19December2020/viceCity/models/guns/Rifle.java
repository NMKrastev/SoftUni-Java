package _04_JavaOOPRetakeExam_19December2020.viceCity.models.guns;

public class Rifle extends BaseGun {

    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int RIFLE_SHOT = 5;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {

        if (canFire()) {
            setBulletsPerBarrel(getBulletsPerBarrel() - RIFLE_SHOT);
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

        return RIFLE_SHOT;
    }
}
