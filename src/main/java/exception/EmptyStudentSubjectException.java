package exception;

public class EmptyStudentSubjectException extends Exception {
    public EmptyStudentSubjectException() {
        super("학생에게 등록된 과목이 없습니다.");
    }
}
