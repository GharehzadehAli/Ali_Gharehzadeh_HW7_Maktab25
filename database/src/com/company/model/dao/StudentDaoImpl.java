package model.dao;

import model.Student;


import java.sql.*;
import java.util.*;

public class StudentDaoImpl implements StudentDAO {

    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/university";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    private static Connection conn;
    private static Statement statement;

    @Override
    public void insert(Student student) throws SQLException, ClassNotFoundException {
        initConn();

        String query = "INSERT INTO `student` (`name`, `code`) VALUES ('" + student.getName() + "', '" + student.getCode() + "'); ";

        statement.executeUpdate(query);

        closeConn();

    }

    @Override
    public Student findById(int id) throws SQLException, ClassNotFoundException {
        initConn();

        String query = "SELECT * FROM `student` where id='" + id + "'";

        ResultSet rs = statement.executeQuery(query);

        Student stu = null;

        if (rs.next()) {
            stu = new Student(rs.getString("name"), rs.getInt("code"));
        }

        closeConn();

        return stu;
    }

    @Override
    public Student findByCode(int code) throws SQLException, ClassNotFoundException {
        initConn();

        String query = "SELECT * FROM `student` where code='" + code + "'";
String query1="SELECT teacher.name FROM teacher JOIN relation ON teacher.id=relation.teacher_id join student on relation.student_id=student.id where student.code="+code+"";
        ResultSet resultSet = statement.executeQuery(query);
        ResultSet resultSet1 = statement.executeQuery(query1);

        Student student = null;

        if (resultSet.next()) {
            student = new Student(resultSet.getString("name"), resultSet.getInt("code"));
        }
        String teachersNames="";
        if (resultSet1.next()) {
             teachersNames=resultSet1.getString("name");

        }
        student.setTeachersNames(teachersNames);
        closeConn();

        return student;
    }

    @Override
    public void update(int id) throws SQLException, ClassNotFoundException {
        initConn();

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a new name");
        String name = scanner.next();
        System.out.println("enter a new code");
        int code = scanner.nextInt();
        String query = "UPDATE `student` SET `name`='" + name + "',`code`='" + code + "' WHERE id='" + id + "'";
        statement.executeUpdate(query);
        closeConn();
    }

    @Override
    public void delete(Student student) throws SQLException, ClassNotFoundException {
        initConn();
        String query1 = "SELECT * FROM `student` where code='" + student.getCode() + "'";

        ResultSet resultSet = statement.executeQuery(query1);
        resultSet.next();
        int id = resultSet.getInt("id");
        String query= "DELETE FROM `student` WHERE `student`.`id` = '"+id+"'";
        statement.executeUpdate(query);
        closeConn();
    }

    @Override
    public void delete(int id) throws SQLException {
        String query= "DELETE FROM `student` WHERE `student`.`id` = '"+id+"'";
        statement.executeUpdate(query);
        closeConn();
    }

    @Override
    public List<Student> findAll() throws SQLException, ClassNotFoundException {
        initConn();
        String query = "SELECT * FROM `student`";
        ResultSet resultSet = statement.executeQuery(query);
        List<Student> list = new ArrayList<Student>();
        Student student;
        while (resultSet.next()) {
            initConn();

            student = new Student(resultSet.getString("name"), resultSet.getInt("code"));

            student.setId(resultSet.getInt("id"));

            String query1="SELECT teacher.name FROM teacher JOIN relation ON teacher.id=relation.teacher_id join student on relation.student_id=student.id where student.id='"+student.getId()+"'";
            ResultSet resultSet1 = statement.executeQuery(query1);
            String teachersNames="";
            while (resultSet1.next()) {
                teachersNames+=resultSet1.getString("name");

            }
            closeConn();
            student.setTeachersNames(teachersNames);
            list.add(student);

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
