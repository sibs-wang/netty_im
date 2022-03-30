package com.wang.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class SurveyInfo {

    // 不一定是吧,前端展示可以是
    private String id;

    private String surveyName;

    private String surveyDescription;

}
