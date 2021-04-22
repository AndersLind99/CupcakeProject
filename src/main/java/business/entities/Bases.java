package business.entities;


public class Bases {

    private int bases_id;
    private String name;
    private int price;

    public Bases(int bases_id, String name, int price) {
        this.bases_id = bases_id;
        this.name = name;
        this.price = price;
    }

    public int getBases_id() {
        return bases_id;
    }

    public void setBases_id(int bases_id) {
        this.bases_id = bases_id;
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
