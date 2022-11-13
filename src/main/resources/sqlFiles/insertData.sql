
-- ▶▶▶▶▶ 앵간하면 건들지 말것 ( 조심쓰 ) ◀◀◀◀◀◀


-- insert member (user1~user10@ogam.com)
(
insert into member(MEMBER_EMAIL
                 , MEMBER_PW
                 , MEMBER_NICK
                 , MEMBER_BIRTH
                 , MEMBER_PHONE
                 , MEMBER_GENDER
                 , MEMBER_INTRO
    ) values( 'user1@ogam.com'
            , '1234'
            , '김말복'
            , '1985/11/03'
            , '010-1234-1234'
            , 'male'
            , '안녕하세요! 김말복입니다!😁😁😁😁'
    );
insert into member(MEMBER_EMAIL
                 , MEMBER_PW
                 , MEMBER_NICK
                 , MEMBER_BIRTH
                 , MEMBER_PHONE
                 , MEMBER_GENDER
                 , MEMBER_INTRO
    ) values( 'user2@ogam.com'
            , '1234'
            , '몽이'
            , '2018/11/03'
            , '010-1234-1234'
            , 'male'
            , '안녕하세요! 몽이입니다!😸'
    );
insert into member(MEMBER_EMAIL
                 , MEMBER_PW
                 , MEMBER_NICK
                 , MEMBER_BIRTH
                 , MEMBER_PHONE
                 , MEMBER_GENDER
                 , MEMBER_INTRO
    ) values( 'user3@ogam.com'
            , '1234'
            , '햇님이'
            , '1995/11/03'
            , '010-1234-1234'
            , 'female'
            , '안녕하세요! 햇님이입니다!🤗🤗'
    );
insert into member(MEMBER_EMAIL
                 , MEMBER_PW
                 , MEMBER_NICK
                 , MEMBER_BIRTH
                 , MEMBER_PHONE
                 , MEMBER_GENDER
                 , MEMBER_INTRO
    ) values( 'user4@ogam.com'
            , '1234'
            , '나도나도'
            , '2000/11/03'
            , '010-1234-1234'
            , 'male'
            , '안녕하세요! 나도나도입니다!😻'
    );
insert into member(MEMBER_EMAIL
                 , MEMBER_PW
                 , MEMBER_NICK
                 , MEMBER_BIRTH
                 , MEMBER_PHONE
                 , MEMBER_GENDER
                 , MEMBER_INTRO
    ) values( 'user5@ogam.com'
            , '1234'
            , '도리토스'
            , '1998/11/03'
            , '010-1234-1234'
            , 'male'
            , '안녕하세요! 도리토스입니다!🥳'
    );
insert into member(MEMBER_EMAIL
                 , MEMBER_PW
                 , MEMBER_NICK
                 , MEMBER_BIRTH
                 , MEMBER_PHONE
                 , MEMBER_GENDER
                 , MEMBER_INTRO
    ) values( 'user6@ogam.com'
            , '1234'
            , '푸린'
            , '1985/11/03'
            , '010-1234-1234'
            , 'female'
            , '안녕하세요! 푸린입니다!😁'
    );
insert into member(MEMBER_EMAIL
                 , MEMBER_PW
                 , MEMBER_NICK
                 , MEMBER_BIRTH
                 , MEMBER_PHONE
                 , MEMBER_GENDER
                 , MEMBER_INTRO
    ) values( 'user7@ogam.com'
            , '1234'
            , '구르밍'
            , '2018/11/03'
            , '010-1234-1234'
            , 'female'
            , '안녕하세요! 구르밍입니다!😺😺'
    );
insert into member(MEMBER_EMAIL
                 , MEMBER_PW
                 , MEMBER_NICK
                 , MEMBER_BIRTH
                 , MEMBER_PHONE
                 , MEMBER_GENDER
                 , MEMBER_INTRO
    ) values( 'user8@ogam.com'
            , '1234'
            , '배고파ㅏㅏ'
            , '1995/11/03'
            , '010-1234-1234'
            , 'female'
            , '안녕하세요! 배고파ㅏㅏ입니다!😩'
    );
insert into member(MEMBER_EMAIL
                 , MEMBER_PW
                 , MEMBER_NICK
                 , MEMBER_BIRTH
                 , MEMBER_PHONE
                 , MEMBER_GENDER
                 , MEMBER_INTRO
    ) values( 'user9@ogam.com'
            , '1234'
            , '야나두'
            , '2000/11/03'
            , '010-1234-1234'
            , 'male'
            , '안녕하세요! 야나두입니다!😊'
    );
insert into member(MEMBER_EMAIL
                 , MEMBER_PW
                 , MEMBER_NICK
                 , MEMBER_BIRTH
                 , MEMBER_PHONE
                 , MEMBER_GENDER
                 , MEMBER_INTRO
    ) values( 'user10@ogam.com'
            , '1234'
            , '꼬북칩'
            , '1998/11/03'
            , '010-1234-1234'
            , 'female'
            , '안녕하세요! 꼬북칩입니다!😙'
    );
)

