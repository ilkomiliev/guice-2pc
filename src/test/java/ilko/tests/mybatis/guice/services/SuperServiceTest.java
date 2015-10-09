package ilko.tests.mybatis.guice.services;

import ilko.tests.mybatis.guice.BootClass;
import org.junit.Test;

/**
 * Created by ILIEVI on 09.10.2015.
 */
public class SuperServiceTest {

    @Test
    public void testSuperService() throws Exception {
        SuperService superService = getService(SuperService.class);
        System.out.format("SuperService guice: %s%n", superService);
        Integer id1 = 1;
        Integer id2 = 1;
        superService.updateTwoDatasources(id1, id2);
    }

    private static <T> T getService(Class<T> serviceClass) {
        T instance = BootClass.getInjector().getInstance(serviceClass);
        return instance;
    }

}
