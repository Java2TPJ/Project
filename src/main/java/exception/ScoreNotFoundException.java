package exception;

public class ScoreNotFoundException extends Exception {
    public ScoreNotFoundException() {
        super("입력하신 회차가 아직 점수가 등록되지 않았습니다.");
    }
}
