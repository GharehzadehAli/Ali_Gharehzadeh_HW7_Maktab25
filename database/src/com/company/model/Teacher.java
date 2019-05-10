package model;

import java.util.Scanner;

public class Teacher {

    private int id;

    private String name;
private String studentNames;

    public String getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(String studentNames) {
        this.studentNames = studentNames;
    }

    private int code;
public Teacher(){
    Scanner scanner=new Scanner(System.in);
    System.out.println("enter the name");
    this.name=scanner.next();
    System.out.println("enter the code");
    this.code=scanner.nextInt();
}
    public Teacher(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
