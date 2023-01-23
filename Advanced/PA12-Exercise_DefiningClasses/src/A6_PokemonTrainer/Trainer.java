package A6_PokemonTrainer;

import java.util.List;

public class Trainer {

    private String name;
    private int numOfBadges;
    private List<Pokemon> pokemonsList;

    public Trainer(String name, List<Pokemon> pokemonsList) {
        this.name = name;
        this.numOfBadges = 0;
        this.pokemonsList = pokemonsList;
    }

    public String getName() {
        return name;
    }

    public int getNumOfBadges() {
        return numOfBadges;
    }

    public List<Pokemon> getPokemonsList() {
        return pokemonsList;
    }

    public void checkForElement(String element) {
        if(isPokemonWithElementExisting(element)) {
            numOfBadges += 1;
        } else {
            for (int i = 0; i < pokemonsList.size(); i++) {
                pokemonsList.get(i).setHealth(pokemonsList.get(i).getHealth() - 10);
                if (pokemonsList.get(i).getHealth() <= 0) {
                    pokemonsList.remove(pokemonsList.get(i));
                    i--;
                }
            }
        }
    }

    private boolean isPokemonWithElementExisting(String element) {
        for (Pokemon pokemon : pokemonsList) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", name, numOfBadges, pokemonsList.size());
    }
}
