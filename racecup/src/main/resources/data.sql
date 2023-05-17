--MySQL

INSERT INTO `user` VALUES (37,'vanderpoel','Mathieu','Poel','vanderpoel@gmail.com','$2a$10$cV9kEM3Xk8StYg8uopYvmOjcU4ZWM.1K9qnweb2JyWjDRj71tWXni','Athlete',1),
(38,'VanAert','Wout','Van Aert','vanaert@mail.ru','$2a$10$cV9kEM3Xk8StYg8uopYvmOjcU4ZWM.1K9qnweb2JyWjDRj71tWXni','Athlete',1),
(39,'pidcock','Tom','Pidcock','pidcock@gmail.org','$2a$10$cV9kEM3Xk8StYg8uopYvmOjcU4ZWM.1K9qnweb2JyWjDRj71tWXni','Athlete',1),
(40,'pauline','Pauline','Prevot','prevot@yandex.ru','$2a$10$cV9kEM3Xk8StYg8uopYvmOjcU4ZWM.1K9qnweb2JyWjDRj71tWXni','Athlete',1),
(41,'cortney','Kate','Cortney','cortney@amazon.com','$2a$10$cV9kEM3Xk8StYg8uopYvmOjcU4ZWM.1K9qnweb2JyWjDRj71tWXni','Athlete',1),
(42,'nino1','Nino','Schurter','schurter@uci.org','$2a$10$cV9kEM3Xk8StYg8uopYvmOjcU4ZWM.1K9qnweb2JyWjDRj71tWXni','Athlete',1),
(43,'sagan','Peter','Sagan','sagan@mail.ru','$2a$10$cV9kEM3Xk8StYg8uopYvmOjcU4ZWM.1K9qnweb2JyWjDRj71tWXni','Athlete',1),
(44,'pogachar','Tadej','Pogachar','pogachar@gmail.com','$2a$10$cV9kEM3Xk8StYg8uopYvmOjcU4ZWM.1K9qnweb2JyWjDRj71tWXni','Athlete',1),
(45,'avanchini','Da Silva','Avanchini','avanchini@gmail.com','$2a$10$cV9kEM3Xk8StYg8uopYvmOjcU4ZWM.1K9qnweb2JyWjDRj71tWXni','Athlete',1),
(46,'admin','Admin','Admin','admin@gmail.com','$2a$10$jG8OR8TJIkxTyTEWs7aaKuSLkVdn45I/qhhsG.IeFUDe.GStQe2tW','Admin',1),
(47,'org01','Org1','Org1','organizer1@mail.ru','$2a$10$cV9kEM3Xk8StYg8uopYvmOjcU4ZWM.1K9qnweb2JyWjDRj71tWXni','Organizer',1),
(49,'org02','Org2','Org2','organizer2@mail.ru','$2a$10$cV9kEM3Xk8StYg8uopYvmOjcU4ZWM.1K9qnweb2JyWjDRj71tWXni','Organizer',1),
(50,'user01','Ivan','Ivanov','ivanov@mail.ru','$2a$10$cV9kEM3Xk8StYg8uopYvmOjcU4ZWM.1K9qnweb2JyWjDRj71tWXni','User',1),
(51,'user02','Petr','Petrov','petrov@mail.ru','$2a$10$cV9kEM3Xk8StYg8uopYvmOjcU4ZWM.1K9qnweb2JyWjDRj71tWXni','User',1),
(53,'user03','Sidor','Sidorov','sidorov@mail.ru','$2a$10$cV9kEM3Xk8StYg8uopYvmOjcU4ZWM.1K9qnweb2JyWjDRj71tWXni','User',1),
(55,'user04','Alexandr','Alexandrov','test@mail.ru','$2a$10$n5bT8ZcKD5jmC57W/KWiN.MHzMbwbdYTwoS0VS4VEGODjQFpa6zzq','User',1);


