create table if not exists clothing (
    id identity,
    name varchar(50) not null,
    brand_from varchar(50) not null,
    created_at timestamp not null,
    price double not null
);