import java.util.*;
import model.*;

public class StudentTest {

    public static void main(String[] args) {
        // 과목 목록 생성
        List<Subject> Subjects = List.of(
                new Subject("국어", "필수"),
                new Subject("영어", "필수"),
                new Subject("수학", "필수"),
                new Subject("과학", "선택")
        );

        // 학생 리스트 생성
        List<Student> students = new ArrayList<>();

        // 학생 객체 생성 및 과목 할당
        List<Subject> student1Subjects = new ArrayList<>();
        student1Subjects.add(Subjects.get(0)); // 국어
        student1Subjects.add(Subjects.get(1)); // 영어
        students.add(new Student("김철수", student1Subjects));

        List<Subject> student2Subjects = new ArrayList<>();
        student2Subjects.add(Subjects.get(1)); // 영어
        student2Subjects.add(Subjects.get(2)); // 수학
        students.add(new Student("이영희", student2Subjects));

        List<Subject> student3Subjects = new ArrayList<>();
        student3Subjects.add(Subjects.get(0)); // 국어
        student3Subjects.add(Subjects.get(2)); // 수학
        student3Subjects.add(Subjects.get(3)); // 과학
        students.add(new Student("박지훈", student3Subjects));

        // 학생 정보 출력
        for (Student student : students) {
            System.out.println("학생 ID: " + student.getStudentId());
            System.out.println("학생 이름: " + student.getStudentName());
            System.out.print("등록 과목:");
            for (Subject subject : student.getStudentSubjects()) {
                System.out.print(" " +subject.getSubjectName());
            }
            System.out.println();
            System.out.println();
        }

        for (Student student : students) {
            if (student.getStudentName().equals("박지훈")) {
                System.out.println("박지훈의 정보");
                System.out.println("학생 ID: " + student.getStudentId());
                System.out.println("학생 이름: " + student.getStudentName());
                System.out.print("등록 과목:");
                for (Subject subject : student.getStudentSubjects()) {
                    System.out.print(" " + subject.getSubjectName());
                }
                System.out.println();
                System.out.println();
            }
        }
    }
}
