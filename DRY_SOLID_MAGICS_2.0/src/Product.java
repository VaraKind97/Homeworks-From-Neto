abstract class Product {

    protected String name;
    protected int price;
    protected String weight;
    protected int count;

    public Product(String name, int price, String weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
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
