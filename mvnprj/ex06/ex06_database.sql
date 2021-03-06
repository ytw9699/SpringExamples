create table users(
	username varchar2(50) not null primary key,
	password varchar2(50) not null,
	enabled char(1) default '1' );
	
create table authorities (
	username varchar2(50) not null,
	authority varchar2(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username,authority);

insert into users(username, password ) values ( 'user00' , 'pw00');
insert into users(username, password ) values ( 'member00' , 'pw00');
insert into users(username, password ) values ( 'admin00' , 'pw00');

insert into authorities(username, authority) values ('user00','ROLE_USER');
insert into authorities(username, authority) values ('member00','ROLE_MANAGER');
insert into authorities(username, authority) values ('admin00','ROLE_MANAGER');
insert into authorities(username, authority) values ('admin00','ROLE_ADMIN');


select * from users;

select * from authorities order by authority;

create table tbl_member(
      userid varchar2(50) not null primary key,
      userpw varchar2(100) not null,
      username varchar2(100) not null,
      regdate date default sysdate, 
      updatedate date default sysdate,
      enabled char(1) default '1'
);

drop table tbl_member purge 

create table tbl_member_auth (
     userid varchar2(50) not null,
     auth varchar2(50) not null,
     constraint fk_member_auth foreign key(userid) references tbl_member(userid)
);

create table persistent_logins (
	username varchar(64) not null,
	series varchar(64) primary key,
	token varchar(64) not null,
	last_used timestamp not null
);
--테이블을 생성하는 스크립트는 특정한 데이터베이스에 맞게 테이블 이름과 칼럼명을 제
--외한 칼럼의 타입 등을 적당히 조정해서 사용하면 됩니다. 오라클에서는 varchar를 그대
--로 이용하거나 varchar2로 변경해서 사용하면 됩니다
