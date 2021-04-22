package business.entities;

public class Toppings {

    private int toppings_id;
    private String name;
    private int price;

    public Toppings(int toppings_id, String name, int price) {
        this.toppings_id = toppings_id;
        this.name = name;
        this.price = price;
    }

    public int getToppings_id() {
        return toppings_id;
    }

    public void setToppings_id(int toppings_id) {
        this.toppings_id = toppings_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
