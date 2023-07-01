-- MySQL dump 10.13  Distrib 8.0.31, for macos13.0 (x86_64)
--
-- Host: localhost    Database: studentdb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `GradeSummary`
--

DROP TABLE IF EXISTS `GradeSummary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `GradeSummary` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `StudentId` int DEFAULT NULL,
  `SocialPracticeGrade` float DEFAULT NULL,
  `ResearchGrade` float DEFAULT NULL,
  `VolunteerServiceGrade` float DEFAULT NULL,
  `AcademicGrade` float DEFAULT NULL,
  `StudentLeadershipGrade` float DEFAULT NULL,
  `PersonalSummaryGrade` float DEFAULT NULL,
  `SumGrade` float DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `StudentId` (`StudentId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GradeSummary`
--

LOCK TABLES `GradeSummary` WRITE;
/*!40000 ALTER TABLE `GradeSummary` DISABLE KEYS */;
INSERT INTO `GradeSummary` VALUES (1,6,0,0,0,90,0,0,0),(2,8,0,0,0,3.5,0,0,0),(3,9,0,0,0,3.2,0,0,0),(4,10,0,0,0,3.8,0,0,0),(5,11,0,0,0,90,0,0,0),(6,12,0,0,0,89,0,0,0),(7,13,0,0,0,78,0,0,0),(8,14,0,0,0,90,0,0,0),(9,15,0,0,0,86,0,0,0),(10,16,0,0,0,87,0,0,0),(11,17,0,0,0,89,0,0,0),(12,18,0,0,0,90,0,0,0),(13,19,0,0,0,3.8,0,0,0),(14,20,0,0,0,3.7,0,0,0),(15,21,0,0,0,3.8,0,0,0),(16,22,0,0,0,3.7,0,0,0),(17,23,0,0,0,78,0,0,0),(18,24,0,0,0,89,0,0,0),(19,25,0,0,0,80,0,0,0),(20,26,0,0,0,3.5,0,0,0),(21,27,0,0,0,3.2,0,0,0),(22,28,0,0,89,3.8,0,0,0),(23,29,0,0,0,3.6,0,0,0),(24,30,0,0,0,60,0,0,0),(25,31,91,93,0,97,100,98,0),(26,32,0,0,0,89,0,0,0),(27,33,0,0,0,90,0,0,0),(28,34,0,0,0,99.99,0,0,0),(29,35,0,0,0,78,0,0,0),(30,36,0,0,0,80,0,0,0);
/*!40000 ALTER TABLE `GradeSummary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `permission_type` varchar(255) DEFAULT NULL,
  `resource1` varchar(255) DEFAULT NULL,
  `resource2` varchar(255) DEFAULT NULL,
  `resource3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,'api','/admin-api/stulist/',NULL,NULL),(2,'api','/admin-api/student/',NULL,NULL),(3,'api','/admin-api/auth',NULL,NULL),(4,'api','/admin-api/grade1/',NULL,NULL),(5,'api','/admin-api/grade2/',NULL,NULL),(6,'api','/admin-api/grade3/',NULL,NULL),(7,'api','/admin-api/grade4/',NULL,NULL),(8,'api','/admin-api/grade5/',NULL,NULL),(9,'menu','学工管理','/rbac/user/list','views/User/List'),(10,'menu','用户信息','/rbac/user/add','views/User/Add'),(11,'menu','评审页面','/rbac/user/teacher','views/User/Teacher'),(12,'menu','学生页面','/rbac/user/student1','views/User/Student1');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PersonalSummary`
--

