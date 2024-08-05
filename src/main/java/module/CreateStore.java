package module;

import model.*;
import java.util.*;
import data.Data;

public class CreateStore {
    private Data data;
    Scanner sc = new Scanner(System.in);
    
    public CreateStore(Data data) {
        this.data = data;
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    public void addStore() {
        Student targetStudent = null;
        System.out.print("점수를 저장할 학생 번호를 입력하세요 : ");
        Long studentId = sc.nextLong();
        
        // 입력받은 학생 번호에 해당하는 학생 객체를 찾습니다.
        for(Student student : data.getStudents()) {
            if (student.getStudentId().equals(studentId)) {
                targetStudent = student;
                break;
            }
        }

        if (targetStudent == null) {
            System.out.println("해당 학생이 없습니다.");
            return;
        }
        
        // 학생의 과목 목록을 가져옵니다.
        List<Subject> subjects = targetStudent.getStudentSubjects();
        
        if (subjects.isEmpty()) {
            System.out.println("학생에게 등록된 과목이 없습니다.");
            return;
        }

        // 등록된 과목 목록을 출력합니다.
        System.out.println("등록된 과목 목록:");
        for (int j = 0; j < subjects.size(); j++) {
            System.out.println((j + 1) + ". " + subjects.get(j).getSubjectName());
        }
        
        System.out.print("점수를 등록할 과목 번호를 선택하세요: ");
        int subjectChoice = sc.nextInt();
        sc.nextLine(); // 개행 문자 삭제

        if (subjectChoice < 1 || subjectChoice > subjects.size()) {
            System.out.println("유효하지 않은 과목 번호입니다.");
            return;
        }

        // 선택한 과목을 가져옵니다.
        Subject selectedSubject = subjects.get(subjectChoice - 1);

        // 선택한 과목에 대해 회차와 점수 입력을 받습니다.
        while (true) {
            System.out.print("회차를 입력하세요 (1-10, 종료하려면 0 입력): ");
            int round = sc.nextInt();
            boolean check = false;
            sc.nextLine(); // 개행 문자 삭제

            if (round == 0) {
                break; // 종료 조건
            } else if (round < 1 || round > 10) {
                System.out.println("유효하지 않은 회차입니다. 1부터 10 사이의 숫자를 입력하세요.");
                continue;
            }

            // 이미 입력된 회차인지 검사합니다.
            for (Score score : data.getScores()) {
                if (targetStudent.getStudentId().equals(score.getStudentId()) &&
                        selectedSubject.getSubjectId().equals(score.getSubjectId()) &&
                        round == score.getRound()) {
                    check = true;
                    break;
                }
            }

            if (check) {
                System.out.println("동일한 회차를 입력하였습니다. 재입력해주세요.");
                continue;
            }

            // 점수 입력을 받습니다.
            System.out.print(round + "회차 점수를 입력하세요: ");
            int scoreValue = sc.nextInt();
            sc.nextLine(); // 개행 문자 삭제

            // 점수에 대한 등급을 결정합니다.
            String grade;
            if ("ESSENTIAL".equals(selectedSubject.getSubjectType())) {
                grade = data.EssentialGrade(scoreValue);
            } else {
                grade = data.SectGrade(scoreValue);
            }

            // 입력된 점수와 등급을 데이터에 추가합니다.
            data.getScores().add(new Score(targetStudent.getStudentId(), selectedSubject.getSubjectId(), round, scoreValue, grade));

            System.out.println(round + "회차 점수 " + scoreValue + "점, 등급 " + grade + "이(가) 등록되었습니다.");
        }
    }
}
