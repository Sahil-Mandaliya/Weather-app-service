--DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `reference_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `reference_id` (`reference_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1

DROP TABLE IF EXISTS `user_city_mapping`;
CREATE TABLE `user_city_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `is_deleted` tinyint DEFAULT 0,
  PRIMARY KEY (`id`),
    INDEX(`city_id`,`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1
