public class Alcohol extends Product implements Drink {
    public static int age;

    public Alcohol(String name, int price, String weight) {
        super(name, price, weight);
    }

    @Override
    public void checkAge(String msg) {
        System.out.format("Подтвердите возраст!");
    }
}