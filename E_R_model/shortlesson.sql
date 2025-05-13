/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50514
Source Host           : localhost:3306
Source Database       : new

Target Server Type    : MYSQL
Target Server Version : 50514
File Encoding         : 65001

Date: 2024-07-08 09:12:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminNum` varchar(20) NOT NULL,
  `adminName` varchar(10) DEFAULT NULL,
  `adminPwd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`adminNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for awardinfo
-- ----------------------------
DROP TABLE IF EXISTS `awardinfo`;
CREATE TABLE `awardinfo` (
  `compNum` varchar(20) NOT NULL,
  `teamCode` varchar(20) NOT NULL,
  `awards` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`compNum`,`teamCode`),
  KEY `FK_awardInfo2` (`teamCode`),
  CONSTRAINT `FK_awardInfo2` FOREIGN KEY (`teamCode`) REFERENCES `team` (`teamCode`),
  CONSTRAINT `FK_awardInfo` FOREIGN KEY (`compNum`) REFERENCES `competition` (`compNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of awardinfo
-- ----------------------------

-- ----------------------------
-- Table structure for coach
-- ----------------------------
DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach` (
  `teamCode` varchar(20) NOT NULL,
  `teaNum` varchar(20) NOT NULL,
  `compNum` varchar(20) NOT NULL,
  PRIMARY KEY (`teamCode`,`teaNum`,`compNum`),
  KEY `FK_coach2` (`teaNum`),
  KEY `FK_coach3` (`compNum`),
  CONSTRAINT `FK_coach3` FOREIGN KEY (`compNum`) REFERENCES `competition` (`compNum`),
  CONSTRAINT `FK_coach` FOREIGN KEY (`teamCode`) REFERENCES `team` (`teamCode`),
  CONSTRAINT `FK_coach2` FOREIGN KEY (`teaNum`) REFERENCES `teacher` (`teaNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of coach
-- ----------------------------

-- ----------------------------
-- Table structure for competition
-- ----------------------------
DROP TABLE IF EXISTS `competition`;
CREATE TABLE `competition` (
  `compNum` varchar(20) NOT NULL,
  `matchsCode` varchar(20) DEFAULT NULL,
  `organizeTime` datetime DEFAULT NULL,
  `organizeArea` varchar(50) DEFAULT NULL,
  `compName` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`compNum`),
  KEY `FK_belong` (`matchsCode`),
  CONSTRAINT `FK_belong` FOREIGN KEY (`matchsCode`) REFERENCES `matchs` (`matchsCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of competition
-- ----------------------------

-- ----------------------------
-- Table structure for matchs
-- ----------------------------
DROP TABLE IF EXISTS `matchs`;
CREATE TABLE `matchs` (
  `matchsCode` varchar(20) NOT NULL,
  `matchsName` varchar(30) DEFAULT NULL,
  `organizer` varchar(50) DEFAULT NULL,
  `contractor` varchar(50) DEFAULT NULL,
  `matchsGroup` tinyint(1) DEFAULT NULL,
  `matchsInfo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`matchsCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of matchs
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuNum` varchar(20) NOT NULL,
  `stuName` varchar(10) DEFAULT NULL,
  `stuField` varchar(20) DEFAULT NULL,
  `stuClass` varchar(20) DEFAULT NULL,
  `entryYear` int(11) DEFAULT NULL,
  `stuTel` varchar(11) DEFAULT NULL,
  `qq` varchar(10) DEFAULT NULL,
  `stumail` varchar(30) DEFAULT NULL,
  `stuPwd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`stuNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teaNum` varchar(20) NOT NULL,
  `teaName` varchar(10) DEFAULT NULL,
  `belongCollege` varchar(20) DEFAULT NULL,
  `teaTel` varchar(11) DEFAULT NULL,
  `teaemail` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`teaNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `teamCode` varchar(20) NOT NULL,
  `teamName` varchar(20) DEFAULT NULL,
  `teamNameEn` varchar(30) DEFAULT NULL,
  `creatTime` datetime DEFAULT NULL,
  `teamSize` int(11) DEFAULT NULL,
  `note` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`teamCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of team
-- ----------------------------

-- ----------------------------
-- Table structure for teammember
-- ----------------------------
DROP TABLE IF EXISTS `teammember`;
CREATE TABLE `teammember` (
  `stuNum` varchar(20) NOT NULL,
  `teamCode` varchar(20) NOT NULL,
  `leader` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`stuNum`,`teamCode`),
  KEY `FK_teamMember2` (`teamCode`),
  CONSTRAINT `FK_teamMember2` FOREIGN KEY (`teamCode`) REFERENCES `team` (`teamCode`),
  CONSTRAINT `FK_teamMember` FOREIGN KEY (`stuNum`) REFERENCES `student` (`stuNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of teammember
-- ----------------------------
