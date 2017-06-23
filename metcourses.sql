-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 05, 2017 at 11:30 PM
-- Server version: 5.5.54
-- PHP Version: 5.3.10-1ubuntu3.26

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `metcourses`
--

-- --------------------------------------------------------

--
-- Table structure for table `ASISTENT`
--

CREATE TABLE IF NOT EXISTS `ASISTENT` (
  `asistent_id` int(11) NOT NULL AUTO_INCREMENT,
  `asistent_ime` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `asistent_prezime` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `asistent_oblast` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`asistent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `KORISNIK`
--

CREATE TABLE IF NOT EXISTS `KORISNIK` (
  `korisnik_id` int(11) NOT NULL,
  `korisnik_ime` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `korisnik_prezime` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `korisnik_username` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `korisnik_password` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`korisnik_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `KORISNIK`
--

INSERT INTO `KORISNIK` (`korisnik_id`, `korisnik_ime`, `korisnik_prezime`, `korisnik_username`, `korisnik_password`, `enabled`) VALUES
(1, 'Janko', 'Jankovic', 'jankoj', '123456', 1),
(2, 'Petar', 'Petrovic', 'petarp', '123456', 1);

-- --------------------------------------------------------

--
-- Table structure for table `KORISNIK_ROLE`
--

CREATE TABLE IF NOT EXISTS `KORISNIK_ROLE` (
  `korisnik_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `korisnik_username` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`korisnik_role_id`),
  KEY `korisnik_username` (`korisnik_username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `KORISNIK_ROLE`
--

INSERT INTO `KORISNIK_ROLE` (`korisnik_role_id`, `korisnik_username`, `role`) VALUES
(1, 'jankoj', 'ROLE_USER'),
(2, 'petarp', 'ROLE_USER'),
(3, 'petarp', 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `KURS`
--

CREATE TABLE IF NOT EXISTS `KURS` (
  `kurs_id` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `asistent_id` int(11) NOT NULL,
  `profesor_id` int(11) NOT NULL,
  `kurs_naziv` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `kurs_godina` int(11) NOT NULL,
  `kurs_espb` int(11) NOT NULL,
  `kurs_opis` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`kurs_id`),
  KEY `FK_ASISTENT_KURS` (`asistent_id`),
  KEY `FK_PROFESOR_KURS` (`profesor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `PROFESOR`
--

CREATE TABLE IF NOT EXISTS `PROFESOR` (
  `profesor_id` int(11) NOT NULL AUTO_INCREMENT,
  `profesor_ime` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `profesor_prezime` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `profesor_oblast` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`profesor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `KORISNIK_ROLE`
--
ALTER TABLE `KORISNIK_ROLE`
  ADD CONSTRAINT `KORISNIK_ROLE_ibfk_1` FOREIGN KEY (`korisnik_username`) REFERENCES `KORISNIK` (`korisnik_username`);

--
-- Constraints for table `KURS`
--
ALTER TABLE `KURS`
  ADD CONSTRAINT `FK_ASISTENT_KURS` FOREIGN KEY (`ASISTENT_ID`) REFERENCES `ASISTENT` (`ASISTENT_ID`),
  ADD CONSTRAINT `FK_PROFESOR_KURS` FOREIGN KEY (`PROFESOR_ID`) REFERENCES `PROFESOR` (`PROFESOR_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
