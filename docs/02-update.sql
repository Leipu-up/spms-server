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
