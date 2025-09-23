DROP TABLE IF EXISTS `studentdb`;
CREATE TABLE IF NOT EXISTS `studentdb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `course` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

INSERT INTO `studentdb` (`id`, `name`, `course`, `password`) VALUES
(1, 'Manthan', 'CE', 'manthan123'),
(2, 'Takshay', 'CC', 'takshay123'),
(3, 'Dhyey', 'CE', 'dhyey123');
COMMIT;