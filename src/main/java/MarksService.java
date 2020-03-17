import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarksService {

    JDBCConnection jdbcConnection = new JDBCConnection();

    public List<String> createMark(String mark, String subjectId, String studentId) throws SQLException {

        List<String> addMark = new ArrayList<>();
        Connection connection = jdbcConnection.jdbcConnection();
        if (connection != null) {
            PreparedStatement st = null;
            try {
                st = connection.prepareStatement("INSERT INTO marks (mark, subject_id, student_id) VALUES (?, ?, ?)");

                st.setString(1, mark);
                st.setString(2, subjectId);
                st.setString(3, studentId);

                st.executeUpdate();

                addMark.add(mark);
                addMark.add(subjectId);
                addMark.add(studentId);

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
        return addMark;
    }

}
