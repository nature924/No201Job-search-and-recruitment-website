-- --------------------------------------------------------
-- 主机:                           47.101.198.61
-- Server version:               10.3.14-MariaDB - MariaDB Server
-- Server OS:                    Linux
-- HeidiSQL 版本:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for boot_zhaopin
CREATE DATABASE IF NOT EXISTS `boot_zhaopin` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `boot_zhaopin`;

-- Dumping structure for table boot_zhaopin.apply
DROP TABLE IF EXISTS `apply`;
CREATE TABLE IF NOT EXISTS `apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `p_id` int(11) NOT NULL COMMENT '职位Id',
  `resume_id` int(11) DEFAULT NULL COMMENT '1代表在线简历，2附件简历',
  `state` int(11) DEFAULT NULL,
  `handle_user` int(11) DEFAULT NULL,
  `handle_time` date DEFAULT NULL,
  `apply_time` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='申请职位表';

-- Dumping data for table boot_zhaopin.apply: ~3 rows (approximately)
/*!40000 ALTER TABLE `apply` DISABLE KEYS */;
INSERT INTO `apply` (`id`, `user_id`, `p_id`, `resume_id`, `state`, `handle_user`, `handle_time`, `apply_time`) VALUES
	(8, 4, 3, 2, NULL, NULL, NULL, NULL),
	(9, 5, 7, 1, NULL, NULL, NULL, NULL),
	(10, 1, 2, 1, NULL, NULL, NULL, NULL),
	(11, 8, 13, 1, 0, NULL, NULL, '2020-01-11'),
	(12, 8, 6, 1, 0, NULL, NULL, '2020-01-11'),
	(13, 8, 9, 1, 3, 1, '2020-01-11', '2020-01-11'),
	(14, 8, 10, 1, 0, NULL, NULL, '2020-01-11'),
	(15, 8, 3, 2, 0, NULL, NULL, '2020-01-11');
/*!40000 ALTER TABLE `apply` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.campus
DROP TABLE IF EXISTS `campus`;
CREATE TABLE IF NOT EXISTS `campus` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `duty` text DEFAULT NULL COMMENT '在校职务',
  `award` text DEFAULT NULL COMMENT '获奖',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='获奖情况eduwork';

-- Dumping data for table boot_zhaopin.campus: ~3 rows (approximately)
/*!40000 ALTER TABLE `campus` DISABLE KEYS */;
INSERT INTO `campus` (`id`, `user_id`, `duty`, `award`, `create_time`, `update_time`) VALUES
	(1, 1, '大一担任团支书，大二担任班长', '连续三年获得奖学金，大二获得优秀学生干部', '2017-12-11 20:12:49', '2018-03-14 17:56:54'),
	(2, 5, '大一是班长，现在是党员', '大学期间都获得奖学金', '2018-03-09 23:40:23', '2018-03-09 23:40:35'),
	(3, 8, '班长', '好吃一等奖', '2020-01-11 10:06:37', '2020-01-11 10:06:37');
/*!40000 ALTER TABLE `campus` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.collection
DROP TABLE IF EXISTS `collection`;
CREATE TABLE IF NOT EXISTS `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `p_id` int(11) NOT NULL COMMENT '职位Id',
  `flag` int(11) DEFAULT NULL COMMENT '1代表社会，2代表校园',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='收藏';

-- Dumping data for table boot_zhaopin.collection: ~7 rows (approximately)
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
INSERT INTO `collection` (`id`, `user_id`, `p_id`, `flag`) VALUES
	(2, 1, 7, 1),
	(4, 1, 14, 1),
	(5, 1, 5, 1),
	(9, 1, 13, 1),
	(10, 1, 10, 1),
	(11, 5, 7, 1),
	(12, 8, 15, 1);
/*!40000 ALTER TABLE `collection` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.department
DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK_NAME` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table boot_zhaopin.department: ~0 rows (approximately)
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`id`, `name`, `create_time`, `update_time`) VALUES
	(9, '人力资源部', '2020-01-11 10:57:41', '2020-01-11 10:57:42');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.education
DROP TABLE IF EXISTS `education`;
CREATE TABLE IF NOT EXISTS `education` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `school` varchar(10) DEFAULT NULL COMMENT '毕业院校',
  `level` varchar(10) DEFAULT NULL COMMENT '学历',
  `from_time` varchar(20) DEFAULT NULL COMMENT '从---时间',
  `to_time` varchar(20) DEFAULT NULL COMMENT '到--',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='教育经历';

-- Dumping data for table boot_zhaopin.education: ~3 rows (approximately)
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` (`id`, `user_id`, `school`, `level`, `from_time`, `to_time`, `create_time`, `update_time`) VALUES
	(1, 1, '东莞理工学院', '本科', '2014-09-01', '2018-06-30', '2017-12-11 20:23:28', '2018-03-14 17:56:37'),
	(2, 5, '清华大学', '博士', '2014-09-01', '2018-06-28', '2018-03-09 23:08:30', '2018-03-09 23:09:02'),
	(3, 8, '北京大学', '硕士研究生', '2018-06-07', '2020-01-11', '2020-01-11 09:53:19', '2020-01-11 10:04:13');
/*!40000 ALTER TABLE `education` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.grade
DROP TABLE IF EXISTS `grade`;
CREATE TABLE IF NOT EXISTS `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `score` float DEFAULT NULL COMMENT '分数',
  `classify` varchar(50) DEFAULT NULL COMMENT '类型',
  `orig_quest` varchar(50) DEFAULT NULL COMMENT '初始答案',
  `score_detail` varchar(50) DEFAULT NULL COMMENT '分数详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='成绩表';

-- Dumping data for table boot_zhaopin.grade: ~3 rows (approximately)
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` (`id`, `user_id`, `score`, `classify`, `orig_quest`, `score_detail`) VALUES
	(2, 7, 9, '逻辑', NULL, NULL),
	(3, 1, 8, '技术', NULL, NULL),
	(4, 8, 0, NULL, '"{1=A, 2=A, 3=A, 4=B, 5=A, 6=B}"', '"{1=n, 2=n, 3=n, 4=n, 5=n, 6=n}"');
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.information
DROP TABLE IF EXISTS `information`;
CREATE TABLE IF NOT EXISTS `information` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `name` varchar(20) DEFAULT NULL COMMENT '用户名字',
  `sex` varchar(3) DEFAULT NULL COMMENT '性别',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `poli_status` varchar(10) DEFAULT NULL COMMENT '政治面貌',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系方式',
  `photo` varchar(100) DEFAULT NULL COMMENT '头像',
  `files` varchar(100) DEFAULT NULL COMMENT '附件文件',
  `job_intension` varchar(10) DEFAULT NULL COMMENT '求职意向',
  `describes` text DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `doubleKey` (`user_id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- Dumping data for table boot_zhaopin.information: ~5 rows (approximately)
/*!40000 ALTER TABLE `information` DISABLE KEYS */;
INSERT INTO `information` (`id`, `user_id`, `name`, `sex`, `email`, `poli_status`, `phone`, `photo`, `files`, `job_intension`, `describes`, `create_time`, `update_time`) VALUES
	(1, 1, '黄树佳', '男', '920358803@qq.com', '群众', '13631780332', '152103277906485.jpg', '152103280174019.pdf', 'JAVA开发工程师', '尚与人交通，基础知识扎实', '2017-11-27 21:28:12', '2018-03-14 21:06:26'),
	(2, 4, NULL, NULL, NULL, NULL, NULL, NULL, '151824696503372.pdf', NULL, NULL, '2018-02-10 15:16:05', '2018-02-10 15:16:05'),
	(3, 2, 'huang', '男', '920358803@qq.com', '群众', '13631780000', NULL, NULL, 'UI设计师', '为人诚实友善，好学习', '2018-03-08 22:41:08', '2018-03-08 22:41:08'),
	(6, 5, 'zhang', '男', '929358803@qq.com', '群众', '13631700000', '152107931421430.jpg', '152107930424029.pdf', '技术管理工程师', '诚实好学', '2018-03-14 23:43:56', '2018-03-15 10:06:44'),
	(7, 8, '源码码头', '男', '1357845688@qq.com', '群众', '13022502404', '157871251716850.png', '157871297191960.pdf', '开发工程师', '好吃鬼', '2020-01-11 09:52:51', '2020-01-11 10:08:25');
