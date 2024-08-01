package view;
import java.util.*;
public class MainView implements View{

    Scanner sc = new Scanner(System.in);
    ScoreView scoreView = new ScoreView();
    StudentView studentView = new StudentView();


    @Override
    public void displayView() {
        boolean flag = true;
        while(flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.println("\n==================================");
            System.out.print("번호 입력 : ");
            int i = sc.nextInt();

            switch (i) {
                case 1 -> { // 수강생 관리
                    studentView.displayView();
                }
                case 2 -> scoreView.displayView(); // 점수 관리
                case 3 -> flag = false; // 프로그램 종료
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
