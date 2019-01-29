CREATE TABLE `ry`.`t_crm_base_info`  (
  `id` int(255) NOT NULL auto_increment COMMENT '主键',
  `name` varchar(255) NULL COMMENT '客户名称',
  `code` varchar(255) NULL COMMENT '客户编码',
  `org_type` varchar(255) NULL COMMENT '组织类型(是人还是企业)',
  `custom_contact` varchar(255) NULL COMMENT '客户方联系人',
  `custom_contact_phone` varchar(255) NULL COMMENT '联系人联系方式',
  `contact` varchar(255) NULL,
  `contact_phone` varchar(255) NULL COMMENT '我方联系人联系方式',
  `type` varchar(255) NULL COMMENT '类别(是客户还是供应商)',
  `status` varchar(255) NULL COMMENT '合作状态',
  PRIMARY KEY (`id`)
) COMMENT='客户关系管理' ;



-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户关系管理', '0', '4', '#', 'C', '0', 'system:crmBaseInfo:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '客户关系管理菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户列表', @parentId, '1', '/system/crmBaseInfo', 'C', '0', 'system:crmBaseInfo:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '客户关系管理菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户关系管理查询', @parentId, '1',  '#',  'F', '0', 'system:crmBaseInfo:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户关系管理新增', @parentId, '2',  '#',  'F', '0', 'system:crmBaseInfo:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户关系管理修改', @parentId, '3',  '#',  'F', '0', 'system:crmBaseInfo:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户关系管理删除', @parentId, '4',  '#',  'F', '0', 'system:crmBaseInfo:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
