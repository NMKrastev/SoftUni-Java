package solid.calculators;

import solid.products.Product;

import java.util.List;

public interface Calculator {

    public double total(List<Product> products);

    public double average(List<Product> products);

}
