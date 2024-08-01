package com.i.miniTravel.Config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:spring/db.properties")
@EnableTransactionManagement // xml에 tx:annotation 이랑 같은뜻
public class SpringConfiguration {

    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driverClassName);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml")); // Resource 잡아와야한다. classpath: 가 new ClasspathResource() 와 같다.
//        sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("mapper/userMapper.xml"));
       /* sqlSessionFactoryBean.setMapperLocations(
                new ClassPathResource("mapper/userMapper.xml"),
                new ClassPathResource("mapper/userUploadMapper.xml"));*/

//        sqlSessionFactoryBean.setTypeAliasesPackage("*.bean");

        sqlSessionFactoryBean.setMapperLocations(
                applicationContext.getResources("classpath:mapper/*Mapper.xml") // wild 카드 쓸 수 있다.
        );


        return sqlSessionFactoryBean.getObject(); // SqlSessionFactory로 변환시켜줘야한다.
    }

    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory()); // exception Throws 한 메소드 호출하려는 곳에도 똑같이 Throws 걸어줘야한다.
    }

    @Bean
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }


}
