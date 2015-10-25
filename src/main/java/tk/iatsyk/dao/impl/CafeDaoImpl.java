package tk.iatsyk.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.iatsyk.dao.CafeDao;
import tk.iatsyk.entities.Cafe;

import java.util.List;

/**
 * @author Vova Iatsyk
 *         Date: 10/19/15
 */
@Repository
@Transactional(readOnly = true)
public class CafeDaoImpl implements CafeDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Override
    @Transactional(readOnly = false)
    public long save(Cafe cafe) {
        return (Long) hibernateTemplate.save(cafe);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Cafe cafe) {
        hibernateTemplate.update(cafe);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Cafe cafe) {
        hibernateTemplate.delete(cafe);
    }

    @Override
    public Cafe findById(long cafeId) {
        return hibernateTemplate.get(Cafe.class, cafeId);
    }

    @Override
    public List<Cafe> getAllCafes() {
        return hibernateTemplate.loadAll(Cafe.class);
    }

}
