/*
MySQL Backup
Source Server Version: 8.0.23
Source Database: demo
Date: 2021/6/21 22:14:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `audit`
-- ----------------------------
DROP TABLE IF EXISTS `audit`;
CREATE TABLE `audit` (
  `sid` int NOT NULL COMMENT '学生用户名',
  `pid` int NOT NULL COMMENT '职位号',
  `status` int DEFAULT NULL COMMENT '申请状态',
  PRIMARY KEY (`sid`,`pid`),
  KEY `s_id` (`sid`),
  KEY `p_id` (`pid`),
  CONSTRAINT `p_id` FOREIGN KEY (`pid`) REFERENCES `position` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `s_id` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bussiness`
-- ----------------------------
DROP TABLE IF EXISTS `bussiness`;
CREATE TABLE `bussiness` (
  `bid` int NOT NULL AUTO_INCREMENT COMMENT '企业用户名',
  `bussinessname` varchar(255) DEFAULT NULL COMMENT '企业名',
  `password` varchar(255) NOT NULL COMMENT '企业密码',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `position`
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `pid` int NOT NULL AUTO_INCREMENT COMMENT '职位号',
  `bid` int NOT NULL COMMENT '企业号',
  `positionname` varchar(255) DEFAULT NULL COMMENT '职位名称',
  `salary` int DEFAULT NULL COMMENT '工资',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`pid`),
  KEY `position_ibfk_1` (`bid`),
  CONSTRAINT `position_ibfk_1` FOREIGN KEY (`bid`) REFERENCES `bussiness` (`bid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int NOT NULL AUTO_INCREMENT COMMENT '学生用户名',
  `sname` varchar(255) DEFAULT NULL COMMENT '学生姓名',
  `stelephone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `spassword` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `audit` VALUES ('1','1','1'), ('1','8','1'), ('2','1','1'), ('2','3','2'), ('3','1','2'), ('99','2','1');
INSERT INTO `bussiness` VALUES ('1','企业4','123','法国','333333'), ('2','企业2','111','广东省分工','43254'), ('3','企业3','111','山沟沟','001'), ('4','企业5','234','萨法','23524'), ('6','aS','5675768','湖底施工方','123425346'), ('7','sad','13425235','微软提供','23146575674'), ('71','企业1','12','撒大大','12');
INSERT INTO `position` VALUES ('1','2','经理','43','2021-07-04 12:00:00','2021-07-04 12:00:00'), ('2','3','工程师','2543','2021-05-01 08:00:00','2022-03-01 15:00:00'), ('3','2','程序员','1234','2022-03-01 15:00:00','2022-10-01 16:00:00'), ('4','71','测试员','21','2021-06-28 16:00:00','2021-06-10 17:18:16'), ('5','1','设计师','345','2021-05-01 08:00:00','2021-09-30 12:00:00'), ('7','1','程序员','2000','2021-06-19 16:00:00','2021-06-28 16:00:00'), ('8','2','总裁','1','2021-06-07 16:00:00','2021-06-21 16:00:00'), ('9','1','经理','43','2021-07-04 12:00:00','2021-07-04 13:00:00');
INSERT INTO `student` VALUES ('1','张三','20190001','123456'), ('2','李四','20190002','123123'), ('3','王五','20190003','111111'), ('6','dsf','23546','231425'), ('7','TangoZ','123425453','324565'), ('99','ggg','12333333','12345'), ('100','qq','123455','123');
