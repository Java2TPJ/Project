package exception;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException() {
        super("해당 학생이 없습니다.");
    }
}
