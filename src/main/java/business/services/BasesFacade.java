package business.services;

import business.entities.Bases;
import business.exceptions.UserException;
import business.persistence.BasesMapper;
import business.persistence.Database;

import java.util.List;

public class BasesFacade {

    private BasesMapper basesMapper;

    public BasesFacade(Database database) {
       this.basesMapper = new BasesMapper(database);
    }

    public Bases getBasesById(int id) throws UserException {

       return basesMapper.getBasesById(id);

    }

    public List<Bases> getAllBases() throws UserException {

        return basesMapper.getAllBases();

    }

}