DROP TABLE IF EXISTS `PersonalSummary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PersonalSummary` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `StudentId` int DEFAULT NULL,
  `PersonalSummaryContent` text,
  PRIMARY KEY (`ID`),
  KEY `StudentId` (`StudentId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PersonalSummary`
--

LOCK TABLES `PersonalSummary` WRITE;
/*!40000 ALTER TABLE `PersonalSummary` DISABLE KEYS */;
INSERT INTO `PersonalSummary` VALUES (2,18,'个人总结'),(3,15,'hhhhh'),(4,19,'不敢讲脱口秀了'),(5,28,'哈哈哈哈哈'),(6,11,'开心开心'),(7,31,'吃得饱饱');
/*!40000 ALTER TABLE `PersonalSummary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Research`
--

DROP TABLE IF EXISTS `Research`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Research` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `StudentId` int DEFAULT NULL,
  `ResearchContent` text,
  PRIMARY KEY (`ID`),
  KEY `StudentId` (`StudentId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Research`
--

LOCK TABLES `Research` WRITE;
/*!40000 ALTER TABLE `Research` DISABLE KEYS */;
INSERT INTO `Research` VALUES (1,19,'每天都在开摆'),(2,18,'科研哈哈哈哈'),(3,28,'hhhhhhhhhhhh'),(4,11,'哈哈哈哈哈哈哈哈哈'),(5,31,'研发楼研发');
/*!40000 ALTER TABLE `Research` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Role` (
  `id` int NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES (1,'学工'),(2,'学生'),(3,'评审1'),(4,'评审2'),(5,'评审3'),(6,'评审4'),(7,'评审5');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolepermission`
--

DROP TABLE IF EXISTS `rolepermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rolepermission` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `permission_id` int DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolepermission`
--

LOCK TABLES `rolepermission` WRITE;
/*!40000 ALTER TABLE `rolepermission` DISABLE KEYS */;
INSERT INTO `rolepermission` VALUES (1,1,3),(2,2,3),(3,3,3),(4,4,3),(5,5,3),(6,6,3),(7,7,3),(8,2,2),(9,1,1),(10,3,4),(11,4,5),(12,5,6),(13,6,7),(14,7,8),(15,1,9),(17,2,12),(25,3,11),(26,4,11),(27,5,11),(28,6,11),(29,7,11),(30,1,10),(31,2,10),(32,3,10),(33,4,10),(34,5,10),(35,6,10),(36,7,10);
/*!40000 ALTER TABLE `rolepermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SocialPractice`
--

DROP TABLE IF EXISTS `SocialPractice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SocialPractice` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `StudentId` int DEFAULT NULL,
  `SocialPracticeContent` text,
  PRIMARY KEY (`ID`),
  KEY `StudentId` (`StudentId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SocialPractice`
--

LOCK TABLES `SocialPractice` WRITE;
/*!40000 ALTER TABLE `SocialPractice` DISABLE KEYS */;
INSERT INTO `SocialPractice` VALUES (1,19,'便利蜂'),(2,18,'社会哈哈哈哈哈哈哈'),(3,28,'哈哈哈哈哈'),(4,11,'每天便利蜂'),(5,31,'草坪奔跑');
/*!40000 ALTER TABLE `SocialPractice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `UserId` int DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `StudentNumber` varchar(255) DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `PhoneNumber` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Year` int DEFAULT NULL,
  `AcademyDictionary` varchar(255) DEFAULT NULL,
  `MajorDictionary` varchar(255) DEFAULT NULL,
  `PoliticalStatusDictionary` varchar(255) DEFAULT NULL,
  `StudentTypeDictionary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `UserId` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,1001,'John Doe','20210001','Male','1234567890','johndoe@example.com',2023,'Computer Science','Software Engineering','Party Member','Undergraduate'),(2,1001,'John Doe','20210001','Male','1234567890','johndoe@example.com',2023,'Computer Science','Software Engineering','Party Member','Undergraduate'),(3,12,'张三','211sss1',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(4,13,'李四','211s',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(5,14,'王五','202101',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(6,15,'花花','2020',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(7,16,'李四','2021',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(8,18,'张三','20',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(9,19,'李四','21',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(10,20,'王五','23',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(11,21,'陈正岩','2200022759','男','19921840249','3490241794@qq.com',2023,'求知一苑','软件工程','团员','二学位'),(12,22,'李家','2200022745',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(13,24,'没病','2200022768',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(14,29,'没病是谁','2200022767',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(15,32,'陈正岩','2200022757',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(16,33,'李家','2200022746',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(17,34,'战鹰','2200022700',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(18,35,'路就','222000',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(19,36,'张三','2201','男','1999000888','22222222@qq.com',2022,'求知五苑','计算机科学','党员','二学位'),(20,37,'李四','2202',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(21,38,'张三','220100',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(22,39,'李四','22021111',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(23,40,'张三是谁','22079909',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(24,41,'李四说啥','220000',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(25,42,'sdss','122222',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(26,43,'张三','10000',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(27,44,'李四','100002',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(28,45,'王五','1000',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(29,46,'刘六','10004',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(30,49,'柯南','2300022222',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(31,57,'焦糖','2300022001',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(32,64,'aaasas','23333',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(33,65,'刘红心','00000',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(34,66,' 刘虹吸','000000001',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(35,67,'张三','89000',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(36,68,'李四','9000',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StudentLeadership`
--

DROP TABLE IF EXISTS `StudentLeadership`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `StudentLeadership` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `StudentId` int DEFAULT NULL,
  `StudentLeadershipContent` text,
  PRIMARY KEY (`ID`),
  KEY `StudentId` (`StudentId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StudentLeadership`
--

LOCK TABLES `StudentLeadership` WRITE;
/*!40000 ALTER TABLE `StudentLeadership` DISABLE KEYS */;
INSERT INTO `StudentLeadership` VALUES (1,19,'去了一个地方'),(2,18,'骨干哈哈哈哈哈哈s'),(3,28,'哈哈哈哈哈哈哈哈'),(4,11,'有嘛？'),(5,31,'听再想想');
/*!40000 ALTER TABLE `StudentLeadership` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'222','111'),(2,'20210001','20210001'),(3,'20210002','20210002'),(4,'20210003','20210003'),(6,'2110001','2110001'),(7,'21100010002','21100010002'),(8,'20210113','20210113'),(9,'2110s01','2110s01'),(10,'211sss10002','211sss10002'),(11,'202101as13','202101as13'),(12,'211sss1','211sss1'),(13,'211s','211s'),(14,'202101','202101'),(15,'2020','2020'),(16,'2021','2021'),(18,'20','20'),(19,'21','21'),(20,'23','23'),(21,'2200022759','2200022759'),(22,'2200022745','2200022745'),(24,'2200022768','2200022768'),(25,NULL,NULL),(26,NULL,NULL),(27,NULL,NULL),(28,NULL,NULL),(29,'2200022767','2200022767'),(30,NULL,NULL),(32,'2200022757','2200022757'),(33,'2200022746','2200022746'),(34,'2200022700','2200022700'),(35,'222000','222000'),(36,'2201','2201'),(37,'2202','2202'),(38,'220100','220100'),(39,'22021111','22021111'),(40,'22079909','22079909'),(41,'220000','220000'),(42,'122222','122222'),(43,'10000','10000'),(44,'100002','100002'),(45,'1000','1000'),(46,'10004','10004'),(47,NULL,NULL),(48,'666','666'),(49,'2300022222','2300022222'),(50,NULL,NULL),(51,NULL,NULL),(52,NULL,NULL),(53,'20230001','20230001'),(54,'20230002','20230002'),(55,'20230003','20230003'),(56,'110000','110000'),(57,'2300022001','111'),(58,'0001','0001'),(59,'0002','0002'),(60,'0003','0003'),(61,'0004','0004'),(62,'001','001'),(63,'01','01'),(64,'23333','23333'),(65,'00000','00000'),(66,'000000001','000000001'),(67,'89000','89000'),(68,'9000','9000');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userrole` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrole`
--

LOCK TABLES `userrole` WRITE;
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` VALUES (1,48,3),(2,48,4),(3,2,1),(4,1,1),(5,21,2),(6,49,2),(7,53,1),(8,53,2),(9,53,3),(10,54,1),(11,54,4),(12,55,2),(13,55,3),(14,55,5),(15,56,3),(16,56,6),(17,57,2),(18,58,3),(19,59,4),(20,60,5),(21,61,6),(22,61,7),(23,62,5),(24,62,4),(25,63,3),(26,63,5),(27,64,2),(28,65,2),(29,66,2),(30,67,2),(31,68,2);
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VolunteerService`
--

DROP TABLE IF EXISTS `VolunteerService`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `VolunteerService` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `StudentId` int DEFAULT NULL,
  `VolunteerServiceContent` text,
  PRIMARY KEY (`ID`),
  KEY `StudentId` (`StudentId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VolunteerService`
--

LOCK TABLES `VolunteerService` WRITE;
/*!40000 ALTER TABLE `VolunteerService` DISABLE KEYS */;
INSERT INTO `VolunteerService` VALUES (1,19,'主打一个蹭'),(2,18,'志愿'),(3,28,'就哈哈哈哈哈哈'),(4,11,'小丑逗大家开心'),(5,31,'陪大家');
/*!40000 ALTER TABLE `VolunteerService` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-01 21:54:49
