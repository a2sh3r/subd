CREATE TABLE students (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  last_name VARCHAR(255),
  first_name VARCHAR(255),
  batya_name VARCHAR(255),
  group_id BIGINT,
  grade INT
);

CREATE TABLE courses (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255)
);

CREATE TABLE student_course (
  student_id BIGINT,
  course_id BIGINT,
  PRIMARY KEY(student_id, course_id),
  FOREIGN KEY(student_id) REFERENCES students(id),
  FOREIGN KEY(course_id) REFERENCES courses(id)
);

CREATE TABLE groups (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255)
);