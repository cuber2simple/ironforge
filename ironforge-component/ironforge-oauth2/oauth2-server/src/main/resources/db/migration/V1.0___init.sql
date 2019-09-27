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
    path					VARCHAR(1024),
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
comment on column t_role.path 					is '角色路径';
comment on column t_role.avatar					is '角色头像';
comment on column t_role.status              	is '状态';
comment on column t_role.update_user_id			is '更新操作员';
comment on column t_role.create_user_id			is '创建操作员';
comment on column t_role.update_datetime		is '更新时间';
comment on column t_role.expire_datetime		is '过期时间';
comment on column t_role.create_datetime		is '创建时间';





