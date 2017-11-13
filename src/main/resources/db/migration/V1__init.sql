create table author (
    id  serial not null, 
    name varchar(255) not null, 
    primary key (id));

create table book (
    id  serial not null, 
    title_id int4 not null, 
    primary key (id));

create table publisher (
    id  serial not null, 
    name varchar(255) not null, 
    primary key (id));

create table title (
    id  serial not null, 
    ddc_class int4 check (ddc_class>=0 AND ddc_class<=9), 
    ddc_division int4 check (ddc_division>=0 AND ddc_division<=9), 
    ddc_section int4 check (ddc_section>=0 AND ddc_section<=9), 
    isbn varchar(17), 
    title varchar(255) not null, 
    year_published int4, 
    publisher_id int4, 
    primary key (id));

create table title_authors (
    titles_id int4 not null, 
    authors_id int4 not null, 
    primary key (titles_id, authors_id));

alter table title add constraint uq_title_isbn unique (isbn);
alter table book add constraint fk_book_title foreign key (title_id) references title;
alter table title add constraint fk_title_publisher foreign key (publisher_id) references publisher;
alter table title_authors add constraint fk_title_authors_title foreign key (titles_id) references title;
alter table title_authors add constraint fk_title_authors_author foreign key (authors_id) references author;

create unique index title_isbn_idx on title(isbn);
create index book_title_id_idx on book(title_id);
create index title_publisher_id_idx on title(publisher_id);
