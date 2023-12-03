
/* user */
insert into user(user_id, name, role, profile_url, login_id, password, fcm_token) values(1, "jisu", "ROLE_USER", "", "1234", "1234", "c0v_2oF5TxaXLS2rp9-mnu:APA91bGFogvHiDn-t2zr9kwExrZQ-b1Fame31MYtnAgDO7MpwCVbPjqwcqBfPSTrmN4SlBSoLd3VcC0Zbh5IApHk03BBnQ3SB1CZd9ddiy9vXWbyDvDHRuwx6b6F4Bpkpwez4nAzlJhM");
insert into user(user_id, name, role, profile_url, login_id, password) values(2, "eunhee", "ROLE_USER", "", "5678", "5678");
insert into user(user_id, name, role, profile_url, login_id, password) values(3, "eunkyung", "ROLE_USER", "user_default_profile.png", "9101112", "9101112");
insert into user(user_id, name, role, profile_url, login_id, password) values(4, "younghyun", "ROLE_USER", "user_default_profile.png", "13141516", "13141516");


/* restaurant */
-- gusia
insert into restaurant(restaurant_id, name, restaurant_spot) values(1, '포아이니', 'gusia');
insert into restaurant(restaurant_id, name, restaurant_spot) values(2, "분식대첩", 'gusia');
insert into restaurant(restaurant_id, name, restaurant_spot) values(3, "만권화밥", 'gusia');
insert into restaurant(restaurant_id, name, restaurant_spot) values(4, "최고당돈가스", 'gusia');
-- shalom
insert into restaurant(restaurant_id, name, restaurant_spot) values(5, 'shalom', 'shalom');
-- nuri
insert into restaurant(restaurant_id, name, restaurant_spot) values(6, "퀴즈노스", 'nuri');
insert into restaurant(restaurant_id, name, restaurant_spot) values(7, "가은", 'nuri');
insert into restaurant(restaurant_id, name, restaurant_spot) values(8, "츄밥", 'nuri');
-- fiftieth
insert into restaurant(restaurant_id, name, restaurant_spot) values(9, "뜌레쥬르", 'fiftieth');
insert into restaurant(restaurant_id, name, restaurant_spot) values(10, "감탄떡볶이", 'fiftieth');


/* menu */
-- 포아이니
insert into menu(menu_id, name, price, image_url, restaurant_id) values(1, "면덕후쌀국수", 5900, "1.png", 1);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(2, "차돌양지쌀국수", 6900, "2.png", 1);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(3, "매운차돌양지쌀국수", 7500, "3.png", 1);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(4, "새우완탕면쌀국수", 7900, "4.png", 1);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(5, "모둠어묵쌀국수", 5900, "5.png", 1);
-- 분식대첩
insert into menu(menu_id, name, price, image_url, restaurant_id) values(6, "꼬마김밥", 6500, "6.png", 2);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(7, "라면", 6000, "7.png", 2);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(8, "떡라면", 6400, "8.png", 2);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(9, "치즈라면", 7800, "9.png", 2);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(10, "유부우동", 6900, "10.png", 2);
-- 만권화밥
insert into menu(menu_id, name, price, image_url, restaurant_id) values(11, "두루치기덮밥", 6500, "11.png", 3);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(12, "매운닭갈비덮밥", 6500, "12.png", 3);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(13, "간장닭갈비덮밥", 6500, "13.png", 3);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(14, "오징어볶음덮밥", 6500, "14.png", 3);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(15, "오삼불고기덮밥", 7000, "15.png", 3);
-- 최고당돈가스
insert into menu(menu_id, name, price, image_url, restaurant_id) values(16, "수제생등심돈가스", 6400, "16.png", 4);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(17, "치즈돈가스", 7400, "17.png", 4);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(18, "크림돈가스", 7400, "18.png", 4);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(19, "카레돈가스", 7400, "19.png", 4);
insert into menu(menu_id, name, price, image_url, restaurant_id) values(20, "매운칠리돈가스", 7400, "20.png", 4);


