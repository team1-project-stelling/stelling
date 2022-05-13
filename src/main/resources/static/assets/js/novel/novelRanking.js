// const category = $(".nav-link");
//     console.log(category);
// $.each (category, function(item, index){
//     console.log(index, el);
// });

// $(".active").on("click", function(){
//     console.log(this);
//     this.css('background-color', 'black');
// })

//메뉴 클릭 시 클래스 추가
// const category = document.querySelector(".nav-link");
// for(var i=0; i<category.length; i++){
//     (category[i]).onclick=function(){
//         (category[i]).classList.add("active");
//     }
// }



//태그 클릭 시 해당 태그 인덱스 값 부여 -> 클릭시 css 먹이기
$(document).ready(function(){
    $('.nav-link').each(function(index){
        $(this).attr('menu-index', index);
    }).click(function(){
        var index = $(this).attr('menu-index');
        $('.nav-link[menu-index=' + index + ']').addClass('clicked_menu');
        $('.nav-link[menu-index!=' + index + ']').removeClass('clicked_menu');
    });


});

//각 이미지 마다 적용될 수 있도록 바꿔야함!
//필요 없을 듯!
// const imgs = document.querySelectorAll(".scale");

// for(var i = 0; i<imgs.length; i++){
//     imgs[i].setAttribute('onmouseenter', zoomIn(event));
//     imgs[i].setAttribute('onmouseleave', zoomOut(event));
//     console.log(imgs[i]);
// }

//마우스 올렸을 때 이미지 확대
function zoomIn(event){
    event.target.style.transform = "scale(1.2)"; //1.2배 확대
    event.target.style.zIndex = 1;
    event.target.style.transition = "all 0.5s";// 속도
}

function zoomOut(event){
    event.target.style.transform = "scale(1)";
    event.target.style.zIndex = 0;
    event.target.style.transition = "all 0.5s";
}

//마우스 올렸을 때 폰트 색 변경(전체, 자유, 완결)
function mouseOver(event){
    event.target.style.color = "#ef6e73";
}

function mouseOut(event){
    event.target.style.color = "#000";
}


//상단 메뉴바 클릭 시 밑줄(클래스 주기)
let menus = document.querySelectorAll('.click-menu');
function clickMenu() {
    for (var i = 0; i < menus.length; i++){
        menus[i].classList.remove('menu-select');
    }
    this.classList.add('menu-select');
}

for (var i = 0; i < menus.length; i++){
    menus[i].addEventListener('click', clickMenu);
}

//상단 메뉴바 클릭시 밑줄(클래스 주기)
//     $(document).ready(function(){
// 	$('.click-menu').each(function(index){
// 		$(this).attr('menu-index', index);
// 	}).click(function(){
// 		var index = $(this).attr('menu-index');
//         console.log(index);
// 		$('.click-menu[menu-index=' + index + ']').addClass('menu-select');
// 		$('.click-menu[menu-index!=' + index + ']').removeClass('menu-select');
// 	});


// });

//태그 검색 보이기 숨기기
function changeTagSearch(){
    $('.category_ul').toggle()
    $('#searchFormWrap').toggle()
}

/*태그검색 눌렀을때 모달창(안하기로!)*/
// function modal(id) {
//     var zIndex = 9999;
//     var modal = document.getElementById(id);
//
//     // 모달 div 뒤에 희끄무레한 레이어
//     var bg = document.createElement('div');
//     bg.setStyle({
//         position: 'fixed',
//         zIndex: zIndex,
//         left: '0px',
//         top: '0px',
//         width: '100%',
//         height: '100%',
//         overflow: 'auto',
//         // 레이어 색갈은 여기서 바꾸면 됨
//         backgroundColor: 'rgba(0,0,0,0.4)'
//     });
//     document.body.append(bg);
//
//     // 닫기 버튼 처리, 시꺼먼 레이어와 모달 div 지우기
//     modal.querySelector('.modal_close_btn').addEventListener('click', function() {
//         bg.remove();
//         modal.style.display = 'none';
//     });
//
//     modal.setStyle({
//         position: 'fixed',
//         display: 'block',
//         boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',
//
//         // 시꺼먼 레이어 보다 한칸 위에 보이기
//         zIndex: zIndex + 1,
//
//         // div center 정렬
//         top: '50%',
//         left: '50%',
//         transform: 'translate(-50%, -50%)',
//         msTransform: 'translate(-50%, -50%)',
//         webkitTransform: 'translate(-50%, -50%)'
//     });
// }
//
// // Element 에 style 한번에 오브젝트로 설정하는 함수 추가
// Element.prototype.setStyle = function(styles) {
//     for (var k in styles) this.style[k] = styles[k];
//     return this;
// };
//
// document.getElementById('genre_search_modal_btn').addEventListener('click', function() {
//     // 모달창 띄우기
//     modal('search_modal');
// });