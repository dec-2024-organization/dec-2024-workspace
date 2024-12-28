insert into author_details(author_firstname, author_lastname) values ('JK', 'Rowling');
insert into author_details(author_firstname, author_lastname) values ('Geronimo', 'Stilton');

insert into book_details(book_title, book_genre, book_image_url, book_author_id) 
	values ('Harry Potter and the Order of phoenix', 'Fantasy', '', 1);
insert into book_details(book_title, book_genre, book_image_url, book_author_id) 
	values ('Harry Potter and the Half blood Prince', 'Fantasy', '', 1);
insert into book_details(book_title, book_genre, book_image_url, book_author_id) 
	values ('The Fire Dragon', 'Comedy', '', 2);
	
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

insert into userinfo(username, password) values('aaa', 'aaa');
insert into userinfo(username, password) values('bbb', 'bbb');
insert into userinfo(username, password) values('ccc', 'ccc');

insert into role_details(role_name) values ('ADMIN');
insert into role_details(role_name) values ('USER');

insert into userinfo_role_details(username, role_id) values ('aaa',1);
insert into userinfo_role_details(username, role_id) values ('bbb',2);
insert into userinfo_role_details(username, role_id) values ('ccc',1);
insert into userinfo_role_details(username, role_id) values ('ccc',2);



