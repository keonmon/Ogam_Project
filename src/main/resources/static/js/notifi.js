
// 알림 모달 스크립트
const notifi = document.querySelector(".notifi");
const notifi_wrapModal = document.querySelector(".notifi_wrapModal");

notifi.addEventListener("click", () => {
        notifi_wrapModal.classList.toggle("toggle");
})