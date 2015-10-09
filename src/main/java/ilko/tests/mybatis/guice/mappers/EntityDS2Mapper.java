package ilko.tests.mybatis.guice.mappers;

import ilko.tests.mybatis.guice.entities.EntityDS2;

/**
 * Created by ILIEVI on 09.10.2015.
 */
public interface EntityDS2Mapper {

    int insert(EntityDS2 entityDS2);

    int update(EntityDS2 entityDS2);

    int deleteById(Integer id);

    EntityDS2 selectById(Integer id);

}
