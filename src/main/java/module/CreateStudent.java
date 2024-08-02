package module;

import data.Data;
import model.Subject;

import java.util.List;
import java.util.Scanner;

public class CreateStudent {
  Data data = new Data();
  private List<Subject> selectSubjects;
  Scanner sc = new Scanner(System.in);


  public CreateStudent(){}

  public CreateStudent(Data data){
    // 데이터 초기화 필요
    this.data = data;
  }



  public void addStudent(){
    System.out.print("이름 : ");
    String name = sc.next();
    data.printSubjects();
    for(int j=0; j<9; j++){
      if(j<5){
        // List에 넣기
        // 필수과목인지 선택과목인지 확인
        // count++(타입별 선택된 수)

      } else if (j >= 5){
        // 최소 필수과목 3개 이상 충족하는지
        // 최소 선택과목 2개 이상 충족하는지
        // 다시 넣기
      }
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
    System.out.println("\n==================================");
  }

}
