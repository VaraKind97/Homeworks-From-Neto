public class Coffee extends Product implements Package, Drinks {
    protected final String name = "Кофе";
    protected final int price = 350;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void temperature() {
        System.out.println("Горячий");
    }

    @Override
    public void material() {
        System.out.println("Бумажный стаканчик");
    }
}