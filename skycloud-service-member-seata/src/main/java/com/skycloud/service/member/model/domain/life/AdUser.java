package com.skycloud.service.member.model.domain.life;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 会员信息表
 *
 * @author code generator
 * @date 2019-06-15 14:52:38
 */
@Data
@Table(name = "ad_user")
public class AdUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;


    /**
     * 账号使用范围 1：测试账号 2：生产账号
     */
    @Column(name = "card_range")
    private Integer cardRange;
    /**
     * 所属企业
     */
    @Column(name = "group_num")
    private Long groupNum;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别 '0' 男 ,'1' 女
     */
    private String sex;
    /**
     * 手机号
     */
    private String telephone;
    /**
     * 邮箱
     */
    private String mailbox;
    /**
     * 身份证号
     */
    @Column(name = "identity_card")
    private String identityCard;
    /**
     * 会员卡号
     */
    @Column(name = "card_number")
    private String cardNumber;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 支付密码
     */
    @Column(name = "pay_password")
    private String payPassword;
    /**
     * 可用积分账户
     */
    private BigDecimal integral;
    /**
     * 初始积分
     */
    @Column(name = "start_integral")
    private BigDecimal startIntegral;
    /**
     * 预积分账户
     */
    @Column(name = "expect_integral")
    private BigDecimal expectIntegral;
    /**
     * 支付额度
     */
    @Column(name = "line_credit")
    private BigDecimal lineCredit;
    /**
     * 账户状态  1 未激活 2 激活 3冻结 4注销
     */
    @Column(name = "is_active")
    private String isActive;
    /**
     * 激活时间
     */
    @Column(name = "active_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date activeDate;
    /**
     * 加入黑名单或冻结企业保存的上一次激活状态
     */
    @Column(name = "last_is_active")
    private String lastIsActive;
    /**
     * 支付密码开关
     */
    @Column(name = "is_pay_password")
    private String isPayPassword;
    /**
     * 会员类型  0:员工 1:家属 2:退休 3:离职  4:社会会员  5:不接受推送
     */
    private Integer type;
    /**
     * 工作状态 1：在职 2：退休 3：离职 4:家属无
     */
    @Column(name = "job_status")
    private Integer jobStatus;
    /**
     * 是否向第三方同步数据 0：不同步    1：同步
     */
    @Column(name = "data_syn")
    private String dataSyn;
    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;
    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private String delFlag;
    /**
     * 0：普通会员，1：机票代理会员，3：兜礼体验官
     */
    private Integer state;
    /**
     * 车牌号(该字段已作废)
     */
    @Column(name = "license_number")
    private String licenseNumber;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 推荐来源    0：独立会员，无推荐
     */
    @Column(name = "source_card_number")
    private String sourceCardNumber;
    /**
     * 更新时间
     */
    @Column(name = "update_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;
    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;
    /**
     * 创建时间
     */
    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    /**
     * 财富值，默认为0
     */
    private Integer wealth;


}
