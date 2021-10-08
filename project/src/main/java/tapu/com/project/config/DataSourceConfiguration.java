package tapu.com.project.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean(name = "mysqlDatasource")
    @Primary
    public DataSource mysqlDatasource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/appdb?characterEncoding=UTF8");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("kbr.flk88");
        return dataSourceBuilder.build();
    }
}
