package tk.iatsyk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.iatsyk.repository.CafeRepository;
import tk.iatsyk.service.CafeService;

/**
 * User: Vova Iatsyk
 * Date: 17.10.2015
 */
@Service
public class CafeServiceImpl implements CafeService {

    @Autowired
    private CafeRepository cafeRepository;

    @Override
    public String getProperties() {
        return cafeRepository.getProperties();
    }

}
