CREATE TABLE IF NOT EXISTS t_worker (
                                        id                    VARCHAR(64) PRIMARY KEY,
                                        username              VARCHAR(256),
                                        password              VARCHAR(1024),
                                        nick_name             VARCHAR(1024),
                                        email					VARCHAR(256),
                                        phone					VARCHAR(32),
                                        namespace             VARCHAR(256),
                                        employee_no           VARCHAR(64),
                                        avatar                VARCHAR(256),
                                        status				VARCHAR(64),
                                        update_worker   	    VARCHAR(64),
                                        create_worker   		VARCHAR(64),
                                        update_datetime       TIMESTAMP WITHOUT TIME ZONE,
                                        create_datetime       TIMESTAMP WITHOUT TIME ZONE
);
CREATE INDEX idx_t_worker_username ON t_worker USING btree(username);
CREATE unique index idx_t_worker_namespace_username ON t_worker USING btree(username, namespace);

comment on table  t_worker						    is '用户表';
comment on column t_worker.id						is '用户ID';
comment on column t_worker.username					is '用户姓名';
comment on column t_worker.password					is '密码';
comment on column t_worker.nick_name				is '昵称';
comment on column t_worker.email					is '邮箱';
comment on column t_worker.phone					is '电话号码';
comment on column t_worker.namespace				is '归属';
comment on column t_worker.employee_no			    is '员工号';
comment on column t_worker.avatar					is '用户头像';
comment on column t_worker.status              	    is '状态';
comment on column t_worker.update_worker			is '更新操作员';
comment on column t_worker.create_worker			is '创建操作员';
comment on column t_worker.update_datetime		    is '更新时间';
comment on column t_worker.create_datetime		    is '创建时间';