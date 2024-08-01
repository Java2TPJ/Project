package model;

import java.util.*;

public class Subject {
    private UUID subjectId;     // 고유 번호
    private String subjectName; // 과목 이름
    private String subjectType; // 과목 타입

    public Subject(String subjectName, String subjectType) {
        this.subjectId = UUID.randomUUID();
        this.subjectName = subjectName;
        this.subjectType = subjectType;
    }

    public UUID getSubjectId() {
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
