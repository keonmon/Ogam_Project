
// 알림 모달 스크립트
const notifi = document.querySelector(".notifi");
const notifi_wrapModal = document.querySelector(".notifi_wrapModal");

notifi.addEventListener("click", () => {
        notifi_wrapModal.classList.toggle("toggle");
})

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

// 모달창 버튼 스크립트
const addBtn = document.querySelectorAll(".addBtn");
const add = document.querySelectorAll(".add");
const complete = document.querySelectorAll(".complete");
const email = document.querySelectorAll(".member_email");

for (let i = 0; i < addBtn.length; i++) {
    addBtn[i].addEventListener("click", () => {
    let member_email = email[i].value;
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
                add[i].style.display = "none";
                complete[i].style.display = "block";
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
const searchInput = document.getElementById("searchInput").value;

searchBtn.addEventListener("click", () => {
console.log(searchInput);

})

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
const op_email = document.querySelectorAll(".op_email");

for(let i = 0; i < accept.length; i++){
    accept[i].addEventListener("click", () => {
    let response = answer[i].value.innerHTML = 'y';
    let nickname = op_nickname[i].innerHTML;
    let member_op_email = op_email[i].value;
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
               data:{"response" : response, "nickname" : nickname, "member_op_email" : member_op_email},
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
    let member_op_email = op_email[i].value;

    Swal.fire({
          title: '친구등록을 거절했습니다',
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
             data:{"response" : response, "nickname" : nickname, "member_op_email" : member_op_email},
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
