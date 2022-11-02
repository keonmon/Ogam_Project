const moodSelect = document.querySelectorAll(".moodSelect div");

for(let i = 0; i < moodSelect.length; i++) {
    moodSelect[i].addEventListener("click", () => {
        for(let j = 0; j < moodSelect.length; j++) {
            moodSelect[j].style.backgroundColor = "rgb(139, 184, 232, 60%)";
        }
        moodSelect[i].style.backgroundColor = "#8BB8E8";
    })
}
