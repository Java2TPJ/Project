package view;

import model.*;
import java.util.*;

public class ScoreView implements View{
    Scanner sc = new Scanner(System.in);

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    @Override
    public void displayView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 수강생의 과목별 평균 등급 조회");                 //추가 요구사항
            System.out.println("5. 특정 상태 수강생들의 필수 과목 평균 등급 조회");    //추가 요구사항
            System.out.println("6. 메인 화면 이동");
            System.out.println("\n==================================");
            System.out.print("번호 입력 : ");
            int i = sc.nextInt();
            sc.nextLine(); // 개행 문자 삭제

            switch (i) {
                case 1 -> createStore(); // 수강생의 과목별 시험 회차 및 점수 등록
                case 2 -> {} // 수강생의 과목별 회차 점수 수정
                case 3 -> {} // 수강생의 특정 과목 회차별 등급 조회
                case 4 -> {} // 수강생의 과목별 평균 등급 조회
                case 5 -> {} // 특정 상태 수강생들의 필수 과목 평균 등급 조회
                case 6 -> flag = false; // 메인 화면 이동
            }
        }
    }

    List<Student> students = new ArrayList<>();
    List<Score> scores = new ArrayList<>();
    // 수강생의 과목별 시험 회차 및 점수 등록
    public void createStore() {
        Student targetStudent = null;
        System.out.print("점수를 저장할 학생 이름을 입력하세요 : ");
        String studentName = sc.nextLine();
        for(Student student : students) {
            if (student.getStudentName().equals(studentName)) {
                targetStudent = student;
                break;
            }
        }

        if (targetStudent == null) {
            System.out.println("해당 이름의 학생이 없습니다.");
            return;
        }

        for(Subject subject : targetStudent.getStudentSubjects()) {
            System.out.println("[과목이름] 시험 점수 등록");
            for(int i = 0; i<10; i++) {
                System.out.print((i+1)+"회차 [과목이름] 점수를 입력하세요. : ");
                int score = sc.nextInt();
                String grade = null;

                scores.add(new Score(targetStudent.getStudentId(), subject.getSubjectId(), (i+1), score, grade));
            }
        }
    }
}
