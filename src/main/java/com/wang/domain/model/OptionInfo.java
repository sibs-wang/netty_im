package com.wang.domain.model;

import lombok.Data;

@Data
public class OptionInfo {
    private int id;

    private int surveyId;

    private int questionId;

    private String optionName;

    private int optionSort;

    private int optionPicId;
}