/*  recruit  */
insert into recruit(recruit_id, content, recruit_created_at, start_time, end_time, restaurant, edited_at, status, title, user_id) values(1, '구시아에서 같이 밥먹어요 시간 조금 더 늦춰도 좋습니다:) 연락주s세요!', "2023-05-13", "11:23", "11:40", 'gusia', "2023-03-12", 'ONGOING', '구시아 11시에', 1);
insert into recruit(recruit_id, content, recruit_created_at, start_time, end_time, restaurant, edited_at, status, title, user_id) values(2, '밥 친구 구해요..! 같이 드실 분 계신가요?', "2023-05-12", "11:24", "12:11", 'gusia', "2023-03-06", 'CONNECTING', '밥 친구 구해요!', 2);
insert into recruit(recruit_id, content, recruit_created_at, start_time, end_time, restaurant, edited_at, status, title, user_id) values(3, '매주 화요일에 점심 혼자 먹기 싫어서.. 혹시 같이 드실 분 계신가요??', "2023-05-11", "14:23", "16:00", 'nuri', "2023-03-14", 'ONGOING', '매주 화요일', 4);
insert into recruit(recruit_id, content, recruit_created_at, start_time, end_time, restaurant, edited_at, status, title, user_id) values(4, '오늘 저녁에 퀴즈노스에서 샌드위치 드실분?? 채팅 남겨 주세요~', "2023-05-13", "20:00", "21:00", 'shalom', "2023-03-27", 'COMPLETED', '샌드위치 좋아하시는 분', 4);


/*  orders  */
-- jisu
insert into orders(order_id, order_created_at, order_num, order_status, user_id) values(1,  "2023-04-28 16:30:51", 102, "COMPLETE", 1);
insert into orders(order_id, order_created_at, order_num, order_status, user_id) values(2,  "2023-06-01 15:00:32", 30, "ONGOING", 1);
-- eunhee

insert into orders(order_id, order_created_at, order_num, order_status, user_id) values(3,  "2023-05-11 10:44:21", 196, "COMPLETE", 2);
insert into orders(order_id, order_created_at, order_num, order_status, user_id) values(4,  "2023-05-24 17:37:19", 209, "COMPLETE", 2);
insert into orders(order_id, order_created_at, order_num, order_status, user_id) values(5,  "2023-06-01 14:04:08", 344, "ONGOING", 2);


/*  order_menu  */
-- jisu, orders1

insert into order_menu(order_menu_id, menu_cnt, menu_id, order_id, order_menu_status) values(1, 2, 10, 1, "COMPLETED");
insert into order_menu(order_menu_id, menu_cnt, menu_id, order_id, order_menu_status) values(2, 1, 1, 1, "COMPLETED");
insert into order_menu(order_menu_id, menu_cnt, menu_id, order_id, order_menu_status) values(3, 3, 3, 1, "COMPLETED");

-- jisu, orders2

insert into order_menu(order_menu_id, menu_cnt, menu_id, order_id, order_menu_status) values(4, 1, 2, 2, "ONGOING");
insert into order_menu(order_menu_id, menu_cnt, menu_id, order_id, order_menu_status) values(5, 1, 4, 2, "ONGOING");

-- eunhee orders3

insert into order_menu(order_menu_id, menu_cnt, menu_id, order_id, order_menu_status) values(6, 3, 16, 3, "COMPLETED");
insert into order_menu(order_menu_id, menu_cnt, menu_id, order_id, order_menu_status) values(7, 1, 1, 3, "COMPLETED");

-- eunhee orders4

insert into order_menu(order_menu_id, menu_cnt, menu_id, order_id, order_menu_status) values(8, 1, 2, 4, "COMPLETED");

-- eunhee orders5

insert into order_menu(order_menu_id, menu_cnt, menu_id, order_id, order_menu_status) values(9, 2, 5, 5, "ONGOING");


/*  review  */
-- jisu, order_menu1,2

insert into review(review_id, score, title, content, review_created_at, review_img, user_id, menu_id, order_menu_id) values(1, 3.0, "먹을만해요", "빨리 나와서 좋아요. 고기가 좀 얇음.", "2023-04-29", "review.png", 1, 10, 1);
insert into review(review_id, score, title, content, review_created_at, review_img, user_id, menu_id, order_menu_id) values(2, 4.0, "이거", "저는 맛있는데, 호불호 갈릴 것 같아요", "2023-04-28", "review.png", 1, 1, 2);

-- eunhee, order_menu6,7

insert into review(review_id, score, title, content, review_created_at, review_img, user_id, menu_id, order_menu_id) values(3, 4.0, "추천", "양 많아요!.", "2023-05-12", "review.png", 2, 16, 6);
insert into review(review_id, score, title, content, review_created_at, review_img, user_id, menu_id, order_menu_id) values(4, 5.0, "최고", "맛있는데 빨리나오고 양까지 많아요.", "2023-05-12", "review.png", 2, 1, 7);


/*  seller  */
insert into seller(seller_id, seller_name, seller_profile_url, seller_fcm_token, login_id, password, restaurant_id) values(1, "포니아 식당 주인", "aaa.png", "", "1010", "1010", 1);
insert into seller(seller_id, seller_name, seller_profile_url, seller_fcm_token, login_id, password, restaurant_id) values(2, "분식대첩 식당 주인", "aaa.png", "", "2222", "2222", 2);
insert into seller(seller_id, seller_name, seller_profile_url, seller_fcm_token, login_id, password, restaurant_id) values(3, "만권화밥 식당 주인", "aaa.png", "", "3333", "3333", 3);
insert into seller(seller_id, seller_name, seller_profile_url, seller_fcm_token, login_id, password, restaurant_id) values(4, "최고당돈가스 식당 주인", "aaa.png", "", "4444", "4444", 4);


