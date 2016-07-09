/*
Navicat MySQL Data Transfer

Source Server         : MariaDB-aliyun
Source Server Version : 50544
Source Host           : 121.42.197.31:3306
Source Database       : Class

Target Server Type    : MYSQL
Target Server Version : 50544
File Encoding         : 65001

Date: 2016-06-08 16:37:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Admin
-- ----------------------------
DROP TABLE IF EXISTS `Admin`;
CREATE TABLE `Admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `adminPwd` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=30000002 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of Admin
-- ----------------------------
INSERT INTO `Admin` VALUES ('30000001', 'admin', '123456');

-- ----------------------------
-- Table structure for Course
-- ----------------------------
DROP TABLE IF EXISTS `Course`;
CREATE TABLE `Course` (
  `couId` int(11) NOT NULL,
  `startTime` date NOT NULL,
  `couName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `couInfo` text COLLATE utf8_unicode_ci,
  `couTea` int(11) DEFAULT NULL,
  `couType` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `couImage` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `couStatus` int(11) DEFAULT '0',
  PRIMARY KEY (`couId`,`startTime`),
  KEY `FK_Course_couTea` (`couTea`),
  CONSTRAINT `FK_Course_couTea` FOREIGN KEY (`couTea`) REFERENCES `Teacher` (`teaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of Course
-- ----------------------------
INSERT INTO `Course` VALUES ('10000001', '2016-09-03', '计算机组成原理', '计算机组成原理', '20000001', '计算机科学', '/upload/images/course/10000001_计算机组成原理_2016-09-03.jpg', '1');
INSERT INTO `Course` VALUES ('10000002', '2016-09-04', '操作系统原理', '操作系统原理', '20000001', '计算机科学', '/upload/images/course/10000002_操作系统原理_2016-09-04.jpg', '1');
INSERT INTO `Course` VALUES ('10000003', '2016-09-05', '编译原理', '编译原理', '20000001', '计算机科学', '/upload/images/course/10000003_编译原理_2016-09-05.jpg', '1');
INSERT INTO `Course` VALUES ('10000004', '2016-09-06', 'JAVA程序设计', 'JAVA程序设计', '20000001', '计算机科学', '/upload/images/course/10000004_JAVA程序设计_2016-09-06.jpg', '1');
INSERT INTO `Course` VALUES ('10000005', '2016-09-07', '计算机组成原理', '计算机组成原理课程设计', '20000001', '计算机科学', '/upload/images/course/10000005_计算机组成原理_2016-09-07.jpg', '1');
INSERT INTO `Course` VALUES ('10000006', '2016-09-03', '.NET程序综合设计', '.NET程序综合设计课程设计', '20000001', '计算机科学', '/upload/images/course/10000006_.NET程序综合设计_2016-09-03.jpg', '1');
INSERT INTO `Course` VALUES ('10000007', '2016-09-04', '汇编语言', '汇编语言', '20000001', '计算机科学', '/upload/images/course/10000007_汇编语言_2016-09-04.jpg', '1');
INSERT INTO `Course` VALUES ('10000008', '2016-09-10', '操作系统原理', '操作系统原理课程设计', '20000001', '计算机科学', '/upload/images/course/10000008_操作系统原理_2016-09-10.jpg', '1');
INSERT INTO `Course` VALUES ('10000009', '2016-09-11', '财务管理A', '财务管理A', '20000002', '商务管理', '/upload/images/course/10000009_财务管理A_2016-09-11.jpg', '1');
INSERT INTO `Course` VALUES ('10000010', '2016-09-04', '货币银行学', '货币银行学', '20000002', '商务管理', '/upload/images/course/10000010_货币银行学_2016-09-04.jpg', '1');
INSERT INTO `Course` VALUES ('10000011', '2016-09-03', '管理专业英语', '管理专业英语', '20000002', '商务管理', '/upload/images/course/10000011_管理专业英语_2016-09-03.jpg', '1');
INSERT INTO `Course` VALUES ('10000012', '2016-09-03', '审计学原理', '审计学原理', '20000002', '商务管理', '/upload/images/course/10000012_审计学原理_2016-09-03.jpg', '1');
INSERT INTO `Course` VALUES ('10000013', '2016-09-15', '投资学', '投资学', '20000002', '商务管理', '/upload/images/course/10000013_投资学_2016-09-15.jpg', '1');
INSERT INTO `Course` VALUES ('10000014', '2016-09-16', '公共关系学', '公共关系学', '20000002', '商务管理', '/upload/images/course/10000014_公共关系学_2016-09-16.jpg', '1');
INSERT INTO `Course` VALUES ('10000015', '2016-09-17', '人员测评与招聘', '人员测评与招聘', '20000002', '商务管理', '/upload/images/course/10000015_人员测评与招聘_2016-09-17.jpg', '1');
INSERT INTO `Course` VALUES ('10000016', '2016-09-03', '劳动关系与劳动法', '劳动关系与劳动法', '20000002', '商务管理', '/upload/images/course/10000016_劳动关系与劳动法_2016-09-03.jpg', '1');
INSERT INTO `Course` VALUES ('10000017', '2016-09-04', '心理学', '心理学', '20000003', '艺术人文', '/upload/images/course/10000017_心理学_2016-09-04.jpg', '1');
INSERT INTO `Course` VALUES ('10000018', '2016-09-20', '诗词鉴赏', '诗词鉴赏', '20000003', '艺术人文', '/upload/images/course/10000018_诗词鉴赏_2016-09-20.jpg', '1');
INSERT INTO `Course` VALUES ('10000019', '2016-09-07', '论语', '论语', '20000003', '艺术人文', '/upload/images/course/10000019_论语_2016-09-07.jpg', '1');
INSERT INTO `Course` VALUES ('10000020', '2016-09-04', '对话先秦哲学', '对话先秦哲学', '20000003', '艺术人文', '/upload/images/course/10000020_对话先秦哲学_2016-09-04.jpg', '1');
INSERT INTO `Course` VALUES ('10000021', '2016-09-04', '材料物理', '材料物理', '20000004', '自然科学', '/upload/images/course/10000021_材料物理_2016-09-04.jpg', '1');
INSERT INTO `Course` VALUES ('10000022', '2016-09-24', '电动力学', '电动力学', '20000004', '自然科学', '/upload/images/course/10000022_电动力学_2016-09-24.jpg', '1');
INSERT INTO `Course` VALUES ('10000023', '2016-09-07', '量子力学', '量子力学', '20000004', '自然科学', '/upload/images/course/10000023_量子力学_2016-09-07.jpg', '1');
INSERT INTO `Course` VALUES ('10000024', '2016-09-07', '热学', '热学', '20000004', '自然科学', '/upload/images/course/10000024_热学_2016-09-07.jpg', '1');
INSERT INTO `Course` VALUES ('10000025', '2016-09-27', '光学', '光学', '20000004', '自然科学', '/upload/images/course/10000025_光学_2016-09-27.jpg', '1');
INSERT INTO `Course` VALUES ('10000026', '2016-09-28', '数学模型', '数学模型', '20000005', '数学逻辑', '/upload/images/course/10000026_数学模型_2016-09-28.jpg', '1');
INSERT INTO `Course` VALUES ('10000027', '2016-09-04', '数据分析', '数据分析', '20000005', '数学逻辑', '/upload/images/course/10000027_数据分析_2016-09-04.jpg', '1');
INSERT INTO `Course` VALUES ('10000028', '2016-09-03', '概率论与数理统计', '概率论与数理统计', '20000005', '数学逻辑', '/upload/images/course/10000028_概率论与数理统计_2016-09-03.jpg', '1');
INSERT INTO `Course` VALUES ('10000029', '2016-09-04', '复变函数', '复变函数', '20000005', '数学逻辑', '/upload/images/course/10000029_复变函数_2016-09-04.jpg', '1');
INSERT INTO `Course` VALUES ('10000030', '2016-09-07', '常微分方程', '常微分方程', '20000005', '数学逻辑', '/upload/images/course/10000030_常微分方程_2016-09-07.jpg', '1');

-- ----------------------------
-- Table structure for CourseInfo
-- ----------------------------
DROP TABLE IF EXISTS `CourseInfo`;
CREATE TABLE `CourseInfo` (
  `couId` int(11) NOT NULL DEFAULT '0',
  `startTime` date NOT NULL DEFAULT '0000-00-00',
  `userId` int(11) NOT NULL DEFAULT '0',
  `joinTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`couId`,`startTime`,`userId`),
  KEY `FK_CourseInfo_userId` (`userId`),
  KEY `FK_CourseInfo_pk` (`couId`,`startTime`) USING BTREE,
  CONSTRAINT `FK_CourseInfo_pk` FOREIGN KEY (`couId`, `startTime`) REFERENCES `Course` (`couId`, `startTime`),
  CONSTRAINT `FK_CourseInfo_userId` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of CourseInfo
-- ----------------------------
INSERT INTO `CourseInfo` VALUES ('10000001', '2016-09-03', '10000004', '2016-06-08 16:24:41');

-- ----------------------------
-- Table structure for Message
-- ----------------------------
DROP TABLE IF EXISTS `Message`;
CREATE TABLE `Message` (
  `mesId` int(11) NOT NULL AUTO_INCREMENT,
  `couId` int(11) DEFAULT NULL,
  `startTime` date DEFAULT NULL,
  `fromer` int(11) DEFAULT NULL,
  `toer` int(11) DEFAULT NULL,
  `mesInfo` text COLLATE utf8_unicode_ci,
  `smesIf` int(11) DEFAULT NULL,
  `mesType` int(11) DEFAULT NULL,
  `mesStatus` int(11) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`mesId`),
  KEY `FK_Message_fromer` (`fromer`),
  KEY `FK_Message_toer` (`toer`),
  KEY `FK_Message_pk` (`couId`,`startTime`),
  CONSTRAINT `FK_Message_fromer` FOREIGN KEY (`fromer`) REFERENCES `User` (`userId`),
  CONSTRAINT `FK_Message_pk` FOREIGN KEY (`couId`, `startTime`) REFERENCES `Course` (`couId`, `startTime`),
  CONSTRAINT `FK_Message_toer` FOREIGN KEY (`toer`) REFERENCES `User` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of Message
-- ----------------------------

-- ----------------------------
-- Table structure for Product
-- ----------------------------
DROP TABLE IF EXISTS `Product`;
CREATE TABLE `Product` (
  `proId` int(11) NOT NULL AUTO_INCREMENT,
  `couId` int(11) DEFAULT NULL,
  `proName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `proType` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `proFormat` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `proNo` int(11) DEFAULT NULL,
  `proUrl` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`proId`),
  KEY `FK_Product_couid` (`couId`),
  CONSTRAINT `FK_Product_couid` FOREIGN KEY (`couId`) REFERENCES `Course` (`couId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of Product
-- ----------------------------
INSERT INTO `Product` VALUES ('1', '10000001', '大作业', '简介', 'pdf', '1', '/upload/product/10000001_大作业_1465374504166.pdf', '2016-06-08 16:28:24');
INSERT INTO `Product` VALUES ('2', '10000001', '大作业', '内容', 'zip', '2', '/upload/product/10000001_大作业_1465374550080.zip', '2016-06-08 16:29:10');

-- ----------------------------
-- Table structure for Source
-- ----------------------------
DROP TABLE IF EXISTS `Source`;
CREATE TABLE `Source` (
  `srcId` int(11) NOT NULL AUTO_INCREMENT,
  `couId` int(11) DEFAULT NULL,
  `startTime` date DEFAULT NULL,
  `srcName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `srcType` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `srcInfo` text COLLATE utf8_unicode_ci,
  `srcFormat` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `srcNo` int(11) DEFAULT NULL,
  `srcUrl` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `uploader` int(11) DEFAULT NULL,
  `uploadTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`srcId`),
  KEY `FK_Source_uploader` (`uploader`),
  KEY `FK_Source_pk` (`couId`,`startTime`),
  CONSTRAINT `FK_Source_pk` FOREIGN KEY (`couId`, `startTime`) REFERENCES `Course` (`couId`, `startTime`),
  CONSTRAINT `FK_Source_uploader` FOREIGN KEY (`uploader`) REFERENCES `Teacher` (`teaId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of Source
-- ----------------------------
INSERT INTO `Source` VALUES ('3', '10000001', '2016-09-03', '第一课', '课件', '第一课ppt', 'ppt', '1', '/upload/source/10000001_2016-09-03_第一课_1465374345149.pdf', '20000001', '2016-06-08 16:25:53');
INSERT INTO `Source` VALUES ('4', '10000001', '2016-09-03', '第二课', '课件', '第二课', 'pptx', '2', '/upload/source/10000001_2016-09-03_第二课_1465374375125.pdf', '20000001', '2016-06-08 16:26:29');
INSERT INTO `Source` VALUES ('5', '10000001', '2016-09-03', '讲义', '讲义', '11', 'docx', '1', '/upload/source/10000001_2016-09-03_讲义_1465374449007.pdf', '20000001', '2016-06-08 16:27:31');
INSERT INTO `Source` VALUES ('6', '10000001', '2016-09-03', '444', '实验指导', '111', 'xls', '1', '/upload/source/10000001_2016-09-03_444_1465374475788.pdf', '20000001', '2016-06-08 16:27:57');

-- ----------------------------
-- Table structure for Teacher
-- ----------------------------
DROP TABLE IF EXISTS `Teacher`;
CREATE TABLE `Teacher` (
  `teaId` int(11) NOT NULL AUTO_INCREMENT,
  `teaName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `teaPwd` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `teaEmail` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `teaStatus` int(11) DEFAULT '1',
  PRIMARY KEY (`teaId`)
) ENGINE=InnoDB AUTO_INCREMENT=20000030 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of Teacher
-- ----------------------------
INSERT INTO `Teacher` VALUES ('20000001', '师金荷', '123456', 'li1@163.com', '1');
INSERT INTO `Teacher` VALUES ('20000002', '钱文玲', '123456', 'li2@163.com', '1');
INSERT INTO `Teacher` VALUES ('20000003', '杨柳村', '123456', 'li3@163.com', '1');
INSERT INTO `Teacher` VALUES ('20000004', '杨皓', '123456', 'li1@164.com', '1');
INSERT INTO `Teacher` VALUES ('20000005', '李俊毅', '123456', 'li2@164.com', '1');
INSERT INTO `Teacher` VALUES ('20000006', '余元其', '123456', 'li3@164.com', '1');
INSERT INTO `Teacher` VALUES ('20000007', '于根', '123456', 'li1@165.com', '1');
INSERT INTO `Teacher` VALUES ('20000008', '黄宋杰', '123456', 'li2@165.com', '1');
INSERT INTO `Teacher` VALUES ('20000009', '陆振宁', '123456', 'li3@165.com', '1');
INSERT INTO `Teacher` VALUES ('20000010', '蔡鼎业', '123456', 'li1@166.com', '1');
INSERT INTO `Teacher` VALUES ('20000011', '张月娇', '123456', 'li2@166.com', '1');
INSERT INTO `Teacher` VALUES ('20000012', '章国文', '123456', 'li3@166.com', '1');
INSERT INTO `Teacher` VALUES ('20000013', '杨青宝', '123456', 'li1@167.com', '1');
INSERT INTO `Teacher` VALUES ('20000014', '昝雨露', '123456', 'li2@167.com', '1');
INSERT INTO `Teacher` VALUES ('20000015', '陆凌杰', '123456', 'li3@167.com', '1');
INSERT INTO `Teacher` VALUES ('20000016', '周奇', '123456', 'li1@168.com', '1');
INSERT INTO `Teacher` VALUES ('20000017', '王剑', '123456', 'li2@168.com', '1');
INSERT INTO `Teacher` VALUES ('20000018', '张庆伍', '123456', 'li3@168.com', '1');
INSERT INTO `Teacher` VALUES ('20000019', '王帆', '123456', 'li1@169.com', '1');
INSERT INTO `Teacher` VALUES ('20000020', '王喆文', '123456', 'li2@169.com', '1');
INSERT INTO `Teacher` VALUES ('20000021', '陈志豪', '123456', 'li3@169.com', '1');
INSERT INTO `Teacher` VALUES ('20000022', '陈龙龙', '123456', 'li1@170.com', '1');
INSERT INTO `Teacher` VALUES ('20000023', '谢天祥', '123456', 'li2@170.com', '1');
INSERT INTO `Teacher` VALUES ('20000024', '刘航', '123456', 'li3@170.com', '1');
INSERT INTO `Teacher` VALUES ('20000025', '姚诗忆', '123456', 'li1@171.com', '1');
INSERT INTO `Teacher` VALUES ('20000026', '华尧', '123456', 'li2@171.com', '1');
INSERT INTO `Teacher` VALUES ('20000027', '马慧萍', '123456', 'li3@171.com', '1');
INSERT INTO `Teacher` VALUES ('20000028', '陈铭豪', '123456', 'li1@172.com', '1');
INSERT INTO `Teacher` VALUES ('20000029', '陈莹羚', '123456', 'li2@172.com', '1');

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `userPwd` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `userEmail` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `userImage` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `userStatus` int(11) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=10000005 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of User
-- ----------------------------
INSERT INTO `User` VALUES ('10000003', 'bbb', '123456', 'bbb@163.com', null, '0', '2016-06-08 16:21:20');
INSERT INTO `User` VALUES ('10000004', 'hhk', '123456', 'hhk@163.com', null, '1', '2016-06-08 16:22:05');

-- ----------------------------
-- Table structure for WorkInfo
-- ----------------------------
DROP TABLE IF EXISTS `WorkInfo`;
CREATE TABLE `WorkInfo` (
  `workId` int(11) NOT NULL DEFAULT '0',
  `couId` int(11) NOT NULL DEFAULT '0',
  `startTime` date NOT NULL DEFAULT '0000-00-00',
  `usrId` int(11) NOT NULL DEFAULT '0',
  `workName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `workUrl` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `workStatus` int(11) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`workId`,`couId`,`startTime`,`usrId`),
  KEY `FK_WorkInfo_usrId` (`usrId`),
  KEY `FK_WorkInfo_pk` (`couId`,`startTime`),
  CONSTRAINT `FK_WorkInfo_pk` FOREIGN KEY (`couId`, `startTime`) REFERENCES `Course` (`couId`, `startTime`),
  CONSTRAINT `FK_WorkInfo_usrId` FOREIGN KEY (`usrId`) REFERENCES `User` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of WorkInfo
-- ----------------------------
INSERT INTO `WorkInfo` VALUES ('1465374421', '10000001', '2016-09-03', '10000004', '1', '/upload/homework/10000001_2016-09-03_1_1465374421.pdf', '1', '2016-06-08 16:27:01');
