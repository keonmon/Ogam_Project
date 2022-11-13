function memberPopup( ) {
        
    window.open("/memberPopup", "memberPopup",
    ['fullscreen=no,menubar=no,status=no,toolbar=no,titlebar=no,location=no,scrollbar=auto,width=550px,height=750px'] );
    
    iniform.target="memberPopup";
    iniform.action="/memberPopup";
    
    iniform.submit( );
    
}
//const check = document.querySelectorAll(".check")
//function diary() {
//
//    for (let i=0 ; i<check.length; i++) {
//
//        check[i].addEventListener("click", ()=> {
//            let diarySeq = check[i].getAttribute("data")
//            diaryPopup(diarySeq)
//        })
//
//
//    }
//}

function diaryPopup(diary_seq) {
        
    window.open("/diaryPopup/{diarySeq}", "diaryPopup",
    ['fullscreen=no,menubar=no,status=no,toolbar=no,titlebar=no,location=no,scrollbar=auto,width=550px,height=625px'] );
    
    iniform.target="diaryPopup";
    iniform.action="/diaryPopup/{diarySeq}";

//    const input = document.getElementById("diarySeq");
//    input.value= diarySeq;
//    console.log(input.value);
    iniform.submit( );

}


function commentPopup( ) {
        
    window.open("/commentPopup", "commentPopup",
    ['fullscreen=no,menubar=no,status=no,toolbar=no,titlebar=no,location=no,scrollbar=auto,width=550px,height=510px'] );
    
    iniform.target="commentPopup";
    iniform.action="/commentPopup";
    
    iniform.submit( );
    
}