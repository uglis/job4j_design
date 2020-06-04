
--создание базы данных в редакторе не получилось, сделал через cmd
create database tracker;

create table rules (
		id serial primary key,
		rights varchar(40)
);

create table roles (
		id serial primary key,
		id_rules int references rules(id)
);

create table users (
		id serial primary key,
		login text,
		password varchar(30),
		id_role integer references roles(id)
);

create table categorys (
		id serial primary key,
		category varchar(50)
);

create table states (
		id serial primary key,
		state varchar(50)
);

create table items (
		id serial primary key,
		item text,
		user_id int references users(id),
		category int references categorys(id),
		state_id int references states(id)
);

create table attachs (
		id serial primary key,
		url text,
		id_item integer references items(id)
);

create table comments (
		id serial primary key,
		description text,
		id_item integer references items(id)
);

insert into rules(rights) values('admin'), ('guest');

insert into roles(id_rules) values (1), (2);

insert into users(login, password, id_role) values ('Igor', 'igor', 1), ('Olea', 'olea', 2);

insert into categorys(category) values ('normal'), ('middle'), ('urgent');

insert into states(state) values ('new'), ('process'), ('finished');

insert into items(item, user_id, category, state_id) values ('car', 1, 3, 1), ('byke', 2, 1, 2), ('burger', 1, 1, 1);

insert into comments(description, id_item) values ('black with white', 1), ('street', 2);

insert into attachs(url, id_item) values ('www.pictures.com/323434.png', 1), ('www.pictures.com/34366.png', 2);