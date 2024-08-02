package module;


import data.Data;
import model.Student;

import java.util.List;
import java.util.Scanner;

// 수강생 목록 조회 - 혜민님
public class StudentList {
  Data data = new Data();
  Scanner sc = new Scanner(System.in);

  public StudentList(){}
  public StudentList(Data data){
    this.data = data;
  }

  public void printStudentAll(){
    List<Student> students = data.getStudents();
    System.out.println("==================================");
    for(int i=0; i<data.getStudents().size(); i++){
      System.out.println(students.get(i).getStudentId() +
          ", " +
          students.get(i).getStudentName());
    }
    System.out.println("==================================");

    boolean answerYes = true;
    while(answerYes){
      System.out.println("수강생 관리 목록으로 돌아가시겠습니까? (yes)");
      String answer = sc.next();
      if(answer.equals("yes")){
        answerYes = false;
      }
    }



  }
}
