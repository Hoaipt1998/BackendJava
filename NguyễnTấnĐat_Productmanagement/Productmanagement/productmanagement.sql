
use ProductManagement;
DROP TABLE IF EXISTS `producttype`;
CREATE TABLE `producttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `descreption` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `descreption` varchar(500) DEFAULT NULL,
  `status` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `producttype` VALUES ('1','SamSung','samsung moi nhat');
INSERT INTO `producttype` VALUES ('2','Apple','apple moi nhat');
INSERT INTO `producttype` VALUES ('3','Xaomi','xaomi moi nhat');
INSERT INTO `product` VALUES ('1','SamSungGalaxy','1000000','samsung moi nhat','fullbox');
INSERT INTO `product` VALUES ('2','AppleIphone12Promax','200000','apple moi nhat','fullbox');
INSERT INTO `product` VALUES ('3','XaomiMi10','1000000','xaomi moi nhat','fullbox');


