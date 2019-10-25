CREATE DATABASE  IF NOT EXISTS `privateschoolstructure` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `privateschoolstructure`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: privateschoolstructure
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignments`
--

DROP TABLE IF EXISTS `assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assignments` (
  `assignment_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `assignDescription` varchar(80) DEFAULT NULL,
  `subDateTime` date DEFAULT NULL,
  `oralMark` varchar(10) DEFAULT NULL,
  `totalMark` varchar(10) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`assignment_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `assignments_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignments`
--

LOCK TABLES `assignments` WRITE;
/*!40000 ALTER TABLE `assignments` DISABLE KEYS */;
INSERT INTO `assignments` VALUES (1,'Group Project','Part A','2019-10-10','B','A',2),(2,'Group Project','Part B','2019-11-20','C','A',2),(3,'Individual Project','Part A','2019-06-21','B','A',2),(4,'Individual Project','Part B','2019-07-24','C','A',2),(5,'Group Project','Part A','2019-10-10','B','B',2),(6,'Group Project','Part B','2019-11-20','C','A',2),(7,'Individual Project','Part A','2019-06-21','A','A',2),(8,'Individual Project','Part B','2019-07-24','C','B',2),(9,'Group Project','Part A','2019-10-10','B','A',1),(10,'Group Project','Part B','2019-11-20','B','A',1),(11,'Individual Project','Part A','2019-06-21','B','A',1),(12,'Individual Project','Part B','2019-07-24','A','A',1),(13,'Group Project','Part A','2019-10-10','C','A',4),(14,'Group Project','Part B','2019-11-20','C','A',4),(15,'Individual Project','Part A','2019-06-21','B','C',4),(16,'Individual Project','Part B','2019-07-24','A','B',4),(17,'Group Project','Part A','2019-10-10','C','A',1),(18,'Group Project','Part B','2019-11-20','C','D',1),(19,'Individual Project','Part A','2019-06-21','B','C',1),(20,'Individual Project','Part B','2019-07-24','C','B',1),(21,'Group Project','Part A','2019-10-10','C','B',4),(22,'Group Project','Part B','2019-11-20','C','B',4),(23,'Individual Project','Part A','2019-06-21','B','C',4),(24,'Individual Project','Part B','2019-07-24','B','B',4),(25,'Group Project','Part A','2019-10-10','A','B',3),(26,'Group Project','Part B','2019-11-20','B','B',3),(27,'Individual Project','Part A','2019-06-21','B','A',3),(28,'Individual Project','Part B','2019-07-24','B','B',3),(29,'Group Project','Part A','2019-10-10','A','B',2),(30,'Group Project','Part B','2019-11-20','A','B',2),(31,'Individual Project','Part A','2019-06-21','B','A',2),(32,'Individual Project','Part B','2019-07-24','C','B',2),(33,'Group Project','Part A','2019-10-10','B','B',1),(34,'Group Project','Part B','2019-11-20','A','B',1),(35,'Individual Project','Part A','2019-06-21','A','A',1),(36,'Individual Project','Part B','2019-07-24','C','B',1),(37,'Group Project','Part A','2019-10-10','B','B',3),(38,'Group Project','Part B','2019-11-20','B','B',3),(39,'Individual Project','Part A','2019-06-21','A','B',3),(40,'Individual Project','Part B','2019-07-24','C','B',3),(41,'Group Project','Part A','2019-10-10','A','A',1),(42,'Group Project','Part B','2019-11-20','A','B',1),(43,'Individual Project','Part A','2019-06-21','A','B',1),(44,'Individual Project','Part B','2019-07-24','B','B',1);
/*!40000 ALTER TABLE `assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignmentsinstudents`
--

DROP TABLE IF EXISTS `assignmentsinstudents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assignmentsinstudents` (
  `student_id` int(11) NOT NULL,
  `assignment_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`assignment_id`),
  KEY `assignment_id` (`assignment_id`),
  CONSTRAINT `assignmentsinstudents_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
  CONSTRAINT `assignmentsinstudents_ibfk_2` FOREIGN KEY (`assignment_id`) REFERENCES `assignments` (`assignment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentsinstudents`
--

LOCK TABLES `assignmentsinstudents` WRITE;
/*!40000 ALTER TABLE `assignmentsinstudents` DISABLE KEYS */;
INSERT INTO `assignmentsinstudents` VALUES (1,1),(1,2),(1,3),(1,4),(2,5),(2,6),(2,7),(2,8),(3,9),(3,10),(3,11),(3,12),(4,13),(4,14),(4,15),(4,16),(5,17),(5,18),(5,19),(5,20),(6,21),(6,22),(6,23),(6,24),(7,25),(7,26),(7,27),(7,28),(8,29),(8,30),(8,31),(8,32),(9,33),(9,34),(9,35),(9,36),(9,37),(9,38),(9,39),(9,40),(10,41),(10,42),(10,43),(10,44);
/*!40000 ALTER TABLE `assignmentsinstudents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignmentsmodels`
--

DROP TABLE IF EXISTS `assignmentsmodels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assignmentsmodels` (
  `assignment_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `assignDescription` varchar(80) DEFAULT NULL,
  `subDateTime` date DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`assignment_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `assignmentsmodels_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentsmodels`
--

LOCK TABLES `assignmentsmodels` WRITE;
/*!40000 ALTER TABLE `assignmentsmodels` DISABLE KEYS */;
INSERT INTO `assignmentsmodels` VALUES (1,'Group Project','Part A','2019-10-10',1),(2,'Group Project','Part B','2019-11-20',1),(3,'Individual Project','Part A','2019-06-21',1),(4,'Individual Project','Part B','2019-07-24',1),(5,'Group Project','Part A','2019-10-10',2),(6,'Group Project','Part B','2019-11-20',2),(7,'Individual Project','Part A','2019-06-21',2),(8,'Individual Project','Part B','2019-07-24',2),(9,'Group Project','Part A','2019-10-10',3),(10,'Group Project','Part B','2019-11-20',3),(11,'Individual Project','Part A','2019-06-21',3),(12,'Individual Project','Part B','2019-07-24',3),(13,'Group Project','Part A','2019-10-10',4),(14,'Group Project','Part B','2019-11-20',4),(15,'Individual Project','Part A','2019-06-21',4),(16,'Individual Project','Part B','2019-07-24',4);
/*!40000 ALTER TABLE `assignmentsmodels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `courses` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `stream` varchar(20) DEFAULT NULL,
  `courseType` varchar(20) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Java Full Time Course','Java','Full Time','2019-05-13','2019-11-22'),(2,'C# Full Time Course','C#','Full Time','2019-05-13','2019-11-22'),(3,'Java Part Time Course','Java','Part Time','2019-05-13','2019-08-02'),(4,'C# Part Time Course','C#','Part Time','2019-05-13','2019-08-02');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `students` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) DEFAULT NULL,
  `secondName` varchar(50) DEFAULT NULL,
  `birthDate` date DEFAULT NULL,
  `stream` varchar(20) DEFAULT NULL,
  `tuition` double DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Allyn','D\'Angeli','1980-07-14','C#',2282.3),(2,'Murdoch','Garlic','1984-03-28','C#',2240.6),(3,'Schuyler','Cecchetelli','1998-12-20','Java',2226.9),(4,'Colet','Pattrick','1989-02-20','C#',2468.6),(5,'Rozelle','Empleton','1985-08-21','Java',2038.3),(6,'Raychel','Herche','1999-03-22','C#',2496.4),(7,'Adrianne','Thrush','1988-01-01','Java',2090.2),(8,'Gnni','Deering','1990-11-27','C#',2025.1),(9,'Kain','Oppy','1989-09-07','Java',2333.9),(10,'Bernelle','Stronghill','1982-06-12','Java',2097);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentsincourses`
--

DROP TABLE IF EXISTS `studentsincourses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `studentsincourses` (
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `studentsincourses_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
  CONSTRAINT `studentsincourses_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentsincourses`
--

LOCK TABLES `studentsincourses` WRITE;
/*!40000 ALTER TABLE `studentsincourses` DISABLE KEYS */;
INSERT INTO `studentsincourses` VALUES (3,1),(5,1),(9,1),(10,1),(1,2),(2,2),(8,2),(7,3),(9,3),(4,4),(6,4);
/*!40000 ALTER TABLE `studentsincourses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainers`
--

DROP TABLE IF EXISTS `trainers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trainers` (
  `trainer_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) DEFAULT NULL,
  `secondName` varchar(50) DEFAULT NULL,
  `trainerSubject` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`trainer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainers`
