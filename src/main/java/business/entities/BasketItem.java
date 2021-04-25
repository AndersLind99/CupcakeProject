package business.entities;

public class BasketItem {

    private Bases base;
    private Toppings topping;
    private int amount;

    public BasketItem(Bases base, Toppings topping, int amount) {
        this.base = base;
        this.topping = topping;
        this.amount = amount;
    }

    public int getPrice(){

        return ((topping.getPrice() + base.getPrice()) * amount);
    }

    public Bases getBase() {
        return base;
    }

    public void setBase(Bases base) {
        this.base = base;
    }

    public Toppings getTopping() {
        return topping;
    }

    public void setTopping(Toppings topping) {
        this.topping = topping;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
