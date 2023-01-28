CREATE SCHEMA IF NOT EXISTS my_store;

-- Создание последовательности
CREATE SEQUENCE IF NOT EXISTS my_store.my_store_id_seq;
-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_store.product
(
    id               integer NOT NULL DEFAULT nextval('my_store.my_store_id_seq'),
    name             text NOT NULL,
    cost             integer,
    CONSTRAINT pk_my_store_product PRIMARY KEY(id)
    );
-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_store.order
(
    id               integer NOT NULL DEFAULT nextval('my_store.my_store_id_seq'),
    creation_date    date,
    cost             integer,
    fk_products_id   integer constraint data_source_fk_product_id_fkey references my_store.product,
    CONSTRAINT pk_my_store_order PRIMARY KEY(id)
    );



