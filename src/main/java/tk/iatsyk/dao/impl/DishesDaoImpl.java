package tk.iatsyk.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.iatsyk.dao.DishesDao;
import tk.iatsyk.entities.businessentities.Dish;
import tk.iatsyk.entities.representationobjects.DishRO;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Vova Iatsyk
 * Date: 25.10.2015
 */
@Repository
@Transactional(readOnly = true)
public class DishesDaoImpl implements DishesDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(readOnly = false)
    public long save(Dish dishes) {
        return (Long) hibernateTemplate.save(dishes);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Dish dishes) {
        hibernateTemplate.update(dishes);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Dish dishes) {
        hibernateTemplate.delete(dishes);
    }

    @Override
    public Dish findById(long dishesId) {
        return hibernateTemplate.get(Dish.class, dishesId);
    }

    @Override
    public List<DishRO> findAllDishesByCafeId(Long cafeId) {
        List dishes = hibernateTemplate.findByNamedQueryAndNamedParam("findAllDishesByCafeId", "cafeId", cafeId);
        if (CollectionUtils.isEmpty(dishes)) {
            return new ArrayList<>();
        }
        return DishRO.parseDishes(dishes);
    }
}
