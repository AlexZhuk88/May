create schema smay_db;

create table smay_db.user (
  id       bigserial primary key,
  username character varying(256) unique not null,
  email    character varying(256),
  password character varying(128)
);

create table smay_db.news (
  id          bigserial primary key,
  newsname    character varying(256) unique not null,
  date        date,
  time        time,
  discription text,
  author_id   bigint references smay_db.user (id)
);

create table smay_db.groop (
  id          bigserial primary key,
  groopname   character varying(256) unique not null,
  discription text
);

create table smay_db.concert (
  id          bigserial primary key,
  concertname character varying(256) not null,
  groop_id    bigint references smay_db.groop (id),
  discription text,
  time        time,
  date        date
);

create table smay_db.concertplace (
  id         bigserial primary key,
  concert_id bigint unique not null references smay_db.concert (id),
  city       character varying(256),
  place      character varying(256),
  entrance   character varying(256)
);

create table smay_db.meeting (
  id          bigserial primary key,
  meetingname character varying(256) not null
);

create table smay_db.user_meeting (
  user_id    bigint not null references smay_db.user (id),
  meeting_id bigint not null references smay_db.meeting (id),
  primary key (user_id, meeting_id)
);

create table smay_db.comment (
  id          bigserial primary key,
  user_id     bigint not null references smay_db.user (id),
  time        time,
  date        date,
  discription text,
  concert_id  bigint references smay_db.concert (id),
  news_id     bigint references smay_db.news (id),
  type        character varying(128)
);


drop table smay_db.comment;
drop table smay_db.user_meeting;
drop table smay_db.meeting;
drop table smay_db.news;
drop table smay_db.user;
drop table smay_db.concertplace;
drop table smay_db.concert;
drop table smay_db.groop;





insert into smay_db.user (username, email, password)
values ('Alex', 'Alex@mail.ru', '111'),
       ('Bill', 'Bill@mail.ru', '111'),
       ('Sveta', 'Sveta@mail.ru', '111'),
       ('Dima', 'Dima@mail.ru', '111'),
       ('Olga', 'Olga@mail.ru', '111');

insert into smay_db.news (newsname, date, time, discription, author_id)
values ('Новость1', '2018-11-11', '13:12:16', 'Ура!', 1),
       ('Новость2', '2018-11-11', '13:12:16', 'Ура!', 2),
       ('Новость3', '2018-11-11', '13:12:16', 'Ура!', 3),
       ('Новость4', '2018-11-11', '13:12:16', 'Ура!', 4);

insert into smay_db.groop (groopname, discription)
values ('Сразу Май', 'Брест'),
       ('Би2', 'Минск'),
       ('Ария', 'Брест'),
       ('Машина времени', 'Гродно'),
       ('Любэ', 'Гомель');

insert into smay_db.concert (concertname, groop_id, discription, time, date)
values ('Концерт№1', 1, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№2', 2, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№3', 3, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№4', 4, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№5', 5, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№6', 1, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№7', 2, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№8', 3, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№9', 4, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№10', 5, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№11', 1, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№12', 2, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№13', 2, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№14', 3, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№15', 4, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№16', 5, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№17', 3, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№18', 2, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№19', 1, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№20', 1, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№21', 1, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№22', 3, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№23', 3, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№24', 3, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№25', 2, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№26', 2, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№27', 3, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№28', 5, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№29', 5, 'Будет руто!', '13:12:16', '2018-11-11'),
       ('Концерт№30', 3, 'Будет руто!', '13:12:16', '2018-11-11');

insert into smay_db.concertplace (concert_id, city, place, entrance)
VALUES (1, 'Минск', 'Ресторан', '9 BYN'),
       (2, 'Гродно', 'Паб', '5 BYN'),
       (3, 'Минск', 'Паб', '5 BYN'),
       (4, 'Брест', 'Концернтный зал', '5 BYN'),
       (5, 'Гродно', 'Паб', '9 BYN'),
       (6, 'Брест', 'Кафе', '8 BYN'),
       (7, 'Минск', 'Ресторан', '9 BYN'),
       (8, 'Гродно', 'Кафе', '5 BYN'),
       (9, 'Брест', 'Ресторан', '5 BYN'),
       (10, 'Минск', 'Паб', '8 BYN'),
       (11, 'Гродно', 'Ресторан', '5 BYN'),
       (12, 'Гомель', 'Концернтный зал', '9 BYN'),
       (13, 'Минск', 'Ресторан', '5 BYN'),
       (14, 'Минск', 'Паб', '8 BYN'),
       (15, 'Минск', 'Паб', '5 BYN'),
       (16, 'Гродно', 'Кафе', '5 BYN'),
       (17, 'Гомель', 'Ресторан', '5 BYN'),
       (18, 'Минск', 'Концернтный зал', '5 BYN'),
       (19, 'Брест', 'Паб', '9 BYN'),
       (20, 'Гомель', 'Кафе', '5 BYN'),
       (21, 'Гродно', 'Ресторан', '8 BYN'),
       (22, 'Минск', 'Концернтный зал', '5 BYN'),
       (23, 'Брест', 'Паб', '9 BYN'),
       (24, 'Минск', 'Ресторан', '5 BYN'),
       (25, 'Гомель', 'Кафе', '5 BYN'),
       (26, 'Гродно', 'Концернтный зал', '8 BYN'),
       (27, 'Минск', 'Паб', '5 BYN'),
       (28, 'Гомель', 'Ресторан', '5 BYN'),
       (29, 'Брест', 'Кафе', '9 BYN'),
       (30, 'Гомель', 'Концернтный зал', '8 BYN');

-- select *
-- from smay_db.concert where ;