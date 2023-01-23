package A7_Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private Car car;
    private List<Child> childrenList;
    private List<Parent> parentsList;
    private List<Pokemon> pokemonsList;

    public Person(String name) {
        this.name = name;
        this.childrenList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.pokemonsList = new ArrayList<>();
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Child> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Child> childrenList) {
        this.childrenList = childrenList;
    }

    public List<Parent> getParentsList() {
        return parentsList;
    }

    public void setParentsList(List<Parent> parentsList) {
        this.parentsList = parentsList;
    }

    public List<Pokemon> getPokemonsList() {
        return pokemonsList;
    }

    public void setPokemonsList(List<Pokemon> pokemonsList) {
        this.pokemonsList = pokemonsList;
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();
        output.append(name).append(System.lineSeparator());
        output.append("Company:\n").append(String.format(String.format("%s", getCompany() == null ? "" : getCompany() + "\n")));
        output.append("Car:\n").append(String.format("%s", getCar() == null ? "" : getCar() + "\n"));
        output.append("Pokemon:").append(String.format("%s", getPokemonsList() == null ? "\n" : "\n" + String.join("\n", getPokemonsList().toString().replaceAll("\\[|]|, ", ""))));
        output.append("Parents:").append(String.format("%s", getParentsList() == null ? "\n" : "\n" + String.join("\n", getParentsList().toString().replaceAll("\\[|]|, ", ""))));
        output.append("Children:").append(String.format("%s", getChildrenList() == null ? "\n" : "\n" + String.join("\n", getChildrenList().toString().replaceAll("\\[|]|, ", ""))));
        return output.toString();

    }
}
