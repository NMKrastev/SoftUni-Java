package _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.explorers;

import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.suitcases.Suitcase;

public interface Explorer {
    String getName();

    double getEnergy();

    boolean canSearch();

    Suitcase getSuitcase();

    void search();
}
