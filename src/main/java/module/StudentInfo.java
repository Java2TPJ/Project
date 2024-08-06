package module;
import model.*;
import java.util.*;
import data.Data;
import exception.*;
public class StudentInfo {
    private Data data;
    Scanner sc = new Scanner(System.in);
    public StudentInfo(Data data) {
        this.data = data;
    }

    public void showInfo() {
        int select = 0;
        do {
            try {
                System.out.print("조회할 학생 번호를 입력하세요 : ");
                Long studentId = sc.nextLong();
                Student targetStudent = null;
                for(Student student : data.getStudents()) {
                    if (student.getStudentId().equals(studentId)) {
                        targetStudent = student;
                        System.out.println("학생 번호 : "+student.getStudentId());
                        System.out.println("학생 이름 : "+student.getStudentName());
                        System.out.println("학생 상태 : "+student.getState());
                        System.out.print("과목 목록 : ");
                        for(Subject subject : student.getStudentSubjects()) {
                            System.out.print(subject.getSubjectName());
                            System.out.print(", ");
                        }
                    }
                }

                if (targetStudent == null) {
                    throw new StudentNotFoundException();
                }
                System.out.println("");
                System.out.print("[추가 조회를 원하면 1, 종료를 원할 시 아무 숫자 값을 눌러주세요.] :");
                select = sc.nextInt();
            } catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());
            }catch (Exception e) {
                System.out.println("예기치 않은 오류가 발생했습니다. 다시 시도해주세요.");
            }
        } while(select==1);
    }
}
