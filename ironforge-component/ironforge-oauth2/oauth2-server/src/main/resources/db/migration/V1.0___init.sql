CREATE TABLE IF NOT EXISTS t_user (
    id                      SERIAL primary key,
    merchant_id             VARCHAR(64) not null,
    user_id                 VARCHAR(64) not null,
    user_type               VARCHAR(128) not null,
    user_name               VARCHAR(256) not null,
    password                VARCHAR(1024),
    nick_name               VARCHAR(256),
    email                   VARCHAR(256),
    phone                   VARCHAR(32),
    employee_no             VARCHAR(64),
    avatar                  VARCHAR(256),
    status                  VARCHAR(64),
    update_user_id          VARCHAR(64),
    create_user_id          VARCHAR(64),
    update_datetime         TIMESTAMP WITHOUT TIME ZONE,
    create_datetime         TIMESTAMP WITHOUT TIME ZONE
);
CREATE unique index idx_t_user_user_id ON t_user USING btree(user_id);
CREATE unique index idx_t_user_merchant_id_username ON t_user USING btree(merchant_id, user_name);
CREATE unique index idx_t_user_merchant_id_email ON t_user USING btree(merchant_id, email);

comment on table  t_user						    is '用户表/暂不考虑';
comment on column t_user.id						    is '用户ID';
comment on column t_user.merchant_id                is '商户id';
comment on column t_user.user_id					is '用户id';
comment on column t_user.user_type					is 'operator/client 操作员/机器';
comment on column t_user.user_name					is '用户名称';
comment on column t_user.password					is '密码';
comment on column t_user.nick_name				    is '昵称';
comment on column t_user.email					    is '邮箱';
comment on column t_user.phone					    is '电话号码';
comment on column t_user.employee_no			    is '员工号';
comment on column t_user.avatar					    is '用户头像';
comment on column t_user.status              	    is '状态';
comment on column t_user.update_user_id			    is '更新操作员';
comment on column t_user.create_user_id			    is '创建操作员';
comment on column t_user.update_datetime		    is '更新时间';
comment on column t_user.create_datetime		    is '创建时间';

CREATE TABLE IF NOT EXISTS t_group (
    id			            SERIAL primary key,
    group_code				VARCHAR(256),
    group_name              VARCHAR(256),
    group_desc				VARCHAR(1024),
    namespace               VARCHAR(256),
    parent_code				VARCHAR(256),
    manager_role_code       VARCHAR(64),
    avatar					VARCHAR(256),
    status					VARCHAR(64),
    update_user_id    		VARCHAR(64),
    create_user_id    		VARCHAR(64),
    expire_datetime			TIMESTAMP WITHOUT TIME ZONE,
    update_datetime         TIMESTAMP WITHOUT TIME ZONE,
    create_datetime         TIMESTAMP WITHOUT TIME ZONE
);

CREATE unique index idx_t_group_code ON t_group USING btree(group_code);
CREATE index idx_t_group_parent_code ON t_group USING btree(parent_code);

comment on table  t_group						is '组织架构表';
comment on column t_group.id					is '组织ID';
comment on column t_group.group_code			is '组织CODE';
comment on column t_group.group_name 			is '组织名称';
comment on column t_group.group_desc			is '组织别名';
comment on column t_group.namespace			    is '归属';
comment on column t_group.parent_code			is '组织父级code';
comment on column t_group.manager_role_code		is '组织父级code';
comment on column t_group.avatar				is '组织头像';
comment on column t_group.status              	is '状态';
comment on column t_group.update_user_id		is '更新操作员';
comment on column t_group.create_user_id		is '创建操作员';
comment on column t_group.update_datetime		is '更新时间';
comment on column t_group.expire_datetime		is '过期时间';
comment on column t_group.create_datetime		is '创建时间';

CREATE TABLE IF NOT EXISTS t_role (
    id					    SERIAL primary key,
    role_code				VARCHAR(256),
    role_name				VARCHAR(256),
    role_desc				VARCHAR(1024),
    namespace               VARCHAR(256),
    super_manager           VARCHAR(8),
    avatar					VARCHAR(256),
    status					VARCHAR(64),
    update_user_id    		VARCHAR(64),
    create_user_id    		VARCHAR(64),
    expire_datetime			TIMESTAMP WITHOUT TIME ZONE,
    update_datetime         TIMESTAMP WITHOUT TIME ZONE,
    create_datetime         TIMESTAMP WITHOUT TIME ZONE
);

CREATE UNIQUE INDEX idx_t_role_code ON t_role USING btree(role_code);

comment on table  t_role						is '角色';
comment on column t_role.id						is '角色ID';
comment on column t_role.role_code				is '角色编码';
comment on column t_role.role_name				is '角色名';
comment on column t_role.role_desc 			    is '角色描述';
comment on column t_role.super_manager			is 'true,false是否超级管理员';
comment on column t_role.avatar					is '角色头像';
comment on column t_role.status              	is '状态';
comment on column t_role.update_user_id			is '更新操作员';
comment on column t_role.create_user_id			is '创建操作员';
comment on column t_role.update_datetime		is '更新时间';
comment on column t_role.expire_datetime		is '过期时间';
comment on column t_role.create_datetime		is '创建时间';

CREATE TABLE IF NOT EXISTS t_group_role (
    id					    SERIAL primary key,
    group_code				VARCHAR(64),
    role_code				VARCHAR(256),
    status					VARCHAR(64),
    update_user_id    		VARCHAR(64),
    create_user_id    		VARCHAR(64),
    expire_datetime			TIMESTAMP WITHOUT TIME ZONE,
    update_datetime         TIMESTAMP WITHOUT TIME ZONE,
    create_datetime         TIMESTAMP WITHOUT TIME ZONE
);

