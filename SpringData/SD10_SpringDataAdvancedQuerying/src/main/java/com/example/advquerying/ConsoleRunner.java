package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.services.ingredient.IngredientService;
import com.example.advquerying.services.shampoo.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.example.advquerying.constants.Constants.BRAND_SIZE_PRICE_FORMAT;

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

        System.out.print("Please, enter task number: ");
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
        }
    }

    private void selectIngredientsByName() {
        //5. Select Ingredients By Names
        final List<String> ingredients = new ArrayList<>();

        System.out.print("Please, enter ingredients(name): ");
        String ingredient = scanner.nextLine();

        System.out.println("Enter end if you want to stop entering names.");

        while(!ingredient.equalsIgnoreCase("end")) {

            ingredients.add(ingredient);

            System.out.print("Please, enter ingredients(name): ");
            ingredient = scanner.nextLine();
        }

        List<Ingredient> allByNameIn = this.ingredientService.findAllByNameInOrderByPrice(ingredients);

        allByNameIn.forEach(e -> System.out.println(e.getName()));
    }

    private void selectIngredientsStartingWithLetters() {
        //4. Select Ingredients By Name
        System.out.println("Please, enter letter/letters: ");
        String letters = scanner.nextLine();

        List<Ingredient> byNameStartingWith = this.ingredientService.findByNameStartingWith(letters);

        byNameStartingWith.forEach(e -> System.out.println(e.getName()));
    }

    private void selectShampooByPriceHigherThan() {
        //3. Select Shampoos By Price
        System.out.print("Please, enter price: ");
        BigDecimal price = BigDecimal.valueOf(Long.parseLong(scanner.nextLine()));

        List<Shampoo> byPriceGreaterThan = this.shampooService.findByPriceGreaterThan(price);

        byPriceGreaterThan.forEach(e -> System.out.printf(BRAND_SIZE_PRICE_FORMAT, e.getBrand(), e.getSize(), e.getPrice()));
    }

    private void selectShampooBySizeOrLabel() {
        //2. Select Shampoos by Size or Label
        System.out.print("Please, enter size: ");
        String size = scanner.nextLine();
        System.out.print("Please, enter label(id): ");
        long label = Long.parseLong(scanner.nextLine());

        final List<Shampoo> allBySizeOrLabel = this.shampooService.findAllBySizeOrLabelIdOrderByPrice(size, label);

        allBySizeOrLabel.forEach(e -> System.out.printf(BRAND_SIZE_PRICE_FORMAT, e.getBrand(), e.getSize(), e.getPrice()));
    }

    private void selectShampooBySize() {
        //Task 1 Select Shampoo By Size
        System.out.print("Please, enter size: ");
        String size = scanner.nextLine();

        final List<Shampoo> allBySizeOrdered= this.shampooService.findBySizeOrderById(size);

        allBySizeOrdered.forEach(e -> System.out.printf(BRAND_SIZE_PRICE_FORMAT, e.getBrand(), e.getSize(), e.getPrice()));
    }
}
