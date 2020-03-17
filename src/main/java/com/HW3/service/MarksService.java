package com.HW3.service;

import com.HW3.model.Mark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MarksService {

    JDBCConnection jdbcConnection = new JDBCConnection();

    Mark mark = new Mark();

    public Mark createMark(int marks, int subjectId, int studentId) throws SQLException {

        Connection connection = jdbcConnection.jdbcConnection();
        if (connection != null) {
            PreparedStatement st = null;
            try {
                st = connection.prepareStatement("INSERT INTO marks (mark, subject_id, student_id) VALUES (?, ?, ?)");

                st.setInt(1, marks);
                st.setInt(2, subjectId);
                st.setInt(3, studentId);

                st.executeUpdate();

                mark.setMark(marks);

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
        return mark;
    }

}
