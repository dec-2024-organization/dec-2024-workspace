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