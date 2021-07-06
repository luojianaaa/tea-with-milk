/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.40 : Database - milkteashop_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`milkteashop_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `milkteashop_db`;

/*Table structure for table `administrators` */

DROP TABLE IF EXISTS `administrators`;

CREATE TABLE `administrators` (
  `aid` varchar(2) NOT NULL,
  `anum` varchar(15) NOT NULL,
  `apassword` varchar(15) NOT NULL,
  `aname` varchar(5) NOT NULL,
  `aposition` varchar(5) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `administrators` */

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `comid` varchar(3) NOT NULL,
  `cid` varchar(20) NOT NULL,
  `comtext` text NOT NULL,
  `comtime` date NOT NULL,
  PRIMARY KEY (`comid`),
  KEY `cid` (`cid`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

/*Table structure for table `commodity` */

DROP TABLE IF EXISTS `commodity`;

CREATE TABLE `commodity` (
  `coid` varchar(3) NOT NULL,
  `coname` varchar(10) NOT NULL,
  `coprice` double NOT NULL,
  `costock` int(11) NOT NULL,
  PRIMARY KEY (`coid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `commodity` */

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `cid` varchar(20) NOT NULL,
  `cphonenumber` varchar(11) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

/*Table structure for table `detailed` */

DROP TABLE IF EXISTS `detailed`;

CREATE TABLE `detailed` (
  `oid` varchar(5) NOT NULL,
  `coid` varchar(3) NOT NULL,
  `cnum` int(11) NOT NULL,
  `cprice` double NOT NULL,
  PRIMARY KEY (`oid`,`coid`),
  KEY `coid` (`coid`),
  CONSTRAINT `detailed_ibfk_1` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`),
  CONSTRAINT `detailed_ibfk_2` FOREIGN KEY (`coid`) REFERENCES `commodity` (`coid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `detailed` */

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `oid` varchar(5) NOT NULL,
  `cid` varchar(20) NOT NULL,
  `oprice` double NOT NULL,
  `otime` datetime NOT NULL,
  PRIMARY KEY (`oid`),
  KEY `cid` (`cid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

/*Table structure for table `table_number` */

DROP TABLE IF EXISTS `table_number`;

CREATE TABLE `table_number` (
  `tid` varchar(3) NOT NULL,
  `cid` varchar(20) NOT NULL,
  `tnum` varchar(3) NOT NULL,
  PRIMARY KEY (`tid`),
  KEY `cid` (`cid`),
  CONSTRAINT `table_number_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `table_number` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
