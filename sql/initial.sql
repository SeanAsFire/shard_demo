drop database if exists test0;
create database test0 charset utf8mb4;
use test0;
DROP TABLE IF EXISTS `user0`;
create table `user0`(
                        `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
                        `name` varchar(32) NOT null DEFAULT '' comment '姓名',
                        `age` INT COMMENT '姓名',
                        `sex` int comment '年龄',
                        PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Compact;

DROP TABLE IF EXISTS `user1`;
create table `user1`(
                        `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
                        `name` varchar(32) NOT null DEFAULT '' comment '姓名',
                        `age` INT COMMENT '姓名',
                        `sex` int comment '年龄',
                        PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Compact;

drop database if exists test1;
create database test1 charset utf8mb4;
use test1;
DROP TABLE IF EXISTS `user0`;
create table `user0`(
                        `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
                        `name` varchar(32) NOT null DEFAULT '' comment '姓名',
                        `age` INT COMMENT '姓名',
                        `sex` int comment '年龄',
                        PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Compact;

DROP TABLE IF EXISTS `user1`;
create table `user1`(
                        `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
                        `name` varchar(32) NOT null DEFAULT '' comment '姓名',
                        `age` INT COMMENT '姓名',
                        `sex` int comment '年龄',
                        PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Compact;