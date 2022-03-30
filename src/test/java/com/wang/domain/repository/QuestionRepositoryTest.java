package com.wang.domain.repository;

import com.wang.domain.model.entity.Question;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

// 启动spring上下文
// @SpringBootTest
// 这里只需要测试持久化
@DataJpaTest
class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private EntityManager entityManager;


    @Test
    void repositorySaveQuestion() {
        var question = new Question("UID_00001", "a test title", "a test detail");

        var save = questionRepository.save(question);

        assertEquals(save.getId(), is(notNullValue()));
        assertEquals(save.getQuestionerId(), equalTo(question.getQuestionerId()));
        assertEquals(save.getTitle(), equalTo(question.getTitle()));
        assertEquals(save.getDetail(), equalTo(question.getDetail()));
    }

    @Test
    void repository_find_by_id() {
        var question = new Question("UID_00001", "a test title", "a test detail");
        var save = questionRepository.saveAndFlush(question);
        entityManager.detach(save);
        var findQuestion = questionRepository.findById(String.valueOf(save.getId())).orElseThrow(AssertionError::new);
        assertEquals(findQuestion.getQuestionerId(), equalTo(question.getQuestionerId()));
        assertEquals(findQuestion.getTitle(), equalTo(question.getTitle()));
        assertEquals(findQuestion.getDetail(), equalTo(question.getDetail()));
    }
}