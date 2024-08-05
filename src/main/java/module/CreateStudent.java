package module;

import data.Data;
import model.Student;
import model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateStudent {
  Data data = new Data();

  Scanner sc = new Scanner(System.in);

  String[] array = {"Green", "Red", "Yellow"};


  public CreateStudent(){}

  public CreateStudent(Data data){
    // 데이터 초기화 필요
    this.data = data;
  }



  public void studentSelect(){
    List<Subject> subjects = data.getSubjects();
    List<Subject> selectSubjects = new ArrayList<>();

    // 이름 입력받음
    String name = "";
    boolean validName = false;
    while(!validName){
      System.out.print("이름 : ");
      name = sc.nextLine();
      if(name == "" || name == "\n"){
        System.out.println("이름을 입력해주세요.");
      } else {
        validName = true;
        break;
      }
    }

    
    // state 입력받음
    //24-08-04 추가 학생 상태 입력 하고 일치하는지 검증 36 line ~ 53 line
    String state = "";
    boolean validState = false;
    while (!validState) {
      System.out.println("상태 목록: " + String.join(", ", array));
      System.out.print("상태 : ");
      state = sc.nextLine();
      for (String i : array) {
        if (state.equals(i)) {
          validState = true;
          break;
        }
      }
      if (!validState) {
        System.out.println("일치하지 않습니다. 다시 입력해주세요.");
      }
    }


    int eCount = 0; // 필수과목 선택 수
    int sCount = 0; // 선택과목 선택 수
    // 해당 인덱스가 선택되어있는지 저장
    boolean[] is_select = new boolean[subjects.size()];


    for(int j=0; j<10; j++){
        // 과목 번호 입력 받음
        System.out.print((j+1) +"번째, 과목 번호 입력 : ");
        int select = Integer.parseInt(sc.nextLine());
          if(select < 0 || select > 10){
            System.out.println("유효하지 않은 과목 번호입니다.");
          } else if(is_select[select - 1] == true){
            System.out.println("이미 선택된 과목입니다.");
            j--;
          } else{
            // List에 넣기
            selectSubjects.add(subjects.get(select-1));
            // 해당 과목 선택되었다고 저장
            is_select[select - 1] = true;
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
          if(answer.equals("yes")){

          } else {
            // 저장
            addStudent(name, selectSubjects, state);
            System.out.println("[새로운 수강생이 저장되었습니다. 이름 : "+ name+"]");
            return;
          }
        }
      }
      System.out.println("필수 과목 " +eCount + "개, 선택 과목 "+sCount+ "개 선택되었습니다.");
    }
  }

  public void addStudent(String name, List<Subject> studentSubjects, String state){
    data.getStudents().add(new Student(name, studentSubjects, state)); // 만든것을 내놔야함
  }

  // 수강 과목 리스트 불러옴
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