-- insert emotions (총 55개의 이모지)
(
insert into emotions(EMOJI,EMOTION) values('😊','기쁨');
insert into emotions(EMOJI,EMOTION) values('😁','기쁨');
insert into emotions(EMOJI,EMOTION) values('😍','기쁨');
insert into emotions(EMOJI,EMOTION) values('🥳','기쁨');
insert into emotions(EMOJI,EMOTION) values('😺','기쁨');
insert into emotions(EMOJI,EMOTION) values('😸','기쁨');
insert into emotions(EMOJI,EMOTION) values('😽','기쁨');
insert into emotions(EMOJI,EMOTION) values('😝','기쁨');
insert into emotions(EMOJI,EMOTION) values('🤗','기쁨');
insert into emotions(EMOJI,EMOTION) values('🤭','기쁨');

insert into emotions(EMOJI,EMOTION) values('😍','사랑');
insert into emotions(EMOJI,EMOTION) values('🥰','사랑');
insert into emotions(EMOJI,EMOTION) values('😘','사랑');
insert into emotions(EMOJI,EMOTION) values('😚','사랑');
insert into emotions(EMOJI,EMOTION) values('😻','사랑');
insert into emotions(EMOJI,EMOTION) values('😙','사랑');

insert into emotions(EMOJI,EMOTION) values('😥','슬픔');
insert into emotions(EMOJI,EMOTION) values('😢','슬픔');
insert into emotions(EMOJI,EMOTION) values('😭','슬픔');
insert into emotions(EMOJI,EMOTION) values('😰','슬픔');
insert into emotions(EMOJI,EMOTION) values('😿','슬픔');

insert into emotions(EMOJI,EMOTION) values('😔','우울');
insert into emotions(EMOJI,EMOTION) values('😞','우울');
insert into emotions(EMOJI,EMOTION) values('☹','우울');
insert into emotions(EMOJI,EMOTION) values('🤐','우울');
insert into emotions(EMOJI,EMOTION) values('😶','우울');
insert into emotions(EMOJI,EMOTION) values('😑','우울');
insert into emotions(EMOJI,EMOTION) values('😐','우울');
insert into emotions(EMOJI,EMOTION) values('🙁','우울');
insert into emotions(EMOJI,EMOTION) values('😩','우울');
insert into emotions(EMOJI,EMOTION) values('😟','우울');

insert into emotions(EMOJI,EMOTION) values('💀','힘듦');
insert into emotions(EMOJI,EMOTION) values('☠','힘듦');
insert into emotions(EMOJI,EMOTION) values('😩','힘듦');
insert into emotions(EMOJI,EMOTION) values('🥱','힘듦');
insert into emotions(EMOJI,EMOTION) values('🤒','힘듦');
insert into emotions(EMOJI,EMOTION) values('🤕','힘듦');
insert into emotions(EMOJI,EMOTION) values('🤢','힘듦');
insert into emotions(EMOJI,EMOTION) values('😷','힘듦');
insert into emotions(EMOJI,EMOTION) values('🤮','힘듦');
insert into emotions(EMOJI,EMOTION) values('😵','힘듦');
insert into emotions(EMOJI,EMOTION) values('😫','힘듦');
insert into emotions(EMOJI,EMOTION) values('😣','힘듦');
insert into emotions(EMOJI,EMOTION) values('😓','힘듦');
insert into emotions(EMOJI,EMOTION) values('🙀','힘듦');

insert into emotions(EMOJI,EMOTION) values('😡','분노');
insert into emotions(EMOJI,EMOTION) values('🤬','분노');
insert into emotions(EMOJI,EMOTION) values('😠','분노');
insert into emotions(EMOJI,EMOTION) values('😣','분노');
insert into emotions(EMOJI,EMOTION) values('🤯','분노');
insert into emotions(EMOJI,EMOTION) values('😕','분노');
insert into emotions(EMOJI,EMOTION) values('🤨','분노');
insert into emotions(EMOJI,EMOTION) values('😤','분노');
insert into emotions(EMOJI,EMOTION) values('😾','분노');
insert into emotions(EMOJI,EMOTION) values('👿','분노');
)

-- insert diary
-- 1.공개 다이어리
(
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user1@ogam.com', 1, '오늘은 너무 행복했다! 친구와 동네에서 재미있게 놀았다!!😁😁😁😁','n');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user2@ogam.com', 7, '오늘은 길을 가다 너무 귀여운 아기 고양이를 만났어! 그 친구랑 한참을 놀다가 집에왔당!!😸','n');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user3@ogam.com', 51, '평소와 같이 아침에 출근하는데 버스에서 모르는 사람이 나한테 뭐라고 했다🤬 다시 생각해도 너무 열받네 진짜.. ','n');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user4@ogam.com', 19, '엄마가 코로나에 걸렸다.. 최근에 놀러나갔다 오셨는데 그때 걸렸나보다 ㅠ 많이 아프지 않았으면...😥','n');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user5@ogam.com', 33, '와 요즘에 일이 너무 빡세다...  하.. ','n');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user6@ogam.com', 43, '요즘따라 마음이 왤케 힘든지 모르겠다','n');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user7@ogam.com', 7, '내 생일!!!!!! 옴팡지게 놀아야지~','n');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user8@ogam.com', 11, '친구야 항상 너무 고마워 사랑햇','n');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user9@ogam.com', 35, '아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ 날 좀 내버려둬ㅓㅓㅓㅓㅓㅓㅓㅓㅓ','n');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user10@ogam.com', 50, '친구랑 싸웠다. 요즘들어 날 빡치게 하는 사람들이 왤케 많지..?','n');
)

