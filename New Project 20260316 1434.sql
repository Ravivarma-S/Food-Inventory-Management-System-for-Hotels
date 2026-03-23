-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.25a


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema hotelinventory
--

CREATE DATABASE IF NOT EXISTS hotelinventory;
USE hotelinventory;

--
-- Definition of table `ingrediants`
--

DROP TABLE IF EXISTS `ingrediants`;
CREATE TABLE `ingrediants` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ing_name` varchar(255) DEFAULT NULL,
  `ing_note` varchar(255) DEFAULT NULL,
  `ing_qty` varchar(255) DEFAULT NULL,
  `ing_unit` varchar(255) DEFAULT NULL,
  `recipe_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKak1yg8bliamungivwijbvhohl` (`recipe_id`),
  CONSTRAINT `FKak1yg8bliamungivwijbvhohl` FOREIGN KEY (`recipe_id`) REFERENCES `reciepe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ingrediants`
--

/*!40000 ALTER TABLE `ingrediants` DISABLE KEYS */;
INSERT INTO `ingrediants` (`id`,`ing_name`,`ing_note`,`ing_qty`,`ing_unit`,`recipe_id`) VALUES 
 (3,'Rice','basmati','0.5','kg',2),
 (4,'Chicken','Fried','10','g',2);
/*!40000 ALTER TABLE `ingrediants` ENABLE KEYS */;


--
-- Definition of table `reciepe`
--

DROP TABLE IF EXISTS `reciepe`;
CREATE TABLE `reciepe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dish_name` varchar(255) DEFAULT NULL,
  `preparation_notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reciepe`
--

/*!40000 ALTER TABLE `reciepe` DISABLE KEYS */;
INSERT INTO `reciepe` (`id`,`dish_name`,`preparation_notes`) VALUES 
 (2,'Chicken Rice','rjsr6kxmk mgtxk');
/*!40000 ALTER TABLE `reciepe` ENABLE KEYS */;


--
-- Definition of table `restaurent`
--

DROP TABLE IF EXISTS `restaurent`;
CREATE TABLE `restaurent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restaurent`
--

/*!40000 ALTER TABLE `restaurent` DISABLE KEYS */;
INSERT INTO `restaurent` (`id`,`brand`,`contact`,`email`,`fullname`,`password`) VALUES 
 (1,'AA Restaurent','7897897894','aa@gmail.com','AA','11'),
 (4,'Spicy','9698969895','bb@gmail.com','BB','123456');
/*!40000 ALTER TABLE `restaurent` ENABLE KEYS */;


--
-- Definition of table `stocks`
--

DROP TABLE IF EXISTS `stocks`;
CREATE TABLE `stocks` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `expiry_date` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` varchar(255) DEFAULT NULL,
  `reorder_level` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stocks`
--

/*!40000 ALTER TABLE `stocks` DISABLE KEYS */;
INSERT INTO `stocks` (`id`,`expiry_date`,`product_name`,`quantity`,`reorder_level`,`unit`) VALUES 
 (1,'2026-03-28','Chicken','90.0','2','kg'),
 (2,'2026-03-27','Rice','99.5','20','kg');
/*!40000 ALTER TABLE `stocks` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
