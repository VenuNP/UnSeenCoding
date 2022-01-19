
CREATE TABLE `movies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

