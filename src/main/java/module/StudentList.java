package module;


import data.Data;
import model.Student;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentList {
  Data data = new Data();
  Scanner sc = new Scanner(System.in);

  public StudentList(){}
  public StudentList(Data data){
    this.data = data;
  }

  // (1-2) 수강생 목록 조회 - 혜민
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

  // (1-3) 상태별 수강생 목록 조회 - 혜민
  public void stateStudentList(){
    List<Student> students = data.getStudents();
    System.out.println("==================================");
    // state == Green
    System.out.println("< State = Green >");
    List<Student> greenStudents = students.stream().filter(t -> t.getState().equals("Green")).collect(Collectors.toList());
    for(int i=0; i<greenStudents.size(); i++){
      System.out.println("("+greenStudents.get(i).getStudentId()+ ")" +greenStudents.get(i).getStudentName() + ", " + greenStudents.get(i).getState());
    }
    System.out.println("----------------------------------");
    // state == Red
    System.out.println("< State = Red >");
    List<Student> RedStudents = students.stream().filter(t -> t.getState().equals("Red")).collect(Collectors.toList());
    for(int i=0; i<RedStudents.size(); i++){
      System.out.println("("+RedStudents.get(i).getStudentId()+ ")" +RedStudents.get(i).getStudentName() + ", " + RedStudents.get(i).getState());
    }
    System.out.println("----------------------------------");
    // state == Yellow
    System.out.println("< State = Yellow >");
    List<Student> YellowStudents = students.stream().filter(t -> t.getState().equals("Yellow")).collect(Collectors.toList());
    for(int i=0; i<YellowStudents.size(); i++){
      System.out.println("("+YellowStudents.get(i).getStudentId()+ ")" +YellowStudents.get(i).getStudentName() + ", " + YellowStudents.get(i).getState());
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
