package A6_PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;

        Map<String, List<Pokemon>> pokemonsMap = new LinkedHashMap<>();
        while (!(input = scanner.nextLine()).equals("Tournament")) {
            String trainerName = input.split("\\s+")[0];
            String pokemonName = input.split("\\s+")[1];
            String pokemonElement = input.split("\\s+")[2];
            int pokemonHealth = Integer.parseInt(input.split("\\s+")[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            pokemonsMap.putIfAbsent(trainerName, new ArrayList<>());
            pokemonsMap.get(trainerName).add(pokemon);
        }

        List<Trainer> trainersList = pokemonsMap.entrySet().stream()
                .map(trainer -> new Trainer(trainer.getKey(), trainer.getValue()))
                .collect(Collectors.toList());

        while (!(input = scanner.nextLine()).equals("End")) {

            String element = input;
            trainersList.forEach(trainer -> {
                trainer.checkForElement(element);
            });
        }

        trainersList.stream().sorted(Comparator.comparing(Trainer::getNumOfBadges).reversed())
                .forEach(System.out::println);
    }
}
/*You want to be the best pokemon trainer, like no one ever was, so you set out to catch pokemon.
Define a class Trainer and a class Pokemon. The trainer has a name, a number of badges, and a collection of pokemon.
Pokemon has a name, an element, and health, all values are mandatory. Every Trainer starts with 0 badges.
From the console, you will receive an unknown number of lines until you receive the command "Tournament",
each line will carry information about a pokemon and the trainer who caught it in the format
"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}" where TrainerName is the name of the Trainer who caught
the pokemon, names are unique there cannot be 2 trainers with the same name. After receiving the command "Tournament"
an unknown number of lines containing one of three elements "Fire", "Water", and "Electricity" will follow until
the command "End" is received. For every command, you must check if a trainer has at least 1 pokemon with the given element,
if he does he receives 1 badge, otherwise, all his pokemon lose 10 health, if a pokemon falls to 0 or less health,
he dies and must be deleted from the trainer's collection. After the command "End" is received, you should print
all trainers sorted by the amount of badges they have in descending order
(if two trainers have the same amount of badges, they should be sorted by order of appearance in the input)
in the format "{TrainerName} {Badges} {NumberOfPokemon}".
*/