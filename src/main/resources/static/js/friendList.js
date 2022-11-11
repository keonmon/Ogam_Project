
// 메뉴바 스크립트
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

// 삭제버튼 script
const response = document.querySelectorAll(".response");
const op_nickname = document.querySelectorAll(".op_nickname span");
for(let i = 0; i < response.length; i++){
    response[i].addEventListener("click", () => {
    let nickname = op_nickname[i].innerHTML;
    Swal.fire({
          title: '정말 삭제하시겠습니까?',
          text: "친구목록에서 삭제가 됩니다!",
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: '삭제',
          cancelButtonText: '취소'
        }).then((result) => {
          if (result.isConfirmed) {
            Swal.fire(
              '삭제!',
              '삭제가 성공적으로 되었습니다.',
              'success'
            ). then(function () {
                $.ajax({
                   url:"/deleteFriend",
                   type:"post",
                   data:{"nickname" : nickname},
                   success:function(data) {
                        window.location.href = "/friendList";
                   },
                   error:function(e) {
                        console.log(e);
                   }
                })
            });
          }
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
