-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: cis175.cfjodorzrjhs.us-east-2.rds.amazonaws.com    Database: game
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `WARNING`
--

DROP TABLE IF EXISTS `WARNING`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WARNING` (
  `id` int(11) NOT NULL,
  `warning` text COLLATE utf8_unicode_ci,
  `Bitcoin_Address` text COLLATE utf8_unicode_ci,
  `Email` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WARNING`
--

LOCK TABLES `WARNING` WRITE;
/*!40000 ALTER TABLE `WARNING` DISABLE KEYS */;
INSERT INTO `WARNING` VALUES (1,'To recover your lost Database and avoid leaking it: Send us 0.06 Bitcoin (BTC) to our Bitcoin address 1BLYhUDmnmVPVjcTWgc6gFT6DCYwbVieUD and contact us by Email with your Server IP or Domain name and a Proof of Payment. If you are unsure if we have your data, contact us and we will send you a proof. Your Database is downloaded and backed up on our servers. Backups that we have right now: game, shopping, PLEASE_READ_ME_VVV . If we dont receive your payment in the next 10 Days, we will make your database public or use them otherwise.','1BLYhUDmnmVPVjcTWgc6gFT6DCYwbVieUD','contact@sqldb.to');
/*!40000 ALTER TABLE `WARNING` ENABLE KEYS */;
UNLOCK TABLES;
