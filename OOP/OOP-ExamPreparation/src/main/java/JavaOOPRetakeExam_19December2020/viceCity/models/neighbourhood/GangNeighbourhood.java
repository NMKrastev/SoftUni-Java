package JavaOOPRetakeExam_19December2020.viceCity.models.neighbourhood;

import JavaOOPRetakeExam_19December2020.viceCity.models.guns.Gun;
import JavaOOPRetakeExam_19December2020.viceCity.models.players.Player;

import java.util.Collection;
import java.util.stream.Collectors;

public class GangNeighbourhood implements Neighbourhood {

    public GangNeighbourhood() {
    }

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        for (Gun model : mainPlayer.getGunRepository().getModels()) {
            for (Player civilPlayer : civilPlayers) {
                while (civilPlayer.isAlive() && model.canFire()) {
                    int firePoints = model.fire();
                    civilPlayer.takeLifePoints(firePoints);
                }
            }
        }

        civilPlayers = civilPlayers
                .stream()
                .filter(Player::isAlive)
                .collect(Collectors.toList());

        for (Player alivePlayer : civilPlayers) {
            for (Gun model : alivePlayer.getGunRepository().getModels()) {
                while (mainPlayer.isAlive() && model.canFire()) {
                    int firePoints = model.fire();
                    mainPlayer.takeLifePoints(firePoints);
                    if (!mainPlayer.isAlive()) {
                        return;
                    }
                }
            }
        }
    }
}
