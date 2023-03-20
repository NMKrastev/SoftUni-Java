package _08_JavaOOPRetakeExam_22August2021.glacialExpedition.core;

public interface Controller {
    String addExplorer(String type, String explorerName);

    String addState(String stateName, String... exhibits);

    String retireExplorer(String explorerName);

    String exploreState(String stateName);

    String finalResult();
}
