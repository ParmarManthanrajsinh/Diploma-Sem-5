DROP TABLE IF EXISTS `students`;
CREATE TABLE IF NOT EXISTS `students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `course` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

INSERT INTO `students` (`id`, `name`, `course`) VALUES
(1, 'Manthan', 'CE'),
(2, 'Takshay', 'CC'),
(3, 'Dhyey', 'CE');
COMMIT;