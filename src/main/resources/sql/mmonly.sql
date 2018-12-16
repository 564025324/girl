create table seckill.url_pic
(
  id       bigint auto_increment
    primary key,
  url_name varchar(500) not null,
  url_addr varchar(500) not null,
  url_type varchar(20)  null
);

create table seckill.urldb
(
  id       bigint(100) auto_increment
    primary key,
  url      varchar(300) not null,
  url_type int(2)       not null
);

