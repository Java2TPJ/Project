package module;

import model.*;
import data.Data;
import java.util.*;

public class StateGradeInfo {
    private Data data;
    private Scanner sc = new Scanner(System.in);
    private String[] states = {"Green", "Red", "Yellow"};

    public StateGradeInfo(Data data) {
        this.data = data;
    }

    public void stateGradeInfo() {
        int select;
        do {
            System.out.println("상태 목록: " + String.join(", ", states));
            System.out.print("상태를 입력하세요: ");
            String state = sc.nextLine();

            List<Student> students = data.getStudents();
            boolean check = false;

            // students 리스트의 모든 학생을 순회한다.
            // 입력한 state와 일치하면 check 변수를 true로 설정한다.
            for (Student student : students) {
                if (student.getState().equalsIgnoreCase(state)) {
                    check = true;
                    double totalScore = 0;
                    int count = 0;

                    // 해당 학생의 수강중인 과목 리스트를 가져오고 필수 과목인지 확인한다.
                    List<Subject> subjects = student.getStudentSubjects();
                    for (Subject subject : subjects) {
                        if ("ESSENTIAL".equals(subject.getSubjectType())) {
                            List<Score> scores = data.getScores();
                            // 점수 리스트에서 현재 학생과 현재 과목에 해당하는 점수를 찾는다.
                            // 해당 점수를 더하고 회차만큼 count를 증가시킨다.
                            for (Score score : scores) {
                                if (score.getStudentId().equals(student.getStudentId()) &&
                                        score.getSubjectId().equals(subject.getSubjectId())) {
                                    totalScore += score.getScore();
                                    count++;
                                }
                            }
                        }
                    }

                    if (count == 0) {
                        System.out.printf("학생 '%s' (ID: %d)의 필수 과목 점수가 없습니다.%n", student.getStudentName(), student.getStudentId());
                    } else {
                        double averageScore = totalScore / count;
                        String grade = data.EssentialGrade(averageScore);
                        System.out.printf("학생 '%s' (ID: %d)의 필수 과목 평균 등급: %s%n", student.getStudentName(), student.getStudentId(), grade);
                    }
                }
            }

            if (!check) {
                System.out.println("해당 상태의 수강생이 없습니다.");
            }

            System.out.println();
            System.out.print("[추가 조회를 원하면 1, 종료를 원할 시 0을 눌러주세요.] :");
            select = sc.nextInt();
            sc.nextLine(); // 개행 문자 삭제
        } while (select == 1);
    }
}
