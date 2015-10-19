package tk.iatsyk.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import tk.iatsyk.repository.CafeRepository;

/**
 * User: Vova Iatsyk
 * Date: 17.10.2015
 */
@Repository
public class CafeRepositoryImpl implements CafeRepository {

    @Value("${app.program_name}")
    private String value;

    @Override
    public String getProperties() {
        return value;
    }
}
