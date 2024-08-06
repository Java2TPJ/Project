package exception;

public class SubjectNotFoundOrNoScoresException extends Exception {
    public SubjectNotFoundOrNoScoresException() {
        super("해당 학생의 과목은 선택돼지 않았거나 아직 점수가 입력되지 않았습니다.");
    }
}
