package _13_JavaOOPExam_14August2022.footballUnitTest;

public class Footballer {
    private String name;
    private boolean isActive;

    public Footballer(String name){
        this.setName(name);
        this.setActive(true);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }
}
