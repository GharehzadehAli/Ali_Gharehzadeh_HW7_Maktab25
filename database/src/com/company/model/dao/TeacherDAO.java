package model.dao;

import model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDAO {

    void insert(Teacher teacher) throws SQLException, ClassNotFoundException;

    Teacher findById(int id) throws SQLException, ClassNotFoundException;

    Teacher findByCode(int code) throws SQLException, ClassNotFoundException;

    void update(int id) throws SQLException, ClassNotFoundException;

    void delete(Teacher student) throws SQLException, ClassNotFoundException;

    void delete(int id) throws SQLException;

    List<Teacher> findAll() throws SQLException, ClassNotFoundException;

    // TODO delete update list

}
