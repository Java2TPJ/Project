package module;

import model.*;
import java.util.*;
import data.Data;

public class DeleteStudent {
    private Data data;

    Scanner sc = new Scanner(System.in);

    public DeleteStudent(Data data) {
        this.data = data;
    }

    public void deleteStudent() {
        int select = 0;
        do {
            if (data.getStudents().isEmpty()) {
                System.out.println("학생 정보가 없습니다.");
                return;
            }

            Iterator<Student> iterator = data.getStudents().iterator();
    
            System.out.print("삭제할 학생 번호를 입력하세요 : ");
            Long studentId = sc.nextLong();
            Student targetStudent = null;

            // 학생 찾기 및 삭제
            while (iterator.hasNext()) {
                Student student = iterator.next();
                if (student.getStudentId().equals(studentId)) {
                    iterator.remove(); // 학생 삭제
                    targetStudent = student;
                    System.out.println("학생 정보가 삭제되었습니다.");
                    break;
                }
            }

            if (targetStudent == null) {
                System.out.println("해당 학생이 없습니다.");
                continue;
            }

            System.out.println("");
            System.out.print("[추가 삭제를 원하면 1, 종료를 원할 시 0을 눌러주세요.] :");
            select = sc.nextInt();
        } while (select == 1);
    }
}
