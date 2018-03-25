/*
Navicat MySQL Data Transfer

Source Server         : 193.112.3.227
Source Server Version : 50721
Source Host           : 193.112.3.227:3306
Source Database       : eivencrm

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-03-25 22:22:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mk_user
-- ----------------------------
DROP TABLE IF EXISTS `mk_user`;
CREATE TABLE `mk_user` (
  `id` char(18) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL COMMENT '真实群名，显示规则：real_name > nick_name > user_name',
  `mobile` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `skill` varchar(255) DEFAULT NULL COMMENT '用户擅长技能',
  `sex` int(11) DEFAULT '0' COMMENT '0=男 1=女 2=不知',
  `birthday` int(11) DEFAULT NULL COMMENT '20121107',
  `age` int(11) DEFAULT NULL,
  `shuo_ming` varchar(255) DEFAULT NULL COMMENT '个人说明',
  `portrait_url` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `qrcode` varchar(255) DEFAULT NULL COMMENT '用户二维码',
  `wxid` varchar(255) DEFAULT NULL,
  `wx_subs` int(11) DEFAULT '0' COMMENT '是否关注过微信　0=未 1=有',
  `imid` varchar(255) DEFAULT NULL,
  `impwd` varchar(255) DEFAULT NULL,
  `id_auth_status` int(11) DEFAULT NULL COMMENT '身份证认证状态 0=未认证 1=认证成功 2=认证中 3=认证失败',
  `mobile_auth_status` int(11) DEFAULT NULL,
  `email_auth_status` int(11) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `pay_status` int(11) DEFAULT '0' COMMENT '0=未付费 ,1=付费',
  `unionid` varchar(255) DEFAULT NULL,
  `lang` varchar(255) DEFAULT NULL COMMENT '语言，现在直接从微信里拿，后期用来支持国际化',
  `status` int(11) DEFAULT NULL COMMENT '0=禁用 1=启用',
  `leader` bigint(20) DEFAULT NULL COMMENT '上线',
  `last_log_time` int(11) DEFAULT '0',
  `user_level` bigint(20) DEFAULT NULL COMMENT '学员等级',
  `user_score` decimal(10,2) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  `recommend` int(11) DEFAULT '0' COMMENT '推荐讲师',
  `integration_rule` text COMMENT '存储加分规则，如上限等',
  `perfect_info` int(4) DEFAULT '0' COMMENT '全部完善我的信息',
  `creator` varchar(255) DEFAULT NULL,
  `create_time` int(11) DEFAULT NULL,
  `updator` varchar(255) DEFAULT NULL,
  `update_time` int(11) DEFAULT NULL,
  `org_id` bigint(20) DEFAULT NULL,
  `shop_id` bigint(20) NOT NULL DEFAULT '0',
  `contribution` int(11) DEFAULT NULL COMMENT '用户贡献值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表，所有的学员，讲师，校长，管理员都会在这里先保存，然后再分另外的表来存储具体信息';

-- ----------------------------
-- Records of mk_user
-- ----------------------------
INSERT INTO `mk_user` VALUES ('1', 'padmin', '清华', null, '15875927543', '380026342@qq.com', 'e10adc3949ba59abbe56e057f20f883e', null, '0', null, null, 'hhhh', '', null, null, null, '0', null, null, null, '1', '1', null, null, null, null, 'sys_admin', '0', null, null, '1', null, '1468907778', null, '0.00', '0', '0', null, '0', '0', '0', '0', '1482149226', '1', '0', null);
INSERT INTO `mk_user` VALUES ('109', '13911111111', '印记', '', '13911111111', '', 'e10adc3949ba59abbe56e057f20f883e', '保密', '2', '915120000', '0', '', 'http://yinlidao-10018982.image.myqcloud.com/3/DzQI5W8wTMAo3qeEE64-crop-100.png', '测试', '', '', '0', '', '', '0', '0', '0', '', '广东', '广州', '增城市', 'sys_dean', '0', '', '', '1', '3', '1487583992', '43', '0.00', '0', '0', '{\"replyTopicOrArticleLastTime\":1489203038,\"rewardCount\":1,\"replyTopicOrArticleCount\":1,\"rewardLastTime\":1489202479}', '1', '0', '1487664865', '109', '1489203038', '3', '0', '0');
INSERT INTO `mk_user` VALUES ('110', '13212332112', '测试1', '', '13212332112', '', 'e10adc3949ba59abbe56e057f20f883e', '保密', '0', '1265126400', '0', '', 'http://yinlidao-10018982.image.myqcloud.com/3/hYO9hXFbRIlCUxw3KzH-crop-1.jpg', '测试', '', '', '0', '', '', '0', '0', '0', '', '广东', '广州', '荔湾区', 'sys_student', '0', '', '', '1', '3', '1487587312', '34', '0.00', '0', '0', '', '1', '0', '1487587312', '0', '1487900637', '3', '0', '0');
INSERT INTO `mk_user` VALUES ('111', '13660198105@163.com', 'huan136', '', '', '13660198105@163.com', 'e10adc3949ba59abbe56e057f20f883e', '保密', '0', '0', '0', '', 'http://yinlidao-10018982.image.myqcloud.com/3/EdgbrlYmdKalku19LHb-crop.jpg', '测试', '', '', '0', '', '', '0', '0', '0', '', '', '', '', 'sys_student', '0', '', '', '1', '13', '1487731757', '0', '0.00', '0', '0', '{\"replyTopicOrArticleLastTime\":1487989930,\"replyTopicOrArticleCount\":1}', '0', '3', '1489039878', '0', '1487989930', '3', '0', '0');
INSERT INTO `mk_user` VALUES ('112', '110@qq.com', '测试签到', '', '', '110@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '保密', '0', '0', '0', '', '', '测试', '', '', '0', '', '', '0', '0', '0', '', '', '', '', 'sys_student', '0', '', '', '1', '0', '1487734162', '0', '0.00', '0', '0', '{\"rewardCount\":9,\"rewardLastTime\":1489117953}', '0', '0', '1487734162', '112', '1489117953', '3', '0', '0');
INSERT INTO `mk_user` VALUES ('113', '18320259585', '433878', '', '18320259585', '', 'e10adc3949ba59abbe56e057f20f883e', '', '0', '0', '0', '', '', '', '', '', '0', '', '', '0', '0', '0', '', '', '', '', 'sys_student', '0', '', '', '1', '3', '1487930674', '0', '0.00', '0', '0', '', '0', '0', '1487930674', '0', '0', '3', '0', '0');
INSERT INTO `mk_user` VALUES ('125', '15624586345', '轻轻的来', '', '15624586345', '', 'e10adc3949ba59abbe56e057f20f883e', '', '0', '0', '0', '', '', '', '', '', '0', '', '', '0', '0', '0', '', '', '', '', 'sys_student', '0', '', '', '1', '3', '1488768552', '0', '0.00', '0', '0', '', '0', '0', '1488768552', '3', '1488938864', '3', '0', '0');
INSERT INTO `mk_user` VALUES ('126', '18585874587', '书房士多房', null, '18585874587', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null, null, null, null, 'sys_student', null, null, null, '1', '3', '1488960999', null, '0.00', '0', null, null, null, '0', '1488960999', '0', '0', '3', '0', null);
INSERT INTO `mk_user` VALUES ('127', '18585858585', '所发生的', null, '18585858585', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null, null, null, null, 'sys_student', null, null, null, '1', '3', '1488962142', null, '0.00', '0', null, null, null, '0', '1488962142', '0', '0', '3', '0', null);
INSERT INTO `mk_user` VALUES ('128', '18557888888', '45654', null, '18557888888', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null, null, null, null, 'sys_student', null, null, null, '1', '3', '1488962542', null, '0.00', '0', null, null, null, '0', '1488962542', '0', '0', '3', '0', null);
INSERT INTO `mk_user` VALUES ('129', '18555555555', '松岛枫松岛枫', null, '18555555555', '', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, null, '/assets/img/default/avatar_v.png', '', null, null, '0', null, null, null, null, null, null, null, null, null, 'sys_student,sys_teacher', null, null, null, '1', '3', '1488963274', '0', '0.00', '0', null, null, null, '0', '1488963274', '3', '1489136238', '3', '0', null);
INSERT INTO `mk_user` VALUES ('130', '55848487@qq.com', null, null, null, '55848487@qq.com', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null, null, null, null, 'sys_student,sys_teacher,sys_dean', null, null, null, '1', null, null, null, null, '0', null, null, null, '0', '1489034585', '0', '1489034585', '11', '0', null);
INSERT INTO `mk_user` VALUES ('131', '55848487@qq.com', null, null, null, '55848487@qq.com', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null, null, null, null, 'sys_student,sys_teacher,sys_dean', null, null, null, '1', null, null, null, null, '0', null, null, null, '0', '1489034795', '0', '1489034795', '12', '0', null);
INSERT INTO `mk_user` VALUES ('132', 'eiven', '小谢', null, null, null, 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'sys_student', null, null, null, '1', null, '1489107981', null, '0.00', '0', null, null, null, '0', '1489107981', '0', '0', '1', '0', null);
INSERT INTO `mk_user` VALUES ('137', 'od88nweP6xOzu4x3HjBc2ngcFDpA', '电子表', null, '', '', '', null, '1', null, null, null, 'http://wx.qlogo.cn/mmopen/ulqU0jeN5Udfice8skXQeHSw3WudX9lkibh3q5eRJGGVRuITc73XibH4wwH3glTGazP0ibJRicwAzXhZqURnIhQ9wdGtPl5Blhicu8/0', '我是讲师', null, 'od88nweP6xOzu4x3HjBc2ngcFDpA', '1', null, null, null, null, null, '中国', '广东', '广州', null, 'sys_student,sys_teacher', null, null, 'zh_CN', '1', null, '1489122048', '0', '0.00', '0', '1489138594', null, null, '0', '1489122048', '3', '1489138594', '3', '0', null);
INSERT INTO `mk_user` VALUES ('2', '784691627@qq.com', 'zhang', '', '15875927532', '784691627@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '我很牛的', '0', '1481731200', '0', 'hhhh', 'http://yinlidao-10018982.image.myqcloud.com/3/57/R3VzaxFt3IHqWE4MzE1/5.jpg?imageView2/5/width/250/height/300', '', '', '', '0', '', '', '0', '1', '1', '', '广东', '广州', '天河区', 'sys_student', '0', '', '', '1', '0', '1479954176', '33', '0.00', '0', '3', '{\"rewardCount\":1,\"rewardLastTime\":1488180022}', '0', '0', '1487658697', '0', '1488180022', '3', '0', '0');
INSERT INTO `mk_user` VALUES ('3', 'admin', 'admin', '', '13760639224', '55848487@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '我会种草，插秧，还会拔草和助长1', '0', '1574352000', '0', 'hhhh', 'http://yinlidao-10018982.image.myqcloud.com/3/THrwslciIMDwVRdv1Fl-crop.jpg', '每天都被自己帅醒，好烦123', '', '', '0', '', '', '2', '1', '1', '', '澳门', '圣方济各堂区', '天河区', 'sys_student,sys_teacher,sys_admin,sys_dean', '0', '', '', '1', '3', '1482745292', '41', '0.00', '0', '1489136761', '{\"studyDianBoLastTime\":1489126639,\"dianBoStudentCount\":1,\"rewardCount\":3,\"dianBoStudentLastTime\":1489129063,\"shareOrgCount\":4,\"uploadVideoLastTime\":1488968662,\"liveTimeCount\":3,\"studyDianBoCount\":1,\"rewardLastTime\":1489216095,\"zhiBoStudentCount\":9,\"uploadVideoCount\":4,\"replyTopicOrArticleLastTime\":1489215619,\"liveTimeLastTime\":1488971264,\"shareOrgLastTime\":1488963319,\"replyTopicOrArticleCount\":8,\"zhiBoStudentLastTime\":1489211489}', '1', '3', '1488979363', '3', '1489216095', '3', '0', '45');
INSERT INTO `mk_user` VALUES ('58', 'huan@163.com', 'huan', '', '13575927551', 'huan@163.com', 'e10adc3949ba59abbe56e057f20f883e', '飞呀飞呀', '1', '1479916800', '0', 'hhhh', 'http://yinlidao-10018982.image.myqcloud.com/3/58/IQELGCACH0mZrx8vU3K/头像2.jpg?imageView2/5/width/250/height/300', '我可是高高手哟，跟我来吧1', '', '', '0', '', '', '0', '1', '1', '', '广东', '广州', '天河区', 'sys_student,sys_teacher,123', '0', '', '', '1', '0', '1479954550', '41', '0.00', '0', '1489138715', '{\"replyTopicOrArticleLastTime\":1488365479,\"rewardCount\":1,\"replyTopicOrArticleCount\":4,\"rewardLastTime\":1487927978}', '0', '3', '1489039557', '3', '1489138715', '3', '0', '0');
INSERT INTO `mk_user` VALUES ('59', '2634176956@qq.com', '小绵羊', '', '15873427543', '2634176956@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '只吃', '1', '1480003200', '0', 'hhhh', 'http://yinlidao-10018982.image.myqcloud.com/3/BPZqst0bRJhLI7kONqy-懒羊羊.jpg', '跟我一起飞一起装逼', '', '', '0', '', '', '0', '1', '1', '', '广东', '广州', '天河区', 'sys_teacher', '0', '', '', '1', '0', '1479954780', '32', '0.00', '0', '1487569832', '{\"replyTopicOrArticleLastTime\":1488000680,\"rewardCount\":2,\"replyTopicOrArticleCount\":1,\"rewardLastTime\":1487927307}', '1', '0', '1487927307', '0', '1488186878', '3', '0', '0');
INSERT INTO `mk_user` VALUES ('60', '870651361@qq.com', '小康', '', '15915775533', '870651361@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '缘来是你', '0', '1470499200', '0', 'hhh', 'http://course.mncode.cn/3/60/Zv8m6UxIoZWTgjvfjw5/2.jpg?imageView2/1/w/300/h/200/q/80', '', '', '', '0', '', '', '0', '1', '1', '', '广东', '广州', '天河区', 'sys_student', '0', '', '', '1', '0', '1479954847', '41', '0.00', '0', '0', '{\"replyTopicOrArticleLastTime\":1484823224,\"rewardCount\":4,\"replyTopicOrArticleCount\":1,\"rewardLastTime\":1488018162}', '0', '0', '1486371311', '0', '1488018162', '3', '0', '88');
INSERT INTO `mk_user` VALUES ('68', 'test', 'test', '', '15875927552', '380026004@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '呵呵1', '0', '1438358400', '0', 'hh', 'http://yinlidao-10018982.image.myqcloud.com/3/68/5Y7Pt63tjVliUa7kJW8/07.png', '呵呵', '', '', '0', '', '', '0', '1', '1', '', '广东', '广州', '天河区', 'sys_student,sys_student', '0', '', '', '1', '0', '1480930916', '34', '0.00', '0', '0', '{\"rewardCount\":2,\"rewardLastTime\":1489211552}', '0', '0', '1487582355', '68', '1489211552', '3', '0', '0');
INSERT INTO `mk_user` VALUES ('70', '刘德华', '刘德华', '', '1587457543', '11@qq.com', '96e79218965eb72c92a549dd5a330112', '会放激光', '2', '1574956800', '0', 'hh', 'http://yinlidao-10018982.image.myqcloud.com/3/70/hzNREH6f28yKwyWKREg/7a8.jpg', '帅', '', '', '0', '', '', '0', '1', '1', '', '国外', '', '', 'sys_teacher', '0', '', '', '1', '0', '1480994605', '34', '0.00', '0', '0', '{\"studyDianBoLastTime\":1489109305,\"rewardCount\":1,\"shareNotFreeLessionLastTime\":1489216095,\"shareFreeLessionLastTime\":1489110719,\"shareNotFreeLessionCount\":6,\"studyDianBoCount\":1,\"rewardLastTime\":1489052333,\"shareFreeLessionCount\":3}', '0', '0', '1480994605', '3', '1489216095', '3', '0', '0');
INSERT INTO `mk_user` VALUES ('71', '15875927551@qq.com', 'tomcat', '', '15875677543', '15875927551@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '测试1', '0', '1480003200', '0', 'hhy', 'http://yinlidao-10018982.image.myqcloud.com/3/71/ZNNQWuhIDs6h36UQhKQ/QQ图片20161210113705.gif?imageView2/5/width/250/height/300', '测试', '', '', '0', '', '', '1', '1', '1', '', '广东', '广州', '天河区', 'sys_teacher', '0', '', '', '1', '0', '1481092996', '32', '0.00', '0', '1487405259', '{\"rewardCount\":2,\"rewardLastTime\":1487647428}', '0', '0', '1486633249', '3', '1489133466', '3', '0', '0');

-- ----------------------------
-- Table structure for sys_company
-- ----------------------------
DROP TABLE IF EXISTS `sys_company`;
CREATE TABLE `sys_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父级编号',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `address` varchar(255) DEFAULT NULL,
  `sort` int(10) DEFAULT NULL COMMENT '排序',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `fax` varchar(200) DEFAULT NULL COMMENT '传真',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `useable` varchar(64) DEFAULT NULL COMMENT '是否启用',
  `primary_person` varchar(64) DEFAULT NULL COMMENT '主负责人',
  `deputy_person` varchar(64) DEFAULT NULL COMMENT '副负责人',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` bit(1) DEFAULT b'0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_company
-- ----------------------------

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `id` int(20) NOT NULL,
  `parent_id` int(20) NOT NULL COMMENT '父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` int(10) NOT NULL COMMENT '排序',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `fax` varchar(200) DEFAULT NULL COMMENT '传真',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `useable` varchar(64) DEFAULT NULL COMMENT '是否启用',
  `primary_person` varchar(64) DEFAULT NULL COMMENT '主负责人',
  `deputy_person` varchar(64) DEFAULT NULL COMMENT '副负责人',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_department
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `parent_id` int(20) DEFAULT NULL COMMENT '父菜单id',
  `name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(500) DEFAULT NULL COMMENT '菜单链接',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `isuse` bit(1) DEFAULT b'1' COMMENT '状态（0显示，1隐藏)',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `type` varchar(255) DEFAULT NULL,
  `isopen` bit(1) DEFAULT b'0' COMMENT '是否展开 true 是 false 否',
  `update_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', null, '系统设置', null, '&#xe614;', '1', '', null, null, null, '\0', '1', '2018-03-21 13:53:51', '1', '2018-03-21 13:53:54');
INSERT INTO `sys_menu` VALUES ('2', '1', '菜单设置', null, null, '1', '', null, null, null, '\0', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('3', '1', '用户设置', '', '', '2', '', '', '', '', '\0', '1', '2018-03-21 13:53:51', '1', '2018-03-21 13:53:54');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL COMMENT '角色id',
  `name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `code` varchar(64) DEFAULT NULL COMMENT '角色代码',
  `status` varchar(6) DEFAULT NULL COMMENT '角色状态(0正常 1禁用）',
  `role_type` varchar(6) DEFAULT NULL COMMENT '角色类型',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '新增时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新人',
  `create_id` varchar(32) DEFAULT NULL COMMENT '新增人',
  `company_id` bigint(20) NOT NULL COMMENT '归属公司',
  `office_id` bigint(20) NOT NULL COMMENT '归属部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` int(20) NOT NULL COMMENT '角色id',
  `menu_id` int(20) NOT NULL COMMENT '权限id',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) DEFAULT NULL COMMENT '归属公司',
  `department_id` int(11) DEFAULT NULL COMMENT '归属部门',
  `login_name` varchar(100) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `no` varchar(100) DEFAULT NULL COMMENT '工号',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `identity_card` varchar(18) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) DEFAULT NULL COMMENT '手机',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型',
  `photo` varchar(1000) DEFAULT NULL COMMENT '用户头像',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `login_time` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_id` int(11) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` int(11) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `is_use` int(1) DEFAULT '0' COMMENT '是否使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', null, null, 'eiven', 'c4ca4238a0b923820dcc509a6f75849b', null, 'eiven', null, null, null, null, null, null, null, null, null, null, null, '1', '2018-03-16 11:44:17', '1', '2018-03-16 11:44:20', null, '0');
INSERT INTO `sys_user` VALUES ('2', null, null, 'zhangsan', 'c4ca4238a0b923820dcc509a6f75849b', '', '张三', null, null, null, null, '', '', '', '', '', '', '2018-03-23 17:14:51', '1', '2018-03-23 17:14:51', '1', '2018-03-16 11:44:20', '', '0');
INSERT INTO `sys_user` VALUES ('3', null, null, 'lisi', 'c4ca4238a0b923820dcc509a6f75849b', '', '李四', null, null, null, null, '', '', '', '', '', '', '2018-03-24 17:14:51', '1', '2018-03-24 17:14:51', '1', '2018-03-16 11:44:20', '', '0');
INSERT INTO `sys_user` VALUES ('4', null, null, 'wangwu', 'c4ca4238a0b923820dcc509a6f75849b', '', '王五', null, null, null, null, '', '', '', '', '', '', '2018-03-25 17:14:51', '1', '2018-03-25 17:14:51', '1', '2018-03-16 11:44:20', '', '0');
INSERT INTO `sys_user` VALUES ('5', null, null, '马六', 'c4ca4238a0b923820dcc509a6f75849b', '', '马六', null, null, null, null, '', '', '', '', '', '', '2018-03-24 17:14:51', '1', '2018-03-16 11:44:17', '1', '2018-03-16 11:44:20', '', '0');
INSERT INTO `sys_user` VALUES ('6', null, null, 'jh', 'c4ca4238a0b923820dcc509a6f75849b', '', 'jiahui', null, null, null, null, '', '', '', '', '', '', '2018-03-24 17:14:51', '1', '2018-03-16 11:44:17', '1', '2018-03-16 11:44:20', '', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Function structure for find_in_set_plus
-- ----------------------------
DROP FUNCTION IF EXISTS `find_in_set_plus`;
DELIMITER ;;
CREATE DEFINER=`mm`@`%` FUNCTION `find_in_set_plus`(source VARCHAR(1000) , target VARCHAR(1000) ) RETURNS int(11)
BEGIN
DECLARE ret INT DEFAULT 0;
DECLARE matched INT;
DECLARE a INT DEFAULT 0 ;
DECLARE str VARCHAR(255);
DECLARE source1 VARCHAR(1000);
DECLARE target1 VARCHAR(1000);
SET source1 = IFNULL(source, '');
SET target1 = IFNULL(target, '');
  simple_loop: LOOP
	 SET a=a+1;
	 SET str=SPLIT_STR(source1,",",a);
	 IF str='' THEN
	    LEAVE simple_loop;
	 END IF;
	 SET matched =  FIND_IN_SET(str, target1);
	 IF matched > 0 THEN
	    SET ret = ret + 1;
	 END IF;
  END LOOP simple_loop;
  RETURN ret;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for harvesine
-- ----------------------------
DROP FUNCTION IF EXISTS `harvesine`;
DELIMITER ;;
CREATE DEFINER=`mm`@`%` FUNCTION `harvesine`(lat1 double, lon1 double, lat2 double, lon2 double) RETURNS double
return  3956 * 2 * ASIN(SQRT(POWER(SIN((lat1 - abs(lat2)) * pi()/180 / 2), 2)
         + COS(abs(lat1) * pi()/180 ) * COS(abs(lat2) * pi()/180) * POWER(SIN((lon1 - lon2) * pi()/180 / 2), 2) ))
;;
DELIMITER ;

-- ----------------------------
-- Function structure for split_str
-- ----------------------------
DROP FUNCTION IF EXISTS `split_str`;
DELIMITER ;;
CREATE DEFINER=`mm`@`%` FUNCTION `split_str`(
  x VARCHAR(255),
  delim VARCHAR(12),
  pos INT
) RETURNS varchar(255) CHARSET utf8
RETURN REPLACE(SUBSTRING(SUBSTRING_INDEX(x, delim, pos),
    LENGTH(SUBSTRING_INDEX(x, delim, pos -1)) + 1),
    delim, '')
;;
DELIMITER ;
