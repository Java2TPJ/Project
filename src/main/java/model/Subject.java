package model;

import java.util.*;

public class Subject {
    private static Long nextSubjectId = 1L;
    private Long subjectId;     // 고유 번호
    private String subjectName; // 과목 이름
    private String subjectType; // 과목 타입

    public Subject(String subjectName, String subjectType) {
        this.subjectId = nextSubjectId++;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }
}
