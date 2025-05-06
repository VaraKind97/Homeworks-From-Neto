public class Milk extends Product implements Food, Drinks {
    protected final String name = "Молоко";
    protected final int price = 150;

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
        System.out.println("Можно добавить в кофе");
    }

    @Override
    public void temperature() {
        System.out.println("Можно разогреть или пить холодным");
    }
}