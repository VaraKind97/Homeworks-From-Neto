/*
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static final String RUB = "рублей";
    private static ArrayList<Product> menu;
    private static String input;

    public static void main(String[] args) {

        menu = new ArrayList<Product>();
        menu.add(new Salad("Витаминный салат", 350, "230гр"));
        menu.add(new Salad("Салат Греческий", 400, "250гр"));
        menu.add(new MeatDish("Стейк Стриплойнд", 1000, "250гр"));
        menu.add(new MeatDish("Стейк Шато Бриан", 1100, "250гр"));
*/
/*        menu.add(new Drink("Кола", 150, "1л"));
        menu.add(new Drink("Святой источник", 40, "1.5л"));
        menu.add(new Alcohol("Пиво", 100, "0.5л"));
        menu.add(new Alcohol("Вино", 500, "1л"));
        System.out.println("Добро пожаловать в наш ресторан!\n");
        printMenu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите желаемую позицию и количество или введите `end` ");
            input = scanner.nextLine();
            if ("end".equals(input)) break;
            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            menu.get(productNumber).setCount(Integer.parseInt(parts[1]));*//*

        }
    }

    private static void printMenu() {
        System.out.println("Меню:");
        Iterator<Product> iterator = menu.listIterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            System.out.print(product.getName() + ", ");
            System.out.print(product.getPrice() + " " + RUB + ", ");
            System.out.println(product.getWeight() + " ");
        }
    }

}*/
