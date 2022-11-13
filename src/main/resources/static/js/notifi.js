
// 알림 모달 스크립트
const notifi = document.querySelector(".notifi");
const notifi_wrapModal = document.querySelector(".notifi_wrapModal");
const currentNotifiBox = document.querySelectorAll(".currentNotifi_contents");

// 알림창 열고 닫기
notifi.addEventListener("click", () => {
     notifi_wrapModal.classList.toggle("toggle");

})


// 알림 클릭 이벤트
for(let i = 0; i < currentNotifiBox.length; i++) {
    currentNotifiBox[i].addEventListener("click", () =>{
        console.log(currentNotifiBox[i]);
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: '알림을 확인했습니다.',
          showConfirmButton: false,
          timer: 1500
        }).then(function() {
         $.ajax({
                url: "/currentNotifi",
                type: "post",
                data:data,
            }).done(function (friendSendList){
                $(".currentNotifi").replaceWith(friendSendList);
            })
        })
    })
}