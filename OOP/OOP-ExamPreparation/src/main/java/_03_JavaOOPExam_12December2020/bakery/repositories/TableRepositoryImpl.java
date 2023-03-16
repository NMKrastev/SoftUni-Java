package _03_JavaOOPExam_12December2020.bakery.repositories;

import _03_JavaOOPExam_12December2020.bakery.entities.tables.interfaces.Table;
import _03_JavaOOPExam_12December2020.bakery.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table> {

    private Collection<Table> models;

    public TableRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public void add(Table table) {
        this.models.add(table);
    }

    @Override
    public Collection<Table> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public Table getByNumber(int number) {
        return this.models.stream()
                .filter(table -> table.getTableNumber() == number)
                .findFirst()
                .orElse(null);
    }
}
