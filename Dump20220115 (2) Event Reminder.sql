-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: event_database
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dao_person`
--

DROP TABLE IF EXISTS `dao_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dao_person` (
  `id` int DEFAULT NULL,
  `per_id` int NOT NULL,
  PRIMARY KEY (`per_id`),
  KEY `FKpdbqa1kt0c9f6kf4aexa8e1bv` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dao_person`
--

LOCK TABLES `dao_person` WRITE;
/*!40000 ALTER TABLE `dao_person` DISABLE KEYS */;
/*!40000 ALTER TABLE `dao_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datumi`
--

DROP TABLE IF EXISTS `datumi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datumi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `day` varchar(45) NOT NULL,
  `month` varchar(45) NOT NULL,
  `year` varchar(45) NOT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `per_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4fuxsqddhp1vn45gfbny6iui9` (`per_id`),
  CONSTRAINT `FK4fuxsqddhp1vn45gfbny6iui9` FOREIGN KEY (`per_id`) REFERENCES `persons` (`per_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datumi`
--

LOCK TABLES `datumi` WRITE;
/*!40000 ALTER TABLE `datumi` DISABLE KEYS */;
INSERT INTO `datumi` VALUES (1,'1','2','2021',NULL,NULL,NULL);
/*!40000 ALTER TABLE `datumi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events1`
--

DROP TABLE IF EXISTS `events1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `events1` (
  `idevents1` int NOT NULL,
  `date` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idevents1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events1`
--

LOCK TABLES `events1` WRITE;
/*!40000 ALTER TABLE `events1` DISABLE KEYS */;
INSERT INTO `events1` VALUES (0,'23','rodjendan');
/*!40000 ALTER TABLE `events1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events_new`
--

DROP TABLE IF EXISTS `events_new`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `events_new` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events_new`
--

LOCK TABLES `events_new` WRITE;
/*!40000 ALTER TABLE `events_new` DISABLE KEYS */;
INSERT INTO `events_new` VALUES (1,'23','aniversary'),(2,'12','birthday'),(9,'28','event'),(10,'25','birthday'),(12,'2','anniversary'),(14,'3','nesto'),(15,'1','event'),(16,'02',''),(18,'01',''),(19,'01','event'),(20,'01','event2');
/*!40000 ALTER TABLE `events_new` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events_new1`
--

DROP TABLE IF EXISTS `events_new1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `events_new1` (
  `id` int NOT NULL AUTO_INCREMENT,
  `day` varchar(45) NOT NULL,
  `month` varchar(45) NOT NULL,
  `year` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events_new1`
--

LOCK TABLES `events_new1` WRITE;
/*!40000 ALTER TABLE `events_new1` DISABLE KEYS */;
INSERT INTO `events_new1` VALUES (2,'17','05','2021','birthday Sanja'),(3,'05','05','2021','birthday Sandra'),(4,'25','10','2021','Ana birthday'),(5,'30','02','2021','Ivana birthday'),(6,'20','02','2021','Alma birthday'),(7,'23','04','2021','anniversary'),(8,'31','07','2021','wedding'),(10,'06','11','2021','Lun birthday'),(11,'26','05','2021','Nesa birthday'),(30,'18','10','2021','Tamara birthday');
/*!40000 ALTER TABLE `events_new1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persons`
--

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persons` (
  `per_id` int NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`per_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` VALUES (1,'ana','ja');
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-15 15:49:50
