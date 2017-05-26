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

DROP TABLE IF EXISTS `osoba`;
CREATE TABLE `osoba` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `korisnicko_ime` varchar(50) NOT NULL,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(20) NOT NULL,
  `sifra` varchar(50) NOT NULL,
  `tip` varchar(50) NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sigurnosni_id` int(10) NOT NULL,
  `id_osobe` int(10) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrator`
--




-- --------------------------------------------------------

--
-- Table structure for table `moderator`
--
DROP TABLE IF EXISTS `moderator`;
CREATE TABLE `moderator` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sigurnosni_id` int(10) NOT NULL,
  `adresa` varchar(50) NOT NULL,
  `grad` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `id_osobe` int(10) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------


--
-- Table structure for table `clanbiblioteke`
--
DROP TABLE IF EXISTS `clanbiblioteke`;
CREATE TABLE `clanbiblioteke` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `broj_clanske_karte` varchar(50) NOT NULL,
  `datum_rodjenja` date NOT NULL,
  `adresa` varchar(50) NOT NULL,
  `mjesto_stanovanja` varchar(50) NOT NULL,
  `broj_telefona` varchar(50) NOT NULL,
  `ustanova` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `id_osobe` int(10) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clanbiblioteke`
--

-- --------------------------------------------------------

--
-- Table structure for table `kategorija`
--
DROP TABLE IF EXISTS `kategorija`;
CREATE TABLE `kategorija` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `naziv_kategorije` varchar(50) NOT NULL,
  `potkategorija` varchar(50) NOT NULL,
  `opis` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
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
DROP TABLE IF EXISTS `literatura`;
CREATE TABLE `literatura` (
  `id` int(10) NOT NULL,
  `autor_literature` varchar(50) NOT NULL,
  `naziv_literature` varchar(50) NOT NULL,
  `izdavac` varchar(50) NOT NULL,
  `godina_izdavanja` int(11) NOT NULL,
  `broj_strana` int(10) NOT NULL,
  `komentar` varchar(255) DEFAULT NULL,
  `mogucnost_preuzimanja` tinyint(1) NOT NULL,
  `datum_iznajmljivanja` date DEFAULT NULL,
  `datum_povratka` date DEFAULT NULL,
  `datum_unosa` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `kategorija` int(10) NOT NULL,
  `unajmio_clan` int(11) NULL,
  `iznajmio_moderator` int(11) NULL,
  `iznajmio_administrator` int(11) NULL 
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
  ADD KEY `FKLiteraturaKategorija` (`kategorija`),
  ADD KEY `FKClan` (`unajmio_clan`),
  ADD KEY `FKModerator` (`iznajmio_moderator`),
  ADD KEY `FKAdmin` (`iznajmio_administrator`);

--
-- AUTO_INCREMENT for table `literatura`
--
ALTER TABLE `literatura`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for table `literatura`
--
ALTER TABLE `literatura`
  ADD CONSTRAINT `FKAdmin` FOREIGN KEY (`iznajmio_administrator`) REFERENCES `administrator` (`id`),
  ADD CONSTRAINT `FKClan` FOREIGN KEY (`unajmio_clan`) REFERENCES `clanbiblioteke` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKLiteraturaKategorija` FOREIGN KEY (`kategorija`) REFERENCES `kategorija` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKModerator` FOREIGN KEY (`iznajmio_moderator`) REFERENCES `moderator` (`id`);



ALTER TABLE `administrator`
  ADD KEY `FKAdminOsoba` (`id_osobe`);
ALTER TABLE `administrator`
  ADD CONSTRAINT `FKAdminOsoba` FOREIGN KEY (`id_osobe`) REFERENCES `osoba` (`id`) ON DELETE CASCADE;


ALTER TABLE `moderator`
  ADD KEY `FKModOsoba` (`id_osobe`);
ALTER TABLE `moderator`
  ADD CONSTRAINT `FKModOsoba` FOREIGN KEY (`id_osobe`) REFERENCES `osoba` (`id`) ON DELETE CASCADE;

ALTER TABLE `clanbiblioteke`
  ADD KEY `FKClanOsoba` (`id_osobe`);
ALTER TABLE `clanbiblioteke`
ADD CONSTRAINT `FKClanOsoba` FOREIGN KEY (`id_osobe`) REFERENCES `osoba` (`id`) ON DELETE CASCADE;


--
-- AUTO_INCREMENT for dumped tables
--




--
-- Table structure for table `arhiv`
--

DROP TABLE IF EXISTS `arhiv`;
CREATE TABLE `arhiv` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ukupan_broj` int(10) NOT NULL,
  `broj_iznajmljenih` int(10) NOT NULL,
  `id_literature` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKArhivLiteratura` (`id_literature`),
  CONSTRAINT `FKArhivLiteratura` FOREIGN KEY (`id_literature`) REFERENCES `literatura` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




INSERT INTO `osoba` (`id`, `korisnicko_ime`, `ime`, `prezime`, `sifra`, `tip`) VALUES
(7, 'admin', 'Dzana', 'Hanic', 'admin', 'Administrator'),
(9, 'mod_name', 'Imenko', 'Prezimenko', 'imenko2', 'Moderator'),
(10, 'janeuser', 'Jane', 'Doe', 'jane321', 'Clan');

INSERT INTO `moderator` (`id`, `sigurnosni_id`, `adresa`, `grad`, `email`, `id_osobe`) VALUES
(3, 39785, 'ABS', 'Sarajevo', 'imenko@gmail.com', 9);


INSERT INTO `clanbiblioteke` (`id`, `broj_clanske_karte`, `datum_rodjenja`, `adresa`, `mjesto_stanovanja`, `broj_telefona`, `ustanova`, `email`, `id_osobe`) VALUES
(6, '5251', '2017-05-03', 'Gradacacka', 'Sarajevo', '06211122', 'Gradska biblioteka', 'jane@gmail.com', 10);

INSERT INTO `administrator` (`id`, `sigurnosni_id`, `id_osobe`) VALUES
(3, 2712995, 7);

