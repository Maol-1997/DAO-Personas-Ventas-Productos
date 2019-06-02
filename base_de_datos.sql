/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.1.37-MariaDB : Database - prog2dao1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prog2dao1` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `prog2dao1`;

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `persona` */

insert  into `persona`(`id`,`nombre`,`apellido`) values (2,'Martin','Ortiz'),(3,'Juan','Perez'),(4,'Laura','Lopez'),(16,'Mateo','Morgui');

/*Table structure for table `productos` */

DROP TABLE IF EXISTS `productos`;

CREATE TABLE `productos` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `precio` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `productos` */

insert  into `productos`(`id`,`nombre`,`descripcion`,`precio`) values (8,'pera','sonperas',50),(9,'naranja','sonnaranjas',60),(10,'carne','escarne',300),(11,'almohada','almo',2),(16,'ps4','play 4',5000);

/*Table structure for table `relventaproducto` */

DROP TABLE IF EXISTS `relventaproducto`;

CREATE TABLE `relventaproducto` (
  `idventa` int(10) DEFAULT NULL,
  `idproducto` int(10) DEFAULT NULL,
  KEY `relventa` (`idventa`),
  KEY `relproducto` (`idproducto`),
  CONSTRAINT `relproducto` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`id`),
  CONSTRAINT `relventa` FOREIGN KEY (`idventa`) REFERENCES `ventas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `relventaproducto` */

insert  into `relventaproducto`(`idventa`,`idproducto`) values (8,8),(8,10),(8,16);

/*Table structure for table `ventas` */

DROP TABLE IF EXISTS `ventas`;

CREATE TABLE `ventas` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `idpersona` int(10) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `valor` int(10) DEFAULT NULL,
  `descripcion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `relpersonaventa` (`idpersona`),
  CONSTRAINT `relpersonaventa` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `ventas` */

insert  into `ventas`(`id`,`idpersona`,`fecha`,`valor`,`descripcion`) values (8,16,'2019-06-02',5350,'mateo');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
