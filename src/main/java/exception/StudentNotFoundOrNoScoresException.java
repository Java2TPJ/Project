package exception;

public class StudentNotFoundOrNoScoresException extends Exception {
    public StudentNotFoundOrNoScoresException() {
        super("해당 학생이 없거나 아직 점수가 입력되지 않았습니다.");
    }
}
