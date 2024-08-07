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

        // 과목 목록 설정(테스트용 삭제 처리 예정)
        Subject java = getSubjectByName("Java");
        Subject spring = getSubjectByName("Spring");
        Subject mongoDB = getSubjectByName("MongoDB");

        // 강태영 학생 생성 및 과목 설정(테스트용 삭제 처리 예정)
        Student student1 = new Student("흥부", List.of(java ,spring, mongoDB), "Green");
        Student student2 = new Student("홍길", List.of(java ,spring, mongoDB), "Green");
        Student student3 = new Student("삭제용", List.of(java ,spring, mongoDB), "Red");
        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    // 테스트용, 추후 변경해야할듯 이름으로 Subject 객체 가져오기
    private Subject getSubjectByName(String name) {
        for (Subject subject : subjects) {
            if (subject.getSubjectName().equals(name)) {
                return subject;
            }
        }
        return null; // 없을 경우 null 반환
    }

    // 필수 과목 등급 반환 메서드
    public String EssentialGrade(double Score) {
        String Grade;
        if ((Score >= 95) && (Score <= 100)) {
            Grade = "A";
            return Grade;
        } else if ((Score >= 90) && (Score < 95)) {
            Grade = "B";
            return Grade;
        } else if ((Score >= 80) && (Score < 90)) {
            Grade = "C";
            return Grade;
        } else if ((Score >= 70) && (Score < 80)) {
            Grade = "D";
            return Grade;
        } else if ((Score >= 60) && (Score < 70)) {
            Grade = "F";
            return Grade;
        } else {
            Grade = "N";
            return Grade;
        }
    }

    // 선택 과목 등급 반환 메서드
    public String SectGrade(double  Score) {
        String Grade;
        if ((Score >= 90) && (Score <= 100)) {
            Grade = "A";
            return Grade;
        } else if ((Score >= 80) && (Score < 90)) {
            Grade = "B";
            return Grade;
        } else if ((Score >= 70) && (Score < 80)) {
            Grade = "C";
            return Grade;
        } else if ((Score >= 60) && (Score < 70)) {
            Grade = "D";
            return Grade;
        } else if ((Score >= 50) && (Score < 60)) {
            Grade = "F";
            return Grade;
        } else {
            Grade = "N";
            return Grade;
        }
    }

    // 현재 저장된 점수 목록 출력(테스트용 삭제 처리 요망)
    public void printScores() {
        System.out.println("현재 저장된 점수 목록:");
        for (Score score : scores) {
            System.out.println("학생 ID: " + score.getStudentId() +
                    ", 과목 ID: " + score.getSubjectId() +
                    ", 회차: " + score.getRound() +
                    ", 점수: " + score.getScore() +
                    ", 등급: " + score.getGrade());
        }
    }

    // 현재 저장된 학생 목록 출력(테스트용 삭제 처리 요망)
    public void printStudents() {
        System.out.println("현재 저장된 학생 목록:");
        for (Student student : students) {
            System.out.println("학생번호: "+student.getStudentId()+
                    " 학생 이름: " + student.getStudentName() +
                    ", 등록된 과목: " + student.getStudentSubjects());
        }
    }

    // 현재 저장된 과목 목록 출력(테스트용 삭제 처리 요망)
    public void printSubjects() {
        System.out.println("현재 저장된 과목 목록 : ");
        for (Subject subject : subjects) {
            System.out.println("과목번호: " + subject.getSubjectId() +
                    ", 과목 이름: " + subject.getSubjectName() +
                    ", 과목 등급: " + subject.getSubjectType()
            );
        }
    }
}
