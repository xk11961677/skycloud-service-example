package com.skycloud.service.order.model.domain;


import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * 订单表
 *
 * @author yacoXiao
 * @date 2019-06-18 14:07:48
 */
@Data
@Table(name = "_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @JSONField(serializeUsing = ToStringSerializer.class)
//    @KeySql(genId = SimpleGenId.class)
    private Long id;

    /**
     * 用户id
     */
    private Integer userid;
    /**
     * 用户id
     */
    @Column(name = "orderUserId")
    private Integer orderUserId;
    /**
     * 商家id
     */
    @Column(name = "bussinessId")
    private String bussinessId;
    /**
     * 商家门店或设备编号
     */
    @Column(name = "storesId")
    private String storesId;
    /**
     * 支付密码
     */
    @Column(name = "payPassword")
    private String payPassword;
    /**
     * 用户的短信验证码或优惠券码
     */
    @Column(name = "verificationCode")
    private String verificationCode;
    /**
     * 实付金额
     */
    private BigDecimal amount;
    /**
     * 实付总金额
     */
    @Column(name = "totalAmount")
    private BigDecimal totalAmount;
    /**
     * 应付金额
     * 订单金额（折扣前的金额）
     * 订单金额（折扣前的金额）
     * 订单金额（折扣前的金额）
     * 订单金额（折扣前的金额）
     */
    private BigDecimal price;
    /**
     * 应付总金额
     */
    @Column(name = "totalPrice")
    private BigDecimal totalPrice;
    /**
     * 0:宝钢积分 非积分部分需明确具体支付方式，1:非积分（商家无法区分） 2：现金 3：微信支付 4：银行卡[借记卡、信用卡]、5：商家积分 6：支付宝支付 7：京东支付 8：唯品支付 9：其它 12:工银e支付 13 银联支付
     */
    @Column(name = "payType")
    private Integer payType;
    /**
     * 商家订单号
     */
    @Column(name = "orderNumber")
    private String orderNumber;
    /**
     * 商家交易流水号
     */
    @Column(name = "serialNumber")
    private String serialNumber;
    /**
     * 订单发生时间(0000-00-00 00:00:00)
     */
    @Column(name = "orderDate")
    private Timestamp orderDate;
    /**
     * 换货订单号关联对应的源销售订单号
     */
    @Column(name = "originOrderNumber")
    private String originOrderNumber;
    /**
     * 订单完成状态:0:未完成 1:已完成
     */
    private Integer state;
    /**
     * 交易类型 0:收入 1:支出 2:兜礼收银台
     */
    @Column(name = "orderType")
    private Integer orderType;
    /**
     * 交易阶段（0：短信验证码确认        1：完成订单    2:积分支付阶段     3:平台充值     4:返利     5:退货返积分     6：交易被取消     7:商家下单未支付    8:商家下单未支付订单被取消(0元订单作废) 9:券码核销订单 10:反核销订单）11:审核不通过(针对商家平台退货申请)
     */
    private Integer type;
    /**
     * 订单来源   0:机票个人      1：机票分销商       2：合作商家     3：睿渠平台
     */
    private Integer source;
    /**
     * 需要支付密码 0:不需要 1:需要
     */
    @Column(name = "isPayPassword")
    private Integer isPayPassword;
    /**
     * 订单明细原始数据
     */
    @Column(name = "orderDetail")
    private String orderDetail;
    /**
     * 是否返利   0：尚进行      1：已经返佣       2:已经返利
     */
    @Column(name = "isRebate")
    private Integer isRebate;
    /**
     * 预积分商家返佣数量
     */
    @Column(name = "BusinessRebate")
    private BigDecimal businessRebate;
    /**
     * 会员返利数量
     */
    @Column(name = "UserRebate")
    private BigDecimal userRebate;
    /**
     * 创建时间
     */
    @Column(name = "createDateTime")
    private Timestamp createDateTime;
    /**
     * 对账状态（0:未对账，1:已对账）
     */
    @Column(name = "check_state")
    private Integer checkState;
    /**
     * 收银机编号
     */
    @Column(name = "cash_number")
    private String cashNumber;
    /**
     * 大订单编号
     */
    @Column(name = "big_order_number")
    private String bigOrderNumber;

}
