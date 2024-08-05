package model;
import java.util.*;
public class Student {
    private static Long nextStudentId = 1L;
    private Long studentId;                 // 학생 고유 번호
    private String studentName;             // 학생 이름
    private List<Subject> studentSubjects;  // 과목 목록
    private String state;                   // 학생 상태

    public Student(String studentName, List<Subject> studentSubjects, String state) {
        this.studentId = nextStudentId++; // 학생 등록할 때마다 값이 증가하도록 변경
        this.studentName = studentName;
        this.studentSubjects = studentSubjects;
        this.state = state;
    }

    public Long getStudentId() {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
