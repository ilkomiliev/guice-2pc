package ilko.tests.mybatis.guice;

import com.google.inject.*;
import com.google.inject.name.Names;
import ilko.tests.mybatis.guice.dao.DaoDS1;
import ilko.tests.mybatis.guice.dao.DaoDS1Impl;
import ilko.tests.mybatis.guice.dao.DaoDS2;
import ilko.tests.mybatis.guice.dao.DaoDS2Impl;
import ilko.tests.mybatis.guice.services.SuperService;
import ilko.tests.mybatis.guice.services.SuperServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.session.SqlSessionManagerProvider;

/**
 * Created by ILIEVI on 09.10.2015.
 */
public class BootClass {

    private static Injector injector;

    public static Injector getInjector() {
        if (injector == null) {
            createInjector();
        }
        return injector;
    }

    private static void createInjector() {
        injector = Guice.createInjector(new PrivateModule() {
            @Override
            protected void configure() {
                install(new XMLMyBatisModule() {
                    @Override
                    protected void initialize() {
                        setEnvironmentId("dev");
                        setClassPathResource("mybatis-config-ds1.xml");
                    }
                });

                bind(SqlSession.class).annotatedWith(Names.named("DS1")).toProvider(SqlSessionManagerProvider.class).in(Scopes.SINGLETON);
                expose(SqlSession.class).annotatedWith(Names.named("DS1"));
            }
        }, new PrivateModule() {
            @Override
            protected void configure() {
                install(new XMLMyBatisModule() {
                    @Override
                    protected void initialize() {
                        setEnvironmentId("dev");
                        setClassPathResource("mybatis-config-ds2.xml");
                    }
                });

                bind(SqlSession.class).annotatedWith(Names.named("DS2")).toProvider(SqlSessionManagerProvider.class).in(Scopes.SINGLETON);
                expose(SqlSession.class).annotatedWith(Names.named("DS2"));
            }
        }, new AbstractModule() {
            @Override
            protected void configure() {
                bind(DaoDS1.class).to(DaoDS1Impl.class).in(Scopes.SINGLETON);
                bind(DaoDS2.class).to(DaoDS2Impl.class).in(Scopes.SINGLETON);
                bind(SuperService.class).to(SuperServiceImpl.class).in(Scopes.SINGLETON);
            }
        });
    }


}
