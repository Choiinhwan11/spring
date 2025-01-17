oracle
[테이블]
CREATE TABLE board(
     seq NUMBER NOT NULL,               -- 글번호 (시퀀스 객체 이용)
     id VARCHAR2(20) NOT NULL,           -- 아이디
     name VARCHAR2(40) NOT NULL,       -- 이름
     email VARCHAR2(40),                  -- 이메일
     subject VARCHAR2(255) NOT NULL,    -- 제목
     content VARCHAR2(4000) NOT NULL,   -- 내용 

     ref NUMBER NOT NULL,                 -- 그룹번호
     lev NUMBER DEFAULT 0 NOT NULL,     -- 단계
     step NUMBER DEFAULT 0 NOT NULL,    -- 글순서
     pseq NUMBER DEFAULT 0 NOT NULL,    -- 원글번호
     reply NUMBER DEFAULT 0 NOT NULL,   -- 답변수

     hit NUMBER DEFAULT 0,              -- 조회수
     logtime DATE DEFAULT SYSDATE
 );

[시퀀스]
CREATE SEQUENCE seq_board  NOCACHE NOCYCLE;
mysql

CREATE TABLE board(
     seq BIGINT PRIMARY KEY  AUTO_INCREMENT,               -- 글번호 (시퀀스 객체 이용)
     id VARCHAR(20) NOT NULL,           -- 아이디
     name VARCHAR(40) NOT NULL,       -- 이름
     email VARCHAR(40),                  -- 이메일
     subject VARCHAR(255) NOT NULL,    -- 제목
     content VARCHAR(4000) NOT NULL,   -- 내용 

     ref BIGINT NOT NULL,                 -- 그룹번호
     lev BIGINT DEFAULT 0 NOT NULL,     -- 단계
     step BIGINT DEFAULT 0 NOT NULL,    -- 글순서
     pseq BIGINT DEFAULT 0 NOT NULL,    -- 원글번호
     reply BIGINT DEFAULT 0 NOT NULL,   -- 답변수

     hit BIGINT DEFAULT 0,              -- 조회수
     logtime DATE DEFAULT (CURRENT_date)
 );
 
  [예]
	logtime DATE DEFAULT (current_date) -- 현재 날짜
    logtime DATETIME DEFAULT (CURRENT_TIME) -- 현재 시간
    logtime DATETIME DEFAULT CURRENT_TIMESTAMP -- 현재 날짜 & 현재 시간
    logtime DATETIME DEFAULT NOW() -- 현재 날짜 & 현재 시간