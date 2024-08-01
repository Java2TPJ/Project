package view;
import java.util.*;
import data.Data;
public class MainView implements View{
    private Data data;
    private Scanner sc = new Scanner(System.in);
    private ScoreView scoreView;
    private StudentView studentView;

    public MainView(Data data) {
        this.data = data;
        this.scoreView = new ScoreView(data); // Data 객체를 전달
        this.studentView = new StudentView(data);
    }

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
                case 1 -> studentView.displayView();
                case 2 -> scoreView.displayView(); // 점수 관리
                case 3 -> flag = false; // 프로그램 종료
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
