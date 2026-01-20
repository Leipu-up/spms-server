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
