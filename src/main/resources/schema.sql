create table if not exists `USERS` (
    `id` bigint not null auto_increment,
    `username` varchar(50) not null,
    `password` varchar(50) not null,
    primary key (`id`)
);
create table if not exists `GROUPS` (
    `id` bigint not null auto_increment,
    `name` varchar(50) not null,
    `admin` bigint not null,
    primary key (`id`)
);
create table if not exists `MESSAGES` (
    `id` bigint not null auto_increment,
    `user` bigint not null,
    `group` bigint not null,
    `text` varchar(1000) not null,
    primary key (`id`)
);
create table if not exists `GROUPS_USERS` (
    `group_id` bigint not null,
    `user_id` bigint not null
);
insert into GROUPS(`name`, `admin`) VALUES ( 'primary', 0 );
insert into USERS( `username`, `password` ) values ( 'admin', 'password' );
insert into GROUPS_USERS(`group_id`, `user_id`) values ( 0, 0 );