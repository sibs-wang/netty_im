package com.wang.domain.application;

import com.wang.domain.application.command.QuestionnaireResult;
import com.wang.domain.repository.QuestionRepository;

public class QuestionnaireService {

    private final QuestionRepository questionRepository;


    public QuestionnaireService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionnaireResult findQuestion(String command) {
        var question = questionRepository.findById(command);
        return new QuestionnaireResult();
    }
}
