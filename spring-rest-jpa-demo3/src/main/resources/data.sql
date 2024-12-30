insert into userinfo_details(username, password) values('aaa', '$2a$12$yi.KpiNsOJo5hVnEqpRiUuwsaczBSNSg55HmiPL9g18gOWmHWIhx.');
insert into userinfo_details(username, password) values('bbb', '$2a$12$Snn.6tXhwGvWI4F5AxWoju0/8p2ylUQ3AV8oPDfv15rvd01m.tErS');
insert into userinfo_details(username, password) values('ccc', '$2a$12$4/GxqBV1HsPAKVsXVOYLzuJgi/jL0U4G./4lKaF2YBHyG6zEuQ0MS');

insert into role_details(role_name) values ('ADMIN');
insert into role_details(role_name) values ('USER');

insert into userinfo_role_details(username, role_id) values ('aaa',1);
insert into userinfo_role_details(username, role_id) values ('bbb',2);
insert into userinfo_role_details(username, role_id) values ('ccc',1);
insert into userinfo_role_details(username, role_id) values ('ccc',2);

insert into author_details(author_firstname, author_lastname) values ('JK', 'Rowling');
insert into author_details(author_firstname, author_lastname) values ('Geronimo', 'Stilton');

insert into book_details(book_title, book_genre, book_image_url, book_author_id, publisher_username) 
	values ('Harry Potter and the Order of phoenix', 'Fantasy', '', 1, 'aaa');
insert into book_details(book_title, book_genre, book_image_url, book_author_id, publisher_username) 
	values ('Harry Potter and the Half blood Prince', 'Fantasy', '', 1, 'aaa');
insert into book_details(book_title, book_genre, book_image_url, book_author_id, publisher_username) 
	values ('The Fire Dragon', 'Comedy', '', 2, 'aaa');
	
insert into character_details(char_firstname, char_lastname) values('Harry', 'Potter');
insert into character_details(char_firstname, char_lastname) values('Ron', 'Weasley');
insert into character_details(char_firstname, char_lastname) values('Draco', 'Malfoy');
insert into character_details(char_firstname, char_lastname) values('Albus', 'Dumbledore');
insert into character_details(char_firstname, char_lastname) values('Lord', 'Voldermot');
insert into character_details(char_firstname, char_lastname) values('Jack', 'High');

insert into book_character_details(book_id, char_id) values (1, 1);
insert into book_character_details(book_id, char_id) values (1, 2);
insert into book_character_details(book_id, char_id) values (1, 3);
insert into book_character_details(book_id, char_id) values (1, 4);
insert into book_character_details(book_id, char_id) values (1, 5);
insert into book_character_details(book_id, char_id) values (2, 1);
insert into book_character_details(book_id, char_id) values (2, 2);
insert into book_character_details(book_id, char_id) values (2, 3);
insert into book_character_details(book_id, char_id) values (2, 4);
insert into book_character_details(book_id, char_id) values (2, 5);
insert into book_character_details(book_id, char_id) values (3, 6);





