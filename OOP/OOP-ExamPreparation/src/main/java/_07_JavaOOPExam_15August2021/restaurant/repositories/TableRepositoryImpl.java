package _07_JavaOOPExam_15August2021.restaurant.repositories;

import _07_JavaOOPExam_15August2021.restaurant.entities.tables.interfaces.Table;
import _07_JavaOOPExam_15August2021.restaurant.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table> {

    private Collection<Table> tables = new ArrayList<>();

    @Override
    public Table byNumber(int number) {

        return this.tables
                .stream()
                .filter(e -> e.getTableNumber() == number)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(this.tables);
    }

    @Override
    public void add(Table table) {
        this.tables.add(table);
    }
}
