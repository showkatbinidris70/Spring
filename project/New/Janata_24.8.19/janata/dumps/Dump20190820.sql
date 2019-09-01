-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: janata
-- ------------------------------------------------------
-- Server version	5.7.15-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `airways`
--

DROP TABLE IF EXISTS `airways`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airways` (
  `id` bigint(20) NOT NULL,
  `airways_name` varchar(30) NOT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airways`
--

LOCK TABLES `airways` WRITE;
/*!40000 ALTER TABLE `airways` DISABLE KEYS */;
INSERT INTO `airways` VALUES (9,'skybd','01921839596','skybd@gmail.com'),(10,'BimanBangladesh','01921839525','bimanbd@gmail.com'),(11,'arabian','01921839596','arabian@gmail.com'),(12,'dubai','01921839545','dubai@gmail.com'),(13,'ukbangla','01921839596','usbangla@gmail.com'),(14,'bonkabangla@gmail.com','01745896554','showkatbinidris70@gmail.com');
/*!40000 ALTER TABLE `airways` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `manager_name` varchar(255) DEFAULT NULL,
  `compnany_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q5alqrisfvpjk2t07gw4sofe` (`email`),
  KEY `FKgp13t2y22a44ae75ptc5fwekh` (`compnany_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (15,'kishorejong','564','01921839596','bangladesh','showkatbinidris70@gmail.com','showkat',1),(16,'Uttara','564','01921839545','bangladesh','jabber@gmail.com','Jabber',1),(17,'Dahnmondi','Motin20','01921839596','bangladesh','motin@gmail.com','Motin',1),(18,'Khilkhet','s40','01921839596','bangladesh','sabbir@gmail.com','Sabbir',1),(19,'Mirpur','m50','01745896554','bangladesh','monir@gmail.com','Monir',1);
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `estd_date` date DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `reg_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'dhaka','janata','01921839596','janata@gmail.com','2019-08-05','dhaka','janata2020');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `booking_date` datetime DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `delivery_date` datetime DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `compnany_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK532xb0ja1eadwswf680i3mnlk` (`compnany_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (20,'dhaka','2019-08-19 11:16:31','01745896551','bangladesh','showkat','2019-08-19 11:16:31','dhaka','showkatbinidris70@gmail.com','dhaka',1),(21,'dhaka','2019-08-19 11:17:06','01921839525','bangladesh','Sobor','2019-08-19 11:17:06','dhaka','sobor@gmail.com','dhaka',1),(22,'btgyu','2019-08-19 11:17:49','01921839545','bangladesh','Kartick','2019-08-19 11:17:49','dhaka','kartock@gmail.com','rtyui',1),(23,'dhaka','2019-08-19 11:18:29','01921839520','bangladesh','Kanok','2019-08-19 11:18:29','dhaka','konok@gmail.com','dhaka',1),(24,'india','2019-08-19 11:19:25','0174589655','India','Kashem','2019-08-19 11:19:25','karnakata','karnakata@gmail.com','karnakata',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distribution_details`
--

DROP TABLE IF EXISTS `distribution_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distribution_details` (
  `id` bigint(20) NOT NULL,
  `booking_date` date DEFAULT NULL,
  `customer_details` varchar(255) DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  `delivery_type` varchar(255) DEFAULT NULL,
  `height` varchar(255) DEFAULT NULL,
  `lenght` varchar(255) DEFAULT NULL,
  `parcel_name` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distribution_details`
--

LOCK TABLES `distribution_details` WRITE;
/*!40000 ALTER TABLE `distribution_details` DISABLE KEYS */;
INSERT INTO `distribution_details` VALUES (49,NULL,'Potul','2019-08-22','cash','455','42','pencard','12'),(50,'2019-08-20','habir','2019-08-23','cradit','60','12','sugar','50');
/*!40000 ALTER TABLE `distribution_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` tinyint(4) NOT NULL,
  `birth_date` datetime DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `joining_date` datetime DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `branch_id` bigint(20) DEFAULT NULL,
  `compnany_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcvhlsx8tao1rxt7mpxrot61jt` (`branch_id`),
  KEY `FK3asht00qsdk4asox1ve0ulwus` (`compnany_id`),
  KEY `FK6lk0xml9r7okjdq0onka4ytju` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (25,'dhaka',50,'2019-08-19 11:21:01','b+','01921839596','showkatbinidris70@gmail.com','Showkat','male','2019-08-19 11:21:01',' Ali',25000,15,1,1),(26,'sylhet',30,'2019-08-19 11:22:13','ab+','01745896554','skybd@gmail.com','kauser','male','2019-08-19 11:22:13','Miah',35000,16,1,2),(27,'Lalmonirhut',28,'2019-08-19 11:25:50','b+','01921839525','skbd@gmail.com','kader','male','2019-08-19 11:25:50','Miah',26000,17,1,1),(28,'Kalkata',54,'2019-08-19 11:29:07','ab+','01745896554','sifu@gmail.com','Siful','male','2019-08-19 11:29:07',' Ali',42000,18,1,1),(29,'Lalmonirhut',25,'2019-08-19 11:29:44','ab+','0174589655','sdfgsdg@gmail.com','Abul','male','2019-08-19 11:29:44','Miah',25000,19,1,2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (51),(51),(51),(51),(51),(51),(51),(51),(51),(51),(51);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packing`
--

DROP TABLE IF EXISTS `packing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `packing` (
  `id` bigint(20) NOT NULL,
  `packing_code` varchar(255) DEFAULT NULL,
  `send_date` datetime DEFAULT NULL,
  `branch_id` bigint(20) DEFAULT NULL,
  `compnany_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK34a2oets0xd9nvity0y96juo` (`branch_id`),
  KEY `FKsre44te6v2wi5lhsr37t43v73` (`compnany_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packing`
--

LOCK TABLES `packing` WRITE;
/*!40000 ALTER TABLE `packing` DISABLE KEYS */;
INSERT INTO `packing` VALUES (44,'topten','2019-08-19 11:46:13',15,1),(45,'eight','2019-08-19 11:46:30',17,1);
/*!40000 ALTER TABLE `packing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packing_parcel`
--

DROP TABLE IF EXISTS `packing_parcel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `packing_parcel` (
  `packing_id` bigint(20) NOT NULL,
  `parcel_id` bigint(20) NOT NULL,
  PRIMARY KEY (`packing_id`,`parcel_id`),
  KEY `FKs1m3bpt9a8nbyvax7pbnh1o1s` (`parcel_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packing_parcel`
--

LOCK TABLES `packing_parcel` WRITE;
/*!40000 ALTER TABLE `packing_parcel` DISABLE KEYS */;
INSERT INTO `packing_parcel` VALUES (44,40),(45,41);
/*!40000 ALTER TABLE `packing_parcel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parcel`
--

DROP TABLE IF EXISTS `parcel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parcel` (
  `id` bigint(20) NOT NULL,
  `booking_date` datetime DEFAULT NULL,
  `cost` varchar(255) DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  `height` varchar(255) DEFAULT NULL,
  `length` varchar(255) DEFAULT NULL,
  `parcel_name` varchar(30) NOT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  `received_to` varchar(255) DEFAULT NULL,
  `send_country` varchar(255) DEFAULT NULL,
  `send_from` varchar(255) DEFAULT NULL,
  `send_state` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `branch_id` bigint(20) DEFAULT NULL,
  `compnany_id` bigint(20) DEFAULT NULL,
  `shipping_details_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn8mp6ptamquplwnrvuygehdh9` (`branch_id`),
  KEY `FKeva991chxber89x0l2fm9xxj5` (`compnany_id`),
  KEY `FK46y8y9ruhkxhm5x44ggmvraif` (`shipping_details_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parcel`
--

LOCK TABLES `parcel` WRITE;
/*!40000 ALTER TABLE `parcel` DISABLE KEYS */;
INSERT INTO `parcel` VALUES (48,'2019-08-20 09:56:44','50000','2019-08-24','400','56','Kahata','parcel','india','fgfgh','bangladesh','Japan','10',15,1,35);
/*!40000 ALTER TABLE `parcel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receiving_details`
--

DROP TABLE IF EXISTS `receiving_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receiving_details` (
  `id` bigint(20) NOT NULL,
  `receiver_name` varchar(255) DEFAULT NULL,
  `receiving_date` datetime DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `destinationbranch_id` bigint(20) DEFAULT NULL,
  `sendingbranch_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKovcbh6tkyifack33ffika6xu5` (`employee_id`),
  KEY `FK8vb4o3wpq79560qoakc0fjg5s` (`destinationbranch_id`),
  KEY `FKd20fauvcmbjxy4vyujq8l5xe4` (`sendingbranch_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receiving_details`
--

LOCK TABLES `receiving_details` WRITE;
/*!40000 ALTER TABLE `receiving_details` DISABLE KEYS */;
INSERT INTO `receiving_details` VALUES (47,'Kader','2019-08-19 11:47:10',26,16,15);
/*!40000 ALTER TABLE `receiving_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recivings_packing`
--

DROP TABLE IF EXISTS `recivings_packing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recivings_packing` (
  `sending_details_id` bigint(20) NOT NULL,
  `packing_id` bigint(20) NOT NULL,
  PRIMARY KEY (`sending_details_id`,`packing_id`),
  UNIQUE KEY `UK_huqv8418txgke9agnm06wlstb` (`packing_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recivings_packing`
--

LOCK TABLES `recivings_packing` WRITE;
/*!40000 ALTER TABLE `recivings_packing` DISABLE KEYS */;
INSERT INTO `recivings_packing` VALUES (47,45);
/*!40000 ALTER TABLE `recivings_packing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iubw515ff0ugtm28p8g3myt0h` (`role_name`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'supervisor'),(3,'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sending_details`
--

DROP TABLE IF EXISTS `sending_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sending_details` (
  `id` bigint(20) NOT NULL,
  `sender_name` varchar(255) DEFAULT NULL,
  `sending_date` datetime DEFAULT NULL,
  `destinationbranch_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `sendingbranch_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnn73uqjici95796rw21bjvrcx` (`destinationbranch_id`),
  KEY `FKqbbkwjbo1ionf1u94bijwctyr` (`employee_id`),
  KEY `FKj8omnp2cekaurnc6yob2b2rsd` (`sendingbranch_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sending_details`
--

LOCK TABLES `sending_details` WRITE;
/*!40000 ALTER TABLE `sending_details` DISABLE KEYS */;
INSERT INTO `sending_details` VALUES (46,'Saddam','2019-08-19 11:46:53',16,28,15);
/*!40000 ALTER TABLE `sending_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sending_packing`
--

DROP TABLE IF EXISTS `sending_packing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sending_packing` (
  `sending_details_id` bigint(20) NOT NULL,
  `packing_id` bigint(20) NOT NULL,
  PRIMARY KEY (`sending_details_id`,`packing_id`),
  UNIQUE KEY `UK_pbdm9qae5xl578crfd6ppa5ff` (`packing_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sending_packing`
--

LOCK TABLES `sending_packing` WRITE;
/*!40000 ALTER TABLE `sending_packing` DISABLE KEYS */;
INSERT INTO `sending_packing` VALUES (46,45);
/*!40000 ALTER TABLE `sending_packing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_details`
--

DROP TABLE IF EXISTS `shipping_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipping_details` (
  `id` bigint(20) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `flight_no` varchar(255) DEFAULT NULL,
  `mobile_no` varchar(255) DEFAULT NULL,
  `reciever_name` varchar(255) DEFAULT NULL,
  `road_no` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping_details`
--

LOCK TABLES `shipping_details` WRITE;
/*!40000 ALTER TABLE `shipping_details` DISABLE KEYS */;
INSERT INTO `shipping_details` VALUES (35,'dhaka','Australia','bd480','australia@gmail.com','Kashem Akbur','dhaka','india'),(36,'dhaka','japan','bd480','austraia@gmail.com',' Akbur','dhaka','dhaka '),(37,'dhaka','bangladesh','bd480','autralia@gmail.com','Kashem','dhaka','india'),(38,'dhaka','bangladesh','bd480','austraia@gmail.com','Abul Miah','dhaka','karnakata'),(39,'dhaka','India','bd480','austria@gmail.com','Kashem Miah','dhaka','dhaka ');
/*!40000 ALTER TABLE `shipping_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` tinyint(4) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `regi_date` datetime DEFAULT NULL,
  `user_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_cnjwxx5favk5ycqajjt17fwy1` (`mobile`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'dhaka',26,'2019-08-10','alamgir@gmail.com','Alarmgir','male','2019-08-19 11:00:16','Hossen','01954645645','2019-08-19 11:00:16','Alamgir '),(2,'dhaka',36,'2019-08-07','siful@gmail.com','Siful','male','2019-08-19 11:01:41','Miah','01924624564','2019-08-19 11:01:41','Siful Miah'),(3,'dhaka',28,'2019-08-14','kashem@gmail.com','Abul','male','2019-08-19 11:02:53','Kashem','01924624562','2019-08-19 11:02:53','Abul Kashem');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2),(3,3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'janata'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-20 12:32:14
