import view.MainView;
import data.Data;
import model.*;
public class App {
    public static void main(String[] args) {
        Data data = new Data();
        // 데이터 저장소 초기화
        data.setInitData();

        MainView mainView = new MainView(data);
        try {
            mainView.displayView();
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage() + "\n프로그램을 종료합니다.");
        }
    }
}
