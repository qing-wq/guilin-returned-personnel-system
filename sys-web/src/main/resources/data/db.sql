create database `personnel`;

use personnel;

DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    `id`          INT(10)      NOT NULL AUTO_INCREMENT COMMENT '业务主键',
    `create_time` timestamp    NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
    `update_time` timestamp    NOT NULL DEFAULT current_timestamp() COMMENT '最后更新时间',
    `username`   VARCHAR(255) NOT NULL DEFAULT '' COMMENT '账号',
    `password`   VARCHAR(255) NOT NULL DEFAULT '' COMMENT '密码',
    `deleted`     tinyint(10)  NOT NULL DEFAULT 0 COMMENT '是否删除',
    PRIMARY KEY (id)
) COMMENT = 'user';
DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info
(
    `id`             INT(10)      NOT NULL AUTO_INCREMENT COMMENT '业务主键',
    `create_time`    timestamp    NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
    `update_time`    timestamp    NOT NULL DEFAULT current_timestamp() COMMENT '最后更新时间',
    `user_id`        VARCHAR(255) NOT NULL DEFAULT 0 COMMENT '用户ID',
    `user_info_name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '姓名',
    `regoin`         VARCHAR(255) NOT NULL DEFAULT '' COMMENT '所属地区',
    `user_role`      VARCHAR(255) NOT NULL DEFAULT '' COMMENT '用户角色',
    `deleted`        tinyint(10)  NOT NULL DEFAULT 0 COMMENT '是否删除',
    `country`        VARCHAR(255) NOT NULL DEFAULT '' COMMENT '国家',
    `return_time`    VARCHAR(255) NOT NULL COMMENT '归国时间',
    `after_work`     VARCHAR(255) NOT NULL DEFAULT '' COMMENT '归国后工作',
    `before_work`    VARCHAR(255) NOT NULL DEFAULT '' COMMENT '归国前工作',
    PRIMARY KEY (id)
) COMMENT = 'user_info';
DROP TABLE IF EXISTS role;
CREATE TABLE role
(
    `id`           INT          NOT NULL AUTO_INCREMENT COMMENT '业务主键',
    `CREATED_TIME` timestamp    NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
    `UPDATED_TIME` timestamp    NOT NULL DEFAULT current_timestamp() COMMENT '更新时间',
    `description`  VARCHAR(255) NOT NULL DEFAULT '' COMMENT '描述;admin、市级人员、县级人员等',
    `deleted`      tinyint      NOT NULL DEFAULT 0 COMMENT '是否删除',
    PRIMARY KEY (id)
) COMMENT = '';
