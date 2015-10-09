package ilko.tests.mybatis.guice.services;

import com.google.inject.Inject;
import ilko.tests.mybatis.guice.dao.DaoDS1;
import ilko.tests.mybatis.guice.dao.DaoDS2;
import ilko.tests.mybatis.guice.entities.EntityDS1;
import ilko.tests.mybatis.guice.entities.EntityDS2;
import org.mybatis.guice.transactional.Transactional;

/**
 * Created by ILIEVI on 09.10.2015.
 */
public class SuperServiceImpl implements SuperService {

    @Inject
    private DaoDS1 daoDS1;

    @Inject
    private DaoDS2 daoDS2;

    @Transactional
    public void updateTwoDatasources(Integer customerId, Integer addressId) {
        EntityDS1 customer = daoDS1.selectById(addressId);
        customer.setFirstname("Test 1");
        daoDS1.update(customer);
        EntityDS2 address = daoDS2.selectById(addressId);
        address.setStreet("Somewhere on the earth street 1");
        daoDS2.update(address);
        throw new RuntimeException("rollback me!");
    }
}
