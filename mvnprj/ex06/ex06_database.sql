create table users(
	username varchar2(50) not null primary key,
	password varchar2(50) not null,
	enabled char(1) default '1' );
	
create table authorities (
	username varchar2(50) not null,
	authority varchar2(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

insert into users(username, password ) values ( 'user00' , 'pw00');
insert into users(username, password ) values ( 'member00' , 'pw00');
insert into users(username, password ) values ( 'admin00' , 'pw00');

insert into authorities(username, authority) values ('user00','ROLE_USER');
insert into authorities(username, authority) values ('member00','ROLE_MANAGER');
insert into authorities(username, authority) values ('admin00','ROLE_MANAGER');
insert into authorities(username, authority) values ('admin00','ROLE_ADMIN');


