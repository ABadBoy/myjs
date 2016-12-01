-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `douban`;
CREATE TABLE `douban` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `houseLink` varchar(200) DEFAULT NULL,
  `houseMessage` varchar(255) DEFAULT NULL,
  `userLink` varchar(255) DEFAULT NULL,
  `userNmae` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `response` varchar(100) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
