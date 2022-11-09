
-- ▶▶▶▶▶ 앵간하면 건들지 말것 ( 조심쓰 ) ◀◀◀◀◀◀
-- 테이블 및 컬럼 수정시 반드시 기록할 것

-- member.member_date                                   -> default sysdate로 수정
-- diary.bgimg_seq                                      -> null로 수정
-- emotions.emoji                                       -> 다시 varchar2(50)으로 수정함...
-- notifi.reply_seq, diary_seq, like_seq, fri_send_seq  -> null로 바꿈
-- notifi, friend_apply, friend_send 테이블              -> nickname 컬럼 제거
-- friend_apply 테이블                                   -> friend_key number not null 컬럼 추가
-- friend_apply. MEMBER_OP_EMAIL                        -> not null로 변경
-- block_seq 시퀀스, block 테이블 생성문 추가
-- deleted_diary,deleted_reply 테이블 삭제
-- diary, reply 테이블에 삭제 구분 컬럼 추가 (diary_del, reply_del)
-- member테이블 - member_adminyn 컬럼 삭제

----------------------------------------
--DROP TABLE BGIMAGE;

--DROP TABLE BLACKLIST_DIARY;
--DROP TABLE BLACKLIST_REPLY;
--DROP TABLE BOARD;
--DROP TABLE DELETED_DIARY;
--DROP TABLE DELETED_REPLY;

--DROP TABLE DIARY;
--DROP TABLE DIARY_LIKE;
--DROP TABLE EMOTIONS;
--DROP TABLE FRIEND_APPLY;
--DROP TABLE FRIEND_SEND;
--DROP TABLE MEMBER;
--DROP TABLE NOTIFI;
--DROP TABLE REPLY;
-------------------------------------------------

CREATE TABLE MEMBER (
	member_email	varchar2(100)	PRIMARY KEY	NOT NULL,
	member_pw	varchar2(100)		NULL,
	member_nick	varchar2(50)	UNIQUE	NOT NULL,
	member_birth	date		NULL,
	member_phone	varchar2(50)		NULL,
	member_gender	varchar2(10)		NULL,
	member_blackYn	varchar2(2)	DEFAULT 'n'	NOT NULL,
	member_black_reason	varchar2(200)		NULL,
	member_date	date	DEFAULT sysdate	NULL,
	member_image	varchar2(100)		NULL,
	member_intro	varchar2(200)		NULL,
	member_quited	date		NULL,
	member_quited_reason	varchar2(200)		NULL
);

COMMENT ON COLUMN MEMBER.member_adminyn IS '값이 y면 관리자계정';
COMMENT ON COLUMN MEMBER.member_blackYn IS '값이 y면 정지계정';
--USER TABLE

CREATE TABLE DIARY (
	diary_seq	number	DEFAULT diary_seq.nextval PRIMARY KEY	NOT NULL,
	member_email	varchar2(100)	NOT NULL,
	bgimg_seq	number		NULL,
    emotion_seq 	number	NOT NULL,
	contents	varchar2(200)		NOT NULL,
	diary_date	date	DEFAULT sysdate	NOT NULL,
	diary_private	varchar2(2)	DEFAULT 'n'	NOT NULL,
	diary_del varchar2(2) not null default 'n'
);

--DROP TABLE reply;

CREATE TABLE reply (
	reply_seq	number	DEFAULT reply_seq.nextval PRIMARY KEY	NOT NULL,
	diary_seq	number 	NOT NULL,
	member_email	varchar2(100)		NOT NULL,
	reply	varchar2(200)		NULL,
	reply_date	date	DEFAULT sysdate	NULL,
	reply_del varchar2(2) not null default 'n'
);


CREATE TABLE DIARY_LIKE (
	like_seq	number	DEFAULT like_seq.nextval PRIMARY KEY	NOT NULL,
	diary_seq	number 	NOT NULL,
	member_email	varchar2(100)		NOT NULL
);


COMMENT ON COLUMN DIARY_LIKE.like_seq IS '해당 일기의 좋아요 개수는
select count(like_seq) 
  from diary_like';


