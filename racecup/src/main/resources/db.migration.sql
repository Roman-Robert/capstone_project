
CREATE DATABASE IF NOT EXIST 'race_cup';

USE 'race_cup';

DROP TABLE IF EXISTS `hibernate_sequence`;
DROP TABLE IF EXISTS `race_result`;
DROP TABLE IF EXISTS `race`;
DROP TABLE IF EXISTS `admin`;
DROP TABLE IF EXISTS `organizer`;
DROP TABLE IF EXISTS `athlete`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(45) DEFAULT 'user',
  `is_active` int DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `athlete` (
  `id` int NOT NULL,
  `birthday` varchar(25) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `country` varchar(45) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  `team` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `organizer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mobile_phone` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `admin` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `race` (
  `id` int NOT NULL AUTO_INCREMENT,
  `race_type` varchar(25) NOT NULL,
  `name` varchar(45) NOT NULL,
  `location` varchar(64) NOT NULL,
  `distance_km` double NOT NULL,
  `date` varchar(25) NOT NULL,
  `info` varchar(255) NOT NULL,
  `organizer_id` int NOT NULL,
  `is_actual` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `race_result` (
  `result_id` int NOT NULL AUTO_INCREMENT,
  `athlete_id` int NOT NULL,
  `race_id` int NOT NULL,
  `transit_time` time DEFAULT NULL,
  `status` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`result_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
