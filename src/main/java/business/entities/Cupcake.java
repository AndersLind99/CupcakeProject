package business.entities;

public class Cupcake {

    private int cupcake_id;
    private int order_id;
    private int toppings_id;
    private int bases_id;
    private int quantity;
    private int sum;

    public Cupcake(int cupcake_id, int order_id, int toppings_id, int bases_id, int quantity, int sum) {
        this.cupcake_id = cupcake_id;
        this.order_id = order_id;
        this.toppings_id = toppings_id;
        this.bases_id = bases_id;
        this.quantity = quantity;
        this.sum = sum;
    }

    public Cupcake(int order_id, int toppings_id, int bases_id, int quantity, int sum) {
        this.order_id = order_id;
        this.toppings_id = toppings_id;
        this.bases_id = bases_id;
        this.quantity = quantity;
        this.sum = sum;
    }

    public int getCupcake_id() {
        return cupcake_id;
    }

    public void setCupcake_id(int cupcake_id) {
        this.cupcake_id = cupcake_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getToppings_id() {
        return toppings_id;
    }

    public void setToppings_id(int toppings_id) {
        this.toppings_id = toppings_id;
    }

    public int getBases_id() {
        return bases_id;
    }

    public void setBases_id(int bases_id) {
        this.bases_id = bases_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
