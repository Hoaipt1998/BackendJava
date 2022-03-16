/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : course

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-11-04 14:21:02
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `credit` int(2) DEFAULT NULL,
  `courseTypeID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_coursetype` (`courseTypeID`),
  CONSTRAINT `fk_coursetype` FOREIGN KEY (`courseTypeID`) REFERENCES `coursetype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'GE 1011', 'General English 1', '15', '2');
INSERT INTO `course` VALUES ('2', 'COSC 1436', 'Programming Fundamentals 1', '1', '1');
INSERT INTO `course` VALUES ('5', 'SPCH 1315', 'Public Speaking', '3', '1');
INSERT INTO `course` VALUES ('6', 'INEW 2438', 'Advanced Java Programming', '4', '2');
INSERT INTO `course` VALUES ('7', 'COSC 1437', 'Programming Fundamentals II', '4', '1');
INSERT INTO `course` VALUES ('8', 'BCIS 1305', 'Business Computer Applications', '3', '1');
INSERT INTO `course` VALUES ('9', 'ITSE 1346', 'Database Theory and Design', '3', '1');
INSERT INTO `course` VALUES ('10', 'GE 2011', 'General English 2', '15', '2');
INSERT INTO `course` VALUES ('11', 'politics', 'Brain Washing', '3', '5');
INSERT INTO `course` VALUES ('12', 'afdas', '3', '3', '1');

-- ----------------------------
-- Table structure for `coursetype`
-- ----------------------------
DROP TABLE IF EXISTS `coursetype`;
CREATE TABLE `coursetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of coursetype
-- ----------------------------
INSERT INTO `coursetype` VALUES ('1', 'AAS', 'AAS Course Type');
INSERT INTO `coursetype` VALUES ('2', 'ESL', null);
INSERT INTO `coursetype` VALUES ('4', 'gggg', 'gggggg');
INSERT INTO `coursetype` VALUES ('5', 'VN', '');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '01-17-0-20004', 'Le Dinh', 'Hoang');
INSERT INTO `student` VALUES ('2', '01-19-1-00004', 'Dang Thi Thanh', 'Huong');
INSERT INTO `student` VALUES ('3', '01-17-0-20011', 'Truong Quoc', 'Phi');
INSERT INTO `student` VALUES ('4', '01-17-0-20012', 'Ro Da', 'Thanh');
INSERT INTO `student` VALUES ('5', '01-17-0-20011', 'Truong Quoc', 'Phi');
INSERT INTO `student` VALUES ('6', '01-18-0-00018', 'Do Le Phi', 'Long');
INSERT INTO `student` VALUES ('7', '01-17-0-20009', 'Bui Anh', 'Tuan');

-- ----------------------------
-- Table structure for `study`
-- ----------------------------
DROP TABLE IF EXISTS `study`;
CREATE TABLE `study` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentID` int(11) DEFAULT NULL,
  `courseID` int(11) DEFAULT NULL,
  `averageScore` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_student` (`studentID`),
  KEY `fk_course` (`courseID`),
  CONSTRAINT `fk_course` FOREIGN KEY (`courseID`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student` FOREIGN KEY (`studentID`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of study
-- ----------------------------
INSERT INTO `study` VALUES ('20', '4', '5', '0');
INSERT INTO `study` VALUES ('21', '4', '6', '0');
INSERT INTO `study` VALUES ('38', '3', '5', '0');
INSERT INTO `study` VALUES ('39', '3', '6', '0');
INSERT INTO `study` VALUES ('50', '4', '1', '0');
INSERT INTO `study` VALUES ('51', '4', '2', '0');
INSERT INTO `study` VALUES ('52', '4', '7', '0');
INSERT INTO `study` VALUES ('53', '4', '8', '0');
INSERT INTO `study` VALUES ('54', '4', '9', '0');
INSERT INTO `study` VALUES ('55', '4', '10', '0');
INSERT INTO `study` VALUES ('56', '1', '11', '0');
INSERT INTO `study` VALUES ('57', '2', '11', '0');
