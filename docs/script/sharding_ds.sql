/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 127.0.0.1
 Source Database       : sharding_ds

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 08/29/2019 19:46:03 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `_order_0`
-- ----------------------------
DROP TABLE IF EXISTS `_order_0`;
CREATE TABLE `_order_0` (
  `id` bigint(20) NOT NULL,
  `userid` int(20) DEFAULT '0' COMMENT '用户id',
  `orderUserId` int(11) DEFAULT NULL COMMENT '用户id',
  `bussinessId` varchar(60) DEFAULT NULL COMMENT '商家id',
  `storesId` varchar(20) DEFAULT NULL COMMENT '商家门店或设备编号',
  `payPassword` varchar(20) DEFAULT NULL COMMENT '支付密码',
  `verificationCode` varchar(60) DEFAULT NULL COMMENT '用户的短信验证码或优惠券码',
  `amount` decimal(15,2) DEFAULT NULL COMMENT '实付金额',
  `totalAmount` decimal(10,2) DEFAULT '0.00' COMMENT '实付总金额',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '应付金额\r\n订单金额（折扣前的金额）\r\n订单金额（折扣前的金额）\r\n订单金额（折扣前的金额）\r\n订单金额（折扣前的金额）',
  `totalPrice` decimal(10,2) DEFAULT '0.00' COMMENT '应付总金额',
  `payType` int(11) DEFAULT NULL COMMENT '0:宝钢积分 非积分部分需明确具体支付方式，1:非积分（商家无法区分） 2：现金 3：微信支付 4：银行卡[借记卡、信用卡]、5：商家积分 6：支付宝支付 7：京东支付 8：唯品支付 9：其它 12:工银e支付 13 银联支付 15 建行龙卡支付',
  `orderNumber` varchar(100) DEFAULT NULL COMMENT '商家订单号',
  `serialNumber` varchar(100) DEFAULT NULL COMMENT '商家交易流水号',
  `orderDate` datetime DEFAULT NULL COMMENT '订单发生时间(0000-00-00 00:00:00)',
  `originOrderNumber` varchar(100) DEFAULT NULL COMMENT '换货订单号关联对应的源销售订单号',
  `state` int(11) DEFAULT '0' COMMENT '订单完成状态:0:未完成 1:已完成',
  `orderType` int(11) DEFAULT NULL COMMENT '交易类型 0:收入 1:支出 2:兜礼收银台',
  `type` int(11) DEFAULT NULL COMMENT '交易阶段（0：短信验证码确认        1：完成订单    2:积分支付阶段     3:平台充值     4:返利     5:退货返积分     6：交易被取消     7:商家下单未支付    8:商家下单未支付订单被取消(0元订单作废) 9:券码核销订单 10:反核销订单）11:审核不通过(针对商家平台退货申请)',
  `source` int(11) DEFAULT '0' COMMENT '订单来源   0:机票个人      1：机票分销商       2：合作商家     3：睿渠平台    ',
  `isPayPassword` int(11) DEFAULT NULL COMMENT '需要支付密码 0:不需要 1:需要',
  `orderDetail` text COMMENT '订单明细原始数据',
  `isRebate` int(11) NOT NULL DEFAULT '0' COMMENT '是否返利   0：尚进行      1：已经返佣       2:已经返利   ',
  `BusinessRebate` decimal(65,10) NOT NULL DEFAULT '0.0000000000' COMMENT '预积分商家返佣数量',
  `UserRebate` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员返利数量',
  `createDateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `check_state` tinyint(1) DEFAULT '0' COMMENT '对账状态（0:未对账，1:已对账）',
  `cash_number` varchar(500) DEFAULT NULL COMMENT '收银机编号',
  `big_order_number` varchar(50) DEFAULT '0' COMMENT '大订单编号',
  PRIMARY KEY (`id`),
  KEY `_order_bussinessId_index` (`bussinessId`) USING BTREE,
  KEY `_order_userid_index` (`userid`) USING BTREE,
  KEY `_order_orderNumber_index` (`orderNumber`) USING BTREE,
  KEY `_order_payType_index` (`payType`) USING BTREE,
  KEY `_order_type_index` (`type`) USING BTREE,
  KEY `_order_orderDate_index` (`orderDate`) USING BTREE,
  KEY `_order_storesId_index` (`storesId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `_order_0`
-- ----------------------------
BEGIN;
INSERT INTO `_order_0` VALUES ('373892280480149504', '1', null, null, null, null, null, '2.01', '0.00', '0.00', '0.00', null, null, null, '2019-08-29 17:54:25', null, '0', null, null, '0', null, null, '0', '0.0000000000', '0.00', '2019-08-29 17:54:25', '0', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `_order_1`
-- ----------------------------
DROP TABLE IF EXISTS `_order_1`;
CREATE TABLE `_order_1` (
  `id` bigint(20) NOT NULL,
  `userid` int(20) DEFAULT '0' COMMENT '用户id',
  `orderUserId` int(11) DEFAULT NULL COMMENT '用户id',
  `bussinessId` varchar(60) DEFAULT NULL COMMENT '商家id',
  `storesId` varchar(20) DEFAULT NULL COMMENT '商家门店或设备编号',
  `payPassword` varchar(20) DEFAULT NULL COMMENT '支付密码',
  `verificationCode` varchar(60) DEFAULT NULL COMMENT '用户的短信验证码或优惠券码',
  `amount` decimal(15,2) DEFAULT NULL COMMENT '实付金额',
  `totalAmount` decimal(10,2) DEFAULT '0.00' COMMENT '实付总金额',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '应付金额\r\n订单金额（折扣前的金额）\r\n订单金额（折扣前的金额）\r\n订单金额（折扣前的金额）\r\n订单金额（折扣前的金额）',
  `totalPrice` decimal(10,2) DEFAULT '0.00' COMMENT '应付总金额',
  `payType` int(11) DEFAULT NULL COMMENT '0:宝钢积分 非积分部分需明确具体支付方式，1:非积分（商家无法区分） 2：现金 3：微信支付 4：银行卡[借记卡、信用卡]、5：商家积分 6：支付宝支付 7：京东支付 8：唯品支付 9：其它 12:工银e支付 13 银联支付 15 建行龙卡支付',
  `orderNumber` varchar(100) DEFAULT NULL COMMENT '商家订单号',
  `serialNumber` varchar(100) DEFAULT NULL COMMENT '商家交易流水号',
  `orderDate` datetime DEFAULT NULL COMMENT '订单发生时间(0000-00-00 00:00:00)',
  `originOrderNumber` varchar(100) DEFAULT NULL COMMENT '换货订单号关联对应的源销售订单号',
  `state` int(11) DEFAULT '0' COMMENT '订单完成状态:0:未完成 1:已完成',
  `orderType` int(11) DEFAULT NULL COMMENT '交易类型 0:收入 1:支出 2:兜礼收银台',
  `type` int(11) DEFAULT NULL COMMENT '交易阶段（0：短信验证码确认        1：完成订单    2:积分支付阶段     3:平台充值     4:返利     5:退货返积分     6：交易被取消     7:商家下单未支付    8:商家下单未支付订单被取消(0元订单作废) 9:券码核销订单 10:反核销订单）11:审核不通过(针对商家平台退货申请)',
  `source` int(11) DEFAULT '0' COMMENT '订单来源   0:机票个人      1：机票分销商       2：合作商家     3：睿渠平台    ',
  `isPayPassword` int(11) DEFAULT NULL COMMENT '需要支付密码 0:不需要 1:需要',
  `orderDetail` text COMMENT '订单明细原始数据',
  `isRebate` int(11) NOT NULL DEFAULT '0' COMMENT '是否返利   0：尚进行      1：已经返佣       2:已经返利   ',
  `BusinessRebate` decimal(65,10) NOT NULL DEFAULT '0.0000000000' COMMENT '预积分商家返佣数量',
  `UserRebate` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员返利数量',
  `createDateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `check_state` tinyint(1) DEFAULT '0' COMMENT '对账状态（0:未对账，1:已对账）',
  `cash_number` varchar(500) DEFAULT NULL COMMENT '收银机编号',
  `big_order_number` varchar(50) DEFAULT '0' COMMENT '大订单编号',
  PRIMARY KEY (`id`),
  KEY `_order_bussinessId_index` (`bussinessId`) USING BTREE,
  KEY `_order_userid_index` (`userid`) USING BTREE,
  KEY `_order_orderNumber_index` (`orderNumber`) USING BTREE,
  KEY `_order_payType_index` (`payType`) USING BTREE,
  KEY `_order_type_index` (`type`) USING BTREE,
  KEY `_order_orderDate_index` (`orderDate`) USING BTREE,
  KEY `_order_storesId_index` (`storesId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `_order_1`
-- ----------------------------
BEGIN;
INSERT INTO `_order_1` VALUES ('373892275795111937', '1', null, null, null, null, null, '1.01', '0.00', '0.00', '0.00', null, null, null, '2019-08-29 17:54:25', null, '0', null, null, '0', null, null, '0', '0.0000000000', '0.00', '2019-08-29 17:54:25', '0', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `ad_order_detail_0`
-- ----------------------------
DROP TABLE IF EXISTS `ad_order_detail_0`;
CREATE TABLE `ad_order_detail_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `order_report_id` bigint(20) NOT NULL COMMENT '订单报表编号',
  `category_id` varchar(64) NOT NULL COMMENT '商品品类',
  `code` varchar(100) DEFAULT NULL COMMENT '商品编号',
  `goods` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '实收价格',
  `price` decimal(10,2) DEFAULT NULL COMMENT '应收价格',
  `number` decimal(11,2) DEFAULT NULL COMMENT '数量',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `tax` decimal(10,0) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `sku` varchar(255) DEFAULT NULL,
  `product_sku_id` varchar(45) DEFAULT NULL COMMENT '主要作用,如果用户有未支付的SKU, 用户不能创建相同SKU的订单',
  `ret_code` varchar(10) DEFAULT NULL COMMENT '充值平台返回状态code',
  `ret_msg` varchar(200) DEFAULT NULL COMMENT '充值平台返回msg',
  `ret_state` varchar(10) DEFAULT NULL COMMENT '充值平台处理状态',
  `card_oid` varchar(200) DEFAULT NULL COMMENT '充值平台订单号',
  `card_code` varchar(200) DEFAULT NULL COMMENT '充值卡号',
  `card_pass` varchar(200) DEFAULT NULL COMMENT '充值密码',
  `product_img` varchar(200) DEFAULT NULL COMMENT '商品主图链接',
  `external_number` varchar(200) DEFAULT NULL,
  `duihuan_url` varchar(500) DEFAULT NULL COMMENT '虚拟产品兑换地址',
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`) USING BTREE,
  KEY `order_report_id` (`order_report_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表';

-- ----------------------------
--  Table structure for `ad_order_detail_1`
-- ----------------------------
DROP TABLE IF EXISTS `ad_order_detail_1`;
CREATE TABLE `ad_order_detail_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `order_report_id` bigint(20) NOT NULL COMMENT '订单报表编号',
  `category_id` varchar(64) NOT NULL COMMENT '商品品类',
  `code` varchar(100) DEFAULT NULL COMMENT '商品编号',
  `goods` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '实收价格',
  `price` decimal(10,2) DEFAULT NULL COMMENT '应收价格',
  `number` decimal(11,2) DEFAULT NULL COMMENT '数量',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `tax` decimal(10,0) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `sku` varchar(255) DEFAULT NULL,
  `product_sku_id` varchar(45) DEFAULT NULL COMMENT '主要作用,如果用户有未支付的SKU, 用户不能创建相同SKU的订单',
  `ret_code` varchar(10) DEFAULT NULL COMMENT '充值平台返回状态code',
  `ret_msg` varchar(200) DEFAULT NULL COMMENT '充值平台返回msg',
  `ret_state` varchar(10) DEFAULT NULL COMMENT '充值平台处理状态',
  `card_oid` varchar(200) DEFAULT NULL COMMENT '充值平台订单号',
  `card_code` varchar(200) DEFAULT NULL COMMENT '充值卡号',
  `card_pass` varchar(200) DEFAULT NULL COMMENT '充值密码',
  `product_img` varchar(200) DEFAULT NULL COMMENT '商品主图链接',
  `external_number` varchar(200) DEFAULT NULL,
  `duihuan_url` varchar(500) DEFAULT NULL COMMENT '虚拟产品兑换地址',
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`) USING BTREE,
  KEY `order_report_id` (`order_report_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表';

-- ----------------------------
--  Table structure for `ad_order_report_0`
-- ----------------------------
DROP TABLE IF EXISTS `ad_order_report_0`;
CREATE TABLE `ad_order_report_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `order_id` bigint(100) NOT NULL COMMENT '订单编号',
  `bussiness_id` bigint(20) NOT NULL COMMENT '商户编号',
  `user_id` bigint(20) NOT NULL COMMENT '会员编号',
  `order_number` varchar(100) DEFAULT NULL COMMENT '商户订单号',
  `stores_id` varchar(100) DEFAULT NULL COMMENT '商户门店或设备编号',
  `total_mount` decimal(65,2) DEFAULT NULL COMMENT '实付总金额',
  `total_price` decimal(65,2) DEFAULT NULL COMMENT '应付总金额',
  `order_date` datetime DEFAULT NULL COMMENT '订单发生时间',
  `state` char(1) DEFAULT '0' COMMENT '订单完成状态：0 未支付(进行中)   1已支付 2取消 ',
  `type` smallint(2) DEFAULT NULL COMMENT '交易阶段 1：完成订单    5：退货订单, 自营订单状态(10:待付款,20:待发货,30已发货,40已收货,50确认收货,99交易取消, 交易完成和退款使用原来状态1,5)',
  `is_user_rebate` char(1) NOT NULL DEFAULT '1' COMMENT '是否返利 0:是   1：否',
  `user_rebate` decimal(65,2) DEFAULT '0.00' COMMENT '预积分返还数量',
  `user_return_amount` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '返还积分数量',
  `is_business_rebate` char(1) NOT NULL DEFAULT '0' COMMENT '是否返佣 0:否   1：是',
  `business_rebate_amount` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '预返佣金额',
  `billing_state` char(1) DEFAULT '0' COMMENT '对账状态： 0 未对账 1 对账结束',
  `del_flag_user` char(1) DEFAULT '0' COMMENT 'A系统用户控制删除按钮',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `is_first` int(1) NOT NULL DEFAULT '0' COMMENT '是否首单,0:不是，1：是',
  `is_source` int(11) DEFAULT '0' COMMENT '订单来源   0:机票个人      1：机票分销商       2：合作商家     3：睿渠平台',
  `first_count` int(11) DEFAULT '0' COMMENT '首单优惠人数',
  `air_settle_accounts` decimal(10,2) DEFAULT '0.00' COMMENT '机票结算金额',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `consignee_name` varchar(50) DEFAULT NULL COMMENT '实物或者虚拟接收人名姓名',
  `consignee_mobile` varchar(15) DEFAULT NULL COMMENT '实物或者虚拟商品接收手机号',
  `consignee_addr` varchar(100) DEFAULT NULL COMMENT '接收人地址',
  `product_type` int(4) DEFAULT NULL COMMENT '商品类型(1.实体卡券 2.电子卡券 3.话费充值 4.流量充值 5.旅游卡, 6.自营卡券, 7.兜礼话费特惠 参考:ad_self_product_type)',
  `product_id` bigint(20) DEFAULT NULL COMMENT '目前的作用是,如果用户有未支付的订单, 对同一种SKU的商品不能多次下单',
  `act_type` varchar(50) DEFAULT NULL COMMENT '活动类型. COMMON: 普通订单, JCHD: 机场活动订单',
  `service_charge` decimal(10,2) DEFAULT '0.00' COMMENT '服务费',
  `voucher` decimal(10,2) DEFAULT '0.00' COMMENT '优惠券金额',
  `coupon_id` varchar(45) DEFAULT NULL COMMENT '抵扣券ID',
  `support_pay_type` varchar(45) DEFAULT NULL COMMENT '1:积分,2:微信, 3.支付宝; 多个以逗号分割',
  `big_order_number` varchar(50) DEFAULT '0' COMMENT '大订单编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `aor_order_id_index` (`order_id`) USING BTREE,
  KEY `aor_bussiness_id_index` (`bussiness_id`) USING BTREE,
  KEY `aor_user_id_index` (`user_id`) USING BTREE,
  KEY `aor_order_number_index` (`order_number`) USING BTREE,
  KEY `aor_type_index` (`type`) USING BTREE,
  KEY `aor_del_flag_index` (`del_flag`) USING BTREE,
  KEY `aor_order_date_index` (`order_date`) USING BTREE,
  KEY `aor_order_big_index` (`big_order_number`) USING BTREE,
  KEY `unit_test` (`order_number`,`order_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单报表';

-- ----------------------------
--  Table structure for `ad_order_report_1`
-- ----------------------------
DROP TABLE IF EXISTS `ad_order_report_1`;
CREATE TABLE `ad_order_report_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `order_id` bigint(100) NOT NULL COMMENT '订单编号',
  `bussiness_id` bigint(20) NOT NULL COMMENT '商户编号',
  `user_id` bigint(20) NOT NULL COMMENT '会员编号',
  `order_number` varchar(100) DEFAULT NULL COMMENT '商户订单号',
  `stores_id` varchar(100) DEFAULT NULL COMMENT '商户门店或设备编号',
  `total_mount` decimal(65,2) DEFAULT NULL COMMENT '实付总金额',
  `total_price` decimal(65,2) DEFAULT NULL COMMENT '应付总金额',
  `order_date` datetime DEFAULT NULL COMMENT '订单发生时间',
  `state` char(1) DEFAULT '0' COMMENT '订单完成状态：0 未支付(进行中)   1已支付 2取消 ',
  `type` smallint(2) DEFAULT NULL COMMENT '交易阶段 1：完成订单    5：退货订单, 自营订单状态(10:待付款,20:待发货,30已发货,40已收货,50确认收货,99交易取消, 交易完成和退款使用原来状态1,5)',
  `is_user_rebate` char(1) NOT NULL DEFAULT '1' COMMENT '是否返利 0:是   1：否',
  `user_rebate` decimal(65,2) DEFAULT '0.00' COMMENT '预积分返还数量',
  `user_return_amount` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '返还积分数量',
  `is_business_rebate` char(1) NOT NULL DEFAULT '0' COMMENT '是否返佣 0:否   1：是',
  `business_rebate_amount` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '预返佣金额',
  `billing_state` char(1) DEFAULT '0' COMMENT '对账状态： 0 未对账 1 对账结束',
  `del_flag_user` char(1) DEFAULT '0' COMMENT 'A系统用户控制删除按钮',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `is_first` int(1) NOT NULL DEFAULT '0' COMMENT '是否首单,0:不是，1：是',
  `is_source` int(11) DEFAULT '0' COMMENT '订单来源   0:机票个人      1：机票分销商       2：合作商家     3：睿渠平台',
  `first_count` int(11) DEFAULT '0' COMMENT '首单优惠人数',
  `air_settle_accounts` decimal(10,2) DEFAULT '0.00' COMMENT '机票结算金额',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `consignee_name` varchar(50) DEFAULT NULL COMMENT '实物或者虚拟接收人名姓名',
  `consignee_mobile` varchar(15) DEFAULT NULL COMMENT '实物或者虚拟商品接收手机号',
  `consignee_addr` varchar(100) DEFAULT NULL COMMENT '接收人地址',
  `product_type` int(4) DEFAULT NULL COMMENT '商品类型(1.实体卡券 2.电子卡券 3.话费充值 4.流量充值 5.旅游卡, 6.自营卡券, 7.兜礼话费特惠 参考:ad_self_product_type)',
  `product_id` bigint(20) DEFAULT NULL COMMENT '目前的作用是,如果用户有未支付的订单, 对同一种SKU的商品不能多次下单',
  `act_type` varchar(50) DEFAULT NULL COMMENT '活动类型. COMMON: 普通订单, JCHD: 机场活动订单',
  `service_charge` decimal(10,2) DEFAULT '0.00' COMMENT '服务费',
  `voucher` decimal(10,2) DEFAULT '0.00' COMMENT '优惠券金额',
  `coupon_id` varchar(45) DEFAULT NULL COMMENT '抵扣券ID',
  `support_pay_type` varchar(45) DEFAULT NULL COMMENT '1:积分,2:微信, 3.支付宝; 多个以逗号分割',
  `big_order_number` varchar(50) DEFAULT '0' COMMENT '大订单编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `aor_order_id_index` (`order_id`) USING BTREE,
  KEY `aor_bussiness_id_index` (`bussiness_id`) USING BTREE,
  KEY `aor_user_id_index` (`user_id`) USING BTREE,
  KEY `aor_order_number_index` (`order_number`) USING BTREE,
  KEY `aor_type_index` (`type`) USING BTREE,
  KEY `aor_del_flag_index` (`del_flag`) USING BTREE,
  KEY `aor_order_date_index` (`order_date`) USING BTREE,
  KEY `aor_order_big_index` (`big_order_number`) USING BTREE,
  KEY `unit_test` (`order_number`,`order_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单报表';

-- ----------------------------
--  Table structure for `undo_log`
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
