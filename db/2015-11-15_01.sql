-- MySQL dump 10.13  Distrib 5.7.8-rc, for Win64 (x86_64)
--
-- Host: localhost    Database: park
-- ------------------------------------------------------
-- Server version	5.7.8-rc-log

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
-- Table structure for table `attraction`
--
use park;
DROP TABLE IF EXISTS `attraction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attraction` (
  `id_attraction` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `height` int(11) NOT NULL,
  `att_picture` text NOT NULL,
  `price_adult` int(11) NOT NULL,
  `price_child` int(11) NOT NULL,
  PRIMARY KEY (`id_attraction`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attraction`
--

LOCK TABLES `attraction` WRITE;
/*!40000 ALTER TABLE `attraction` DISABLE KEYS */;
INSERT INTO `attraction` VALUES (1,'Best','Best attraction ever',31,'D:\\Images\\lNmNhbLUHU.mypic',31,14),(2,'New ','New',60,'D:\\Images\\fVVPKqLQxr.mypic',51,15),(3,'Super','Super',90,'D:\\Images\\HHATxfCymu.mypic',80,90),(4,'Ulet','Ulet',90,'D:\\Images\\oFqerPNRqe.mypic',80,89),(5,'Banzai','Banzai',90,'D:\\Images\\ihctbMUUoD.mypic',80,31);
/*!40000 ALTER TABLE `attraction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id_comment` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_news` int(11) NOT NULL,
  `body` varchar(130) NOT NULL,
  `wrote_date` datetime NOT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `userrId_idx` (`id_user`),
  KEY `news_id_idx` (`id_news`),
  CONSTRAINT `news_id` FOREIGN KEY (`id_news`) REFERENCES `news` (`id_news`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userrId` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (2,1,1,'Круто','2015-11-09 13:47:51');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id_news` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `title` text NOT NULL,
  `body` text NOT NULL,
  `news_picture` text NOT NULL,
  `post_date` datetime NOT NULL,
  PRIMARY KEY (`id_news`),
  KEY `userId_idx` (`id_user`),
  CONSTRAINT `userId` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='				';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,1,'ПЕРВЫЙ В УКРАИНЕ ФЕСТИВАЛЬ ЗОМБИ ПРОЙДЕТ В ПАРКЕ ГОРЬКОГО','В этом году в рамках традиционного празднования \"Жуткого Хэллоуина в парке\" состоится ЗомбиFEST. Мероприятие, связанное с популярной сейчас темой оживших мертвецов, пройдет впервые в Украине. ЗомбиFEST влючает в себя массу тематических активностей и развлечений.\n\nТак, на аллее у Развлекательного центра разместится Ярмарка Ужасов и Станция Превращения в Зомби. На Средневековой площади пройдет турнир \"Зомби против людей\", в Логове Билли Кида - интерактивная игра \"Охота на Зомби\".\n\nУчастники конкурсов и состязаний получат призы от парка Горького и наших партнеров - Планеты кино ІМАХ, Харьковского дельфинария \"Немо\", квест-комнаты \"Взаперти\", Харьковского цирка.\n\nВечером по Центральной аллее пройдет массовое шествие зомби, в Ретро-парке - киномарафон фильмов ужасов, а на Главной сцене состоится праздничная шоу-программа с тематическими конкурсами, фаершоу и дискотекой.','D:\\Images\\News\\gHSdGLdyDJ.mypic','2015-10-15 22:56:46');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id_role`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `id_role` int(11) NOT NULL,
  `login` varchar(30) NOT NULL,
  `password` varchar(16) NOT NULL,
  `first_name` varchar(60) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `reg_date` datetime NOT NULL,
  `status_banned` tinyint(1) NOT NULL,
  `dob` date NOT NULL,
  `salt` varchar(256) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `idRole` (`id_role`),
  CONSTRAINT `idRole` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'admin','1234','admin','admin','admin@mail.ru','+38056789123','2015-11-08 00:00:00',0,'1991-06-03','123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-15 22:27:20
