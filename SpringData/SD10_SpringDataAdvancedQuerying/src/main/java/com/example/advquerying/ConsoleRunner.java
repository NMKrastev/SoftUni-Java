package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.services.ingredient.IngredientService;
import com.example.advquerying.services.shampoo.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import static com.example.advquerying.constants.Constants.*;

@Service
public class ConsoleRunner implements CommandLineRunner {

    private static final Scanner scanner = new Scanner(System.in);
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    @Autowired
    public ConsoleRunner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {

        /*final List<Shampoo> allByBrand = this.shampooService.findByBrand("Cotton Fresh");

        allByBrand.forEach(e -> System.out.println(e.getId()));

        System.out.print("Enter size: ");
        String size = scanner.nextLine();

        final List<Shampoo> allByBrandAndSize = this.shampooService.findByBrandAndSize("Cotton Fresh", size);

        allByBrandAndSize.forEach(e -> System.out.printf("%s: %s\n", e.getBrand(), e.getSize()));*/

        System.out.print(ENTER_TASK_NUMBER);
        int taskNumber = Integer.parseInt(scanner.nextLine());

        switch (taskNumber) {
            //Task 1 Select Shampoo By Size
            case 1 -> selectShampooBySize();
            //2. Select Shampoos By Size Or Label
            case 2 -> selectShampooBySizeOrLabel();
            //3. Select Shampoos By Price
            case 3 -> selectShampooByPriceHigherThan();
            //4. Select Ingredients By Name
            case 4 -> selectIngredientsStartingWithLetters();
            //5. Select Ingredients By Names
            case 5 -> selectIngredientsByName();
            //6. Count Shampoos By Price
            case 6 -> countShampoosByPrice();
            //7. Select Shampoos By Ingredients
            case 7 -> selectShampooByIngredients();
            //8. Select Shampoos By Ingredients Count
            case 8 -> selectShampoosByIngredientsCount();
            //9. Delete Ingredients By Name
            case 9 -> deleteIngredientsByName();
            //10. Update Ingredients By Price
            case 10 -> updateAllIngredientsPrice();
            //11. Update Ingredients By Names
            case 11 -> updateIngredientsPriceByName();
        }
    }

    private void updateIngredientsPriceByName() {
        //11. Update Ingredients By Names
        final List<String> ingredients = new ArrayList<>();

        getIngredientsInAList(ingredients);

        System.out.print(ENTER_PERCENTAGE);
        String percent = scanner.nextLine();
        percent = String.format(percent.equals("100") ? "2": String.format("1.%s", percent));
        BigDecimal percentage = BigDecimal.valueOf(Double.parseDouble(percent));

        this.ingredientService.updateIngredientsPriceByName(ingredients, percentage);

        System.out.println(INGREDIENTS_PRICE_UPDATED);
    }

    private void updateAllIngredientsPrice() {
        //10. Update Ingredients By Price
        this.ingredientService.updateAllIngredientsPrice();

        System.out.println(INGREDIENTS_PRICE_UPDATED);
    }

    private void deleteIngredientsByName() {
        //9. Delete Ingredients By Name
        System.out.print(ENTER_INGREDIENT_NAME);
        String ingredient = scanner.nextLine();

        this.ingredientService.deleteIngredientByName(ingredient);

        System.out.println();
    }

    private void selectShampoosByIngredientsCount() {
        //8. Select Shampoos By Ingredients Count
        System.out.print(ENTER_INGREDIENTS_COUNT);
        int count = Integer.parseInt(scanner.nextLine());

        List<Shampoo> allByIngredientsCountLessThan = this.shampooService.findAllByIngredientsCountLessThan(count);

        allByIngredientsCountLessThan
                .forEach(e -> System.out.println(e.getBrand()));
    }

    private void selectShampooByIngredients() {

        final List<String> ingredients = new ArrayList<>();

        getIngredientsInAList(ingredients);

        List<String> byIngredients = this.shampooService.findAllByIngredientsIn(ingredients);

        byIngredients.forEach(System.out::println);
    }

    private void countShampoosByPrice() {
        //6. Count Shampoos By Price
        System.out.print(ENTER_SHAMPOO_PRICE);
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));

        int count = this.shampooService.countShampoosByPriceLessThan(price);

        System.out.println(count);
    }

    private void selectIngredientsByName() {
        //5. Select Ingredients By Names
        final List<String> ingredients = new ArrayList<>();

        System.out.print(ENTER_INGREDIENT_NAME);
        String ingredient = scanner.nextLine();

        System.out.println(ENTER_END_TO_STOP);

        while(!ingredient.equalsIgnoreCase(END)) {

            ingredients.add(ingredient);

            System.out.print(ENTER_INGREDIENT_NAME);
            ingredient = scanner.nextLine();
        }

        List<Ingredient> allByNameIn = this.ingredientService.findAllByNameInOrderByPrice(ingredients);

        allByNameIn.forEach(e -> System.out.println(e.getName()));
    }

    private void selectIngredientsStartingWithLetters() {
        //4. Select Ingredients By Name
        System.out.print(ENTER_STARTS_WITH_LETTERS_FOR_INGREDIENT);
        String letters = scanner.nextLine();

        List<Ingredient> byNameStartingWith = this.ingredientService.findByNameStartingWith(letters);

        byNameStartingWith.forEach(e -> System.out.println(e.getName()));
    }

    private void selectShampooByPriceHigherThan() {
        //3. Select Shampoos By Price
        System.out.print(ENTER_SHAMPOO_PRICE);
        BigDecimal price = BigDecimal.valueOf(Long.parseLong(scanner.nextLine()));

        List<Shampoo> byPriceGreaterThan = this.shampooService.findByPriceGreaterThan(price);

        byPriceGreaterThan.forEach(e -> System.out.printf(BRAND_SIZE_PRICE_FORMAT, e.getBrand(), e.getSize(), e.getPrice()));
    }

    private void selectShampooBySizeOrLabel() {
        //2. Select Shampoos by Size or Label
        System.out.print(ENTER_SHAMPOO_SIZE);
        String size = scanner.nextLine();
        System.out.print(ENTER_LABEL_ID);
        long label = Long.parseLong(scanner.nextLine());

        final List<Shampoo> allBySizeOrLabel = this.shampooService.findAllBySizeOrLabelIdOrderByPrice(size, label);

        allBySizeOrLabel.forEach(e -> System.out.printf(BRAND_SIZE_PRICE_FORMAT, e.getBrand(), e.getSize(), e.getPrice()));
    }

    private void selectShampooBySize() {
        //Task 1 Select Shampoo By Size
        System.out.print(ENTER_SHAMPOO_SIZE);
        String size = scanner.nextLine();

        final List<Shampoo> allBySizeOrdered= this.shampooService.findBySizeOrderById(size);

        allBySizeOrdered.forEach(e -> System.out.printf(BRAND_SIZE_PRICE_FORMAT, e.getBrand(), e.getSize(), e.getPrice()));
    }

    private static void getIngredientsInAList(List<String> ingredients) {

        System.out.print(ENTER_INGREDIENT_NAME);
        String ingredient = scanner.nextLine();

        System.out.println(ENTER_END_TO_STOP);

        while(!(ingredient.equalsIgnoreCase(END))) {

            ingredients.add(ingredient);

            System.out.print(ENTER_INGREDIENT_NAME);
            ingredient = scanner.nextLine();
        }
    }
}
