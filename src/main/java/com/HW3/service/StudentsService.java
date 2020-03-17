package com.HW3.service;

import com.HW3.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentsService {

    JDBCConnection jdbcConnection = new JDBCConnection();

    Student student = new Student();

    public Student createStudent(String name, String lastName, Integer phone) throws SQLException {

        Connection connection = jdbcConnection.jdbcConnection();
        if (connection != null) {
            PreparedStatement st = null;
            try {
                st = connection.prepareStatement("INSERT INTO students (name, last_name, phone) VALUES (?, ?, ?)");

                st.setString(1, name);
                st.setString(2, lastName);
                st.setInt(3, phone);

                st.executeUpdate();

                student.setName(name);
                student.setLastName(lastName);
                student.setPhone(phone);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        }
        return student;
    }

    public Student editStudent(String name, String lastName, Integer phone, int id) throws SQLException {

        Connection connection = jdbcConnection.jdbcConnection();
        if (connection != null) {
            PreparedStatement st = null;
            try {
                st = connection.prepareStatement("UPDATE students SET name = ?, last_name = ?, phone = ? WHERE id = ?");

                st.setString(1, name);
                st.setString(2, lastName);
                st.setInt(3, phone);
                st.setInt(4, id);

                st.executeUpdate();

                student.setId(id);
                student.setName(name);
                student.setLastName(lastName);
                student.setPhone(phone);

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
        return student;
    }

    public void deleteStudent(int id) throws SQLException {

        Connection connection = jdbcConnection.jdbcConnection();
        if (connection != null) {
            PreparedStatement st = null;
            try {
                st = connection.prepareStatement("DELETE FROM students WHERE id = ?");

                st.setInt(1, id);

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

    public Student selectStudentById(int id) throws SQLException {

        Connection connection = jdbcConnection.jdbcConnection();
        if (connection != null) {
            PreparedStatement st = null;
            try {
                st = connection.prepareStatement("SELECT * FROM students WHERE id = ?");

                st.setInt(1, id);

                ResultSet rs = st.executeQuery();

                while (rs.next()) {

                    String name = rs.getString(2);
                    String lastName = rs.getString(3);
                    Integer phone = rs.getInt(4);

                    student.setId(id);
                    student.setName(name);
                    student.setLastName(lastName);
                    student.setPhone(phone);

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
        return student;
    }

}
