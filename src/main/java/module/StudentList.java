package module;


import data.Data;
import model.Score;
import model.Student;
import model.Subject;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

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

  // (2-3) 수강생의 특정 과목 회차별 등급 조회
  public void roundRatingList(){
    Student targetStudent = null;
    boolean answerNo = true;
    List<Score> scores = data.getScores();
    while(answerNo){
      System.out.print("조회할 수강생의 번호를 입력 : ");
      Long studentId = sc.nextLong();
      sc.nextLine();
      for(Student student : data.getStudents()){
        if(student.getStudentId().equals(studentId)){
          targetStudent = student;
          // 해당 수강생의 수강 과목 출력
          for(int i=0; i<targetStudent.getStudentSubjects().size(); i++){
            System.out.println("("+targetStudent.getStudentSubjects().get(i).getSubjectId()+")"+targetStudent.getStudentSubjects().get(i).getSubjectName());
          }

          System.out.print("조회할 과목 입력 : ");
          Long subjectNumber = sc.nextLong();
          sc.nextLine();
          System.out.println("==================================");
          for (Subject subject1 : data.getSubjects()) {
            if (subject1.getSubjectId().equals(subjectNumber)) {
              System.out.println(subject1.getSubjectName());
            }
          }
          System.out.println("----------------------------------");
          // 회차순
          List<Score> filteredScores = scores.stream()
              .filter(score -> score.getStudentId().equals(studentId) && score.getSubjectId().equals(subjectNumber))
              .sorted()
              .collect(Collectors.toList());
          for(Score score : filteredScores){
            System.out.println(score.getRound()+"회차, " + score.getGrade() + "등급");
          }


          // 입력순
//          for(int j=0; j<scores.size(); j++){
//            if(scores.get(j).getStudentId().equals(studentId)){
//              if(scores.get(j).getSubjectId().equals(subjectNumber)){
//                System.out.println(scores.get(j).getRound()+"회차, 등급:" + scores.get(j).getGrade());
//              }
//            }
//          }
          //
          System.out.print("다른 과목의 회차별 등급도 확인하시겠습니까? (yes or no) : ");
          String answer = sc.nextLine();
          if(answer.equals("yes")){
            answerNo = true;
          } else {
            answerNo = false;
          }
        }
      }
      if(targetStudent == null){
        System.out.println("해당 학생은 존재하지않습니다.");
      }
    }
  }

}
