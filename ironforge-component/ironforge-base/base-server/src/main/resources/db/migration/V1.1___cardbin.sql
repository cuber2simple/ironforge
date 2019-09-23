CREATE TABLE IF NOT EXISTS T_CARD_BIN (
    ID							SERIAL primary key,
    CARD_BIN                    VARCHAR(20),
    CARD_ORG                    VARCHAR(128),
    ISSUER                      VARCHAR(128),
    CARD_TYPE                   VARCHAR(128),
    CARD_CLASS                  VARCHAR(128),
    ISSUER_COUNTRY              VARCHAR(128),
    COUNTRY_CODE2               VARCHAR(4),
    COUNTRY_CODE3               VARCHAR(6),
    CURRENCY_NUMBER             VARCHAR(6),
    ISSUER_CODE                 VARCHAR(32),
    CARD_OPERATOR               VARCHAR(64),
    OPERATOR_TIME               TIMESTAMP WITHOUT TIME ZONE,
    STATUS                      VARCHAR(2),
    CARD_BRAND                  VARCHAR(128),
    REGION                      VARCHAR(2)
);
create unique index IDX_CARD_BIN on T_CARD_BIN using btree (CARD_BIN);

COMMENT ON COLUMN T_CARD_BIN.CARD_BIN IS '卡BIN';
COMMENT ON COLUMN T_CARD_BIN.CARD_ORG IS '卡组织';
COMMENT ON COLUMN T_CARD_BIN.ISSUER IS '发卡行';
COMMENT ON COLUMN T_CARD_BIN.CARD_TYPE IS '卡类型';
COMMENT ON COLUMN T_CARD_BIN.CARD_CLASS IS '卡种';
COMMENT ON COLUMN T_CARD_BIN.ISSUER_COUNTRY IS '发卡国家';
COMMENT ON COLUMN T_CARD_BIN.COUNTRY_CODE2 IS '国家二字码';
COMMENT ON COLUMN T_CARD_BIN.COUNTRY_CODE3 IS '国家三字码';
COMMENT ON COLUMN T_CARD_BIN.CURRENCY_NUMBER IS '币种数字代码';
COMMENT ON COLUMN T_CARD_BIN.ISSUER_CODE IS '发卡行在卡组织中的代码 (DC使用)';
COMMENT ON COLUMN T_CARD_BIN.CARD_OPERATOR IS '操作员';
COMMENT ON COLUMN T_CARD_BIN.OPERATOR_TIME IS '操作时间';
COMMENT ON COLUMN T_CARD_BIN.STATUS IS '是否可更改';
COMMENT ON COLUMN T_CARD_BIN.CARD_BRAND IS '卡品牌';


