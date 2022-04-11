package com.example.ideabox.Question;

public class QuestionChangeNeutralForm {

    private long questionId;

    private boolean allowNeutral;

    public QuestionChangeNeutralForm(long questionId, boolean allowNeutral) {
        this.questionId = questionId;
        this.allowNeutral = allowNeutral;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public boolean getAllowNeutral() {
        return allowNeutral;
    }

    public void setAllowNeutral(boolean allowNeutral) {
        this.allowNeutral = allowNeutral;
    }
}
