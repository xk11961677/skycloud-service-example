package com.skycloud.service.member.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;


/**
 * @author
 */
@Configuration
@MapperScan(basePackages = "com.skycloud.service.member.mapper.life", sqlSessionFactoryRef = "lifeSqlSessionFactory")
public class LifeDataSourceConfig {

    @Value("${spring.datasource.druid.life.url}")
    private String url;

    @Value("${spring.datasource.druid.life.username}")
    private String user;

    @Value("${spring.datasource.druid.life.password}")
    private String password;

    @SuppressWarnings("all")
    @Bean(name = "lifeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource lifeDataSource() {
        DruidDataSource lifeDataSource = new DruidDataSource();
        lifeDataSource.setUrl(url);
        lifeDataSource.setUsername(user);
        lifeDataSource.setPassword(password);
        return lifeDataSource;
    }

    @Bean(name = "lifeDataSourceProxy")
    public DataSourceProxy lifeDataSourceProxy() {
        return new DataSourceProxy(lifeDataSource());
    }

    @Bean(name = "lifeTransactionManager")
    public DataSourceTransactionManager setTransationManager() {
        return new DataSourceTransactionManager(lifeDataSourceProxy());
    }

    @Bean(name = "lifeSqlSessionFactory")
    public SqlSessionFactory lifeSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(lifeDataSourceProxy());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/life/*.xml"));
        return bean.getObject();
    }

}
