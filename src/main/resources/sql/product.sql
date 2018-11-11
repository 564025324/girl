create table `product_info` (
  `product_id`          varchar(32)   not null,
  `product_name`        varchar(64)   not null
  comment '商品名称',
  `product_price`       decimal(8, 2) not null
  comment '单价',
  `product_stock`       int           not null
  comment '库存',
  `product_description` varchar(512) comment '描述',
  `product_icon`        int           not null
  comment '小图',
  `category_type`       int           not null
  comment '类目编号',
  `create_time`         timestamp     not null default current_timestamp
  comment '创建时间',
  `update_time`         timestamp     not null DEFAULT '0000-00-00 00:00:00'
  comment '修改时间',
  -- 因为Mysql5.6以下不支持建表语句中出现两次以上current_timestamp或者on update： default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`product_id`)
)
  comment '商品表';
-- 增加触发器
CREATE TRIGGER `update_product_info_update_time_trigger`
  BEFORE UPDATE
  ON `product_info`
  FOR EACH ROW
  SET NEW.`update_time` = NOW();


create table `product_category` (
  `category_id`   int         not null auto_increment,
  `category_name` varchar(64) not null
  comment '类目名称',
  `category_type` int         not null
  comment '类目编号',
  `create_time`   timestamp   not null default current_timestamp
  comment '创建时间',
  `update_time`   timestamp   not null DEFAULT '0000-00-00 00:00:00'
  comment '修改时间',
  -- 因为Mysql5.6以下不支持建表语句中出现两次以上current_timestamp或者on update： default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`category_id`),
  unique key `uqe_category_type` (`category_type`) -- 约束索引
)
  comment '类目表';
-- 增加触发器
CREATE TRIGGER `update_product_category_update_time_trigger`
  BEFORE UPDATE
  ON `product_category`
  FOR EACH ROW
  SET NEW.`update_time` = NOW();


create table `order_master` (
  `order_id`      varchar(32)   not null,
  `buyer_name`    varchar(32)   not null
  comment '买家名字',
  `buyer_phone`   varchar(32)   not null
  comment '买家电话',
  `buyer_address` varchar(128)  not null
  comment '买家地址',
  `buyer_openid`  varchar(64)   not null
  comment '买家微信openid',
  `buyer_amount`  decimal(8, 2) not null
  comment '订单总金额',
  `buyer_status`  tinyint(3)    not null default '0'
  comment '订单状态，默认0新下单',
  `pay_status`    tinyint(3)    not null default '0'
  comment '支付状态，默认0未支付',
  `create_time`   timestamp     not null default current_timestamp
  comment '创建时间',
  `update_time`   timestamp     not null DEFAULT '0000-00-00 00:00:00'
  comment '修改时间',
  -- 因为Mysql5.6以下不支持建表语句中出现两次以上current_timestamp或者on update： default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`order_id`),
  key `idx_buyer_openid` (`buyer_openid`) -- 约束索引
)
  comment '订单主表';
-- 增加触发器
CREATE TRIGGER `update_iorder_master_update_time_trigger`
  BEFORE UPDATE
  ON `order_master`
  FOR EACH ROW
  SET NEW.`update_time` = NOW();


create table `order_detail` (
  `detail_id`        varchar(32)   not null,
  `order_id`         varchar(32)   not null,
  `product_id`       varchar(32)   not null
  comment '类目名称',
  `product_name`     varchar(64)   not null
  comment '商品名称',
  `product_price`    decimal(8, 2) not null
  comment '商品价格',
  `product_quantity` int           not null
  comment '商品数量',
  `product_icon`     varchar(512) comment '商品小图',
  `create_time`      timestamp     not null default current_timestamp
  comment '创建时间',
  `update_time`      timestamp     not null DEFAULT '0000-00-00 00:00:00'
  comment '修改时间',
  -- 因为Mysql5.6以下不支持建表语句中出现两次以上current_timestamp或者on update： default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`detail_id`),
  unique key `idx_order_id` (`order_id`) -- 约束索引
)
  comment '订单详细表';
-- 增加触发器
CREATE TRIGGER `update_order_detail_update_time_trigger`
  BEFORE UPDATE
  ON `order_detail`
  FOR EACH ROW
  SET NEW.`update_time` = NOW();
