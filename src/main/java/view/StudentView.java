package view;
import data.Data;
import java.util.*;
import module.*;

public class StudentView implements View{

    private Data data;
    private CreateStudent createStudent;
    private StudentInfo studentInfo;
    Scanner sc = new Scanner(System.in);

    public StudentView(Data data) {
        this.data = data;
        this.createStudent = new CreateStudent(data);
        this.studentInfo = new StudentInfo(data);
    }
    @Override
    public void displayView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 수강생 정보 조회");
            System.out.println("4. 수강생 정보 수정");       //추가 요구사항
            System.out.println("5. 수강생 삭제");           //추가 요구사항
            System.out.println("6. 상태별 수강생 목록 조회"); //추가 요구사항
            System.out.println("7. 메인 화면 이동");
            System.out.println("\n==================================");
            System.out.print("번호 입력 : ");
            int i = sc.nextInt();

            switch (i) {
                case 1 -> {
                    createStudent.printAllSubjects(data); // 과목 출력
                    createStudent.studentSelect();
                }
                case 2 -> {} // 수강생 목록 조회
                case 3 -> studentInfo.showInfo(); // 수강생 정보 조회
                case 4 -> {} // 수강생 정보 수정
                case 5 -> {} // 수강생 삭제
                case 6 -> {} // 상태별 수강생 목록 조회
                case 7 -> flag = false; // 메인 화면 이동
            }
        }
    }
}
