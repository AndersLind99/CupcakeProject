package business.entities;

public class BasketItem {

    private String base;
    private String topping;
    private int amount;
    private int price;

    public BasketItem(String base, String topping, int amount, int price) {
        this.base = base;
        this.topping = topping;
        this.amount = amount;
        this.price = price;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
