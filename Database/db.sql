-- MySQL dump 10.13  Distrib 5.5.17, for Win64 (x86)
--
-- Host: localhost    Database: dbms
-- ------------------------------------------------------
-- Server version	5.5.17

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
create database dbms;
use dbms;
--
-- Table structure for table `airconditioner`
--

DROP TABLE IF EXISTS `airconditioner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airconditioner` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Company`,`ProductName`),
  KEY `dealerid` (`dealerid`),
  CONSTRAINT `airconditioner_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airconditioner`
--

LOCK TABLES `airconditioner` WRITE;
/*!40000 ALTER TABLE `airconditioner` DISABLE KEYS */;
INSERT INTO `airconditioner` VALUES ('Lloyd','Window_3ton',3,25000,'D101'),('Voltas ','Split_2ton',3,40000,'D100');
/*!40000 ALTER TABLE `airconditioner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('AirConditioner'),('Fan'),('LCD'),('LED'),('Microwave'),('Refrigerator'),('Smartphones'),('WashingMachine'),('WaterPurifier');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dealer`
--

DROP TABLE IF EXISTS `dealer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dealer` (
  `Dealer_ID` varchar(20) NOT NULL DEFAULT '',
  `Name` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Contact_No` bigint(20) NOT NULL,
  `Tin_No` bigint(20) NOT NULL,
  PRIMARY KEY (`Dealer_ID`),
  UNIQUE KEY `Tin_No` (`Tin_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dealer`
--

LOCK TABLES `dealer` WRITE;
/*!40000 ALTER TABLE `dealer` DISABLE KEYS */;
INSERT INTO `dealer` VALUES ('D100','Suresh','Male','Allahabad',9632587410,12365478969),('D101','Mukesh','Male','Allahabad',8523697410,98745632102),('D102','Lokesh','Male','Allahabad',7412589630,25874136960),('D103','Mandakini','Female','Varanasi',7896541230,10000000002);
/*!40000 ALTER TABLE `dealer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `Emp_ID` varchar(10) NOT NULL DEFAULT '',
  `Name` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Contact_No` bigint(20) NOT NULL,
  `Adhaar_No` bigint(20) NOT NULL,
  PRIMARY KEY (`Emp_ID`),
  UNIQUE KEY `Adhaar_No` (`Adhaar_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('E100','Manu','Male','Naini',9873214560,123654789632),('E101','Arun','Male','Agra',7896541258,125478963258),('E102','Vimla','Female','Lucknow',7854123658,147852369321);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fan`
--

DROP TABLE IF EXISTS `fan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fan` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Company`,`ProductName`),
  KEY `dealerid` (`dealerid`),
  CONSTRAINT `fan_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fan`
--

LOCK TABLES `fan` WRITE;
/*!40000 ALTER TABLE `fan` DISABLE KEYS */;
INSERT INTO `fan` VALUES ('rtyy','ds',12,2000,'D100');
/*!40000 ALTER TABLE `fan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lcd`
--

DROP TABLE IF EXISTS `lcd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lcd` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Company`,`ProductName`),
  KEY `dealerid` (`dealerid`),
  CONSTRAINT `lcd_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lcd`
--

LOCK TABLES `lcd` WRITE;
/*!40000 ALTER TABLE `lcd` DISABLE KEYS */;
INSERT INTO `lcd` VALUES ('Panasonic','Panaroma_42',3,100000,'D101'),('Sony','Bravia_32',6,45000,'D100');
/*!40000 ALTER TABLE `lcd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `led`
--

DROP TABLE IF EXISTS `led`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `led` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Company`,`ProductName`),
  KEY `dealerid` (`dealerid`),
  CONSTRAINT `led_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `led`
--

LOCK TABLES `led` WRITE;
/*!40000 ALTER TABLE `led` DISABLE KEYS */;
INSERT INTO `led` VALUES ('LG','Avado_24',6,25000,'D103'),('Samsung','Ultrahd_56',2,200000,'D102');
/*!40000 ALTER TABLE `led` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `microwave`
--

DROP TABLE IF EXISTS `microwave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `microwave` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Company`,`ProductName`),
  KEY `dealerid` (`dealerid`),
  CONSTRAINT `microwave_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `microwave`
--

LOCK TABLES `microwave` WRITE;
/*!40000 ALTER TABLE `microwave` DISABLE KEYS */;
INSERT INTO `microwave` VALUES ('Elctrolux','Grill_20',5,9000,'D102'),('LG','Convection_22',2,16000,'D100');
/*!40000 ALTER TABLE `microwave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `bill_id` varchar(5) NOT NULL DEFAULT '',
  `payment_mode` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('B100','Card'),('B101','Cheque'),('B102','cash');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchased_item`
--

DROP TABLE IF EXISTS `purchased_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchased_item` (
  `Bill_Id` varchar(10) NOT NULL DEFAULT '',
  `Company` varchar(20) NOT NULL,
  `Product` varchar(20) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` bigint(20) NOT NULL,
  `Dealer_ID` varchar(20) DEFAULT NULL,
  `date` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Bill_Id`),
  KEY `Dealer_ID` (`Dealer_ID`),
  CONSTRAINT `purchased_item_ibfk_1` FOREIGN KEY (`Dealer_ID`) REFERENCES `dealer` (`Dealer_ID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchased_item`
--

LOCK TABLES `purchased_item` WRITE;
/*!40000 ALTER TABLE `purchased_item` DISABLE KEYS */;
INSERT INTO `purchased_item` VALUES ('B1000','Voltas ','Split_2ton',6,40000,'D100','2017-03-26'),('B1001','Lloyd','Window_3ton',4,25000,'D101','2017-03-27'),('B1002','Sony','Bravia_32',6,45000,'D100','2017-02-28'),('B1003','Panasonic','Panaroma_42',3,100000,'D101','2017-02-22'),('B1004','LG','Avado_24',6,25000,'D103','2017-05-03'),('B1005','Samsung','Ultrahd_56',2,200000,'D102','2017-05-15'),('B1006','LG','Convection_22',2,16000,'D100','2017-03-14'),('B1007','Elctrolux','Grill_20',5,9000,'D102','2017-03-14'),('B1008','Samsung','Doubledoor_500',2,250000,'D100','2017-03-14'),('B1009','LG','Halun_110',3,30000,'D101','2017-02-27'),('B1010','Apple','Iphone7',3,70000,'D100','2017-03-10'),('B1011','Samsung','GalaxyS7',3,40000,'D102','2017-03-10'),('B1012','Whirlpool','Automatic_7',2,15000,'D103','2017-04-05'),('B1013','IFB','Manual_5',6,7000,'D100','2017-04-09'),('B1014','EurekaForbes','Aquaguard',6,15000,'D102','2017-04-03'),('B1015','Kent','ManualRO_10',3,7000,'D100','2017-04-03'),('B1016','rtyy','ds',12,2000,'D100','2017-03-27');
/*!40000 ALTER TABLE `purchased_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refrigerator`
--

DROP TABLE IF EXISTS `refrigerator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `refrigerator` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Company`,`ProductName`),
  KEY `dealerid` (`dealerid`),
  CONSTRAINT `refrigerator_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refrigerator`
--

LOCK TABLES `refrigerator` WRITE;
/*!40000 ALTER TABLE `refrigerator` DISABLE KEYS */;
INSERT INTO `refrigerator` VALUES ('LG','Halun_110',3,30000,'D101'),('Samsung','Doubledoor_500',2,250000,'D100');
/*!40000 ALTER TABLE `refrigerator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `security`
--

DROP TABLE IF EXISTS `security`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `security` (
  `Question` varchar(100) DEFAULT NULL,
  `Answer` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `security`
--

LOCK TABLES `security` WRITE;
/*!40000 ALTER TABLE `security` DISABLE KEYS */;
INSERT INTO `security` VALUES ('What is the name of your First Dog?','Max'),('Where your Mother was born?','Delhi'),('Which was the first book you read?','The Kite Runner');
/*!40000 ALTER TABLE `security` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `smartphones`
--

DROP TABLE IF EXISTS `smartphones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `smartphones` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Company`,`ProductName`),
  KEY `dealerid` (`dealerid`),
  CONSTRAINT `smartphones_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `smartphones`
--

LOCK TABLES `smartphones` WRITE;
/*!40000 ALTER TABLE `smartphones` DISABLE KEYS */;
INSERT INTO `smartphones` VALUES ('Apple','Iphone7',1,70000,'D100'),('Samsung','GalaxyS7',3,40000,'D102');
/*!40000 ALTER TABLE `smartphones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sold_item`
--

DROP TABLE IF EXISTS `sold_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sold_item` (
  `billid` varchar(100) NOT NULL DEFAULT '',
  `Prot` varchar(100) NOT NULL,
  `Pron` varchar(100) NOT NULL,
  `quantity` int(5) NOT NULL,
  `cname` varchar(100) NOT NULL,
  `addr` varchar(100) NOT NULL,
  `pno` varchar(12) NOT NULL,
  `date` varchar(10) NOT NULL,
  `total` int(8) NOT NULL,
  `Empid` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`billid`),
  KEY `Empid` (`Empid`),
  CONSTRAINT `sold_item_ibfk_1` FOREIGN KEY (`Empid`) REFERENCES `employee` (`Emp_ID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sold_item`
--

LOCK TABLES `sold_item` WRITE;
/*!40000 ALTER TABLE `sold_item` DISABLE KEYS */;
INSERT INTO `sold_item` VALUES ('B100','Smartphones','Apple-Iphone7',1,'Pushpendra','Jaipur','7418529632','2017-03-27',70000,'E100'),('B101','AirConditioner','Lloyd-Window_3ton',1,'Suyog','Bhilwara','9630852741','2017-03-28',25000,'E100'),('B102','Smartphones','Apple-Iphone7',1,'pranjal','Allahabad','4563217895','2017-03-26',70000,'E100');
/*!40000 ALTER TABLE `sold_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(40) DEFAULT NULL,
  `Password` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','qwerty');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warranty`
--

DROP TABLE IF EXISTS `warranty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warranty` (
  `bill_id` varchar(5) NOT NULL DEFAULT '',
  `prdct_name` varchar(40) DEFAULT NULL,
  `owner_name` varchar(40) DEFAULT NULL,
  `date` varchar(10) DEFAULT NULL,
  `warranty` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warranty`
--

LOCK TABLES `warranty` WRITE;
/*!40000 ALTER TABLE `warranty` DISABLE KEYS */;
INSERT INTO `warranty` VALUES ('b100','Voltas -Split_2ton','Pranav','2017-04-11','Return'),('B102','Apple-Iphone7','pranjal','2017-03-26','Return');
/*!40000 ALTER TABLE `warranty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `washingmachine`
--

DROP TABLE IF EXISTS `washingmachine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `washingmachine` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Company`,`ProductName`),
  KEY `dealerid` (`dealerid`),
  CONSTRAINT `washingmachine_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `washingmachine`
--

LOCK TABLES `washingmachine` WRITE;
/*!40000 ALTER TABLE `washingmachine` DISABLE KEYS */;
INSERT INTO `washingmachine` VALUES ('IFB','Manual_5',6,7000,'D100'),('Whirlpool','Automatic_7',2,15000,'D103');
/*!40000 ALTER TABLE `washingmachine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waterpurifier`
--

DROP TABLE IF EXISTS `waterpurifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `waterpurifier` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Company`,`ProductName`),
  KEY `dealerid` (`dealerid`),
  CONSTRAINT `waterpurifier_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waterpurifier`
--

LOCK TABLES `waterpurifier` WRITE;
/*!40000 ALTER TABLE `waterpurifier` DISABLE KEYS */;
INSERT INTO `waterpurifier` VALUES ('EurekaForbes','Aquaguard',4,15000,'D102'),('Kent','ManualRO_10',3,7000,'D100');
/*!40000 ALTER TABLE `waterpurifier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-29 13:01:21
