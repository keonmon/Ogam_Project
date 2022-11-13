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
    member_repw.setCustomValidity("비밀번호가 일치하지 않습니다.");
    }
    else {
    member_repw.setCustomValidity('');
    }
}

member_pw.onchange = validatePassword;
member_repw.onchange = validatePassword;