CREATE UNIQUE INDEX idx_t_group_role ON t_group_role USING btree(group_code, role_code);

comment on table  t_group_role						is '组内角色关联表';
comment on column t_group_role.id					is '关联ID';
comment on column t_group_role.group_code			is '组CODE';
comment on column t_group_role.role_code			is '角色编码';
comment on column t_group_role.status              	is '状态';
comment on column t_group_role.update_user_id		is '更新操作员';
comment on column t_group_role.create_user_id		is '创建操作员';
comment on column t_group_role.update_datetime		is '更新时间';
comment on column t_group_role.expire_datetime		is '过期时间';
comment on column t_group_role.create_datetime		is '创建时间';

CREATE TABLE IF NOT EXISTS t_user_role (
   id					    SERIAL primary key,
   user_id				    VARCHAR(64),
   role_code				VARCHAR(256),
   status					VARCHAR(64),
   update_user_id    		VARCHAR(64),
   create_user_id    		VARCHAR(64),
   expire_datetime			TIMESTAMP WITHOUT TIME ZONE,
   update_datetime          TIMESTAMP WITHOUT TIME ZONE,
   create_datetime          TIMESTAMP WITHOUT TIME ZONE
);

CREATE UNIQUE INDEX idx_t_user_role ON t_user_role USING btree(user_id, role_code);

comment on table  t_user_role						is '用户角色关联表';
comment on column t_user_role.id					is '关联ID';
comment on column t_user_role.user_id				is '用户ID';
comment on column t_user_role.role_code				is '角色编码';
comment on column t_user_role.status              	is '状态';
comment on column t_user_role.update_user_id		is '更新操作员';
comment on column t_user_role.create_user_id		is '创建操作员';
comment on column t_user_role.update_datetime		is '更新时间';
comment on column t_user_role.expire_datetime		is '过期时间';
comment on column t_user_role.create_datetime		is '创建时间';

CREATE TABLE IF NOT EXISTS t_resource (
    id					    SERIAL primary key,
    resource_code			VARCHAR(64),
    resource_name			VARCHAR(256),
    resource_desc			VARCHAR(1024),
    resource_type           VARCHAR(64),
    namespace               VARCHAR(256),
    url					    VARCHAR(1024),
    avatar					VARCHAR(256),
    icon					VARCHAR(128),
    status					VARCHAR(64),
    update_user_id    		VARCHAR(64),
    create_user_id    		VARCHAR(64),
    expire_datetime			TIMESTAMP WITHOUT TIME ZONE,
    update_datetime         TIMESTAMP WITHOUT TIME ZONE,
    create_datetime         TIMESTAMP WITHOUT TIME ZONE
);

CREATE UNIQUE INDEX idx_t_resource_code ON t_resource USING btree(resource_code);

comment on table  t_resource						is '资源表';
comment on column t_resource.id						is '资源表ID';
comment on column t_resource.resource_code			is '资源CODE';
comment on column t_resource.resource_name			is '资源名称';
comment on column t_resource.resource_desc 			is '资源描述';
comment on column t_resource.namespace 			    is 'POSS/MPS';
comment on column t_resource.resource_type 			is 'menu/page/element/api';
comment on column t_resource.url 					is '资源路径';
comment on column t_resource.avatar					is '资源头像';
comment on column t_resource.icon					is '菜单图标';
comment on column t_resource.status              	is '状态';
comment on column t_resource.update_user_id			is '更新操作员';
comment on column t_resource.create_user_id			is '创建操作员';
comment on column t_resource.update_datetime		is '更新时间';
comment on column t_resource.expire_datetime		is '过期时间';
comment on column t_resource.create_datetime		is '创建时间';

CREATE TABLE IF NOT EXISTS t_resource_tree (
    id					    SERIAL primary key,
    resource_code			VARCHAR(64),
    sub_resource_code		VARCHAR(64),
    sort_index              int,
    status					VARCHAR(64),
    update_user_id    		VARCHAR(64),
    create_user_id    		VARCHAR(64),
    expire_datetime			TIMESTAMP WITHOUT TIME ZONE,
    update_datetime         TIMESTAMP WITHOUT TIME ZONE,
    create_datetime         TIMESTAMP WITHOUT TIME ZONE
);

CREATE UNIQUE INDEX idx_t_resource_tree ON t_resource_tree USING btree(resource_code, sub_resource_code);

comment on table  t_resource_tree						is '资源树';
comment on column t_resource_tree.id					is '树ID';
comment on column t_resource_tree.resource_code			is '资源CODE';
comment on column t_resource_tree.sub_resource_code		is '资源子CODE';
comment on column t_resource_tree.sort_index		    is '排序';
comment on column t_resource_tree.status              	is '状态';
comment on column t_resource_tree.update_user_id		is '更新操作员';
comment on column t_resource_tree.create_user_id		is '创建操作员';
comment on column t_resource_tree.update_datetime		is '更新时间';
comment on column t_resource_tree.expire_datetime		is '过期时间';
comment on column t_resource_tree.create_datetime		is '创建时间';

CREATE TABLE IF NOT EXISTS t_resource_role (
    id					    SERIAL primary key,
    resource_code			VARCHAR(64),
    role_code				VARCHAR(256),
    status					VARCHAR(64),
    update_user_id    		VARCHAR(64),
    create_user_id    		VARCHAR(64),
    expire_datetime			TIMESTAMP WITHOUT TIME ZONE,
    update_datetime         TIMESTAMP WITHOUT TIME ZONE,
    create_datetime         TIMESTAMP WITHOUT TIME ZONE
);

CREATE UNIQUE INDEX idx_t_resource_role ON t_resource_role USING btree(resource_code, role_code);

