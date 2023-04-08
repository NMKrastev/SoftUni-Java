package _17_JavaOOPExam_08April2023.robotService.entities.services;

public class SecondaryService extends BaseService {

    private static final int capacity = 15;

    public SecondaryService(String name) {
        super(name, capacity);
    }
}
