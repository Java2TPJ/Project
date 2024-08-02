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
        // 학생의 과목 목록 출력
        List<Subject> subjects = targetStudent.getStudentSubjects();
        if (subjects.isEmpty()) {
            System.out.println("학생에게 등록된 과목이 없습니다.");
            return;
        }

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

        // 해당 학생의 과목 목록을 새로운 List에 담았기 때문에 [Spring, 디자인패턴, 등등] 이라고 입력이 되어있기 때문에
        // 출력되는 각 과목 번호는 리스트에 대입되어 있는 번호에서 -1 해야지 같다.
        Subject selectedSubject = subjects.get(subjectChoice - 1);

        // 선택한 과목에 대해 회차와 점수 입력
        while (true) {
            System.out.print("회차를 입력하세요 (1-10, 종료하려면 0 입력): ");
            int round = sc.nextInt();
            sc.nextLine(); // 개행 문자 삭제

            if (round == 0) {
                break; // 종료 조건
            } else if (round < 1 || round > 10) {
                System.out.println("유효하지 않은 회차입니다. 1부터 10 사이의 숫자를 입력하세요.");
                continue;
            }

            // 같은 회차에 점수 넣는 것을 방지 하기 위해서 check 변수에 false값 설정
            // 이미 저장이 되어있을거기 때문에 scores 리스트에서 값들을 가져오고 현재 입력을 받는 회원의 Id와 과목 Id가 일치하는 값을 찾고
            // 입력받은 round 값이 scores에 존재 하는지 검사 맞다면 check값을 true로 변경
            boolean check = false;

            System.out.print(round + "회차 점수를 입력하세요: ");
            int score = sc.nextInt();
            sc.nextLine(); // 개행 문자 삭제

            // 점수에 대한 등급 배분
            String grade;
            if ("ESSENTIAL".equals(selectedSubject.getSubjectType())) {
                grade = data.EssentialGrade(score);
            } else {
                grade = data.SectGrade(score);
            }
            System.out.println("확인용 학생 : "+targetStudent.getStudentId());
            System.out.println("확인용 과목 : "+selectedSubject.getSubjectId());
            data.getScores().add(new Score(targetStudent.getStudentId(), selectedSubject.getSubjectId(), round, score, grade));

            System.out.println(round + "회차 점수 " + score + "점, 등급 " + grade + "이(가) 등록되었습니다.");
        }
    }
}
