
CREATE TABLE ANS
(
  ans_key int          NOT NULL,
  answer  varchar(200) NULL    ,
  PRIMARY KEY (ans_key)
) COMMENT '답항';

CREATE TABLE QnA
(
  qna_key   int NOT NULL,
  ans_key   int NOT NULL,
  quest_key int NOT NULL,
  PRIMARY KEY (qna_key)
) COMMENT '문항에 대한 답항';

CREATE TABLE QUEST
(
  quest_key int          NOT NULL,
  question  varchar(200) NULL    ,
  PRIMARY KEY (quest_key)
) COMMENT '문항';

CREATE TABLE RES_Q
(
  id      int NOT NULL,
  qna_key int NOT NULL
);

CREATE TABLE RESPONSE
(
  id   int          NOT NULL,
  name varchar(200) NULL    ,
  PRIMARY KEY (id)
);

ALTER TABLE QnA
  ADD CONSTRAINT FK_ANS_TO_QnA
    FOREIGN KEY (ans_key)
    REFERENCES ANS (ans_key);

ALTER TABLE QnA
  ADD CONSTRAINT FK_QUEST_TO_QnA
    FOREIGN KEY (quest_key)
    REFERENCES QUEST (quest_key);

ALTER TABLE RES_Q
  ADD CONSTRAINT FK_RESPONSE_TO_RES_Q
    FOREIGN KEY (id)
    REFERENCES RESPONSE (id);

ALTER TABLE RES_Q
  ADD CONSTRAINT FK_QnA_TO_RES_Q
    FOREIGN KEY (qna_key)
    REFERENCES QnA (qna_key);
