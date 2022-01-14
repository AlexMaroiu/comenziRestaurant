CREATE DATABASE  IF NOT EXISTS `restaurant` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `restaurant`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: restaurant
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `comanda`
--

DROP TABLE IF EXISTS `comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comanda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_mancare` int DEFAULT NULL,
  `portii` int DEFAULT NULL,
  `pret` decimal(6,2) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `finalizat` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comanda`
--

LOCK TABLES `comanda` WRITE;
/*!40000 ALTER TABLE `comanda` DISABLE KEYS */;
INSERT INTO `comanda` VALUES (1,1,1,2.00,NULL,0),(2,1,1,2.00,NULL,0),(3,2,1,1.00,NULL,0),(4,1,1,2.25,NULL,0),(5,2,1,7.00,NULL,0),(6,1,1,11.25,NULL,0),(7,1,2,11.25,NULL,0),(8,1,1,11.25,NULL,0),(9,2,2,14.00,NULL,0),(10,1,2,22.50,NULL,0),(11,1,1,11.25,NULL,0),(12,1,1,11.25,NULL,0),(13,1,1,11.25,NULL,0),(14,1,1,11.25,NULL,0),(15,1,1,11.25,NULL,0),(16,1,1,11.25,NULL,0),(17,1,1,11.25,NULL,0),(18,1,1,11.25,'alex',1),(19,1,1,11.25,'Alexandru',1),(20,1,1,11.25,'alex',1),(21,2,1,7.00,'alex',1),(22,1,3,33.75,'alex',1),(23,1,1,11.25,'alex',1),(24,1,1,11.25,'alex',1),(25,2,1,5.60,'alex',1),(26,2,1,5.60,'alex',1),(27,2,1,5.60,'alex',1),(28,1,1,11.25,'Alexandru',0),(29,1,1,11.25,'alex',0),(30,1,1,11.25,'alex',0),(31,1,1,11.25,'achi',0),(32,1,1,15.00,'Alexandru',0);
/*!40000 ALTER TABLE `comanda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-14 18:23:32
