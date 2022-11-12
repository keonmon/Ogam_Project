const moodSelect = document.querySelectorAll(".moodSelect div");
let emotion = "";

for(let i = 0; i < moodSelect.length; i++) {
    moodSelect[i].addEventListener("click", (e) => {

        emotion = e.currentTarget.children[1];

        for(let j = 0; j < moodSelect.length; j++) {
            moodSelect[j].style.backgroundColor = "rgb(139, 184, 232, 60%)";
        }
      $.ajax({
            url: "/happyDiary",
            type: "post",
            async: false,
            data: JSON.stringify({'reqEmotion': emotion.textContent}),
            contentType : "application/json; charset=UTF-8",
        }).done(function (selectDiaryByMood){
            $(".diaryContainer").replaceWith(selectDiaryByMood);
        });
        moodSelect[i].style.backgroundColor = "#8BB8E8";

    })
}

// 일기 클릭시 url 이동
const diary = document.querySelectorAll(".diary");
for(let i = 0; i < diary.length; i++ ) {
    diary[i].addEventListener("click", () => {
        console.log(diary[i]);
    })
}
