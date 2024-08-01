package Chapter04_ANNO.spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:spring/db.properties")
public class SpringConfiguration {
    // 이런식으로 해도 된다.
   /* @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    private String username;
    private String password;*/

    private final Environment environment;

    public SpringConfiguration(Environment environment){
        this.environment = environment;
    }

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
        basicDataSource.setUrl(environment.getProperty("jdbc.url"));
        basicDataSource.setUsername(environment.getProperty("jdbc.username"));
        basicDataSource.setPassword(environment.getProperty("jdbc.password"));
        return basicDataSource;
    }
}
