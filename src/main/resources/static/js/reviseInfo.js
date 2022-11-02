function click_img(event) {
    let file = new FileReader();

    file.onload = function(event) {
        let img = document.createElement("img");
        img.setAttribute("src", event.target.result);
        document.querySelector('span#imgBlock').appendChild(img);
    };

    file.readAsDataURL(event.target.files[0]);
}