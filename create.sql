create table author (id  serial not null, name varchar(255) not null, primary key (id))
create table book (id  serial not null, title_id int4 not null, primary key (id))
create table publisher (id  serial not null, name varchar(255) not null, primary key (id))
create table title (id  serial not null, ddc_class int4 check (ddc_class>=0 AND ddc_class<=9), ddc_division int4 check (ddc_division>=0 AND ddc_division<=9), ddc_section int4 check (ddc_section>=0 AND ddc_section<=9), isbn varchar(17), title varchar(255) not null, year_published int4, publisher_id int4, primary key (id))
create table title_authors (titles_id int4 not null, authors_id int4 not null, primary key (titles_id, authors_id))
alter table title add constraint UK_agjy1djbnq9i4fub9sw860w9f unique (isbn)
alter table book add constraint FKjkumnt1blnm0ly9na1gd9rqog foreign key (title_id) references title
alter table title add constraint FKcy7tb4c5xk6k4axdpvjlaf870 foreign key (publisher_id) references publisher
alter table title_authors add constraint FKkk639v91oaodupirw3ivrxp46 foreign key (authors_id) references author
alter table title_authors add constraint FKq2tuoaxpb48gjhfqqto40rt3t foreign key (titles_id) references title
