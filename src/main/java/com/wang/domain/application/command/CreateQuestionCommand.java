package com.wang.domain.application.command;

public record CreateQuestionCommand(
        String questionId,
        String title,
        String detail
) {
}
