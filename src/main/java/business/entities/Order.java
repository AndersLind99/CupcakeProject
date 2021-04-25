package business.entities;

public class Order {

   private int order_id;
   private int user_id;
   private int price;
   private String date;

    public Order(int order_id, int user_id, int price, String date) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.price = price;
        this.date = date;
    }

    public Order(int user_id, int price) {
        this.user_id = user_id;
        this.price = price;

    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

}
