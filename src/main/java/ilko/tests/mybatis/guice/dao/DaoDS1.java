package ilko.tests.mybatis.guice.dao;

import ilko.tests.mybatis.guice.entities.EntityDS1;

/**
 * Created by ILIEVI on 09.10.2015.
 */
public interface DaoDS1 {

    int insert(EntityDS1 entityDS1);

    int update(EntityDS1 entityDS1);

    int delete(Integer id);

    EntityDS1 selectById(Integer id);
}
