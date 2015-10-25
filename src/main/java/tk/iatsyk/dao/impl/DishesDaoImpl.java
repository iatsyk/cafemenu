package tk.iatsyk.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.iatsyk.dao.DishesDao;
import tk.iatsyk.entities.Dishes;

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
    public long save(Dishes dishes) {
        return (Long) hibernateTemplate.save(dishes);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Dishes dishes) {
        hibernateTemplate.update(dishes);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Dishes dishes) {
        hibernateTemplate.delete(dishes);
    }

    @Override
    public Dishes findById(long dishesId) {
        return hibernateTemplate.get(Dishes.class, dishesId);
    }

    @Override
    public List<Dishes> findAllDishesByCafeId(Long cafeId) {
        List dishes = hibernateTemplate.findByNamedQueryAndNamedParam("findAllDishesByCafeId", "cafeId", cafeId);
        if (CollectionUtils.isEmpty(dishes)) {
            return new ArrayList<>();
        }
        return dishes;
    }
}
