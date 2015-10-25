package tk.iatsyk.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.iatsyk.dao.DishesDao;
import tk.iatsyk.entities.Dishes;
import tk.iatsyk.handler.DishesHandler;

import java.util.List;

/**
 * User: Vova Iatsyk
 * Date: 25.10.2015
 */
@Component
public class DishesHandlerImpl implements DishesHandler {

    @Autowired
    private DishesDao dishesDao;

    @Override
    public List<Dishes> findAllDishesByCafeId(Long cafeId) {
        return dishesDao.findAllDishesByCafeId(cafeId);
    }

}
