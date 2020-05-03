/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.26-log : Database - asflow
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`asflow` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;

USE `asflow`;

/*Table structure for table `demand` */

DROP TABLE IF EXISTS `demand`;

CREATE TABLE `demand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '需求id',
  `pid` bigint(20) NOT NULL COMMENT '项目id',
  `uid` bigint(20) NOT NULL COMMENT '添加人id',
  `time` datetime NOT NULL COMMENT '添加时间',
  `title` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '需求标题',
  `content` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT '需求内容',
  `flag` smallint(6) NOT NULL COMMENT '状态0为待定1为确定2为删除',
  `test_flag` smallint(6) NOT NULL DEFAULT '0' COMMENT '测试标记 0为未测试1为测试',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `demand` */

insert  into `demand`(`id`,`pid`,`uid`,`time`,`title`,`content`,`flag`,`test_flag`) values 
(1,11,1,'2020-04-10 11:24:01','第一个需求','需求的描述需求的描述需求的描述需求的描述需求的描述需求的描述需求的描述需求的描述需求的描述需求的描述需求的描述需求的描述',1,0),
(2,11,1,'2020-04-10 11:30:38','第二个需求','需求描述',1,0),
(3,11,1,'2020-04-10 11:32:25','第三个需求','描述',2,0),
(4,11,1,'2020-04-10 11:32:58','第四个需求','需求',1,0),
(5,11,1,'2020-04-10 12:53:40','123','123',2,0),
(6,11,1,'2020-04-10 19:35:30','需求五','描述五',2,0),
(7,15,1,'2020-04-21 18:01:33','222','222',1,0);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `uid` bigint(20) NOT NULL COMMENT '用户id',
  `pid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `role` smallint(6) NOT NULL COMMENT '担任角色0为管理员1为项目经理2为开发人员',
  `groupid` smallint(6) DEFAULT NULL COMMENT '所属的组的id',
  KEY `pid` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `department` */

insert  into `department`(`uid`,`pid`,`role`,`groupid`) values 
(1,11,0,11),
(3,11,1,22),
(5,11,2,22),
(5,12,2,22),
(2,11,1,123),
(1,15,0,0);

/*Table structure for table `interface` */

DROP TABLE IF EXISTS `interface`;

CREATE TABLE `interface` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '接口id',
  `uid` bigint(20) NOT NULL COMMENT '创建人id',
  `time` datetime NOT NULL COMMENT '创建时间',
  `mid` bigint(20) NOT NULL COMMENT '模块id',
  `parameter` varchar(300) COLLATE utf8mb4_bin NOT NULL COMMENT '参数',
  `returnss` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '返回',
  `disc` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '描述',
  `flag` smallint(6) NOT NULL DEFAULT '0' COMMENT '0为未编码，1为编码',
  `title` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '接口名',
  `test_flag` smallint(6) NOT NULL DEFAULT '0' COMMENT '0为未测试，1为测试',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `interface` */

insert  into `interface`(`id`,`uid`,`time`,`mid`,`parameter`,`returnss`,`disc`,`flag`,`title`,`test_flag`) values 
(10,1,'2020-04-17 12:42:34',1,'[{\'参数类型\':1-\'参数名\':1-\'参数描述\':1}]','  返回类型  2- 返回名  2- 返回描述  2 ','123123',0,'1',1),
(16,1,'2020-04-17 13:12:30',1,'[{\'参数类型\':2-\'参数名\':2-\'参数描述\':123}, {\'参数类型\':2-\'参数名\':2-\'参数描述\':1}, {\'参数类型\':2-\'参数名\':2-\'参数描述\':3}]','  返回类型  2- 返回名  2- 返回描述  2 ','2',1,'2',0),
(18,1,'2020-04-17 13:17:56',1,'[{\'参数类型\':1-\'参数名\':1-\'参数描述\':1}]','  返回类型  1- 返回名  1- 返回描述  1 ','1',0,'4',0),
(19,1,'2020-04-20 16:24:23',1,'[{\'参数类型\':1-\'参数名\':1-\'参数描述\':1}, {\'参数类型\':2-\'参数名\':2-\'参数描述\':2}]','  返回类型  1- 返回名  1- 返回描述  1 ','123',0,'123',0),
(20,1,'2020-04-21 18:02:18',5,'[{\'参数类型\':123-\'参数名\':213-\'参数描述\':213}]','  返回类型  123- 返回名  123- 返回描述  123 ','213',0,'123',0),
(21,1,'2020-04-27 23:31:21',2,'[{\'参数类型\':int-\'参数名\':juan-\'参数描述\':jj}, {\'参数类型\':1-\'参数名\':1-\'参数描述\':1}, {\'参数类型\':2-\'参数名\':2-\'参数描述\':2}]','  返回类型  2- 返回名  2- 返回描述  2 ','卷接口',0,'卷卷',0);

