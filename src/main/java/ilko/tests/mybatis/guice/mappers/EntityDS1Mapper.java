package ilko.tests.mybatis.guice.mappers;

import ilko.tests.mybatis.guice.entities.EntityDS1;

/**
 * Created by ILIEVI on 09.10.2015.
 */
public interface EntityDS1Mapper {

    int insert(EntityDS1 entityDS1);

    int update(EntityDS1 entityDS1);

    int deleteById(Integer id);

    EntityDS1 selectById(Integer id);
}
