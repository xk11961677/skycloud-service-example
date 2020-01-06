package com.skycloud.service.order.mapper;

import com.sky.framework.mybatis.MyMapper;
import com.skycloud.service.order.model.po.DataSourceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 订单表
 *
 * @author
 */
@Mapper
@Repository
public interface DatasourceMapper extends MyMapper<DataSourceEntity> {


}
