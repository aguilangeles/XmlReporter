CREATE DATABASE  IF NOT EXISTS `reporteocr_1` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `reporteocr_1`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: reporteocr_1
-- ------------------------------------------------------
-- Server version	5.6.10

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
-- Table structure for table `campos`
--

DROP TABLE IF EXISTS `campos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSede` int(11) NOT NULL,
  `idIdc` int(11) NOT NULL,
  `campos` int(11) DEFAULT NULL,
  `campos_valid` int(11) DEFAULT NULL,
  `campos_invalid` int(11) DEFAULT NULL,
  `campos_invalidDB` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idcs` (`idIdc`),
  KEY `fk_sede` (`idSede`),
  CONSTRAINT `fk_sede` FOREIGN KEY (`idSede`) REFERENCES `sedes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_idcs` FOREIGN KEY (`idIdc`) REFERENCES `idc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campos`
--

LOCK TABLES `campos` WRITE;
/*!40000 ALTER TABLE `campos` DISABLE KEYS */;
/*!40000 ALTER TABLE `campos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caratulas`
--

DROP TABLE IF EXISTS `caratulas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caratulas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idIdc` int(11) NOT NULL,
  `idVolumen` int(11) NOT NULL,
  `idSede` int(11) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `tipo_doc` varchar(10) NOT NULL,
  `subtipo_doc` int(11) NOT NULL,
  `id_c1` varchar(20) DEFAULT NULL,
  `id_c2` varchar(20) DEFAULT NULL,
  `id_c3` varchar(20) DEFAULT NULL,
  `id_c4` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_crt_idc` (`idIdc`),
  KEY `fk_crt_sedes` (`idSede`),
  CONSTRAINT `fk_crt_idc` FOREIGN KEY (`idIdc`) REFERENCES `idc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_crt_sedes` FOREIGN KEY (`idSede`) REFERENCES `sedes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caratulas`
--