/*!40000 ALTER TABLE `information` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.job
DROP TABLE IF EXISTS `job`;
CREATE TABLE IF NOT EXISTS `job` (
  `name` varchar(64) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT current_timestamp(),
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK_NAME` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table boot_zhaopin.job: ~0 rows (approximately)
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
/*!40000 ALTER TABLE `job` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.positions
DROP TABLE IF EXISTS `positions`;
CREATE TABLE IF NOT EXISTS `positions` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `p_name` varchar(10) NOT NULL COMMENT '职位名称',
  `p_classify` varchar(10) DEFAULT NULL COMMENT '职位分类',
  `p_describe` text DEFAULT NULL COMMENT '描述',
  `p_responsibility` text DEFAULT NULL COMMENT '职责',
  `p_request` text DEFAULT NULL COMMENT '要求',
  `p_workSite` varchar(50) DEFAULT NULL COMMENT '工作地点',
  `p_department` varchar(20) DEFAULT NULL COMMENT '公司',
  `p_flag` int(11) DEFAULT NULL COMMENT '标志1表示社会招聘，2表示校园招聘',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `p_name` (`p_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='职位表';

-- Dumping data for table boot_zhaopin.positions: ~15 rows (approximately)
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` (`id`, `p_name`, `p_classify`, `p_describe`, `p_responsibility`, `p_request`, `p_workSite`, `p_department`, `p_flag`, `create_time`, `update_time`) VALUES
	(1, '异构计算平台架构师', '技术', '1-3年', '1. 主导计算平台异构计算领域技术规划并输出SP，完成关键技术项目Charter立项并推动落地，确保技术提前Ready;<br>\n2. 制定异构计算关键技术落地节奏，确保计算平台如SIGMA、OSCA、芯片应用等技术综合竞争力领先，支撑公司异构计算产品商业成功；<br>\n3. 拉通技术体系、结合产品业务，主导异构计算产业关键技术和算法的识别、分析、判断及技术Ready，对异构计算产业的技术准备度和长期竞争力负责。', '业务技能要求： 1、熟悉服务器、异构计算、网络，特别是云计算等新产品的业界发展趋势和关键技术，能够提炼出对异构计算关键需求并推动业务应用落地。<br>\n2、拉通技术体系、结合产品业务，主导异构计算产业关键技术和算法的识别、分析、判断及技术Ready，构建异构计算长期竞争力。<br>\n专业知识要求：<br>\n1. 计算机科学（机器学习、NLP、计算机视觉、并行计算）、统计学或应用数学博士<br>\n2. 精通计算机体系结构，精通处理器和GPU微架构；<br>\n3. 熟悉ICT行业如服务器、异构计算、网络，特别是云计算等新产品的业界发展趋势和关键技术，能够提炼出对异构计算关键需求并推动业务应用落地；<br>\n4. 在ICT行业10年以上研发工作经验，负责过云计算场景下GPU技术的规划、设计和开发，并获得市场成功；<br>\n5. 具备出色的沟通能力和项目拓展能力，较强的成就导向和团队合作意识。', '深圳', '技术部', 1, '2017-12-03 21:23:31', '2018-03-11 16:23:48'),
	(2, 'java工程师', '管理', '不限', '负责后端的开发', '1.掌握javaSe基础知识；<br>2具有面向对象的抽象思维', '深圳', '技术部', 1, '2017-12-14 19:25:51', '2017-12-14 19:25:51'),
	(3, 'java工程师', '技术', '不限', '负责后端的开发', '1.掌握javaSe基础知识；<br>2具有面向对象的抽象思维', '广州', '技术部', 2, '2017-12-14 19:25:51', '2018-01-28 22:20:26'),
	(4, '异构计算平台架构师', '技术', '博士生', '1. 主导计算平台异构计算领域技术规划并输出SP，完成关键技术项目Charter立项并推动落地，确保技术提前Ready;<br>\r\n2. 制定异构计算关键技术落地节奏，确保计算平台如SIGMA、OSCA、芯片应用等技术综合竞争力领先，支撑公司异构计算产品商业成功；<br>\r\n3. 拉通技术体系、结合产品业务，主导异构计算产业关键技术和算法的识别、分析、判断及技术Ready，对异构计算产业的技术准备度和长期竞争力负责。', '业务技能要求： 1、熟悉服务器、异构计算、网络，特别是云计算等新产品的业界发展趋势和关键技术，能够提炼出对异构计算关键需求并推动业务应用落地。<br>\r\n2、拉通技术体系、结合产品业务，主导异构计算产业关键技术和算法的识别、分析、判断及技术Ready，构建异构计算长期竞争力。<br>\r\n专业知识要求：<br>\r\n1. 计算机科学（机器学习、NLP、计算机视觉、并行计算）、统计学或应用数学博士<br>\r\n2. 精通计算机体系结构，精通处理器和GPU微架构；<br>\r\n3. 熟悉ICT行业如服务器、异构计算、网络，特别是云计算等新产品的业界发展趋势和关键技术，能够提炼出对异构计算关键需求并推动业务应用落地；<br>\r\n4. 在ICT行业10年以上研发工作经验，负责过云计算场景下GPU技术的规划、设计和开发，并获得市场成功；<br>\r\n5. 具备出色的沟通能力和项目拓展能力，较强的成就导向和团队合作意识。', '深圳', '技术部', 2, '2017-12-03 21:23:31', '2017-12-03 21:49:43'),
	(5, '软件测试工程师', '技术', '不限', '1、负责产品领域测试方案的设计，测试用例的输出，能够指导领域内测试人员开展测试活动，并给出质量评价<br>\r\n 2、负责产品领域测试能力的构建，研究领域内的先进测试方法、自动化技术，提升测试效率', '1、通信、计算机软件等相关专业，本科以上学历，英语读写、沟通良好；<br>\r\n2、了解基础网络知识； <br>\r\n3、具备3年及以上实际的软件项目测试经验； <br>\r\n4、具备良好的沟通协调能力和团队合作精神、良好的学习、动手以及解决问题的能力。', '广州', '技术部', 1, '2017-12-23 16:17:17', '2017-12-23 16:17:17'),
	(6, '软件测试工程师', '技术', '不限', '1、负责产品领域测试方案的设计，测试用例的输出，能够指导领域内测试人员开展测试活动，并给出质量评价<br>\r\n 2、负责产品领域测试能力的构建，研究领域内的先进测试方法、自动化技术，提升测试效率', '1、通信、计算机软件等相关专业，本科以上学历，英语读写、沟通良好；<br>\r\n2、了解基础网络知识； <br>\r\n3、具备3年及以上实际的软件项目测试经验； <br>\r\n4、具备良好的沟通协调能力和团队合作精神、良好的学习、动手以及解决问题的能力。', '广州', '技术部', 2, '2017-12-23 16:17:17', '2017-12-23 16:17:17'),
	(7, '技术管理工程师', '技术', '不限', '1、作为研发侧在解决方案或产品的重大项目中提供技术支持，如需求分析、答标、技术交流、方案设计和规划、外部测试等<br>\r\n2、负责对外市场技术资料写作与管理、竞争对手技术分析；<br>\r\n3、参与系统设计工作；<br>\r\n4、协助客户需求承诺管理及网上问题处理等。', '1、光学、电子、电力、通信、机械、海洋工程等相关专业，本科及以上学历；<br>\r\n2、具备1年以上相关工作经验，有光传输工作经验优先。<br>\r\n3、能够胜任频繁国际出差，具备较强的面对客户沟通和理解能力。<br>\r\n4、精通英语，可用英语为工作语言，了解另外1门外语者优先；<br>\r\n5、具备较强的学习能力和抗压力。', '深圳', '技术部', 1, '2017-12-23 16:20:03', '2017-12-23 16:20:03'),
	(8, '技术管理工程师', '技术', '不限', '1、作为研发侧在解决方案或产品的重大项目中提供技术支持，如需求分析、答标、技术交流、方案设计和规划、外部测试等<br>\r\n2、负责对外市场技术资料写作与管理、竞争对手技术分析；<br>\r\n3、参与系统设计工作；<br>\r\n4、协助客户需求承诺管理及网上问题处理等。', '1、光学、电子、电力、通信、机械、海洋工程等相关专业，本科及以上学历；<br>\r\n2、具备1年以上相关工作经验，有光传输工作经验优先。<br>\r\n3、能够胜任频繁国际出差，具备较强的面对客户沟通和理解能力。<br>\r\n4、精通英语，可用英语为工作语言，了解另外1门外语者优先；<br>\r\n5、具备较强的学习能力和抗压力。', '深圳', '技术部', 2, '2017-12-23 16:20:03', '2017-12-23 16:20:03'),
	(9, '光技术工程师', '技术', '不限', '1、负责中继产品的光学模块和子系统设计工作；<br>\r\n2、负责光器件选型和应用。', '1、光学通信类等相关专业硕士学历；<br>\r\n2、具有2年以上相关工作经验,有光放设计工作经验者优先；<br>\r\n3、深入了解光学基本原理，熟悉光元器件、工程技术和设计技术等综合知识；掌握通讯光学（光功率、OSNR、偏振、色散、OEQ、OADM等）设计方法，能够进行光学子系统设计；<br>\r\n4、具备良好的组织协调和沟通能力，团队合作意识强；<br>\r\n5、英语熟练掌握，可作为工作语言，大学英语六级以上。', '广州', '技术部', 1, '2017-12-23 16:21:52', '2017-12-23 16:21:52'),
	(10, '光技术工程师', '技术', '不限', '1、负责中继产品的光学模块和子系统设计工作；<br>\r\n2、负责光器件选型和应用。', '1、光学通信类等相关专业硕士学历；<br>\r\n2、具有2年以上相关工作经验,有光放设计工作经验者优先；<br>\r\n3、深入了解光学基本原理，熟悉光元器件、工程技术和设计技术等综合知识；掌握通讯光学（光功率、OSNR、偏振、色散、OEQ、OADM等）设计方法，能够进行光学子系统设计；<br>\r\n4、具备良好的组织协调和沟通能力，团队合作意识强；<br>\r\n5、英语熟练掌握，可作为工作语言，大学英语六级以上。', '广州', '技术部', 2, '2017-12-23 16:21:52', '2017-12-23 16:21:52'),
	(11, '资深资金经理', '管理', '3-5年', '1、负责本区域的资金风险管理，包括内部运营风险和外部遵从风险；<br>\r\n2、管理本区域的流动性、银行账户结构、权签、网上银行等保障账户资金安全；<br>\r\n3、管理本区域的资金业务相关的金融机构关系；<br>\r\n4、管理本区域的外汇风险，包括外汇管制政策解读及应用；<br>\r\n5、管理本区域的融资业务（针对允许使用融资的区域）；', '1、5年以上银行交易结算、企业资金业务、贸易融资，或担保风险量化及评估等相关企业或国际性银行工作经验<br>\r\n2、金融或财务相关专业背景<br>\r\n3、具备宏观经济学、金融学、货币银行学等金融理论基础<br>\r\n4、英语流利，熟练的英语听、说、读、写能力', '深圳', '管理部', 1, '2017-12-23 16:23:43', '2017-12-23 16:23:43'),
	(12, '渠道经理', '销售', '3-5年', '1、目标承接与管理：对分销商以及零售商的sell-in、sell-through、sell-out销售目标计划制定与达成负责；提升所辖区域终端产品的渠道覆盖率；SMR（sales management review）的推行与落地。<br>\r\n2、客户管理：和渠道伙伴制定联合的生意计划和联合营销计划；通过有效的客户PSI管理，有效监控DOS（Day of sale）走势，制定合理的要货计划；管理渠道伙伴的价格，信用、回款、返利等；建立健康的合作关系。<br>\r\n3、渠道拓展：渠道客户的选择、认证；新产品上市的渠道规划与沟通；制定客户TCO（Total Channel Offer）计划。', '业务技能要求：<br>\r\n在某个领域（行业、区域）的渠道销售、渠道策略、渠道伙伴管理、渠道销售运营等有过成功案例；<br>\r\n能够把握手机等电子终端行业的发展趋势，并制定相关的市场策略；<br>\r\n专业知识要求：<br>\r\n有移动通信终端领域知识；<br>\r\n熟悉营销领域的知识和技能；', '深圳', '销售部', 1, '2017-12-23 16:25:35', '2017-12-23 16:25:35'),
	(13, '渠道经理', '销售', '研究生', '1、目标承接与管理：对分销商以及零售商的sell-in、sell-through、sell-out销售目标计划制定与达成负责；提升所辖区域终端产品的渠道覆盖率；SMR（sales management review）的推行与落地。<br>\r\n2、客户管理：和渠道伙伴制定联合的生意计划和联合营销计划；通过有效的客户PSI管理，有效监控DOS（Day of sale）走势，制定合理的要货计划；管理渠道伙伴的价格，信用、回款、返利等；建立健康的合作关系。<br>\r\n3、渠道拓展：渠道客户的选择、认证；新产品上市的渠道规划与沟通；制定客户TCO（Total Channel Offer）计划。', '业务技能要求：<br>\r\n在某个领域（行业、区域）的渠道销售、渠道策略、渠道伙伴管理、渠道销售运营等有过成功案例；<br>\r\n能够把握手机等电子终端行业的发展趋势，并制定相关的市场策略；<br>\r\n专业知识要求：<br>\r\n有移动通信终端领域知识；<br>\r\n熟悉营销领域的知识和技能；', '深圳', '销售部', 2, '2017-12-23 16:25:35', '2017-12-23 16:25:35'),
	(14, '终端零售管理经理', '销售', '3-5年', '1.	终端门店管理：负责重点店面规划、建设与管理，含策略与作战地图，SI规范及落地，阵地规划与建设，运营管理，流程指标监管，陈列体验的设计和执行，相关费用管理；<br>\r\n2.	零售营销：负责新品上市终端管理，促销活动管理，促销品供应管理，样机管理，In store MKT，相关费用管理；<br>\r\n3.	促销人力管理：负责外包组织建设，人力规划与配置原则，考核与激励，人员销售和产能管理，人员闭环管理，零售系统运营及数据应用，相关费用管理；<br>\r\n4.	零售培训：负责内外部FF人力培训，讲师管理，课程适配与开发，培训项目管理，培训评估管理，优秀案例传播，相关费用管理。', '五年以上零售行业工作经验；<br>\r\n且必须有手机行业工作经验，在门店管理、零售营销、促销人力管理、零售培训其中1个或某几个专业领域有两年以上工作经验；<br>\r\n门店管理经验丰富的优先（门店建设、运营、SI规范形象维护）。', '深圳', '销售部', 1, '2017-12-23 16:27:21', '2017-12-23 16:27:21'),
	(15, '高级招聘专员', '人力资源', '3-5年', '作为人力资源经理和HRD与HRBP一起制定有效的招聘行动计划，在既定的时间表内填补具体的职位空缺。<br>\r\n•负责整个招聘流程，候选人寻源，筛选，谈判及入职。<br>\r\n•使用有效的沟通方式，包括主动地保持他人的信息，及时的以口头或书面的形式恰当地与候选人表达想法<br>\r\n•需求收集:设计一个切合实际的工作预览计划，收集准确、详细的职位信息和描述。负责定期与猎头进行接触，确保优质的服务和执行招聘的运作。<br>\r\n面试:在所有级别的候选人中进行电话或面对面的面试。以合法、一致的方式记录调查结果。<br>\r\n•负责解聘流程，在符合德国劳工法的情况下解聘员工的全流程<br>\r\n•报告和指标:不断更新招聘数据库，以确保候选人数据的准确性。<br>\r\n•培训管理:员工试用期管理、培训计划、能力、资格晋升等。<br>\r\n•员工关系:年度团队建设、日常关注等。', '有良好的沟通，解决问题谈判等技巧，工作经验在至少5年以上<br>\r\n硕士以上学历，懂得招聘技巧，熟知德国当地劳工法', '深圳', '人力资源部', 1, '2017-12-23 16:29:21', '2017-12-23 16:29:21');
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.project
DROP TABLE IF EXISTS `project`;
CREATE TABLE IF NOT EXISTS `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `project_name` varchar(20) DEFAULT NULL COMMENT '项目名称',
  `from_time` varchar(20) DEFAULT NULL COMMENT '从---时间',
  `to_time` varchar(20) DEFAULT NULL COMMENT '到--',
  `describes` text DEFAULT NULL COMMENT '项目描述',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='项目经验';

-- Dumping data for table boot_zhaopin.project: ~3 rows (approximately)
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` (`id`, `user_id`, `project_name`, `from_time`, `to_time`, `describes`, `create_time`, `update_time`) VALUES
	(1, 1, 'OA办公系统', '2017-02-06', '2017-03-30', '使用thymeleaf模版；\n使用Spring + Spring MVC + Spring Data JPA+ Spring Security，使用mysql', '2017-12-11 20:37:26', '2018-03-14 17:56:45'),
	(2, 5, 'hello', '2018-03-14', '2018-03-28', '使用mysql 使用ssm和maven，git', '2018-03-09 23:39:02', '2018-03-09 23:39:11'),
	(3, 8, '永动机项目', '2020-01-08', '2020-01-15', '永动机项目', '2020-01-11 10:05:49', '2020-01-11 11:24:27');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.question
DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `q_name` text DEFAULT NULL COMMENT '问题的名称',
  `q_chose` text DEFAULT NULL COMMENT '选项',
  `q_answer` varchar(5) DEFAULT NULL COMMENT '答案',
  `q_classify` varchar(10) DEFAULT NULL COMMENT '分类',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8 COMMENT='问答表';

-- Dumping data for table boot_zhaopin.question: ~73 rows (approximately)
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` (`id`, `q_name`, `q_chose`, `q_answer`, `q_classify`, `create_time`, `update_time`) VALUES
	(1, '选出下面的不同', 'A:1/3;B:1/4;C:1/5;D:3/9', 'D', '逻辑', '2017-12-05 21:37:49', '2018-03-11 16:22:20'),
	(2, '小说离不开现实生活，没有深入体验生活的人是不可能写出优秀作品的。', 'A. 诗人、小说家不可能年轻;   B. 创作小说都是老人们的事  ;  C. 要创作小说必须有足够的生活经验 ; D. 作小说要靠运气 ', 'C', '逻辑', '2017-12-05 21:37:49', '2017-12-05 22:27:55'),
	(3, '如果张未在2000年后从大学毕业，他就必须修过世界历史导论。   则这一论点是从下列哪句话中推出？()', 'A. 在2000年前，大学学习中，世界历史导论不是必修课 ;   B. 每一个选修世界历史导论的学生都是2000年以后大学毕业的 ;  C. 没有一个2000年前毕业的大学生修过世界历史导论;  D. 所有2000年后毕业的大学生都必须修世界历史导论', 'D', '逻辑', '2017-12-05 21:37:49', '2017-12-05 22:27:55'),
	(4, '下面是甲、乙、丙、丁四城市某日的天气预报：已知四城市有三种天气情况，甲市和丙市的天气相同，乙市和丁市当天没有雨。   以下推断不正确的是( )。', 'A. 甲市小雨;  B. 乙市多云;   C. 丙市晴;  D. 丁市晴', 'C', '逻辑', '2017-12-05 21:37:49', '2018-01-21 15:44:09'),
	(5, '在下列四个选择中，与其他三项意见差别最大的一项是()。', ' A.没有事物是不运动变化的 ;   B.不运动变化的事物是不存在的  ; C.凡事皆变 ; D.不运动变化的事物不是不可能的', 'D', '逻辑', '2017-12-05 21:37:49', '2017-12-05 22:27:55'),
	(6, '小董并非既懂英文又懂法语。    如果上述断定为真，那么下列哪项断定必定为真？()', 'A.小董懂英文但不懂法语  ; B.小董并懂法语但不懂英文  ; C.小董既不懂英文又不懂法语;  D.如果小董懂英文，小董一定不懂法语', 'D', '逻辑', '2017-12-05 21:37:49', '2017-12-05 22:27:55'),
	(7, '2  6 16 44 () 328', 'A.120  ; B.110  ; C.108;  D.104', 'A', '逻辑', '2017-12-05 21:37:49', '2017-12-05 22:27:55'),
	(8, '4  8 20  60 210 ()', 'A.390  ; B.840  ; C.890;  D.1024', 'B', '逻辑', '2017-12-05 21:37:49', '2017-12-05 22:27:55'),
	(9, '12  14  17 22  29 ()', 'A.31 ; B.36 ; C.40;  D.56', 'C', '逻辑', '2017-12-05 21:37:49', '2017-12-05 22:27:55'),
	(10, '某市出租车收费标准是：起步价11元，可乘3公里，3公里到5公里，每一公里1.3元，超过5公里，每公里2.4元，小张一次乘车付了37.6元，那么他乘坐多少公里', 'A.15 ; B.16 ; C.17;  D.18', 'A', '逻辑', '2017-12-05 21:37:49', '2017-12-05 22:27:55'),
	(11, '轮船顺流航行的速度24公里每小时，逆流航行速度18公里每小时，问水流的速度是？', 'A.8公里/时 ; B.3公里/时 ; C.6公里/时;  D.2公里/时', 'A', '逻辑', '2017-12-05 21:37:49', '2017-12-05 22:27:55'),
	(12, '超速：交警：处罚（）', 'A.犯规：裁判员：禁赛; B.超载：路政：卸货 ; C.故障：工程师：维修;  D.作弊：学生：重修', 'C', '逻辑', '2017-12-05 21:37:49', '2017-12-05 22:27:55'),
	(13, '画家：作家（）', 'A.工人：农民; B.土豆：山芋 ; C.绿茶：红茶;  D.军人：诗人', 'D', '逻辑', '2017-12-05 21:37:49', '2017-12-05 22:27:55'),
	(14, '-1  3  1  7  9  23 （）', 'A.25  ;B:37 ;C.39;  D.41', 'D', '逻辑', '2017-12-05 21:37:49', '2017-12-05 22:27:55'),
	(15, '0 9  26  65  124()', 'A.186;B:217 ;C.216;  D.215', 'B', '逻辑', '2017-12-05 21:37:49', '2017-12-05 22:27:55'),
	(16, '馒头：面点：食物（）', 'A.钻石：珠宝：矿物; B.香樟：木材：森林 ; C.普洱：茶具：器皿;  D.冰箱：家电：电器', 'D', '逻辑', '2017-12-05 21:37:49', '2017-12-05 22:27:55'),
	(17, '灯泡：台灯（）', 'A.手机：电话;B.水：矿泉水;C.纸张：打印机;D.木门：房间', 'D', '逻辑', '2017-12-20 17:00:00', '2017-12-20 17:00:00'),
	(18, '1  1/3  3/5  15/7  105/9 ', 'A.18 1/13 ;B:19 1/2;C:34 4/11;D:85 10/11', 'D', '逻辑', '2017-12-20 17:03:43', '2017-12-20 17:03:43'),
	(19, '0  1  3  8  22  63 ()', 'A.121 ;B:125;C:169;D:185', 'D', '逻辑', '2017-12-20 17:03:43', '2017-12-20 17:03:43'),
	(20, '“按揭”是一种以银行行为销售者和购买者媒介的分期付款方式，下面属于“按揭的是”？', 'A.小李贷款开店;B:学校贷款该教学楼;C:小李贷款买别墅;D:小张贷款付学费', 'C', '逻辑', '2017-12-20 17:03:43', '2017-12-20 17:03:43'),
	(21, '长江上游的A港与下游的S港相距270千米，以轮船以恒定速度从A港到S港需要6.75小时，返回需要9小时，如果一只漂流瓶从A港顺水漂流到S港。需要的时间是', 'A.84小时;B.50小时;C.54小时;D.81小时', 'C', '逻辑', '2017-12-25 20:59:10', '2017-12-25 20:59:12'),
	(22, '2013年是中国农历的蛇年。本世纪余下的年分里，农历是蛇年的年份有', 'A.5个;B.6个;C.7个小时;D.8个', 'C', '逻辑', '2017-12-25 20:59:10', '2017-12-25 20:59:12'),
	(23, '12  14  17 22  29 ()', 'A.31 ; B.36 ; C.40;  D.56', 'C', '逻辑', '2017-12-25 21:02:12', '2017-12-25 21:02:12'),
	(25, '选出下面的不同', 'A:1/3;B:1/4;C:1/5;D:3/9', 'D', '逻辑', '2018-01-21 14:51:14', '2018-01-21 14:51:14'),
	(26, '在Java中，负责对字节代码解释执行的是', 'A.应用服务器;B. 虚拟机;C. 垃圾回收器;D. 编译器', 'B', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(27, ' 一个栈的输入序列为1 2 3 4 5，则下列序列中不可能是栈得输出序列的是', 'A. 5 4 1 3 2;B. 2 3 4 1 5;C. 1 5 4 3 2;D. 2 3 1 4 5', 'A', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(28, '要想在你的视图上成功的执行查询需要做什么', 'A. 只能在基础表中有select权限;B. 在视图中需要有select权限;C. 基础表中必须有数据;D. 基础表必须在同一个 用户模式中', 'B', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(29, 'Oracle中VARCHAR2类型的最大长度是', 'A. 4000;B. 3000;C. 1000;D. 2000', 'A', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(30, '当客户端关闭一个从连接池中获取的连接, 会发生下面哪一种情况?', 'A. 连接不会关闭，只是简单地还给连接池;B. 连接被关闭，但又被重新打开并还给连接池;C. 连接永久性关闭', 'A', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(31, '以下哪些不是javascript的全局函数', 'A. eval;B. escape;C. setTimeout;D. parseFloat', 'C', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(32, '在UML提供的图中，（  ）用于按时间顺序描述对象间的交互', 'A. 协作图;B. 网络图;C. 序列图;D. 状态图', 'C', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(33, '在实现DAO设计模式时，下面哪种模式经常被采用：', 'A. Proxy模式;B. Factory模式;C. Prototype模式;D. Observer模式', 'B', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(34, '如果配置一个Servlet需要使用的参数，最好在哪个方法中加载', 'A. init;B. doGet;C. doPost;D. service', 'A', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(35, '类的实例方法表示的是什么？', 'A. 父类对象的行为;B. 类的属性;C. 类对象的行为;D. 类的行为', 'C', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(36, '下面说法正确的是', 'A. JAVA中线程是非抢占式的;B. JAVA中的线程不可以共享数据;C. 每个JAVA程序都至少有一个线程，即主线程;D. JAVA中的线程不可以共享代码', 'C', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(37, 'TCP协议在每次建立或拆除连接时，都要在收发双方之间交换_________ 报文', 'A. 1个;B. 2个;C. 3个;D. 4个', 'C', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(38, '网络操作系统和分布式操作系统的主要区别是', 'A. 是否连接多台计算机;B. 计算机之间能否通信;C. 网上资源能否共享;D. 各台计算机有没有主次之分', 'C', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(39, '下列描述中正确的是', 'A. 软件工程只是解决软件项目的管理问题;B. 软件工程只是解决软件开发中的技术问题;C. 软件工程的主要思想是强调在软件开发过程中需要应用工程化的原则;D. 软件工程主要解决软件产品的生产率问题', 'C', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(40, '项目中的技术风险是通常是通过（）方法来缓解的', 'A. 技术文档;B. 架构原型验证;C. 代码复审;D. 单元测试', 'C', '技术', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(41, '对组织内部人力资源供给的预测，常用的方法有：马尔可夫分析法、档案资料分 析法和', 'A.趋势分析法;B.管理者继任模型;C.德尔菲法;D.回归预测法', 'B', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(42, '某公司今年离职人员数为30，而今年在职人员的平均数为150，那么，该公司的人员变动率是', 'A.20%;B.10%;C.15%;D.25%', 'A', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(43, '当职位空缺有许多种，而且在某一特定地区内又有足够的求职者的情况下，应该使用以下哪种招募形式', 'A.报纸;B.广播电视;C.杂志;D.招募现场的宣传资料', 'B', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(44, '在人员甄选活动中，对一个人所学知识和技能的基本检测称之为', 'A.能力测试;B.人格测试;C.成就测试;D.兴趣测试', 'C', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(45, '考核绩效中最简单也最常用的工具是', 'A.图表评定法;B.交替排序法;C.配对比较法;D.强制分布法', 'A', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(46, '失业保险所属的员工福利类型是', 'A.企业福利;B.法定福利;C.生活福利;D.有偿假期', 'B', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(47, '360度考核所面临的最大难题是', 'A.信度;B.效度;C.可接受度;D.完备性', 'A', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(48, '将人的资质作为确定等级结构主要依据的薪酬模式为', 'A.计件工资制;B.绩效工资制;C.技能工资制;D.职位工资制', 'C', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(49, '目前在激励员工方面应用最普遍的员工所有权形式是', 'A.员工持股计划;B.股票期权计划;C.收益分享计划;D.利润分享计划', 'A', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(50, '成人学习的最好方式是 ', 'A.老师传授;B.老师传授为主，自学为辅;C.被动学习;D.自我学习', 'D', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(51, '人与职业相匹配理论的提出者是', 'A.斯金纳;B.巴甫洛夫;C.霍兰德;D.帕森斯', 'D', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(52, '绩效反馈最主要的方式是', 'A.绩效面谈;B.绩效辅导;C.绩效沟通;D.绩效改进', 'A', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(53, '企业文化的中心内容是', 'A.控制行为;B.尊重人;C.提高绩效;D.品牌认同', 'B', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(54, '人力资源需求预测方法中的专家判断法又称', 'A.回归分析法;B．经验预测法;C．德尔菲法;D．马尔可夫分析法', 'C', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(55, '企业对新员工上岗前进行的培训称为', 'A．培训;B．岗前培训;C．脱产培训;D．在职培训', 'B', '人力资源', '2018-03-14 14:07:45', '2018-03-14 14:07:45'),
	(56, 'Java是从（ ）语言改进重新设计', 'A．Ada;B．C++;C．Pasacal;D．BASIC', 'B', '技术', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(57, '下列语句哪一个正确', 'A.Java程序经编译后会产生machine code;B.Java程序经编译后会产生byte code;C.Java程序经编译后会产生DLL;D.以上都不正确', 'B', '技术', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(58, '提供Java存取数据库能力的包是', 'A．java.sql;B．java.awt;C．java.lang;D．java.swing', 'A', '技术', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(59, '下列运算符合法的是', 'A．&&;B．<>;C．if;D．:=', 'A', '技术', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(60, '下列说法正确的有', 'A． class中的constructor不可省略;B． constructor必须与class同名，但方法不能与class同名;C． constructor在一个对象被new时执行;D． 一个class只能定义一个constructor', 'C', '技术', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(61, '下列哪一种叙述是正确的', 'A.abstract修饰符可修饰字段、方法和类;B.抽象方法的body部分必须用一对大括号{ }包住;C.声明抽象方法，大括号可有可无;D． 声明抽象方法不可写出大括号', 'D', '技术', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(62, '下列语句正确的是', 'A． 形式参数可被视为local variable;B． 形式参数可被字段修饰符修饰;C． 形式参数为方法被调用时，真正被传递的参数;D.形式参数不可以是对象', 'C', '技术', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(63, '下面的哪个赋值语句是不对的?', 'A．float f = 11.1;B．double d = 5.3E12;C．double d = 3.14159;D．double d = 3.14D', 'A', '技术', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(64, '下面哪个是不合法的标识符?', 'A．$persons;B．TwoUsers;C．*point;D．_endline;', 'C', '技术', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(65, '若在某一个类定义中定义有如下的方法： final void aFinalFunction( )则该方法属于（）', 'A、本地方法;B、静态方法;C、最终 方法 ;D、抽象方法 ', 'C;', '技术', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(66, '在职业活动中，“选择最佳手段以实现职责最优结果，努力规避风险”，这一做法体现的职业活动内在的道德准则是', 'A. 谨慎;B. 审慎;C. 慎微;D. 慎独', 'B', '人力资源', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(67, '敬业的特征是', 'A. 主动、务实、持久;B. 遵约、守纪、爱岗;C. 加班、奉献、忠诚;D. 细致、耐心、少言', 'A', '人力资源', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(68, ' 诚信的“智慧性”是指在坚持诚信宗旨前提下，还要', 'A. 深藏不露;B. 始终言语谨慎;C. 讲究方式策略;D. 注重运用先进科技手段', 'C', '人力资源', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(69, '劳动法律体系的(　)包括工作时间和休息休假制度、工资制度、劳动安全卫生制度以及女职工和未成年特殊保护制度等', 'A. 劳动标准制度;B. 促进就业法律制度;C. 职业培训制度;D. 社会保险和福利制度', 'A', '人力资源', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(70, '短期企业唯一可变的生产要素是', 'A.生产资料;B.劳动资料;C.资本投入;D.劳动投入', 'D', '人力资源', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(71, '以下不属于劳动保障法的是', 'A.促进就业法;B.社会保险法;C.工作时间法;D.劳动福利法', 'C', '人力资源', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(72, ' 社会知觉失真的表现不包括', 'A. 蝴蝶效应;B. 光环效应;C. 投射效应;D. 对比效应', 'A', '人力资源', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(73, '(　)是将人的智力、人格、兴趣、情绪等心理特征，按一定规则表示成数字。并赋予这些数字一定解释的过程', 'A. 心理测量;B. 素质测验;C. 生理测量;D. 人事测评', 'A', '人力资源', '2018-03-15 13:59:39', '2018-03-15 13:59:39'),
	(74, ' 劳动法的立法宗旨在于', 'A. 规范企业的行为;B. 规范劳动者行为;C. 保护劳动者的合法权益;D. 规范劳动力市场', 'C', '人力资源', '2018-03-15 13:59:39', '2018-03-15 13:59:39');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.questtype
DROP TABLE IF EXISTS `questtype`;
CREATE TABLE IF NOT EXISTS `questtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK_NAME` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table boot_zhaopin.questtype: ~0 rows (approximately)
/*!40000 ALTER TABLE `questtype` DISABLE KEYS */;
INSERT INTO `questtype` (`id`, `name`, `create_time`, `update_time`) VALUES
	(9, '测试智商', '2020-01-11 10:58:12', '2020-01-11 10:58:14');
