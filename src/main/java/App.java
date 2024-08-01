import view.MainView;
import data.Data;
import model.*;
public class App {
    public static void main(String[] args) {
        MainView mainView = new MainView();
        Data data = new Data();

        // 데이터 저장소 초기화
        data.setInitData();

        // 데이터 저장소 확인용 (추후 삭제 예정)
//        System.out.println("과목 리스트:");
//        for (Subject subject : data.getSubjects()) {
//            System.out.println("과목명: " + subject.getSubjectName() + ", 과목 타입: " + subject.getSubjectType());
//        }

        try {
            mainView.displayView();
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage() + "\n프로그램을 종료합니다.");
        }
    }
}
