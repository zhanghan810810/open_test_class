
create table if not exists login_users (
user_id varchar(40) not null primary key,
user_passwd varchar(40),
user_name varchar(100),
user_role varchar(10),
user_status int
);


create table if not exists course (
course_id varchar(40) not null primary key,
course_name varchar(20),
teacher_id varchar(40),
sub_cnt int,
course_status int
);

create table if not exists subscribe (
subscribe_id varchar(40) not null primary key,
course_id varchar(40),
student_id varchar(40)
);