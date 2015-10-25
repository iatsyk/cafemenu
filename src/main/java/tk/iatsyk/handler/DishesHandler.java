package tk.iatsyk.handler;

import tk.iatsyk.entities.Dishes;

import java.util.List;

/**
 * User: Vova Iatsyk
 * Date: 25.10.2015
 */
public interface DishesHandler {

    List<Dishes> findAllDishesByCafeId(Long cafeId);

}
