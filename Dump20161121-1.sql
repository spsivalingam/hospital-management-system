-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: hms
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrator` (
  `admin_id` int(10) NOT NULL,
  PRIMARY KEY (`admin_id`),
  CONSTRAINT `administrator_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (3);
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admittedpatients`
--

DROP TABLE IF EXISTS `admittedpatients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admittedpatients` (
  `patient_id` int(10) NOT NULL,
  `ward_id` int(7) NOT NULL,
  `operator_id` int(10) NOT NULL,
  `bed_number` int(5) DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  KEY `ward_id` (`ward_id`),
  KEY `operator_id` (`operator_id`),
  CONSTRAINT `admittedpatients_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  CONSTRAINT `admittedpatients_ibfk_2` FOREIGN KEY (`ward_id`) REFERENCES `wards` (`ward_id`),
  CONSTRAINT `admittedpatients_ibfk_3` FOREIGN KEY (`operator_id`) REFERENCES `operator` (`operator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admittedpatients`
--

LOCK TABLES `admittedpatients` WRITE;
/*!40000 ALTER TABLE `admittedpatients` DISABLE KEYS */;
/*!40000 ALTER TABLE `admittedpatients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ambulance`
--

DROP TABLE IF EXISTS `ambulance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ambulance` (
  `ambulance_no` varchar(20) NOT NULL,
  `driver_first_name` varchar(20) NOT NULL,
  `driver_last_name` varchar(20) NOT NULL,
  PRIMARY KEY (`ambulance_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ambulance`
--

LOCK TABLES `ambulance` WRITE;
/*!40000 ALTER TABLE `ambulance` DISABLE KEYS */;
/*!40000 ALTER TABLE `ambulance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointment` (
  `apt_no` int(15) NOT NULL AUTO_INCREMENT,
  `operator_id` int(10) NOT NULL,
  `patient_id` int(10) NOT NULL,
  `doctor_id` int(10) NOT NULL,
  `apt_time` datetime NOT NULL,
  PRIMARY KEY (`apt_no`),
  KEY `operator_id` (`operator_id`),
  KEY `patient_id` (`patient_id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`operator_id`) REFERENCES `operator` (`operator_id`),
  CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  CONSTRAINT `appointment_ibfk_3` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,4,1,1,'2016-12-04 03:30:00');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger chk_date before insert
 on appointment 
 
      for each row 
       begin  
      if  new.apt_time<current_timestamp() then
       SIGNAL SQLSTATE '45000'   
       SET MESSAGE_TEXT = 'Cannot add or update row: only';
       end if; 
    end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `bloodgroup`
--

DROP TABLE IF EXISTS `bloodgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bloodgroup` (
  `blood_group_name` varchar(50) NOT NULL,
  `quantity` int(10) NOT NULL,
  PRIMARY KEY (`blood_group_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloodgroup`
--

LOCK TABLES `bloodgroup` WRITE;
/*!40000 ALTER TABLE `bloodgroup` DISABLE KEYS */;
INSERT INTO `bloodgroup` VALUES ('A+',4),('A-',3),('AB+',9),('AB-',5),('B+',1),('B-',4),('O+',4),('O-',4);
/*!40000 ALTER TABLE `bloodgroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `doctor_id` int(10) NOT NULL,
  `degree` varchar(8) NOT NULL,
  `specialization` varchar(10) NOT NULL,
  `in_time` time DEFAULT NULL,
  `out_time` time DEFAULT NULL,
  PRIMARY KEY (`doctor_id`),
  CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'dhnfkjh','jsdkhksd','04:20:00','06:02:00'),(2,'dgdgg','bbb',NULL,NULL);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emergencycasedetails`
--

DROP TABLE IF EXISTS `emergencycasedetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emergencycasedetails` (
  `case_id` int(20) NOT NULL AUTO_INCREMENT,
  `emergencymanager_id` int(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `addr_line1` varchar(30) NOT NULL,
  `addr_line2` varchar(30) NOT NULL,
  `city` varchar(20) NOT NULL,
  `zip_code` varchar(6) NOT NULL,
  `mobile_number` char(10) NOT NULL,
  PRIMARY KEY (`case_id`),
  UNIQUE KEY `mobile_number` (`mobile_number`),
  KEY `emergencymanager_id` (`emergencymanager_id`),
  CONSTRAINT `emergencycasedetails_ibfk_1` FOREIGN KEY (`emergencymanager_id`) REFERENCES `emergencymanager` (`emergencymanager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emergencycasedetails`
--

LOCK TABLES `emergencycasedetails` WRITE;
/*!40000 ALTER TABLE `emergencycasedetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `emergencycasedetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emergencymanager`
--

DROP TABLE IF EXISTS `emergencymanager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emergencymanager` (
  `emergencymanager_id` int(20) NOT NULL,
  PRIMARY KEY (`emergencymanager_id`),
  CONSTRAINT `emergencymanager_ibfk_1` FOREIGN KEY (`emergencymanager_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emergencymanager`
--

LOCK TABLES `emergencymanager` WRITE;
/*!40000 ALTER TABLE `emergencymanager` DISABLE KEYS */;
INSERT INTO `emergencymanager` VALUES (1),(2),(3),(4);
/*!40000 ALTER TABLE `emergencymanager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `employee_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(15) NOT NULL,
  `pass` varchar(15) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `addr_line1` varchar(30) DEFAULT NULL,
  `addr_line2` varchar(30) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `zip_code` varchar(6) DEFAULT NULL,
  `email_id_1` varchar(20) NOT NULL,
  `email_id_2` varchar(20) DEFAULT NULL,
  `mobile_number` char(10) NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `user_name` (`user_name`),
  UNIQUE KEY `email_id_1` (`email_id_1`),
  UNIQUE KEY `mobile_number` (`mobile_number`),
  UNIQUE KEY `email_id_2` (`email_id_2`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Dhenuka','Dhenuka','Rangam','DhenukaBhargavi','516 Barton Creek Dr.','Apt-A','Charlotte','28262','rang@gmaik.com','drang@unnj.edu','8095481823'),(2,'Venkat','Venkat','hgjj','chkjs','hj','hjh','jhh','86345','vn@hgg','h@hhhh','9999999999'),(3,'Siva','Siva','gg','hh','ggg','ggg','ggg','23456','gg@gg','ggg@fff','1234567890'),(4,'Satish','Satish','svds','sdcd','hhh','hhh','hhhh','67890','g@gg','gg@gggk','7894561230'),(5,'Ripu','Ripu','Rangam','sfdsfsdf','sdd','sdfd','ch','12345','sfsd@ddfsfd','ssfd@sgs','2345678777'),(6,'Dhamani','Dhamani','bbhhh','bb','bb','bb','bb','23456','hhhi@hhh','hhffh@hhhh','1111111112'),(7,'Dharani','Dharani','bbhhh','bb','bb','bb','bb','23456','hhaah@hhh','rrhh@hhhh','7894561231'),(8,'ddd','ddd','dd','dddd','ddd','ddd','dddd','12345','ddd@unnuu','ddd@uncc','1234567899');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `item_name` varchar(30) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `quantity` int(10) DEFAULT NULL,
  PRIMARY KEY (`item_name`),
  UNIQUE KEY `item_name` (`item_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES ('1','ssdvd',5),('keys','description',3),('kjfhaj','ffdf',1),('OxygenMasks','hdhhd',4),('Red1','assads',45),('Saline','hdhhd',0),('Stethescope','hdhhd',4);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger chk_quantity before insert on inventory 
      for each row 
       begin  
      if  new.quantity<0 then
       SIGNAL SQLSTATE '45000'   
       SET MESSAGE_TEXT = 'Cannot add or update row: only';
       end if; 
    end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `inventory_manager`
--

DROP TABLE IF EXISTS `inventory_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory_manager` (
  `inv_manager_id` int(10) NOT NULL,
  PRIMARY KEY (`inv_manager_id`),
  CONSTRAINT `inventory_manager_ibfk_1` FOREIGN KEY (`inv_manager_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_manager`
--

LOCK TABLES `inventory_manager` WRITE;
/*!40000 ALTER TABLE `inventory_manager` DISABLE KEYS */;
INSERT INTO `inventory_manager` VALUES (5),(6);
/*!40000 ALTER TABLE `inventory_manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `labincharge`
--

DROP TABLE IF EXISTS `labincharge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `labincharge` (
  `labincharge_id` int(10) NOT NULL,
  `laboratory` varchar(50) NOT NULL,
  PRIMARY KEY (`labincharge_id`),
  CONSTRAINT `labincharge_ibfk_1` FOREIGN KEY (`labincharge_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `labincharge`
--

LOCK TABLES `labincharge` WRITE;
/*!40000 ALTER TABLE `labincharge` DISABLE KEYS */;
/*!40000 ALTER TABLE `labincharge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operator`
--

DROP TABLE IF EXISTS `operator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operator` (
  `operator_id` int(10) NOT NULL,
  PRIMARY KEY (`operator_id`),
  CONSTRAINT `operator_ibfk_1` FOREIGN KEY (`operator_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operator`
--

LOCK TABLES `operator` WRITE;
/*!40000 ALTER TABLE `operator` DISABLE KEYS */;
INSERT INTO `operator` VALUES (4);
/*!40000 ALTER TABLE `operator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `patient_id` int(10) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(20) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `patient_type` varchar(10) DEFAULT NULL,
  `addr_line1` varchar(30) DEFAULT NULL,
  `addr_line2` varchar(30) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `zip_code` varchar(6) DEFAULT NULL,
  `email_id_1` varchar(20) NOT NULL,
  `email_id_2` varchar(20) DEFAULT NULL,
  `mobile_number` char(10) NOT NULL,
  `e_mobile_number` char(10) NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `email_id_1` (`email_id_1`),
  UNIQUE KEY `mobile_number` (`mobile_number`),
  UNIQUE KEY `e_mobile_number` (`e_mobile_number`),
  UNIQUE KEY `email_id_2` (`email_id_2`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'Reddy','Dhenuka','female',NULL,'3-4-148','sdssd','sfdsfd','23455','dsd@ggg','ssdffd@dgdg','7894561230','7894561230');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_records`
--

DROP TABLE IF EXISTS `patient_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_records` (
  `record_id` int(15) NOT NULL AUTO_INCREMENT,
  `patient_id` int(10) NOT NULL,
  `doctor_id` int(10) NOT NULL,
  `operator_id` int(10) NOT NULL,
  `disease` varchar(25) NOT NULL,
  `comments` varchar(160) DEFAULT NULL,
  `Created_on` datetime NOT NULL,
  PRIMARY KEY (`record_id`),
  KEY `operator_id` (`operator_id`),
  KEY `patient_id` (`patient_id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `patient_records_ibfk_1` FOREIGN KEY (`operator_id`) REFERENCES `operator` (`operator_id`),
  CONSTRAINT `patient_records_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  CONSTRAINT `patient_records_ibfk_3` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_records`
--

LOCK TABLES `patient_records` WRITE;
/*!40000 ALTER TABLE `patient_records` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patienttestresults`
--

DROP TABLE IF EXISTS `patienttestresults`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patienttestresults` (
  `test_id` int(20) NOT NULL AUTO_INCREMENT,
  `patient_id` int(10) NOT NULL,
  `labincharge_id` int(10) NOT NULL,
  `test_name` varchar(50) NOT NULL,
  `test_result` varchar(200) NOT NULL,
  `test_taken_on` datetime NOT NULL,
  PRIMARY KEY (`test_id`),
  KEY `patient_id` (`patient_id`),
  KEY `labincharge_id` (`labincharge_id`),
  CONSTRAINT `patienttestresults_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  CONSTRAINT `patienttestresults_ibfk_2` FOREIGN KEY (`labincharge_id`) REFERENCES `labincharge` (`labincharge_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patienttestresults`
--

LOCK TABLES `patienttestresults` WRITE;
/*!40000 ALTER TABLE `patienttestresults` DISABLE KEYS */;
/*!40000 ALTER TABLE `patienttestresults` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `request_id` int(10) NOT NULL AUTO_INCREMENT,
  `doctor_id` int(10) NOT NULL,
  `item_name` varchar(30) NOT NULL,
  `quantity` int(15) NOT NULL,
  `status` varchar(10) DEFAULT 'INPROGRESS',
  PRIMARY KEY (`request_id`),
  KEY `doctor_id` (`doctor_id`),
  KEY `item_name` (`item_name`),
  CONSTRAINT `request_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE,
  CONSTRAINT `request_ibfk_2` FOREIGN KEY (`item_name`) REFERENCES `inventory` (`item_name`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wards`
--

DROP TABLE IF EXISTS `wards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wards` (
  `ward_id` int(7) NOT NULL AUTO_INCREMENT,
  `ward_type` varchar(15) DEFAULT NULL,
  `capacity` int(5) DEFAULT NULL,
  PRIMARY KEY (`ward_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wards`
--

LOCK TABLES `wards` WRITE;
/*!40000 ALTER TABLE `wards` DISABLE KEYS */;
INSERT INTO `wards` VALUES (1,'ICU',70),(2,'GENERAL',150),(3,'VIP',10);
/*!40000 ALTER TABLE `wards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hms'
--

--
-- Dumping routines for database 'hms'
--
/*!50003 DROP PROCEDURE IF EXISTS `deleteEmployeeDetail` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteEmployeeDetail`(in  username varchar(50))
BEGIN
    DECLARE empId INT default null;
    DECLARE emrgMnagerId INT default null;
    DECLARE labInchargeId INT default null;
    DECLARE invManId INT default null;
    DECLARE docId INT default null;
    DECLARE oprId INT default null;


SELECT employee_id INTO empId from Employee where user_name= username;

SELECT emergencymanager_id INTO emrgMnagerId from EmergencyManager where emergencymanager_id= empId;

SELECT labincharge_id INTO labInchargeId from LabInCharge where labincharge_id = empId;

SELECT inv_manager_id INTO invManId from inventory_manager where inv_manager_id = empId;

SELECT doctor_id INTO docId from Doctor where doctor_id = empId;

SELECT operator_id INTO oprId from Operator where operator_id = empId;

IF (emrgMnagerId is not null) THEN
        DELETE from EmergencyManager where emergencymanager_id= emrgMnagerId ;
ELSEIF (labInchargeId  is not null) THEN
        DELETE from LabInCharge where labincharge_id = labInchargeId ;
ELSEIF (invManId is not null) THEN
        DELETE from inventory_manager where inv_manager_id = invManId ;
ELSEIF (docId is not null) THEN
        DELETE from Doctor where doctor_id = docId ;
ELSEIF (oprId is not null) THEN
        DELETE from Operator where operator_id = oprId;
END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-21  5:53:13
