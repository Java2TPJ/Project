import view.MainView;
public class App {
    public static void main(String[] args) {
        MainView mainView = new MainView();
        try {
            mainView.displayView();
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage() + "\n프로그램을 종료합니다.");
        }
    }
}
