-- MySQL dump 10.13  Distrib 5.7.13, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: BibalDenis
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.18-MariaDB-1~jessie

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
-- Table structure for table `DATABASECHANGELOG`
--

DROP TABLE IF EXISTS `DATABASECHANGELOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DATABASECHANGELOG` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATABASECHANGELOG`
--

LOCK TABLES `DATABASECHANGELOG` WRITE;
/*!40000 ALTER TABLE `DATABASECHANGELOG` DISABLE KEYS */;
INSERT INTO `DATABASECHANGELOG` VALUES ('00000000000001','jhipster','classpath:config/liquibase/changelog/00000000000000_initial_schema.xml','2016-10-15 08:36:35',1,'EXECUTED','7:05d6c1de129cdd107606d5dba8731152','createTable, createIndex (x2), createTable (x2), addPrimaryKey, createTable, addForeignKeyConstraint (x3), loadData, dropDefaultValue, loadData (x2), createTable (x2), addPrimaryKey, createIndex (x2), addForeignKeyConstraint','',NULL,'3.4.2',NULL,NULL),('20161015074820-1','jhipster','classpath:config/liquibase/changelog/20161015074820_added_entity_Usager.xml','2016-10-15 08:44:27',2,'EXECUTED','7:871dbcd81e2b1867d10975a9733433d0','createTable','',NULL,'3.4.2',NULL,NULL),('20161015074823-1','jhipster','classpath:config/liquibase/changelog/20161015074823_added_entity_Auteur.xml','2016-10-15 08:44:27',3,'EXECUTED','7:a47d49ad2e1cbfad25b554a67b1fc115','createTable','',NULL,'3.4.2',NULL,NULL),('20161015074821-1','jhipster','classpath:config/liquibase/changelog/20161015074821_added_entity_Livre.xml','2016-10-15 08:44:27',4,'EXECUTED','7:1e9922220fd626672ccc5ed2dc042cf7','createTable','',NULL,'3.4.2',NULL,NULL),('20161010150035-1','jhipster','classpath:config/liquibase/changelog/20161010150035_added_entity_Magazine.xml','2016-10-15 08:44:27',5,'EXECUTED','7:d460edee3bbeb70432f440dc420a5b26','createTable','',NULL,'3.4.2',NULL,NULL),('20161015074822-1','jhipster','classpath:config/liquibase/changelog/20161015074822_added_entity_Exemplaire.xml','2016-10-15 08:44:27',6,'EXECUTED','7:2eee0abf2a3af0eb497afdbb0599d317','createTable','',NULL,'3.4.2',NULL,NULL),('20161010150030-1','jhipster','classpath:config/liquibase/changelog/20161010150030_added_entity_Emprunt.xml','2016-10-15 08:44:27',7,'EXECUTED','7:16b3988bf5a6bddb52109eaaa98c487d','createTable','',NULL,'3.4.2',NULL,NULL),('20161015074825-1','jhipster','classpath:config/liquibase/changelog/20161015074825_added_entity_Reservation.xml','2016-10-15 08:44:27',8,'EXECUTED','7:6f2fc634ff14f54e85121b83595be423','createTable','',NULL,'3.4.2',NULL,NULL),('20161015074821-2','jhipster','classpath:config/liquibase/changelog/20161015074821_added_entity_constraints_Livre.xml','2016-10-15 08:44:27',9,'EXECUTED','7:8c75cfe53df870acc17e5223d7264541','addForeignKeyConstraint','',NULL,'3.4.2',NULL,NULL),('20161010150035-2','jhipster','classpath:config/liquibase/changelog/20161010150035_added_entity_constraints_Magazine.xml','2016-10-15 08:44:27',10,'EXECUTED','7:c391ef493b48040cfa32dc8a73c4974d','addForeignKeyConstraint','',NULL,'3.4.2',NULL,NULL),('20161015074822-2','jhipster','classpath:config/liquibase/changelog/20161015074822_added_entity_constraints_Exemplaire.xml','2016-10-15 08:44:27',11,'EXECUTED','7:19562cad016701adbe6e9c7c694b3967','addForeignKeyConstraint (x2)','',NULL,'3.4.2',NULL,NULL),('20161010150030-2','jhipster','classpath:config/liquibase/changelog/20161010150030_added_entity_constraints_Emprunt.xml','2016-10-15 08:44:27',12,'EXECUTED','7:9a3b7e421d47c2b1b4b5a41ff96053c1','addForeignKeyConstraint (x3)','',NULL,'3.4.2',NULL,NULL),('20161015074825-2','jhipster','classpath:config/liquibase/changelog/20161015074825_added_entity_constraints_Reservation.xml','2016-10-15 08:44:27',13,'EXECUTED','7:7c0516f95b492f552b13b6b36bbe37c5','addForeignKeyConstraint (x2)','',NULL,'3.4.2',NULL,NULL);
/*!40000 ALTER TABLE `DATABASECHANGELOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DATABASECHANGELOGLOCK`
--

DROP TABLE IF EXISTS `DATABASECHANGELOGLOCK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DATABASECHANGELOGLOCK` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATABASECHANGELOGLOCK`
--