CREATE TABLE friend_apply (
	fri_app_seq	number	DEFAULT fri_app_seq.nextval PRIMARY KEY	NOT NULL,
	member_email	varchar2(100)		NOT NULL,
	member_op_email	varchar2(100)		NOT NULL,
	friend_date	date	DEFAULT sysdate	NOT NULL,
	friend_key number not null
);


CREATE TABLE friend_send (
	fri_send_seq	number	DEFAULT fri_send_seq.nextval PRIMARY KEY	NOT NULL,
	member_email	varchar2(100)		NOT NULL,
	member_op_email	varchar2(100)		NOT NULL,
	response	varchar2(2)		NULL,
	send_date	date	DEFAULT sysdate	NULL,
	yndate	date		NULL
);


COMMENT ON COLUMN friend_apply.member_email IS '친구신청을 한 사람의 이메일';

COMMENT ON COLUMN friend_send.member_op_email IS '친구신청을 받은 사람의 이메일';

COMMENT ON COLUMN friend_send.response IS '친구 신청을 받은 사람의 신청 수락 여부
수락시 : y
거절시 : n';


CREATE TABLE emotions (
	emotion_seq	number DEFAULT emotion_seq.nextval	PRIMARY KEY	NOT NULL,
	emotion	varchar2(50)		NULL,
    emoji   varchar2(50)        NOT NULL
);


CREATE TABLE notifi (
	noti_seq	number	DEFAULT noti_seq.nextval PRIMARY KEY	NOT NULL,
	member_email	varchar2(100)		NOT NULL,
	reply_seq	number	NULL,
	diary_seq	number	NULL,
	like_seq	number	NULL,
	fri_send_seq	number	NULL,
	noti_email	varchar2(100)		NULL,
	noti_type	varchar2(50)		NOT NULL,
	noti_date	date	DEFAULT sysdate	NOT NULL,
	noti_readDate	date		NULL,
	noti_comm	varchar2(200)		NULL
);


COMMENT ON COLUMN notifi.noti_seq IS '고유번호';



COMMENT ON COLUMN notifi.noti_type IS '- 댓글 알림 : reply
- 좋아요 : like
- 친구 일기 : diary
- 친구신청 : friend_send
- 친구 맺음 : friend_yn';


COMMENT ON COLUMN notifi.noti_readDate IS '사용자가 확인할 경우 sysdate입력';

CREATE TABLE BOARD (
	board_seq	number	DEFAULT board_seq.nextVal PRIMARY KEY	NOT NULL,
	board_title	varchar2(100)		NULL,
	board_contents	varchar2(500)		NULL,
	board_date	date	DEFAULT sysdate	NOT NULL,
	board_yn	varchar2(2)	DEFAULT 'n'	NOT NULL
);


COMMENT ON COLUMN BOARD.board_date IS '공지 작성일';

COMMENT ON COLUMN BOARD.board_yn IS '기본적으로 n(비공개)로 함
공지는 신중해야 하기 떄문..!!!';

CREATE TABLE Blacklist_reply (
	blacklist_com_seq	number	DEFAULT BLACKLIST_COM_SEQ.NEXTVAL PRIMARY KEY	NOT NULL,
	reply_seq	number	NOT NULL,
	member_email	varchar2(100)		NOT NULL,
	blacklist_member_email	varchar2(100)		NULL,
	blacklist_comment	varchar2(50)		NULL,
	blacklist_reply_date	date		NULL
);



CREATE TABLE Blacklist_diary (
	blacklist_diary_seq	number	DEFAULT blacklist_diary_seq.NEXTVAL PRIMARY KEY	NOT NULL,
	diary_seq	number	NOT NULL,
	member_email	varchar2(100)		NOT NULL,
	blacklist_user_email	varchar2(100)		NULL,
	blacklist_comment	varchar2(50)		NULL,
	blacklist_diary_date	date		NULL
);


CREATE TABLE BGIMAGE (
	bgimg_seq	number	DEFAULT bgimg_seq.NEXTVAL PRIMARY KEY	NOT NULL,
	bgimg_path	varchar2(100)		NULL,
	bgimg_title	varchar2(100)		NULL
);


ALTER TABLE DIARY ADD CONSTRAINT FK_MEMBER_TO_DIARY_1 FOREIGN KEY (
	member_email
)
REFERENCES MEMBER (
	member_email
);


