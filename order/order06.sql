/*
Navicat MySQL Data Transfer

Source Server         : 本地sql
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : order06

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-03-05 21:20:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for details
-- ----------------------------
DROP TABLE IF EXISTS `details`;
CREATE TABLE `details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `gcount` int(11) DEFAULT NULL,
  `oid` int(11) DEFAULT NULL,
  `remake` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of details
-- ----------------------------
INSERT INTO `details` VALUES ('1', '11', '3', '5', null);
INSERT INTO `details` VALUES ('2', '14', '6', '5', null);
INSERT INTO `details` VALUES ('3', '12', '5', '6', null);
INSERT INTO `details` VALUES ('4', '14', '5', '6', null);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(255) DEFAULT NULL,
  `gprice` double DEFAULT NULL,
  `gpath` varchar(255) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `updown` varchar(255) DEFAULT '1' COMMENT '1表示上架，0表示下架',
  `status` int(11) DEFAULT '1' COMMENT '1表示可以，0表示禁用',
  PRIMARY KEY (`id`),
  KEY `tid` (`tid`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '鱼香肉丝', '14', 'f3b1f365-0921-451a-981c-e9966277020f.jpg', '1', '50', '0', '1');
INSERT INTO `goods` VALUES ('2', '黄焖鸡', '20', '1a0f7461-9b63-4148-993d-6abae863b715.jpg', '1', '10', '1', '1');
INSERT INTO `goods` VALUES ('3', '扬州炒饭', '15', '3ec6e91a-1750-48a5-94ae-d887abe613d1.jpg', '1', '25', '0', '1');
INSERT INTO `goods` VALUES ('4', '麻辣米线', '8', '9261d013-51e7-429c-a8c2-45c1846d0967.jpg', '2', '2', '1', '1');
INSERT INTO `goods` VALUES ('5', '过桥米线', '15', 'bfbd8f60-7992-4d21-88eb-2f19a5aa8418.jpg', '3', '5', '1', '1');
INSERT INTO `goods` VALUES ('6', '酱香米线', '18', '5c2b94b4-fa4a-4b1b-8fd8-7e25fa68e095.jpg', '2', '8', '1', '1');
INSERT INTO `goods` VALUES ('7', '干煸菜花', '12', '4ac4336a-f438-4a7b-84d1-89aeb06185c0.jpg', '1', '20', '1', '1');
INSERT INTO `goods` VALUES ('8', '牛肉汉堡', '15', '7cf102db-e1d9-4702-9918-c6f9fe164b2c.jpg', '3', '22', '1', '1');
INSERT INTO `goods` VALUES ('9', '珍珠奶茶', '9', 'fe76375e-77a0-4887-917f-08a87bd51e34.jpg', '2', '25', '1', '1');
INSERT INTO `goods` VALUES ('10', '双拼奶茶', '10', '38256c17-5ca5-4143-ac9a-051d2509d3a8.jpg', '2', '25', '1', '1');
INSERT INTO `goods` VALUES ('11', '香辣翅中', '12', 'c5ad48de-f99c-4d97-8369-c63a67319859.jpg', '2', '30', '1', '1');
INSERT INTO `goods` VALUES ('12', '煎包', '20', 'e5417ce0-3dd3-4879-b53a-bf9ea668738b.jpg', '3', '205', '1', '1');
INSERT INTO `goods` VALUES ('13', '麻辣香锅', '50', 'ed3c0116-daa1-4775-bd01-a74a024b2bd2.jpg', '5', '11', '1', '1');
INSERT INTO `goods` VALUES ('14', '把子肉', '5', '8d0af8e7-e79b-4b9f-a40f-adb44e9138bc.jpg', '1', '105', '1', '1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tableno` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `remake` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('5', null, '2019-02-26 22:53:27', '66', null);
INSERT INTO `orders` VALUES ('6', null, '2019-02-26 22:59:46', '125', null);

-- ----------------------------
-- Table structure for types
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '1' COMMENT '默认为1可用，0不可以',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES ('1', '盖浇饭', '1');
INSERT INTO `types` VALUES ('2', '汉堡', '1');
INSERT INTO `types` VALUES ('3', '面食', '1');
INSERT INTO `types` VALUES ('4', '汤', '1');
INSERT INTO `types` VALUES ('5', '奶茶', '1');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '超级管理员', '110');
INSERT INTO `users` VALUES ('2', 'dianzhang', 'ce12bd856596baa29ef29fdfc574cd8e', '张三丰', '155');
