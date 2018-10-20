DROP TABLE IF EXISTS `mailrecord`;
CREATE TABLE `mailrecord` (
  `id` bigint(20) NOT NULL,
  `from_address` varchar(64) NOT NULL,
  `to_address` varchar(64) NOT NULL,
  `title` varchar(128) NOT NULL,
  `contents` text NOT NULL,
  `created_time` bigint(20) NOT NULL,
  `updated_time` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `to_address` (`to_address`),
  KEY `from_address` (`from_address`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
