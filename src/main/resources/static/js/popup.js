/* 사용자 상세 정보*/
function memberPopup(member_email) {
    console.log("member: " + member_email)
        
    window.open("/memberPopup?member_email=" + member_email, "memberPopup",
    ['fullscreen=no,menubar=no,status=no,toolbar=no,titlebar=no,location=no,scrollbar=auto,width=550px,height=750px'] );

}

/* 일기 상세 정보 */
function diaryPopup(diary_seq) {
    console.log("seq: " + diary_seq)

    window.open("/diaryPopup?diary_seq=" + diary_seq, "diaryPopup",
    ['fullscreen=no,menubar=no,status=no,toolbar=no,titlebar=no,location=no,scrollbar=auto,width=550px,height=625px'] );

}

/* 댓글 상세 정보 */
function commentPopup(reply_seq) {
    console.log("seq: " + reply_seq)

    window.open("/commentPopup?reply_seq=" + reply_seq, "commentPopup",
    ['fullscreen=no,menubar=no,status=no,toolbar=no,titlebar=no,location=no,scrollbar=auto,width=550px,height=510px'] );

}

/* 창닫기 */
function reload(){
    window.opener.location.reload();
    window.close();
}