CREATE DATABASE  IF NOT EXISTS `java_web_aplication` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `java_web_aplication`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: java_web_aplication
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `foto`
--

DROP TABLE IF EXISTS `foto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `link` varchar(1000) DEFAULT NULL,
  `descricao` varchar(300) DEFAULT NULL,
  `FK_pasta` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pasta` (`FK_pasta`),
  CONSTRAINT `foto_ibfk_1` FOREIGN KEY (`FK_pasta`) REFERENCES `pasta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto`
--

LOCK TABLES `foto` WRITE;
/*!40000 ALTER TABLE `foto` DISABLE KEYS */;
INSERT INTO `foto` VALUES (1,'https://i.pinimg.com/564x/da/00/9f/da009f9550a0016ad1f63523243fdba9.jpg','wallpaper blue',1),(2,'https://i.pinimg.com/564x/3f/04/94/3f0494c392f840a63bec3470ff7356d4.jpg','wallpaper blue',1),(3,'https://i.pinimg.com/564x/83/d1/7e/83d17e2e182a3e469bb1050c57d9d8af.jpg','wallpaper blue',1),(4,'https://i.pinimg.com/564x/ad/f9/dc/adf9dcdecbdeb187f6f997144530f284.jpg','wallpaper blue',1),(5,'https://i.pinimg.com/564x/72/1b/13/721b1318f63ab112f002e7fc508fe003.jpg','wallpaper blue',1),(6,'https://i.pinimg.com/564x/4d/c4/7e/4dc47e874e0f3f41774f89606c743688.jpg','wallpaper blue',1),(7,'https://i.pinimg.com/236x/97/04/a3/9704a3edf038940e01dae3d438eb71f0.jpg','wallpaper dark',2),(8,'https://i.pinimg.com/236x/1d/fa/80/1dfa80166c5aba41aee1dad05edd1e7f.jpg','wallpaper dark',2),(9,'https://i.pinimg.com/236x/ee/88/18/ee8818c43e19b5861cdb5a898b159970.jpg','wallpaper dark',2),(10,'https://i.pinimg.com/236x/eb/54/4d/eb544da63c03ad47a4eac88673b8b3d5.jpg','wallpaper dark',2),(11,'https://i.pinimg.com/236x/3e/e5/c3/3ee5c37da81debe656e6ab8a2f8deec8.jpg','wallpaper dark',2),(12,'https://i.pinimg.com/236x/ea/ed/8a/eaed8a570d7385ec9c2cfb7fa6260ab7.jpg','wallpaper dark',2),(13,'https://i.pinimg.com/236x/c9/bd/f5/c9bdf5891495525be841adc1b40dac81.jpg','wallpaper Cute',3),(14,'https://i.pinimg.com/236x/77/7b/55/777b55972c0c91675a4e43c9b5f30434.jpg','wallpaper Cute',3),(15,'https://i.pinimg.com/236x/ae/8f/81/ae8f8163083dc08c9a907e562447d340.jpg','wallpaper Cute',3),(16,'https://i.pinimg.com/236x/9e/d0/00/9ed000a605a3f58711b3768ec7dc8714.jpg','wallpaper Cute',3),(17,'https://i.pinimg.com/236x/eb/b8/e1/ebb8e17f58ed41f713cbfbe2f6fee49f.jpg','wallpaper Cute',3),(18,'https://i.pinimg.com/236x/9b/50/42/9b50426b5d5827d2b61e77f050dbc3c4.jpg','wallpaper Cute',3),(19,'https://i.pinimg.com/236x/32/40/32/3240325cebf1742457b234f6b2264492.jpg','wallpaper Aesthetic',4),(20,'https://i.pinimg.com/236x/d0/d6/9f/d0d69fd1a04a66486765862855699493.jpg','wallpaper Aesthetic',4),(21,'https://i.pinimg.com/236x/78/b9/23/78b9236cc805b6a53a427be8623f8415.jpg','wallpaper Aesthetic',4),(22,'https://i.pinimg.com/236x/fa/de/79/fade796666bc75fb170fba7c53ed4aef.jpg','wallpaper Aesthetic',4),(23,'https://i.pinimg.com/236x/02/49/5d/02495d8ed387022ff6e57abf639df601.jpg','wallpaper Aesthetic',4),(24,'https://i.pinimg.com/236x/4f/eb/9f/4feb9f5f60c5d0b87051473951456e37.jpg','wallpaper Aesthetic',4),(25,'https://i.pinimg.com/236x/1c/fc/80/1cfc80b8e03732bfc75c274f62c1d7a7.jpg','wallpaper Animals',5),(26,'https://i.pinimg.com/236x/24/c9/bd/24c9bdc4b27dca723080605a60f46df1.jpg','wallpaper Animals',5),(27,'https://i.pinimg.com/236x/41/6e/59/416e599cd328ea93585e2f1fe2f020f3.jpg','wallpaper Animals',5),(28,'https://i.pinimg.com/236x/c0/7e/0e/c07e0e8699fc6cc74a12da0f18d957fa.jpg','wallpaper Animals',5),(29,'https://i.pinimg.com/236x/af/11/aa/af11aa9aa039d9f869146146b41272e4.jpg','wallpaper Animals',5),(30,'https://i.pinimg.com/236x/30/5d/f6/305df632c0c903bd9e9d714d181f1b38.jpg','wallpaper Animals',5);
/*!40000 ALTER TABLE `foto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasta`
--

DROP TABLE IF EXISTS `pasta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pasta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `criador` enum('origin','user') DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasta`
--

LOCK TABLES `pasta` WRITE;
/*!40000 ALTER TABLE `pasta` DISABLE KEYS */;
INSERT INTO `pasta` VALUES (1,'origin','Blues','only blue wallpapers'),(2,'origin','Dark',''),(3,'origin','Cute',''),(4,'origin','Aesthetic',''),(5,'origin','Animals','');
/*!40000 ALTER TABLE `pasta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-30  8:35:25
