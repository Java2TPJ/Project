package module;
import model.*;
import java.util.*;
import data.Data;
import exception.*;
public class UpdateScore {
    private Data data;
    Scanner sc = new Scanner(System.in);

    public UpdateScore(Data data) {
        this.data = data;
    }

    // 수강생의 과목별 회차 점수 수정
    public void updateScore() {
        // 추가 수정을 위해 입력받을 값
        int select = 0;

        do {
            try {
                // 점수 리스트에 해당 학생 번호가 있는지 확인
                boolean check1 = false;
                // 해당 학생의 과목에 대한 점수 기록이 있는지 확인
                boolean check2 = false;
                // 해당 회차가 존재하는지 확인
                boolean check3 = false;
                System.out.print("STEP1. 학생 번호를 입력하세요 : ");
                Long studentId = sc.nextLong();
                // STEP1. 입력받은 학생 번호에 해당하는 학생을 Score 저장소에 저장이 되어있는지 찾습니다.
                Long targetStudentId = checkStudentId(studentId);

                System.out.print("STEP2. 과목 번호를 입력하세요 : ");
                Long subjectId = sc.nextLong();
                // STEP2. 입력받은 학생 번호와 과목 번호에 해당하는 기록이 있는지 확인합니다.
                Long targetSubjectId = checkSubjectId(targetStudentId, subjectId);

                System.out.print("STEP3.수정할 회차 번호를 입력하세요. : ");
                int round = sc.nextInt();
                // STEP3. 입력받은 학생 번호, 과목 번호, 회차 번호를 통해 수정 지점을 찾고 점수를 입력받아 점수를 수정합니다.
                updateScoreForFound(targetStudentId, targetSubjectId, round);

                System.out.println("");
                System.out.print("[추가 수정을 원하면 1, 종료를 원할 시 아무 숫자 값을 눌러주세요.] :");
                select = sc.nextInt();
            } catch (StudentNotFoundOrNoScoresException|SubjectNotFoundOrNoScoresException|ScoreNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("예기치 않은 오류가 발생했습니다. 다시 시도해주세요.");
            }
        } while(select==1);
    }

    // STEP1. 입력받은 학생 번호에 해당하는 학생을 Score 저장소에 저장이 되어있는지 찾습니다.
    private Long checkStudentId(Long studentId) throws StudentNotFoundOrNoScoresException {
        boolean check1 = false;
        for(Score score : data.getScores()) {
            if (score.getStudentId().equals(studentId)) {
                check1 = true;
            }
        }
        if (!check1) {
            throw new StudentNotFoundOrNoScoresException();
        }
        return studentId;
    }

    // STEP2. 입력받은 학생 번호와 과목 번호에 해당하는 기록이 있는지 확인합니다.
    private Long checkSubjectId(Long targetStudentId, Long subjectId) throws SubjectNotFoundOrNoScoresException {
        boolean check2 = false;
        for (Score score : data.getScores()) {
            if (score.getStudentId().equals(targetStudentId) && score.getSubjectId().equals(subjectId)) {
                check2 = true;
            }
        }
        if(!check2) {
            throw new SubjectNotFoundOrNoScoresException();
        }
        return subjectId;
    }

    // STEP3. 입력받은 학생 번호, 과목 번호, 회차 번호를 통해 수정 지점을 찾고 점수를 입력받아 점수를 수정합니다.
    private void updateScoreForFound(Long targetStudentId, Long targetSubjectId, int round) throws ScoreNotFoundException {
        boolean check3 = false;
        for(Score score : data.getScores()) {
            if(score.getStudentId().equals(targetStudentId) && score.getSubjectId().equals(targetSubjectId) && score.getRound() == round) {
                check3 = true;
                System.out.print("새로운 점수를 입력하세요 : ");
                double newScore = sc.nextDouble();
                score.setScore(newScore);

                // 해당 과목 번호를 가지고 Subject객체를 조사하여 해당 과목에 대한 정보를 반환
                Subject subject = data.getSubjects().stream()
                        .filter(s -> s.getSubjectId().equals(targetSubjectId))
                        .findFirst().orElse(null);

                // 등급 업데이트
                if (subject != null) {
                    if ("ESSENTIAL".equals(subject.getSubjectType())) {
                        score.setGrade(data.EssentialGrade(newScore));
                    } else {
                        score.setGrade(data.SectGrade(newScore));
                    }
                }
                System.out.println("점수가 수정되었습니다.");
            }
        }
        if(!check3) {
            throw new ScoreNotFoundException();
        }
    }

}