--

LOCK TABLES `trainers` WRITE;
/*!40000 ALTER TABLE `trainers` DISABLE KEYS */;
INSERT INTO `trainers` VALUES (1,'Clemens','Windas','ullamcorper purus sit'),(2,'Gabbie','Cowthard','eget orci'),(3,'Anna','Broadfoot','orci luctus et ultrices'),(4,'Jaimie','Solland','nulla justo aliquam'),(5,'Roxane','Carney','urna ut tellus nulla'),(6,'Morty','Dinjes','pretium iaculis justo in'),(7,'Hillard','Mattiuzzi','ut rhoncus aliquet pulvinar'),(8,'Pauline','Darben','vestibulum ante ipsum primis'),(9,'Darrelle','McCafferky','malesuada in imperdiet'),(10,'Gennifer','Lesly','ullamcorper augue a suscipit');
/*!40000 ALTER TABLE `trainers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainersincourses`
--

DROP TABLE IF EXISTS `trainersincourses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trainersincourses` (
  `trainer_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`trainer_id`,`course_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `trainersincourses_ibfk_1` FOREIGN KEY (`trainer_id`) REFERENCES `trainers` (`trainer_id`),
  CONSTRAINT `trainersincourses_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainersincourses`
--

LOCK TABLES `trainersincourses` WRITE;
/*!40000 ALTER TABLE `trainersincourses` DISABLE KEYS */;
INSERT INTO `trainersincourses` VALUES (1,1),(3,1),(5,1),(9,1),(2,2),(4,2),(6,2),(10,2),(1,3),(3,3),(5,3),(7,3),(2,4),(4,4),(6,4),(8,4);
/*!40000 ALTER TABLE `trainersincourses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'privateschoolstructure'
--

--
-- Dumping routines for database 'privateschoolstructure'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-24 21:28:51