LOCK TABLES `DATABASECHANGELOGLOCK` WRITE;
/*!40000 ALTER TABLE `DATABASECHANGELOGLOCK` DISABLE KEYS */;
INSERT INTO `DATABASECHANGELOGLOCK` VALUES (1,'\0',NULL,NULL);
/*!40000 ALTER TABLE `DATABASECHANGELOGLOCK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auteur`
--

DROP TABLE IF EXISTS `auteur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auteur` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auteur`
--

LOCK TABLES `auteur` WRITE;
/*!40000 ALTER TABLE `auteur` DISABLE KEYS */;
INSERT INTO `auteur` VALUES (1,'DOE','John'),(2,'SEAGAL','Steven');
/*!40000 ALTER TABLE `auteur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emprunt`
--

DROP TABLE IF EXISTS `emprunt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emprunt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_emprunt` date DEFAULT NULL,
  `date_retour` date DEFAULT NULL,
  `usager_id` bigint(20) DEFAULT NULL,
  `livre_id` bigint(20) DEFAULT NULL,
  `magazine_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_emprunt_usager_id` (`usager_id`),
  KEY `fk_emprunt_livre_id` (`livre_id`),
  KEY `fk_emprunt_magazine_id` (`magazine_id`),
  CONSTRAINT `fk_emprunt_livre_id` FOREIGN KEY (`livre_id`) REFERENCES `livre` (`id`),
  CONSTRAINT `fk_emprunt_magazine_id` FOREIGN KEY (`magazine_id`) REFERENCES `magazine` (`id`),
  CONSTRAINT `fk_emprunt_usager_id` FOREIGN KEY (`usager_id`) REFERENCES `usager` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emprunt`
--

LOCK TABLES `emprunt` WRITE;
/*!40000 ALTER TABLE `emprunt` DISABLE KEYS */;
/*!40000 ALTER TABLE `emprunt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exemplaire`
--

DROP TABLE IF EXISTS `exemplaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exemplaire` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `edition` varchar(255) DEFAULT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `livre_id` bigint(20) DEFAULT NULL,
  `magazine_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_exemplaire_livre_id` (`livre_id`),
  KEY `fk_exemplaire_magazine_id` (`magazine_id`),
  CONSTRAINT `fk_exemplaire_livre_id` FOREIGN KEY (`livre_id`) REFERENCES `livre` (`id`),
  CONSTRAINT `fk_exemplaire_magazine_id` FOREIGN KEY (`magazine_id`) REFERENCES `magazine` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exemplaire`
--

LOCK TABLES `exemplaire` WRITE;
/*!40000 ALTER TABLE `exemplaire` DISABLE KEYS */;
INSERT INTO `exemplaire` VALUES (1,'M2SID','Neuf',1,NULL);
/*!40000 ALTER TABLE `exemplaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_authority`
--

DROP TABLE IF EXISTS `jhi_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_authority` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_authority`
--

LOCK TABLES `jhi_authority` WRITE;
/*!40000 ALTER TABLE `jhi_authority` DISABLE KEYS */;
INSERT INTO `jhi_authority` VALUES ('ROLE_ADMIN'),('ROLE_USER');
/*!40000 ALTER TABLE `jhi_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_persistent_audit_event`
--

DROP TABLE IF EXISTS `jhi_persistent_audit_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_persistent_audit_event` (
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `principal` varchar(50) NOT NULL,
  `event_date` timestamp NULL DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `idx_persistent_audit_event` (`principal`,`event_date`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_persistent_audit_event`
--

LOCK TABLES `jhi_persistent_audit_event` WRITE;
/*!40000 ALTER TABLE `jhi_persistent_audit_event` DISABLE KEYS */;
INSERT INTO `jhi_persistent_audit_event` VALUES (1,'admin','2016-10-15 10:37:35','AUTHENTICATION_SUCCESS'),(2,'admin','2016-10-15 11:33:32','AUTHENTICATION_SUCCESS'),(3,'user','2016-10-15 11:38:24','AUTHENTICATION_SUCCESS'),(4,'admin','2016-10-15 11:41:48','AUTHENTICATION_SUCCESS'),(5,'admin','2016-10-15 11:51:17','AUTHENTICATION_SUCCESS'),(6,'yolo','2016-10-15 11:51:41','AUTHENTICATION_FAILURE');
/*!40000 ALTER TABLE `jhi_persistent_audit_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_persistent_audit_evt_data`
--

DROP TABLE IF EXISTS `jhi_persistent_audit_evt_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_persistent_audit_evt_data` (
  `event_id` bigint(20) NOT NULL,
  `name` varchar(150) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`,`name`),
  KEY `idx_persistent_audit_evt_data` (`event_id`),
  CONSTRAINT `fk_evt_pers_audit_evt_data` FOREIGN KEY (`event_id`) REFERENCES `jhi_persistent_audit_event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_persistent_audit_evt_data`
--

LOCK TABLES `jhi_persistent_audit_evt_data` WRITE;
/*!40000 ALTER TABLE `jhi_persistent_audit_evt_data` DISABLE KEYS */;
INSERT INTO `jhi_persistent_audit_evt_data` VALUES (1,'remoteAddress','127.0.0.1'),(1,'sessionId','pEE17bLUA-U9MH1CO2Mpm7VUy2L8o-XWsjUwG_W8'),(2,'remoteAddress','127.0.0.1'),(2,'sessionId','VM4fpiJM5_PWbYC_YjTSNFFQ6GMrCPsRGOno6ptK'),(3,'remoteAddress','127.0.0.1'),(3,'sessionId','2S8BkUL7T19rl7w58xo_YT9MkgUATwXijWlLp6Hg'),(4,'remoteAddress','127.0.0.1'),(4,'sessionId','hH8FkngxuGcHkJuYBwfDdCf1g-faxuqY9xk274Y-'),(5,'remoteAddress','127.0.0.1'),(5,'sessionId','TDoO4dcI8CP7wO1DcuvEiopBD0hKxvbiXzXqV-2g'),(6,'message','Bad credentials'),(6,'remoteAddress','127.0.0.1'),(6,'sessionId','aRx0Uc0ZTw-RRc_BTrjv_TDUnQBxT_zt8nBivh9p'),(6,'type','org.springframework.security.authentication.BadCredentialsException');
/*!40000 ALTER TABLE `jhi_persistent_audit_evt_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_persistent_token`
--

DROP TABLE IF EXISTS `jhi_persistent_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_persistent_token` (
  `series` varchar(76) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `token_value` varchar(76) NOT NULL,
  `token_date` date DEFAULT NULL,
  `ip_address` varchar(39) DEFAULT NULL,
  `user_agent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`series`),
  KEY `fk_user_persistent_token` (`user_id`),
  CONSTRAINT `fk_user_persistent_token` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_persistent_token`
--

LOCK TABLES `jhi_persistent_token` WRITE;
/*!40000 ALTER TABLE `jhi_persistent_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `jhi_persistent_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_user`
--

DROP TABLE IF EXISTS `jhi_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password_hash` varchar(60) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `activated` bit(1) NOT NULL,
  `lang_key` varchar(5) DEFAULT NULL,
  `activation_key` varchar(20) DEFAULT NULL,
  `reset_key` varchar(20) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` timestamp NOT NULL,
  `reset_date` timestamp NULL DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `idx_user_login` (`login`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `idx_user_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_user`
--

LOCK TABLES `jhi_user` WRITE;
/*!40000 ALTER TABLE `jhi_user` DISABLE KEYS */;
INSERT INTO `jhi_user` VALUES (1,'system','$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG','System','System','system@localhost','','en',NULL,NULL,'system','2016-10-15 08:36:35',NULL,'system','2016-10-15 08:36:35'),(2,'anonymoususer','$2a$10$j8S5d7Sr7.8VTOYNviDPOeWX8KcYILUVJBsYV83Y5NtECayypx9lO','Anonymous','User','anonymous@localhost','','en',NULL,NULL,'system','2016-10-15 08:36:35',NULL,'system','2016-10-15 08:36:35'),(3,'admin','$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC','Administrator','Administrator','admin@localhost','','en',NULL,NULL,'system','2016-10-15 08:36:35',NULL,'system','2016-10-15 08:36:35'),(4,'user','$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K','User','User','user@localhost','','en',NULL,NULL,'system','2016-10-15 08:36:35',NULL,'system','2016-10-15 08:36:35'),(5,'test','$2a$10$XJYpLT/oSh3LrMxuNF8B1.ayvi7CcgVFh9A84FKTElsY.u3MHm62O',NULL,NULL,'test@test.fr','\0','en','07930178155581055210',NULL,'anonymousUser','2016-10-15 11:51:36',NULL,'anonymousUser','2016-10-15 11:51:36');
/*!40000 ALTER TABLE `jhi_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_user_authority`
--

DROP TABLE IF EXISTS `jhi_user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_user_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_name` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`authority_name`),
  KEY `fk_authority_name` (`authority_name`),
  CONSTRAINT `fk_authority_name` FOREIGN KEY (`authority_name`) REFERENCES `jhi_authority` (`name`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_user_authority`
--

LOCK TABLES `jhi_user_authority` WRITE;
/*!40000 ALTER TABLE `jhi_user_authority` DISABLE KEYS */;
INSERT INTO `jhi_user_authority` VALUES (1,'ROLE_ADMIN'),(1,'ROLE_USER'),(3,'ROLE_ADMIN'),(3,'ROLE_USER'),(4,'ROLE_USER'),(5,'ROLE_USER');
/*!40000 ALTER TABLE `jhi_user_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livre`
--

DROP TABLE IF EXISTS `livre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livre` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_edition` date DEFAULT NULL,
  `resume` varchar(255) DEFAULT NULL,
  `nb_resa` int(11) DEFAULT NULL,
  `date_ajout` date DEFAULT NULL,
  `auteur_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_livre_auteur_id` (`auteur_id`),
  CONSTRAINT `fk_livre_auteur_id` FOREIGN KEY (`auteur_id`) REFERENCES `auteur` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livre`
--

LOCK TABLES `livre` WRITE;
/*!40000 ALTER TABLE `livre` DISABLE KEYS */;
INSERT INTO `livre` VALUES (1,'1993-10-11','test',0,'2016-10-15',1);
/*!40000 ALTER TABLE `livre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magazine`
--

DROP TABLE IF EXISTS `magazine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `magazine` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `numero` int(11) DEFAULT NULL,
  `parution` date DEFAULT NULL,
  `periodicite` int(11) DEFAULT NULL,
  `nb_resa` int(11) DEFAULT NULL,
  `date_ajout` date DEFAULT NULL,
  `auteur_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_magazine_auteur_id` (`auteur_id`),
  CONSTRAINT `fk_magazine_auteur_id` FOREIGN KEY (`auteur_id`) REFERENCES `auteur` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magazine`
--

LOCK TABLES `magazine` WRITE;
/*!40000 ALTER TABLE `magazine` DISABLE KEYS */;
INSERT INTO `magazine` VALUES (1,13,'2016-10-12',1,0,'2016-10-15',2);
/*!40000 ALTER TABLE `magazine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `date_expiration` date DEFAULT NULL,
  `usager_reservation_id` bigint(20) DEFAULT NULL,
  `exemplaire_reservation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reservation_usager_reservation_id` (`usager_reservation_id`),
  KEY `fk_reservation_exemplaire_reservation_id` (`exemplaire_reservation_id`),
  CONSTRAINT `fk_reservation_exemplaire_reservation_id` FOREIGN KEY (`exemplaire_reservation_id`) REFERENCES `exemplaire` (`id`),
  CONSTRAINT `fk_reservation_usager_reservation_id` FOREIGN KEY (`usager_reservation_id`) REFERENCES `usager` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,'2016-10-15','2016-10-22',1,1);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usager`
--

DROP TABLE IF EXISTS `usager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usager` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usager`
--

LOCK TABLES `usager` WRITE;
/*!40000 ALTER TABLE `usager` DISABLE KEYS */;
INSERT INTO `usager` VALUES (1,'CHIRAC','Jacques','13 rue Michel Ney, 54000 Nancy');
/*!40000 ALTER TABLE `usager` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-15 15:54:07
