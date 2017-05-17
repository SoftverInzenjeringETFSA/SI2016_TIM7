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
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `korisnicko_ime` varchar(15) NOT NULL,
  `ime` varchar(15) NOT NULL,
  `prezime` varchar(20) NOT NULL,
  `sifra` varchar(8) NOT NULL,
  PRIMARY KEY (`id`)
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
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sigurnosni_id` int(10) NOT NULL,
  `id_osobe` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAdministra712414` (`id_osobe`),
  CONSTRAINT `FKAdministra712414` FOREIGN KEY (`id_osobe`) REFERENCES `osoba` (`id`)
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
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sigurnosni_id` int(10) NOT NULL,
  `adresa` varchar(20) NOT NULL,
  `grad` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `id_osobe` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKModerator180282` (`id_osobe`),
  CONSTRAINT `FKModerator180282` FOREIGN KEY (`id_osobe`) REFERENCES `osoba` (`id`)
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
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `naziv_kategorije` varchar(25) NOT NULL,
  `potkategorija` varchar(25) NOT NULL,
  `opis` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
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
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `autor_literature` varchar(50) NOT NULL,
  `naziv_literature` varchar(50) NOT NULL,
  `izdavac` varchar(30) NOT NULL,
  `godina_izdavanja` date NOT NULL,
  `broj_strana` int(4) NOT NULL,
  `komentar` varchar(255) DEFAULT NULL,
  `mogucnost_preuzimanja` varchar(25) NOT NULL,
  `datum_unosa` date NOT NULL,
  `kategorija` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKLiteratura343607` (`kategorija`),
  CONSTRAINT `FKLiteratura343607` FOREIGN KEY (`kategorija`) REFERENCES `kategorija` (`id`)
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
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ukupan_broj` int(10) NOT NULL,
  `broj_iznajmljenih` int(10) NOT NULL,
  `id_literature` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKArhiv824399` (`id_literature`),
  CONSTRAINT `FKArhiv824399` FOREIGN KEY (`id_literature`) REFERENCES `literatura` (`id`)
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
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `broj_clanske_karte` varchar(10) NOT NULL,
  `datum_rodjenja` date NOT NULL,
  `adresa` varchar(20) NOT NULL,
  `mjesto_stanovanja` varchar(10) NOT NULL,
  `broj_telefona` varchar(30) NOT NULL,
  `ustanova` varchar(15) NOT NULL,
  `email` varchar(20) NOT NULL,
  `id_osobe` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKClanBiblio900434` (`id_osobe`),
  CONSTRAINT `FKClanBiblio900434` FOREIGN KEY (`id_osobe`) REFERENCES `osoba` (`id`)
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
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `naziv_literature` varchar(50) NOT NULL,
  `datum_povratka` date NOT NULL,
  `datum_iznajmljivanja` date NOT NULL,
  `autor_literature` varchar(50) NOT NULL,
  `unajmio_clan` int(10) NOT NULL,
  `id_literature` int(10) NOT NULL,
  `iznajmio_moderator` int(10) DEFAULT NULL,
  `iznajmio_administrator` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKIznajmljen532543` (`unajmio_clan`),
  KEY `FKIznajmljen444059` (`id_literature`),
  KEY `FKIznajmljen647220` (`iznajmio_administrator`),
  KEY `FKIznajmljen870956` (`iznajmio_moderator`),
  CONSTRAINT `FKIznajmljen870956` FOREIGN KEY (`iznajmio_moderator`) REFERENCES `moderator` (`id`),
  CONSTRAINT `FKIznajmljen444059` FOREIGN KEY (`id_literature`) REFERENCES `literatura` (`id`),
  CONSTRAINT `FKIznajmljen532543` FOREIGN KEY (`unajmio_clan`) REFERENCES `clanbiblioteke` (`id`),
  CONSTRAINT `FKIznajmljen647220` FOREIGN KEY (`iznajmio_administrator`) REFERENCES `administrator` (`id`)
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
