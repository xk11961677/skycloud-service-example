package com.skycloud.service.order.web.frontend;


import com.sky.framework.model.dto.MessageRes;
import com.skycloud.service.order.config.DataSourceContext;
import com.skycloud.service.order.mapper.DatasourceMapper;
import com.skycloud.service.order.model.po.DataSourceEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author
 */
@RestController
@AllArgsConstructor
@RequestMapping("/order")
@Api(value = "WEB - OrderController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class OrderController {


    @Autowired
    private DatasourceMapper datasourceMapper;

    @ApiOperation(value = "查询")
    @RequestMapping("/getOrders")
    public MessageRes<List<DataSourceEntity>> getOrders() {
        DataSourceContext.setDataSource("1000000");
        List<DataSourceEntity> dataSourceEntities = datasourceMapper.selectAll();
        return MessageRes.success(dataSourceEntities);
    }

}
