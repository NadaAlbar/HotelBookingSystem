CREATE DATABASE  IF NOT EXISTS `hotelSystem` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `hotelSystem`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: hotel
-- ------------------------------------------------------
-- Server version	5.7.19

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
-- Table structure for table `Hotel`
--

DROP TABLE IF EXISTS `Hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Hotel` (
  `hotel_id` int(11) NOT NULL,
  `hotel_name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Hotel`
--

LOCK TABLES `Hotel` WRITE;
/*!40000 ALTER TABLE `Hotel` DISABLE KEYS */;
INSERT INTO `Hotel` VALUES (1001,'Courtyard Marriott ','310 S. COLLEGE AVENUE','Newyork','(216) 881-3000 '),(1002,'Hampton Inn','1710 N. KINSER PIKE','Washington','(216) 881-4973 '),(1003,'Days Inn ','120 S FAIRFIELD DRIVE','Pittsburgh','(216) 881-4589 '),(1004,'Comfort Inn ','2100 N WALNUT STREET','Los Angeles','(216) 881-3027 '),(1005,'Quality Inn','200 E. STATE ROAD ','Newyork','(216) 881-2424 '),(1006,'Country Heart Inn','1399 LIBERTY DRIVE','Chicago','(216) 432-3505 '),(1007,'A Summerhouse ','2615 EAST THIRD STREET','Miami','(216) 881-3000 '),(1008,'Hilton Garden Inn ','1751 NORTH STONELAKE DRIVE','Orlando','(216) 881-4973 '),(1009,'Bloomington Travelodge','1722 N WALNUT ST','Denver','(216) 881-4589 '),(1010,'Quality Inn','4501 EAST 3RD STREET','Washington','(216) 881-3027 '),(1011,'Country Heart Inn','245 N. COLLEGE AVE','Pittsburgh','(216) 881-2424 '),(1012,'Holiday Inn Express','105 SOUTH FRANKLIN','Pittsburgh','(216) 432-3505 '),(1013,' Super 8 Motel','1399 LIBERTY DRIVE','Las vegas','(216) 881-4589 '),(1014,'Homewood Suites ','117 S. FRANKLIN ROAD ','Cleveland','(216) 881-3027 '),(1015,'','','',''),(1016,'','','',''),(1017,'','','',''),(1018,'','','',''),(1019,'','','',''),(1020,'','','','');
/*!40000 ALTER TABLE `Hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Room`
--



DROP TABLE IF EXISTS `Room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Room` (
  `room_id` int(11) NOT NULL,
  `room_type` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `room_num` varchar(45) DEFAULT NULL,
  `num_guests` varchar(45) DEFAULT NULL,
  `room_status` varchar(45) DEFAULT NULL,
   `hotel` int(11) NOT NULL,
  
  PRIMARY KEY (`room_id`),
  foreign key (hotel) references Hotel(hotel_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Room`
--

LOCK TABLES `Room` WRITE;
/*!40000 ALTER TABLE `Room` DISABLE KEYS */;
INSERT INTO `Room` (room_id, room_type,price,room_num, num_guests, room_status, hotel) VALUES (1012,'queen',190,'123','4','available',1001),(1014,'queen',180,'134','2','available',1002 ),(1016,'queen',170,'234','2','available',1001),(1018,'standard double',200,'532','4','Unavailable', 1002), (1019,'standard double',200,'532','4','Unavailable', 1002),(1020,'queen',199,'455','2','Unavailable', 1003),(1051,'queen',199,'455','2','Unavailable', 1003),(1022,'King',230,'567','2','available', 1004),(1024,'standard double',210,'432','4','available', 1005),(1026,'King',220,'345','2','Unavailable', 1006),(1028,'King',210,'678','2','Unavailable', 1007),(1030,'King',215,'346','2','available',1008),(1032,'twin',199,'643','4','available',1009),(1034,'standard double',194,'536','4','Unavailable',1010),(1036,'standard double',188,'435','4','available', 1011),(1038,'King',201,'577','2','Unavailable',1012),(1040,'junior suite',195,'953','5','available', 1013), (1041,'junior suite',195,'953','5','available', 1013);
/*!40000 ALTER TABLE `Room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `cust_id` int(11)  auto_increment ,
  `Fname` varchar(250) DEFAULT NULL,
  `Lname` varchar(250) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservations` (
  `res_id` int(11) NOT NULL,
  `check_in` date DEFAULT NULL,
  `check_out` date DEFAULT NULL,
  `num_guests` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `trans_id` int(11) NOT NULL,
  `payment_type` varchar(45) DEFAULT NULL,
  `total_price` varchar(45) DEFAULT NULL,
  `card_holder` varchar(45) DEFAULT NULL,
  `card_expire_date` varchar(45) DEFAULT NULL,
  `card_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`trans_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-27  1:41:45


