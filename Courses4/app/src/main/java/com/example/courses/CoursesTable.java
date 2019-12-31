package com.example.courses;

public class CoursesTable {
   private String course_name;
    private  int id;

    public CoursesTable(String course_name) {
        this.setCourse_name(course_name);
    }

    public String getCourse_name(){
        return course_name;
    }
    public void setCourse_name(String course_name){
        this.course_name=course_name;
    }

    public int getId() {
        return id;
    }
    public void setId(){
        this.id=id;
    }
}
