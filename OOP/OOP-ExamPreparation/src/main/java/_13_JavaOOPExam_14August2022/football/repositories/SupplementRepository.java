package _13_JavaOOPExam_14August2022.football.repositories;

import _13_JavaOOPExam_14August2022.football.entities.supplement.Supplement;

public interface SupplementRepository {
    void add(Supplement supplement);

    boolean remove(Supplement supplement);

    Supplement findByType(String type);
}
