package business.services;

import business.entities.Bases;
import business.entities.BasketItem;
import business.entities.Toppings;
import business.exceptions.UserException;
import business.persistence.BasesMapper;
import business.persistence.Database;

import java.util.ArrayList;
import java.util.List;

public class ShopCalc {


    private BasesFacade basesFacade;
    private ToppingsFacade toppingsFacade;

    List<BasketItem> basketItemList = new ArrayList<>();

    public ShopCalc(Database database) {

        this.basesFacade = new BasesFacade(database);
        this.toppingsFacade = new ToppingsFacade(database);

    }

    private int getBasePrice(String name) throws UserException {
        int basePrice = 0;
        List<Bases> basesList = this.basesFacade.getAllBases();

        for (Bases bases : basesList) {

            if (bases.getName().equals(name)) {

                basePrice = bases.getPrice();
                break;
            }
        }

        return basePrice;
    }

    private int getToppingsPrice(String name) throws UserException {
        int toppingsPrice = 0;
        List<Toppings> toppingsList = this.toppingsFacade.getAllToppings();

        for (Toppings toppings : toppingsList) {

            if (toppings.getName().equals(name)) {

                toppingsPrice = toppings.getPrice();
                break;
            }
        }

        return toppingsPrice;
    }

    public int totalPrice(String bottom, String topping, int amount) throws UserException {

        int totalPrice = 0;


        totalPrice = getBasePrice(bottom) + getToppingsPrice(topping) * amount;

        return totalPrice;
    }

    public List<BasketItem> addToBasket(String bottom, String topping, int amount, int price) {

        basketItemList.add(new BasketItem(bottom, topping, amount, price));

        return basketItemList;
    }


}
