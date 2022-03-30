package com.wang.domain.model;

import lombok.Data;

@Data
public class QuestionInfo {

    private int id;

    private int surveyId;

    private String questionType;

    private String questionName;

    private String questionDescription;

    private String questionSort;

    private String requiredFlag;

    private int questionPicId;
}
