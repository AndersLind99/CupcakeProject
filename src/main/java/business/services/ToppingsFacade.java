package business.services;

import business.entities.Toppings;
import business.exceptions.UserException;
import business.persistence.BasesMapper;
import business.persistence.Database;
import business.persistence.ToppingsMapper;

import java.util.List;

public class ToppingsFacade {

    private ToppingsMapper toppingsMapper;

    public ToppingsFacade(Database database) {
        this.toppingsMapper = new ToppingsMapper(database);
    }

    public Toppings getToppingsById(int id) throws UserException {

        return toppingsMapper.getToppingsById(id);

    }

    public List<Toppings> getAllToppings() throws UserException {

       return toppingsMapper.getAllToppings();

    }

}
