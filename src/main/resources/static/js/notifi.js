
// 알림 모달 스크립트
const notifi = document.querySelector(".notifi");
const notifi_wrapModal = document.querySelector(".notifi_wrapModal");
const currentNotifiBox = document.querySelectorAll(".currentNotifi_contents");
const message = document.querySelectorAll(".currentNotifi_message span");
// 알림창 열고 닫기
notifi.addEventListener("click", () => {
     notifi_wrapModal.classList.toggle("toggle");

      $.ajax({
         url: "/notifi",
         type: "post",
     }).done(function (notifiSelectList){
        console.log(notifiSelectList)
         $(".currentNotifi").replaceWith(notifiSelectList);
     })

})


// 알림 클릭 이벤트
for(let i = 0; i < currentNotifiBox.length; i++) {
    currentNotifiBox[i].addEventListener("click", () =>{
    console.log(message[i])
        // 친구 친청 op_email 변수에 넣어주기


        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: '알림을 확인했습니다.',
          showConfirmButton: false,
          timer: 1500
        }).then(function() {
//          $.ajax({
//              url:"/deleteNotifi",
//              type:"post",
//              data:{},
//              success:function(data) {
//                 console.log(data);
//                 //member_list.remove();
//              },
//              error:function(e) {
//                   console.log(e);
//              }
//           })
        })
    })
}