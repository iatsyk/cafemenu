package tk.iatsyk.dao;

import tk.iatsyk.entities.businessentities.Dish;
import tk.iatsyk.entities.representationobjects.DishRO;

import java.util.List;

/**
 * User: Vova Iatsyk
 * Date: 25.10.2015
 */
public interface DishesDao {

    long save(Dish dishes);

    void update(Dish dishes);

    void delete(Dish dishes);

    Dish findById(long dishesId);

    List<DishRO> findAllDishesByCafeId(Long cafeId);
}
