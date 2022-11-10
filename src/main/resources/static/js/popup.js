function memberPopup( ) {
        
    window.open("/admin/memberPopup.html", "memberPopup",
    ['fullscreen=no,menubar=no,status=no,toolbar=no,titlebar=no,location=no,scrollbar=auto,width=550px,height=750px'] );
    
    iniform.target="memberPopup";
    iniform.action="/admin/memberPopup.html";
    
    iniform.submit( );
    
}

function diaryPopup( ) {
        
    window.open("/diaryPopup", "diaryPopup",
    ['fullscreen=no,menubar=no,status=no,toolbar=no,titlebar=no,location=no,scrollbar=auto,width=550px,height=625px'] );
    
    iniform.target="diaryPopup";
    iniform.action="diaryPopup.html";
    
    iniform.submit( );
    
}

function commentPopup( ) {
        
    window.open("/admin/commentPopup", "commentPopup",
    ['fullscreen=no,menubar=no,status=no,toolbar=no,titlebar=no,location=no,scrollbar=auto,width=550px,height=510px'] );
    
    iniform.target="commentPopup";
    iniform.action="/admin/commentPopup";
    
    iniform.submit( );
    
}