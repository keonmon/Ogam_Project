
// 친구 모달 스크립트
const friend_send = document.querySelector(".friend-send");

function friend_Modal() {
    let modalContainer = document.querySelector(".modalContainer");
    modalContainer.style.display = "block";
}

function closeModal1() {
    let modalContainer = document.querySelector(".modalContainer");
    modalContainer.style.display = "none";
    window.location.href="/sendList";
}

// 모달창 버튼 스크립트 친구 신청하기
const addBtn = document.querySelectorAll(".addBtn");
const add = document.querySelectorAll(".add");
const email = document.querySelectorAll(".member_email");
const list = document.querySelectorAll(".member_list");

for (let i = 0; i < addBtn.length; i++) {
    add[i].addEventListener("click", () => {
    let member_email = email[i].innerHTML;
    console.log(member_email)
    let member_list = list[i];
    let response = 'n';

    Swal.fire({
      title: '친구신청을 했습니다',
      showClass: {
        popup: 'animate__animated animate__fadeInDown'
      },
      hideClass: {
        popup: 'animate__animated animate__fadeOutUp'
      }
    }).then(function () {
          $.ajax({
             url:"/addSendList",
             type:"post",
             data:{"member_email" : member_email, "response" : response},
             success:function(data) {
                console.log(data);
                member_list.remove();
             },
             error:function(e) {
                  console.log(e);
             }
          })
      })
    })
}

// 모달창 검색 ajax
const searchBtn = document.getElementById("searchBtn");
const searchInput = document.getElementById("searchInput");

let searchKeyword;

searchBtn.addEventListener("click", () => {
searchKeyword = searchInput.value;

    $.ajax({
        url: "/modalSearch",
        type: "post",
        data:{"searchKeyword":searchKeyword},
    }).done(function (memberList){
        $(".modalBody").replaceWith(memberList);
        addEventHanlder();
    })
})

// ajax 로 추가버튼 함수
function addEventHanlder() {
const tmpAddBtn = document.querySelectorAll(".addBtn");
const tmpAdd = document.querySelectorAll(".add");
const tmpEmail = document.querySelectorAll(".member_email");
const tmpList = document.querySelectorAll(".member_list");

for (let i = 0; i < tmpAddBtn.length; i++) {
    tmpAdd[i].addEventListener("click", () => {
    let member_email = tmpEmail[i].innerHTML;
    let member_list = tmpList[i];
    let response = 'n';

    Swal.fire({
      title: '친구신청을 했습니다',
      showClass: {
        popup: 'animate__animated animate__fadeInDown'
      },
      hideClass: {
        popup: 'animate__animated animate__fadeOutUp'
      }
    }).then(function () {
          $.ajax({
             url:"/addSendList",
             type:"post",
             data:{"member_email" : member_email, "response" : response},
             success:function(data) {
                console.log(data);
                member_list.remove();
             },
             error:function(e) {
                  console.log(e);
             }
          })
      })
    })
}
}

// 친구신청 / 친구 리스트 메뉴바 스크립트
const friendList = document.querySelector(".friendList");
const sendList = document.querySelector(".sendList");

friendList.addEventListener("click", () => {
    friendList.style.zIndex = "1";
    sendList.style.zIndex = "0";
    window.location.href = "/friendList";
})

sendList.addEventListener("click", () => {
    friendList.style.zIndex = "0";
    sendList.style.zIndex = "1";
    window.location.href = "/sendList";
})

// 친구 수락/ 거절 버튼

const accept = document.querySelectorAll("#accept");
const refuse = document.querySelectorAll("#refuse");
const answer = document.querySelectorAll(".answer");
const op_nickname = document.querySelectorAll(".op_nickname span");
const friSeq = document.querySelectorAll(".friSeq");
const op_email = document.querySelectorAll(".op_email");

for(let i = 0; i < accept.length; i++){
    accept[i].addEventListener("click", () => {
    let response = answer[i].value.innerHTML = 'y';
    let nickname = op_nickname[i].innerHTML;
    let member_op_email = op_email[i].innerHTML;
    let fri_send_seq = friSeq[i].innerHTML;
    console.log(fri_send_seq)
        Swal.fire({
          title: '친구등록을 완료했습니다',
          showClass: {
            popup: 'animate__animated animate__fadeInDown'
          },
          hideClass: {
            popup: 'animate__animated animate__fadeOutUp'
          }
        }).then(function () {
            $.ajax({
               url:"/response",
               type:"post",
               data:{"response" : response, "nickname" : nickname, "member_op_email" : member_op_email, "fri_send_seq" : fri_send_seq},
               success:function(data) {
                    window.location.href = "/sendList";
               },
               error:function(e) {
                    console.log(e);
               }
            })
        })
    })
}

for(let i = 0; i < refuse.length; i++){
    refuse[i].addEventListener("click", () => {
    let response = answer[i].value.innerHTML = 'n';
    let nickname = op_nickname[i].innerHTML;
    let member_op_email = op_email[i].innerHTML;
    let fri_send_seq = friSeq[i].innerHTML;

    Swal.fire({
      title: '정말 거절하시겠습니까?',
      text: "거절하면! 친구등록이 안됩니다",
      icon: '경고',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: '삭제',
      cancelButtonText: '취소'
    }).then((result) => {
       $.ajax({
        url:"/response",
        type:"post",
        data:{"response" : response, "nickname" : nickname, "member_op_email" : member_op_email, "fri_send_seq" : fri_send_seq},
        success:function(data) {
           console.log(data)
           window.location.href = "/sendList";
        },
        error:function(e) {
             console.log(e);
        }
       })
     })
  })
}

// 다크모드
const btn_theme = document.querySelector(".btn_theme");
const body = document.body;
const mode = localStorage.getItem('darkMode');

btn_theme.addEventListener("click", () =>{
    body.classList.toggle("dark");

    // body태그에 darkMode localStorage에 넣고 빼기
    if(body.classList.contains('dark')) {
        activateDarkMode();
        localStorage.setItem("darkMode","enabled");
    } else {
        deactivateDarkMode();
        localStorage.setItem("darkMode","disabled");
    }
});

if(mode === "enabled") {
    activateDarkMode();
} else if (mode == "disabled") {
    deactivateDarkMode();
}

function activateDarkMode() {
    body.classList.add("dark");
    btn_theme.classList.remove('fa-moon');
    btn_theme.classList.add('fa-sun');
}

function deactivateDarkMode() {
    body.classList.remove("dark");
    btn_theme.classList.add('fa-moon');
    btn_theme.classList.remove('fa-sun');
}
