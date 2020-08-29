insert into login_users(user_id,user_passwd,user_name,user_role,user_status) 
values
('teacher1','123456','joe','TEACHER',1),
('student1','123456','lucy','STUDENT',1),
('Admin','Admin','administrator','ADMIN',1);


insert into course(course_id,course_name,teacher_id,sub_cnt,course_status) 
values
('402881e4743a58cf01743a5a82e00001','数学','teacher1',1,1);


insert into subscribe(subscribe_id,course_id,student_id) 
values
('402881e4743a58cf01743a5a8ec10002','402881e4743a58cf01743a5a82e00001','student1');