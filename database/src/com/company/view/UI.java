package view;

import javax.swing.*;

public class UI {
    JMenu menu, student, teacher;
    JMenuItem showStudentById, showTeacherById, insertNewStudent, insertNewTeacher, deleteStudent, deleteTeacher, editStudent, editTeacher;

    UI() {
        JFrame jFrame = new JFrame("Menu and MenuItem Example");
        JMenuBar mb = new JMenuBar();
        menu = new JMenu("Menu");
        student = new JMenu("student");
        teacher = new JMenu("teacher");
        showStudentById = new JMenuItem("showStudentById");
        showTeacherById = new JMenuItem("showTeacherById");
        insertNewStudent = new JMenuItem("insertNewStudent");
        insertNewTeacher = new JMenuItem("insertNewTeacher");
        deleteStudent = new JMenuItem("deleteStudent");
        deleteTeacher = new JMenuItem("deleteTeacher");
        editStudent = new JMenuItem("editStudent");
        editTeacher = new JMenuItem("editTeacher");

        student.add(showStudentById);
        student.add(insertNewStudent);
        student.add(deleteStudent);
        student.add(editStudent);
        teacher.add(showTeacherById);
        teacher.add(insertNewTeacher);
        teacher.add(deleteTeacher);
        teacher.add(editTeacher);
        menu.add(student);
        menu.add(teacher);

        mb.add(menu);


        jFrame.setJMenuBar(mb);
        jFrame.setSize(500, 500);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new UI();
    }
}
