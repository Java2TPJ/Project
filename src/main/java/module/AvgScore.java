package module;

import model.Score;
import model.Subject;
import data.Data;
import java.util.Scanner;

public class AvgScore {
    private Data data;
    Scanner sc = new Scanner(System.in);
    double sumScore = 0;
    double saveRound = 0;
    double resultScore;

    public AvgScore(Data data) {
        this.data = data;
    }

    // 수강생의 과목별 회차 점수 및 평균 출력
    public void avgScore() {
        System.out.print("학생 번호를 입력하세요 : ");
        Long studentId = sc.nextLong();

        System.out.print("과목 번호를 입력하세요 : ");
        Long subjectId = sc.nextLong();

        boolean found = false;

        for (Score score : data.getScores()) {
            if (score.getStudentId().equals(studentId) && score.getSubjectId().equals(subjectId)) {
                System.out.println("회차: " + score.getRound());
                System.out.println("점수: " + score.getScore());
                System.out.println("등급: " + score.getGrade());
                System.out.println("-----------------------------");
                found = true;
                sumScore += score.getScore();
                saveRound++;
            }
        }

        if (!found) {
            System.out.println("해당 학생의 과목에 대한 점수가 없습니다.");
            return;
        }

        resultScore = sumScore / saveRound;
        System.out.println("평균 점수: " + resultScore);

        // 과목 타입 가져오기
        Subject subject = data.getSubjects().stream()
                .filter(s -> s.getSubjectId().equals(subjectId))
                .findFirst().orElse(null);

        if (subject != null) {
            String subjectType = subject.getSubjectType();
            if ("ESSENTIAL".equals(subjectType)) {
                System.out.println("평균 등급: " + data.EssentialGrade((int) resultScore));
            } else if ("SELECT".equals(subjectType)) {
                System.out.println("평균 등급: " + data.SectGrade((int) resultScore));
            } else {
                System.out.println("평균 등급을 계산할 수 없습니다.");
            }
        } else {
            System.out.println("해당 과목 정보를 찾을 수 없습니다.");
        }
    }
}
