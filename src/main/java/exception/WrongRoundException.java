package exception;

public class WrongRoundException extends Exception {
    public WrongRoundException() {
        super("동일한 회차를 입력하였습니다. 재입력해주세요.");
    }
}
