const new_pw = document.getElementById("member_pw");
const re_pw = document.getElementById("member_repw");
/* 비밀번호 일치 확인 */
function chk_pwd() {

    if(new_pw.value != re_pw.value) {
        alert("비밀번호가 일치하지 않습니다");
        new_pw.style.backgroundColor = "#F8D4E2";
        re_pw.style.backgroundColor = "#F8D4E2";
        re_pw.value = "";
        return false;
    } else {
        new_pw.style.backgroundColor = "white";
        re_pw.style.backgroundColor = "white";
        return true;
    }

}
/* 비밀번호 규칙 확인 (최소 8자 최대 16자, 특수문자, 영어, 숫자 조합, 공백x)*/
function new_pw_chk() {

   var num = new_pw.value.search(/[0-9]/g);
   var eng = new_pw.value.search(/[a-z]/ig);
   var spe = new_pw.value.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

   if(new_pw.value.length < 8 || new_pw.value.length > 16){
        alert("최소 8자 최대 16자 이내로 입력해주세요.");
        new_pw.style.backgroundColor = "#F8D4E2";
        new_pw.value=""
        return false;
   } else if(new_pw.value.search(/\s/) != -1){
        alert("비밀번호는 공백 없이 입력해주세요.");
        new_pw.style.backgroundColor = "#F8D4E2";
        new_pw.value=""
        return false;
    } else if(num < 0 || eng < 0 || spe < 0 ){
        alert("영문, 숫자, 특수문자를 혼합하여 입력해주세요.");
        new_pw.style.backgroundColor = "#F8D4E2";
        new_pw.value=""
        return false;
    } else {
   	    new_pw.style.backgroundColor = "white";
        return true;
    }

}

 const finish = document.getElementById("finish")
 const frm = document.getElementById("frm")
 const KakaoLoginCheck = document.getElementById("kakaoLoginChk");
 function reviseInfoSubmit(){
    
    if(kakaoLoginChk.value==''){
        if(!chk_pwd()){
                return false;
            } else if(!new_pw_chk()){
                return false;
            }
    }

    frm.submit();
 }









