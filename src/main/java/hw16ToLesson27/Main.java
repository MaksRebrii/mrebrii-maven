package hw16ToLesson27;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(StudentDAO.getInstance().getStudentById(1));
        List<StudentDTO> allStudents = StudentDAO.getInstance().getAllStudents();
        System.out.println(allStudents);
        System.out.println(StudentDAO.getInstance().deleteStudentById(7));
        System.out.println(StudentDAO.getInstance().deleteStudentById(6));
        System.out.println(allStudents);
        allStudents = StudentDAO.getInstance().getAllStudents();
        System.out.println(allStudents);

        List<StudentDTO> studentsKompan = StudentDAO.getInstance().getStudentListByLastName("Kompan");
        System.out.println(studentsKompan);
    }
}
