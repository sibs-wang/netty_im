package com.wang.rest.request;

public record CreateQuestionRequest(
        String questionId,
        String title,
        String detail
) {
}
