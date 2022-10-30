
// 알림 모달 스크립트
const notifi = document.querySelector(".notifi");
const notifi_wrapModal = document.querySelector(".notifi_wrapModal");

notifi.addEventListener("click", () => {
        notifi_wrapModal.classList.toggle("toggle");
})

// 친구 모달 스크립트
function friend_Modal() {
    let modalContainer = document.querySelector(".modalContainer");
    modalContainer.style.display = "block";
}

function closeModal1() {
    let modalContainer = document.querySelector(".modalContainer");
    modalContainer.style.display = "none";
}

// 모달창 버튼 스크립트
const addBtn = document.querySelectorAll(".addBtn");
const add = document.querySelectorAll(".add");
const complete = document.querySelectorAll(".complete");

for (let i = 0; i < addBtn.length; i++) {
    addBtn[i].addEventListener("click", () => {
        add[i].style.display = "none";
        complete[i].style.display = "block";
    })
}