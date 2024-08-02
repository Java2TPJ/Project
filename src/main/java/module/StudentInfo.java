package module;
import model.*;
import java.util.*;
import data.Data;
public class StudentInfo {
    private Data data;
    Scanner sc = new Scanner(System.in);
    public StudentInfo(Data data) {
        this.data = data;
    }

    public void showInfo() {
        int select = 0;
        do {
            System.out.print("조회할 학생 번호를 입력하세요 : ");
            Long studentId = sc.nextLong();
            Student targetStudent = null;
            for(Student student : data.getStudents()) {
                if (student.getStudentId().equals(studentId)) {
                    targetStudent = student;
                    System.out.println("학생 번호 : "+student.getStudentId());
                    System.out.println("학생 이름 : "+student.getStudentName());
                    // System.out.println("학생 상태 : "+student.getState());
                    System.out.print("과목 목록 : ");
                    for(Subject subject : student.getStudentSubjects()) {
                        System.out.print(subject.getSubjectName());
                        System.out.print(", ");
                    }
                }
            }

            if (targetStudent == null) {
                System.out.println("해당 학생이 없습니다.");
                continue;
            }
            System.out.println("");
            System.out.print("[추가 조회를 원하면 1, 종료를 원할 시 아무 값을 눌러주세요.] :");
            select = sc.nextInt();
        } while(select==1);
    }
}
