/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.31 : Database - springsecurity
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springsecurity` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `springsecurity`;

/*Table structure for table `persistent_logins` */

DROP TABLE IF EXISTS `persistent_logins`;

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `persistent_logins` */

insert  into `persistent_logins`(`username`,`series`,`token`,`last_used`) values ('admin','NX6idpFxfg1guu/JbhBMlw==','cJNjU4O0m7vi/9k3P+yYVQ==','2020-11-16 15:56:52');

/*Table structure for table `sys_role_table` */

DROP TABLE IF EXISTS `sys_role_table`;

CREATE TABLE `sys_role_table` (
  `role_id` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '主键',
  `role_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '角色ID',
  `description` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE KEY `sys_role_table_pk` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_role_table` */

insert  into `sys_role_table`(`role_id`,`role_name`,`description`) values ('1','ROLE_ADMIN','超级管理员'),('2f412c59e5077e0cd53d21fac3eee402','ROLE_收银员','收银员'),('d04c2ebb1e32995f384ad49f6d4b421d','ROLE_店长','店长');

/*Table structure for table `sys_role_user_table` */

DROP TABLE IF EXISTS `sys_role_user_table`;

CREATE TABLE `sys_role_user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '角色ID',
  `user_id` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_role_user_table` */

insert  into `sys_role_user_table`(`id`,`role_id`,`user_id`) values (40,'1','bcad19f214499feab47f15b18ae9bc88'),(43,'d04c2ebb1e32995f384ad49f6d4b421d','6268cbe21e573513a66799114d925e04'),(76,'2f412c59e5077e0cd53d21fac3eee402','d01c54801e8155223f3a6656056fa2dd'),(77,'2f412c59e5077e0cd53d21fac3eee402','86c887c04ec842d1a5ce7050f263355a'),(78,'2f412c59e5077e0cd53d21fac3eee402','0f09bb6fd9b516d25932fcd4c2d1fbfc'),(79,'2f412c59e5077e0cd53d21fac3eee402','b0b4c302687e1c29409ebb688298b667');

/*Table structure for table `sys_user_table` */

DROP TABLE IF EXISTS `sys_user_table`;

CREATE TABLE `sys_user_table` (
  `user_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '主键',
  `user_name` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '用户名称',
  `pass_word` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '用户密码-BCR算法加密',
  `description` varchar(800) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_user_table` */

insert  into `sys_user_table`(`user_id`,`user_name`,`pass_word`,`description`,`state`) values ('0f09bb6fd9b516d25932fcd4c2d1fbfc','刘伟','$2a$10$mKVSgJnapbUKoBYfIVJyT.19wG3SuSrn6ZYu20eeon0Mrpc/D1Oey',NULL,1),('13a0d86310b052bb1d7c57786316077a','白杨树','$2a$10$jalwt9mC7GWOkM5HjZroeOuD/1xhXcqvXgSYYX7ruCXBSeIX/ypW6',NULL,1),('1a9fa07a96f44f40a020b24c54b52428','程小东','$2a$10$TKeidhFBUt5oAnCkYkmQj.DpMULqZR3ITCqKep0J36kf50HEgXRZa',NULL,1),('1f540f553a4dd536e52aeca3d470dad7','郭强','$2a$10$Q7Xcmhe8N71niSFriYRREOKACg8nSA8cFDk1NUQTm2JStuasGllN.',NULL,1),('330708e6680c4e9dd0d772af7343f01e','谭红红','$2a$10$jVFVJ59rKW1VObOVWX7Wpedhlb.oubFIFWfqg9RWby5jE2AkPw3bS',NULL,1),('40529d21d3f4fb975043c63e43630253','韦博','$2a$10$Gwk0Oaz04AxZz1O9s7LSfuOw56H9zGX2HG1I3wqLtpEPh/fRbdR2y',NULL,1),('469c4d4d21d900d2446edaf5f646c663','郭德纲','$2a$10$y4d3fWr7ajYQ9qyAdGfW/OG8qInla9U7U4gL0/EDwRvCm2fAeJl6m',NULL,1),('5ae28c392a6779e41c7d0f8c9f7dfb09','任静','$2a$10$VCRbyDApB15zA5wLNTfkNeEvG7Yu3h3fHeG82Cgz6JpaSXeXx/fHe',NULL,1),('6268cbe21e573513a66799114d925e04','李兰','$2a$10$uAU6hwGYTdynwnjOpQFfYO.a17DWhqkaKU52fdw9IKdYY7Pj/QOuy',NULL,1),('86c887c04ec842d1a5ce7050f263355a','含','$2a$10$Omd.iEgCyiHbc8pxPMF.F./FLmRuvf.9tLjjHf8f/mXAzWVGJjToG','ceshi',1),('b0b4c302687e1c29409ebb688298b667','李四','$2a$10$mjMbuWPgl/ZkBkfv.uHTk.6k1LTbpPvFoKHivz5I16mEnRbq0REcu',NULL,1),('b3c9e9218fdf0347cc358755c365f2fa','郭明','$2a$10$UdhLqkJ.uCD3e/3Z13mV3eEkIrbxpG3oXNyBLm4y8Kwxs8NnXcOly',NULL,1),('bcad19f214499feab47f15b18ae9bc88','admin','$2a$10$1H81ddXs9x/KqYC3IA.kBO7hFac5KXHz1Bgwt49GZbwvjXkXbLFTq','超级管理员',1),('c2ea699c481735cd2288dcedbc558d54','魏艳梅','$2a$10$h5RdNWDVHmwdRV4X/HYR0eOXT9ISRtDXf8RA5/y3nmczAGCZI/iya',NULL,1),('c915222fff04f4a3e29afff8d62a56f2','胡柳杨','$2a$10$VRtWxeuvWP8ILmGWKoDPv.5AACxhznGKV.pspWYVqLrVYHdWp3PAC',NULL,1),('c9b52031507db4e87e128747afb686bc','伊能静','$2a$10$Z./P3eWTSs9klr9cmHwC9uui/BFtfhF5pzwUrKP8Jyi0TisqFL5S2',NULL,1),('d01c54801e8155223f3a6656056fa2dd','张三','$2a$10$4ed508knTPCdkBp5TfiZROge2WWxcYTTCV.LHo3/jI6tbZPK5wwna',NULL,1),('da52a0c77af941b43fb54074313ebd9a','郭敬明','$2a$10$9hWszcWfimQNiwEiet.dCueLMkXxiUAfX35KBLcaNUdwZu4ZvwpZe',NULL,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