/*  notification  */
insert into notification(notification_type, notification_id, notification_created_at, notification_content, notification_is_read, notification_title) values('notification_order', 1, "2023-05-12", '', TRUE, "");
insert into notification(notification_type, notification_id, notification_created_at, notification_content, notification_is_read, notification_title) values('notification_order', 2, "2023-05-13", '', TRUE, "");
insert into notification(notification_type, notification_id, notification_created_at, notification_content, notification_is_read, notification_title) values('notification_order', 3, "2023-05-13", '', TRUE, "");
insert into notification(notification_type, notification_id, notification_created_at, notification_content, notification_is_read, notification_title) values('notification_order', 4, "2023-05-13", '', TRUE, "");
insert into notification(notification_type, notification_id, notification_created_at, notification_content, notification_is_read, notification_title) values('notification_order', 5, "2023-05-13", '', TRUE, "");
insert into notification(notification_type, notification_id, notification_created_at, notification_content, notification_is_read, notification_title) values('notification_order', 6, "2023-05-13", '', TRUE, "");
insert into notification(notification_type, notification_id, notification_created_at, notification_content, notification_is_read, notification_title) values('notification_order', 7, "2023-05-13", '', TRUE, "");


/*  notification_order  */
insert into notification_order(notification_id, order_id, restaurant_id) values(1, 1, 1);
insert into notification_order(notification_id, order_id, restaurant_id) values(2, 1, 2);

insert into notification_order(notification_id, order_id, restaurant_id) values(3, 2, 1);

insert into notification_order(notification_id, order_id, restaurant_id) values(4, 3, 1);
insert into notification_order(notification_id, order_id, restaurant_id) values(5, 3, 4);

insert into notification_order(notification_id, order_id, restaurant_id) values(6, 4, 1);

insert into notification_order(notification_id, order_id, restaurant_id) values(7, 5, 1);


/*  chat_room  */
insert into chat_room(chat_room_id, created_at, recruit_id, user_id) values(201, "2023-05-13", 1, 2);
insert into chat_room(chat_room_id, created_at, recruit_id, user_id) values(401, "2023-05-14", 1, 4);
insert into chat_room(chat_room_id, created_at, recruit_id, user_id) values(103, "2023-05-12", 3, 1);



insert into chat_message(chat_message_id, created_at, is_read, message, chat_room_id, user_id) values(1, "2023-05-13", TRUE, "안녕하세요! 게시글 보고 연락드렸어요", 201, 2);
insert into chat_message(chat_message_id, created_at, is_read, message, chat_room_id, user_id) values(2, "2023-05-13", TRUE, "네네 구시아 괜찮으세요?", 201, 1);
insert into chat_message(chat_message_id, created_at, is_read, message, chat_room_id, user_id) values(3, "2023-05-14", TRUE, "괜찮아요:)", 201, 2);
insert into chat_message(chat_message_id, created_at, is_read, message, chat_room_id, user_id) values(4, "2023-05-14", TRUE, "네 그럼 그때 뵈어요", 201, 1);
insert into chat_message(chat_message_id, created_at, is_read, message, chat_room_id, user_id) values(5, "2023-05-15", FALSE, "넵! 그때 뵙겠습니다!", 201, 2);


insert into chat_message(chat_message_id, created_at, is_read, message, chat_room_id, user_id) values(6, "2023-05-13", TRUE, "안녕하세요! 혹시 구해졌나요?", 401, 4);
insert into chat_message(chat_message_id, created_at, is_read, message, chat_room_id, user_id) values(7, "2023-05-13", TRUE, "네네ㅜ 제가 수정을 안했네요", 401, 1);
insert into chat_message(chat_message_id, created_at, is_read, message, chat_room_id, user_id) values(8, "2023-05-14", FALSE, "그렇군요..! 알겠습니다", 401, 4);


insert into chat_message(chat_message_id, created_at, is_read, message, chat_room_id, user_id) values(9, "2023-05-12", TRUE, "혹시 구했나요??", 103, 1);
insert into chat_message(chat_message_id, created_at, is_read, message, chat_room_id, user_id) values(10, "2023-05-12", TRUE, "아니요!", 103, 4);
insert into chat_message(chat_message_id, created_at, is_read, message, chat_room_id, user_id) values(11, "2023-05-12", FALSE, "저 같이 먹고 싶은데 괜찮으세요?", 103, 4);

insert into order_num values(1, 1);