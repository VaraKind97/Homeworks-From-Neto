abstract class Product {

    private String name;
    private int price;
    private String weight;
    private int count;

    // constructor
    public Product(String name, int price, String weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getWeight() {
        return weight;
    }


    public int getCount() {
        return count;
    }

    public Product setCount(int count) {
        this.count += count;
        return this;
    }
}
