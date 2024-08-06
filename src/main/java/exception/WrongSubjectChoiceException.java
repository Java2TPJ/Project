package exception;

public class WrongSubjectChoiceException extends Exception {
    public WrongSubjectChoiceException() {
        super("유효하지 않는 과목 번호입니다.");
    }
}
