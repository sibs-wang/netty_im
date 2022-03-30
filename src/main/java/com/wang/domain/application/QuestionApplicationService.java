package com.wang.domain.application;

import com.wang.domain.application.command.CreateQuestionCommand;
import com.wang.domain.application.command.QuestionCreatedResult;
import com.wang.domain.model.entity.Question;
import com.wang.domain.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionApplicationService {

    private final QuestionRepository questionRepository;

    public QuestionApplicationService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionCreatedResult createQuestion(CreateQuestionCommand command) {
        var question = new Question(command.questionId(), command.title(), command.detail());
        questionRepository.save(question);
        return new QuestionCreatedResult(question.getQuestionerId());
    }
}
