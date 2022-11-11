
// 알림 모달 스크립트
const notifi = document.querySelector(".notifi");
const notifi_wrapModal = document.querySelector(".notifi_wrapModal");

notifi.addEventListener("click", () => {
        notifi_wrapModal.classList.toggle("toggle");
})

const dropbtn_click = document.querySelectorAll(".dropbtn_click");
const dropdown_content = document.querySelectorAll(".dropdown_content");

for (let i = 0; i < dropbtn_click.length; i++) {
    dropbtn_click[i].addEventListener("click", () => {
        dropdown_content[i].classList.toggle('show');
    })
}


for (let i = 0; i < dropbtn_click.length; i++) {
    dropbtn_click[i].addEventListener("click", () => {

        if (dropbtn_click[i].innerHTML == "▼") {
            dropbtn_click[i].innerHTML = "▲";
        } else if (dropbtn_click[i].innerHTML == "▲") {
            dropbtn_click[i].innerHTML = "▼";
        }
    })
}