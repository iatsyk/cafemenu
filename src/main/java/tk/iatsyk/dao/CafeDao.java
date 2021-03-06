package tk.iatsyk.dao;

import tk.iatsyk.entities.businessentities.Cafe;
import tk.iatsyk.entities.representationobjects.CafeRO;

import java.util.List;

/**
 * @author Vova Iatsyk
 *         Date: 10/19/15
 */
public interface CafeDao {

    long save(Cafe cafe);

    void update(Cafe cafe);

    void delete(Cafe cafe);

    Cafe findById(long cafeId);

    List<CafeRO> getAllCafes();
}
