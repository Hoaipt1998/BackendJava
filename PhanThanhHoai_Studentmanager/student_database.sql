
use student;
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(100) DEFAULT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'Le Dinh', 'Hoang', 'Nam', 'hoang@gmail.com','09874532');
INSERT INTO `student` VALUES ('2',  'Dang Thi Thanh', 'Huong', 'Nu', 'huong@gmail.com','09874532');
INSERT INTO `student` VALUES ('3',  'Truong Quoc', 'Phi' , 'Nam', 'phi@gmail.com','09874532');
INSERT INTO `student` VALUES ('4',  'Ro Da', 'Thanh',  'Nam', 'thanh@gmail.com','09874532');
INSERT INTO `student` VALUES ('5',  'Truong Quoc', 'Phi', 'Nam', 'phiqt@gmail.com','09874532');
INSERT INTO `student` VALUES ('6',  'Do Le Phi', 'Long', 'Nam', 'long@gmail.com','09874532');
INSERT INTO `student` VALUES ('7',  'Bui Anh', 'Tuan', 'Nam', 'tuan@gmail.com','09874532');