DROP TABLE IF EXISTS question;
create table question(
    id INT PRIMARY KEY ,
    questioner_id VARCHAR(255) NOT NULL ,
    title VARCHAR(255) NOT NULL ,
    detail VARCHAR(255)
);