-- 2.비공개 다이어리
(
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user1@ogam.com', 43, '오늘은 너무 힘들었다... 상사 새끼 탈모왔으면.. ','y');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user2@ogam.com', 55, '지난주에 산 옷 입고 출근하는데 뜬금없이 새똥맞음... 진심 개빡','y');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user3@ogam.com', 23, '요즘따라 왜이리 우울할까','y');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user4@ogam.com', 6, '업무시간에 몰래 폰겜하는거 개꿀잼ㅋ','y');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user5@ogam.com', 28, '일상이 너무 단조롭다 집-직장-집-직장의 반복😩','y');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user6@ogam.com', 1, '오늘은 너무 행복했다! 친구와 동네에서 재미있게 놀았다!!😁😁😁😁','y');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user7@ogam.com', 11, '너무 사랑스러워ㅠㅠㅠㅠㅠㅠㅠㅠ','y');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user8@ogam.com', 36, 'ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ 떠나지마','y');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user9@ogam.com', 42, '아 오늘 체력적으로 너무 힘들었다','y');
insert into diary(MEMBER_EMAIL, EMOTION_SEQ, CONTENTS, DIARY_PRIVATE) values('user10@ogam.com', 30, '세상 우울하네 이세상','y');
)

-- insert friend_apply
(
insert into friend_apply(member_email, member_op_email,friend_key)
    values('user1@ogam.com', 'user2@ogam.com', 1);
insert into friend_apply(member_email, member_op_email,friend_key)
    values('user2@ogam.com', 'user1@ogam.com', 1);
)


-- insert reply
(
insert into reply(DIARY_SEQ,MEMBER_EMAIL,REPLY) values(1,'user2@ogam.com','행복하셨다니 저도 기분이 좋아요!!');
insert into reply(DIARY_SEQ,MEMBER_EMAIL,REPLY) values(1,'user3@ogam.com','얼마나 재밌게 노셨으면 행복하셨을까용');
insert into reply(DIARY_SEQ,MEMBER_EMAIL,REPLY) values(2,'user1@ogam.com','우와 고양이!!!😻');
insert into reply(DIARY_SEQ,MEMBER_EMAIL,REPLY) values(3,'user2@ogam.com','그 사람 정말 나쁜사람이에요!');
insert into reply(DIARY_SEQ,MEMBER_EMAIL,REPLY) values(4,'user10@ogam.com','아무 탈 없이 금방 나으시길 ㅠㅠ');
insert into reply(DIARY_SEQ,MEMBER_EMAIL,REPLY) values(5,'user9@ogam.com','힘내세요!!!!!!!');
insert into reply(DIARY_SEQ,MEMBER_EMAIL,REPLY) values(6,'user10@ogam.com','마음이 힘드시다니ㅠㅠ 힘내세용');
insert into reply(DIARY_SEQ,MEMBER_EMAIL,REPLY) values(7,'user10@ogam.com','아무 탈 없이 금방 나으시길 ㅠㅠ');
insert into reply(DIARY_SEQ,MEMBER_EMAIL,REPLY) values(10,'user5@ogam.com','에구 친구가 마음을 몰라줬네요ㅠ');
)

-- insert like
(
insert into diary_like(DIARY_SEQ,MEMBER_EMAIL) values(1,'user2@ogam.com');
insert into diary_like(DIARY_SEQ,MEMBER_EMAIL) values(1,'user3@ogam.com');
insert into diary_like(DIARY_SEQ,MEMBER_EMAIL) values(2,'user1@ogam.com');
)



-- 각종 alter문 (여기서 적용된 alter문은 전부 ogam_table.sql에 기록함)
(
alter table emotions modify emoji varchar2(50)
alter table emotions drop column emoji;
alter table emotions add emoji varchar2(50);

alter table notifi modify reply_seq null;
alter table notifi modify DIARY_SEQ null;
alter table notifi modify LIKE_SEQ null;
alter table notifi modify FRI_SEND_SEQ null;

alter table notifi drop column nickname;
alter table friend_apply drop column nickname;
alter table friend_send drop column nickname;

alter table friend_apply add friend_key number not null;

alter table Blacklist_diary modify blacklist_diary_date date default sysdate not null;
alter table Blacklist_reply modify blacklist_reply_date date default sysdate not null;


alter table MEMBER add KAKAOID number null ;
)

