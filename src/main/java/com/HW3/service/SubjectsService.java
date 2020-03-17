package com.HW3.service;

import com.HW3.model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectsService {

    JDBCConnection jdbcConnection = new JDBCConnection();

    Subject subject = new Subject();

    public Subject selectSubjectById(int id) throws SQLException {

        Connection connection = jdbcConnection.jdbcConnection();
        if (connection != null) {
            PreparedStatement st = null;
            try {
                st = connection.prepareStatement("SELECT * FROM subjects WHERE id = ?");

                st.setInt(1, id);

                ResultSet rs = st.executeQuery();

                while (rs.next()) {

                    String subjectName = rs.getString(2);

                    subject.setSubjectName(subjectName);
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
        return subject;
    }


}
