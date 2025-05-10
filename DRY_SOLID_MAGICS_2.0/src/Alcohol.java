public class Alcohol extends Product implements Drink, StopList {

    public Alcohol(String name, int price, String weight) {
        super(name, price, weight);
    }

    @Override
    public void checkAge(String msg) {
        System.out.format("Подтвердите возраст!");
    }

    @Override
    public void stop(String msg) {
        System.out.println("С 23 часов продажа алкоголя запрещена!");
    }
}