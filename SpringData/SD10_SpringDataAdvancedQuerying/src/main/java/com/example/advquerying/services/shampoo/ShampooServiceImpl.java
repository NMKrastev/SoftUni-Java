package com.example.advquerying.services.shampoo;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class ShampooServiceImpl implements ShampooService {

    private ShampooRepository shampooRepository;


    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findByBrand(String brand) {

        return this.shampooRepository.findAllByBrand(brand)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Shampoo> findByBrandAndSize(String brand, String size) {

        Size parse = Size.valueOf(size.toUpperCase());

        return this.shampooRepository.findByBrandAndSize(brand, parse)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Shampoo> findBySizeOrderById(String size) {

        Size parse = Size.valueOf(size.toUpperCase());

        return this.shampooRepository.findBySizeOrderById(parse)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Shampoo> findAllBySizeOrLabelIdOrderByPrice(String size, Long label) {

        Size parse = Size.valueOf(size.toUpperCase());

        return this.shampooRepository.findAllBySizeOrLabelIdOrderByPrice(parse, label)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Shampoo> findByPriceGreaterThan(BigDecimal price) {

        return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Integer countShampoosByPriceLessThan(BigDecimal price) {

        Optional<List<Shampoo>> byPriceLessThan = this.shampooRepository.findByPriceLessThan(price);

        return byPriceLessThan.map(List::size).orElse(0);
    }

    @Override
    public List<String> findAllByIngredientsIn(List<String> ingredients) {

        return this.shampooRepository.findAllByIngredientsIn(ingredients)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Shampoo> findAllByIngredientsCountLessThan(int count) {

        return this.shampooRepository.findAllByIngredientsCountLessThan(count)
                .orElseThrow(NoSuchElementException::new);
    }
}
