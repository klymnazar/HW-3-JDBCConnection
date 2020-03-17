import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectsService {

    JDBCConnection jdbcConnection = new JDBCConnection();

    public List<String> selectSubjectById(String id) throws SQLException {

        List<String> selectedSubject = new ArrayList<>();
        selectedSubject.add(id);
        Connection connection = jdbcConnection.jdbcConnection();
        if (connection != null) {
            PreparedStatement st = null;
            try {
                st = connection.prepareStatement("SELECT * FROM subjects WHERE id = ?");

                st.setString(1, id);

                ResultSet rs = st.executeQuery();

                while (rs.next()) {

                    String subjectName = rs.getString(2);

                    selectedSubject.add(subjectName);

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
        return selectedSubject;
    }


}
