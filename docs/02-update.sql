-- 修改的脚本(一般为alter字段, 同时记得init脚本中的一致)

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1768375936750, 553, 364, 1768375971314, '机加产品表管理-导出', 'Jjcpbgl_export');
INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1768376002898, 554, 363, 1768376002900, '机加工序表管理-导出', 'Jjgxbgl_export');
INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1768376035826, 555, 353, 1768376035828, '小程序用户管理-导出', 'Wxyh_export');
INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1768376066399, 556, 340, 1768376066400, '机加工序检查表-导出', 'Jjgxjcb_export');

commit;


INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933144920, 360, 353, 1765938768375, '小程序用户_不分页查询', 'Wxyh_getList');
INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933024543, 355, 353, 1765938794390, '小程序用户-修改', 'Wxyh-update');
INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933117515, 359, 353, 1765938773347, '小程序用户-分页查询', 'Wxyh_getPage');
INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933047910, 356, 353, 1765938789534, '小程序用户-删除', 'Wxyh_delete');
INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933070829, 357, 353, 1765938784205, '小程序用户-启用', 'Wxyh_enable');
INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933168787, 361, 353, 1765938761231, '小程序用户-查询详情', 'Wxyh_getDetail');
INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765932979076, 354, 353, 1765938800099, '小程序用户-添加', 'Wxyh_add');
INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933092380, 358, 353, 1765938778787, '小程序用户-禁用', 'Wxyh_disable');
INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765932939234, 353, 0, 1765938305801, '小程序用户管理', 'Wxyh');

commit;


INSERT INTO spms.menu
(is_disabled, is_published, order_no, create_time, id, parent_id, update_time, name, component, icon, `path`)
VALUES(0, 0, 100, 1765441934099, 43, 0, 1765441934099, '小程序管理', '', '', '');
INSERT INTO spms.menu
(is_disabled, is_published, order_no, create_time, id, parent_id, update_time, name, component, icon, `path`)
VALUES(0, 0, 1, 1765442065042, 44, 43, 1765932776944, '小程序用户管理', '', '', '/console/vx/wxyh/list');
INSERT INTO spms.menu
(is_disabled, is_published, order_no, create_time, id, parent_id, update_time, name, component, icon, `path`)
VALUES(0, 0, 2, 1765870231947, 46, 43, 1765870231947, '机加工序检查表', '', '', '/console/vx/jjgxjcb/list');
INSERT INTO spms.menu
(is_disabled, is_published, order_no, create_time, id, parent_id, update_time, name, component, icon, `path`)
VALUES(0, 0, 1, 1765940128624, 47, 43, 1765940128624, '机加工序表管理', '', '', '/console/vx/jjgxbgl/list');
INSERT INTO spms.menu
(is_disabled, is_published, order_no, create_time, id, parent_id, update_time, name, component, icon, `path`)
VALUES(0, 0, 1, 1765940182660, 48, 43, 1765940182660, '机加产品表管理', '', '', '/console/vx/jjcpbgl/list');

commit;



