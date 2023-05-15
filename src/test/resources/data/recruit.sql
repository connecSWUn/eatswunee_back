--user
insert into user(user_id, name, profile_url) values(1, "jisoo", "a.jpg");
insert into user(user_id, name, profile_url) values(2, "eunkyung", "b.jpg");
insert into user(user_id, name, profile_url) values(3, "younghyun", "c.jpg");
insert into user(user_id, name, profile_url) values(4, "eunhee", "d.jpg");

--recruit
insert into recruit(recruit_id, content, created_at, edited_at, end_time, restaurant, start_time, status, title, user_id) values(1, 'content1', "2023-05-13", "2023-05-14", "2023-03-04", 'gusia', "2023-03-12", '0', 'title1', 1);
insert into recruit(recruit_id, content, created_at, edited_at, end_time, restaurant, start_time, status, title, user_id) values(2, 'content2', "2023-05-12", "2023-05-13", "2023-03-05", 'gusia', "2023-03-06", '0', 'title2', 1);
insert into recruit(recruit_id, content, created_at, edited_at, end_time, restaurant, start_time, status, title, user_id) values(3, 'content3', "2023-05-11", "2023-05-13", "2023-03-14", 'nuri', "2023-03-14", '0', 'title3', 2);
insert into recruit(recruit_id, content, created_at, edited_at, end_time, restaurant, start_time, status, title, user_id) values(4, 'content4', "2023-05-13", "2023-05-15", "2023-03-26", 'shalom', "2023-03-27", '0', 'title4', 3);
