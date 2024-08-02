package module;

import data.Data;
import model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateStudent {
  Data data = new Data();

  Scanner sc = new Scanner(System.in);


  public CreateStudent(){}

  public CreateStudent(Data data){
    // 데이터 초기화 필요
    this.data = data;
  }



  public void addStudent(){
    List<Subject> subjects = data.getSubjects();
    List<Subject> selectSubjects = new ArrayList<>();
    System.out.print("이름 : ");
    String name = sc.next();
    int eCount = 0; // 필수과목 선택 수
    int sCount = 0; // 선택과목 선택 수
    // 해당 인덱스가 선택되어있는지 저장
    boolean[] is_select = {false, false, false, false, false, false, false, false, false};


    for(int j=0; j<9; j++){
      // 저장된 과목 출력
      System.out.println(selectSubjects.toString());
        // 과목 번호 입력 받음
        System.out.print((j+1) +"번째, 과목 번호 입력 : ");
        int select = sc.nextInt();
          if(select < 0 || select > 10){
            System.out.println("유효하지 않은 과목 번호입니다.");
          } else if(is_select[select] == true){
            System.out.println("이미 선택된 과목입니다.");
            j--;
          } else{
            // List에 넣기
            selectSubjects.add(subjects.get(select-1));
            // 해당 과목 선택되었다고 저장
            is_select[select] = true;
            // count++(타입별 선택된 수)
              if (select == 1 || select == 2 || select == 3 || select == 4 || select == 5){
                eCount++;
              } else {
                sCount++;
              }
          }

      if (j >= 4){
        if ((eCount >= 3) && (sCount >=2)){ // 최소 필수과목 3개 이상,선택과목 2개 이상 충족하면
          System.out.println("최소 선택 기준을 충족했습니다. 더 수강하시겠습니까?(yes)");
          String answer = sc.next();
            } else {
              // 원래 view로 돌아감
            }
        } else {
          // 현재 선택된 과목 타입별 수 안내
          System.out.println("필수 과목 " +eCount + "개, 선택 과목 "+sCount+ "개 선택되었습니다.");
        }

        // 다시 넣기
      }
    }



  public void printAllSubjects(Data data){
    System.out.println("==================================");
    List<Subject> subjects = data.getSubjects();
    for(int i=0; i < subjects.size(); i++){
      Subject subject = subjects.get(i);
      System.out.println((i+1)+". "
          + subject.getSubjectName() +
          "(" + subject.getSubjectType() + ")");
    }
    System.out.println("==================================");
  }

}
