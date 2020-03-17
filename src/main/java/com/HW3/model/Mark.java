package com.HW3.model;

public class Mark {

    private int id;
    private int mark;
    private int subjectId;
    private int studentId;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