LOCK TABLES `caratulas` WRITE;
/*!40000 ALTER TABLE `caratulas` DISABLE KEYS */;
/*!40000 ALTER TABLE `caratulas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gna_crt`
--

DROP TABLE IF EXISTS `gna_crt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gna_crt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSede` int(11) NOT NULL,
  `idIdc` int(11) NOT NULL,
  `id_c1` varchar(100) DEFAULT NULL,
  `caja` varchar(100) DEFAULT NULL,
  `anio` varchar(100) DEFAULT NULL,
  `mes` varchar(100) DEFAULT NULL,
  `liquidacion` varchar(100) DEFAULT NULL,
  `unidad` varchar(100) DEFAULT NULL,
  `id_c2` varchar(100) DEFAULT NULL,
  `id_c3` varchar(100) DEFAULT NULL,
  `id_c4` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sede_gnd_carat` (`idSede`),
  KEY `fk_idc_gnd_carat` (`idIdc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gna_crt`
--

LOCK TABLES `gna_crt` WRITE;
/*!40000 ALTER TABLE `gna_crt` DISABLE KEYS */;
/*!40000 ALTER TABLE `gna_crt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gna_metadatos`
--

DROP TABLE IF EXISTS `gna_metadatos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gna_metadatos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSede` int(11) NOT NULL,
  `idIdc` int(11) NOT NULL,
  `grado_valid` int(11) DEFAULT NULL,
  `grado_invalid` int(11) DEFAULT NULL,
  `grado_invalidDB` int(11) DEFAULT NULL,
  `codEst_valid` int(11) DEFAULT NULL,
  `codEst_invalid` int(11) DEFAULT NULL,
  `codEst_invalidDB` int(11) DEFAULT NULL,
  `nombre_valid` int(11) DEFAULT NULL,
  `nombre_invalid` int(11) DEFAULT NULL,
  `nombre_invalidDB` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_gnd_idc_m` (`idIdc`),
  KEY `fk_gnd_sede_m` (`idSede`),
  CONSTRAINT `fk_gnd_idc_m` FOREIGN KEY (`idIdc`) REFERENCES `idc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_gnd_sede_m` FOREIGN KEY (`idSede`) REFERENCES `sedes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gna_metadatos`
--

LOCK TABLES `gna_metadatos` WRITE;
/*!40000 ALTER TABLE `gna_metadatos` DISABLE KEYS */;
/*!40000 ALTER TABLE `gna_metadatos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idc`
--

DROP TABLE IF EXISTS `idc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idVolumen` int(11) NOT NULL,
  `idSede` int(11) NOT NULL,
  `nombre_idc` varchar(45) NOT NULL,
  `papeles` int(11) DEFAULT NULL,
  `pap_validos` int(11) DEFAULT NULL,
  `pap_invalidos` int(11) DEFAULT NULL,
  `cant_caratulas` int(11) DEFAULT NULL,
  `imagenes` int(11) NOT NULL,
  `anversos` int(11) NOT NULL,
  `reversos` int(11) NOT NULL,
  `estado` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idc_vols` (`idVolumen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idc`
--

LOCK TABLES `idc` WRITE;
/*!40000 ALTER TABLE `idc` DISABLE KEYS */;
/*!40000 ALTER TABLE `idc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osn_crt`
--

DROP TABLE IF EXISTS `osn_crt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osn_crt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSede` int(11) NOT NULL,
  `idIdc` int(11) NOT NULL,
  `sumarias` int(11) DEFAULT NULL,
  `id_c2` varchar(100) DEFAULT NULL,
  `caja` varchar(100) DEFAULT NULL,
  `banco` varchar(100) DEFAULT NULL,
  `sucursal` varchar(100) DEFAULT NULL,
  `fecha_presentacion` varchar(100) DEFAULT NULL,
  `id_c3` varchar(45) DEFAULT NULL,
  `id_c4` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idc_osn_crt` (`idIdc`),
  KEY `fk_sede_osn_crt` (`idSede`),
  CONSTRAINT `fk_idc_osn_crt` FOREIGN KEY (`idIdc`) REFERENCES `idc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sede_osn_crt` FOREIGN KEY (`idSede`) REFERENCES `sedes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osn_crt`
--

LOCK TABLES `osn_crt` WRITE;
/*!40000 ALTER TABLE `osn_crt` DISABLE KEYS */;
/*!40000 ALTER TABLE `osn_crt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osn_metadatos`
--

DROP TABLE IF EXISTS `osn_metadatos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osn_metadatos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSede` int(11) NOT NULL,
  `idIdc` int(11) NOT NULL,
  `distrito_valid` int(11) DEFAULT NULL,
  `distrito_invalid` int(11) DEFAULT NULL,
  `partida_valid` int(11) DEFAULT NULL,
  `partida_invalid` int(11) DEFAULT NULL,
  `subcuenta_valid` int(11) DEFAULT NULL,
  `subcuenta_invalid` int(11) DEFAULT NULL,
  `digito_valid` int(11) DEFAULT NULL,
  `digito_invalid` int(11) DEFAULT NULL,
  `anio_valid` int(11) DEFAULT NULL,
  `anio_invalid` int(11) DEFAULT NULL,
  `bimestre_valid` int(11) DEFAULT NULL,
  `bimestre_invalid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_osn_sede` (`idSede`),
  KEY `fk_osn_idc` (`idIdc`),
  CONSTRAINT `fk_osn_idc` FOREIGN KEY (`idIdc`) REFERENCES `idc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_osn_sede` FOREIGN KEY (`idSede`) REFERENCES `sedes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osn_metadatos`
--

LOCK TABLES `osn_metadatos` WRITE;
/*!40000 ALTER TABLE `osn_metadatos` DISABLE KEYS */;
/*!40000 ALTER TABLE `osn_metadatos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sedes`
--

DROP TABLE IF EXISTS `sedes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sedes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sigla` varchar(5) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sigla` (`sigla`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sedes`
--

LOCK TABLES `sedes` WRITE;
/*!40000 ALTER TABLE `sedes` DISABLE KEYS */;
INSERT INTO `sedes` VALUES (1,'GNA','Gendarmería Nacional'),(2,'OSN','Obras Sanitarias de la Nacion');
/*!40000 ALTER TABLE `sedes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `totales`
--

DROP TABLE IF EXISTS `totales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `totales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idVolumen` int(11) NOT NULL,
  `idSede` int(11) NOT NULL,
  `papeles` int(11) DEFAULT NULL,
  `pap_validos` int(11) DEFAULT NULL,
  `pap_invalidos` int(11) DEFAULT NULL,
  `imagenes` int(11) DEFAULT NULL,
  `anversos` int(11) DEFAULT NULL,
  `reversos` int(11) DEFAULT NULL,
  `campos` int(11) DEFAULT NULL,
  `campos_valid` int(11) DEFAULT NULL,
  `campos_invalid` int(11) DEFAULT NULL,
  `campos_invalidDb` int(11) DEFAULT NULL,
  `estado_validacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sede_vol` (`idSede`),
  KEY `fk_volumen` (`idVolumen`),
  CONSTRAINT `fk_sede_vol` FOREIGN KEY (`idSede`) REFERENCES `sedes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_volumen` FOREIGN KEY (`idVolumen`) REFERENCES `volumen` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `totales`
--

LOCK TABLES `totales` WRITE;
/*!40000 ALTER TABLE `totales` DISABLE KEYS */;
/*!40000 ALTER TABLE `totales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volumen`
--

DROP TABLE IF EXISTS `volumen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volumen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSede` int(11) NOT NULL,
  `volumen` varchar(45) NOT NULL,
  `cantidad_idcs` int(11) NOT NULL COMMENT 'Fecha reporte: dato sobre el momento en que se realizo el reporte ',
  `fecha_reporte` date NOT NULL,
  `estado` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_sede_vols` (`idSede`),
  CONSTRAINT `fk_sede_vols` FOREIGN KEY (`idSede`) REFERENCES `sedes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volumen`
--

LOCK TABLES `volumen` WRITE;
/*!40000 ALTER TABLE `volumen` DISABLE KEYS */;
/*!40000 ALTER TABLE `volumen` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-12 15:47:27
