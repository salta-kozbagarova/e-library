INSERT INTO users (id, username, password) values(nextval ('users_id_seq'), 'admin', '$2a$06$6n2RD7QxapaxJQ7hlIVAoOcZVFxoEpaR4g8ekNqKRcK2Bus70z3oe')
INSERT INTO users (id, username, password) values(nextval ('users_id_seq'), 'student', '$2a$06$mHh2KEcWmIVw9p3jT9VUbuo4/YaWOvk3dX7Vk2ZNfVTeSou1Gs6py')
INSERT INTO roles (id, name) values(nextval ('roles_id_seq'), 'ROLE_USER')
INSERT INTO roles (id, name) values(nextval ('roles_id_seq'), 'ROLE_ADMIN')
INSERT INTO user_roles (user_id,role_id) values(1, 2)
INSERT INTO user_roles (user_id,role_id) values(2, 1)

INSERT INTO s_genre (id, name) values(nextval('genre_id_seq'),'трагедия'),(nextval('genre_id_seq'),'комедия'),(nextval('genre_id_seq'),'драмма'),(nextval('genre_id_seq'),'роман'),(nextval('genre_id_seq'),'поэма'),(nextval('genre_id_seq'),'эпопея'),(nextval('genre_id_seq'),'роман-эпопея');
	
INSERT INTO s_city (id,name) values(nextval('city_id_seq'),'Астана'),(nextval('city_id_seq'),'Алматы'),(nextval('city_id_seq'),'Кокшетау'),(nextval('city_id_seq'),'Караганда'),(nextval('city_id_seq'),'Актобе'),(nextval('city_id_seq'),'Семей'),(nextval('city_id_seq'),'Талдыкорган'),(nextval('city_id_seq'),'Павлодар'),(nextval('city_id_seq'),'Москва');
	
INSERT INTO s_publisher (id, name, city_id) values(nextval('publisher_id_seq'),'Атамура',2),(nextval('publisher_id_seq'),'Билим',2),(nextval('publisher_id_seq'),'БМ Издательство',1),(nextval('publisher_id_seq'),'Сарыарка',4),(nextval('publisher_id_seq'),'Лексика',9);
	
INSERT INTO library_card (id, user_id, firstname, lastname, course, admission_year) values(nextval('library_card_id_seq'), 2, 'Студент', 'Студентов', 2, 2015);

INSERT INTO book (id,name,author,publisher_id,city_id,published_year,pages,genre_id,quantity) values(nextval('book_id_seq'),'Абай Жолы 1 том','М. Ауезов',1,2,2005,358,7,6),(nextval('book_id_seq'),'Война и мир 2 том','Л. Толстой',5,9,1989,348,4,4);
