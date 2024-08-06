package module;

import model.*;
import java.util.*;
import data.Data;
import exception.*;

public class CreateStore {
    private Data data;
    private Scanner sc = new Scanner(System.in);

    public CreateStore(Data data) {
        this.data = data;
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    public void addStore() {
        while (true) {
            try {
                System.out.print("점수를 저장할 학생 번호를 입력하세요 : ");
                Long studentId = sc.nextLong();

                // 입력받은 학생 번호에 해당하는 학생 객체를 찾습니다.
                Student targetStudent = findStudentById(studentId);

                // 학생의 과목 목록을 가져옵니다.
                List<Subject> subjects = getStudentSubjects(targetStudent);
                System.out.println("등록된 과목 목록:");
                for (int j = 0; j < subjects.size(); j++) {
                    System.out.println((j + 1) + ". " + subjects.get(j).getSubjectName());
                }

                // 점수를 입력할 과목을 입력받습니다.
                Subject selectedSubject = selectSubject(subjects);

                // 선택한 과목에 대해 회차와 점수 입력을 받습니다.
                enterScores(targetStudent, selectedSubject);

                break; // 모든 입력이 성공적으로 완료되면 루프를 종료
            } catch (StudentNotFoundException | EmptyStudentSubjectException | WrongSubjectChoiceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("예기치 않은 오류가 발생했습니다. 다시 시도해주세요.");
            }
        }
    }

    // 하위 2개는

    // 과목 선택
    private Subject selectSubject(List<Subject> subjects) throws WrongSubjectChoiceException {
        while (true) {
            try {
                System.out.print("점수를 등록할 과목 번호를 선택하세요: ");
                int subjectChoice = sc.nextInt();
                sc.nextLine(); // 개행 문자 삭제

                // 유효한 과목 번호인지 확인
                return subjectChoice(subjectChoice, subjects);
            } catch (WrongSubjectChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 점수 입력
    private void enterScores(Student targetStudent, Subject selectedSubject) {
        while (true) {
            try {
                System.out.print("회차를 입력하세요 (1-10, 종료하려면 0 입력): ");
                int round = sc.nextInt();
                sc.nextLine(); // 개행 문자 삭제

                if (round == 0) {
                    break; // 종료 조건
                }

                // 1~10 사이의 회차를 입력받았는지 확인
                checkRound(round);

                // 이미 입력된 회차인지 검사합니다.
                sameCheckRound(targetStudent, selectedSubject, round);

                // 점수 입력을 받습니다.
                System.out.print(round + "회차 점수를 입력하세요: ");
                double scoreValue = sc.nextDouble();
                sc.nextLine(); // 개행 문자 삭제

                // 점수에 대한 등급을 결정합니다.
                String grade;
                if ("ESSENTIAL".equals(selectedSubject.getSubjectType())) {
                    grade = data.EssentialGrade(scoreValue);
                } else {
                    grade = data.SectGrade(scoreValue);
                }

                // 입력된 점수와 등급을 데이터에 추가합니다.
                data.getScores().add(new Score(targetStudent.getStudentId(), selectedSubject.getSubjectId(), round, scoreValue, grade));
                System.out.println(round + "회차 점수 " + scoreValue + "점, 등급 " + grade + "이(가) 등록되었습니다.");
            } catch (WrongRoundException | SameRoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 이 아래는 Exception 처리 동작

    // 등록한 학생이 있는지 없는지를 검사
    private Student findStudentById(Long studentId) throws StudentNotFoundException {
        for (Student student : data.getStudents()) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        throw new StudentNotFoundException();
    }

    // 학생에게 등록된 과목이 있는지 확인
    private List<Subject> getStudentSubjects(Student targetStudent) throws EmptyStudentSubjectException {
        List<Subject> subjects = targetStudent.getStudentSubjects();
        if (subjects.isEmpty()) {
            throw new EmptyStudentSubjectException();
        }
        return subjects;
    }

    // 유효한 과목번호인지 확인
    private Subject subjectChoice(int subjectChoice, List<Subject> subjects) throws WrongSubjectChoiceException {
        if (subjectChoice < 1 || subjectChoice > subjects.size()) {
            throw new WrongSubjectChoiceException();
        }
        return subjects.get(subjectChoice - 1);
    }

    // 1~10 사이의 회차를 입력했는지 확인
    private void checkRound(int round) throws WrongRoundException {
        if (round < 1 || round > 10) {
            throw new WrongRoundException();
        }
    }

    // 동일한 회차를 입력하려고 하는지 확인
    private void sameCheckRound(Student student, Subject subject, int round) throws SameRoundException {
        for (Score score : data.getScores()) {
            if (student.getStudentId().equals(score.getStudentId()) &&
                    subject.getSubjectId().equals(score.getSubjectId()) &&
                    round == score.getRound()) {
                throw new SameRoundException();
            }
        }
    }
}
