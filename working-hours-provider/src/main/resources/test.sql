/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 26/07/2018 18:28:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `requirement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent` tinyint(4) NULL DEFAULT NULL,
  `priority` tinyint(255) NULL DEFAULT NULL,
  `dock_prod` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dock_r_d` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `working_hours` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES (1, '系统设计', 1, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `info` VALUES (2, '数据库设计，方案讨论', 0, NULL, '黄航丹', '张悦，李嘉琳', '4', '43293', '43294', '每人2天');
INSERT INTO `info` VALUES (3, 'MQ，JSF接口设计（与mancms，shop端），接口文档输出', 0, NULL, '黄航丹', '张悦，李嘉琳', '3', '43297', '43298', '每人1.5天');
INSERT INTO `info` VALUES (4, '系统间交互流程图设计', 0, NULL, '黄航丹', '张悦', '1', '43298', '43299', NULL);
INSERT INTO `info` VALUES (5, '业务流程图设计', 0, NULL, '黄航丹', '张悦，李嘉琳', '2', '43299', '43300', '每人1天');
INSERT INTO `info` VALUES (6, '设计评审', 0, NULL, '黄航丹', '张悦，李嘉琳，武洋，赵昆仑', '2', '43300', '43300', '每人0.5天');
INSERT INTO `info` VALUES (7, '活动管理', 1, 2, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `info` VALUES (8, '在活动管理-精品活动中增加京享惠活动管理入口', 0, NULL, '黄航丹', '赵昆仑', '1', '43301', '43301', NULL);
INSERT INTO `info` VALUES (9, '权限：只有在频道运营审核组内的erp才可见该卡片入口', 0, NULL, '黄航丹', '赵昆仑', '1', '43304', '43304', NULL);
INSERT INTO `info` VALUES (10, '活动管理分为3个tab：批次设置、资质设置、审核管理；', 0, NULL, '黄航丹', '赵昆仑', '1', '43305', '43305', NULL);
INSERT INTO `info` VALUES (11, '活动名称：京享惠；区块名称：品牌品类；', 0, NULL, '黄航丹', '赵昆仑', '1', '43306', '43306', NULL);
INSERT INTO `info` VALUES (12, '右侧展示审核组管理按钮，点击可跳转至审核组列表；', 0, NULL, '黄航丹', '赵昆仑', '1', '43307', '43307', NULL);
INSERT INTO `info` VALUES (13, '审核组管理', 1, 3, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `info` VALUES (14, '表格内无频道名称及筛选框；平台运营组，由超级管理员进行添加，暂时不绑定审核组', 0, NULL, '黄航丹', '张悦', '2', '43301', '43304', NULL);
INSERT INTO `info` VALUES (15, '      频道运营有权限增加一级审核组', 0, NULL, '黄航丹', '张悦', '2', '43305', '43306', NULL);
INSERT INTO `info` VALUES (16, '批次设置', 1, 4, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `info` VALUES (17, '新建批次', 0, NULL, '黄航丹', '赵昆仑', '1', '43308', '43308', NULL);
INSERT INTO `info` VALUES (18, '批量新建批次', 0, NULL, '黄航丹', '赵昆仑', '1', '43311', '43311', NULL);
INSERT INTO `info` VALUES (19, '批次列表页', 0, NULL, '黄航丹', '赵昆仑', '1', '43312', '43312', NULL);
INSERT INTO `info` VALUES (20, '资源位设置，资源位导入', 0, NULL, '黄航丹', '赵昆仑', '1.5', '43313', '43314', NULL);
INSERT INTO `info` VALUES (21, '资质设置', 1, 5, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `info` VALUES (22, '资质设置', 0, NULL, '黄航丹', '赵昆仑', '2', '43314', '43318', NULL);
INSERT INTO `info` VALUES (23, '报名', 1, 6, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `info` VALUES (24, '提报系统报名：审核组部门内的erp和其名下商家均可报名', 0, NULL, '黄航丹', '武洋', '1.5', '43301', '43304', NULL);
INSERT INTO `info` VALUES (25, 'man端，shop端报名日历逻辑修改，并联调', 0, NULL, '黄航丹', '武洋', '4', '43304', '43308', NULL);
INSERT INTO `info` VALUES (26, '从cms调取归属分类接口，并联调', 0, NULL, '黄航丹', '李嘉琳', '1.5', '43300', '43301', NULL);
INSERT INTO `info` VALUES (27, 'man端，shop端录入活动信息，校验，联调', 0, NULL, '黄航丹', '李嘉琳', '3', '43301', '43306', NULL);
INSERT INTO `info` VALUES (28, 'man端，shop端单品促销报名，校验（包括促销有效性校验），联调', 0, NULL, '黄航丹', '李嘉琳', '5', '43306', '43313', NULL);
INSERT INTO `info` VALUES (29, 'man端，shop端总价促销报名，校验（包括促销有效性校验），联调', 0, NULL, '黄航丹', '李嘉琳', '4', '43313', '43319', NULL);
INSERT INTO `info` VALUES (30, '已报名', 1, 7, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `info` VALUES (31, 'man,shop端已报名列表，并联调', 0, NULL, '黄航丹', '张悦', '2.5', '43307', '43311', NULL);
INSERT INTO `info` VALUES (32, 'man,shop端展示所有报名的活动信息和单品促销商品信息，并联调', 0, NULL, '黄航丹', '张悦', '4', '43311', '43315', NULL);
INSERT INTO `info` VALUES (33, 'man,shop端展示所有报名的活动信息和总价促销商品信息，并联调', 0, NULL, '黄航丹', '张悦', '2', '43315', '43319', NULL);
INSERT INTO `info` VALUES (34, '单品促销下载', 0, NULL, '黄航丹', '赵昆仑', '2', '43318', '43320', NULL);
INSERT INTO `info` VALUES (35, '总价促销下载', 0, NULL, '黄航丹', '赵昆仑', '1', '43320', '43321', NULL);
INSERT INTO `info` VALUES (36, '审核', 1, 8, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `info` VALUES (37, '审核列表页开发，筛选项开发，接收促销删除MQ', 0, NULL, '黄航丹', '武洋', '3', '43308', '43313', NULL);
INSERT INTO `info` VALUES (38, '历史审核列表页开发，筛选项开发', 0, NULL, '黄航丹', '武洋', '1', '43313', '43314', NULL);
INSERT INTO `info` VALUES (39, '资源数限制，小绿点', 0, NULL, '黄航丹', '武洋', '1', '43314', '43315', NULL);
INSERT INTO `info` VALUES (40, '资源使用情况开发', 0, NULL, '黄航丹', '武洋', '2', '43315', '43319', NULL);
INSERT INTO `info` VALUES (41, '数据导出', 0, NULL, '黄航丹', '武洋', '2.5', '43319', '43321', NULL);
INSERT INTO `info` VALUES (42, '信息传递', 1, 9, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `info` VALUES (43, '频道运营审核通过后，将所有报名信息传递给mancms，并联调；接收mancms 下线通知MQ，并联调', 0, NULL, '黄航丹', '李嘉琳，张悦', '2.5', '43319', '43321', NULL);
INSERT INTO `info` VALUES (44, '代码评审', 1, 10, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `info` VALUES (45, '代码评审及修改', 0, NULL, '黄航丹', '张悦，李嘉琳，武洋，赵昆仑', '4', '43322', '43322', '每人1天');

SET FOREIGN_KEY_CHECKS = 1;
