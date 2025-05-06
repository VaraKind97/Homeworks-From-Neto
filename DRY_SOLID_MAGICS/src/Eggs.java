public class Eggs extends Product implements Food {
    protected final String name = "Яйца";
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
    public void eat() {
        System.out.println("Надо отварить или пожарить");
    }
}