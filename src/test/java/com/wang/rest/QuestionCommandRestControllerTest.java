package com.wang.rest;

import com.wang.domain.application.QuestionApplicationService;
import com.wang.domain.application.command.QuestionCreatedResult;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class QuestionCommandRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionApplicationService questionApplicationService;

    @Test
    void return_ok_when_create_question() throws Exception {

        var questionId = "1";

        BDDMockito.given(questionApplicationService.createQuestion(ArgumentMatchers.any())).willReturn(new QuestionCreatedResult("1"));

        mockMvc.perform(
                post("/questions/create_question")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "questionId": "UID_00001",
                                    "title": "A title for test",
                                    "detail": "A detail for test"
                                }
                                """)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.questionId").value(questionId));
    }
}