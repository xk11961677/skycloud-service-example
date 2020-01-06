package com.skycloud.service.order.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.skycloud.service.order.model.po.DataSourceEntity;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author
 */
@Component
public class DataSourceTemplate {
    /**
     * 获取指定数据库类型的数据库信息列表
     *
     * @return
     * @throws SQLException
     */
    public DataSource getDataSource(DataSourceEntity dataSourceEntity) throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        DataSource dataSource = buildDataSource(dataSourceEntity);

        dataSourceMap.put(dataSourceEntity.getName(), dataSource);

//        ShardingRuleConfiguration shardingRuleConfig = getShardingRuleConfiguration(map, masterSlaveDataSource, dataSourceMap);
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        Properties shardingProperties = getProperties();
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, shardingProperties);
    }


    /**
     * 获取属性配置
     *
     * @return
     */
    private Properties getProperties() {
        Properties shardingProperties = new Properties();
        shardingProperties.put("sql.show", true);
        return shardingProperties;
    }

    /**
     * 获取组装好的ShardingRuleConfiguration
     *
     * @param detailMap
     * @return
     */
    /*private ShardingRuleConfiguration getShardingRuleConfiguration(Map<String, DataSourceDetailEntity> detailMap, Map<String,
            Map<String, javax.sql.DataSource>> masterSlaveDataSource, Map<String, javax.sql.DataSource> dataSourceMap) {
        // 分片规则配置文件类
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        for (String logicTable : detailMap.keySet()) {
            DataSourceDetailEntity dataSourceDetail = detailMap.get(logicTable);
            // 表分片规则配置类
            TableRuleConfiguration ruleConfig = new TableRuleConfiguration();

            // 分表策略
            ComplexShardingStrategyConfiguration databaseShardingStrategyConfig = new ComplexShardingStrategyConfiguration(dataSourceDetail.getDatabaseShardingColumn(),
                    ModuloDatabaseShardingAlgorithm.class.getName());

            // 设置分库策略，缺省表示使用默认分库策略，即ShardingRuleConfiguration中配置的分库策略
            ruleConfig.setDatabaseShardingStrategyConfig(databaseShardingStrategyConfig);

            // 分表规则
            ruleConfig.setTableShardingStrategyConfig(new ComplexShardingStrategyConfiguration(dataSourceDetail.getShardingColumn(),
                    ModuloTableShardingAlgorithm.class.getName()));

            // 真实的数据节点
            String actualDataNodes = dataSourceDetail.getActualDataNodes();
            *//*
              1) 由数据源名 + 表名组成 以小数点分割，多个表以逗号隔开，支持inline表达式
              2) 缺省时，以已知 数据源名称和逻辑表名称生成数据节点
              3) 用于广播表 --即每个库中都需要一个同样的表进行关联查询，多为字典表
              4) 只分库不分表且所有库的表结构完全一致的情况
             *//*
            ruleConfig.setActualDataNodes(actualDataNodes);
            // 逻辑表名称
            ruleConfig.setLogicTable(logicTable);
            shardingRuleConfig.getTableRuleConfigs().add(ruleConfig);
        }

        for (String key : masterSlaveDataSource.keySet()) {
            Map<String, javax.sql.DataSource> temDatasourceMap = masterSlaveDataSource.get(key);
            MasterSlaveRuleConfiguration masterSlaveRuleConfiguration = new MasterSlaveRuleConfiguration();
            masterSlaveRuleConfiguration.setName(key);
            for (String tKey : temDatasourceMap.keySet()) {
                if (tKey.contains("master")) {
                    masterSlaveRuleConfiguration.setMasterDataSourceName(tKey);
                } else if (tKey.contains("slave")) {
                    masterSlaveRuleConfiguration.getSlaveDataSourceNames().add(tKey);
                }
                dataSourceMap.put(tKey, temDatasourceMap.get(tKey));
            }
            shardingRuleConfig.getMasterSlaveRuleConfigs().add(masterSlaveRuleConfiguration);
        }
        return shardingRuleConfig;
    }*/


    /**
     * 创建数据源
     *
     * @param dataSourceEntity
     * @return
     */
    private javax.sql.DataSource buildDataSource(DataSourceEntity dataSourceEntity) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dataSourceEntity.getDriverClass());
        dataSource.setUrl(dataSourceEntity.getUrl());
        dataSource.setUsername(dataSourceEntity.getUsername());
        dataSource.setPassword(dataSourceEntity.getPassword());
        dataSource.setMaxActive(100);
        dataSource.setInitialSize(10);
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setMaxWait(10000);
        dataSource.setValidationQuery("select 'x'");
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(80);
        return dataSource;
    }
}
