package tk.iatsyk.handler;

import tk.iatsyk.entities.representationobjects.DishRO;

import java.util.List;

/**
 * User: Vova Iatsyk
 * Date: 25.10.2015
 */
public interface DishesHandler {

    List<DishRO> findAllDishesByCafeId(Long cafeId);

}
