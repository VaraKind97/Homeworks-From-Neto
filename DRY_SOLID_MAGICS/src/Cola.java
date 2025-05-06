public class Cola extends Product implements Package, Drinks {
    protected final String name = "Кока-кола";
    protected final int price = 200;

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
        System.out.println("Холодная");
    }

    @Override
    public void material() {
        System.out.println("В стеклянной бутылке");
    }
}