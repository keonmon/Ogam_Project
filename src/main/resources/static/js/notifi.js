
// 알림 모달 스크립트
const notifi = document.querySelector(".notifi");
const notifi_wrapModal = document.querySelector(".notifi_wrapModal");
const currentNotifiBox = document.querySelectorAll(".currentNotifi_contents");

// 알림창 열고 닫기
notifi.addEventListener("click", () => {
     notifi_wrapModal.classList.toggle("toggle");

      $.ajax({
         url: "/notifi",
         type: "post",
     }).done(function (notifiSelectList){
         $(".currentNotifi").replaceWith(notifiSelectList);
         notifiEventHandler();
     })

})


// 알림 클릭 이벤트 함수

function notifiEventHandler() {
    const tmpCurrent = document.querySelectorAll(".currentNotifi_contents");
    const seq = document.querySelectorAll(".seq");
    for(let i = 0; i < tmpCurrent.length; i++ ) {
        tmpCurrent[i].addEventListener("click", () => {
            const noti_seq= seq[i].innerHTML;

            Swal.fire({
              position: 'top-end',
              icon: 'success',
              title: '알림을 확인했습니다.',
              showConfirmButton: false,
              timer: 1500
            }).then(function() {
              $.ajax({
                   url: "/deleteNotifi",
                   type: "get",
                   data:{"noti_seq":noti_seq},
                   success:function(data) {
                       fraCalHandler();
                    },
                    error:function(e) {
                         console.log(e);
                    }
               })
            })
        })
    }
}

// fragment call 함수

function fraCalHandler() {
 $.ajax({
         url: "/notifi",
         type: "post",
     }).done(function (notifiSelectList){
         $(".currentNotifi").replaceWith(notifiSelectList);
         notifiEventHandler();
     })
}