// 목록에 따른 타이틀 변경

function innerSample1() {
  // span 문자열 변경
  document.getElementById("adminTitle").innerHTML = "사용자목록";
}


// 체크박스 전체 선택
function selectAll(selectAll)  {
    const checkboxes
       = document.querySelectorAll('input[type="checkbox"]');

    checkboxes.forEach((checkbox) => {
      checkbox.checked = selectAll.checked
    })
}

