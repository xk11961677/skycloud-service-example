package com.skycloud.service.member.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
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
@MapperScan(basePackages = "com.skycloud.service.member.mapper.member", sqlSessionFactoryRef = "memberSqlSessionFactory")
public class MemberDataSourceConfig {

    @Value("${spring.datasource.druid.member.url}")
    private String url;

    @Value("${spring.datasource.druid.member.username}")
    private String user;

    @Value("${spring.datasource.druid.member.password}")
    private String password;

    @SuppressWarnings("all")
    @Bean(name = "memberDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource memberDataSource() {
        DruidDataSource memberDataSource = new DruidDataSource();
        memberDataSource.setUrl(url);
        memberDataSource.setUsername(user);
        memberDataSource.setPassword(password);
        return memberDataSource;
    }

    @Bean(name = "memberDataSourceProxy")
    public DataSourceProxy memberDataSourceProxy() {
        return new DataSourceProxy(memberDataSource());
    }

    @Bean(name = "memberTransactionManager")
    public DataSourceTransactionManager setTransationManager() {
        return new DataSourceTransactionManager(memberDataSourceProxy());
    }

    @Bean(name = "memberSqlSessionFactory")
    public SqlSessionFactory memberSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(memberDataSourceProxy());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/member/*.xml"));
        return bean.getObject();
    }

}
