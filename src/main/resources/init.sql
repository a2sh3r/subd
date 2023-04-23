create database measurement;

create table if not exists measurement.test
(
    id String,
    currentA DOUBLE,
    currentB DOUBLE,
    currentC DOUBLE
)
engine = AggregatingMergeTree
order by (id);


-- engine = SummingMergeTree(count)
-- select source, value,  timestamp, count(1) as count from clickdb.clicks where domain = :domain group by domain, path, d

