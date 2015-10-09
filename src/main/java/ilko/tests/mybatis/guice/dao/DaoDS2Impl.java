package ilko.tests.mybatis.guice.dao;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import ilko.tests.mybatis.guice.entities.EntityDS2;
import ilko.tests.mybatis.guice.mappers.EntityDS2Mapper;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by ILIEVI on 09.10.2015.
 */
public class DaoDS2Impl implements DaoDS2 {

    private static final Class<EntityDS2Mapper> MAPPER = EntityDS2Mapper.class;
    @Inject
    @Named("DS2")
    private SqlSession sqlSession;

    @Override
    public int insert(EntityDS2 entityDS2) {
        return getMapper().insert(entityDS2);
    }

    @Override
    public int update(EntityDS2 entityDS2) {
        return getMapper().update(entityDS2);
    }

    @Override
    public int delete(Integer id) {
        return getMapper().deleteById(id);
    }

    @Override
    public EntityDS2 selectById(Integer id) {
        return getMapper().selectById(id);
    }

    private EntityDS2Mapper getMapper() {
        return sqlSession.getMapper(MAPPER);
    }
}