comment on table  t_resource_role						is '资源角色关联表';
comment on column t_resource_role.id					is '关联ID';
comment on column t_resource_role.resource_code			is '资源CODE';
comment on column t_resource_role.role_code				is '角色编码';
comment on column t_resource_role.status              	is '状态';
comment on column t_resource_role.update_user_id		is '更新操作员';
comment on column t_resource_role.create_user_id		is '创建操作员';
comment on column t_resource_role.update_datetime		is '更新时间';
comment on column t_resource_role.expire_datetime		is '过期时间';
comment on column t_resource_role.create_datetime		is '创建时间';

CREATE TABLE IF NOT EXISTS t_user_client (
    id					    SERIAL primary key,
    user_id                 VARCHAR(64),
    app_id  				VARCHAR(64),
    app_secret				VARCHAR(256),
    rsa_public_key          VARCHAR(2048),
    rsa_private_key         VARCHAR(2048),
    access_token_validity   INTEGER,
    refresh_token_validity  INTEGER,
    notice_channel_url      VARCHAR(2048),
    status					VARCHAR(64),
    update_user_id    		VARCHAR(64),
    create_user_id    		VARCHAR(64),
    expire_datetime			TIMESTAMP WITHOUT TIME ZONE,
    update_datetime         TIMESTAMP WITHOUT TIME ZONE,
    create_datetime         TIMESTAMP WITHOUT TIME ZONE
);

CREATE UNIQUE INDEX idx_t_user_client_user_id ON t_user_client USING btree(user_id);

CREATE UNIQUE INDEX idx_t_user_client_app_id ON t_user_client USING btree(app_id);

comment on table  t_user_client						is '资源角色关联表';
comment on column t_user_client.id					is '关联ID';
comment on column t_user_client.user_id		        is '用户ID';
comment on column t_user_client.app_id			    is 'clientId';
comment on column t_user_client.app_secret		    is 'client密钥';
comment on column t_user_client.rsa_public_key		is 'client公钥';
comment on column t_user_client.rsa_private_key		is 'client私钥';
comment on column t_user_client.access_token_validity	is 'token过期事件';
comment on column t_user_client.refresh_token_validity	is 'refresh过期事件';
comment on column t_user_client.notice_channel_url		is '通知渠道URL';
comment on column t_user_client.status              is '状态';
comment on column t_user_client.update_user_id		is '更新操作员';
comment on column t_user_client.create_user_id		is '创建操作员';
comment on column t_user_client.update_datetime		is '更新时间';
comment on column t_user_client.expire_datetime		is '过期时间';
comment on column t_user_client.create_datetime		is '创建时间';

CREATE TABLE IF NOT EXISTS T_CLIENT_TOKEN(
    id                      VARCHAR(64) primary key,
    app_id                  VARCHAR(64) NOT NULL,
    access_token            VARCHAR(2048) NOT NULL,
    refresh_token           VARCHAR(2048),
    access_token_validity   INTEGER,
    refresh_token_validity  INTEGER,
    status					VARCHAR(64),
    update_user_id    		VARCHAR(64),
    create_user_id    		VARCHAR(64),
    expire_datetime			TIMESTAMP WITHOUT TIME ZONE,
    update_datetime         TIMESTAMP WITHOUT TIME ZONE,
    create_datetime         TIMESTAMP WITHOUT TIME ZONE
);

CREATE UNIQUE INDEX idx_t_client_token_app_id ON T_CLIENT_TOKEN USING btree(app_id);

comment on table  T_CLIENT_TOKEN						is 'token表';
comment on column T_CLIENT_TOKEN.id					    is 'ID';
comment on column T_CLIENT_TOKEN.app_id			        is 'appId';
comment on column T_CLIENT_TOKEN.access_token			is '访问的token';
comment on column T_CLIENT_TOKEN.refresh_token			is 'refresh token';
comment on column T_CLIENT_TOKEN.access_token_validity	is '过期时间(S)';
comment on column T_CLIENT_TOKEN.refresh_token_validity	is '过期时间(s)';
comment on column T_CLIENT_TOKEN.status              	is '状态';
comment on column T_CLIENT_TOKEN.update_user_id		    is '更新操作员';
comment on column T_CLIENT_TOKEN.create_user_id		    is '创建操作员';
comment on column T_CLIENT_TOKEN.update_datetime		is '更新时间';
comment on column T_CLIENT_TOKEN.expire_datetime		is '过期时间';
comment on column T_CLIENT_TOKEN.create_datetime		is '创建时间';

CREATE TABLE IF NOT EXISTS T_CLIENT_TOKEN_HIS(
    id                      VARCHAR(64) NOT NULL,
    app_id                  VARCHAR(64) NOT NULL,
    access_token            VARCHAR(2048) NOT NULL,
    refresh_token           VARCHAR(2048),
    access_token_validity   INTEGER,
    refresh_token_validity  INTEGER,
    status                  VARCHAR(64),
    update_user_id    		VARCHAR(64),
    create_user_id    		VARCHAR(64),
    expire_datetime			TIMESTAMP WITHOUT TIME ZONE,
    update_datetime         TIMESTAMP WITHOUT TIME ZONE,
    create_datetime         TIMESTAMP WITHOUT TIME ZONE
) partition by range (create_datetime);

