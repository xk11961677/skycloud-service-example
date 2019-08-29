package com.skycloud.service.order.web.frontend;

/**
 * @author YacoXiao
 * @date 2019-06-24
 */


import com.skycloud.service.order.model.domain.Order;
import com.skycloud.service.order.service.OrderService;
import com.sky.framework.common.LogUtils;
import com.sky.framework.model.dto.MessageRes;
import com.sky.framework.model.exception.BusinessException;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * 订单相关接口
 *
 * @author yacoXiao
 * @date 2019-06-19 14:54:09
 */
@RestController
@AllArgsConstructor
@RequestMapping("/order")
@Api(value = "WEB - OrderController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
@SuppressWarnings("all")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Autowired
    private MapperFacade mapperFacade;

    /**
     * 此处需要多次TransactionTypeHolder.set(TransactionType.BASE);
     * 可考虑增加个 mybatis-plugin 自动设置
     * @param rb
     * @return
     */
    @ApiImplicitParams({@ApiImplicitParam(name = "rb", paramType = "int")})
    @ApiOperation(value = "增加")
    @PostMapping("/orderList")
    @GlobalTransactional
    public MessageRes<Boolean> add(@RequestParam(defaultValue = "0") int rb) {
        Order order = new Order();
        order.setAmount(new BigDecimal("1.01"));
        order.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        order.setUserid(1);
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        TransactionTypeHolder.set(TransactionType.BASE);
        orderService.save(order);
        TransactionTypeHolder.set(TransactionType.BASE);
        Order order_2 = mapperFacade.map(order, Order.class);
        order_2.setAmount(new BigDecimal("2.01"));
        order_2.setId(null);
        orderService.save(order_2);
        LogUtils.info(log,"add order id:{}",order.getId());
        if(rb >0 ) {
            throw new BusinessException("global roll back");
        }
        return MessageRes.success(true);
    }


    @ApiImplicitParams({@ApiImplicitParam(name = "id", paramType = "Long")})
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public MessageRes<Boolean> update(Long id) {
        Order order = new Order();
        order.setId(id);
        order.setAmount(new BigDecimal("2.01"));
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        int update = orderService.update(order);
        return MessageRes.success(update > 0 ? true : false);
    }


    @ApiOperation(value = "查询")
    @PostMapping("/getOrders")
    public MessageRes<List<Order>> getOrders() {
        List<Order> orders = orderService.selectAll();
        return MessageRes.success(orders);
    }

}
