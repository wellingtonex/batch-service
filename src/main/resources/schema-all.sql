DROP TABLE IF EXISTS autobot;
CREATE TABLE `autobot` (
  `autobot_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `car` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`autobot_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;