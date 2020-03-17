import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsService {

    JDBCConnection jdbcConnection = new JDBCConnection();

    public List<String> createStudent(String name, String lastName, Integer phone) throws SQLException {

        List<String> addStudent = new ArrayList<>();
        Connection connection = jdbcConnection.jdbcConnection();
        if (connection != null) {
            PreparedStatement st = null;
            try {
                st = connection.prepareStatement("INSERT INTO students (name, last_name, phone) VALUES (?, ?, ?)");

                st.setString(1, name);
                st.setString(2, lastName);
                st.setInt(3, phone);

                st.executeUpdate();

                addStudent.add(name);
                addStudent.add(lastName);
                addStudent.add(phone.toString());

            } catch (SQLException var9) {
                var9.printStackTrace();
            } finally {
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        }
        return addStudent;
    }

    public List<String> editStudent(String name, String lastName, Integer phone, String id) throws SQLException {

        List<String> editStudent = new ArrayList<>();
        Connection connection = jdbcConnection.jdbcConnection();
        if (connection != null) {
            PreparedStatement st = null;
            try {
                st = connection.prepareStatement("UPDATE students SET name = ?, last_name = ?, phone = ? WHERE id = ?");

                st.setString(1, name);
                st.setString(2, lastName);
                st.setInt(3, phone);
                st.setString(4, id);

                st.executeUpdate();

                editStudent.add(id);
                editStudent.add(name);
                editStudent.add(lastName);
                editStudent.add(phone.toString());

            } catch (SQLException var9) {
                var9.printStackTrace();
            } finally {
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        }
        return editStudent;
    }

    public void deleteStudent(String id) throws SQLException {

        Connection connection = jdbcConnection.jdbcConnection();
        if (connection != null) {
            PreparedStatement st = null;
            try {
                st = connection.prepareStatement("DELETE FROM students WHERE id = ?");

                st.setString(1, id);

                st.executeUpdate();

            } catch (SQLException var9) {
                var9.printStackTrace();
            } finally {
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        }
    }

    public List<String> selectStudentById(String id) throws SQLException {

        List<String> selectedStudent = new ArrayList<>();
        selectedStudent.add(id);
        Connection connection = jdbcConnection.jdbcConnection();
        if (connection != null) {
            PreparedStatement st = null;
            try {
                st = connection.prepareStatement("SELECT * FROM students WHERE id = ?");

                st.setString(1, id);

                ResultSet rs = st.executeQuery();

                while (rs.next()) {

                    String name = rs.getString(2);
                    String lastName = rs.getString(3);
                    Integer phone = rs.getInt(4);

                    selectedStudent.add(name);
                    selectedStudent.add(lastName);
                    selectedStudent.add(phone.toString());

                }
            } catch (SQLException var9) {
                var9.printStackTrace();
            } finally {
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        }
        return selectedStudent;
    }

}
