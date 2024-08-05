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
            System.out.print("학생 번호를 입력하세요 : ");
            Long studentId = sc.nextLong();
            // 입력받은 학생 번호에 해당하는 학생 객체를 찾습니다.

            for(Score score : data.getScores()) {
                if (score.getStudentId().equals(studentId)) {

                    check1 = true;
                    break;
                }
            }

            if(check1 == false) {
                System.out.println("해당 학생은 아직 점수가 입력되지 않았습니다.");
                return;
            }

            System.out.print("과목 번호를 입력하세요 : ");
            Long subjectId = sc.nextLong();


            if(check2 == false) {
                System.out.println("해당 학생의 과목은 선택돼지 않았거나 아직 점수가 입력되지 않았습니다.");
                return;
            }

            System.out.print("수정할 회차 번호를 입력하세요. : ");
            int round = sc.nextInt();



            System.out.println("");
            System.out.print("[추가 수정을 원하면 1, 종료를 원할 시 아무 숫자 값을 눌러주세요.] :");
            select = sc.nextInt();
        } while(select==1);
    }
}