INSERT INTO `athlete` VALUES (37,'1995-01-19','MALE','Netherlands','','Alpecin-Deceuninck'),
(38,'1994-09-15','MALE','Belgium','','Jumbo-Visma'),
(39,'1999-07-30','MALE','Great Britain','','INEOS Grenadiers'),
(40,'1992-02-10','FEMALE','France','','INEOS Grenadiers'),
(41,'1995-10-29','FEMALE','USA','','Scott Sram MTB Racing'),
(42,'1986-05-13','MALE','Switzerland','','Scott Sram MTB Racing'),
(43,'1990-01-26','MALE','Slovakia','','TotalEnergies'),
(44,'1998-09-21','MALE','Slovenia','','UAE Team Emirates'),
(45,'1989-03-30','MALE','Brasil','','CANNONDALE FACTORY RACING');


INSERT INTO `organizer` VALUES (47,'+345678'),(49,'+88943894');


INSERT INTO `admin` VALUES (46);


INSERT INTO `race` VALUES (1,'2','UCI WorldCup stage1','Prague',64.4,'2023-02-05','First stage of UCI World cup championship',2,1),
(2,'1','Vilnius100','Vilnius',108.2,'2023-03-02','Gravel race around Vilnius city',1,1),
(3,'0','Tour de France','France',136.6,'2023-04-22','The most popular road race in the World ',1,1),
(4,'2','UCI WorldCup stage2','Budapest',87.4,'2023-04-27','Second stage of UCI World cup championship',2,1),
(5,'0','LaStrada race','Saint-Petersburg',100,'2023-06-23','New road race in the center of the cultural capital',1,1),
(6,'1','BlocadRace','Vilnius',32.6,'2023-06-25','Time trial gravel race. Vilnius, Lithuania.',1,1),
(7,'2','Koskiyarvi','Saint-Petersburg',98,'2023-08-16','The hardest cross-country race in SPB',1,1),
(8,'2','UCI WorldCup stage3','London',56.2,'2023-08-16','Third stage of UCI World cup championship',2,1);


INSERT INTO `race_result` VALUES (1,45,1,'01:20:00',NULL),
(2,44,1,'01:12:10',NULL),
(3,43,1,'03:13:00',NULL),
(4,42,1,'02:19:15',NULL),
(5,41,1,'01:13:30',NULL),
(6,40,1,'01:13:59',NULL),
(7,39,1,'01:15:00',NULL),
(8,38,1,'01:15:01',NULL),
(9,37,1,'02:00:00',NULL),
(10,37,2,'04:12:15',NULL),
(11,38,2,'04:14:15',NULL),
(12,39,2,'04:40:20',NULL),
(13,40,2,'04:45:15',NULL),
(14,41,2,'04:20:15',NULL),
(15,42,2,'05:17:00',NULL),
(16,43,2,'05:16:35',NULL),
(17,44,2,'06:23:40',NULL),
(18,45,2,'05:13:00',NULL),
(19,44,3,'03:50:19',NULL),
(20,42,3,'03:50:10',NULL),
(21,40,3,'03:50:23',NULL),
(22,38,3,'03:20:44',NULL),
(23,39,3,'03:12:34',NULL),
(24,37,3,'04:10:15',NULL),
(43,37,4,NULL,NULL),
(44,38,4,NULL,NULL),
(45,39,4,NULL,NULL),
(46,40,4,NULL,NULL),
(47,41,4,NULL,NULL),
(48,42,4,NULL,NULL),
(49,43,4,NULL,NULL),
(50,44,4,NULL,NULL),
(51,45,4,NULL,NULL),
(57,0,0,NULL,NULL),
(58,0,0,NULL,NULL),
(59,0,0,NULL,NULL),
(60,0,0,NULL,NULL),
(61,0,0,NULL,NULL),
(62,0,0,NULL,NULL),
(63,0,0,NULL,NULL);


INSERT INTO `hibernate_sequence` VALUES (2);