/*!40000 ALTER TABLE `questtype` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.resume
DROP TABLE IF EXISTS `resume`;
CREATE TABLE IF NOT EXISTS `resume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `position_name` varchar(20) DEFAULT NULL COMMENT '投递职位',
  `flag` int(11) DEFAULT NULL COMMENT '1表示在线简历2表示附件简历',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  `R` int(5) DEFAULT 0 COMMENT '0表示未读1表示1读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Dumping data for table boot_zhaopin.resume: ~3 rows (approximately)
/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
INSERT INTO `resume` (`id`, `user_id`, `position_name`, `flag`, `create_time`, `update_time`, `R`) VALUES
	(3, 5, '社会招-技术管理工程师', 1, '2018-03-10 10:40:30', '2018-03-10 10:40:30', 1),
	(5, 1, '社会招-java工程师', 1, '2018-03-14 21:53:12', '2018-03-14 21:53:12', 1),
	(7, 8, '校园招-渠道经理', 1, '2020-01-11 10:10:24', '2020-01-11 10:10:24', 0),
	(8, 8, '校园招-软件测试工程师', 1, '2020-01-11 10:10:38', '2020-01-11 10:10:38', 0),
	(9, 8, '社会招-光技术工程师', 1, '2020-01-11 10:10:59', '2020-01-11 10:10:59', 1),
	(10, 8, '校园招-光技术工程师', 1, '2020-01-11 11:10:32', '2020-01-11 11:10:32', 1),
	(11, 8, '校园招-java工程师', 2, '2020-01-11 11:35:59', '2020-01-11 11:35:59', 0);
/*!40000 ALTER TABLE `resume` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色Id',
  `role_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- Dumping data for table boot_zhaopin.role: ~2 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`role_id`, `role_name`) VALUES
	(1, 'user'),
	(2, 'admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.skill
DROP TABLE IF EXISTS `skill`;
CREATE TABLE IF NOT EXISTS `skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `skill_1` varchar(100) DEFAULT NULL COMMENT '技能一',
  `skill_2` varchar(100) DEFAULT NULL COMMENT '技能二',
  `skill_3` varchar(100) DEFAULT NULL COMMENT '技能三',
  `skill_4` varchar(100) DEFAULT NULL COMMENT '技能四',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='技能';

-- Dumping data for table boot_zhaopin.skill: ~3 rows (approximately)
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` (`id`, `user_id`, `skill_1`, `skill_2`, `skill_3`, `skill_4`, `create_time`, `update_time`) VALUES
	(1, 1, '熟悉JAVASE和JAVAEE', '熟悉JAVA开源框架', '熟悉mysql', '会使用git', '2017-12-11 20:44:30', '2018-03-14 17:56:49'),
	(2, 5, '很幽默', '会java', '会html', '会maven，gradle', '2018-03-09 23:39:42', '2018-03-09 23:39:54'),
	(3, 8, '好吃鬼', '好吃鬼', '好吃鬼', '好吃鬼', '2020-01-11 10:06:25', '2020-01-11 10:06:25');
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(60) NOT NULL COMMENT '密码',
  `answer1` varchar(20) NOT NULL COMMENT '答案一',
  `answer2` varchar(20) NOT NULL COMMENT '答案二',
  `flag` int(11) DEFAULT 1 COMMENT '标识符',
  `role_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- Dumping data for table boot_zhaopin.user: ~6 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `answer1`, `answer2`, `flag`, `role_id`, `create_time`, `update_time`) VALUES
	(1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '12', '12', 1, 2, '2017-11-23 22:06:17', '2017-11-23 22:06:18'),
	(2, 'huang', 'e10adc3949ba59abbe56e057f20f883e', '11', '111', 1, 1, '2017-11-23 22:45:38', '2017-12-06 22:17:41'),
	(4, '黄树佳', '96e79218965eb72c92a549dd5a330112', '111', '1111', 1, 1, '2018-02-10 15:02:06', '2018-02-10 15:02:06'),
	(5, 'zhang', 'e10adc3949ba59abbe56e057f20f883e', 'hello', '13631780332', 1, 1, '2018-03-09 21:43:41', '2018-03-09 21:48:36'),
	(7, 'hello', '827ccb0eea8a706c4c34a16891f84e7b', '123456', '123456', 1, 1, '2018-03-11 16:47:03', '2018-03-11 16:58:33'),
	(8, 'matou', 'e10adc3949ba59abbe56e057f20f883e', '123456', '13022502404', 1, 1, '2020-01-11 09:52:03', '2020-01-11 11:08:32');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table boot_zhaopin.work
DROP TABLE IF EXISTS `work`;
CREATE TABLE IF NOT EXISTS `work` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `company` varchar(20) DEFAULT NULL COMMENT '公司名称',
  `duty` varchar(10) DEFAULT NULL COMMENT '职务',
  `from_time` varchar(20) DEFAULT NULL COMMENT '从---时间',
  `to_time` varchar(20) DEFAULT NULL COMMENT '到--',
  `responsibility` text DEFAULT NULL COMMENT '职责',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='工作经历';

-- Dumping data for table boot_zhaopin.work: ~3 rows (approximately)
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
INSERT INTO `work` (`id`, `user_id`, `company`, `duty`, `from_time`, `to_time`, `responsibility`, `create_time`, `update_time`) VALUES
	(1, 1, '东莞金服', '销售', '2017-02-01', '2017-11-30', '负责公司的产品销售', '2017-12-11 20:50:24', '2018-03-14 17:56:42'),
	(2, 5, 'helloWorld', '小组长', '2018-02-27', '2018-03-29', '负责项目的需求，人员的分配,任务分配', '2018-03-09 23:09:41', '2018-03-09 23:38:37'),
	(3, 8, '华为技术有限公司', '开发工程师', '2019-12-30', '2020-01-11', '卖萌', '2020-01-11 09:53:38', '2020-01-11 10:06:44');
/*!40000 ALTER TABLE `work` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
