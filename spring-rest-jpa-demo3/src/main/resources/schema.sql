create table author_details(
   author_id int auto_increment primary key,
   author_firstname varchar(20),
   author_lastname varchar(20)
);

create table book_details(
   book_id int auto_increment primary key,
   book_title varchar(40),
   book_genre varchar(20),
   book_image_url varchar(200),
   book_author_id int,
   foreign key(book_author_id) references author_details(author_id)
);

create table character_details(
	char_id int auto_increment primary key,
	char_firstname varchar(20),
	char_lastname varchar(20)
);

create table book_character_details(
	book_char_id int auto_increment primary key,
	book_id int,
	char_id int,
	foreign key(book_id) references book_details(book_id),
	foreign key(char_id) references character_details(char_id)
);

create table userinfo(
	username varchar(20) primary key,
	password varchar(20)
);

create table role_details(
	role_id int auto_increment primary key,
	role_name varchar(20)
);

create table userinfo_role_details(
	ur_id int auto_increment primary key,
	username varchar(20),
	role_id int,
	foreign key(username) references userinfo(username),
	foreign key(role_id) references role_details(role_id)
);


