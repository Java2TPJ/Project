package module;


import data.Data;

// 수강생 목록 조회 - 혜민님
public class StudentList {
  Data data = new Data();

  public StudentList(){}
  public StudentList(Data data){
    this.data = data;
  }

  public void printStudentAll(){
    for(int i=0; i<data.getStudents().size(); i++){
      System.out.println("Id : " + data.getStudents().get(i).getStudentId() +
          ", 이름" +
          data.getStudents().get(i).getStudentName());
    }
  }
}