comment on table  T_CLIENT_TOKEN_HIS                        is 'token 历史表(按照create_time分表)';
comment on column T_CLIENT_TOKEN_HIS.id                     is '生成的ID';
comment on column T_CLIENT_TOKEN_HIS.app_id                 is '客户端ID';
comment on column T_CLIENT_TOKEN_HIS.access_token           is 'token';
comment on column T_CLIENT_TOKEN_HIS.refresh_token          is 'refresh_token 暂时不可用';
comment on column T_CLIENT_TOKEN_HIS.access_token_validity  is 'access过期时长';
comment on column T_CLIENT_TOKEN_HIS.refresh_token_validity is 'refresh过期时长';
comment on column T_CLIENT_TOKEN_HIS.status              	is '状态';
comment on column T_CLIENT_TOKEN_HIS.update_user_id		    is '更新操作员';
comment on column T_CLIENT_TOKEN_HIS.create_user_id		    is '创建操作员';
comment on column T_CLIENT_TOKEN_HIS.update_datetime		is '更新时间';
comment on column T_CLIENT_TOKEN_HIS.expire_datetime		is '过期时间';
comment on column T_CLIENT_TOKEN_HIS.create_datetime		is '创建时间';

CREATE TABLE IF NOT EXISTS T_CLIENT_TOKEN_HIS_201910 partition OF T_CLIENT_TOKEN_HIS(id PRIMARY KEY,app_id,access_token,refresh_token,access_token_validity,refresh_token_validity,status,update_user_id,create_user_id,update_datetime,expire_datetime,create_datetime) for values
    FROM ('2019-10-01') to ('2019-11-01');
CREATE INDEX IF NOT EXISTS IDX_T_CLIENT_TOKEN_HIS_201910_app_id ON T_CLIENT_TOKEN_HIS_201910 USING btree(app_id);
CREATE INDEX IF NOT EXISTS IDX_T_CLIENT_TOKEN_HIS_201910_CREATE_DATETIME ON T_CLIENT_TOKEN_HIS_201910 USING btree(create_datetime);

CREATE TABLE IF NOT EXISTS T_CLIENT_TOKEN_HIS_201911 partition OF T_CLIENT_TOKEN_HIS(id PRIMARY KEY,app_id,access_token,refresh_token,access_token_validity,refresh_token_validity,status,update_user_id,create_user_id,update_datetime,expire_datetime,create_datetime) for values
    FROM ('2019-11-01') to ('2019-12-01');
CREATE INDEX IF NOT EXISTS IDX_T_CLIENT_TOKEN_HIS_201911_app_id ON T_CLIENT_TOKEN_HIS_201911 USING btree(app_id);
CREATE INDEX IF NOT EXISTS IDX_T_CLIENT_TOKEN_HIS_201911_CREATE_DATETIME ON T_CLIENT_TOKEN_HIS_201911 USING btree(create_datetime);

CREATE TABLE IF NOT EXISTS T_CLIENT_TOKEN_HIS_201912 partition OF T_CLIENT_TOKEN_HIS(id PRIMARY KEY,app_id,access_token,refresh_token,access_token_validity,refresh_token_validity,status,update_user_id,create_user_id,update_datetime,expire_datetime,create_datetime) for values
    FROM ('2019-12-01') to ('2020-01-01');
CREATE INDEX IF NOT EXISTS IDX_T_CLIENT_TOKEN_HIS_201912_app_id ON T_CLIENT_TOKEN_HIS_201912 USING btree(app_id);
CREATE INDEX IF NOT EXISTS IDX_T_CLIENT_TOKEN_HIS_201912_CREATE_DATETIME ON T_CLIENT_TOKEN_HIS_201912 USING btree(create_datetime);

CREATE TABLE IF NOT EXISTS T_CLIENT_TOKEN_HIS_202001 partition OF T_CLIENT_TOKEN_HIS(id PRIMARY KEY,app_id,access_token,refresh_token,access_token_validity,refresh_token_validity,status,update_user_id,create_user_id,update_datetime,expire_datetime,create_datetime) for values
    FROM ('2020-01-01') to ('2020-02-01');
CREATE INDEX IF NOT EXISTS IDX_T_CLIENT_TOKEN_HIS_202001_app_id ON T_CLIENT_TOKEN_HIS_202001 USING btree(app_id);
CREATE INDEX IF NOT EXISTS IDX_T_CLIENT_TOKEN_HIS_202001_CREATE_DATETIME ON T_CLIENT_TOKEN_HIS_202001 USING btree(create_datetime);

CREATE TABLE IF NOT EXISTS T_CLIENT_TOKEN_HIS_202002 partition OF T_CLIENT_TOKEN_HIS(id PRIMARY KEY,app_id,access_token,refresh_token,access_token_validity,refresh_token_validity,status,update_user_id,create_user_id,update_datetime,expire_datetime,create_datetime) for values
    FROM ('2020-02-01') to ('2020-03-01');
CREATE INDEX IF NOT EXISTS IDX_T_CLIENT_TOKEN_HIS_202002_app_id ON T_CLIENT_TOKEN_HIS_202002 USING btree(app_id);
CREATE INDEX  IF NOT EXISTS IDX_T_CLIENT_TOKEN_HIS_202002_CREATE_DATETIME ON T_CLIENT_TOKEN_HIS_202002 USING btree(create_datetime);

CREATE TABLE IF NOT EXISTS T_CLIENT_TOKEN_HIS_202003 partition OF T_CLIENT_TOKEN_HIS(id PRIMARY KEY,app_id,access_token,refresh_token,access_token_validity,refresh_token_validity,status,update_user_id,create_user_id,update_datetime,expire_datetime,create_datetime) for values
    FROM ('2020-03-01') to ('2020-04-01');
CREATE INDEX IF NOT EXISTS IDX_T_CLIENT_TOKEN_HIS_202003_app_id ON T_CLIENT_TOKEN_HIS_202003 USING btree(app_id);
CREATE INDEX  IF NOT EXISTS IDX_T_CLIENT_TOKEN_HIS_202003_CREATE_DATETIME ON T_CLIENT_TOKEN_HIS_202003 USING btree(create_datetime);

INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('poss_index', '首页', 'POSS首页', 'menu', 'poss.ironforge.com', '/index', 'index.jpg', 'index', null, null, null, null, null, null);
INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('poss_order', '订单中心', '订单中心', 'menu', 'poss.ironforge.com', '/order', 'order.jpg', 'order', null, null, null, null, null, null);
INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('poss_order_sale', '交易订单', '交易订单查询', 'menu_page', 'poss.ironforge.com', '/order/sale', 'order_sale.jpg', 'order_sale', null, null, null, null, null, null);
INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('poss_order_auth', '预授权订单', '预授权订单查询', 'menu_page', 'poss.ironforge.com', '/order/auth', 'order_auth.jpg', 'order_auth', null, null, null, null, null, null);
INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('poss_order_refund', '退款订单', '退款订单查询', 'menu_page', 'poss.ironforge.com', '/order/refund', 'order_refund.jpg', 'order_refund', null, null, null, null, null, null);
INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('poss_order_chargeback', '拒付订单', '拒付订单查询', 'menu_page', 'poss.ironforge.com', '/order/changeback', 'order_chargeback.jpg', 'order_chargeback', null, null, null, null, null, null);
INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('poss_channel', '渠道管理', '渠道管理', 'menu', 'poss.ironforge.com', '/channel', 'channel.jpg', 'channel', null, null, null, null, null, null);
INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('poss_channel_config', '渠道配置', '渠道配置', 'menu_page', 'poss.ironforge.com', '/channel/config', 'channel_config.jpg', 'channel_config', null, null, null, null, null, null);
INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('poss_channel_kyc', '签约进件', '签约进件', 'menu_page', 'poss.ironforge.com', '/channel/kyc', 'sign_kyc.jpg', 'sign_kyc', null, null, null, null, null, null);
INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('trade_catalog', 'API总目录', 'API总目录', 'catalog', '', '/acquire/catalog', 'trade_catalog.jpg', 'trade_catalog', null, null, null, null, '2019-10-07 15:15:58.963907', '2019-10-07 15:15:58.963907');
INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('trade_sale', '交易', '交易', 'api', '', '/acquire/sale', 'sale.jpg', 'sale', null, null, null, null, '2019-10-07 15:15:59.087835', '2019-10-07 15:15:59.087835');
INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('trade_auth', '预授权', '预授权', 'api', '', '/acquire/auth', 'auth.jpg', 'auth', null, null, null, null, '2019-10-07 15:15:59.099828', '2019-10-07 15:15:59.099828');
INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('trade_capture', '预授权完成', '预授权完成', 'api', '', '/acquire/capture', 'capture.jpg', 'capture', null, null, null, null, '2019-10-07 15:15:59.105825', '2019-10-07 15:15:59.105825');
INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('trade_refund', '退款', '退款', 'api', '', '/acquire/refund', 'refund.jpg', 'refund', null, null, null, null, '2019-10-07 15:15:59.110822', '2019-10-07 15:15:59.110822');
INSERT INTO public.t_resource (resource_code, resource_name, resource_desc, resource_type, namespace, url, avatar, icon, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ('trade_auth_void', '预授权撤销', '预授权撤销', 'api', '', '/acquire/authVoid', 'auth_void.jpg', 'auth_void', null, null, null, null, '2019-10-07 15:15:59.116819', '2019-10-07 15:15:59.116819');

INSERT INTO public.t_resource_role ( resource_code, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'index', 'role_user', null, null, null, null, null, null);
INSERT INTO public.t_resource_role ( resource_code, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_channel', 'role_order', null, null, null, null, null, null);
INSERT INTO public.t_resource_role ( resource_code, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_order_sale', 'role_order', null, null, null, null, null, null);
INSERT INTO public.t_resource_role ( resource_code, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_order_auth', 'role_order', null, null, null, null, null, null);
INSERT INTO public.t_resource_role ( resource_code, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_order_refund', 'role_order', null, null, null, null, null, null);
INSERT INTO public.t_resource_role ( resource_code, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_order_chargeback', 'role_order', null, null, null, null, null, null);
INSERT INTO public.t_resource_role ( resource_code, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_channel', 'role_channel', null, null, null, null, null, null);
INSERT INTO public.t_resource_role ( resource_code, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_channel_config', 'role_channel', null, null, null, null, null, null);
INSERT INTO public.t_resource_role ( resource_code, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_channel_kyc', 'role_channel', null, null, null, null, null, null);
INSERT INTO public.t_resource_role ( resource_code, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'trade_sale', 'role_api_trade', null, null, null, null, '2019-10-07 15:24:55.487457', '2019-10-07 15:24:55.487457');
INSERT INTO public.t_resource_role ( resource_code, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'trade_auth', 'role_api_trade', null, null, null, null, '2019-10-07 15:24:55.492454', '2019-10-07 15:24:55.492454');
INSERT INTO public.t_resource_role ( resource_code, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'trade_capture', 'role_api_trade', null, null, null, null, '2019-10-07 15:24:55.494454', '2019-10-07 15:24:55.494454');
INSERT INTO public.t_resource_role ( resource_code, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'trade_refund', 'role_api_trade', null, null, null, null, '2019-10-07 15:28:01.555141', '2019-10-07 15:28:01.555141');
INSERT INTO public.t_resource_role ( resource_code, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'trade_auth_void', 'role_api_trade', null, null, null, null, '2019-10-07 15:28:01.641092', '2019-10-07 15:28:01.641092');

INSERT INTO public.t_resource_tree ( resource_code, sub_resource_code, sort_index, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_index', 'poss_order', 0, null, null, null, null, null, null);
INSERT INTO public.t_resource_tree ( resource_code, sub_resource_code, sort_index, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_index', 'poss_channel', 1, null, null, null, null, null, null);
INSERT INTO public.t_resource_tree ( resource_code, sub_resource_code, sort_index, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_order', 'poss_order_sale', 0, null, null, null, null, null, null);
INSERT INTO public.t_resource_tree ( resource_code, sub_resource_code, sort_index, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_order', 'poss_order_auth', 1, null, null, null, null, null, null);
INSERT INTO public.t_resource_tree ( resource_code, sub_resource_code, sort_index, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_order', 'poss_order_refund', 2, null, null, null, null, null, null);
INSERT INTO public.t_resource_tree ( resource_code, sub_resource_code, sort_index, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_order', 'poss_order_chargeback', 3, null, null, null, null, null, null);
INSERT INTO public.t_resource_tree ( resource_code, sub_resource_code, sort_index, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_channel', 'poss_channel_config', 0, null, null, null, null, null, null);
INSERT INTO public.t_resource_tree ( resource_code, sub_resource_code, sort_index, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'poss_order', 'poss_channel_kyc', 1, null, null, null, null, null, null);
INSERT INTO public.t_resource_tree ( resource_code, sub_resource_code, sort_index, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'trade_catalog', 'trade_sale', 1, null, null, null, null, '2019-10-07 15:15:59.091832', '2019-10-07 15:15:59.091832');
INSERT INTO public.t_resource_tree ( resource_code, sub_resource_code, sort_index, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'trade_catalog', 'trade_auth', 2, null, null, null, null, '2019-10-07 15:15:59.102828', '2019-10-07 15:15:59.102828');
INSERT INTO public.t_resource_tree ( resource_code, sub_resource_code, sort_index, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'trade_catalog', 'trade_capture', 3, null, null, null, null, '2019-10-07 15:15:59.107824', '2019-10-07 15:15:59.107824');
INSERT INTO public.t_resource_tree ( resource_code, sub_resource_code, sort_index, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'trade_catalog', 'trade_refund', 4, null, null, null, null, '2019-10-07 15:15:59.114819', '2019-10-07 15:15:59.114819');
INSERT INTO public.t_resource_tree ( resource_code, sub_resource_code, sort_index, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'trade_catalog', 'trade_auth_void', 5, null, null, null, null, '2019-10-07 15:15:59.122815', '2019-10-07 15:15:59.122815');

INSERT INTO public.t_role ( role_code, role_name, role_desc, namespace, super_manager, avatar, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'root', '超级管理员', '超级管理员组，不可删除', 'poss.ironforge.com', 'true', null, null, null, null, null, null, null);
INSERT INTO public.t_role ( role_code, role_name, role_desc, namespace, super_manager, avatar, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'role_order', '订单组权限', '订单组权限', 'poss.ironforge.com', 'false', null, null, null, null, null, null, null);
INSERT INTO public.t_role ( role_code, role_name, role_desc, namespace, super_manager, avatar, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'role_channel', '渠道组权限', '渠道组权限', 'poss.ironforge.com', 'false', null, null, null, null, null, null, null);
INSERT INTO public.t_role ( role_code, role_name, role_desc, namespace, super_manager, avatar, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'role_user', '普通用户权限', '普通用户权限', 'poss.ironforge.com', 'false', null, null, null, null, null, null, null);
INSERT INTO public.t_role ( role_code, role_name, role_desc, namespace, super_manager, avatar, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( 'role_api_trade', 'role_api_trade', 'api权限，交易相关', '', 'false', null, null, null, null, null, '2019-10-07 15:24:55.397509', '2019-10-07 15:24:55.397509');

INSERT INTO public.t_user ( merchant_id, user_id, user_type, user_name, password, nick_name, email, phone, employee_no, avatar, status, update_user_id, create_user_id, update_datetime, create_datetime) VALUES ( '15600000001', '1560000000100000001', 'operator', 'cuber', 'aa1722ca393290ad42e043ecd21d7ec4c71592a8807afee89e7747c3e8a9d930e520ed0130e4081ceed80570b3d48a19968cae96f0efd97a19ed9fadea14b8cc', 'cuber', 'cuber.carrots@gmail.com', '13248199190', null, null, null, null, null, '2019-10-06 21:51:41.913066', '2019-10-06 21:51:41.913066');
INSERT INTO public.t_user ( merchant_id, user_id, user_type, user_name, password, nick_name, email, phone, employee_no, avatar, status, update_user_id, create_user_id, update_datetime, create_datetime) VALUES ( '15600000001', '1560000000100000002', 'operator', 'nico', '6bbc18dbedf2405579fcc1090735e86436f3b0ee10de188ecdebc3fd94e26ea14a69ac1bdb4f125e43ae3da60cf98ca51b7092c242d4f3e92165cf5cb8a5a713', 'nico', 'nico.li@gmail.com', '13248199191', null, null, null, null, null, '2019-10-06 21:51:42.965459', '2019-10-06 21:51:42.965459');
INSERT INTO public.t_user ( merchant_id, user_id, user_type, user_name, password, nick_name, email, phone, employee_no, avatar, status, update_user_id, create_user_id, update_datetime, create_datetime) VALUES ( '15600000001', '1560000000100000003', 'operator', 'faker', 'e03c008dcd41387654993ec3bf11fa661308f4cd0ee951bb028d92314a6e680017103f08dd28bbed4393224872bf6167d1b51553d43fc411d3bc9e87cf949d82', 'faker', 'faker.li@gmail.com', '13248199192', null, null, null, null, null, '2019-10-06 21:51:44.530556', '2019-10-06 21:51:44.530556');
INSERT INTO public.t_user ( merchant_id, user_id, user_type, user_name, password, nick_name, email, phone, employee_no, avatar, status, update_user_id, create_user_id, update_datetime, create_datetime) VALUES ( '15600000001', '1560000000199999999', 'client', 'client_poss', 'a303a313419fadbe671cf4fd6e147c88ccd115a73344201a465378c9c2246d3ca686d7b70483e331d615383c09cc65f055397fc2a371f4ffa122ba7afe9398ba', 'client_poss', 'client.poss@gmail.com', '13248199193', null, null, null, null, null, '2019-10-07 14:40:52.915797', '2019-10-07 14:40:52.915797');
INSERT INTO public.t_user ( merchant_id, user_id, user_type, user_name, password, nick_name, email, phone, employee_no, avatar, status, update_user_id, create_user_id, update_datetime, create_datetime) VALUES ( '15600000002', '1560000000299999999', 'client', 'client_1_merchant', 'c172793964cfcd8285537224f141380078cb0ab89d2c061af12807f73e5411071215baa5595fb2fbea8613999ff1565466d0903b4c432f682618f3593af76f40', 'client_1_merchant', 'client_1.poss@gmail.com', '13248199195', null, null, null, null, null, '2019-10-07 15:18:53.811074', '2019-10-07 15:18:53.811074');
INSERT INTO public.t_user ( merchant_id, user_id, user_type, user_name, password, nick_name, email, phone, employee_no, avatar, status, update_user_id, create_user_id, update_datetime, create_datetime) VALUES ( '15600000003', '1560000000399999999', 'client', 'client_2_merchant', 'c81a91ab23a54309ce0290f4bf81be3716c68c835d205b5a21cbe62b59da3fc49a3e7e0b70172f17aec60b8393702dd1c11202221eefc084225364a6df46f6bb', 'client_2_merchant', 'client_2.poss@gmail.com', '13248199196', null, null, null, null, null, '2019-10-07 15:18:53.901010', '2019-10-07 15:18:53.901010');

INSERT INTO public.t_user_client ( user_id, app_id, app_secret, rsa_public_key, rsa_private_key, access_token_validity, refresh_token_validity, notice_channel_url, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( '1560000000199999999', 'h1K0DfVYN4rO28', 'ce27ffb339441ba1739fa805828fd24348befd09ac94a4166d56c8581d9ddd1151d1a4664f46e2e00aa3d08d591f5221e83693fd259688ed4913e2d7f3bf3191', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCLNbmKl9/gLn7Bef/xtUkshC1WyrLZLRpXCcFYR1gQi0isWsZBTicC4efBOkkNG3r+1ue0gvtuU/tjREFGf4Y7HaKHGb5tNCOlMNeNjM5YLRwLFqrUSsQyD4rj4eua1ltearr24R0HilnTvnQm6Z/UY0s21vdOUFQBPY0GNAa+0wIDAQAB', 'MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIs1uYqX3+AufsF5//G1SSyELVbKstktGlcJwVhHWBCLSKxaxkFOJwLh58E6SQ0bev7W57SC+25T+2NEQUZ/hjsdoocZvm00I6Uw142MzlgtHAsWqtRKxDIPiuPh65rWW15quvbhHQeKWdO+dCbpn9RjSzbW905QVAE9jQY0Br7TAgMBAAECgYBcYhbzpr5no/Nyqmf0G/6nkEAWbQYrogbs5AhvcUk8EXL1DnirNhYlj42hafC4xhflrvCtlo8NNKaLxewbwN1uuzG8A2jd+ROEXlx5HDh2ZluhtHzL/SmNcJXo684xAl2pCNVBjDcW48PcIBijke/sTVHTDsDCukLKDPUOM/mKIQJBAL96k4+jBscazsJiuZ6C3RFDVtRRDpf1dMgLgxcx63bAXkA2Arau0J49IAYmSVJoDXqDoJKWdXJVh9vHSkhN/48CQQC6Hk1/G0Y0nOylf6NOp0oMgc0A+etnwxHKqwtctPKjEYcJx2fzALzTtCoySLYXX7gLnPIQXpQBTUysG5skBKp9AkEAiSQm6fqu0Q4fRlRlc+VwpnufhgPkOuw/z0OHiaZkajJPjxfgC63bl2paNG1ZmJ8UAEqkSDlhNxmRa9UqG+1ZewJASaQxz6gwCCNLM1SkfjuM/hPh1JAOh9jUUleJQF5MXx9RSho/VBQnorB3vbutaOQzw0yPLtDtSPKX8sVdhkveVQJAIDsJP5X8Tey6zXTUISor7PF0TSiKdE4k0IwKoy9y8HmQ+AU8+xyr/iOt5lvaGxKlBK8N/7yCw5H4qHnJaHT+Bg==', 7200, 86400, null, null, null, null, null, '2019-10-07 14:45:34.277929', '2019-10-07 14:45:34.277929');
INSERT INTO public.t_user_client ( user_id, app_id, app_secret, rsa_public_key, rsa_private_key, access_token_validity, refresh_token_validity, notice_channel_url, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( '1560000000299999999', 'h1K0DgfSXzcZFr', '51b4fbf93a454dce327aecdbd34be0fa3d0b176ab19febb2d58c98e01d905e48a6a21fe4c78215b0f38766ae0ff3e7236b081b66e56e4caddcf323b28850a297', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCLNbmKl9/gLn7Bef/xtUkshC1WyrLZLRpXCcFYR1gQi0isWsZBTicC4efBOkkNG3r+1ue0gvtuU/tjREFGf4Y7HaKHGb5tNCOlMNeNjM5YLRwLFqrUSsQyD4rj4eua1ltearr24R0HilnTvnQm6Z/UY0s21vdOUFQBPY0GNAa+0wIDAQAB', 'MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIs1uYqX3+AufsF5//G1SSyELVbKstktGlcJwVhHWBCLSKxaxkFOJwLh58E6SQ0bev7W57SC+25T+2NEQUZ/hjsdoocZvm00I6Uw142MzlgtHAsWqtRKxDIPiuPh65rWW15quvbhHQeKWdO+dCbpn9RjSzbW905QVAE9jQY0Br7TAgMBAAECgYBcYhbzpr5no/Nyqmf0G/6nkEAWbQYrogbs5AhvcUk8EXL1DnirNhYlj42hafC4xhflrvCtlo8NNKaLxewbwN1uuzG8A2jd+ROEXlx5HDh2ZluhtHzL/SmNcJXo684xAl2pCNVBjDcW48PcIBijke/sTVHTDsDCukLKDPUOM/mKIQJBAL96k4+jBscazsJiuZ6C3RFDVtRRDpf1dMgLgxcx63bAXkA2Arau0J49IAYmSVJoDXqDoJKWdXJVh9vHSkhN/48CQQC6Hk1/G0Y0nOylf6NOp0oMgc0A+etnwxHKqwtctPKjEYcJx2fzALzTtCoySLYXX7gLnPIQXpQBTUysG5skBKp9AkEAiSQm6fqu0Q4fRlRlc+VwpnufhgPkOuw/z0OHiaZkajJPjxfgC63bl2paNG1ZmJ8UAEqkSDlhNxmRa9UqG+1ZewJASaQxz6gwCCNLM1SkfjuM/hPh1JAOh9jUUleJQF5MXx9RSho/VBQnorB3vbutaOQzw0yPLtDtSPKX8sVdhkveVQJAIDsJP5X8Tey6zXTUISor7PF0TSiKdE4k0IwKoy9y8HmQ+AU8+xyr/iOt5lvaGxKlBK8N/7yCw5H4qHnJaHT+Bg==', 7200, 86400, null, null, null, null, null, '2019-10-07 15:18:53.895013', '2019-10-07 15:18:53.895013');
INSERT INTO public.t_user_client ( user_id, app_id, app_secret, rsa_public_key, rsa_private_key, access_token_validity, refresh_token_validity, notice_channel_url, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( '1560000000399999999', 'h1K0DhLIKz2Jre', '7834b0886519f03ff0fc1fe2039a45779063deff05a3988b993e4876e7c0ba4132663b8397fd57b3ac4e5ed239266140a90e1c5c5423dbd52acc41a1b1ddd436', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCLNbmKl9/gLn7Bef/xtUkshC1WyrLZLRpXCcFYR1gQi0isWsZBTicC4efBOkkNG3r+1ue0gvtuU/tjREFGf4Y7HaKHGb5tNCOlMNeNjM5YLRwLFqrUSsQyD4rj4eua1ltearr24R0HilnTvnQm6Z/UY0s21vdOUFQBPY0GNAa+0wIDAQAB', 'MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIs1uYqX3+AufsF5//G1SSyELVbKstktGlcJwVhHWBCLSKxaxkFOJwLh58E6SQ0bev7W57SC+25T+2NEQUZ/hjsdoocZvm00I6Uw142MzlgtHAsWqtRKxDIPiuPh65rWW15quvbhHQeKWdO+dCbpn9RjSzbW905QVAE9jQY0Br7TAgMBAAECgYBcYhbzpr5no/Nyqmf0G/6nkEAWbQYrogbs5AhvcUk8EXL1DnirNhYlj42hafC4xhflrvCtlo8NNKaLxewbwN1uuzG8A2jd+ROEXlx5HDh2ZluhtHzL/SmNcJXo684xAl2pCNVBjDcW48PcIBijke/sTVHTDsDCukLKDPUOM/mKIQJBAL96k4+jBscazsJiuZ6C3RFDVtRRDpf1dMgLgxcx63bAXkA2Arau0J49IAYmSVJoDXqDoJKWdXJVh9vHSkhN/48CQQC6Hk1/G0Y0nOylf6NOp0oMgc0A+etnwxHKqwtctPKjEYcJx2fzALzTtCoySLYXX7gLnPIQXpQBTUysG5skBKp9AkEAiSQm6fqu0Q4fRlRlc+VwpnufhgPkOuw/z0OHiaZkajJPjxfgC63bl2paNG1ZmJ8UAEqkSDlhNxmRa9UqG+1ZewJASaQxz6gwCCNLM1SkfjuM/hPh1JAOh9jUUleJQF5MXx9RSho/VBQnorB3vbutaOQzw0yPLtDtSPKX8sVdhkveVQJAIDsJP5X8Tey6zXTUISor7PF0TSiKdE4k0IwKoy9y8HmQ+AU8+xyr/iOt5lvaGxKlBK8N/7yCw5H4qHnJaHT+Bg==', 7200, 86400, null, null, null, null, null, '2019-10-07 15:18:53.903008', '2019-10-07 15:18:53.903008');

INSERT INTO public.t_user_role ( user_id, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( '1560000000100000002', 'rol e_order', null, null, null, null, '2019-10-07 12:35:16.668969', '2019-10-07 12:35:16.668969');
INSERT INTO public.t_user_role ( user_id, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( '1560000000100000002', 'role_user', null, null, null, null, '2019-10-07 12:35:16.754908', '2019-10-07 12:35:16.754908');
INSERT INTO public.t_user_role ( user_id, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( '1560000000100000003', 'role_channel', null, null, null, null, '2019-10-07 12:35:16.757907', '2019-10-07 12:35:16.757907');
INSERT INTO public.t_user_role ( user_id, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( '1560000000100000003', 'role_user', null, null, null, null, '2019-10-07 12:35:16.759905', '2019-10-07 12:35:16.759905');
INSERT INTO public.t_user_role ( user_id, role_code, status, update_user_id, create_user_id, expire_datetime, update_datetime, create_datetime) VALUES ( '1560000000299999999', 'role_api_trade', null, null, null, null, '2019-10-07 15:29:58.285813', '2019-10-07 15:29:58.285813');