ALTER TABLE DIARY ADD CONSTRAINT FK_emotions_TO_DIARY_1 FOREIGN KEY (
	emotion_seq
)
REFERENCES emotions (
	emotion_seq
);

ALTER TABLE DIARY ADD CONSTRAINT FK_BGIMAGE_TO_DIARY_1 FOREIGN KEY (
	bgimg_seq
)
REFERENCES BGIMAGE (
	bgimg_seq
);

ALTER TABLE reply ADD CONSTRAINT FK_DIARY_TO_reply_1 FOREIGN KEY (
	diary_seq
)
REFERENCES DIARY (
	diary_seq
);

ALTER TABLE reply ADD CONSTRAINT FK_MEMBER_TO_reply_1 FOREIGN KEY (
	member_email
)
REFERENCES MEMBER (
	member_email
);

ALTER TABLE DIARY_LIKE ADD CONSTRAINT FK_DIARY_TO_DIARY_LIKE_1 FOREIGN KEY (
	diary_seq
)
REFERENCES DIARY (
	diary_seq
);

ALTER TABLE DIARY_LIKE ADD CONSTRAINT FK_MEMBER_TO_DIARY_LIKE_1 FOREIGN KEY (
	member_email
)
REFERENCES MEMBER (
	member_email
);

ALTER TABLE friend_apply ADD CONSTRAINT FK_MEMBER_TO_friend_apply_1 FOREIGN KEY (
	member_email
)
REFERENCES MEMBER (
	member_email
);

ALTER TABLE friend_send ADD CONSTRAINT FK_MEMBER_TO_friend_send_1 FOREIGN KEY (
	member_email
)
REFERENCES MEMBER (
	member_email
);

ALTER TABLE notifi ADD CONSTRAINT FK_MEMBER_TO_notifi_1 FOREIGN KEY (
	member_email
)
REFERENCES MEMBER (
	member_email
);


ALTER TABLE notifi ADD CONSTRAINT FK_reply_TO_notifi_1 FOREIGN KEY (
	reply_seq
)
REFERENCES reply (
	reply_seq
);

ALTER TABLE notifi ADD CONSTRAINT FK_DIARY_TO_notifi_1 FOREIGN KEY (
	diary_seq
)
REFERENCES DIARY (
	diary_seq
);


ALTER TABLE notifi ADD CONSTRAINT FK_DIARY_LIKE_TO_notifi_1 FOREIGN KEY (
	like_seq
)
REFERENCES DIARY_LIKE (
	like_seq
);


ALTER TABLE notifi ADD CONSTRAINT FK_friend_send_TO_notifi_1 FOREIGN KEY (
	fri_send_seq
)
REFERENCES friend_send (
	fri_send_seq
);

ALTER TABLE Blacklist_reply ADD CONSTRAINT FK_reply_TO_Blacklist_reply_1 FOREIGN KEY (
	reply_seq
)
REFERENCES reply (
	reply_seq
);

ALTER TABLE Blacklist_reply ADD CONSTRAINT FK_MEMBER_TO_Blacklist_reply_1 FOREIGN KEY (
	member_email
)
REFERENCES MEMBER (
	member_email
);

ALTER TABLE Blacklist_diary ADD CONSTRAINT FK_DIARY_TO_Blacklist_diary_1 FOREIGN KEY (
	diary_seq
)
REFERENCES DIARY (
	diary_seq
);

ALTER TABLE Blacklist_diary ADD CONSTRAINT FK_MEMBER_TO_Blacklist_diary_1 FOREIGN KEY (
	member_email
)
REFERENCES MEMBER (
	member_email
);



CREATE SEQUENCE  BLOCK_SEQ  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;

CREATE TABLE block (
	block_seq	number	DEFAULT block_seq.nextval	NOT NULL,
	member_email	varchar2(100)		NOT NULL,
	block_email	varchar2(100)		NOT NULL
);

ALTER TABLE block ADD CONSTRAINT PK_BLOCK PRIMARY KEY (
	block_seq,
	member_email
);

ALTER TABLE block ADD CONSTRAINT FK_MEMBER_TO_block_1 FOREIGN KEY ( member_email )
REFERENCES MEMBER ( member_email );


--COMMIT;




