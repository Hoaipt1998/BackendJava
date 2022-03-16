/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : course

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-08-04 09:03:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `coursetypeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_coursetype` (`coursetypeid`),
  CONSTRAINT `fk_coursetype` FOREIGN KEY (`coursetypeid`) REFERENCES `coursetype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('13', 'GR', 'Grammar', '3', '23');
INSERT INTO `course` VALUES ('16', 'I2BU', 'Introduction to business', '3', '9');
INSERT INTO `course` VALUES ('19', 'MP', 'Mobile Programming', '4', '9');
INSERT INTO `course` VALUES ('22', 'PE', 'Physical education', '3', '14');
INSERT INTO `course` VALUES ('23', 'darrqw', 'GE-5 Listening', '4', '23');
INSERT INTO `course` VALUES ('24', 'GE2', 'GE2', '3', '23');
INSERT INTO `course` VALUES ('25', 'PF1', 'Programming Fundamentals I', '4', '9');
INSERT INTO `course` VALUES ('26', '12e2e', 'Brain Washing', '6', '9');

-- ----------------------------
-- Table structure for `coursetype`
-- ----------------------------
DROP TABLE IF EXISTS `coursetype`;
CREATE TABLE `coursetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coursetype
-- ----------------------------
INSERT INTO `coursetype` VALUES ('9', 'AAS', 'AAS');
INSERT INTO `coursetype` VALUES ('14', 'Vietnamese Courses', 'VN courses');
INSERT INTO `coursetype` VALUES ('23', 'ESL', 'English course');
