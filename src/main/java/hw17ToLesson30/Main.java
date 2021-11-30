package hw17ToLesson30;

import hw17ToLesson30.dao.StudentDAO;
import hw17ToLesson30.dao.StudentGroupDAO;
import hw17ToLesson30.entity.Student;
import hw17ToLesson30.entity.StudentGroup;


public class Main {

    public static final String DELIMITER = "------------------------------------------------------";

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        StudentGroupDAO studentGroupDAO = new StudentGroupDAO();

        StudentGroup group = studentGroupDAO.get(1);

        System.out.println(studentDAO.getAll());
        System.out.println(DELIMITER);

        Student student = new Student(null, "Kostenko Radion Tarasovich", group, 2019);
        System.out.println(studentDAO.getAll());
        System.out.println(DELIMITER);

        student.setStudentGroup(studentGroupDAO.get(2));
        student = studentDAO.saveOrUpdate(student);
        System.out.println(studentDAO.getAll());
        System.out.println(DELIMITER);

        System.out.println(studentDAO.findByNameContaining("Radion"));
        System.out.println(DELIMITER);

        System.out.println(studentGroupDAO.getAll());
        StudentGroup group1 = new StudentGroup(null, "1234", null);
        studentGroupDAO.saveOrUpdate(group1);
        System.out.println(studentGroupDAO.getAll());
    }
}
