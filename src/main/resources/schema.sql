create table COURSE(
    courseId bigserial,
    NAME varchar(8000),
    primary key (courseId)
);

create table STUDENTGROUP(
    groupId bigserial,
    NAME varchar(8000),
    primary key (groupId)
);

create table STUDENTS(
    ID bigserial,
    SECOND_NAME varchar(255),
    FIRST_NAME varchar(255),
    BATYA_NAME varchar(255),
    studentGroup bigint references STUDENTGROUP (groupId),
    courses bigint references COURSE (courseId),
    MARK bigint,
    primary key (ID)
);