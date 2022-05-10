//left_block 색변경
var active = document.getElementsByClassName("left");

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

//소설 통계 상세보기

$(".list").on("click", function () {
    if($(this).find(".novel-detail").is(":visible")){
        $(this).find(".novel-detail").css("display", "none")
        $(this).find(".open").css("display", "none")
        $(this).find(".close").css("display", "block")
    }else{
        $(this).find(".novel-detail").css("display", "table")
        $(this).find(".open").css("display", "block")
        $(this).find(".close").css("display", "none")
    }
});