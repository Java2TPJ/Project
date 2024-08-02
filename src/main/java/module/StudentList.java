package module;


import data.Data;
import model.Student;

import java.util.List;

// 수강생 목록 조회 - 혜민님
public class StudentList {
  Data data = new Data();

  public StudentList(){}
  public StudentList(Data data){
    this.data = data;
  }

  public void printStudentAll(){
    List<Student> students = data.getStudents();
    for(int i=0; i<data.getStudents().size(); i++){
      System.out.println(students.get(i).getStudentId() +
          ", " +
          students.get(i).getStudentName());
    }
  }
}
