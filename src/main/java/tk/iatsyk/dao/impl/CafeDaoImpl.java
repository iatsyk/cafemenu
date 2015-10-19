package tk.iatsyk.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import tk.iatsyk.dao.CafeDao;
import tk.iatsyk.entities.Cafe;

/**
 * @author Vova Iatsyk
 *         Date: 10/19/15
 */
@Repository
public class CafeDaoImpl implements CafeDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Override
    public long save(Cafe cafe) {
        return (Long) hibernateTemplate.save(cafe);
    }

    @Override
    public void update(Cafe cafe) {
        hibernateTemplate.update(cafe);
    }

    @Override
    public void delete(Cafe cafe) {
        hibernateTemplate.delete(cafe);
    }

    @Override
    public Cafe findById(long cafeId) {
        return hibernateTemplate.get(Cafe.class, cafeId);
    }

}
