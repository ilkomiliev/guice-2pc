package ilko.tests.mybatis.guice.dao;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import ilko.tests.mybatis.guice.entities.EntityDS1;
import ilko.tests.mybatis.guice.mappers.EntityDS1Mapper;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by ILIEVI on 09.10.2015.
 */
public class DaoDS1Impl implements DaoDS1 {

    private static final Class<EntityDS1Mapper> MAPPER = EntityDS1Mapper.class;
    @Inject
    @Named("DS1")
    private SqlSession sqlSession;

    @Override
    public int insert(EntityDS1 entityDS1) {
        return getMapper().insert(entityDS1);
    }

    @Override
    public int update(EntityDS1 entityDS1) {
        return getMapper().update(entityDS1);
    }

    @Override
    public int delete(Integer id) {
        return getMapper().deleteById(id);
    }

    @Override
    public EntityDS1 selectById(Integer id) {
        return getMapper().selectById(id);
    }

    private EntityDS1Mapper getMapper() {
        return sqlSession.getMapper(MAPPER);
    }
}
