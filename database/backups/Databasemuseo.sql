-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: museo
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acquisto`
--

DROP TABLE IF EXISTS `acquisto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acquisto` (
  `data_acquisto` datetime NOT NULL,
  `n_biglietto` int NOT NULL,
  `cm_mostra` int NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `email_utente` varchar(50) NOT NULL,
  `data_visita` datetime NOT NULL,
  PRIMARY KEY (`data_acquisto`,`n_biglietto`,`cm_mostra`,`tipo`,`email_utente`),
  KEY `cm_mostra` (`cm_mostra`,`tipo`),
  KEY `email_utente` (`email_utente`),
  CONSTRAINT `acquisto_ibfk_1` FOREIGN KEY (`cm_mostra`, `tipo`) REFERENCES `biglietti` (`cm_mostra`, `tipo`) ON UPDATE CASCADE,
  CONSTRAINT `acquisto_ibfk_2` FOREIGN KEY (`email_utente`) REFERENCES `utenti` (`email`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acquisto`
--

LOCK TABLES `acquisto` WRITE;
/*!40000 ALTER TABLE `acquisto` DISABLE KEYS */;
/*!40000 ALTER TABLE `acquisto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `cf` varchar(16) NOT NULL,
  `cognome` varchar(15) NOT NULL,
  `nome` varchar(15) NOT NULL,
  PRIMARY KEY (`cf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avvisi`
--

DROP TABLE IF EXISTS `avvisi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avvisi` (
  `descrizione` varchar(1000) NOT NULL,
  `titolo` varchar(15) NOT NULL,
  `data` datetime NOT NULL,
  PRIMARY KEY (`data`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avvisi`
--

LOCK TABLES `avvisi` WRITE;
/*!40000 ALTER TABLE `avvisi` DISABLE KEYS */;
/*!40000 ALTER TABLE `avvisi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `biglietti`
--

DROP TABLE IF EXISTS `biglietti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `biglietti` (
  `tipo` varchar(10) NOT NULL,
  `prezzo` float NOT NULL,
  `cm_mostra` int NOT NULL,
  PRIMARY KEY (`cm_mostra`,`tipo`),
  CONSTRAINT `biglietti_ibfk_1` FOREIGN KEY (`cm_mostra`) REFERENCES `mostre` (`cm`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biglietti`
--

LOCK TABLES `biglietti` WRITE;
/*!40000 ALTER TABLE `biglietti` DISABLE KEYS */;
/*!40000 ALTER TABLE `biglietti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mostre`
--

DROP TABLE IF EXISTS `mostre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mostre` (
  `cm` int NOT NULL AUTO_INCREMENT,
  `data_inizio` datetime NOT NULL,
  `data_fine` datetime NOT NULL,
  `n_posti` int NOT NULL,
  `n_posti_disponibili` int DEFAULT '0',
  `descrizione` varchar(1000) NOT NULL,
  `nome` varchar(20) NOT NULL,
  PRIMARY KEY (`cm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mostre`
--

LOCK TABLES `mostre` WRITE;
/*!40000 ALTER TABLE `mostre` DISABLE KEYS */;
/*!40000 ALTER TABLE `mostre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opere`
--

DROP TABLE IF EXISTS `opere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opere` (
  `co` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `lunghezza` int NOT NULL,
  `altezza` int NOT NULL,
  `larghezza` int DEFAULT '0',
  `descrizione` varchar(1000) NOT NULL,
  PRIMARY KEY (`co`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opere`
--

LOCK TABLES `opere` WRITE;
/*!40000 ALTER TABLE `opere` DISABLE KEYS */;
/*!40000 ALTER TABLE `opere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizzazione`
--

DROP TABLE IF EXISTS `organizzazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organizzazione` (
  `data_organizzazione` datetime NOT NULL,
  `cf_personale` varchar(16) NOT NULL,
  `cm` int NOT NULL,
  PRIMARY KEY (`cm`,`cf_personale`,`data_organizzazione`),
  KEY `cf_personale` (`cf_personale`),
  CONSTRAINT `organizzazione_ibfk_1` FOREIGN KEY (`cf_personale`) REFERENCES `personale` (`cf`) ON UPDATE CASCADE,
  CONSTRAINT `organizzazione_ibfk_2` FOREIGN KEY (`cm`) REFERENCES `mostre` (`cm`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizzazione`
--

LOCK TABLES `organizzazione` WRITE;
/*!40000 ALTER TABLE `organizzazione` DISABLE KEYS */;
/*!40000 ALTER TABLE `organizzazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personale`
--

DROP TABLE IF EXISTS `personale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personale` (
  `cf` varchar(16) NOT NULL,
  `cognome` varchar(15) NOT NULL,
  `nome` varchar(15) NOT NULL,
  `tipo` varchar(15) NOT NULL,
  `stipendio` float NOT NULL,
  `cf_admin` varchar(16) NOT NULL,
  PRIMARY KEY (`cf`),
  KEY `cf_admin` (`cf_admin`),
  CONSTRAINT `personale_ibfk_1` FOREIGN KEY (`cf_admin`) REFERENCES `admin` (`cf`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personale`
--

LOCK TABLES `personale` WRITE;
/*!40000 ALTER TABLE `personale` DISABLE KEYS */;
/*!40000 ALTER TABLE `personale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestito`
--

DROP TABLE IF EXISTS `prestito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestito` (
  `data_inizio` datetime NOT NULL,
  `data_fine` datetime NOT NULL,
  `cm_mostra` int NOT NULL,
  `co_opera` int NOT NULL,
  PRIMARY KEY (`data_inizio`,`data_fine`,`cm_mostra`,`co_opera`),
  KEY `cm_mostra` (`cm_mostra`),
  KEY `co_opera` (`co_opera`),
  CONSTRAINT `prestito_ibfk_1` FOREIGN KEY (`cm_mostra`) REFERENCES `mostre` (`cm`) ON UPDATE CASCADE,
  CONSTRAINT `prestito_ibfk_2` FOREIGN KEY (`co_opera`) REFERENCES `opere` (`co`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestito`
--

LOCK TABLES `prestito` WRITE;
/*!40000 ALTER TABLE `prestito` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono`
--

DROP TABLE IF EXISTS `telefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefono` (
  `cf_personale` varchar(16) NOT NULL,
  `numero` int NOT NULL,
  PRIMARY KEY (`numero`),
  KEY `cf_personale` (`cf_personale`),
  CONSTRAINT `telefono_ibfk_1` FOREIGN KEY (`cf_personale`) REFERENCES `personale` (`cf`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono`
--

LOCK TABLES `telefono` WRITE;
/*!40000 ALTER TABLE `telefono` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turni`
--

DROP TABLE IF EXISTS `turni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turni` (
  `giorno` varchar(10) NOT NULL,
  `impiegato` varchar(15) NOT NULL,
  `ora_inizio` datetime NOT NULL,
  `ora_fine` datetime NOT NULL,
  PRIMARY KEY (`giorno`,`impiegato`,`ora_inizio`,`ora_fine`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turni`
--

LOCK TABLES `turni` WRITE;
/*!40000 ALTER TABLE `turni` DISABLE KEYS */;
/*!40000 ALTER TABLE `turni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenti`
--

DROP TABLE IF EXISTS `utenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utenti` (
  `email` varchar(50) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `n_telefono` int NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti`
--

LOCK TABLES `utenti` WRITE;
/*!40000 ALTER TABLE `utenti` DISABLE KEYS */;
/*!40000 ALTER TABLE `utenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-03 11:00:53
