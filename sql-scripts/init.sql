CREATE DATABASE IF NOT EXISTS `agendapro-db`; 
USE `agendapro-db`; 

-- table product
CREATE TABLE IF NOT EXISTS  `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- table role 
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

-- table statistics
CREATE TABLE IF NOT EXISTS `statistics` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `count` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- table users
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- tableusers_roles
CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` bigint NOT NULL,
  `roles_id` bigint NOT NULL,
  KEY `FK15d410tj6juko0sq9k4km60xq` (`roles_id`),
  KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`),
  CONSTRAINT `FK15d410tj6juko0sq9k4km60xq` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

INSERT INTO role (NAME)
SELECT "PRODUCT_SELECT"
WHERE NOT EXISTS (SELECT 1 FROM role WHERE NAME = "PRODUCT_SELECT");

INSERT INTO role (NAME)
SELECT "PRODUCT_INSERT"
WHERE NOT EXISTS (SELECT 1 FROM role WHERE NAME = "PRODUCT_INSERT");

INSERT INTO role (NAME)
SELECT "PRODUCT_UPDATE"
WHERE NOT EXISTS (SELECT 1 FROM role WHERE NAME = "PRODUCT_UPDATE");

INSERT INTO role (NAME)
SELECT "PRODUCT_DELETE"
WHERE NOT EXISTS (SELECT 1 FROM role WHERE NAME = "PRODUCT_DELETE");


GRANT ALL PRIVILEGES ON *.* TO 'user'@'%' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON banco.* TO 'user'@'%';
FLUSH PRIVILEGES;