/*Table structure for table `job` */

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `formid` bigint(20) NOT NULL COMMENT '发布人id',
  `getid` bigint(20) NOT NULL COMMENT '接收人id',
  `disc` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT '任务描述',
  `creat_time` datetime NOT NULL COMMENT '创建时间',
  `final_time` datetime NOT NULL COMMENT '最迟时间',
  `sub_time` datetime DEFAULT NULL COMMENT '提交时间',
  `flag` smallint(6) NOT NULL DEFAULT '0' COMMENT '标记0为未提交1为提交但未完成2为提交完毕3为被打回4为再次提交',
  `completion` smallint(6) NOT NULL DEFAULT '0' COMMENT '完成百分比',
  `sub_flag` smallint(6) NOT NULL DEFAULT '0' COMMENT '是否上传1为上传0为未上传',
  `iid` smallint(6) DEFAULT NULL COMMENT '接口id',
  `pid` bigint(20) NOT NULL COMMENT '项目id',
  `coderid` bigint(20) DEFAULT NULL COMMENT '编码人员id',
  `subid` bigint(20) DEFAULT NULL COMMENT '提交人id',
  `type` smallint(6) DEFAULT NULL COMMENT '任务类型，1为开发任务，2为接口测试任务，3为需求测试任务',
  `did` smallint(6) DEFAULT NULL COMMENT '需求id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `job` */

insert  into `job`(`id`,`formid`,`getid`,`disc`,`creat_time`,`final_time`,`sub_time`,`flag`,`completion`,`sub_flag`,`iid`,`pid`,`coderid`,`subid`,`type`,`did`) values 
(5,1,1,'1','2020-04-27 23:36:37','2020-05-08 23:00:00','2020-04-21 15:20:22',0,4,1,10,11,5,0,2,0),
(10,1,5,'123','2020-04-21 14:20:33','2020-04-25 23:00:00',NULL,3,0,0,16,11,3,0,1,0),
(12,1,2,'`','2020-04-24 22:50:40','2020-04-25 23:00:00',NULL,1,0,0,18,11,0,0,2,0),
(16,1,1,'1','2020-04-27 23:57:03','2020-05-08 23:00:00',NULL,3,0,0,NULL,11,1,NULL,3,1);

/*Table structure for table `mail` */

DROP TABLE IF EXISTS `mail`;

CREATE TABLE `mail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '邮件id',
  `sentid` bigint(20) NOT NULL COMMENT '发送者id',
  `getid` bigint(20) NOT NULL COMMENT '接收者id',
  `time` datetime NOT NULL COMMENT '时间',
  `cont` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT '内容',
  `title` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '标题',
  `flag` smallint(6) NOT NULL DEFAULT '0' COMMENT '状态 0为未读，1为已读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `mail` */

insert  into `mail`(`id`,`sentid`,`getid`,`time`,`cont`,`title`,`flag`) values 
(3,1,4,'2020-04-14 23:55:41','123','123',0),
(4,1,5,'2020-04-21 18:46:56','12312321','123123123',0),
(5,1,4,'2020-04-21 19:03:05','test','消息',0);

/*Table structure for table `model` */

DROP TABLE IF EXISTS `model`;

CREATE TABLE `model` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模块id',
  `did` bigint(20) NOT NULL COMMENT '需求id',
  `uid` bigint(20) NOT NULL COMMENT '添加人id',
  `time` datetime NOT NULL COMMENT '添加时间',
  `title` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '模块标题',
  `content` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT '模块内容',
  `flag` smallint(6) NOT NULL COMMENT '状态0为待定1为确定2为删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `model` */

insert  into `model`(`id`,`did`,`uid`,`time`,`title`,`content`,`flag`) values 
(1,4,1,'2020-04-10 19:10:10','模块一','123',1),
(2,2,1,'2020-04-14 00:37:33','模块一','123',0),
(3,2,1,'2020-04-14 00:46:49','模块2','123',1),
(4,6,1,'2020-04-16 22:20:43','111','111',0),
(5,7,1,'2020-04-21 18:01:52','111','111',1),
(6,1,1,'2020-04-27 23:30:14','卷卷模块','biu',1);

/*Table structure for table `param` */

DROP TABLE IF EXISTS `param`;

CREATE TABLE `param` (
  `id` bigint(20) NOT NULL COMMENT '参数id',
  `iid` bigint(20) NOT NULL COMMENT '所属接口id',
  `type` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '参数类型',
  `name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `param` */

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目id',
  `name` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '项目名',
  `creat_time` datetime NOT NULL COMMENT '创建时间',
  `pid` bigint(20) DEFAULT '0' COMMENT '主项目id默认为0',
  `stage` smallint(6) NOT NULL DEFAULT '1' COMMENT '当前阶段1为需求分析2为概要设计3为详细设计4为编码5为测试',
  `uid` bigint(20) NOT NULL COMMENT '创建人id',
  `dsr` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT '项目描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `project` */

