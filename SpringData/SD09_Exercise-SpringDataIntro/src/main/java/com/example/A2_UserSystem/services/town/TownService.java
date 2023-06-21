package com.example.A2_UserSystem.services.town;

import com.example.A2_UserSystem.models.Town;

import java.util.List;

public interface TownService {

    boolean isDataSeeded();

    void seedTowns(List<Town> towns);

    Town getRandomTown();
}
