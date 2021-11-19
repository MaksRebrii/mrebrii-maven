package hw16ToLesson27;

import java.sql.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/hillel_hw15_to_lesson26";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "19022002__Max";
    private static final String FIO = "student_fio";
    private static final String GROUP = "group_code";
    private static final String YEAR = "admission_year";
    private static StudentDAO instance;

    private StudentDAO() {
    }

    public static synchronized StudentDAO getInstance() {
        if (instance == null) {
            instance = new StudentDAO();
        }
        return instance;
    }


    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }

    public StudentDTO getStudentById(int id) {
        StudentDTO studentDTO = null;

        try (PreparedStatement statement = getConnection().prepareStatement(SQLUser.GET_STUDENT_BY_ID.query)) {
            statement.setInt(1, id);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                studentDTO = mapper(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return studentDTO;
    }

    public boolean deleteStudentById(int id) {
        int result = 0;

        try (PreparedStatement statement = getConnection().prepareStatement(SQLUser.DELETE_USER_BY_ID.query)) {
            statement.setInt(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> result = new ArrayList<>();
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQLUser.GET_ALL_STUDENTS.query);
            while (resultSet.next()) {
                StudentDTO student = mapper(resultSet);
                result.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public List<StudentDTO> getStudentListByLastName(String lastName) {
        List<StudentDTO> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%").append(lastName).append("%");

        try (PreparedStatement statement = getConnection().prepareStatement(SQLUser.GET_STUDENT_BY_LAST_NAME.query)) {

            statement.setString(1, stringBuilder.toString());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                StudentDTO student = mapper(resultSet);
                result.add(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    private StudentDTO mapper(ResultSet rs) throws SQLException {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFio(rs.getString(FIO));
        studentDTO.setGroup(rs.getString(GROUP));
        studentDTO.setYear(Year.parse(rs.getString(YEAR).substring(0, 4)));
       /*пришлось сделать так потому что возвращает год в виде 2019-12-31.
        Можно было пойти через инт, но оставил так*/
        return studentDTO;
    }

    private enum SQLUser {
        DELETE_USER_BY_ID("DELETE FROM students WHERE student_id = ?"),
        GET_STUDENT_BY_ID("SELECT * FROM students JOIN student_groups USING (group_id) WHERE student_id = ?"),
        GET_ALL_STUDENTS("SELECT * FROM students JOIN student_groups USING (group_id)"),
        GET_STUDENT_BY_LAST_NAME("SELECT * FROM students JOIN student_groups USING (group_id) WHERE student_fio LIKE ?");

        String query;

        SQLUser(String query) {
            this.query = query;
        }

    }
}
