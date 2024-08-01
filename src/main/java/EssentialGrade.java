public class EssentialGrade {
    public char EssentialGrade(int Score) {
        char Grade;
        if ((Score >= 95) && (Score <= 100)) {
            Grade = 'A';
            return Grade;
        } else if ((Score >= 90) && (Score <= 94)) {
            Grade = 'B';
            return Grade;
        } else if ((Score >= 80) && (Score <= 89)) {
            Grade = 'C';
            return Grade;
        } else if ((Score >= 70) && (Score <= 79)) {
            Grade = 'D';
            return Grade;
        } else if ((Score >= 60) && (Score <= 69)) {
            Grade = 'F';
            return Grade;
        } else {
            Grade = 'N';
            return Grade;
        }
    }
}
