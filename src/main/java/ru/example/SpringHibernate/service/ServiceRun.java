package ru.example.SpringHibernate.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.example.SpringHibernate.entity.Recipe;

import java.util.List;
import java.util.Scanner;

@Component(value = "serviceRun")
public class ServiceRun implements CommandLineRunner {
    private RecipeService recipeService;

    public ServiceRun(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду (добавить, удалить, найти, выйти): ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("Добавить")) {
                System.out.println("Введите название рецепта: ");
                String name = scanner.nextLine();
                System.out.println("Введите структуру рецепта: ");
                String structure = scanner.nextLine();
                Recipe recipe = new Recipe(name, structure);
                recipeService.insert(recipe);
            } else if (command.equalsIgnoreCase("Удалить")) {
                System.out.println("Введите название рецепта для удаления: ");
                String name = scanner.nextLine();
                recipeService.delete(name);
            } else if (command.equalsIgnoreCase("Найти")) {
                System.out.println("Введите название рецепта или часть названия: ");
                String name = scanner.nextLine();
                List<Recipe> recipes = recipeService.findByName(name);
                recipes.forEach(System.out::println);
            } else if (command.equalsIgnoreCase("выйти")) {
                System.out.println("Выход из программы...");
                break;
            } else {
                System.out.println("Неизвестная команда. Повторите ввод.");
            }
        }
    }
}