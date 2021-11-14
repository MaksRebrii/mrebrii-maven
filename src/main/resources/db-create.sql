DROP DATABASE IF EXISTS hillel_hw15_to_lesson26;
CREATE DATABASE IF NOT EXISTS hillel_hw15_to_lesson26;

USE hillel_hw15_to_lesson26;

DROP TABLE IF EXISTS marks;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS student_groups;
DROP TABLE IF EXISTS lessons;
DROP TABLE IF EXISTS professors;
DROP TABLE IF EXISTS departments;

CREATE TABLE IF NOT EXISTS student_groups -- groups/group используется в  MYSQL
(
    group_id   INT PRIMARY KEY AUTO_INCREMENT,
    group_code VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS departments
(
    department_id   INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(150) NOT NULL,
    department_head VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS professors
(
    professor_id  INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    professor_fio VARCHAR(152)    NOT NULL,
    department_id INT,
    CONSTRAINT department_id_fk FOREIGN KEY (department_id)
        REFERENCES departments (department_id)
);

CREATE TABLE IF NOT EXISTS lessons
(
    lesson_id       INT PRIMARY KEY AUTO_INCREMENT,
    lesson_name     VARCHAR(100),
    professor_id    INT,
    lesson_semester TINYINT NOT NULL,
    lesson_year     YEAR    NOT NULL,
    CONSTRAINT professor_id_fk FOREIGN KEY (professor_id)
        REFERENCES professors (professor_id)
);

CREATE TABLE IF NOT EXISTS students
(
    student_id     INT PRIMARY KEY AUTO_INCREMENT,
    student_fio    VARCHAR(152) NOT NULL,
    group_id       INT,
    admission_year YEAR         NOT NULL,
    CONSTRAINT group_id_fk FOREIGN KEY (group_id) REFERENCES student_groups (group_id)
);

CREATE TABLE IF NOT EXISTS marks
(
    mark_id    INT PRIMARY KEY AUTO_INCREMENT,
    lesson_id  INT,
    student_id INT,
    mark       TINYINT NOT NULL,
    CONSTRAINT student_id_fk FOREIGN KEY (student_id) REFERENCES students (student_id),
    CONSTRAINT lesson_id_fk FOREIGN KEY (lesson_id) REFERENCES lessons (lesson_id)
);

INSERT INTO student_groups
VALUES (DEFAULT, 'AC-191'),
       (DEFAULT, 'AC-192'),
       (DEFAULT, 'AC-193');

INSERT INTO students
VALUES (DEFAULT, 'Melnyk Daria Viacheslavivna', 3, 2019),
       (DEFAULT, 'Savin Ruslan Olegovich', 3, 2019),
       (DEFAULT, 'Davlitshin Vladislav Sergeevich', 2, 2019),
       (DEFAULT, 'Kompan Iryna Ihorivna', 2, 2019),
       (DEFAULT, 'Chechyi Vlad Victorovich', 1, 2019),
       (DEFAULT, 'Baranova Mariya Andeevna', 1, 2019);

INSERT INTO departments
VALUES (DEFAULT, 'System Software Department', 'Kostenko Radion Tarasovich'),
       (DEFAULT, 'Department of Computer System', 'Havrulyk Oleksii Yurievich');

INSERT INTO professors
VALUES (DEFAULT, 'Ivanov Ivan Ivanovich', 1),
       (DEFAULT, 'Petrov Petr Petrovich', 1),
       (DEFAULT, 'Sidorov Sidor Sidorovich', 2);

INSERT INTO lessons
VALUES (DEFAULT, 'Sex education', 1, 1, 2021),
       (DEFAULT, 'Chemistry', 2, 2, 2020),
       (DEFAULT, 'Algebra', 3, 1, 2021),
       (DEFAULT, 'Geometry', 3, 2, 2021),
       (DEFAULT, 'Programming', 1, 1, 2021);

INSERT INTO marks
VALUES (DEFAULT, 1, 1, 68),
       (DEFAULT, 2, 1, 76),
       (DEFAULT, 3, 1, 76),
       (DEFAULT, 4, 1, 79),
       (DEFAULT, 5, 1, 76),
       (DEFAULT, 1, 2, 62),
       (DEFAULT, 2, 2, 83),
       (DEFAULT, 3, 2, 91),
       (DEFAULT, 4, 2, 87),
       (DEFAULT, 5, 2, 73),
       (DEFAULT, 1, 3, 84),
       (DEFAULT, 2, 3, 98),
       (DEFAULT, 3, 3, 98),
       (DEFAULT, 4, 3, 68),
       (DEFAULT, 5, 3, 78),
       (DEFAULT, 1, 4, 100),
       (DEFAULT, 2, 4, 95),
       (DEFAULT, 3, 4, 97),
       (DEFAULT, 4, 4, 98),
       (DEFAULT, 5, 4, 95),
       (DEFAULT, 1, 5, 100),
       (DEFAULT, 2, 5, 95),
       (DEFAULT, 3, 5, 85),
       (DEFAULT, 4, 5, 77),
       (DEFAULT, 5, 5, 60);