-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: qqdb
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `accountphone`
--

DROP TABLE IF EXISTS `accountphone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accountphone` (
  `uid` bigint unsigned NOT NULL,
  `MobilePhone` varchar(255) NOT NULL COMMENT 'QQ账号绑定的手机号',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `MobilePhone` (`MobilePhone`),
  CONSTRAINT `accountphone_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `qqaccountinfo` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accountphone`
--

LOCK TABLES `accountphone` WRITE;
/*!40000 ALTER TABLE `accountphone` DISABLE KEYS */;
/*!40000 ALTER TABLE `accountphone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qqaccountinfo`
--

DROP TABLE IF EXISTS `qqaccountinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qqaccountinfo` (
  `uid` bigint unsigned NOT NULL,
  `account` varchar(255) NOT NULL COMMENT 'QQ账号',
  `password` varchar(255) NOT NULL COMMENT 'QQ密码',
  `createdate` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qqaccountinfo`
--

LOCK TABLES `qqaccountinfo` WRITE;
/*!40000 ALTER TABLE `qqaccountinfo` DISABLE KEYS */;
INSERT INTO `qqaccountinfo` VALUES (1,'1303468364','5546789123','2023-07-26'),(2,'9328006436','sddfgsdfsddf','2023-07-26');
/*!40000 ALTER TABLE `qqaccountinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qqfriendaccount`
--

DROP TABLE IF EXISTS `qqfriendaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qqfriendaccount` (
  `uid` bigint unsigned NOT NULL,
  `FriendAccount` json NOT NULL COMMENT '好友账号列表,维护 uid 数组',
  PRIMARY KEY (`uid`),
  CONSTRAINT `qqfriendaccount_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `qqaccountinfo` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qqfriendaccount`
--

LOCK TABLES `qqfriendaccount` WRITE;
/*!40000 ALTER TABLE `qqfriendaccount` DISABLE KEYS */;
INSERT INTO `qqfriendaccount` VALUES (1,'[2]');
/*!40000 ALTER TABLE `qqfriendaccount` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-05  1:37:12
