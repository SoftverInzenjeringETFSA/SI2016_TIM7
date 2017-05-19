-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2017 at 11:49 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


DROP SCHEMA IF EXISTS `tim7` ;
CREATE DATABASE tim7;
USE  tim7;


--
-- Database: `tim7`
--



-- --------------------------------------------------------

--
-- Table structure for table `osoba`
--

CREATE TABLE `osoba` (
  `id` int(10) NOT NULL,
  `korisnicko_ime` varchar(15) NOT NULL,
  `ime` varchar(15) NOT NULL,
  `prezime` varchar(20) NOT NULL,
  `sifra` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `id` int(10) NOT NULL,
  `sigurnosni_id` int(10) NOT NULL,
  `id_osobe` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`id`, `sigurnosni_id`, `id_osobe`) VALUES
(1, 225, 1);



-- --------------------------------------------------------

--
-- Table structure for table `moderator`
--

CREATE TABLE `moderator` (
  `id` int(10) NOT NULL,
  `sigurnosni_id` int(10) NOT NULL,
  `adresa` varchar(20) NOT NULL,
  `grad` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `id_osobe` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------


--
-- Table structure for table `clanbiblioteke`
--

CREATE TABLE `clanbiblioteke` (
  `id` int(10) NOT NULL,
  `broj_clanske_karte` varchar(10) NOT NULL,
  `datum_rodjenja` date NOT NULL,
  `adresa` varchar(20) NOT NULL,
  `mjesto_stanovanja` varchar(10) NOT NULL,
  `broj_telefona` varchar(30) NOT NULL,
  `ustanova` varchar(15) NOT NULL,
  `email` varchar(20) NOT NULL,
  `id_osobe` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clanbiblioteke`
--

INSERT INTO `clanbiblioteke` (`id`, `broj_clanske_karte`, `datum_rodjenja`, `adresa`, `mjesto_stanovanja`, `broj_telefona`, `ustanova`, `email`, `id_osobe`) VALUES
(1, '12345678', '1995-06-19', 'gk11', 'Sarajevo', '123-456-789', 'NA', 'email@example.com', 2);

-- --------------------------------------------------------

--
-- Table structure for table `kategorija`
--

CREATE TABLE `kategorija` (
  `id` int(25) NOT NULL,
  `naziv_kategorije` varchar(25) NOT NULL,
  `potkategorija` varchar(25) NOT NULL,
  `opis` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategorija`
--

INSERT INTO `kategorija` (`id`, `naziv_kategorije`, `potkategorija`, `opis`) VALUES
(1, 'strucna literatura', 'doktorska disertacija', 'doktorska disertacija');

-- --------------------------------------------------------

--
-- Table structure for table `literatura`
--

CREATE TABLE `literatura` (
  `id` int(10) NOT NULL,
  `autor_literature` varchar(50) NOT NULL,
  `naziv_literature` varchar(50) NOT NULL,
  `izdavac` varchar(30) NOT NULL,
  `godina_izdavanja` int(11) NOT NULL,
  `broj_strana` int(4) NOT NULL,
  `komentar` varchar(255) DEFAULT NULL,
  `mogucnost_preuzimanja` tinyint(1) NOT NULL,
  `datum_iznajmljivanja` date DEFAULT NULL,
  `datum_povratka` date DEFAULT NULL,
  `datum_unosa` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `kategorija` int(10) NOT NULL,
  `unajmio_clan` int(11) DEFAULT NULL,
  `iznajmio_moderator` int(11) DEFAULT NULL,
  `iznajmio_administrator` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `literatura`
--

INSERT INTO `literatura` (`id`, `autor_literature`, `naziv_literature`, `izdavac`, `godina_izdavanja`, `broj_strana`, `komentar`, `mogucnost_preuzimanja`, `datum_iznajmljivanja`, `datum_povratka`, `datum_unosa`, `kategorija`, `unajmio_clan`, `iznajmio_moderator`, `iznajmio_administrator`) VALUES
(1, 'john doe', 'doktor', 'etf', 20170508, 201, 'NA', 1, NULL, NULL, '2017-05-18 14:43:48', 1, NULL, NULL, NULL);


--
-- Indexes for dumped tables
--

--
-- Indexes for table `literatura`
--
ALTER TABLE `literatura`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKLiteratura343607` (`kategorija`),
  ADD KEY `unajmio_clan` (`unajmio_clan`),
  ADD KEY `iznajmio_moderator` (`iznajmio_moderator`),
  ADD KEY `iznajmio_administrator` (`iznajmio_administrator`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `literatura`
--
ALTER TABLE `literatura`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;




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

