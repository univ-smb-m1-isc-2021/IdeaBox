package com.example.ideabox.Answer;

public class AnswerForm {

    private long questionId;
    private String value;
    private String userId;

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userIdForApp) {
        this.userId = userIdForApp;
    }
}
