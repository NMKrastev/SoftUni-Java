package bg.softuni.BattleShipsApplication.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShipDTO {

    private String name;

    private long health;

    private long power;

    @Override
    public String toString() {

        return String.format("| %s | %d | %d ", this.name, this.health, this.power);
    }
}
