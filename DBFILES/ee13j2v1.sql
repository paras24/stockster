-- MySQL dump 10.13  Distrib 5.6.14, for Win32 (x86)
--
-- Host: localhost    Database: ee13j2
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `joiningpipelinemembers`
--

DROP TABLE IF EXISTS `joiningpipelinemembers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `joiningpipelinemembers` (
  `jPmemberID` int(11) NOT NULL AUTO_INCREMENT,
  `Grade` varchar(255) DEFAULT NULL,
  `dateOfJoining` datetime DEFAULT NULL,
  `experience` int(11) DEFAULT NULL,
  `jPmemberName` varchar(255) DEFAULT NULL,
  `keySkills` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `supervisorName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`jPmemberID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `joiningpipelinemembers`
--

LOCK TABLES `joiningpipelinemembers` WRITE;
/*!40000 ALTER TABLE `joiningpipelinemembers` DISABLE KEYS */;
/*!40000 ALTER TABLE `joiningpipelinemembers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keyskill`
--

DROP TABLE IF EXISTS `keyskill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keyskill` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `skill` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keyskill`
--

LOCK TABLES `keyskill` WRITE;
/*!40000 ALTER TABLE `keyskill` DISABLE KEYS */;
/*!40000 ALTER TABLE `keyskill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locations` (
  `Loc_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Loc_Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Loc_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'Noida'),(2,'Banglore'),(3,'Indore');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_project`
--

DROP TABLE IF EXISTS `member_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_project` (
  `dateOfprojectAllocation` date DEFAULT NULL,
  `dateOfprojectDeallocation` date DEFAULT NULL,
  `percentAllocation` int(11) NOT NULL,
  `projectID` int(11) NOT NULL DEFAULT '0',
  `memberID` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`projectID`,`memberID`),
  KEY `FK6CE3427453896885` (`memberID`),
  KEY `FK6CE342749BD31D7A` (`projectID`),
  CONSTRAINT `FK6CE3427453896885` FOREIGN KEY (`memberID`) REFERENCES `teammembers` (`memberID`),
  CONSTRAINT `FK6CE342749BD31D7A` FOREIGN KEY (`projectID`) REFERENCES `project` (`projectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_project`
--

LOCK TABLES `member_project` WRITE;
/*!40000 ALTER TABLE `member_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opportunity`
--

DROP TABLE IF EXISTS `opportunity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opportunity` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `Work_Duration` int(11) DEFAULT NULL,
  `People_Required_Count` int(11) DEFAULT NULL,
  `RequestDt` date DEFAULT NULL,
  `requirementStatus` int(11) DEFAULT NULL,
  `requirementType` int(11) DEFAULT NULL,
  `start_Date_Of_Resources` date DEFAULT NULL,
  `Sub_Project_Name` varchar(255) DEFAULT NULL,
  `ContactPoint_Id` bigint(20) DEFAULT NULL,
  `Loc_Id` int(11) DEFAULT NULL,
  `Project_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK16648EB35BBDCB87` (`Project_Id`),
  KEY `FK16648EB3678C2DE8` (`Loc_Id`),
  KEY `FK16648EB34FE8859A` (`ContactPoint_Id`),
  CONSTRAINT `FK16648EB34FE8859A` FOREIGN KEY (`ContactPoint_Id`) REFERENCES `teammembers` (`memberID`),
  CONSTRAINT `FK16648EB35BBDCB87` FOREIGN KEY (`Project_Id`) REFERENCES `project` (`projectID`),
  CONSTRAINT `FK16648EB3678C2DE8` FOREIGN KEY (`Loc_Id`) REFERENCES `locations` (`Loc_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opportunity`
--

LOCK TABLES `opportunity` WRITE;
/*!40000 ALTER TABLE `opportunity` DISABLE KEYS */;
/*!40000 ALTER TABLE `opportunity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opportunity_keyskill`
--

DROP TABLE IF EXISTS `opportunity_keyskill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opportunity_keyskill` (
  `type` int(11) DEFAULT NULL,
  `opportunityID` int(11) NOT NULL DEFAULT '0',
  `keySkill_Id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`keySkill_Id`,`opportunityID`),
  KEY `FK8A8ECB5EAF23A3A8` (`opportunityID`),
  KEY `FK8A8ECB5E8573F013` (`keySkill_Id`),
  CONSTRAINT `FK8A8ECB5E8573F013` FOREIGN KEY (`keySkill_Id`) REFERENCES `keyskill` (`Id`),
  CONSTRAINT `FK8A8ECB5EAF23A3A8` FOREIGN KEY (`opportunityID`) REFERENCES `opportunity` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opportunity_keyskill`
--

LOCK TABLES `opportunity_keyskill` WRITE;
/*!40000 ALTER TABLE `opportunity_keyskill` DISABLE KEYS */;
/*!40000 ALTER TABLE `opportunity_keyskill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opportunity_member`
--

DROP TABLE IF EXISTS `opportunity_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opportunity_member` (
  `opportunityID` int(11) NOT NULL DEFAULT '0',
  `teamMemberID` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`opportunityID`,`teamMemberID`),
  KEY `FK2DE0DD86AF23A3A8` (`opportunityID`),
  KEY `FK2DE0DD863F39FDE2` (`teamMemberID`),
  CONSTRAINT `FK2DE0DD863F39FDE2` FOREIGN KEY (`teamMemberID`) REFERENCES `teammembers` (`memberID`),
  CONSTRAINT `FK2DE0DD86AF23A3A8` FOREIGN KEY (`opportunityID`) REFERENCES `opportunity` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opportunity_member`
--

LOCK TABLES `opportunity_member` WRITE;
/*!40000 ALTER TABLE `opportunity_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `opportunity_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opportunity_remarks`
--

DROP TABLE IF EXISTS `opportunity_remarks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opportunity_remarks` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `remark` varchar(255) DEFAULT NULL,
  `Opportunity_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKE16D7F67EAFBCE81` (`Opportunity_id`),
  CONSTRAINT `FKE16D7F67EAFBCE81` FOREIGN KEY (`Opportunity_id`) REFERENCES `opportunity` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opportunity_remarks`
--

LOCK TABLES `opportunity_remarks` WRITE;
/*!40000 ALTER TABLE `opportunity_remarks` DISABLE KEYS */;
/*!40000 ALTER TABLE `opportunity_remarks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `projectID` int(11) NOT NULL AUTO_INCREMENT,
  `dateOfprojectAllocation` date DEFAULT NULL,
  `dateOfprojectDeallocation` date DEFAULT NULL,
  `groupHeadName` varchar(255) DEFAULT NULL,
  `percentAllocation` int(11) DEFAULT NULL,
  `pointOfContact` varchar(255) DEFAULT NULL,
  `projectName` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `subprojectName` varchar(255) DEFAULT NULL,
  `supervisorName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`projectID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'2013-12-01',NULL,'head',10,'point of contact','test project','open','subproject','supervisor');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleID` int(11) NOT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (2,'Admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teammembers`
--

DROP TABLE IF EXISTS `teammembers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teammembers` (
  `memberID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Grade` varchar(255) DEFAULT NULL,
  `dateOfJoining` datetime DEFAULT NULL,
  `experirnce` int(11) DEFAULT NULL,
  `groupHeadName` varchar(255) DEFAULT NULL,
  `keySkills` varchar(255) DEFAULT NULL,
  `memberName` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `supervisor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`memberID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teammembers`
--

LOCK TABLES `teammembers` WRITE;
/*!40000 ALTER TABLE `teammembers` DISABLE KEYS */;
INSERT INTO `teammembers` VALUES (1,'g4',NULL,NULL,'group hd','java','test mem',NULL,NULL,NULL);
/*!40000 ALTER TABLE `teammembers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roleID` int(11) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  KEY `FK4E39DE8DC8634CC` (`roleID`),
  CONSTRAINT `FK4E39DE8DC8634CC` FOREIGN KEY (`roleID`) REFERENCES `role` (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2013-10-13 18:36:08','2013-10-13 18:36:08','bhavneet.bodh@gmail.com','','7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA',2),(2,'2013-10-13 18:36:08','2013-10-13 18:36:08','arpan.bhandari@impetus.co.in','','7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA',2),(3,'2013-10-13 18:36:08','2013-10-13 18:36:08','apoorva.bhatt@impetus.co.in','','7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA',2),(4,'2013-10-13 18:36:08','2013-10-13 18:36:08','abhishek.rastogi@impetus.co.in','','7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA',2),(5,'2013-10-13 18:36:08','2013-10-13 18:36:08','swati.rawat@impetus.co.in','','7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA',2),(6,'2013-10-13 18:36:08','2013-10-13 18:36:08','sapna.yadav@impetus.co.in','','7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA',2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-13 20:02:08
