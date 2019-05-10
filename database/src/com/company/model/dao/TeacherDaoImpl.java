package model.dao;

import model.Student;
import model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherDaoImpl implements TeacherDAO {
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/university";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    private static Connection conn;
    private static Statement statement;
    @Override
    public void insert(Teacher teacher) throws SQLException, ClassNotFoundException {
        initConn();

        String query = "INSERT INTO `teacher` (`name`, `code`) VALUES ('" + teacher.getName() + "', '" + teacher.getCode() + "'); ";
        statement.executeUpdate(query);

        closeConn();
    }

    @Override
    public Teacher findById(int id) throws SQLException, ClassNotFoundException {
        initConn();

        String query = "SELECT * FROM `teacher` where id='" + id + "'";

        ResultSet rs = statement.executeQuery(query);

        Teacher teacher = null;

        if (rs.next()) {
            teacher = new Teacher(rs.getString("name"), rs.getInt("code"));
        }

        closeConn();

        return teacher;
    }

    @Override
    public Teacher findByCode(int code) throws SQLException, ClassNotFoundException {
        initConn();

        String query = "SELECT * FROM `teacher` where code='" + code + "'";

        ResultSet resultSet = statement.executeQuery(query);

        Teacher teacher = null;

        if (resultSet.next()) {
            teacher = new Teacher(resultSet.getString("name"), resultSet.getInt("code"));
        }

        closeConn();

        return teacher;
    }

    @Override
    public void update(int id) throws SQLException, ClassNotFoundException {
        initConn();


        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a new name");
        String name = scanner.next();
        System.out.println("enter a new code");
        int code = scanner.nextInt();
        String query = "UPDATE `teacher` SET `name`='" + name + "',`code`='" + code + "' WHERE id='" + id + "'";
        statement.executeUpdate(query);
        closeConn();
    }

    @Override
    public void delete(Teacher teacher) throws SQLException, ClassNotFoundException {
        initConn();
        String query1 = "SELECT * FROM `teacher` where code='" + teacher.getCode() + "'";

        ResultSet resultSet = statement.executeQuery(query1);
        resultSet.next();
        int id = resultSet.getInt("id");
        String query= "DELETE FROM `teacher` WHERE `teacher`.`id` = '"+id+"'";
        statement.executeUpdate(query);
        closeConn();
    }

    @Override
    public void delete(int id) throws SQLException {
        String query= "DELETE FROM `teacher` WHERE `teacher`.`id` = '"+id+"'";
        statement.executeUpdate(query);
        closeConn();
    }

    @Override
    public List<Teacher> findAll() throws SQLException, ClassNotFoundException {
        initConn();
        String query = "SELECT * FROM `teacher`";
        ResultSet resultSet = statement.executeQuery(query);
        List<Teacher> list = new ArrayList<Teacher>();
        Teacher teacher;
        while (resultSet.next()) {
            initConn();
            teacher = new Teacher(resultSet.getString("name"), resultSet.getInt("code"));
            teacher.setId(resultSet.getInt("id"));
            String query1="SELECT student.name FROM student JOIN relation ON student.id=relation.student_id join teacher on relation.teacher_id=teacher.id where teacher.id='"+teacher.getId()+"'";
            ResultSet resultSet1 = statement.executeQuery(query1);
            String studentsNames="";
            while (resultSet1.next()) {
                studentsNames+=resultSet1.getString("name");

            }
            closeConn();
            teacher.setStudentNames(studentsNames);
            list.add(teacher);
        }
        closeConn();
        return list;
    }
    private void initConn() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        statement = conn.createStatement();
    }

    private void closeConn() throws SQLException {

        statement.close();
        conn.close();
    }
}
