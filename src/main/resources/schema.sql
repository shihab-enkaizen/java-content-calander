create table content
(
    id           int auto_increment,
    title        varchar(255) null,
    `desc`       varchar(255) null,
    status       varchar(255) null,
    type         varchar(255) null,
    date_created TIMESTAMP    not null,
    date_updated timestamp    null,
    url          varchar(255) null,
    constraint content_pk
        primary key (id)
);
