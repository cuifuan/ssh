/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : ssh

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 10/06/2018 16:32:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sysuser
-- ----------------------------
DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logintime` bigint(20) NULL DEFAULT NULL,
  `loginout` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysuser
-- ----------------------------
INSERT INTO `sysuser` VALUES (1, 'admin', '123456', NULL, NULL);
INSERT INTO `sysuser` VALUES (2, 'test1', '1111', NULL, NULL);
INSERT INTO `sysuser` VALUES (3, '444', '1111', NULL, NULL);
INSERT INTO `sysuser` VALUES (4, '1111', '22sl/kdnsiuc', NULL, NULL);
INSERT INTO `sysuser` VALUES (5, 'hjhvjvv', 'kjvjkv', NULL, NULL);
INSERT INTO `sysuser` VALUES (6, 'jvjvjvj', 'jhvjvj', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
