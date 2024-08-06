package exception;

public class SameRoundException extends Exception {
    public SameRoundException() {
        super("동일한 회차를 입력하였습니다. 재입력해주세요.");
    }
}
