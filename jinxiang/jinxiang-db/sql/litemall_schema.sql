drop database if exists jinxiang;
drop user if exists 'jinxiang'@'localhost';
-- 支持emoji：需要mysql数据库参数： character_set_server=utf8mb4
create database jinxiang default character set utf8mb4 collate utf8mb4_unicode_ci;
use jinxiang;
create user 'jinxiang'@'localhost' identified by 'jinxiang123456';
grant all privileges on jinxiang.* to 'jinxiang'@'localhost';
flush privileges;