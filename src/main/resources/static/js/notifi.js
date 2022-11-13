
// 알림 모달 스크립트
const notifi = document.querySelector(".notifi");
const notifi_wrapModal = document.querySelector(".notifi_wrapModal");
const currentNotifiBox = document.querySelectorAll(".currentNotifi_contents");

// 알림창 열고 닫기
notifi.addEventListener("click", () => {
     notifi_wrapModal.classList.toggle("toggle");

})


// 알림 클릭 이벤트
//for(let i = 0; i < currentNotifiBox.length; i++) {
//    currentNotifiBox.addEventListener("click", () =>{
//        console.log(currentNotifiBox[i]);
//    })
//}