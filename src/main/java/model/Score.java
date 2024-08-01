package model;

import java.util.*;

public class Score {
    private UUID subjectId;
    private UUID studentId;
    private int round;
    private int score;
    private String grade;

    public Score(UUID subjectId, UUID studentId, int round, int score, String grade) {
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.round = round;
        this.score = score;
        this.grade = grade;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(UUID subjectId) {
        this.subjectId = subjectId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
