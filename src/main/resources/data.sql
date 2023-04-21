INSERT INTO groups (title) VALUES ('Group A');
INSERT INTO courses (title) VALUES ('Math'), ('Physics'), ('Chemistry');

INSERT INTO students (last_name, first_name, batya_name, group_id, grade)
VALUES ('Ivanov', 'Ivan', 'Ivanovich', 1, 4),
       ('Petrov', 'Petr', 'Petrovich', 1, 3),
       ('Sidorov', 'Sidor', 'Sidorovich', 1, 5);

INSERT INTO student_course (student_id, course_id)
VALUES (1, 1), (1, 2), (2, 2), (3, 1), (3, 2), (3, 3);