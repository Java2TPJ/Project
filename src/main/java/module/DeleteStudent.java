package module;

import model.*;
import java.util.*;
import data.Data;

public class DeleteStudent {
    private Data data;
    private Scanner sc = new Scanner(System.in);

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
            Long studentId = null;
            boolean isValidInput = false;

            while (!isValidInput) {1
                System.out.print("삭제할 학생 번호를 입력하세요 : ");
                if (sc.hasNextLong()) {
                    studentId = sc.nextLong();
                    isValidInput = true; // 정상적인 입력일 경우 반복문 종료
                } 
                else {
                    System.out.println("정수를 입력하세요.");
                    sc.next(); // 입력 버퍼 비우기
                }
            }

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

            // 점수 정보 삭제
            Iterator<Score> scoreIterator = data.getScores().iterator();
            while (scoreIterator.hasNext()) {
                Score score = scoreIterator.next();
                if (score.getStudentId().equals(studentId)) {
                    scoreIterator.remove();
                }
            }

            if (targetStudent == null) {
                System.out.println("해당 학생이 없습니다.");
            }

            System.out.println();
            System.out.print("[추가 삭제를 원하면 1, 종료를 원하면 0을 입력하세요] : ");
            select = sc.nextInt();
        } while (select == 1);
    }
}
