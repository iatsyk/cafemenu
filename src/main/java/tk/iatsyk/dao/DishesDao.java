package tk.iatsyk.dao;

import tk.iatsyk.entities.Dishes;

import java.util.List;

/**
 * User: Vova Iatsyk
 * Date: 25.10.2015
 */
public interface DishesDao {

    long save(Dishes dishes);

    void update(Dishes dishes);

    void delete(Dishes dishes);

    Dishes findById(long dishesId);

    List<Dishes> findAllDishesByCafeId(Long cafeId);
}
