-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 23, 2017 at 10:44 PM
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
  `asistent_oblast` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`asistent_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=79 ;

--
-- Dumping data for table `ASISTENT`
--

INSERT INTO `ASISTENT` (`asistent_id`, `asistent_ime`, `asistent_prezime`, `asistent_oblast`) VALUES
(1, 'Janko', 'Jankovic', 'MA103 Matematika za IT'),
(2, 'Dejan', 'Dejanovic', 'SE201 Uvod u softversko inženjerstvo'),
(3, 'Milan', 'Milanovic', 'IT170 Arhitektura racunara'),
(4, 'Ivana', 'Ivanovic', 'CS101 Uvod u objektno-orijentisano programiranje'),
(5, 'Jovan', 'Jovanovic', 'IT355 Web Sistemi 2'),
(6, 'Luka', 'Lukic', 'IT255 Web Sistemi 1'),
(7, 'Ana', 'Anic', 'CS330 Razvoj mobilnih aplikacija');

-- --------------------------------------------------------

--
-- Table structure for table `KORISNIK`
--

CREATE TABLE IF NOT EXISTS `KORISNIK` (
  `korisnik_id` int(11) NOT NULL AUTO_INCREMENT,
  `korisnik_ime` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `korisnik_prezime` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `korisnik_username` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `korisnik_password` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`korisnik_username`),
  UNIQUE KEY `korisnik_id` (`korisnik_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=40 ;

--
-- Dumping data for table `KORISNIK`
--

INSERT INTO `KORISNIK` (`korisnik_id`, `korisnik_ime`, `korisnik_prezime`, `korisnik_username`, `korisnik_password`, `enabled`) VALUES
(1, 'Janko', 'Jankovic', 'jankoj', '123456', 0),
(4, 'Pavle', 'Pavlovic', 'pavlep', '123456', 1),
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Dumping data for table `KORISNIK_ROLE`
--

