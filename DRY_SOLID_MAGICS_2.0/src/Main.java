import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static final String RUB = "рублей";
    private static ArrayList<Product> menu;

    public static void main(String[] args) {
        menu = new ArrayList<Product>();
        menu.add(new Salad("Витаминный салат", 350, "230гр"));
        menu.add(new Salad("Салат Греческий", 400, "250гр"));
        menu.add(new Meat("Стейк Стриплойнд", 1000, "250гр"));
        menu.add(new Meat("Стейк Шато Бриан", 1100, "250гр"));
        menu.add(new NonAlcohol("Кола", 150, "0.33л"));
        menu.add(new NonAlcohol("Святой источник", 40, "1л"));
        menu.add(new Alcohol("Пиво", 100, "0.5л"));
        menu.add(new Alcohol("Вино", 500, "0.3л"));
        System.out.println("Добро пожаловать в онлайн-ресторан!\n");
        printMenu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите желаемую позицию и количество или введите `end` ");
            String input = scanner.nextLine();
            if ("end".equals(input)) break;
            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            menu.get(productNumber).setCount(Integer.parseInt(parts[1]));
        }
        printOrderList();
        System.out.println("\nСтоимость вашего заказа составляет: " + getOrderPrice() + " " + RUB);
    }

    private static void printMenu() {
        System.out.println("Меню:");
        Iterator<Product> it = menu.listIterator();
        while (it.hasNext()) {
            Product product = it.next();
            System.out.print(product.getName() + ", ");
            System.out.print(product.getPrice() + " " + RUB + ", ");
            System.out.println(product.getWeight() + " ");
        }
    }

    private static void printOrderList() {
        System.out.println("\nВаш заказ:");
        Iterator<Product> it = menu.listIterator();
        while (it.hasNext()) {
            Product product = it.next();
            if (product.getCount() > 0) {
                System.out.print(product.getName() + "- " + product.getCount() + " шт. \n");
            }
        }
    }

    private static int getOrderPrice() {
        int totalPrice = 0;
        Iterator<Product> it = menu.listIterator();
        while (it.hasNext()) {
            Product product = it.next();
            totalPrice += product.getCount() * product.getPrice();
            if (product instanceof Alcohol) {
                int priceOfAlcohol = product.getPrice();
                int totalPriceOfAlcohol = priceOfAlcohol * product.getCount();
                ((Drink) product).checkAge("Введите ваш возраст!");
                Scanner scanner = new Scanner(System.in);
                int age = scanner.nextInt();
                if (age < 18) {
                    System.out.println("Вы несовершеннолетний и не можете приобрести алкоголь");
                    return totalPrice - totalPriceOfAlcohol;
                }
                ((StopList) product).stop("Запрет на продажу алкоголя");
                totalPrice = 0;
            }

        }
        return totalPrice;
    }
}


