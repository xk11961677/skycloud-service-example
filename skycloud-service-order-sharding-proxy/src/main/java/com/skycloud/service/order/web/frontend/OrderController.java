package com.skycloud.service.order.web.frontend;


import com.skycloud.service.order.model.domain.Order;
import com.skycloud.service.order.service.OrderService;
import com.sky.framework.model.dto.MessageRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * 订单相关接口
 *
 * @author
 */
@RestController
@AllArgsConstructor
@RequestMapping("/order")
@Api(value = "WEB - OrderController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderController {

    @Resource
    private OrderService orderService;


    @ApiOperation(value = "增加")
    @PostMapping("/orderList")
    public MessageRes<Boolean> add() {
        Order order = new Order();
        order.setAmount(new BigDecimal("1.01"));
        order.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        order.setUserid(1);
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        orderService.save(order);
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
