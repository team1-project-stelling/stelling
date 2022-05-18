var left = document.getElementsByClassName("left");

function handleClick(event) {
    console.log(event.target);
    console.log(event.target.classList);

    left[0].classList.remove("clicked");
    if (event.target.classList[1] === "clicked") {
        event.target.classList.remove("clicked");
    } else {
        for (var i = 0; i < active.length; i++) {
            left[i].classList.remove("clicked");
        }

        event.target.classList.add("clicked");
    }
}
function init() {
    left[4].classList.add("clicked");
    for (var i = 0; i < active.length; i++) {
        left[i].addEventListener("click", handleClick);
    }
}
init();

//체크박스 동의 후 서브밋
function check_agree() {
    let check1 = $('#idAgree1').is(':checked');
    let check2 = $('#idAgree2').is(':checked');

    if(check1 == false){
        alert('동의를 모두 하셔야 합니다.');
        return;
    }else if(check2 == false){
        alert('동의를 모두 하셔야 합니다.');
        return;
    }else{
        alert('탈퇴가 완료되었습니다.');
        $('#withDrawForm').submit();
    }
}

