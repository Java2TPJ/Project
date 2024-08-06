package module;

import model.*;
import java.util.*;
import data.Data;

public class ReNameStore {
    private Data data;
    private Scanner sc = new Scanner(System.in);
    
    public ReNameStore(Data data) {
        this.data = data;
    }

    public void reName() {
        Student targetStudent = null;
        
        try {
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
            
            
            System.out.print("수정할 항목을 입력하세요. (이름:1, 상태:2): ");
            int selectPart = sc.nextInt();
            sc.nextLine(); // consume newline left by nextInt()
        
            if (selectPart == 1) {
                System.out.print("새로운 이름을 입력하세요: ");
                String newName = sc.nextLine().trim(); // trim()으로 공백 제거
                
                if (newName.isEmpty()) {
                    System.out.println("올바른 이름을 입력하세요.");
                } else if (containsSpecialCharacters(newName)) {
                    System.out.println("잘못된 입력입니다. 특수 문자 없이 다시 입력하세요.");
                } else {
                    targetStudent.setStudentName(newName); // 학생의 이름을 수정합니다.
                    System.out.println("학생의 이름이 수정되었습니다.");
                }
                
            } else if (selectPart == 2) {
                System.out.print("새로운 상태를 입력하세요(Green:1, Red:2, Yellow:3): ");
                int newState = sc.nextInt();
                sc.nextLine(); 
                
                switch (newState) {
                    case 1:
                        targetStudent.setState("Green");
                        break;
                    case 2:
                        targetStudent.setState("Red");
                        break;
                    case 3:
                        targetStudent.setState("Yellow");
                        break;
                    default:
                        System.out.println("올바른 항목을 선택하세요.");
                        return;
                }
                
                System.out.println("학생의 상태가 수정되었습니다.");
            } else {
                System.out.println("올바른 항목을 선택하세요.");
            }
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력 형식입니다. 정수를 입력하세요.");
            sc.nextLine(); // 버퍼 비우기
        }
    }
    
    // 특수 문자 포함 여부를 검사하는 메서드
    private boolean containsSpecialCharacters(String str) {
        // 한국어와 영어만 허용
        return !str.matches("[a-zA-Z가-힣 ]*");
    }
}
