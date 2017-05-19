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
  `id` int(10) NOT NULL,
  `korisnicko_ime` varchar(15) NOT NULL,
  `ime` varchar(15) NOT NULL,
  `prezime` varchar(20) NOT NULL,
  `sifra` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `osoba`
--



-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;

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
-- Table structure for table `clanbiblioteke`
--


DROP TABLE IF EXISTS `clanbiblioteke`;

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
-- Table structure for table `iznajmljeno`
--



DROP TABLE IF EXISTS `iznajmljeno`;

CREATE TABLE `iznajmljeno` (
  `id` int(10) NOT NULL,
  `datum_povratka` date NOT NULL,
  `datum_iznajmljivanja` date NOT NULL,
  `unajmio_clan` int(10) NOT NULL,
  `id_literature` int(10) NOT NULL,
  `iznajmio_moderator` int(10) DEFAULT NULL,
  `iznajmio_administrator` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kategorija`
--

DROP TABLE IF EXISTS `kategorija`;

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

DROP TABLE IF EXISTS `literatura`;


CREATE TABLE `literatura` (
  `id` int(10) NOT NULL,
  `autor_literature` varchar(50) NOT NULL,
  `naziv_literature` varchar(50) NOT NULL,
  `izdavac` varchar(30) NOT NULL,
  `godina_izdavanja` date NOT NULL,
  `broj_strana` int(4) NOT NULL,
  `komentar` varchar(255) DEFAULT NULL,
  `mogucnost_preuzimanja` tinyint(1) NOT NULL,
  `datum_unosa` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `kategorija` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `literatura`
--

INSERT INTO `literatura` (`id`, `autor_literature`, `naziv_literature`, `izdavac`, `godina_izdavanja`, `broj_strana`, `komentar`, `mogucnost_preuzimanja`, `datum_unosa`, `kategorija`) VALUES
(1, 'john doe', 'doktor', 'etf', '2017-05-08', 201, 'NA', 1, '2017-05-18 14:43:48', 1);

-- --------------------------------------------------------

--
-- Table structure for table `moderator`
--

DROP TABLE IF EXISTS `moderator`;

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
-- Table structure for table `arhiv`
--


DROP TABLE IF EXISTS `arhiv`;

CREATE TABLE `arhiv` (
  `id` int(10) NOT NULL,
  `ukupan_broj` int(10) NOT NULL,
  `broj_iznajmljenih` int(10) NOT NULL,
  `id_literature` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




INSERT INTO `osoba` (`id`, `korisnicko_ime`, `ime`, `prezime`, `sifra`) VALUES
(1, 'jdoe12', 'john', 'doe', '12345'),
(2, 'clan1', 'almir', 'hamza', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKAdministra712414` (`id_osobe`);

--
-- Indexes for table `arhiv`
--
ALTER TABLE `arhiv`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKArhiv824399` (`id_literature`);

--
-- Indexes for table `clanbiblioteke`
--
ALTER TABLE `clanbiblioteke`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKClanBiblio900434` (`id_osobe`);

--
-- Indexes for table `iznajmljeno`
--
ALTER TABLE `iznajmljeno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKIznajmljen532543` (`unajmio_clan`),
  ADD KEY `FKIznajmljen444059` (`id_literature`),
  ADD KEY `FKIznajmljen647220` (`iznajmio_administrator`),
  ADD KEY `FKIznajmljen870956` (`iznajmio_moderator`);

--
-- Indexes for table `kategorija`
--
ALTER TABLE `kategorija`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `literatura`
--
ALTER TABLE `literatura`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKLiteratura343607` (`kategorija`);

--
-- Indexes for table `moderator`
--
ALTER TABLE `moderator`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKModerator180282` (`id_osobe`);

--
-- Indexes for table `osoba`
--
ALTER TABLE `osoba`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrator`
--
ALTER TABLE `administrator`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `arhiv`
--
ALTER TABLE `arhiv`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `clanbiblioteke`
--
ALTER TABLE `clanbiblioteke`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `iznajmljeno`
--
ALTER TABLE `iznajmljeno`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `kategorija`
--
ALTER TABLE `kategorija`
  MODIFY `id` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `literatura`
--
ALTER TABLE `literatura`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `moderator`
--
ALTER TABLE `moderator`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `osoba`
--
ALTER TABLE `osoba`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `FKAdministra712414` FOREIGN KEY (`id_osobe`) REFERENCES `osoba` (`id`);

--
-- Constraints for table `arhiv`
--
ALTER TABLE `arhiv`
  ADD CONSTRAINT `FKArhiv824399` FOREIGN KEY (`id_literature`) REFERENCES `literatura` (`id`);

--
-- Constraints for table `clanbiblioteke`
--
ALTER TABLE `clanbiblioteke`
  ADD CONSTRAINT `FKClanBiblio900434` FOREIGN KEY (`id_osobe`) REFERENCES `osoba` (`id`);

--
-- Constraints for table `iznajmljeno`
--
ALTER TABLE `iznajmljeno`
  ADD CONSTRAINT `FKIznajmljen444059` FOREIGN KEY (`id_literature`) REFERENCES `literatura` (`id`),
  ADD CONSTRAINT `FKIznajmljen532543` FOREIGN KEY (`unajmio_clan`) REFERENCES `clanbiblioteke` (`id`),
  ADD CONSTRAINT `FKIznajmljen647220` FOREIGN KEY (`iznajmio_administrator`) REFERENCES `administrator` (`id`),
  ADD CONSTRAINT `FKIznajmljen870956` FOREIGN KEY (`iznajmio_moderator`) REFERENCES `moderator` (`id`);

--
-- Constraints for table `literatura`
--
ALTER TABLE `literatura`
  ADD CONSTRAINT `FKLiteratura343607` FOREIGN KEY (`kategorija`) REFERENCES `kategorija` (`id`);

--
-- Constraints for table `moderator`
--
ALTER TABLE `moderator`
  ADD CONSTRAINT `FKModerator180282` FOREIGN KEY (`id_osobe`) REFERENCES `osoba` (`id`);

