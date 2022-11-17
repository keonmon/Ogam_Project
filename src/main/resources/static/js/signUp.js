/*눈 모양 버튼을 이용한 비밀번호 보이기 안보이기*/
$(document).ready(function(){
    $('.password i').on('click', function(){
        $('input').toggleClass('active');
        if($('input').hasClass('active')){
            $(this).attr('class',"fa fa-eye-slash fa-lg")
            .prev('input').attr('type',"text");
        }else{
            $(this).attr('class',"fa fa-eye fa-lg")
            .prev('input').attr('type','password');
        }
    });
});

/*비밀번호 일치 여부*/
var member_pw = document.getElementById("member_pw"),
    member_repw = document.getElementById("member_repw");

function validatePassword(){
    if(member_pw.value != member_repw.value){
        member_repw.setCustomValidity("비밀번호가 일치하지 않습니다!!");
        return false;
    }
    else {
        member_repw.setCustomValidity('');
        return false;
    }
}

member_pw.onchange = validatePassword;
member_repw.onchange = validatePassword;

/*라디오 버튼 체크 여부*/
document.getElementById('signup').onclick = function() {

    const email = document.getElementById("member_email").value
    const email2 = document.getElementById("email_checked").value
    const nick = document.getElementById("member_nick").value
    const nick2 = document.getElementById("nick_checked").value

    validatePassword();

    var selected = false;
    var radios = document.getElementsByName('gender');
    for(var radio of radios){
        if(radio.type === 'radio' && radio.checked){
            selected = true;
        }
    }

     if( email != email2 || email2=="" ) {
        swal({
             title: "이메일 중복확인이 필요합니다!",
             icon: "warning",
             button: "확인",
             });
             return false;
    } else if (nick != nick2 || nick2=="") {
        swal({
             title: "닉네임 중복확인이 필요합니다!",
             icon: "warning",
             button: "확인",
             });
             return false;

    } else if (!selected) {
       swal({
           title: "성별을 선택해주세요!!",
           icon: "warning",
           button: "확인",
           });
           return false;
    }else{

        $(".hide").trigger('click');

    }

}