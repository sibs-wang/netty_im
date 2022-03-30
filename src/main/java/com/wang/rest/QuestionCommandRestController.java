package com.wang.rest;

import com.wang.domain.application.QuestionApplicationService;
import com.wang.domain.application.command.CreateQuestionCommand;
import com.wang.domain.application.command.QuestionCreatedResult;
import com.wang.rest.request.CreateQuestionRequest;
import com.wang.rest.request.QuestionCreatedResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionCommandRestController {

    private final QuestionApplicationService questionApplicationService;

    public QuestionCommandRestController(QuestionApplicationService questionApplicationService) {
        this.questionApplicationService = questionApplicationService;
    }


    @PostMapping("/create_question")
    public QuestionCreatedResponse createQuestion(@RequestBody CreateQuestionRequest request) {
        var command = new CreateQuestionCommand(request.questionId(), request.title(), request.detail());
        // 有些参数从路由进来,有些从header进来,有些从body进来
        var result = questionApplicationService.createQuestion(command);
        return new QuestionCreatedResponse(result.questionId());
    }
}
