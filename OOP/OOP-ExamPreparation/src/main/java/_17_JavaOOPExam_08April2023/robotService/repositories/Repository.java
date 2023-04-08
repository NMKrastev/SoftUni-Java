package _17_JavaOOPExam_08April2023.robotService.repositories;

import _17_JavaOOPExam_08April2023.robotService.entities.supplements.Supplement;

public interface Repository {

    void addSupplement(Supplement supplement);

    boolean removeSupplement(Supplement supplement);

    Supplement findFirst(String type);
}
