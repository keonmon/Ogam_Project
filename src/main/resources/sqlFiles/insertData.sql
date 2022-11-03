
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
-- 공개 다이어리
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

-- 비공개 다이어리
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






alter table emotion change emoji emoji varchar2(50)

SELECT CONVERT($메시지_칼럼$, 'AL32UTF8', 'AL32UTF8')
   FROM TB_NAME







alter table emotions modify emoji varchar2(50)
alter table emotions drop column emoji;
alter table emotions add emoji varchar2(50);
