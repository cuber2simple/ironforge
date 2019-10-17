CREATE TABLE IF NOT EXISTS t_resource (
    id                          SERIAL primary key,
    code                        VARCHAR(64) not null,
    name                        VARCHAR(64) not null,
    url                         VARCHAR(64) not null,
    icon                        VARCHAR(128) not null,
    memo                        VARCHAR(256) not null,
    application                 VARCHAR(128) not null,
    enabled_ip_filter           VARCHAR(8) not null,
    enabled_signature_filter    VARCHAR(8) not null,
    enabled_auth_filter         VARCHAR(8) not null,
    status                      VARCHAR(64),
    update_user_id              VARCHAR(64),
    create_user_id              VARCHAR(64),
    update_datetime             TIMESTAMP WITHOUT TIME ZONE,
    create_datetime             TIMESTAMP WITHOUT TIME ZONE
);
CREATE unique index idx_t_resource_code ON t_resource USING btree(code);
CREATE unique index idx_t_resource_url ON t_resource USING btree(url);

comment on table  t_resource						    is '资源表/暂不考虑';
comment on column t_resource.id						    is '主键ID';
comment on column t_resource.code                       is '资源CODE';
comment on column t_resource.name					    is '资源名称';
comment on column t_resource.url					    is 'url';
comment on column t_resource.icon					    is 'ICON';
comment on column t_resource.memo					    is '备注';
comment on column t_resource.application				is '属于那个服务';
comment on column t_resource.enabled_ip_filter			is '是否开启IP过滤';
comment on column t_resource.enabled_signature_filter	is '是否开启签名校验过滤';
comment on column t_resource.enabled_auth_filter		is '是否开启授权过滤';
comment on column t_resource.status              	    is '状态';
comment on column t_resource.update_user_id			    is '更新操作员';
comment on column t_resource.create_user_id			    is '创建操作员';
comment on column t_resource.update_datetime		    is '更新时间';
comment on column t_resource.create_datetime		    is '创建时间';

CREATE TABLE IF NOT EXISTS t_ip_filter (
    id			            SERIAL primary key,
    ip_address				VARCHAR(256),
    resource_code           VARCHAR(64),
    filter_memo				VARCHAR(1024),
    type                    VARCHAR(256),
    status					VARCHAR(64),
    update_user_id    		VARCHAR(64),
    create_user_id    		VARCHAR(64),
    expire_datetime			TIMESTAMP WITHOUT TIME ZONE,
    update_datetime         TIMESTAMP WITHOUT TIME ZONE,
    create_datetime         TIMESTAMP WITHOUT TIME ZONE
);

CREATE index idx_t_ip_filter ON t_ip_filter USING btree(ip_address);
CREATE index idx_t_ip_filter_code ON t_ip_filter USING btree(resource_code);

comment on table  t_ip_filter						is 'IP过列表';
comment on column t_ip_filter.id					is '主键';
comment on column t_ip_filter.ip_address			is '针对的IP名单';
comment on column t_ip_filter.resource_code 		is '专属的资源CODE';
comment on column t_ip_filter.filter_memo			is '过滤原因';
comment on column t_ip_filter.type			        is 'black/white/black-except/white-except';
comment on column t_ip_filter.status              	is '状态';
comment on column t_ip_filter.update_user_id		is '更新操作员';
comment on column t_ip_filter.create_user_id		is '创建操作员';
comment on column t_ip_filter.update_datetime		is '更新时间';
comment on column t_ip_filter.expire_datetime		is '过期时间';
comment on column t_ip_filter.create_datetime		is '创建时间';

CREATE TABLE IF NOT EXISTS t_client (
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
