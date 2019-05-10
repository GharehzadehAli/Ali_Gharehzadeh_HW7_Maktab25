package model.dao;

import model.Student;


import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {

    void insert(Student student) throws SQLException, ClassNotFoundException;

    Student findById(int id) throws SQLException, ClassNotFoundException;

    Student findByCode(int code) throws SQLException, ClassNotFoundException;

    void update(int id) throws SQLException, ClassNotFoundException;

    void delete(Student student) throws SQLException, ClassNotFoundException;

    void delete(int id) throws SQLException;

    List<Student> findAll() throws SQLException, ClassNotFoundException;

    // TODO delete update list

}
