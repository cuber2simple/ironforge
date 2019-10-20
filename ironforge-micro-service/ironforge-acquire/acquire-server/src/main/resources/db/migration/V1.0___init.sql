CREATE TABLE IF NOT EXISTS t_acquire_order (
    id                      VARCHAR(64) not null,
    origin_id               VARCHAR(64) not null,
    merchant_id             VARCHAR(64) not null,
    customer_id             VARCHAR(64) not null,
    reference_id            VARCHAR(256) not null,
    origin_reference_id     VARCHAR(256) not null,
    order_type              VARCHAR(32) not null,
    amount                  numeric(24,6) not null,
    currency                VARCHAR(6),
    available_amount        numeric(24,6) not null,
    platform                VARCHAR(32),
    country_code            VARCHAR(32),
    device_fingerprint      VARCHAR(256),
    pay_method              VARCHAR(256),
    interaction_method      VARCHAR(256),
    locale                  VARCHAR(256),
    return_url              varchar(256),
    merchant_setting_code   VARCHAR(256),
    status                  VARCHAR(64),
    update_user_id          VARCHAR(64),
    create_user_id          VARCHAR(64),
    update_datetime         TIMESTAMP WITHOUT TIME ZONE,
    create_datetime         TIMESTAMP WITHOUT TIME ZONE
);

comment on table  t_acquire_order						    is '用户表/暂不考虑';
comment on column t_acquire_order.id						is '用户ID';
comment on column t_acquire_order.merchant_id               is '商户id';
comment on column t_acquire_order.user_id					is '用户id';
comment on column t_acquire_order.user_type					is 'operator/client 操作员/机器';
comment on column t_acquire_order.user_name					is '用户名称';
comment on column t_acquire_order.password					is '密码';
comment on column t_acquire_order.nick_name				    is '昵称';
comment on column t_acquire_order.email					    is '邮箱';
comment on column t_acquire_order.phone					    is '电话号码';
comment on column t_acquire_order.employee_no			    is '员工号';
comment on column t_acquire_order.avatar					is '用户头像';
comment on column t_acquire_order.status              	    is '状态';
comment on column t_acquire_order.update_user_id			is '更新操作员';
comment on column t_acquire_order.create_user_id			is '创建操作员';
comment on column t_acquire_order.update_datetime		    is '更新时间';
comment on column t_acquire_order.create_datetime		    is '创建时间';

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

