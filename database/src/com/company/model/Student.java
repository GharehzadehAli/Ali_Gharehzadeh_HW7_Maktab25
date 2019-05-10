package model;

import java.util.Scanner;

public class Student {

    private int id;

    private String name;
private String teachersNames;

    public String getTeachersNames() {
        return teachersNames;
    }

    public void setTeachersNames(String teachersNames) {
        this.teachersNames = teachersNames;
    }

    private int code;

    public Student() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the name");
        this.name=scanner.next();
        System.out.println("enter the code");
        this.code=scanner.nextInt();

    }
    public Student(String name,int code){
        this.name=name;
        this.code=code;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}

