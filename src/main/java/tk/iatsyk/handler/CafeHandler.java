package tk.iatsyk.handler;

import tk.iatsyk.entities.Cafe;

import java.util.List;

/**
 * User: Vova Iatsyk
 * Date: 17.10.2015
 */
public interface CafeHandler {

    String getProperties();

    long save(Cafe cafe);

    List<Cafe> getAllCafes();
}