DROP TABLE IF EXISTS `jjtzb`;
CREATE TABLE `jjtzb` (
                         `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
                         `create_time` bigint(20) unsigned DEFAULT '0' COMMENT '创建时间',
                         `update_time` bigint(20) unsigned DEFAULT '0' COMMENT '修改时间',
                         `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '标题',
                         `time` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '时间',
                         `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '内容',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci  COMMENT='机加通知表';


----------------------0311----------------

DROP TABLE IF EXISTS `jjgxjcdjb`;
CREATE TABLE `jjgxjcdjb` (
                             `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `create_time` bigint(20) unsigned DEFAULT '0' COMMENT '创建时间',
                             `update_time` bigint(20) unsigned DEFAULT '0' COMMENT '修改时间',
                             `djscz` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '刀具实测值',
                             `jjgxjcb_id` bigint(20) unsigned NOT NULL  COMMENT '机加工序检查表id',
                             `jjgxxqbgl_id` bigint(20) unsigned NOT NULL  COMMENT '机加工序详情表id',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='机加工序检查换刀表';


DROP TABLE IF EXISTS `jjwxjcb`;
CREATE TABLE `jjwxjcb` (
                           `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
                           `create_time` bigint(20) unsigned DEFAULT '0' COMMENT '创建时间',
                           `update_time` bigint(20) unsigned DEFAULT '0' COMMENT '修改时间',
                           `gysmc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '供应商名称',
                           `jjcpbgl_id` bigint(20) unsigned NOT NULL  COMMENT '机加产品表管理id',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci  COMMENT='机加外协检查表';

DROP TABLE IF EXISTS `jjwxjcxxb`;
CREATE TABLE `jjwxjcxxb` (
                             `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `create_time` bigint(20) unsigned DEFAULT '0' COMMENT '创建时间',
                             `update_time` bigint(20) unsigned DEFAULT '0' COMMENT '修改时间',
                             `xh` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '序号',
                             `gfgc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '规范/公差',
                             `tstx` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '特殊特性',
                             `yq` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '仪器',
                             `ypsl` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '样品数量',
                             `jjwxjcb_id` bigint(20) unsigned NOT NULL   COMMENT '机加外协检查表id',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci  COMMENT='机加外协检查详情表';


DROP TABLE IF EXISTS `jjwxjcjgb`;
CREATE TABLE `jjwxjcjgb` (
                           `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
                           `create_time` bigint(20) unsigned DEFAULT '0' COMMENT '创建时间',
                           `update_time` bigint(20) unsigned DEFAULT '0' COMMENT '修改时间',
                           `pch` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '批次号',
                           `jyy_id` bigint(20) unsigned NOT NULL  COMMENT '检验员id',
                           `rq` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '日期',
                           `phsl` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '批货数量',
                           `ccslwg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '抽查数量外观',
                           `ccslcc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '抽查数量尺寸',
                           `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '状态(0:待完成,1:已完成)',
                           `pdjg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '判定结果',
                           `bz` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '备注',
                           `jjwxjcb_id` bigint(20) unsigned NOT NULL  COMMENT '机加外协检查表id',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='机加外协检查结果表';

DROP TABLE IF EXISTS `jjwxjcjgxxb`;
CREATE TABLE `jjwxjcjgxxb` (
                             `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `create_time` bigint(20) unsigned DEFAULT '0' COMMENT '创建时间',
                             `update_time` bigint(20) unsigned DEFAULT '0' COMMENT '修改时间',
                             `scz` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '实测值',
                             `jjwxjcjgb_id` bigint(20) unsigned NOT NULL  COMMENT '机加外协检查结果表id',
                             `jjwxjcb_id` bigint(20) unsigned NOT NULL  COMMENT '机加外协检查id',
                             `jjwxjcxxb_id` bigint(20) unsigned NOT NULL  COMMENT '机加外协检查详情表id',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='机加外协检查结果详情表';



INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933144920, 560, 557, 1765938768375, '机加外协检查表_不分页查询', 'Jjwxjcb_getList');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933024543, 561, 557, 1765938794390, '机加外协检查表-修改', 'Jjwxjcb_update');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933117515, 562, 557, 1765938773347, '机加外协检查表-分页查询', 'Jjwxjcb_getPage');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933047910, 563, 557, 1765938789534, '机加外协检查表-删除', 'Jjwxjcb_delete');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933070829, 564, 557, 1765938784205, '机加外协检查表-启用', 'Jjwxjcb_enable');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933168787, 565, 557, 1765938761231, '机加外协检查表-查询详情', 'Jjwxjcb_getDetail');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765932979076, 567, 557, 1765938800099, '机加外协检查表-添加', 'Jjwxjcb_add');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933092380, 568, 557, 1765938778787, '机加外协检查表-禁用', 'Jjwxjcb_disable');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765932939234, 557, 0, 1765938305801, '机加外协检查表', 'Jjwxjcb');

commit;


INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933144920, 570, 558, 1765938768375, '机加外协检查详细表_不分页查询', 'Jjwxjcjgb_getList');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933024543, 571, 558, 1765938794390, '机加外协检查详细表-修改', 'Jjwxjcjgb_update');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933117515, 572, 558, 1765938773347, '机加外协检查详细表-分页查询', 'Jjwxjcjgb_getPage');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933047910, 573, 558, 1765938789534, '机加外协检查详细表-删除', 'Jjwxjcjgb_delete');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933070829, 574, 558, 1765938784205, '机加外协检查详细表-启用', 'Jjwxjcjgb_enable');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933168787, 575, 558, 1765938761231, '机加外协检查详细表-查询详情', 'Jjwxjcjgb_getDetail');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765932979076, 576, 558, 1765938800099, '机加外协检查详细表-添加', 'Jjwxjcjgb_add');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933092380, 577, 558, 1765938778787, '机加外协检查详细表-禁用', 'Jjwxjcjgb_disable');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765932939234, 578, 0, 1765938305801, '机加外协检查详细表', 'Jjwxjcjgb');

commit;




