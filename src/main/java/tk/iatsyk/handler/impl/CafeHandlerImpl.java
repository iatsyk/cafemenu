package tk.iatsyk.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.iatsyk.dao.CafeDao;
import tk.iatsyk.entities.businessentities.Cafe;
import tk.iatsyk.entities.representationobjects.CafeRO;
import tk.iatsyk.handler.CafeHandler;
import tk.iatsyk.repository.CafeRepository;

import java.util.List;

/**
 * User: Vova Iatsyk
 * Date: 17.10.2015
 */
@Component
public class CafeHandlerImpl implements CafeHandler {

    @Autowired
    private CafeRepository cafeRepository;

    @Autowired
    private CafeDao cafeDao;

    @Override
    public String getProperties() {
        return cafeRepository.getProperties();
    }

    @Override
    public long save(Cafe cafe) {
        return cafeDao.save(cafe);
    }

    @Override
    public List<CafeRO> getAllCafes() {
        return cafeDao.getAllCafes();
    }

}
