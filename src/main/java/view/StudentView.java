package view;
import data.Data;
import java.util.*;
import module.*;

public class StudentView implements View{

    private Data data;
    private CreateStudent createStudent;
    private StudentInfo studentInfo;
    private StudentList studentsList;
    private DeleteStudent deleteStudent; // 추가: DeleteStudent 객체 추가
    private ReNameStore reNameStore;
    Scanner sc = new Scanner(System.in);

    public StudentView(Data data) {
        this.data = data;
        this.createStudent = new CreateStudent(data);
        this.studentInfo = new StudentInfo(data);
        this.studentsList = new StudentList(data);
        this.deleteStudent = new DeleteStudent(data);
        this.reNameStore = new ReNameStore(data);
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
            try {
                int i = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기
                switch (i) {
                    case 1 -> {
                        createStudent.studentSelect();
                    }
                    case 2 -> studentsList.printStudentAll();// 수강생 목록 조회
                    case 3 -> studentInfo.showInfo(); // 수강생 정보 조회
                    case 4 -> reNameStore.reName(); // 수강생 정보 수정
                    case 5 -> deleteStudent.deleteStudent();// 수강생 삭제
                    case 6 -> {studentsList.stateStudentList();} // 상태별 수강생 목록 조회
                    case 7 -> flag = false; // 메인 화면 이동
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                sc.nextLine(); // 버퍼 비우기
            }
        }
    }
}
