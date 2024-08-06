package exception;

public class WrongDeleteNameException extends Exception {
    public WrongDeleteNameException() {
        super("유효하지 않는 과목 번호입니다.");
    }
}
