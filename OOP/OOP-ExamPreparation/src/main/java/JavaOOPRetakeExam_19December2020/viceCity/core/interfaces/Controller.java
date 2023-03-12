package JavaOOPRetakeExam_19December2020.viceCity.core.interfaces;

public interface Controller {
    String addPlayer(String name);

    String addGun(String type, String name);

    String addGunToPlayer(String name);

    String fight();
}
