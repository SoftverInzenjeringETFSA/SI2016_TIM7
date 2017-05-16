-- MySQL dump 10.13  Distrib 5.1.73, for Win64 (unknown)
--
-- Host: localhost    Database: tim7
-- ------------------------------------------------------
-- Server version	5.1.73-community

DROP SCHEMA IF EXISTS `tim7` ;
CREATE DATABASE tim7;
USE  tim7;


--
-- Table structure for table `osoba`
--

DROP TABLE IF EXISTS `osoba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osoba` (
  `idOsobe` varchar(10) NOT NULL,
  `Korisnicko ime` varchar(15) NOT NULL,
  `Ime` varchar(15) NOT NULL,
  `Prezime` varchar(20) NOT NULL,
  `Sifra` varchar(8) NOT NULL,
  PRIMARY KEY (`idOsobe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osoba`
--

LOCK TABLES `osoba` WRITE;
/*!40000 ALTER TABLE `osoba` DISABLE KEYS */;
/*!40000 ALTER TABLE `osoba` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrator` (
  `idAdministratora` varchar(10) NOT NULL,
  `SigurnosniID` int(10) NOT NULL,
  `idOsobe` varchar(10) NOT NULL,
  PRIMARY KEY (`idAdministratora`),
  KEY `FKAdministra712414` (`idOsobe`),
  CONSTRAINT `FKAdministra712414` FOREIGN KEY (`idOsobe`) REFERENCES `osoba` (`idOsobe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;




--
-- Table structure for table `moderator`
--

DROP TABLE IF EXISTS `moderator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `moderator` (
  `idModeratora` varchar(10) NOT NULL,
  `SigurnosniID` int(10) NOT NULL,
  `Adresa` varchar(20) NOT NULL,
  `Grad` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `idOsobe` varchar(10) NOT NULL,
  PRIMARY KEY (`idModeratora`),
  KEY `FKModerator180282` (`idOsobe`),
  CONSTRAINT `FKModerator180282` FOREIGN KEY (`idOsobe`) REFERENCES `osoba` (`idOsobe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moderator`
--

LOCK TABLES `moderator` WRITE;
/*!40000 ALTER TABLE `moderator` DISABLE KEYS */;
/*!40000 ALTER TABLE `moderator` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `kategorija`
--

DROP TABLE IF EXISTS `kategorija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kategorija` (
  `Kategorija` varchar(25) NOT NULL,
  `Naziv kategorije` varchar(25) NOT NULL,
  `Potkategorija` varchar(25) NOT NULL,
  `Opis` varchar(255) NOT NULL,
  PRIMARY KEY (`Kategorija`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategorija`
--

LOCK TABLES `kategorija` WRITE;
/*!40000 ALTER TABLE `kategorija` DISABLE KEYS */;
/*!40000 ALTER TABLE `kategorija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `literatura`
--

DROP TABLE IF EXISTS `literatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `literatura` (
  `idLiterature` int(10) NOT NULL AUTO_INCREMENT,
  `Autor literature` varchar(50) NOT NULL,
  `Naziv literature` varchar(50) NOT NULL,
  `Izdavac` varchar(30) NOT NULL,
  `Godina izdavanja` date NOT NULL,
  `Broj strana` int(4) NOT NULL,
  `Komentar` varchar(255) DEFAULT NULL,
  `Mogucnost preuzimanja` varchar(25) NOT NULL,
  `Datum unosa` date NOT NULL,
  `Kategorija` varchar(25) NOT NULL,
  PRIMARY KEY (`idLiterature`),
  KEY `FKLiteratura343607` (`Kategorija`),
  CONSTRAINT `FKLiteratura343607` FOREIGN KEY (`Kategorija`) REFERENCES `kategorija` (`Kategorija`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `literatura`
--

LOCK TABLES `literatura` WRITE;
/*!40000 ALTER TABLE `literatura` DISABLE KEYS */;
/*!40000 ALTER TABLE `literatura` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `arhiv`
--

DROP TABLE IF EXISTS `arhiv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arhiv` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Ukupan broj` int(10) NOT NULL,
  `Broj iznajmljenih` int(10) NOT NULL,
  `idLiterature` int(10) NOT NULL,
  KEY `FKArhiv824399` (`idLiterature`),
  CONSTRAINT `FKArhiv824399` FOREIGN KEY (`idLiterature`) REFERENCES `literatura` (`idLiterature`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arhiv`
--

LOCK TABLES `arhiv` WRITE;
/*!40000 ALTER TABLE `arhiv` DISABLE KEYS */;
/*!40000 ALTER TABLE `arhiv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clanbiblioteke`
--

DROP TABLE IF EXISTS `clanbiblioteke`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clanbiblioteke` (
  `Broj clanske karte` varchar(10) NOT NULL,
  `Datum rodjenja` date NOT NULL,
  `Adresa` varchar(20) NOT NULL,
  `Mjesto stanovanja` varchar(10) NOT NULL,
  `Broj telefona` decimal(19,0) NOT NULL,
  `Ustanova` varchar(15) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `idOsobe` varchar(10) NOT NULL,
  PRIMARY KEY (`Broj clanske karte`),
  KEY `FKClanBiblio900434` (`idOsobe`),
  CONSTRAINT `FKClanBiblio900434` FOREIGN KEY (`idOsobe`) REFERENCES `osoba` (`idOsobe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clanbiblioteke`
--

LOCK TABLES `clanbiblioteke` WRITE;
/*!40000 ALTER TABLE `clanbiblioteke` DISABLE KEYS */;
/*!40000 ALTER TABLE `clanbiblioteke` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iznajmljeno`
--

DROP TABLE IF EXISTS `iznajmljeno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iznajmljeno` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Naziv literature` varchar(50) NOT NULL,
  `Datum povratka` date NOT NULL,
  `Datum iznajmljivanja` date NOT NULL,
  `Autor literature` varchar(50) NOT NULL,
  `Broj clanske karte` varchar(10) NOT NULL,
  `idLiterature` int(10) NOT NULL,
  `Iznajmio moderator` varchar(10) DEFAULT NULL,
  `Iznajmio administrator` varchar(10) DEFAULT NULL,
  KEY `FKIznajmljen532543` (`Broj clanske karte`),
  KEY `FKIznajmljen444059` (`idLiterature`),
  KEY `FKIznajmljen647220` (`Iznajmio administrator`),
  KEY `FKIznajmljen870956` (`Iznajmio moderator`),
  CONSTRAINT `FKIznajmljen870956` FOREIGN KEY (`Iznajmio moderator`) REFERENCES `moderator` (`idModeratora`),
  CONSTRAINT `FKIznajmljen444059` FOREIGN KEY (`idLiterature`) REFERENCES `literatura` (`idLiterature`),
  CONSTRAINT `FKIznajmljen532543` FOREIGN KEY (`Broj clanske karte`) REFERENCES `clanbiblioteke` (`Broj clanske karte`),
  CONSTRAINT `FKIznajmljen647220` FOREIGN KEY (`Iznajmio administrator`) REFERENCES `administrator` (`idAdministratora`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iznajmljeno`
--

LOCK TABLES `iznajmljeno` WRITE;
/*!40000 ALTER TABLE `iznajmljeno` DISABLE KEYS */;
/*!40000 ALTER TABLE `iznajmljeno` ENABLE KEYS */;
UNLOCK TABLES;


-- Dump completed on 2017-05-11 17:46:44
