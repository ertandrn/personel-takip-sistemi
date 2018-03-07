-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.30-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema personel_takip_sistemi
--

CREATE DATABASE IF NOT EXISTS personel_takip_sistemi;
USE personel_takip_sistemi;

--
-- Definition of table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `kadi` varchar(45) NOT NULL,
  `sifre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`,`kadi`,`sifre`) VALUES 
 (1,'admin','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


--
-- Definition of table `izinler`
--

DROP TABLE IF EXISTS `izinler`;
CREATE TABLE `izinler` (
  `birim` varchar(45) NOT NULL,
  `kayit_no` int(10) unsigned NOT NULL,
  `sicil_no` int(10) unsigned NOT NULL,
  `kalan_izin_mik` int(10) unsigned NOT NULL,
  `izin_bas_tarih` date NOT NULL,
  `izin_bts_tarih` date NOT NULL,
  `izin_turu` varchar(45) NOT NULL,
  `kullanilan_izin_mik` int(10) unsigned NOT NULL,
  PRIMARY KEY (`kayit_no`) USING BTREE,
  KEY `FK` (`sicil_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `izinler`
--

/*!40000 ALTER TABLE `izinler` DISABLE KEYS */;
INSERT INTO `izinler` (`birim`,`kayit_no`,`sicil_no`,`kalan_izin_mik`,`izin_bas_tarih`,`izin_bts_tarih`,`izin_turu`,`kullanilan_izin_mik`) VALUES 
 ('Yazilim',1,1,5,'2017-02-10','2017-02-20','Ucretsiz',5),
 ('Donanim',2,2,10,'2017-05-05','2017-05-20','Yillik',5),
 ('Bilgi Islem',3,3,5,'2017-12-15','2017-12-30','Ucretli',10),
 ('Donanim',4,4,15,'2017-08-01','2017-08-31','Mazeret',15),
 ('Yazilim',5,5,10,'2017-01-01','2017-01-31','Yillik',20);
/*!40000 ALTER TABLE `izinler` ENABLE KEYS */;


--
-- Definition of table `kisi_bilgi`
--

DROP TABLE IF EXISTS `kisi_bilgi`;
CREATE TABLE `kisi_bilgi` (
  `ad` varchar(45) NOT NULL,
  `soyad` varchar(45) NOT NULL,
  `tc_no` varchar(45) NOT NULL,
  `sicil_no` int(10) unsigned NOT NULL,
  `cinsiyet` varchar(45) NOT NULL,
  `dogum_tarihi` date NOT NULL,
  `sehir` varchar(45) NOT NULL,
  PRIMARY KEY (`tc_no`,`sicil_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kisi_bilgi`
--

/*!40000 ALTER TABLE `kisi_bilgi` DISABLE KEYS */;
INSERT INTO `kisi_bilgi` (`ad`,`soyad`,`tc_no`,`sicil_no`,`cinsiyet`,`dogum_tarihi`,`sehir`) VALUES 
 ('Ertan','Duran','11111111111',1,'Erkek','1980-02-02','Eskisehir'),
 ('Ece','Duran','22222222222',2,'Kiz','1990-04-04','Ankara'),
 ('Nafiye','Duran','33333333333',3,'Kiz','1995-06-05','Konya'),
 ('Ahmet','Duran','44444444444',4,'Erkek','1985-10-01','Bolu'),
 ('Abdullah','Tekcan','55555555555',5,'Erkek','1993-03-23','Ankara');
/*!40000 ALTER TABLE `kisi_bilgi` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