INSERT INTO `KORISNIK_ROLE` (`korisnik_role_id`, `korisnik_username`, `role`) VALUES
(1, 'jankoj', 'ROLE_USER'),
(2, 'petarp', 'ROLE_USER'),
(3, 'petarp', 'ROLE_ADMIN'),
(6, 'pavlep', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `KURS`
--

CREATE TABLE IF NOT EXISTS `KURS` (
  `kurs_id` int(5) NOT NULL AUTO_INCREMENT,
  `kurs_sifra` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `asistent_id` int(11) NOT NULL,
  `profesor_id` int(11) NOT NULL,
  `kurs_naziv` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `kurs_godina` int(11) NOT NULL,
  `kurs_espb` int(11) NOT NULL,
  `kurs_opis` text COLLATE utf8_unicode_ci,
  `kurs_cena` int(10) NOT NULL,
  PRIMARY KEY (`kurs_id`),
  UNIQUE KEY `UK_ob9i95xe5pjncq2s83g1enot` (`kurs_sifra`),
  KEY `asistent_id` (`asistent_id`),
  KEY `profesor_id` (`profesor_id`),
  KEY `kurs_sifra` (`kurs_sifra`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Dumping data for table `KURS`
--

INSERT INTO `KURS` (`kurs_id`, `kurs_sifra`, `asistent_id`, `profesor_id`, `kurs_naziv`, `kurs_godina`, `kurs_espb`, `kurs_opis`, `kurs_cena`) VALUES
(1, 'MA103', 1, 1, 'MA103 Matematika za IT', 1, 8, 'Ovaj nastavni predmet omogućava studentima da razumeju i ovladaju osnovnim znanjima iz matematike potrebnim za praćenje daljih studija. Izlaganje gradiva započinje izučavanjem elemenata linearne algebre i to: determinanti, matrica i sistema linearnih jednačina. Uvod u matematičku analizu realne funkcije jedne realne promenljive započinje predavanjima koji su u vezi sa pregledom elementarnih i neelemantarnih funkcija, preko realnih nizova, zatim granične vrednosti i neprekidnosti realne funkcije jedne promenljive, pa sve do diferencijanog i integralnog računa realne funkcije jedne promenljive. Kurs se završava izučavanjem elemenata ekonomske i finansijske matematike.', 155),
(2, 'SE201', 2, 3, 'SE201 Uvod u softversko inženjerstvo', 3, 8, 'Cilj predmeta je studenti razumeju i ovladaju metodima i tehnikama razvoja profesionalnog softvera, što obuhvata rad na sledećim nastavnim jedinicama: softverski procesi, agilni razvoj softvera, inženjerstvo zahteva, modelovanje sistema, projektovanje arhitekture softvera, projektovanje i implementacija softvera, testiranje softvera i evolucija softvera. Predmet оspоsоbljаvа studеntе dа rаzviјu јаsnе, kоnciznе i fоrmаlizоvаnе zаhtеvе zа prоširеnjеm pоstојеćеg sistеmа u sklаdu sа rеаlnim pоtrеbаmа kоrisnikа, dа primеnе principе prојеktоvаnjа distribuirаnih sistеmа, dа izvršе аnаlizu i prојеktоvаnjе оbјеktnо-оriјеntisаnih sistеmа primеnоm UML diјаgrаmа, i dа primеnе tеhnikе mеrеnjа kvаlitеtа sоftvеrа. Poseban cilj predmeta je osposobljavanje studenta za samostalan rad pri izradi softverskog proizvoda. Zadaci koje ovaj predmet treba da ostvari je ovladavanje teorijskim, metodološkim i praktičnim znanjima razvoja softverskog inženjeringa, koja se 
primenjuju kroz upotrebu savremenih projektantskih alata.', 150),
(3, 'CS101', 4, 2, 'CS101 Uvod u objektno-orijentisano programiranje', 1, 8, 'Predmet uvodi studente u osnovne koncepte programiranja iz perspektive objektno-orijentisanog programiranja. Nastavne teme obuhvataju jednostavne tipove podataka, upravljačke strukture, strukture podataka u vidu nizova karaktera i redova, algoritme, kao i upoznavanje sa programskim jezicima. Studenti se upoznaju sa osnovama objektno-orijentisanog programiranja: objektima, klasama, metodima, prenosu parametar, učauravanja, nasleđivanja i polimorfizma. Pored toga, studenti ovladavaju i osnovama sintakse i semantike programskih jezika: promenljive, tipovi, izrazi, dodeljivanje vrednosti, ulazno-izlazne instrukcije, uslovne i iterativne upravljačke strukture i strukturisane dekompozicija. Izlažu se principi softverskog inženjerstva i razvoja osnovnih veština programiranja u objektno-orijentisanim jezicima. ', 160),
(4, 'IT255', 6, 5, 'IT255 Web Sistemi 1', 2, 8, 'Predmet uvodi studente u osnovne koncepte veb programiranja i dobru praksu dizajna veb sistema, Nielsen-ova pravila veb dizajna, organizaciju informacija i dizajniranje strukture veb stranica. Student se upoznaje sa karakteristikama kvaliteta veb dizajna, kao što su jasna navigacija, jednostavnost i efikasnost u objavljivanju i pronalaženju informacija, kvalitetan i ažuran sadržaj kako za računare visoke rezolucije tako i za uređaje manje rezolucije tehnikama prilagodljivog dizajna veb sistema (responsive web design – One Web for All Accessibility). Student treba da nauči da integriše različite Front-end veb tehnologije. Studenti su osposobljeni samostalno da dizajniraju i programiraju veb aplikacije i da integrišu različite Front-end veb tehnologije poput: HTML5, CSS3, JavaScript, PHP jezik i druge savremene tehnike.', 155),
(5, 'CS330', 7, 6, 'CS330 Razvoj mobilnih aplikacija', 3, 8, 'Predmet uvodi studente u programiranje mobilnih uređaja smart telefona i tableta. U okviru predmeta će biti obrađena teorija programiranja aplikacija za mobilne platforme, ali i konkretno programiranje za uređaje. U okviru predmeta će biti obrađeno: Rad sa MVC arhitekturom, rad sa osnovnim grafičkim komponentama, rad sa grafikom, animacije, rad sa ekranom na dodir, rad sa promenom ekrana sa uspravnog na položeni položaj, životni ciklus mobilnih aplikacija, rad sa slikama, rad sa web sadržajem, prikaz podataka u tabelama, snimanje i učitavanje podataka u memoriju mobilnog uređaja, rad sa nitima, rad sa lokacijama i mapama, rad sa notifikacijama, rad sa podacima u oblaku, rad sa web servisima, i dr. Kao rezultat rada na predmetu student je osposobljen da kreira mobilne aplikacije na najsavremenijim mobilnim uređajima, mobilnim telefonima i tabletima.', 170),
(6, 'IT355', 5, 1, 'IT355 Web Sistemi 2', 3, 8, 'Predmet uvodi studente u oblast projektovanja i programiranja serverske strane (Back-end). Izučavaju se veb klijent-server i višeslojne arhitekture, servisno orijentisana arhitektura, aspekt-orijentisano programiranje (AOP), inverzija kontrole (IoC) sa ubacivanjem zavisnih komponenti (DI), J2EE tehnologija i druge savremene tehnike. Kroz ovaj predmet student će biti upoznat sa java baziranim okvirom za dizajn i programiranje složenih veb aplikacija – Spring framework, tehnikama osiguranja bezbednosti veb sistema, tehnikama i alatima testiranja veb aplikacija. Studenti su osposobljeni samostalno da dizajniraju i programiraju složene veb aplikacije i da integrišu različite Back-end veb tehnologije poput: J2EE, Spring okvir i druge savremene tehnike.', 165);

-- --------------------------------------------------------

--
-- Table structure for table `NARUDZBINA`
--

CREATE TABLE IF NOT EXISTS `NARUDZBINA` (
  `narudzbina_id` int(11) NOT NULL AUTO_INCREMENT,
  `korisnik_username` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `narudzbina_datum` date NOT NULL,
  PRIMARY KEY (`narudzbina_id`),
  KEY `korisnik_username` (`korisnik_username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=18 ;

--
-- Dumping data for table `NARUDZBINA`
--

INSERT INTO `NARUDZBINA` (`narudzbina_id`, `korisnik_username`, `narudzbina_datum`) VALUES
(14, 'pavlep', '2017-06-23'),
(15, 'pavlep', '2017-06-23'),
(16, 'pavlep', '2017-06-23'),
(17, 'pavlep', '2017-06-23');

-- --------------------------------------------------------

--
-- Table structure for table `NARUDZBINA_DETALJI`
--

CREATE TABLE IF NOT EXISTS `NARUDZBINA_DETALJI` (
  `narudzbina_detalji_id` int(11) NOT NULL AUTO_INCREMENT,
  `kurs_sifra` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `narudzbina_id` int(11) NOT NULL,
  `narudzbina_detalji_cena` int(10) NOT NULL,
  `narudzbina_detalji_kolicina` int(10) NOT NULL,
  PRIMARY KEY (`narudzbina_detalji_id`),
  KEY `narudzbina_id` (`narudzbina_id`),
  KEY `kurs_sifra` (`kurs_sifra`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=17 ;

--
-- Dumping data for table `NARUDZBINA_DETALJI`
--

INSERT INTO `NARUDZBINA_DETALJI` (`narudzbina_detalji_id`, `kurs_sifra`, `narudzbina_id`, `narudzbina_detalji_cena`, `narudzbina_detalji_kolicina`) VALUES
(11, 'MA103', 14, 155, 2),
(12, 'SE201', 15, 150, 1),
(13, 'CS330', 15, 170, 1),
(14, 'IT355', 15, 165, 1),
(15, 'CS330', 16, 170, 2),
(16, 'CS101', 17, 160, 1);

-- --------------------------------------------------------

--
-- Table structure for table `PROFESOR`
--

CREATE TABLE IF NOT EXISTS `PROFESOR` (
  `profesor_id` int(11) NOT NULL AUTO_INCREMENT,
  `profesor_ime` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `profesor_prezime` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `profesor_oblast` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`profesor_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=18 ;

--
-- Dumping data for table `PROFESOR`
--

INSERT INTO `PROFESOR` (`profesor_id`, `profesor_ime`, `profesor_prezime`, `profesor_oblast`) VALUES
(1, 'Milena', 'Milenic', 'IT355 Web Sistemi 2'),
(2, 'Bogdan', 'Bogdanovic', 'CS101 Uvod u objektno-orijentisano programiranje'),
(3, 'Filip', 'Filipovic', 'SE201 Uvod u softversko inženjerstvo'),
(5, 'Jakov', 'Jakovljevic', 'IT255 Web Sistemi 1'),
(6, 'Veljko', 'Veljkovic', 'CS330 Razvoj mobilnih aplikacija'),
(7, 'Jelena', 'Jelenic', 'MA401 Matematika 4'),
(8, 'Stanko', 'Stankovic', 'MA103 Matematika za IT');

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
  ADD CONSTRAINT `FK_PROFESOR_KURS` FOREIGN KEY (`PROFESOR_ID`) REFERENCES `PROFESOR` (`PROFESOR_ID`),
  ADD CONSTRAINT `KURS_ibfk_1` FOREIGN KEY (`asistent_id`) REFERENCES `ASISTENT` (`asistent_id`),
  ADD CONSTRAINT `KURS_ibfk_2` FOREIGN KEY (`profesor_id`) REFERENCES `PROFESOR` (`profesor_id`);

--
-- Constraints for table `NARUDZBINA`
--
ALTER TABLE `NARUDZBINA`
  ADD CONSTRAINT `NARUDZBINA_ibfk_1` FOREIGN KEY (`korisnik_username`) REFERENCES `KORISNIK` (`korisnik_username`);

--
-- Constraints for table `NARUDZBINA_DETALJI`
--
ALTER TABLE `NARUDZBINA_DETALJI`
  ADD CONSTRAINT `NARUDZBINA_DETALJI_ibfk_2` FOREIGN KEY (`narudzbina_id`) REFERENCES `NARUDZBINA` (`narudzbina_id`),
  ADD CONSTRAINT `NARUDZBINA_DETALJI_ibfk_3` FOREIGN KEY (`kurs_sifra`) REFERENCES `KURS` (`kurs_sifra`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
