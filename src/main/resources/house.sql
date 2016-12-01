-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `houseId` varchar(20) DEFAULT NULL,
  `houseName` varchar(255) DEFAULT NULL,
  `houseMessage` varchar(255) DEFAULT NULL,
  `housSize` varchar(20) DEFAULT NULL,
  `housePrice` varchar(10) DEFAULT NULL,
  `squareMeterPrice` varchar(10) DEFAULT NULL,
  `otherMessages` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
