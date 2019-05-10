

import model.Student;
import model.Teacher;
import model.dao.StudentDAO;
import model.dao.StudentDaoImpl;
import model.dao.TeacherDAO;
import model.dao.TeacherDaoImpl;


import java.sql.*;
import java.util.Scanner;

public class MyApp {

    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName(DRIVER_NAME);

        System.out.println("Choice one :");

        String input = getNextInput();

        switch (input) {
            case "1":
                showStudentById();
                break;
            case "2":
                showTeacherById();
                break;
            case "3":
                insertNewStudent();
                break;
            case "4":
                insertNewTeacher();
                break;
            case "5":
                deleteStudent();
            case "6":
                deleteTeacher();
            case "7":
                editStudent();
            case "8":
                editTeacher();
            default:
                System.out.println("error");
        }


    }
    private static void editStudent() throws SQLException, ClassNotFoundException {
        System.out.println("input student id :");
        StudentDAO dao=new StudentDaoImpl();
         dao.update(scanner.nextInt());
    }
    private static void editTeacher() throws SQLException, ClassNotFoundException {
        System.out.println("input student id :");
        TeacherDAO dao=new TeacherDaoImpl();
        dao.update(scanner.nextInt());
    }
    private static void deleteStudent() throws SQLException, ClassNotFoundException {
        System.out.println("input student id :");
        StudentDAO dao = new StudentDaoImpl();
        dao.delete(scanner.nextInt());
    }

    private static void deleteTeacher() throws SQLException, ClassNotFoundException {
        System.out.println("input teacher id :");
        TeacherDAO dao = new TeacherDaoImpl();
        dao.delete(scanner.nextInt());
    }

    private static void insertNewStudent() throws SQLException, ClassNotFoundException {
        //TODO
        StudentDAO dao = new StudentDaoImpl();
        Student student = new Student();
        dao.insert(student);
    }

    private static void insertNewTeacher() throws SQLException, ClassNotFoundException {
        TeacherDAO dao = new TeacherDaoImpl();
        Teacher teacher = new Teacher();
        dao.insert(teacher);
    }

    private static void showStudentByCode() {
        //TODO
    }

    private static void showStudentById() throws SQLException, ClassNotFoundException {
        System.out.println("input student id :");
        StudentDAO dao = new StudentDaoImpl();

        Student byId = dao.findById(scanner.nextInt());

        System.out.println(byId);

    }
    private static void showTeacherById() throws SQLException, ClassNotFoundException {
        System.out.println("input teacher id :");
        TeacherDAO dao = new TeacherDaoImpl();

        Teacher byId = dao.findById(scanner.nextInt());

        System.out.println(byId);

    }


    public static String getNextInput() {
        return scanner.nextLine();
    }
}

