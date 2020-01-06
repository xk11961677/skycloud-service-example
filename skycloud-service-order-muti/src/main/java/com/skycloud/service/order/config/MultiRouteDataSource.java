/*
 * The MIT License (MIT)
 * Copyright © 2019 <sky>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the “Software”), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.skycloud.service.order.config;

import cn.hutool.core.bean.BeanUtil;
import com.skycloud.service.order.model.po.DataSourceEntity;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 */
@Slf4j
public class MultiRouteDataSource extends AbstractRoutingDataSource implements ApplicationListener<ApplicationEvent> {

    @Autowired
    private DataSourceTemplate dataSourceTemplate;

    @Autowired
    @Qualifier("defaultDataSource")
    private HikariDataSource defaultDataSource;

    private Map<Object, Object> targetDataSources = new HashMap<>();

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContext.getDataSource();
    }


    public void dynamicInitDatasource() {
        List<DataSourceEntity> list = new ArrayList<>();
        DataSourceEntity dataSourceEntity = new DataSourceEntity();
        dataSourceEntity.setDriverClass("com.mysql.jdbc.Driver");
        dataSourceEntity.setName("1000000");
        dataSourceEntity.setUsername("root");
        dataSourceEntity.setPassword("123456");
        dataSourceEntity.setUrl("jdbc:mysql://47.96.117.253:3306/cloud?useSSL=false&characterEncoding=utf8");
        list.add(dataSourceEntity);
        DataSourceEntity dataSourceEntitySecond = new DataSourceEntity();
        BeanUtil.copyProperties(dataSourceEntity, dataSourceEntitySecond);
        dataSourceEntitySecond.setUrl("jdbc:mysql://47.96.117.253:3306/datax?useSSL=false&characterEncoding=utf8");
        list.add(dataSourceEntitySecond);

        list.forEach(db -> {
            if (targetDataSources.get(db.getName()) == null) {
                try {
                    targetDataSources.put(db.getName(), dataSourceTemplate.getDataSource(db));
                } catch (SQLException e) {
                    log.error("load datasource exception :{}", e.getMessage());
                }
            }
        });
        super.setTargetDataSources(targetDataSources);
        super.setDefaultTargetDataSource(defaultDataSource);
        super.afterPropertiesSet();
    }

    public void dynamicAddDatasource(DataSourceEntity db) {
        targetDataSources.put(db.getName(), buildDatasource(db));
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    public void dynamicRemoveDatasource(List<DataSourceEntity> list) {
        list.forEach(db -> targetDataSources.remove(db.getName()));
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    public void dynamicUpdateDatasource(DataSourceEntity db) {
        targetDataSources.remove(db.getName());
        targetDataSources.put(db.getName(), buildDatasource(db));
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        dynamicInitDatasource();
    }

    private HikariDataSource buildDatasource(DataSourceEntity db) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(db.getDriverClass());
        dataSource.setJdbcUrl(db.getUrl());
        dataSource.setUsername(db.getUsername());
        dataSource.setPassword(db.getPassword());
        return dataSource;
    }
}