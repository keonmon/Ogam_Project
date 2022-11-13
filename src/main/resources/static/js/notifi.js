
// 알림 모달 스크립트
const notifi = document.querySelector(".notifi");
const notifi_wrapModal = document.querySelector(".notifi_wrapModal");
const currentNotifiBox = document.querySelectorAll(".currentNotifi_contents");

// 알림창 열고 닫기
notifi.addEventListener("click", () => {
     notifi_wrapModal.classList.toggle("toggle");

      $.ajax({
         url: "/notifi",
         type: "get",
     }).done(function (friendSendList){
            console.log(friendSendList);
         $(".currentNotifi").replaceWith(friendSendList);
     })

})


// 알림 클릭 이벤트
for(let i = 0; i < currentNotifiBox.length; i++) {
    currentNotifiBox[i].addEventListener("click", () =>{

        // 친구 친청 op_email 변수에 넣어주기
//        let member_op_email = member_email[i].innerHTML;
//        console.log(member_op_email);

        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: '알림을 확인했습니다.',
          showConfirmButton: false,
          timer: 1500
        }).then(function() {
         $.ajax({
                url: "/notifi",
                type: "get",
                data:data,
            }).done(function (friendSendList){
            console.log(friendSendList);
                //$(".currentNotifi").replaceWith(friendSendList);
            })
        })
    })
}