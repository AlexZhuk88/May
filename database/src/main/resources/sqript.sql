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

        -- drop table smay_db.user;
        -- drop table smay_db.news;
        -- drop table smay_db.groop;
        -- drop table smay_db.concert;
        -- drop table smay_db.user_meeting;
        -- drop table smay_db.concertplace;
        -- drop table smay_db.comment;