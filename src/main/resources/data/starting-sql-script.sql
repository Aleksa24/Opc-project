/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.11-MariaDB : Database - opc_zadatak
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`opc_zadatak` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `opc_zadatak`;

/*Table structure for table `grad` */

DROP TABLE IF EXISTS `grad`;

CREATE TABLE `grad` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `grad` */

insert  into `grad`(`id`,`naziv`) values 
(1,'Beograd'),
(2,'Niš'),
(3,'Paraćin'),
(4,'Novi Sad'),
(5,'Vršac'),
(6,'Užice'),
(7,'Bor');

/*Table structure for table `kartica` */

DROP TABLE IF EXISTS `kartica`;

CREATE TABLE `kartica` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `broj_kartice` bigint(255) DEFAULT NULL,
  `kupac_id` bigint(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `broj_kartice` (`broj_kartice`),
  KEY `kupac_id` (`kupac_id`),
  CONSTRAINT `kartica_ibfk_1` FOREIGN KEY (`kupac_id`) REFERENCES `kupac` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Data for the table `kartica` */

insert  into `kartica`(`id`,`broj_kartice`,`kupac_id`) values 
(1,1,1),
(2,2,1),
(3,3,1),
(4,4,1),
(5,5,1),
(6,6,2),
(7,7,2),
(8,8,3),
(9,9,6),
(10,10,6);

/*Table structure for table `karticadozvoljengrad` */

DROP TABLE IF EXISTS `karticadozvoljengrad`;

CREATE TABLE `karticadozvoljengrad` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `kartica_id` bigint(100) DEFAULT NULL,
  `grad_id` bigint(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `kartica_id` (`kartica_id`),
  KEY `grad_id` (`grad_id`),
  CONSTRAINT `karticadozvoljengrad_ibfk_1` FOREIGN KEY (`kartica_id`) REFERENCES `kartica` (`id`),
  CONSTRAINT `karticadozvoljengrad_ibfk_2` FOREIGN KEY (`grad_id`) REFERENCES `grad` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

/*Data for the table `karticadozvoljengrad` */

insert  into `karticadozvoljengrad`(`id`,`kartica_id`,`grad_id`) values 
(1,1,1),
(2,1,7),
(3,2,5),
(4,3,3),
(5,4,4),
(6,4,6),
(7,5,1),
(8,6,4),
(9,7,6),
(10,7,7),
(11,9,1),
(12,10,3);

/*Table structure for table `kupac` */

DROP TABLE IF EXISTS `kupac`;

CREATE TABLE `kupac` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  `grad_id` bigint(100) DEFAULT NULL,
  `aktivan` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `grad_id` (`grad_id`),
  CONSTRAINT `kupac_ibfk_1` FOREIGN KEY (`grad_id`) REFERENCES `grad` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `kupac` */

insert  into `kupac`(`id`,`naziv`,`grad_id`,`aktivan`) values 
(1,'OPC',1,1),
(2,'NIS',4,1),
(3,'Pionir',3,1),
(4,'Elektronika',2,0),
(5,'Hemofarm',5,1),
(6,'Galenika',1,1),
(7,'RTB Bor',7,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