insert  into `project`(`id`,`name`,`creat_time`,`pid`,`stage`,`uid`,`dsr`) values 
(11,'张春伟的项目','2020-04-08 23:05:26',0,5,1,'123'),
(12,'x项目','2020-04-10 19:33:48',0,1,1,'x描述'),
(13,'x项目','2020-04-10 19:33:49',0,1,1,'x描述'),
(14,'项目1','2020-04-10 19:55:44',0,1,1,'123'),
(15,'测试项目','2020-04-21 17:54:15',0,4,1,'第一个测试项目');

/*Table structure for table `repulse` */

DROP TABLE IF EXISTS `repulse`;

CREATE TABLE `repulse` (
  `jid` bigint(20) NOT NULL COMMENT '任务id',
  `reason` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT '打回原因',
  `time` datetime NOT NULL COMMENT '打回时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `repulse` */

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '测试截图id',
  `Iid` bigint(20) NOT NULL DEFAULT '0' COMMENT '接口id',
  `url` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT '截图链接',
  `uid` bigint(20) NOT NULL COMMENT '上传者id',
  `time` datetime NOT NULL COMMENT '上传时间',
  `disc` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT '描述',
  `type` smallint(6) NOT NULL DEFAULT '0' COMMENT '类型',
  `did` bigint(20) NOT NULL DEFAULT '0' COMMENT '需求id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `test` */

insert  into `test`(`id`,`Iid`,`url`,`uid`,`time`,`disc`,`type`,`did`) values 
(3,10,'/photo/IMG_4632.jpg',1,'2020-04-26 22:54:00','123',2,0),
(4,10,'/photo/IMG_4633.jpg',1,'2020-04-26 22:54:00','123',2,0),
(5,10,'/photo/IMG_4638.jpg',1,'2020-04-26 22:54:00','123',2,0),
(6,10,'/photo/IMG_4625.jpg',1,'2020-04-27 23:50:11','222',2,0),
(7,10,'/photo/IMG_4634.jpg',1,'2020-04-27 23:54:18','1111',2,0),
(9,10,'/photo/IMG_4639.jpg',1,'2020-04-28 18:55:49','',2,0);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id号',
  `name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `pwd` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `creat_time` datetime NOT NULL COMMENT '创建时间',
  `phone` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '电话号码',
  `mail` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `users` */

insert  into `users`(`id`,`name`,`pwd`,`creat_time`,`phone`,`mail`) values 
(1,'张春伟','e10adc3949ba59abbe56e057f20f883e','2020-04-01 15:22:57','13981933605','1228835061@qq.com'),
(2,'zcw','202cb962ac59075b964b07152d234b70','2020-04-03 19:31:44','13981933604','1228835061@qq.com'),
(3,'123','4297f44b13955235245b2497399d7a93','2020-04-09 15:54:32','123','123'),
(4,'1234','81dc9bdb52d04dc20036dbd8313ed055','2020-04-09 15:54:40','1234','1234'),
(5,'12345','827ccb0eea8a706c4c34a16891f84e7b','2020-04-09 15:54:49','12345','12345');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
