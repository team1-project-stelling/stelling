//상단 버튼
var active = document.getElementsByClassName("active");

function handleClick(event) {
    console.log(event.target);
    console.log(event.target.classList);

    active[0].classList.remove("clicked");
    if (event.target.classList[1] === "clicked") {
        event.target.classList.remove("clicked");
    } else {
        for (var i = 0; i < active.length; i++) {
            active[i].classList.remove("clicked");
        }

        event.target.classList.add("clicked");
    }
}
function init() {
    active[1].classList.add("clicked");
    for (var i = 0; i < active.length; i++) {
        active[i].addEventListener("click", handleClick);
    }
}
init();
//----------------------------------------------------------

//left_block 색변경
var left = document.getElementsByClassName("left");

function Click(event) {
    console.log(event.target);
    console.log(event.target.classList);

    left[0].classList.remove("oned");
    if (event.target.classList[1] === "oned") {
        event.target.classList.remove("oned");
    } else {
        for (var i = 0; i < active.length; i++) {
            left[i].classList.remove("oned");
        }

        event.target.classList.add("oned");
    }
}
function test() {
    left[1].classList.add("oned");
    for (var i = 0; i < active.length; i++) {
        left[i].addEventListener("on", Click);
    }
}
test();
