insert into member(id, name, email, password, join_date)
       values(1, 'Kim', 'jaenyeong.dev@gmail.com', '1234', now());
insert into member(id, name, email, password, join_date)
       values(2, 'Lee', 'jned0317@naver.com', '1234', now());

insert into board_category(id, name)
       values(1, 'java');
insert into board_category(id, name)
       values(2, 'C#');

insert into board(id, member_id, board_category_id, title, content, read_count, create_date, update_date)
       values(1, 1, 2, 'Hello~1', 'Hello! 1', 2, now(), now());

insert into board(id, member_id, board_category_id, title, content, read_count, create_date, update_date)
       values(2, 1, 2, 'Hello~2', 'Hello! 2', 5, now(), now());

insert into board(id, member_id, board_category_id, title, content, read_count, create_date, update_date)
       values(3, 1, 2, 'Hello~3', 'Hello! 3', 200, now(), now());

insert into board_file(id, board_id, mime_type, name, save_file_name, size)
       values(1, 1, 'image/jpeg', 'a.jpg', '/tmp/a.jpg', 100);
insert into board_file(id, board_id, mime_type, name, save_file_name, size)
       values(2, 1, 'image/jpeg', 'b.jpg', '/tmp/b.jpg', 200);
insert into board_file(id, board_id, mime_type, name, save_file_name, size)
       values(3, 1, 'image/jpeg', 'c.jpg', '/tmp/c.jpg', 300);
insert into board_file(id, board_id, mime_type, name, save_file_name, size)
       values(4, 1, 'image/jpeg', 'd.jpg', '/tmp/d.jpg', 400);