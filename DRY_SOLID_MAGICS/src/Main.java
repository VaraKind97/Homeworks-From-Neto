import java.util.Scanner;

public class Main {
    public static final String RUB = "рублей";
    public static final String c = "шт";

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product().setName("Хлеб").setPrice(100);
        products[1] = new Product().setName("Яйца").setPrice(200);
        products[2] = new Product().setName("Молоко").setPrice(120);
        products[3] = new Product().setName("Кофе").setPrice(300);
        products[4] = new Product().setName("Кола").setPrice(150);
        printProducts(products);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер товара и количество или введите `end` ");
            String input = scanner.nextLine();
            if ("end".equals(input))
                break;
            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            products[productNumber].setCount(Integer.parseInt(parts[1]));
        }
        printProducts(products);
        printBasket(products);
    }

    private static void printProducts(Product[] products) {
        System.out.println("Список товаров для покупки: ");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }
    }

    private static void printBasket(Product[] products) {
        int costProducts = 0;
        System.out.println("Ваша корзина: ");
        for (Product product : products) {
            if (product.getCount() != 0) {
                costProducts += product.getCount() * product.getPrice();
                System.out.println(product + "." + " Количество: " + product.getCount() + c
                        + "." + " Цена: " + product.getPrice() + " " + RUB
                        + "." + " Стоимость: " + product.getCount() * product.getPrice() + " " + RUB);
            }
        }
        System.out.println("Итого: " + costProducts + " " + RUB);
    }
}