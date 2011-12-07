-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.8-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bd_bastanteo
--

CREATE DATABASE IF NOT EXISTS bd_bastanteo;
USE bd_bastanteo;

--
-- Definition of table `acceso`
--

DROP TABLE IF EXISTS `acceso`;
CREATE TABLE `acceso` (
  `C_PERFIL` int(11) NOT NULL,
  `C_ACCESO` int(11) NOT NULL,
  `NOMBRE` varchar(100) NOT NULL,
  `ORDEN` varchar(11) NOT NULL,
  `URL_ACCESO` varchar(100) NOT NULL,
  PRIMARY KEY (`C_PERFIL`,`C_ACCESO`),
  KEY `fk_ACCESO_PERFIL1` (`C_PERFIL`),
  CONSTRAINT `fk_ACCESO_PERFIL1` FOREIGN KEY (`C_PERFIL`) REFERENCES `perfil` (`C_PERFIL`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acceso`
--

/*!40000 ALTER TABLE `acceso` DISABLE KEYS */;
INSERT INTO `acceso` (`C_PERFIL`,`C_ACCESO`,`NOMBRE`,`ORDEN`,`URL_ACCESO`) VALUES 
 (1,1,' ','1',' '),
 (2,2,' ','1',' '),
 (3,3,' ','1',' '),
 (4,4,' ','1',' '),
 (5,5,' ','1',' ');
/*!40000 ALTER TABLE `acceso` ENABLE KEYS */;


--
-- Definition of table `bastanteo`
--

DROP TABLE IF EXISTS `bastanteo`;
CREATE TABLE `bastanteo` (
  `C_EMPRESA` char(8) NOT NULL,
  `C_GRUPO_BASTANTEO` int(11) NOT NULL,
  `C_PODER` char(4) NOT NULL,
  `C_TIPO_INTERVENCION` int(11) NOT NULL,
  `IMPORTE_MIN` decimal(10,0) NOT NULL DEFAULT '0',
  `IMPORTE_MAX` decimal(10,0) NOT NULL DEFAULT '0',
  `FECHA_INI` datetime NOT NULL,
  `FECHA_FIN` datetime NOT NULL,
  PRIMARY KEY (`C_EMPRESA`,`C_GRUPO_BASTANTEO`,`C_PODER`),
  KEY `fk_BASTANTEO_GRUPO_BASTANTEO1` (`C_EMPRESA`,`C_GRUPO_BASTANTEO`),
  KEY `fk_BASTANTEO_TIPO_INTERVENCION1` (`C_TIPO_INTERVENCION`),
  KEY `fk_BASTANTEO_PODER1` (`C_PODER`),
  CONSTRAINT `fk_BASTANTEO_GRUPO_BASTANTEO1` FOREIGN KEY (`C_EMPRESA`, `C_GRUPO_BASTANTEO`) REFERENCES `grupo_bastanteo` (`C_EMPRESA`, `C_GRUPO_BASTANTEO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_BASTANTEO_PODER1` FOREIGN KEY (`C_PODER`) REFERENCES `poder` (`C_PODER`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_BASTANTEO_TIPO_INTERVENCION1` FOREIGN KEY (`C_TIPO_INTERVENCION`) REFERENCES `tipo_intervencion` (`C_TIPO_INTERVENCION`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bastanteo`
--

/*!40000 ALTER TABLE `bastanteo` DISABLE KEYS */;
INSERT INTO `bastanteo` (`C_EMPRESA`,`C_GRUPO_BASTANTEO`,`C_PODER`,`C_TIPO_INTERVENCION`,`IMPORTE_MIN`,`IMPORTE_MAX`,`FECHA_INI`,`FECHA_FIN`) VALUES 
 ('1',1,'CHC0',1,'100','1000','2011-02-01 00:00:00','2011-02-01 00:00:00'),
 ('7',698,'CHC0',1,'200','2500','2011-12-06 00:00:00','2011-12-29 00:00:00');
/*!40000 ALTER TABLE `bastanteo` ENABLE KEYS */;


--
-- Definition of table `d_bastanteo_grupo`
--

DROP TABLE IF EXISTS `d_bastanteo_grupo`;
CREATE TABLE `d_bastanteo_grupo` (
  `C_EMPRESA` char(8) NOT NULL,
  `C_GRUPO_BASTANTEO` int(11) NOT NULL,
  `C_PODER` char(4) NOT NULL,
  `C_EMPRESA_FK` char(8) NOT NULL,
  `C_GRUPO_BASTANTEO_FK` int(11) NOT NULL,
  PRIMARY KEY (`C_EMPRESA`,`C_GRUPO_BASTANTEO`,`C_PODER`),
  KEY `fk_table1_GRUPO_BASTANTEO1` (`C_EMPRESA_FK`,`C_GRUPO_BASTANTEO_FK`),
  CONSTRAINT `fk_table1_BASTANTEO1` FOREIGN KEY (`C_EMPRESA`, `C_GRUPO_BASTANTEO`, `C_PODER`) REFERENCES `bastanteo` (`C_EMPRESA`, `C_GRUPO_BASTANTEO`, `C_PODER`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_GRUPO_BASTANTEO1` FOREIGN KEY (`C_EMPRESA_FK`, `C_GRUPO_BASTANTEO_FK`) REFERENCES `grupo_bastanteo` (`C_EMPRESA`, `C_GRUPO_BASTANTEO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `d_bastanteo_grupo`
--

/*!40000 ALTER TABLE `d_bastanteo_grupo` DISABLE KEYS */;
/*!40000 ALTER TABLE `d_bastanteo_grupo` ENABLE KEYS */;


--
-- Definition of table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
CREATE TABLE `empresa` (
  `C_EMPRESA` char(8) NOT NULL,
  `RUC` char(11) NOT NULL,
  `RAZON_SOCIAL` varchar(100) NOT NULL,
  `C_TIPO_EMPRESA` int(11) NOT NULL,
  `FECHA_INICIO_OPER` date DEFAULT NULL,
  `CANT_EMPLEADO` smallint(6) DEFAULT '0',
  PRIMARY KEY (`C_EMPRESA`),
  KEY `fk_EMPRESA_TIPO_EMPRESA1` (`C_TIPO_EMPRESA`),
  CONSTRAINT `fk_EMPRESA_TIPO_EMPRESA1` FOREIGN KEY (`C_TIPO_EMPRESA`) REFERENCES `tipo_empresa` (`C_TIPO_EMPRESA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `empresa`
--

/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` (`C_EMPRESA`,`RUC`,`RAZON_SOCIAL`,`C_TIPO_EMPRESA`,`FECHA_INICIO_OPER`,`CANT_EMPLEADO`) VALUES 
 ('1','21526423628','INVERSIONES UNIDAS SAC',1,'2011-09-05',77),
 ('7','77777777777','mmm',1,'2011-12-02',7),
 ('9','77777777777','ERT',1,'2011-12-01',8);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;


--
-- Definition of table `grupo_bastanteo`
--

DROP TABLE IF EXISTS `grupo_bastanteo`;
CREATE TABLE `grupo_bastanteo` (
  `C_EMPRESA` char(8) NOT NULL,
  `C_GRUPO_BASTANTEO` int(11) NOT NULL,
  `DESCRIPCION` varchar(100) NOT NULL,
  `ABREVIATURA` varchar(10) NOT NULL,
  PRIMARY KEY (`C_EMPRESA`,`C_GRUPO_BASTANTEO`),
  KEY `fk_GRUPO_BASTANTEO_EMPRESA1` (`C_EMPRESA`),
  CONSTRAINT `fk_GRUPO_BASTANTEO_EMPRESA1` FOREIGN KEY (`C_EMPRESA`) REFERENCES `empresa` (`C_EMPRESA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grupo_bastanteo`
--

/*!40000 ALTER TABLE `grupo_bastanteo` DISABLE KEYS */;
INSERT INTO `grupo_bastanteo` (`C_EMPRESA`,`C_GRUPO_BASTANTEO`,`DESCRIPCION`,`ABREVIATURA`) VALUES 
 ('1',1,'GRUPO A','A'),
 ('7',698,'GRUPO 3','3');
/*!40000 ALTER TABLE `grupo_bastanteo` ENABLE KEYS */;


--
-- Definition of table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
CREATE TABLE `perfil` (
  `C_PERFIL` int(11) NOT NULL,
  `NOMBRE` varchar(40) NOT NULL,
  `FLAG_ACTIVO` char(1) DEFAULT 'A',
  PRIMARY KEY (`C_PERFIL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `perfil`
--

/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` (`C_PERFIL`,`NOMBRE`,`FLAG_ACTIVO`) VALUES 
 (1,'EMPLEADO','A'),
 (2,'ABOGADO','A'),
 (3,'SUPERVISOR','A'),
 (4,'ADMINISTRADOR DE SISTEMA','A'),
 (5,'PERSONAL AGENCIA','A');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;


--
-- Definition of table `poder`
--

DROP TABLE IF EXISTS `poder`;
CREATE TABLE `poder` (
  `C_PODER` char(4) NOT NULL,
  `NOMBRE` varchar(40) NOT NULL,
  `TIPO_PODER` char(1) NOT NULL COMMENT 'VALORES:\n\nA = ACTIVO\nP = PASIVO',
  PRIMARY KEY (`C_PODER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `poder`
--

/*!40000 ALTER TABLE `poder` DISABLE KEYS */;
INSERT INTO `poder` (`C_PODER`,`NOMBRE`,`TIPO_PODER`) VALUES 
 ('CHC0','COBRO DE CHEQUE','A');
/*!40000 ALTER TABLE `poder` ENABLE KEYS */;


--
-- Definition of table `representante`
--

DROP TABLE IF EXISTS `representante`;
CREATE TABLE `representante` (
  `C_EMPRESA` char(8) NOT NULL,
  `C_REPRESENTANTE` int(11) NOT NULL,
  `APE_PATERNO` varchar(20) NOT NULL,
  `APE_MATERNO` varchar(20) NOT NULL,
  `NOMBRE` varchar(40) NOT NULL,
  `C_TIPO_DOC_ID` int(11) NOT NULL,
  `NUM_DOC_ID` varchar(15) NOT NULL,
  `CARGO_EMPRESA` varchar(50) NOT NULL,
  `C_EMPRESA_FK` char(8) NOT NULL,
  `C_GRUPO_BASTANTEO_FK` int(11) NOT NULL,
  PRIMARY KEY (`C_EMPRESA`,`C_REPRESENTANTE`),
  KEY `FK_REPRESENTANTE_EMPRESA` (`C_EMPRESA`),
  KEY `FK_REPRESENTANTE_TIPO_DOC_ID` (`C_TIPO_DOC_ID`),
  KEY `fk_REPRESENTANTE_GRUPO_BASTANTEO1` (`C_EMPRESA_FK`,`C_GRUPO_BASTANTEO_FK`),
  CONSTRAINT `fk_REPRESENTANTE_EMPRESA1` FOREIGN KEY (`C_EMPRESA`) REFERENCES `empresa` (`C_EMPRESA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_REPRESENTANTE_GRUPO_BASTANTEO1` FOREIGN KEY (`C_EMPRESA_FK`, `C_GRUPO_BASTANTEO_FK`) REFERENCES `grupo_bastanteo` (`C_EMPRESA`, `C_GRUPO_BASTANTEO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_REPRESENTANTE_TIPO_DOC_ID1` FOREIGN KEY (`C_TIPO_DOC_ID`) REFERENCES `tipo_doc_id` (`C_TIPO_DOC_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `representante`
--

/*!40000 ALTER TABLE `representante` DISABLE KEYS */;
INSERT INTO `representante` (`C_EMPRESA`,`C_REPRESENTANTE`,`APE_PATERNO`,`APE_MATERNO`,`NOMBRE`,`C_TIPO_DOC_ID`,`NUM_DOC_ID`,`CARGO_EMPRESA`,`C_EMPRESA_FK`,`C_GRUPO_BASTANTEO_FK`) VALUES 
 ('1',1,'PRINCIPE','ASCA','JENNY',1,'10743371','SUPERVISOR','1',1),
 ('1',723,'EEE','RRR','KKK',1,'75212036','HHH','1',1),
 ('1',789,'RR','RR','RR',1,'44444444','SUPERVISOR','1',1),
 ('1',12345,'SALAZAR','LOPEZ','MARIA',1,'10743376','AD.','1',1);
/*!40000 ALTER TABLE `representante` ENABLE KEYS */;


--
-- Definition of table `tipo_doc_id`
--

DROP TABLE IF EXISTS `tipo_doc_id`;
CREATE TABLE `tipo_doc_id` (
  `C_TIPO_DOC_ID` int(11) NOT NULL,
  `NOMBRE` varchar(40) NOT NULL,
  `ABREVIATURA` varchar(10) NOT NULL,
  PRIMARY KEY (`C_TIPO_DOC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_doc_id`
--

/*!40000 ALTER TABLE `tipo_doc_id` DISABLE KEYS */;
INSERT INTO `tipo_doc_id` (`C_TIPO_DOC_ID`,`NOMBRE`,`ABREVIATURA`) VALUES 
 (1,'DOCUMENTO NACIONAL DE IDENTIDAD','DNI');
/*!40000 ALTER TABLE `tipo_doc_id` ENABLE KEYS */;


--
-- Definition of table `tipo_empresa`
--

DROP TABLE IF EXISTS `tipo_empresa`;
CREATE TABLE `tipo_empresa` (
  `C_TIPO_EMPRESA` int(11) NOT NULL,
  `NOMBRE` varchar(40) NOT NULL,
  `ABREVIATURA` varchar(15) NOT NULL,
  PRIMARY KEY (`C_TIPO_EMPRESA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_empresa`
--

/*!40000 ALTER TABLE `tipo_empresa` DISABLE KEYS */;
INSERT INTO `tipo_empresa` (`C_TIPO_EMPRESA`,`NOMBRE`,`ABREVIATURA`) VALUES 
 (1,'SOCIEDAD ANONIMA CERRADA','SAC'),
 (2,'bbb','b');
/*!40000 ALTER TABLE `tipo_empresa` ENABLE KEYS */;


--
-- Definition of table `tipo_intervencion`
--

DROP TABLE IF EXISTS `tipo_intervencion`;
CREATE TABLE `tipo_intervencion` (
  `C_TIPO_INTERVENCION` int(11) NOT NULL,
  `NOMBRE` varchar(40) NOT NULL,
  PRIMARY KEY (`C_TIPO_INTERVENCION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_intervencion`
--

/*!40000 ALTER TABLE `tipo_intervencion` DISABLE KEYS */;
INSERT INTO `tipo_intervencion` (`C_TIPO_INTERVENCION`,`NOMBRE`) VALUES 
 (1,'A SOLA FIRMA');
/*!40000 ALTER TABLE `tipo_intervencion` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `C_USUARIO` int(11) NOT NULL,
  `CLAVE` varchar(15) NOT NULL,
  `LOGIN` varchar(15) NOT NULL,
  `NOMBRE` varchar(40) NOT NULL,
  `C_PERFIL` int(11) NOT NULL,
  `FLAG_ACTIVO` char(1) DEFAULT '&',
  `PATERNO` varchar(45) NOT NULL,
  `MATERNO` varchar(45) NOT NULL,
  `DNI` varchar(45) NOT NULL,
  `CLAVECONFIRM` varchar(15) NOT NULL,
  PRIMARY KEY (`C_USUARIO`),
  KEY `FK_USUARIO_PERFIL` (`C_PERFIL`),
  CONSTRAINT `fk_USUARIO_PERFIL1` FOREIGN KEY (`C_PERFIL`) REFERENCES `perfil` (`C_PERFIL`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`C_USUARIO`,`CLAVE`,`LOGIN`,`NOMBRE`,`C_PERFIL`,`FLAG_ACTIVO`,`PATERNO`,`MATERNO`,`DNI`,`CLAVECONFIRM`) VALUES 
 (1,'111','LBENVENUTO','LUIS',1,'A','BENVENUTO','CALDERON','43396240','111'),
 (2,'222','MZUMAETA','MARIO',3,'A','ZUMAETA','MORI','45213698','222'),
 (3,'888','YGALVEZ','YANINA',2,'A','GALVEZ','LI','45871235','888'),
 (4,'444','ADMIN','ADMIN',4,'M',' ',' ',' ','444'),
 (58,'555','JCCASANI','JOSE',5,'A','CCASANI','MAGALLANES','45621589','555'),
 (888,'7','GF12G','GF',1,'I','GF12','GF','42424242','7');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
