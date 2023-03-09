import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InStockTest {

    private ProductStock inStock;
    private Product product;

    @Before
    public void setUp() {
        this.inStock = new InStock();
        this.product = new Product("Product", 200.00, 1);
    }

    @Test
    public void testAddInStockShouldContainThatProduct() {
        inStock.add(product);
        assertTrue(inStock.contains(product));
    }

    @Test
    public void testContainsShouldReturnFalseWhenProductIsMissing() {
        assertFalse(inStock.contains(product));
    }

    @Test
    public void testCountShouldReturnTheCorrectNumberOfProducts() {
        assertEquals(0, inStock.getCount());
        inStock.add(product);
        assertEquals(1, inStock.getCount());
    }


    @Test
    public void testFindShouldReturnTheCorrectNthProduct() {
        List<Product> productList = addMultipleProducts();
        int productIndex = 3;

        Product expectedProduct = productList.get(productIndex);

        Product actualProduct = inStock.find(productIndex);

        assertNotNull(actualProduct);
        assertEquals(expectedProduct.getLabel(), actualProduct.getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldThrowWithIndexOutOfRange() {
        List<Product> productList = addMultipleProducts();
        inStock.find(productList.size());
    }

    @Test
    public void testChangeQuantityShouldUpdateProductQuantity() {
        inStock.add(product);
        int expectedQuantity = product.getQuantity() + 1;
        inStock.changeQuantity(product.getLabel(), expectedQuantity);
        assertEquals(expectedQuantity, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldThrowIfProductWithLabelIsMissing() {
        inStock.changeQuantity("Missing Label", 5);
    }

    @Test
    public void testFindByLabelShouldReturnTheProductWithSameLabel() {
        addMultipleProducts();
        inStock.add(product);

        Product byLabel = inStock.findByLabel(product.getLabel());

        assertNotNull(byLabel);

        assertEquals(product.getLabel(), byLabel.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldThrowWhenProductWithLabelIsMissing() {
        inStock.findByLabel("Missing Label");
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnCorrectNumberOfProducts() {
        addMultipleProducts();
        int expectedCount = 3;
        List<Product> actualProducts = iterableToList(inStock.findFirstByAlphabeticalOrder(expectedCount));
        assertEquals(expectedCount, actualProducts.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnTheProductsOrderedByLabel() {
        List<Product> products = addMultipleProducts().stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .toList();
        int expectedCount = products.size();
        List<Product> actualProducts = iterableToList(inStock.findFirstByAlphabeticalOrder(expectedCount));

        assertEquals(expectedCount, actualProducts.size());

        for (int i = 0; i < products.size(); i++) {
            String expectedLabel = products.get(i).getLabel();
            String actualLabel = actualProducts.get(i).getLabel();
            assertEquals(expectedLabel, actualLabel);
        }
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWhenNotEnoughProducts() {
        int size = addMultipleProducts().size();
        List<Product> products = iterableToList(inStock.findFirstByAlphabeticalOrder(size + 1));
        assertEquals(0, products.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWhenCountIsZero() {
        addMultipleProducts();
        List<Product> products = iterableToList(inStock.findFirstByAlphabeticalOrder(0));
        assertEquals(0, products.size());
    }

    @Test
    public void testFindAllInRangeShouldReturnCorrectRange() {

        final int lowRange = 10;
        final int highRange = 40;

        List<Product> expected = addMultipleProducts()
                .stream()
                .filter(e -> e.getPrice() > lowRange && e.getPrice() <= highRange)
                .toList();

        List<Product> actual = iterableToList(inStock.findAllInRange(lowRange, highRange));

        assertEquals(expected.size(), actual.size());

        boolean hasNoOutOfRangePrices = actual.stream()
                .map(Product::getPrice)
                .noneMatch(e -> e <= lowRange || e > highRange);

        assertTrue(hasNoOutOfRangePrices);
    }

    @Test
    public void testFindAllInRangeShouldReturnOrderedProductsByPrice() {

        final int lowRange = 10;
        final int highRange = 40;

        List<Product> expected = addMultipleProducts()
                .stream()
                .filter(e -> e.getPrice() > lowRange && e.getPrice() <= highRange)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .toList();

        List<Product> actual = iterableToList(inStock.findAllInRange(lowRange, highRange));

        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            double expectedPrice = expected.get(i).getPrice();
            double actualPrice = actual.get(i).getPrice();
            assertEquals(expectedPrice, actualPrice, 0.00);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnMatchingPriceProduct() {

        addMultipleProducts();

        double expectedPrice = 30.00;
        List<Product> products = iterableToList(inStock.findAllByPrice(expectedPrice));

        for (Product p : products) {
            assertEquals(expectedPrice, p.getPrice(), 0.00);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyCollectionWhenNoneMatches() {
        addMultipleProducts();
        List<Product> products = iterableToList(inStock.findAllByPrice(-10));
        assertEquals(0, products.size());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnMostExpensiveProducts() {
        int productsToTake = 5;
        List<Product> expected = addMultipleProducts().stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(productsToTake)
                .collect(Collectors.toList());

        List<Product> actual = iterableToList(inStock.findFirstMostExpensiveProducts(productsToTake));

        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {

            double expectedPRice = expected.get(i).getPrice();
            double actualPrice = actual.get(i).getPrice();
            assertEquals(expectedPRice, actualPrice, 0.00);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldThrowWhenThereAreLessProductsInStock() {

        int size = addMultipleProducts().size();

        inStock.findFirstMostExpensiveProducts(size + 1);
    }

    @Test
    public void testFindAllByQuantityShouldReturnMatchingPriceProduct() {

        addMultipleProducts();

        int expectedQuantity = 30;
        List<Product> products = iterableToList(inStock.findAllByQuantity(expectedQuantity));

        for (Product p : products) {
            assertEquals(expectedQuantity, p.getQuantity());
        }
    }

    @Test
    public void testFindAllByQuantityShouldReturnEmptyCollectionWhenNoneMatches() {
        addMultipleProducts();
        List<Product> products = iterableToList(inStock.findAllByQuantity(-10));
        assertEquals(0, products.size());
    }

    @Test
    public void testIteratorShouldReturnAllProductsInStock() {
        List<Product> expected = addMultipleProducts();

        Iterator<Product> iterator = inStock.iterator();

        List<Product> actual = new ArrayList<>();

        iterator.forEachRemaining(actual::add);

        assertEquals(expected, actual);
    }

    private List<Product> addMultipleProducts() {
        List<Product> productList = List.of(
                new Product("Product 3", 30.00, 30),
                new Product("Product 4", 40.00, 40),
                new Product("Product 2", 20.00, 20),
                new Product("Product 6", 60.00, 60),
                new Product("Product 1", 10.00, 10),
                new Product("Product 5", 50.00, 50),
                new Product("Product 7", 70.00, 70));
        productList.forEach(inStock::add);
        return productList;
    }

    private List<Product> iterableToList(Iterable<Product> iterable) {
        assertNotNull(iterable);

        List<Product> productList = new ArrayList<>();
        iterable.forEach(productList::add);
        return productList;
    }
}