package view;

import model.*;
import java.util.*;
import data.Data;
import module.*;

public class ScoreView implements View{
    private Data data;
    private CreateStore createStore;
    private UpdateScore updateScore;
    private AvgScore avgScore;
    private StateGradeInfo stateGradeInfo;
    private StudentList studentList;
    Scanner sc = new Scanner(System.in);
    public ScoreView(Data data) {
        this.data = data;
        this.createStore = new CreateStore(data);
        this.updateScore = new UpdateScore(data);
        this.avgScore = new AvgScore(data);
        this.stateGradeInfo = new StateGradeInfo(data);
        this.studentList = new StudentList(data);
    }


    @Override
    public void displayView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 수강생의 과목별 평균 등급 조회");                 //추가 요구사항
            System.out.println("5. 특정 상태 수강생들의 필수 과목 평균 등급 조회");    //추가 요구사항
            System.out.println("6. 전체 점수 목록 조회");
            System.out.println("7. 메인 화면 이동");
            System.out.println("\n==================================");
            System.out.print("번호 입력 : ");
            int i = sc.nextInt();
            sc.nextLine(); // 개행 문자 삭제

            switch (i) {
                case 1 -> createStore.addStore(); // 수강생의 과목별 시험 회차 및 점수 등록
                case 2 -> updateScore.updateScore(); // 수강생의 과목별 회차 점수 수정
                case 3 -> studentList.roundRatingList(); // 수강생의 특정 과목 회차별 등급 조회
                case 4 -> avgScore.avgScore(); // 수강생의 과목별 평균 등급 조회
                case 5 -> stateGradeInfo.stateGradeInfo();    // 특정 상태 수강생들의 필수 과목 평균 등급 조회
                case 6 -> data.printScores(); // 전체 점수 목록 조회
                case 7 -> flag = false; // 메인 화면 이동
            }
        }
    }
}
