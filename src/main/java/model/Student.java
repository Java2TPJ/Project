package model;
import java.util.*;
public class Student {
    private UUID studentId;                 // 학생 고유 번호
    private String studentName;             // 학생 이름
    private List<Subject> studentSubjects;  // 과목 목록

    public Student(String studentName, List<Subject> studentSubjects) {
        this.studentId = UUID.randomUUID(); // UUID 생성
        this.studentName = studentName;
        this.studentSubjects = studentSubjects;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Subject> getStudentSubjects() {
        return studentSubjects;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentSubjects(List<Subject> studentSubjects) {
        this.studentSubjects = studentSubjects;
    }
}
