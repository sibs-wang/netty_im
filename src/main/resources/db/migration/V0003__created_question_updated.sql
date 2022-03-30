CREATE TABLE question_updated_record(
    question_id int primary key ,
    update_type varchar(255) not null ,
    updater_id varchar(255) not null ,
    updated_at timestamp not null ,
    reason varchar(255) null ,
    created_title varchar(255) null,
    created_detail  varchar(255),
    unedited_title  varchar(255),
    edited_title    varchar(255),
    unedited_detail varchar(255),
    edited_detail   varchar(255)
);