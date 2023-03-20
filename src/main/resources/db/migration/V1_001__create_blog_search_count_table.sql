create table blog_search_count
(
    query varchar(1000),
    count bigint,
    primary key (count)
);

create index inx_count on blog_search_count(count);