package module;
import model.*;
import java.util.*;
import data.Data;
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
            // 점수 리스트에 해당 학생 번호가 있는지 확인
            boolean check1 = false;
            // 해당 학생의 과목에 대한 점수 기록이 있는지 확인
            boolean check2 = false;
            // 해당 회차가 존재하는지 확인
            boolean check3 = false;
            System.out.print("STEP1. 학생 번호를 입력하세요 : ");
            Long studentId = sc.nextLong();
            // 입력받은 학생 번호에 해당하는 학생 객체를 찾습니다.

            for(Score score : data.getScores()) {
                if (score.getStudentId().equals(studentId)) {
                    check1 = true;
                    break;
                }
            }
            if(!check1) {
                System.out.println("해당 학생이 없거나 아직 점수가 입력되지 않았습니다.");
                return;
            }

            System.out.print("STEP2. 과목 번호를 입력하세요 : ");
            Long subjectId = sc.nextLong();

            for (Score score : data.getScores()) {
                if (score.getStudentId().equals(studentId) && score.getSubjectId().equals(subjectId)) {
                    check2 = true;
                    break;
                }
            }
            if(!check2) {
                System.out.println("해당 학생의 과목은 선택돼지 않았거나 아직 점수가 입력되지 않았습니다.");
                return;
            }

            System.out.print("STEP3.수정할 회차 번호를 입력하세요. : ");
            int round = sc.nextInt();

            for(Score score : data.getScores()) {
                if(score.getStudentId().equals(studentId) && score.getSubjectId().equals(subjectId) && score.getRound() == round) {
                    check3 = true;
                    System.out.print("새로운 점수를 입력하세요 : ");
                    int newScore = sc.nextInt();
                    score.setScore(newScore);

                    // 해당 과목 번호를 가지고 Subject객체를 조사하여 해당 과목에 대한 정보를 반환
                    Subject subject = data.getSubjects().stream()
                            .filter(s -> s.getSubjectId().equals(subjectId))
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
                    break;
                }
            }

            if(!check3) {
                System.out.println("입력하신 회차가 아직 점수가 등록되지 않았습니다.");
            }

            System.out.println("");
            System.out.print("[추가 수정을 원하면 1, 종료를 원할 시 아무 숫자 값을 눌러주세요.] :");
            select = sc.nextInt();
        } while(select==1);
    }
}
