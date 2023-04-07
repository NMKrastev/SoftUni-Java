package _16_JavaOOPRetakeExam_19December2022.magicGame.repositories;

import _16_JavaOOPRetakeExam_19December2022.magicGame.common.ExceptionMessages;
import _16_JavaOOPRetakeExam_19December2022.magicGame.models.magics.Magic;
import _16_JavaOOPRetakeExam_19December2022.magicGame.repositories.interfaces.MagicRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MagicRepositoryImpl implements MagicRepository<Magic> {
    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return Collections.unmodifiableCollection(this.data);
    }

    @Override
    public void addMagic(Magic magic) {

        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_REPOSITORY);
        }

        this.data.add(magic);
    }

    @Override
    public boolean removeMagic(Magic magic) {
        return this.data.remove(magic);
    }

    @Override
    public Magic findByName(String name) {

        return this.data
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}