package com.wang.domain.model.entity;

import com.wang.domain.model.vo.QuestionUpdatedRecord;
import jakarta.persistence.*;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionerId;

    private String title;

    private String detail;

    @ElementCollection
    @CollectionTable(name = "question_updated_record")
    @OrderBy("updatedAt")// 需要根据updated at进行自然排序.保证插入的顺序和读取的出来的排序是相同的
    private List<QuestionUpdatedRecord> updatedRecords;

    @PersistenceConstructor
    protected Question() {

    }

    public Question(String questionerId, String title, String detail) {
        this.questionerId = questionerId;
        this.title = title;
        this.detail = detail;
        this.updatedRecords = new ArrayList<>();
        updatedRecords.add(QuestionUpdatedRecord.ofCreated(questionerId, title, detail));
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionerId() {
        return questionerId;
    }

    public void setQuestionerId(String questionerId) {
        this.questionerId = questionerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    // mutable
    public List<QuestionUpdatedRecord> getUpdatedRecords() {
        // 拿到当前的副本
        return Collections.unmodifiableList(updatedRecords);
    }

    public void editTitle(String editorId, String reason, String title) {
        this.updatedRecords.add(QuestionUpdatedRecord.ofTitleEdited(editorId, reason, this.title, title));
        this.title = title;
    }

    public void editDetail(String editorId, String reason, String detail) {
        this.updatedRecords.add(QuestionUpdatedRecord.ofDetailEdited(editorId, reason, this.detail, detail));
        this.detail = detail;
    }
}
