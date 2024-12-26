create database propertydatabase;
use propertydatabase;

create table property_details (
				property_id int primary key auto_increment,
                property_name varchar(20) ,
                property_description varchar(200),
                property_location varchar(100),
                property_image_url varchar(200)
);

insert into property_details(property_name, property_description, property_location, property_image_url) values ('Appartment', 'small appartment', 'Chennai', '');
insert into property_details(property_name, property_description, property_location, property_image_url) values ('House', 'big house', 'Pune', '');