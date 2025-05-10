public class NonAlcohol extends Product implements Drink {

    public NonAlcohol(String name, int price, String weight) {
        super(name, price, weight);
    }

    @Override
    public void checkAge(String msg) {
        System.out.format("Паспорт не нужен!)");
    }
}
