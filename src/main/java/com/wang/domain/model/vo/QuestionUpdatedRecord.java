package com.wang.domain.model.vo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.OffsetDateTime;
import java.util.Objects;

@Embeddable
public class QuestionUpdatedRecord {
    // 值对象类型
    @Enumerated(EnumType.STRING)
    private UpdateType updateType;

    private String updaterId;

    private OffsetDateTime updatedAt;

    private String reason;

    private String createdTitle;

    private String createdDetail;

    private String uneditedTitle;

    private String editedTitle;

    private String uneditedDetail;

    private String editedDetail;

    protected QuestionUpdatedRecord() {

    }

    // 如果创建created的record那就不应该有edited,所以全参构造方法是private,通过静态工厂方法创建特定的record
    // 否则对于外部代码有能力创建一个不符合业务约束的实体
    public static QuestionUpdatedRecord ofCreated(String updaterId, String createdTitle, String createdDetail) {
        return new QuestionUpdatedRecord(UpdateType.CREATED, updaterId, OffsetDateTime.now(), null, createdTitle, createdDetail, null, null, null, null);
    }

    public static QuestionUpdatedRecord ofTitleEdited(String updaterId, String reason, String uneditedTitle, String editedTitle) {
        return new QuestionUpdatedRecord(UpdateType.TITLE_EDITED, updaterId, OffsetDateTime.now(), reason, null, null, uneditedTitle, editedTitle, null, null);
    }

    public static QuestionUpdatedRecord ofDetailEdited(String updaterId, String reason, String uneditedDetail, String editedDetail) {
        return new QuestionUpdatedRecord(UpdateType.DETAIL_EDITED, updaterId, OffsetDateTime.now(), reason, null, null, null, null, uneditedDetail, editedDetail);
    }

    private QuestionUpdatedRecord(UpdateType updateType, String updaterId, OffsetDateTime updatedAt,
                                 String reason, String createdTitle, String createdDetail,
                                 String uneditedTitle, String editedTitle,
                                 String uneditedDetail, String editedDetail) {
        this.updateType = updateType;
        this.updaterId = updaterId;
        this.updatedAt = updatedAt;
        this.reason = reason;
        this.createdTitle = createdTitle;
        this.createdDetail = createdDetail;
        this.uneditedTitle = uneditedTitle;
        this.editedTitle = editedTitle;
        this.uneditedDetail = uneditedDetail;
        this.editedDetail = editedDetail;
    }

    public UpdateType getUpdateType() {
        return updateType;
    }

    public String getUpdaterId() {
        return updaterId;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getReason() {
        return reason;
    }

    public String getCreatedTitle() {
        return createdTitle;
    }

    public String getCreatedDetail() {
        return createdDetail;
    }

    public String getUneditedTitle() {
        return uneditedTitle;
    }

    public String getEditedTitle() {
        return editedTitle;
    }

    public String getUneditedDetail() {
        return uneditedDetail;
    }

    public String getEditedDetail() {
        return editedDetail;
    }

    // 判断两个vo是否相等,需要判断两个vo携带的值是否相等
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionUpdatedRecord that)) return false;
        return getUpdateType() == that.getUpdateType()
                && Objects.equals(getUpdaterId(), that.getUpdaterId())
                && Objects.equals(getUpdatedAt(), that.getUpdatedAt())
                && Objects.equals(getReason(), that.getReason())
                && Objects.equals(getCreatedTitle(), that.getCreatedTitle())
                && Objects.equals(getCreatedDetail(), that.getCreatedDetail())
                && Objects.equals(getUneditedTitle(), that.getUneditedTitle())
                && Objects.equals(getEditedTitle(), that.getEditedTitle())
                && Objects.equals(getUneditedDetail(), that.getUneditedDetail())
                && Objects.equals(getEditedDetail(), that.getEditedDetail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUpdateType(), getUpdaterId(), getUpdatedAt(), getReason(),
                getCreatedTitle(), getCreatedDetail(), getUneditedTitle(), getEditedTitle(), getUneditedDetail(), getEditedDetail());
    }

    public enum UpdateType {
        CREATED, TITLE_EDITED, DETAIL_EDITED
    }
}
