/*
Navicat MySQL Data Transfer

Source Server         : mysql_36
Source Server Version : 50536
Source Host           : localhost:3307
Source Database       : muke

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2017-06-23 10:40:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `answer_id` varchar(8) NOT NULL,
  `answer_content` varchar(45) DEFAULT NULL,
  `answer_question` varchar(8) NOT NULL,
  `answer_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `answer_question` (`answer_question`),
  CONSTRAINT `answer_question` FOREIGN KEY (`answer_question`) REFERENCES `question` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('1', '求带HADOOP入门', '1', '孔令囡');
INSERT INTO `answer` VALUES ('2', '求带JS入门', '1', '何倩荣');
INSERT INTO `answer` VALUES ('3', '真难。。。', '2', '王思月');
INSERT INTO `answer` VALUES ('4', '不错！', '1', '赵虹');
INSERT INTO `answer` VALUES ('5', '可以的，', '2', '杨廷良');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` varchar(20) NOT NULL,
  `course_name` varchar(45) DEFAULT NULL,
  `course_rank` varchar(45) DEFAULT NULL,
  `course_direction` varchar(45) DEFAULT NULL,
  `course_description` varchar(45) DEFAULT NULL,
  `course_classification` varchar(45) DEFAULT NULL,
  `course_studyTime` varchar(45) DEFAULT NULL,
  `course_progress` varchar(45) DEFAULT NULL,
  `course_studyNum` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('100', 'Python开发环境搭建', '初级', '后端开发', '带你搭建python开发环境', 'Python', '7小时05分', '更新完毕', '131110');
INSERT INTO `course` VALUES ('101', 'Python操作MySQL数据库', '中级', '后端开发', '本视频教程讲解python如何开发', 'Python', '8小时06分', '更新完毕', '135220');
INSERT INTO `course` VALUES ('102', 'Pytho文件处理', '中级', '后端开发', 'python文件操作指南，掌握对文件目录的处理', 'Python', '8小时10分', '持续更新', '131110');
INSERT INTO `course` VALUES ('103', '初识机器学习—理论篇', '初级', '后端开发', '带你认识机器学习，一些经典的算法', 'Python', '6小时50分', '持续更新', '135220');
INSERT INTO `course` VALUES ('104', 'python正则表达式', '中级', '后端开发', '如何使用正则处理文本，带你全面了解', 'Python', '7小时05分', '更新完毕', '131110');
INSERT INTO `course` VALUES ('105', 'c语言入门', '初级', '后端开发', 'c语言入门视频教程，带你进入编程必修课', 'c', '4小时20分', '持续更新', '246439');
INSERT INTO `course` VALUES ('106', 'Linux C语言编程基本原理与实践', '中级', '后端开发', '本视频教程介绍c语言基本工作原理以及使用与c的实际开发', 'c', '6小时45分', '持续更新', '112322');
INSERT INTO `course` VALUES ('107', 'Linux C语言结构体', '中级', '后端开发', 'c语言的深入，帮助小伙伴们进一步的理解c语言', 'c', '7小时10分', '持续更新', '124571');
INSERT INTO `course` VALUES ('108', 'Linux C语言指针与内存', '中级', '后端开发', '指针-c语言的核心，带领大家对c语言有更深理解', 'c', '7小时05分', '更新完毕', '124571');
INSERT INTO `course` VALUES ('109', 'c++远征之起航篇', '初级', '后端开发', 'c++亮点尽在其中，是c语言的延伸', 'c++', '6小时50分', '持续更新', '124571');
INSERT INTO `course` VALUES ('110', 'c++远征之离港篇', '初级', '后端开发', 'c++扫清通往面向对象的最后一道障碍', 'c++', '5小时10分', '持续更新', '124571');
INSERT INTO `course` VALUES ('111', '数据结构探险—队列篇', '初级', '后端开发', '与现实最为贴近的数据结构', 'c++', '7小时05分', '更新完毕', '124571');
INSERT INTO `course` VALUES ('112', 'c++远征之模版篇', '初级', '后端开发', '本c++教程力求即学即会，所有知识以实践方式讲解', 'c++', '6小时50分', '更新完毕', '124571');
INSERT INTO `course` VALUES ('113', 'c++远征之封装篇（上）', '初级', '后端开发', '封装面向对象的基石，本教程力求帮助到小伙伴', 'c++', '6小时05分', '持续更新', '124571');
INSERT INTO `course` VALUES ('114', 'Cocos2d-x游戏开发初体验-C++篇', '初级', '后端开发', 'Cocos2d-x开发手机游戏够轻量、够简单，你还不来学', 'c++', '7小时10分', '更新完毕', '124571');
INSERT INTO `course` VALUES ('115', 'C++远征之继承篇', '初级', '后端开发', '\'继承，C++面向对象三大特征之一，通过编码实践方式讲解到操作层面', 'c++', '5小时45分', '持续更新', '124571');
INSERT INTO `course` VALUES ('116', 'C++远征之封装篇（下）', '初级', '后端开发', '封装--面向对象三大特征之一，通过案例让C++所学知识融会贯通', 'c++', '8小时05分', '更新完毕', '124571');
INSERT INTO `course` VALUES ('117', 'Go语音第一课', '初级', '后端开发', 'Go语言入门教程，编程之必备知识扩散', 'Go', '5小时45分', '持续更新', '124571');
INSERT INTO `course` VALUES ('118', 'Gopher China 2015 上海大会', '高级', '后端开发', 'go干货尽在GopherChina2015上海大会，干活太多', 'Go', '7小时20分', '持续更新', '124571');
INSERT INTO `course` VALUES ('119', 'Golang之IO操作初接触', '初级', '后端开发', '掌握Golang操作，游走二进制领域', 'Go', '6小时15分', '更新完毕', '124571');
INSERT INTO `course` VALUES ('120', 'Golang之文本编码处理', '初级', '后端开发', '掌握对Golang语言中文本编码处理的应用', 'Go', '7小时40分', '持续更新', '124571');
INSERT INTO `course` VALUES ('121', 'c#开发轻松入门', '初级', '后端开发', '本门课程是c#语言的入门课程，将带你轻松入门NET开发', 'c#', '5小时35分', '更新完毕', '124571');
INSERT INTO `course` VALUES ('122', '用c#实现封装', '初级', '后端开发', 'c#视频教程教大家，用c#语言实现面向对象的封装', 'c#', '7小时05分', '持续更新', '124571');
INSERT INTO `course` VALUES ('123', 'c#面向对象编程', '初级', '后端开发', '本系列教程主要是，带你学习c#面向对象编程的思想', 'c#', '6小时25分', '持续更新', '124571');
INSERT INTO `course` VALUES ('124', 'Ruby语言快速入门', '初级', '后端开发', 'Ruby基础入门教程，让十一年老兵带你走进ruby入门', 'Ruby', '8小时05分', '持续更新', '124571');
INSERT INTO `course` VALUES ('125', 'Android开发视频教程', '初级', '移动开发', 'Android攻城狮的第一门课', 'Android', '4小时20分', '更新完毕', '3244326');
INSERT INTO `course` VALUES ('126', '玩转Android基础课堂', '中级', '移动开发', 'Android攻城狮的第二门课', 'Android', '4小时20分', '更新完毕', '524356');
INSERT INTO `course` VALUES ('127', 'Android深入浅出', '高级', '移动开发', 'Android深入浅出带你掌握和开发控件', 'Android', '10小时20分', '更新完毕', '463763');
INSERT INTO `course` VALUES ('128', 'Android的UI模板设计', '中级', '移动开发', '如何在Android自定义view', 'Android', '6小时40分', '更新完毕', '426345');
INSERT INTO `course` VALUES ('129', 'Android效率开发框架', '高级', '移动开发', 'Android开发框架，敏捷开发必备', 'Android', '4小时20分', '更新完毕', '7433643');
INSERT INTO `course` VALUES ('130', 'Android微信6.0', '高级', '移动开发', 'Android攻城狮的第一门课', 'Android', '11小时15分', '更新完毕', '324657');
INSERT INTO `course` VALUES ('131', 'Android QQ登录', '中级', '移动开发', 'Android应用快速实现登录功能', 'Android', '4小时20分', '更新完毕', '864763');
INSERT INTO `course` VALUES ('132', 'Android面试常客handler详解', '高级', '移动开发', 'Android必学的handler，是面试常客哦', 'Android', '11小时20分', '更新完毕', '537435');
INSERT INTO `course` VALUES ('133', 'IOS逆向与安全', '高级', '移动开发', '学习iOS的逆向与安全知识', 'IOS', '11小时20分', '更新完毕', '132534');
INSERT INTO `course` VALUES ('134', 'IOS开发全套教程', '高级', '移动开发', '学了这个你就一只脚迈入大门了', 'IOS', '15小时45分', '更新完毕', '353667');
INSERT INTO `course` VALUES ('135', '0基础iOS开发', '初级', '移动开发', 'iOS的0基础APP开发', 'IOS', '4小时20分', '更新完毕', '253657');
INSERT INTO `course` VALUES ('136', 'IOS教程编程语言学习', '中级', '移动开发', 'swift编程语言的学\n\n习', 'IOS', '6小时20分', '更新完毕', '462374');
INSERT INTO `course` VALUES ('137', 'IOS从入门到精通', '高级', '移动开发', 'xcode和swift3的学习', 'IOS', '9\n\n小时45分', '更新完毕', '426348');
INSERT INTO `course` VALUES ('138', 'IOS打造直播APP', '高级', '移动开发', '花椒直播APP不是梦', 'IOS', '12小\n\n时10分', '更新完毕', '2465478');
INSERT INTO `course` VALUES ('139', 'IOS UI开发视频第一季', '中级', '移动开发', 'UI设计师的第一步', 'IOS', '6小时20分', '更新完毕', '2463647');
INSERT INTO `course` VALUES ('140', '玩转IOS开发教程', '高级', '移动开发', 'iOS一点都不难', 'IOS', '13小时15分', '更新完毕', '1264784');
INSERT INTO `course` VALUES ('161', '与MySQL的零距离接触', '初级', '数据处理', '全部MySQL数据库的基础', 'MySQL', '7小时30分', '更新完毕', '324234');
INSERT INTO `course` VALUES ('162', 'MySQL开发技巧(一)', '高级', '数据处理', 'SQL技巧是一个好程序员的必备技能', 'MySQL', '4小时20分', '更新完毕', '897298');
INSERT INTO `course` VALUES ('163', '数据库设计那些事', '高级', '数据处理', '本课程教你设计简洁高效又稳定的数据库结构', 'MySQL', '5小时20分', '更新完毕', '456736');
INSERT INTO `course` VALUES ('164', '性能优化之MySQL优化', '高级', '数据处理', '了解MySQL数据库优化的方法和技巧', 'MySQL', '3小时40分', '更新完毕', '654231');
INSERT INTO `course` VALUES ('165', 'MySQL开发技巧(二)', '高级', '数据处理', '通过本课程能够学会更多操作', 'MySQL', '6小时35分', '更新完毕', '363448');
INSERT INTO `course` VALUES ('166', 'MySQL开发技巧(三)', '高级', '数据处理', '懂SQL技巧的程序员才是好程序员', 'MySQL', '8小时20分', '更新完毕', '864352');
INSERT INTO `course` VALUES ('167', 'MySQL5.7版本新特性', '高级', '数据处理', '本课程从四个方面带你了解MySQL5.7新特性', 'MySQL', '9小时45分', '更新完毕', '381356');
INSERT INTO `course` VALUES ('168', '2015 Oracle技术嘉年华', '高级', '数据处理', '2015 Oracle嘉年华尽在慕课网', 'MySQL', '8小时10分', '持续更新', '646778');
INSERT INTO `course` VALUES ('169', 'MongoDB基础入门', '初级', '数据处理', 'MongoDB轻松入门', 'MongoDB', '2小时20分', '更新完毕', '234545');
INSERT INTO `course` VALUES ('170', 'MongoDB零基础教程', '初级', '数据处理', '最全的MongoDB基础教程', 'MongoDB', '7小时55分', '更新完毕', '326894');
INSERT INTO `course` VALUES ('171', 'MongoDB那些事儿', '中级', '数据处理', '与MongoDB零距离接触', 'MongoDB', '4小时35分', '更新完毕', '873543');
INSERT INTO `course` VALUES ('172', '与MongoDB的零距离接触', '初级', '数据处理', '快速掌握MongoDB', 'MongoDB', '4小时33分', '更新完毕', '374374');
INSERT INTO `course` VALUES ('173', 'MongoDB零基础到精通之路', '高级', '数据处理', '本课程带你学通MongoDB', 'MongoDB', '7小时44分', '更新完毕', '675343');
INSERT INTO `course` VALUES ('174', 'MongoDB实战技能', '中级', '数据处理', '实战技能宝典', 'MongoDB', '9小时22分', '持续更新', '745643');
INSERT INTO `course` VALUES ('175', 'MongoDB经典案例', '高级', '数据处理', '案例体现MongoDB精髓', 'MongoDB', '5小时46分', '更新完毕', '464327');
INSERT INTO `course` VALUES ('176', 'MongoDB培训教程', '中级', '数据处理', '全部MongoDB的知识', 'MongoDB', '3小时43分', '更新完毕', '375413');
INSERT INTO `course` VALUES ('177', 'Oracle数据库开发必备利器之SQL基础', '初级', '数据处理', '为你带来Oracle开发必备的sql基础', 'Oracle', '9小时33分', '更新完毕', '687643');
INSERT INTO `course` VALUES ('178', 'Oracle数据库开发必备利器之PL/SQL基础', '中级', '数据处理', 'Oracle数据库高级开发必备的基础', 'Oracle', '2小时44分', '更新完毕', '348345');
INSERT INTO `course` VALUES ('179', 'Oracle高级查询', '中级', '数据处理', '数据库开发中应用广泛的高级查询', 'Oracle', '5小时35分', '更新完毕', '675433');
INSERT INTO `course` VALUES ('180', 'Oracle存储过程和自定义函数', '中级', '数据处理', 'Java开发重要课程，Oracle数据库开发工程师的加薪利器', 'Oracle', '4小时43分', '更新完毕', '637576');
INSERT INTO `course` VALUES ('181', '2015 Oracle技术嘉年华', '高级', '数据处理', '尽情享用技术盛宴', 'Oracle', '6小时21分', '更新完毕', '634867');
INSERT INTO `course` VALUES ('182', 'Oracle触发器', '中级', '数据处理', '教程涉及4个案例讲解触发器的应用', 'Oracle', '4小时31分', '更新完毕', '346575');
INSERT INTO `course` VALUES ('183', 'Oracle数据库开发利器之函数', '中级', '数据处理', '常用函数应用以及这些函数如何在查询中应用', 'Oracle', '8小时33分', '更新完毕', '456185');
INSERT INTO `course` VALUES ('184', 'Oracle 12c在OEL6上的安装', '中级', '数据处理', 'Oracle DBA成长第一门课', 'Oracle', '9小时45分', '持续更新', '721345');
INSERT INTO `course` VALUES ('185', 'SQL/Server数据库开发', '中级', '数据处理', 'SQL/Server轻松入门', 'SQL Server', '9小时45分', '持续更新', '348645');
INSERT INTO `course` VALUES ('186', 'SQL Server2005数据库', '初级', '数据处理', '探索SQL Server2005的奥秘', 'SQL Server', '6小时36分', '更新完毕', '897844');
INSERT INTO `course` VALUES ('187', 'SQL2005入门到精通', '高级', '数据处理', 'SQL2005全套知识', 'SQL Server', '4小时12分', '更新完毕', '257765');
INSERT INTO `course` VALUES ('188', 'SQL Server2014核心篇', '初级', '数据处理', 'SQL2014那些事儿', 'SQL Server', '5小时23分', '持续更新', '468777');
INSERT INTO `course` VALUES ('189', 'SQL Server基础入门', '初级', '数据处理', '带你轻松入门', 'SQL Server', '2小时41分', '更新完毕', '287652');
INSERT INTO `course` VALUES ('190', 'SQL Server2012数据库管理与开发', '中级', '数据处理', '数据库管理与开发全解', 'SQL Server', '3小时40分', '更新完毕', '546544');
INSERT INTO `course` VALUES ('191', 'SQL Server2014索引和游标', '中级', '数据处理', '索引和游标全解', 'SQL Server', '5小时15分', '更新完毕', '376874');
INSERT INTO `course` VALUES ('192', 'SQL Server2014函数和事务', '中级', '数据处理', '函数与事务解析', 'SQL Server', '4小时45分', '更新完毕', '987566');
INSERT INTO `course` VALUES ('193', 'PS教程合辑', '高级', '图像处理', 'PS最全的知识都在这\n\n里', 'Photoshop', '4小时11分', '更新完毕', '767654');
INSERT INTO `course` VALUES ('194', 'PS高手炼成记', '高级', '图像处理', '想成为PS高手的看过\n\n来', 'Photoshop', '4小时31分', '更新完毕', '657897');
INSERT INTO `course` VALUES ('195', '《和文牛一起学PS》', '初级', '图像处理', '快来学PS技术\n\n吧', 'Photoshop', '2小时55分', '更新完毕', '387863');
INSERT INTO `course` VALUES ('196', '建筑家装4部曲', '中级', '图像处理', '建筑家装4部曲【全集】附素\n\n材', 'Photoshop', '3小时45分', '持续更新', '987984');
INSERT INTO `course` VALUES ('197', 'PS教程-Photoshop软件精修', '高级', '图像处理', '提升你的PS技\n\n术', 'Photoshop', '5小时20分', '更新完毕', '321733');
INSERT INTO `course` VALUES ('198', 'UI设计7部曲', '中级', '图像处理', 'UI设计7部曲（全系列合\n\n集）', 'Photoshop', '6小时42分', '更新完毕', '575864');
INSERT INTO `course` VALUES ('199', 'CS5 CS6 CC零基础', '初级', '图像处理', '带你通关CS5 CS6 \n\nCC', 'Photoshop', '3小时33分', '更新完毕', '678764');
INSERT INTO `course` VALUES ('200', 'Photoshop平面设计教程', '中级', '图像处理', '快来学习Photoshop平面设\n\n计教程', 'Photoshop', '1小时43分', '持续更新', '423198');
INSERT INTO `course` VALUES ('201', '和文牛一起学AI', '初级', '图像处理', '快来学习AI吧', 'lllustrator', '1\n\n小时21分', '更新完毕', '345634');
INSERT INTO `course` VALUES ('202', 'illustrator快速入门', '初级', '图像处理', 'illustrator入门基\n\n础', 'lllustrator', '2小时43分', '更新完毕', '357435');
INSERT INTO `course` VALUES ('203', 'illustrator零基础到精通之路', '高级', '图像处理', '最全的illustrator\n\n知识都在这里', 'lllustrator', '4小时22分', '更新完毕', '745634');
INSERT INTO `course` VALUES ('204', 'illustrator终极技能实战', '高级', '图像处理', '带你实战带你\n\n飞', 'lllustrator', '3小时44分', '更新完毕', '345467');
INSERT INTO `course` VALUES ('205', 'oeasy教你玩ai illustrator', '中级', '图像处理', '想学习ai \n\nillustrator吗', 'lllustrator', '4小时33分', '更新完毕', '657446');
INSERT INTO `course` VALUES ('206', 'illustrator教程', '中级', '图像处理', 'illustrator基础教\n\n程', 'lllustrator', '1小时45分', '更新完毕', '676876');
INSERT INTO `course` VALUES ('207', '平面设计精品案例', '高级', '图像处理', '通过案例学习\n\nillustrator', 'lllustrator', '2小时24分', '更新完毕', '876766');
INSERT INTO `course` VALUES ('208', 'illustrator CC从入门到精通', '高级', '图像处理', 'illustrator最系统\n\n讲解', 'lllustrator', '1小时46分', '更新完毕', '897466');
INSERT INTO `course` VALUES ('209', '零基础影视合成与特效', '初级', '图像处理', '合成与特效入门', 'After \n\nEffects', '1小时26分', '持续更新', '367684');
INSERT INTO `course` VALUES ('210', '终极合成技术大师篇', '高级', '图像处理', '快来学习合成技术吧', 'After \n\nEffects', '2小时46分', '更新完毕', '687564');
INSERT INTO `course` VALUES ('211', '影视后期AE与PR综合特效与剪辑技巧', '中级', '图像处理', '带给你最全的\n\n合成技巧', 'After Effects', '1小时43分', '更新完毕', '327567');
INSERT INTO `course` VALUES ('212', 'UI设计', '初级', '图像处理', 'UI设计基础', 'After Effects', '2小时13分\n\n', '更新完毕', '676845');
INSERT INTO `course` VALUES ('213', 'AE CC2017运动图形MG动画训练', '中级', '图像处理', '探索MG动画训练的奥\n\n秘', 'After Effects', '2小时33分', '更新完毕', '637564');
INSERT INTO `course` VALUES ('214', '必备调色技巧', '中级', '图像处理', '想让你的调色技巧更高一筹\n\n么', 'After Effects', '1小时22分', '更新完毕', '646544');
INSERT INTO `course` VALUES ('215', 'AE制作MAD/AMV中常见过场效果', '中级', '图像处理', '快来设计你的过场效\n\n果', 'After Effects', '2小时47分', '更新完毕', '434244');
INSERT INTO `course` VALUES ('216', '特效研究所', '高级', '图像处理', '特效天才们的盛宴', 'After \n\nEffects', '1小时28分', '更新完毕', '732413');
INSERT INTO `course` VALUES ('217', '《和文牛一起学CDR》', '初级', '图像处理', '快来学习CDR\n\n吧', 'CorelDRAW', '1小时22分', '更新完毕', '463132');
INSERT INTO `course` VALUES ('218', '全套CDR基础入门教程', '初级', '图像处理', '这里有全套的CDR教\n\n程', 'CorelDRAW', '2小时28分', '更新完毕', '324733');
INSERT INTO `course` VALUES ('219', 'CorelDRAW X6基础到精通', '高级', '图像处理', 'CorelDRAW基础入门教\n\n程', 'CorelDRAW', '3小时40分', '更新完毕', '413654');
INSERT INTO `course` VALUES ('220', '《和文牛一起学图文设计》', '中级', '图像处理', '和文牛一起学习图文设计\n\n', 'CorelDRAW', '1小时32分', '更新完毕', '635453');
INSERT INTO `course` VALUES ('221', 'CDR企业VI设计精品教程', '高级', '图像处理', '快来让你的CDR技术更上一\n\n层楼', 'CorelDRAW', '2小时29分', '持续更新', '674652');
INSERT INTO `course` VALUES ('222', 'CorelDRAW X7基础入门到精通', '高级', '图像处理', '最全套的CorelDRAW\n\n技术都在这里', 'CorelDRAW', '1小时42分', '更新完毕', '654563');
INSERT INTO `course` VALUES ('223', '图文学习CDR', '中级', '图像处理', '有图、有文还怕你学不会\n\n么', 'CorelDRAW', '1小时35分', '更新完毕', '634132');
INSERT INTO `course` VALUES ('224', 'CorelDRAW培训教程', '中级', '图像处理', 'CorelDRAW培训教程开始\n\n啦', 'CorelDRAW', '2小时15分', '更新完毕', '354566');
INSERT INTO `course` VALUES ('225', '三维动画技术基础', '初级', '图像处理', '3D技术基础入门', '3DMAX', '1小\n\n时30分', '持续更新', '345466');
INSERT INTO `course` VALUES ('226', '3Dmax全景效果图', '中级', '图像处理', '一起来体验3D全景效\n\n果', '3DMAX', '2小时16分', '更新完毕', '642327');
INSERT INTO `course` VALUES ('227', '3dsmax建模', '中级', '图像处理', '一起来学习3dsmax建模吧', '3DMAX', '1\n\n小时40分', '更新完毕', '657641');
INSERT INTO `course` VALUES ('228', '全套3DMAX基础教程', '高级', '图像处理', '最全套的3D教程都在这\n\n里', '3DMAX', '2小时23分', '更新完毕', '322546');
INSERT INTO `course` VALUES ('229', '小亮老师讲解3DS Max', '中级', '图像处理', '看小亮老师如何讲解\n\n3DS', '3DMAX', '1小时46分', '更新完毕', '544642');
INSERT INTO `course` VALUES ('230', '3DMax2013基础入门篇', '初级', '图像处理', '这里有最全的3DMax基础入门\n\n知识', '3DMAX', '1小时51分', '持续更新', '345432');
INSERT INTO `course` VALUES ('231', '3ds Max软件基础', '初级', '图像处理', '带你学习3ds Max软件基础那些事\n\n儿', '3DMAX', '2小时18分', '更新完毕', '744352');
INSERT INTO `course` VALUES ('232', '3dsmax的实用小技巧', '中级', '图像处理', '快来看看3dsmax的实例\n\n吧', '3DMAX', '1小时38分', '更新完毕', '353123');
INSERT INTO `course` VALUES ('233', 'AutoCAD2014快速入门精品自学教程', '中级', '图像处理', 'AutoCAD精品入\n\n门自学教程', 'AutoCAD', '1小时30分', '持续更新', '465612');
INSERT INTO `course` VALUES ('234', 'CAD图纸设计', '中级', '图像处理', '快来开始你的图纸设计之\n\n旅', 'AutoCAD', '2小时21分', '更新完毕', '335433');
INSERT INTO `course` VALUES ('235', 'AutoCAD二维制图轻量化教程', '中级', '图像处理', 'AutoCAD二维制图轻量\n\n化教程让你爱不释手', 'AutoCAD', '1小时19分', '更新完毕', '245321');
INSERT INTO `course` VALUES ('236', 'AutoCAD免费教程', '初级', '图像处理', '免费教程带你体验\n\nAutoCAD', 'AutoCAD', '1小时27分', '持续更新', '135452');
INSERT INTO `course` VALUES ('237', '全套CAD基础入门教程', '初级', '图像处理', '最全的CAD知识都在这里\n\n啦', 'AutoCAD', '2小时22分', '持续更新', '246543');
INSERT INTO `course` VALUES ('238', 'CAD零基础教程', '初级', '图像处理', '从零开始，收获更\n\n多！', 'AutoCAD', '1小时37分', '更新完毕', '245231');
INSERT INTO `course` VALUES ('239', 'AutoCAD精品案例制作教程', '高级', '图像处理', '从小案例看大智\n\n慧', 'AutoCAD', '1小时43分', '更新完毕', '134455');
INSERT INTO `course` VALUES ('240', 'CAD常用工具简易教程', '中级', '图像处理', '本课程带你开始自己的CAD之\n\n旅', 'AutoCAD', '1小时13分', '持续更新', '134324');
INSERT INTO `course` VALUES ('241', 'Angular快速入门', '中级', '前端开发', '帮助大家快速上手开发', 'AngularJS', '6小时15分', '更新完毕', '4632347');
INSERT INTO `course` VALUES ('242', 'AngularJS基础一', '高级', '前端开发', '一起学习AngularJS基础教程一', 'AngularJS', '8小时15分', '更新完毕', '1524653');
INSERT INTO `course` VALUES ('243', 'AngularJS基础二', '高级', '前端开发', '一起学习AngularJS基础教程二', 'AngularJS', '8小时15分', '更新完毕', '1524653');
INSERT INTO `course` VALUES ('244', 'AngularJS基础三', '高级', '前端开发', '一起学习AngularJS基础教程三', 'AngularJS', '8小时15分', '更新完毕', '1524653');
INSERT INTO `course` VALUES ('245', 'AngularJS前端框架开发', '高级', '前端开发', 'AngularJS前端框架开发', 'AngularJS', '8小时15分', '更新完毕', '1524653');
INSERT INTO `course` VALUES ('246', 'JavaScript之Vue.JS(二)', '初级', '前端开发', 'Vue.JS的基础学习', 'Vue.JS', '4小时15分', '更新完毕', '325368');
INSERT INTO `course` VALUES ('247', 'JavaScript之Vue.JS(一)', '初级', '前端开发', 'Vue.JS的基础学习', 'Vue.JS', '4小时30分', '更新完毕', '634135');
INSERT INTO `course` VALUES ('248', '走进Vue.JS 1.0', '初级', '前端开发', 'Vue的基础学习', 'Vue.JS', '3小时15分', '更新完毕', '6347867');
INSERT INTO `course` VALUES ('249', 'Vue构建工具', '初级', '前端开发', 'Vue构建工具的基础学习', 'Vue.JS', '4小时15分', '更新完毕', '353753');
INSERT INTO `course` VALUES ('250', 'Vue实战案例', '高级', '前端开发', 'Vue的实战案例开发教程', 'Vue.JS', '9小时25分', '更新完毕', '235765');
INSERT INTO `course` VALUES ('251', 'Vue生命周期', '中级', '前端开发', '了解Vue的生命周期', 'Vue.JS', '4小时15分', '更新完毕', '253676');
INSERT INTO `course` VALUES ('252', '走进Vue.JS 2.0', '初级', '前端开发', 'Vue.JS的基础学习', 'Vue.JS', '3小时15分', '更新完毕', '425343');
INSERT INTO `course` VALUES ('253', 'Vue.JS入门和实战', '高级', '前端开发', 'Vue.JS的实战入门开发', 'Vue.JS', '8小时15分', '更新完毕', '748784');
INSERT INTO `course` VALUES ('254', 'React实战入门', '中级', '前端开发', 'React的实战入门学习与开发', 'React.JS', '7小时15分', '更新完毕', '135367');
INSERT INTO `course` VALUES ('255', 'React学习入门到精通', '初级', '前端开发', 'React入门学习', 'React.JS', '6小时15分', '更新完毕', '436489');
INSERT INTO `course` VALUES ('256', '彻底征服React', '高级', '前端开发', '学过这些你就能掌握React', 'React.JS', '10小时15分', '更新完毕', '245363');
INSERT INTO `course` VALUES ('257', 'React入门教程', '初级', '前端开发', 'React的入门学习', 'React.JS', '4小时15分', '更新完毕', '762143');
INSERT INTO `course` VALUES ('258', 'React从入门到精通', '中级', '前端开发', 'React的入门学习与开发', 'React.JS', '6小时15分', '更新完毕', '642536');
INSERT INTO `course` VALUES ('259', 'React全家桶', '中级', '前端开发', 'React全家桶之web基础应用', 'React.JS', '6小时45分', '更新完毕', '523534');
INSERT INTO `course` VALUES ('260', 'React构建应用', '中级', '前端开发', 'React全家桶之构建应用', 'React.JS', '7小时35分', '更新完毕', '352345');
INSERT INTO `course` VALUES ('261', 'React社区开发实战', '高级', '前端开发', 'React的实战', 'React.JS', '12小时15分', '更新完毕', '4364772');
INSERT INTO `course` VALUES ('30', 'HTML+CSS基础课程', '初级', '前端开发', '基础课程7小时带你深入学习标签用法', 'HTML/CSS', '7小时20分', '更新完毕', '3244326');
INSERT INTO `course` VALUES ('31', '网页布局基础', '初级', '前端开发', 'CSS三大定位机制，彻底掌握网页布局', 'HTML/CSS', '7小时20分', '更新完毕', '1538261');
INSERT INTO `course` VALUES ('32', '如何运用CSS进行网页布局', '初级', '前端开发', '最简洁的布局知识案例', 'HTML/CSS', '6小时30分', '更新完毕', '210550');
INSERT INTO `course` VALUES ('33', '手把手教你实现电商网站开发', '初级', '前端开发', '电商网站基本制作流程，掌握整站开发过程', 'HTML/CSS', '7小时20分', '更新完毕', '4438925');
INSERT INTO `course` VALUES ('34', '企业网站综合布局实战', '中级', '前端开发', '实现常见企业网站布局方法', 'HTML/CSS', '7小时10分', '更新完毕', '1353678');
INSERT INTO `course` VALUES ('35', '导航条菜单的制作', '初级', '前端开发', '水平，垂直，圆角导航条菜单制作', 'HTML/CSS', '7小时37分', '更新完毕', '6236782');
INSERT INTO `course` VALUES ('36', '网页简单布局之结构与表现原则', '初级', '前端开发', '入门必杀结构与表现', 'HTML/CSS', '6小时20分', '更新完毕', '1532676');
INSERT INTO `course` VALUES ('37', 'IT菜鸟逆袭指南', '初级', '前端开发', '码农逆袭有秘诀，给你一些启发', 'HTML/CSS', '5小时20分', '更新完毕', '3244326');
INSERT INTO `course` VALUES ('38', 'JavaScript入门篇', '初级', '前端开发', 'web工程师的必备技术', 'JavaScript', '4小时15分', '更新完毕', '5436764');
INSERT INTO `course` VALUES ('39', 'JavaScript进阶篇', '中级', '前端开发', '从如何插入JS代码开始，进入网页动态交互世界', 'JavaScript', '6小时25分', '更新完毕', '35436536');
INSERT INTO `course` VALUES ('40', 'JavaScript深入浅出', '高级', '前端开发', '解析JS常见误区，从入门到掌握', 'JavaScript', '7小时15分', '更新完毕', '3536357');
INSERT INTO `course` VALUES ('41', 'Ajax全接触', '高级', '前端开发', 'Ajax相关概念原理实现方式和应用', 'JavaScript', '8小时05分', '更新完毕', '35236764');
INSERT INTO `course` VALUES ('42', 'JS动画效果', '高级', '前端开发', '从简单动画开始，深入各种动画', 'JavaScript', '7小时34分', '更新完毕', '35433676');
INSERT INTO `course` VALUES ('43', '网页定位导航特效', '中级', '前端开发', '网页定位导航特效，仿天猫版购物网', 'JavaScript', '5小时15分', '更新完毕', '3253648');
INSERT INTO `course` VALUES ('44', '电商网站前端架构', '高级', '前端开发', '项目组织开发，教你如何创建一个电子商务', 'JavaScript', '8小时15分', '更新完毕', '1243536');
INSERT INTO `course` VALUES ('45', '商城分类导航效果', '中级', '前端开发', '两种方法实现导航，同时扩展其他导航制作', 'JavaScript', '6小时15分', '更新完毕', '1353768');
INSERT INTO `course` VALUES ('46', 'Html5之元素与标签结构', '高级', '前端开发', '详细探讨HTML5元素与标签结构知识', 'Html5', '8小时15分', '更新完毕', '13524635');
INSERT INTO `course` VALUES ('47', 'Html5音乐可视化', '高级', '前端开发', '利用webaudio和canvas让你的音乐动起来', 'Html5', '8小时15分', '更新完毕', '3256547');
INSERT INTO `course` VALUES ('48', 'Html5存储', '高级', '前端开发', '浏览器端存储的方案', 'Html5', '8小时20分', '更新完毕', '2356765');
INSERT INTO `course` VALUES ('49', '绚丽的倒计时效果', '高级', '前端开发', '学习HTML5中最激动人心的技术', 'Html5', '8小时32分', '更新完毕', '2536347');
INSERT INTO `course` VALUES ('50', 'Html5小游戏', '中级', '前端开发', '学做HTML5小游戏，适合刚入手同学', 'Html5', '6小时15分', '更新完毕', '1352678');
INSERT INTO `course` VALUES ('51', 'Html5离线应用实战演练', '高级', '前端开发', '一起来剖析离线技术吧', 'Html5', '8小时45分', '更新完毕', '324678');
INSERT INTO `course` VALUES ('52', '走进SVG', '高级', '前端开发', 'HTML5中矢量图的标记语言，掌握更多干货', 'Html5', '8小时15分', '更新完毕', '3243679');
INSERT INTO `course` VALUES ('53', '用D3制作图表', '中级', '前端开发', '用最酷的数据可视化图表，初窥数据可视化奥秘', 'Html5', '6小时15分', '更新完毕', '3246376');
INSERT INTO `course` VALUES ('54', 'CSS3实现网页平滑过渡效果', '中级', '前端开发', '打造页面之间的平滑效果，带来神奇的体验', 'CSS3', '6小时15分', '更新完毕', '1325465');
INSERT INTO `course` VALUES ('55', 'CSS3实现漂亮的tooltips效果', '中级', '前端开发', '实现鼠标悬停弹出信息提示框', 'CSS3', '6小时20分', '更新完毕', '1356377');
INSERT INTO `course` VALUES ('56', 'CSS3教你玩转CSS禅意花园', '中级', '前端开发', '36个设计让你彻底了解CSS3', 'CSS3', '6小时15分', '更新完毕', '1325465');
INSERT INTO `course` VALUES ('57', 'CSS3绚丽照片墙', '中级', '前端开发', '轻松实现绚丽照片墙效果', 'CSS3', '6小时35分', '更新完毕', '3243546');
INSERT INTO `course` VALUES ('58', '按钮特效', '中级', '前端开发', 'web前端开发必备能力', 'CSS3', '6小时45分', '更新完毕', '2463479');
INSERT INTO `course` VALUES ('59', 'CSS3图片动态提示效果', '中级', '前端开发', '图片动态提示效果', 'CSS3', '6小时35分', '更新完毕', '2957834');
INSERT INTO `course` VALUES ('60', 'CSS3实现图片阴影效果', '中级', '前端开发', '利用多投影重叠原理，实现曲线阴影和翘边阴影的效果', 'CSS3', '7小时25分', '更新完毕', '1524842');
INSERT INTO `course` VALUES ('61', 'CSS3共嗨世界杯', '高级', '前端开发', '世界杯与前端只是两不误', 'CSS3', '9小时15分', '更新完毕', '1520815');
INSERT INTO `course` VALUES ('62', 'jQuery基础一', '初级', '前端开发', 'jQuery初入开启样式搭建网站布局', 'jQuery', '3小时15分', '更新完毕', '2563547');
INSERT INTO `course` VALUES ('63', 'jQuery基础二', '初级', '前端开发', 'jQuery创建了解插入和替换', 'jQuery', '3小时15分', '更新完毕', '1324635');
INSERT INTO `course` VALUES ('64', 'jQuery源码解析', '高级', '前端开发', '揭开框架背后的秘密', '9小时15分', 'jQuery', '更新完毕', '5245672');
INSERT INTO `course` VALUES ('65', 'jQuery基础四', '初级', '前端开发', '基础教程动画篇，开启动画修炼', 'jQuery', '3小时15分', '更新完毕', '426357');
INSERT INTO `course` VALUES ('66', '新手引导', '中级', '前端开发', 'JavaScript和jQuery依次显示', 'jQuery', '5小时15分', '更新完毕', '1353567');
INSERT INTO `course` VALUES ('67', 'jQuery基础三', '初级', '前端开发', '掌握对页面进行交互的操作', 'jQuery', '3小时45分', '更新完毕', '5256352');
INSERT INTO `course` VALUES ('68', 'jQuery实现自定义滚动条', '中级', '前端开发', '深入理解滚轮事件交互', 'jQuery', '6小时15分', '更新完毕', '26457658');
INSERT INTO `course` VALUES ('69', 'Ajax应用与常用插件', '初级', '前端开发', '有效提高前端开发速度', 'jQuery', '3小时15分', '更新完毕', '5253678');
INSERT INTO `course` VALUES ('70', '玩转Bootstrap基础一', '中级', '前端开发', '告诉你使用Bootstrap并且能够独立制定出适合自己的Bootstrap', 'Bootstrap', '6小时15分', '更新完毕', '1352456');
INSERT INTO `course` VALUES ('71', 'Bootstrap快速入门', '高级', '前端开发', '最流行的框架之一，带你快速搭建网页', 'Bootstrap', '8小时15分', '更新完毕', '35236547');
INSERT INTO `course` VALUES ('72', '基于Bootstrap的网站开发', '中级', '前端开发', 'Bootstrap前端框架搭建网页', 'Bootstrap', '6小时20分', '更新完毕', '2536789');
INSERT INTO `course` VALUES ('73', '响应式布局', '高级', '前端开发', '让网站兼容不同终端不是梦', 'Bootstrap', '10小时15分', '更新完毕', '7685721');
INSERT INTO `course` VALUES ('74', '玩转Bootstrap（JS插件篇）', '中级', '前端开发', '自由扩制Bootstrap中提供的组件', 'Bootstrap', '6小时15分', '更新完毕', '246357');
INSERT INTO `course` VALUES ('75', '玩转Bootstrap框架', '中级', '前端开发', '框架的构建和使用', 'Bootstrap', '6小时15分', '更新完毕', '5733464');
INSERT INTO `course` VALUES ('76', '玩转Bootstrap视频', '中级', '前端开发', '玩转视频', 'Bootstrap', '6小时15分', '更新完毕', '6584326');
INSERT INTO `course` VALUES ('77', 'Bootstrap前端开发', '中级', '前端开发', 'Bootstrap的前端开发', 'Bootstrap', '6小时15分', '更新完毕', '4634576');
INSERT INTO `course` VALUES ('78', 'AngularJS实战', '高级', '前端开发', '一起学习AngularJS基础教程', 'AngularJS', '8小时15分', '更新完毕', '1524653');
INSERT INTO `course` VALUES ('79', 'AngularJS开发下一代web应用', '高级', '前端开发', '化繁为简，更简单的开发体验', 'AngularJS', '8小时30分', '更新完毕', '6425461');
INSERT INTO `course` VALUES ('80', 'AngularJS表单验证', '高级', '前端开发', '一看就明白的表单验证', 'AngularJS', '8小时45分', '更新完毕', '7467425');
INSERT INTO `course` VALUES ('81', 'PHP入门篇', '初级', '后端开发', 'PHP入门教程轻松学', 'PHP', '6小时12分', '更新完毕', '330627');
INSERT INTO `course` VALUES ('82', 'PHP进阶篇', '中级', '后端开发', '轻松学习PHP中级课程，全面了解', 'PHP', '7小时20分', '持续更新', '134744');
INSERT INTO `course` VALUES ('83', '版本管理工具介绍—Git篇', '初级', '后端开发', '主要讲解了git在各平台的安装', 'PHP', '7小时30分', '持续更新', '201202');
INSERT INTO `course` VALUES ('84', '手把手教你实现电商网站后台开发', '中级', '后端开发', '手把手教你用PHP搭建电子商务平台', 'PHP', '6小时15分', '更新完毕', '145268');
INSERT INTO `course` VALUES ('85', 'PHP实现微信公众平台开发—基础篇', '中级', '后端开发', '由浅入深一起玩转微信公众平台开发', 'PHP', '8小时10分', '持续更新', '124568');
INSERT INTO `course` VALUES ('86', '快速入门ThinkPHP框架—理论篇', '高级', '后端开发', '快速入门ThinkPHP框架教程', 'PHP', '5小时25分', '持续更新', '84565');
INSERT INTO `course` VALUES ('87', 'MVC架构模式分析与设计', '中级', '后端开发', '通过学习MVC理论知识，带您实现第一个MVC框架', 'PHP', '6小时10分', '更新完毕', '56942');
INSERT INTO `course` VALUES ('88', 'PHP开发APP接口', '高级', '后端开发', 'APP通信接口技术，不得不掌握的法宝', 'PHP', '7小时50分', '更新完毕', '45297');
INSERT INTO `course` VALUES ('89', 'Java入门第一季', '初级', '后端开发', '本课程从头带你入门', 'Java', '7小时20分', '持续更新', '124571');
INSERT INTO `course` VALUES ('90', 'Java入门第二季', '初级', '后端开发', 'Java面向对象编程基本实现原理', 'Java', '6小时45分', '更新完毕', '545742');
INSERT INTO `course` VALUES ('91', 'Java入门第三季', '初级', '后端开发', 'Java中你必须懂得常用技能', 'Java', '7小时10分', '持续更新', '54587');
INSERT INTO `course` VALUES ('92', 'Java遇见HTML—JSP篇', '初级', '后端开发', 'Java Web入门级教程JSP', 'Java', '6小时46分', '更新完毕', '414233');
INSERT INTO `course` VALUES ('93', 'Spring入门篇', '高级', '后端开发', '为您带来IOC和AOP的基本概念及方法', 'Java', '7小时15分', '持续更新', '21463');
INSERT INTO `course` VALUES ('94', '深入浅出Java多线程', '中级', '后端开发', '带与你一起深入浅出多线程', 'Java', '7小时35分', '持续更新', '21546');
INSERT INTO `course` VALUES ('95', 'Spring MVC起步', '高级', '后端开发', 'Java中Spring MVC框架入门教程', 'Java', '6小时30分', '更新完毕', '54543');
INSERT INTO `course` VALUES ('96', '初识Java微信公众号开发', '中级', '后端开发', 'Java', 'Java微信公众号开发的入门教程', '5小时45分', '持续更新', '24546');
INSERT INTO `course` VALUES ('98', 'python进阶', '中级', '后端开发', '学习函数式、模块和面向对象编程', 'Python', '6小时50分', '更新完毕', '54532');
INSERT INTO `course` VALUES ('99', 'Python开发简单爬虫', '高级', '后端开发', '本教程带您解开python爬虫这门神奇技术', 'Python', '5小时50分', '持续更新', '135220');

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `question_id` varchar(8) NOT NULL,
  `question_user` varchar(45) DEFAULT NULL,
  `question_title` varchar(200) DEFAULT NULL,
  `question_time` varchar(45) DEFAULT NULL,
  `question_label` varchar(45) DEFAULT NULL,
  `question_num` varchar(20) DEFAULT NULL,
  `question_new` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '慕慕', '猿们看过来！文章投稿功能开放啦！', '20170622', 'javascript', '2343', null);
INSERT INTO `question` VALUES ('2', '课课', '这个bug怎么改？', '20170622', 'java', '298', null);
INSERT INTO `question` VALUES ('4', '游客', '3eds', '2017-6-22-23:50:45', '', '0', '无');
INSERT INTO `question` VALUES ('5', '游客', 'czsadczsdacfwa', '2017-6-22-23:51:48', '', '0', '无');
INSERT INTO `question` VALUES ('6', '11111', 'kkkkkkk', '2017-6-22-23:57:35', '', '0', '无');
INSERT INTO `question` VALUES ('7', '11111', 'oooooo', '2017-6-22-23:59:40', '', '0', '无');
INSERT INTO `question` VALUES ('8', '游客', '强强强强强', '2017-6-22-22:44:23', '', '0', '无');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(8) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_password` varchar(20) DEFAULT NULL,
  `user_email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1');
INSERT INTO `user` VALUES ('1111', '11111', '1111', '');
INSERT INTO `user` VALUES ('2', 'kkkkk', '2', '2');
INSERT INTO `user` VALUES ('222', 'FDHGF', '222', '');
INSERT INTO `user` VALUES ('3', '33333', '3', '');
