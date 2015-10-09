package ilko.tests.mybatis.guice.dao;

import ilko.tests.mybatis.guice.entities.EntityDS2;

/**
 * Created by ILIEVI on 09.10.2015.
 */
public interface DaoDS2 {

    int insert(EntityDS2 entityDS2);

    int update(EntityDS2 entityDS2);

    int delete(Integer id);

    EntityDS2 selectById(Integer id);
}
