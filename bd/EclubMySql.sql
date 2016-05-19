CREATE DATABASE  IF NOT EXISTS `eclub` /*!40100 DEFAULT CHARACTER SET latin1 */;
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
-- Table structure for table `empresa_divulgador`
--

DROP TABLE IF EXISTS `empresa_divulgador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa_divulgador` (
  `nome_Emp` varchar(70) NOT NULL DEFAULT '',
  `telefone_Emp` varchar(13) DEFAULT NULL,
  `email_Emp` varchar(50) DEFAULT NULL,
  `tipo_Emp` varchar(20) DEFAULT NULL,
  `senha_Emp` varchar(20) DEFAULT NULL,
  `cnpj_Emp` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`nome_Emp`,`cnpj_Emp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa_divulgador`
--

LOCK TABLES `empresa_divulgador` WRITE;
/*!40000 ALTER TABLE `empresa_divulgador` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa_divulgador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `cidade` varchar(20) DEFAULT NULL,
  `bairro` varchar(20) DEFAULT NULL,
  `cep` varchar(12) DEFAULT NULL,
  `rua` varchar(50) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `latitude` varchar(30) DEFAULT NULL,
  `longetude` varchar(30) DEFAULT NULL,
  `Estado` varchar(2) DEFAULT NULL,
  `id_Endereco` int(11) NOT NULL,
  PRIMARY KEY (`id_Endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `qntHomem` int(11) DEFAULT NULL,
  `valorEntrada` double DEFAULT NULL,
  `qntMulher` int(11) DEFAULT NULL,
  `qntMaxPessoas` int(11) DEFAULT NULL,
  `idEvento` int(11) NOT NULL,
  `nome_Evento` varchar(30) DEFAULT NULL,
  `foto_Evento` blob,
  `tipo_Evento` varchar(30) DEFAULT NULL,
  `data_Evento` date DEFAULT NULL,
  `hora_Evento` time DEFAULT NULL,
  `descrição_Evento` varchar(300) DEFAULT NULL,
  `id_Endereco` int(11) DEFAULT NULL,
  `nome_Emp` varchar(70) DEFAULT NULL,
  `cnpj_Emp` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idEvento`),
  KEY `id_Endereco` (`id_Endereco`),
  KEY `nome_Emp` (`nome_Emp`,`cnpj_Emp`),
  CONSTRAINT `evento_ibfk_1` FOREIGN KEY (`id_Endereco`) REFERENCES `endereco` (`id_Endereco`),
  CONSTRAINT `evento_ibfk_2` FOREIGN KEY (`nome_Emp`, `cnpj_Emp`) REFERENCES `empresa_divulgador` (`nome_Emp`, `cnpj_Emp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participa`
--

DROP TABLE IF EXISTS `participa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participa` (
  `redeSocial` varchar(30) DEFAULT NULL,
  `idEvento` int(11) DEFAULT NULL,
  KEY `redeSocial` (`redeSocial`),
  KEY `idEvento` (`idEvento`),
  CONSTRAINT `participa_ibfk_1` FOREIGN KEY (`redeSocial`) REFERENCES `usuario` (`redeSocial`),
  CONSTRAINT `participa_ibfk_2` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`idEvento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
  `id_Endereco` int(11) DEFAULT NULL,
  `nome_Emp` varchar(70) DEFAULT NULL,
  `cnpj_Emp` varchar(20) DEFAULT NULL,
  KEY `nome_Emp` (`nome_Emp`,`cnpj_Emp`),
  KEY `id_Endereco` (`id_Endereco`),
  CONSTRAINT `tem_ibfk_2` FOREIGN KEY (`id_Endereco`) REFERENCES `endereco` (`id_Endereco`),
  CONSTRAINT `tem_ibfk_1` FOREIGN KEY (`nome_Emp`, `cnpj_Emp`) REFERENCES `empresa_divulgador` (`nome_Emp`, `cnpj_Emp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tem`
--

LOCK TABLES `tem` WRITE;
/*!40000 ALTER TABLE `tem` DISABLE KEYS */;
/*!40000 ALTER TABLE `tem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `dataNascimento` date DEFAULT NULL,
  `redeSocial` varchar(30) NOT NULL,
  `sexo` tinyint(1) DEFAULT NULL,
  `nome_User` varchar(30) DEFAULT NULL,
  `telefone_User` varchar(13) DEFAULT NULL,
  `foto_User` blob,
  `email_User` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`redeSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
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

-- Dump completed on 2016-05-13  0:08:30
