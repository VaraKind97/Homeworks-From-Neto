import java.time.LocalTime;

public class Alcohol extends Product implements Drink, StopList {

    public Alcohol(String name, int price, String weight) {
        super(name, price, weight);
    }

    @Override
    public void checkAge(String msg) {
        System.out.println("Вы заказали алкоголь! Укажите свой возраст!");
    }

    @Override
    public void stop(String msg) {
        if (LocalTime.now().getHour() >= 23) {
            System.out.println("Сейчас " + LocalTime.now().getHour() + ":00");
            System.out.println("С 23 часов продажа алкоголя запрещена!");
        } else {
            System.out.println("Сейчас " + LocalTime.now().getHour() + ":00");
            System.out.println("Продажа алкоголя разрешена!");
        }
    }
}
