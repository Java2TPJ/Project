package module;

import model.*;
import java.util.*;
import data.Data;

public class ReNameStore {
    private Data data;
    Scanner sc = new Scanner(System.in);
    
    public ReNameStore(Data data) {
        this.data = data;
    }

    public void reName() {
        Student targetStudent = null;
        
        System.out.print("수정할 학생 번호를 입력하세요 : ");
        Long studentId = sc.nextLong();
        sc.nextLine(); // 개행 문자 처리
        
        // 입력받은 학생 번호에 해당하는 학생 객체를 찾습니다.
        for (Student student : data.getStudents()) {
            if (student.getStudentId().equals(studentId)) {
                targetStudent = student;
                break;
            }
        }

        if (targetStudent == null) {
            System.out.println("해당 학생이 없습니다.");
            return;
        }
        
        System.out.print("새로운 이름을 입력하세요: ");
        String newName = sc.nextLine();
        
        targetStudent.setStudentName(newName); // 학생의 이름을 수정합니다.
        
        System.out.println("학생의 이름이 수정되었습니다.");
    }
}
