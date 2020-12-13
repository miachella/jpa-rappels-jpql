-- MariaDB dump 10.17  Distrib 10.4.11-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: movie_db_2
-- ------------------------------------------------------
-- Server version	10.4.11-MariaDB

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
-- Table structure for table `acteur`
--

DROP TABLE IF EXISTS `acteur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acteur` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `anniversaire` date DEFAULT NULL,
  `href` varchar(255) DEFAULT NULL,
  `id_imdb` varchar(255) DEFAULT NULL,
  `identite` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `INDEX_ACTEUR_ID_IMDB` (`id_imdb`)
) ENGINE=InnoDB AUTO_INCREMENT=30527 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `annee` int(11) DEFAULT NULL,
  `id_imdb` varchar(255) DEFAULT NULL,
  `imdb_href` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `traite` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`),
  KEY `INDEX_FILM_ID_IMDB` (`id_imdb`),
  KEY `INDEX_FILM_NOM` (`nom`),
  KEY `INDEX_FILM_ANNEE` (`annee`)
) ENGINE=InnoDB AUTO_INCREMENT=81068 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `film_genre`
--

DROP TABLE IF EXISTS `film_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film_genre` (
  `id_film` bigint(20) NOT NULL,
  `id_genre` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `film_pays`
--

DROP TABLE IF EXISTS `film_pays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film_pays` (
  `id_film` bigint(20) NOT NULL,
  `id_pays` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `film_realisateur`
--

DROP TABLE IF EXISTS `film_realisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film_realisateur` (
  `id_film` bigint(20) NOT NULL,
  `id_realisateur` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=274 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pays`
--

DROP TABLE IF EXISTS `pays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pays` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `realisateur`
--

DROP TABLE IF EXISTS `realisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `realisateur` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `anniversaire` date DEFAULT NULL,
  `href` varchar(255) NOT NULL,
  `id_imdb` varchar(255) NOT NULL,
  `identite` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10313 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `id_acteur` bigint(20) DEFAULT NULL,
  `id_film` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqci566nxqijcpn1fxa1mfrj60` (`id_acteur`),
  KEY `INDEX_ROLE_ID_FILM_ID_ACTEUR` (`id_film`,`id_acteur`),
  CONSTRAINT `FKdphj0qhdfu7vg8lr42x6vq71h` FOREIGN KEY (`id_film`) REFERENCES `film` (`id`),
  CONSTRAINT `FKqci566nxqijcpn1fxa1mfrj60` FOREIGN KEY (`id_acteur`) REFERENCES `acteur` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=215277 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-13 20:46:59
