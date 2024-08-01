package data;

import model.*;
import java.util.*;
public class Data {
    private List<Student> students;
    private List<Subject> subjects;
    private List<Score> scores;

    // getter
    public List<Student> getStudents() {
        return students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Score> getScores() {
        return scores;
    }

    //초기 데이터 저장고 생성
    public void setInitData() {
        students = new ArrayList<>();
        subjects = List.of(
                new Subject("Java", "ESSENTIAL"),
                new Subject("OOP", "ESSENTIAL"),
                new Subject("Spring", "ESSENTIAL"),
                new Subject("JPA", "ESSENTIAL"),
                new Subject("MySQL", "ESSENTIAL"),
                new Subject("디자인 패턴", "SELECT"),
                new Subject("Spring Security", "SELECT"),
                new Subject("Redis", "SELECT"),
                new Subject("MongoDB", "SELECT")
        );
        scores = new ArrayList<>();
    }
}
