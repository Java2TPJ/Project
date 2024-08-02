package module;

import data.Data;
import model.Subject;

import java.util.List;
import java.util.Scanner;

public class CreateStudent {
  Data data = new Data();
  Scanner sc = new Scanner(System.in);


  public CreateStudent(){}

  public CreateStudent(Data data){
    this.data = data;
    //데이터 초기화
    data.setInitData();
  }

  public void addStudent(){
    System.out.print("이름 : ");
    String name = sc.next();
    data.printSubjects();
    for(int j=0; j<9; j++){
      if(j<5){

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
    System.out.println("==================================");
  }

}
