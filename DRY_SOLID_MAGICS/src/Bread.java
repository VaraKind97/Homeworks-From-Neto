public class Bread extends Product implements Food {
    protected final String name = "Хлеб";
    protected final int price = 70;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void eat() {
        System.out.println("Готов к употреблению");
    }
}