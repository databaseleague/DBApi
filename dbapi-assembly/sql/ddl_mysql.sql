-- ----------------------------
-- Table structure for api_config
-- ----------------------------
DROP TABLE IF EXISTS `api_config`;
CREATE TABLE `api_config`
(
    `id`             varchar(20) NOT NULL,
    `name`           varchar(255) DEFAULT NULL,
    `note`           varchar(255) DEFAULT NULL,
    `path`           varchar(255) DEFAULT NULL,
    `params`         text,
    `json_param`     text,
    `status`         int(11)      DEFAULT NULL COMMENT '0-offline;1-online',
    `access`         int(11)      DEFAULT NULL COMMENT '0-private;1-public',
    `group_id`       varchar(20)  DEFAULT NULL,
    `content_type`   varchar(50)  DEFAULT NULL,
    `task`           text,
    `create_user_id` int(11)      DEFAULT NULL,
    `create_time`    varchar(20)  DEFAULT NULL,
    `update_time`    varchar(20)  DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `path` (`path`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for api_group
-- ----------------------------
DROP TABLE IF EXISTS `api_group`;
CREATE TABLE `api_group`
(
    `id`             varchar(255) NOT NULL,
    `name`           varchar(255) DEFAULT NULL,
    `create_user_id` int(11)      DEFAULT NULL,
    `create_time`    varchar(20)  DEFAULT NULL,
    `update_time`    varchar(20)  DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `name` (`name`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for api_history
-- ----------------------------
DROP TABLE IF EXISTS `api_history`;
CREATE TABLE `api_history`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `api_id`      varchar(20) DEFAULT NULL,
    `content`     text,
    `create_time` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for api_plugin_config
-- ----------------------------
DROP TABLE IF EXISTS `api_plugin_config`;
CREATE TABLE `api_plugin_config`
(
    `api_id`       varchar(20) NOT NULL,
    `plugin_type`  int(11)      DEFAULT NULL,
    `plugin_name`  varchar(255) DEFAULT NULL,
    `plugin_param` text
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`
(
    `id`              varchar(255) NOT NULL DEFAULT '',
    `name`            varchar(255)          DEFAULT NULL,
    `note`            varchar(1024)         DEFAULT NULL,
    `secret`          varchar(255)          DEFAULT NULL,
    `public_key`      varchar(1024)         DEFAULT NULL,
    `expire_desc`     varchar(255)          DEFAULT NULL,
    `expire_duration` varchar(255)          DEFAULT NULL,
    `token`           varchar(255)          DEFAULT NULL,
    `expire_at`       bigint(32)            DEFAULT NULL,
    `create_user_id`  int(11)               DEFAULT NULL,
    `create_time`     varchar(20)           DEFAULT NULL,
    `update_time`     varchar(20)           DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for client_auth
-- ----------------------------
DROP TABLE IF EXISTS `client_auth`;
CREATE TABLE `client_auth`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `client_id` varchar(20) DEFAULT NULL,
    `group_id`  varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for datasource
-- ----------------------------
DROP TABLE IF EXISTS `datasource`;
CREATE TABLE `datasource`
(
    `id`             varchar(20) NOT NULL,
    `name`           varchar(255)  DEFAULT NULL,
    `note`           varchar(255)  DEFAULT NULL,
    `type`           varchar(20)   DEFAULT NULL,
    `detail`         varchar(1024) DEFAULT NULL,
    `create_user_id` int(11)       DEFAULT NULL,
    `create_time`    varchar(20)   DEFAULT NULL,
    `update_time`    varchar(20)   DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for firewall
-- ----------------------------
DROP TABLE IF EXISTS `firewall`;
CREATE TABLE `firewall`
(
    `status` varchar(255) DEFAULT NULL,
    `mode`   varchar(255) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for ip_rules
-- ----------------------------
DROP TABLE IF EXISTS `ip_rules`;
CREATE TABLE `ip_rules`
(
    `type` varchar(255) DEFAULT NULL,
    `ip`   text         DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for perm_group_datasource
-- ----------------------------
DROP TABLE IF EXISTS `perm_group_datasource`;
CREATE TABLE `perm_group_datasource`
(
    `group_id`      varchar(20) NOT NULL,
    `datasource_id` varchar(20) NOT NULL,
    `type`          int(11) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for perm_user_group
-- ----------------------------
DROP TABLE IF EXISTS `perm_user_group`;
CREATE TABLE `perm_user_group`
(
    `user_id`  int(11)     NOT NULL,
    `group_id` varchar(20) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `username`    varchar(255) DEFAULT NULL,
    `password`    varchar(255) DEFAULT NULL,
    `role`        varchar(20)  DEFAULT NULL,
    `email`       varchar(255) DEFAULT NULL,
    `create_time` varchar(20)  DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;


insert into `firewall`(`status`, `mode`)
values ('off', 'black');

insert into `ip_rules`(`type`, `ip`)
values ('white', NULL),
       ('black', NULL);

insert into `user`(`id`, `username`, `password`, `role`)
values (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'ADMIN');