DROP TABLE IF EXISTS `jjcljcb`;
CREATE TABLE `jjcljcb` (
                           `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
                           `create_time` bigint(20) unsigned DEFAULT '0' COMMENT '创建时间',
                           `update_time` bigint(20) unsigned DEFAULT '0' COMMENT '修改时间',
                           `gysmc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '供应商名称',
                           `jjcpbgl_id` bigint(20) unsigned NOT NULL  COMMENT '机加产品表管理id',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci  COMMENT='机加材料检查表';

DROP TABLE IF EXISTS `jjcljcxxb`;
CREATE TABLE `jjcljcxxb` (
                             `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `create_time` bigint(20) unsigned DEFAULT '0' COMMENT '创建时间',
                             `update_time` bigint(20) unsigned DEFAULT '0' COMMENT '修改时间',
                             `xh` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '序号',
                             `jcxm` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '检查项目',
                             `gfgc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '规范/公差',
                             `yq` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '仪器',
                             `ypsl` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '样品数量',
                             `jjcljcb_id` bigint(20) unsigned NOT NULL   COMMENT '机加材料检查表id',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci  COMMENT='机加材料检查详情表';


DROP TABLE IF EXISTS `jjcljcjgb`;
CREATE TABLE `jjcljcjgb` (
                             `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `create_time` bigint(20) unsigned DEFAULT '0' COMMENT '创建时间',
                             `update_time` bigint(20) unsigned DEFAULT '0' COMMENT '修改时间',
                             `pch` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '批货号',
                             `jyy_id` bigint(20) unsigned NOT NULL  COMMENT '检验员id',
                             `rq` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '日期',
                             `phsl` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '批货数量',
                             `lh` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '炉号',
                             `srr` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '受入日',
                             `jcr` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '检查日',
                             `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '状态(0:待完成,1:已完成)',
                             `czzm` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '材质证明',
                             `rohs` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT 'ROHS',
                             `chbg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '出货报告',
                             `pdjg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '判定结果',
                             `bz` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '备注',
                             `jjcljcb_id` bigint(20) unsigned NOT NULL  COMMENT '机加外协检查表id',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='机加材料检查结果表';

DROP TABLE IF EXISTS `jjcljcjgxxb`;
CREATE TABLE `jjcljcjgxxb` (
                               `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
                               `create_time` bigint(20) unsigned DEFAULT '0' COMMENT '创建时间',
                               `update_time` bigint(20) unsigned DEFAULT '0' COMMENT '修改时间',
                               `scz` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '实测值',
                               `jjcljcjgb_id` bigint(20) unsigned NOT NULL  COMMENT '机加材料检查结果表id',
                               `jjcljcb_id` bigint(20) unsigned NOT NULL  COMMENT '机加材料检查id',
                               `jjcljcxxb_id` bigint(20) unsigned NOT NULL  COMMENT '机加材料检查详情表id',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='机加材料检查结果详情表';




INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933144920, 591, 590, 1765938768375, '机加材料检查表_不分页查询', 'Jjcljcb_getList');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933024543, 592, 590, 1765938794390, '机加材料检查表-修改', 'Jjcljcb_update');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933117515, 593, 590, 1765938773347, '机加材料检查表-分页查询', 'Jjcljcb_getPage');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933047910, 594, 590, 1765938789534, '机加材料检查表-删除', 'Jjcljcb_delete');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933070829, 595, 590, 1765938784205, '机加材料检查表-启用', 'Jjcljcb_enable');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933168787, 596, 590, 1765938761231, '机加材料检查表-查询详情', 'Jjcljcb_getDetail');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765932979076, 597, 590, 1765938800099, '机加材料检查表-添加', 'Jjcljcb_add');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933092380, 598, 590, 1765938778787, '机加材料检查表-禁用', 'Jjcljcb_disable');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765932939234, 590, 0, 1765938305801, '机加材料检查表', 'Jjcljcb');

commit;


INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933144920, 581, 580, 1765938768375, '机加材料检查详细表_不分页查询', 'Jjcljcjgb_getList');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933024543, 582, 580, 1765938794390, '机加材料检查详细表-修改', 'Jjcljcjgb_update');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933117515, 583, 580, 1765938773347, '机加材料检查详细表-分页查询', 'Jjcljcjgb_getPage');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933047910, 584, 580, 1765938789534, '机加材料检查详细表-删除', 'Jjcljcjgb_delete');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933070829, 585, 580, 1765938784205, '机加材料检查详细表-启用', 'Jjcljcjgb_enable');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933168787, 586, 580, 1765938761231, '机加材料检查详细表-查询详情', 'JjcljcjgbgetDetail');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765932979076, 587, 580, 1765938800099, '机加材料检查详细表-添加', 'Jjcljcjgb_add');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765933092380, 588, 580, 1765938778787, '机加材料检查详细表-禁用', 'Jjcljcjgb_disable');

INSERT INTO spms.permission
(is_disabled, is_published, is_system, `type`, create_time, id, parent_id, update_time, name, `identity`)
VALUES(0, 0, 0, 0, 1765932939234, 580, 0, 1765938305801, '机加材料检查详细表', 'Jjcljcjgb');

commit;

