import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class InStock implements ProductStock {

    private List<Product> productsList;

    public InStock() {
        this.productsList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return productsList.size();
    }

    @Override
    public boolean contains(Product product) {
        return productsList.stream()
                .anyMatch(e -> e.getLabel().equals(product.getLabel()));
    }

    @Override
    public void add(Product product) {
        productsList.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        Product currentProduct = findByLabel(product);
        currentProduct.setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        return productsList.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        return productsList.stream()
                .filter(e -> e.getLabel().equals(label))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to find product with label!"));
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count <= 0 || count > productsList.size()) {
            return new ArrayList<>();
        }

        return productsList.stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return productsList.stream()
                .filter(e -> e.getPrice() > lo && e.getPrice() <= hi)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .toList();
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return productsList.stream()
                .filter(e -> e.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {

        if (count <= 0 || count > productsList.size()) {
            throw new IllegalArgumentException("Not enough products in stock!");
        }

        return productsList.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return productsList.stream()
                .filter(e -> e.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return productsList.iterator();
    }
}
