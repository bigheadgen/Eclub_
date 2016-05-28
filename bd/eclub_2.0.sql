CREATE DATABASE  IF NOT EXISTS `eclub` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `eclub`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eclub
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `divulgador`
--

DROP TABLE IF EXISTS `divulgador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `divulgador` (
  `cnpjDivulgador` varchar(15) NOT NULL DEFAULT '',
  `nomeDivulgador` varchar(30) NOT NULL DEFAULT '',
  `EmailDivulgador` varchar(30) DEFAULT NULL,
  `senhaDivulgador` varchar(15) DEFAULT NULL,
  `telefoneDivulgador` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`cnpjDivulgador`,`nomeDivulgador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `divulgador`
--

LOCK TABLES `divulgador` WRITE;
/*!40000 ALTER TABLE `divulgador` DISABLE KEYS */;
INSERT INTO `divulgador` VALUES ('X0000001','divulgadorX1','divulgadorX@gmail.com','123456','9123456'),('X0000002','divulgadorX2','divulgadorX2@hotmail.com','123450','9123450'),('X0000003','divulgadorX3','divulgadorX3@hotmail.com','123451','9123451'),('X0000004','divulgadorX4','divulgadorX4@hotmail.com','123452','9123452'),('X0000005','divulgadorX5','divulgadorX5@gmail.com','123453','9123453');
/*!40000 ALTER TABLE `divulgador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `cidade` varchar(25) DEFAULT NULL,
  `rua` varchar(50) DEFAULT NULL,
  `estado` varchar(25) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `latitude` varchar(25) NOT NULL DEFAULT '',
  `longitude` varchar(25) NOT NULL DEFAULT '',
  `bairro` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`latitude`,`longitude`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES ('olinda','X03','PE',3,'-7.9934558','-34.8497768','tambem nao sei'),('Recife','X01','PE',1,'-8.0581882','-34.88242','piedade'),('Jaboatao','X02','PE',2,'-8.1693708','-35.0025508','nao sei'),('caruaru','X04','PE',5,'-8.2098276','-35.6344908','tambem nao sei'),('Cabo de Santo Agostinho','X05','PE',5,'-8.289433','-35.0924409','tambem nao sei');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `qntMulher` int(11) DEFAULT NULL,
  `descricaoEvento` varchar(200) DEFAULT NULL,
  `valorEntrada` double DEFAULT NULL,
  `qntHomem` int(11) DEFAULT NULL,
  `qntMaxPessoas` int(11) DEFAULT NULL,
  `nomeEvento` varchar(30) DEFAULT NULL,
  `tipoEvento` varchar(30) DEFAULT NULL,
  `idEvento` int(11) NOT NULL,
  `cnpjDivulgador` varchar(15) DEFAULT NULL,
  `nomeDivulgador` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idEvento`),
  KEY `cnpjDivulgador` (`cnpjDivulgador`,`nomeDivulgador`),
  CONSTRAINT `evento_ibfk_1` FOREIGN KEY (`cnpjDivulgador`, `nomeDivulgador`) REFERENCES `divulgador` (`cnpjDivulgador`, `nomeDivulgador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (400,'blablablablablabla01',89,300,1500,'Rock01','rock-pop',1,'X0000001','divulgadorX1'),(800,'blublublublublublu',110,200,1200,'gogo','go',2,'X0000002','divulgadorX2'),(325,'oxiOxi',49,1000,2000,'gogo2','go2',3,'X0000002','divulgadorX2'),(150,'god',120,100,300,'gogooooooo3','go3',4,'X0000003','divulgadorX3'),(150,'god',120,100,300,'gogooooooo3','go3',5,'X0000004','divulgadorX4'),(100,'girl',70,20,200,'gogooooooo6','go6',6,'X0000005','divulgadorX5'),(20,'man',100,100,200,'gogooooooo7','go7',7,'X0000001','divulgadorX1'),(2900,'wow',250,3000,10000,'gogooooooo8','go8',8,'X0000001','divulgadorX1'),(290,'wow1',60,10,1000,'gogooooooo9','go9',9,'X0000005','divulgadorX5');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participa`
--

DROP TABLE IF EXISTS `participa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participa` (
  `idRedeSocial` int(11) DEFAULT NULL,
  `idEvento` int(11) DEFAULT NULL,
  KEY `idRedeSocial` (`idRedeSocial`),
  KEY `idEvento` (`idEvento`),
  CONSTRAINT `participa_ibfk_1` FOREIGN KEY (`idRedeSocial`) REFERENCES `usuario` (`idRedeSocial`),
  CONSTRAINT `participa_ibfk_2` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`idEvento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participa`
--

LOCK TABLES `participa` WRITE;
/*!40000 ALTER TABLE `participa` DISABLE KEYS */;
/*!40000 ALTER TABLE `participa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tem`
--

DROP TABLE IF EXISTS `tem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tem` (
  `Data` datetime NOT NULL,
  `latitude` varchar(25) DEFAULT NULL,
  `longitude` varchar(25) DEFAULT NULL,
  `idEvento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Data`),
  KEY `latitude` (`latitude`,`longitude`),
  KEY `idEvento` (`idEvento`),
  CONSTRAINT `tem_ibfk_1` FOREIGN KEY (`latitude`, `longitude`) REFERENCES `endereco` (`latitude`, `longitude`),
  CONSTRAINT `tem_ibfk_2` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`idEvento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tem`
--

LOCK TABLES `tem` WRITE;
/*!40000 ALTER TABLE `tem` DISABLE KEYS */;
INSERT INTO `tem` VALUES ('2016-01-02 00:00:00','-8.1693708','-35.0025508',5),('2016-05-28 00:00:00','-7.9934558','-34.8497768',1),('2016-06-29 00:00:00','-8.289433','-35.0924409',9),('2016-07-01 00:00:00','-8.1693708','-35.0025508',3),('2016-07-02 00:00:00','-8.1693708','-35.0025508',4),('2016-07-29 00:00:00','-8.289433','-35.0924409',9),('2016-08-29 00:00:00','-8.0581882','-34.88242',2),('2017-01-02 00:00:00','-8.289433','-35.0924409',6),('2017-06-29 00:00:00','-8.289433','-35.0924409',8),('2017-11-29 00:00:00','-8.289433','-35.0924409',8),('2017-12-02 00:00:00','-8.289433','-35.0924409',7),('2017-12-29 00:00:00','-8.289433','-35.0924409',8);
/*!40000 ALTER TABLE `tem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `nomeUsuario` varchar(30) DEFAULT NULL,
  `sexo` int(11) DEFAULT NULL,
  `dataNascimento` datetime DEFAULT NULL,
  `EmailUsuario` varchar(50) DEFAULT NULL,
  `telefoneUsuario` varchar(15) DEFAULT NULL,
  `idRedeSocial` int(11) NOT NULL,
  PRIMARY KEY (`idRedeSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('userX1',0,'1980-09-15 00:00:00','userX1@gmail.com','9000001',0),('userX2',1,'1996-08-30 00:00:00','userX2@gmail.com','9000002',2),('userX3',0,'1991-09-27 00:00:00','userX3@gmail.com','9000003',3),('userX4',0,'1950-02-01 00:00:00','userX4@gmail.com','9000004',4),('userX5',1,'1999-06-11 00:00:00','userX5@gmail.com','9000005',5);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-28 13:34:23
