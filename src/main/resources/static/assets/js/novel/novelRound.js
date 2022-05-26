function ModalHandler(){
    document.body.classList.add('preventscroll');
    document.querySelector('.Sponmodalwrap').style.display='block'
}
function ModalHandlerClose(){
    document.querySelector('.Sponmodalwrap').style.display='none'
    document.body.classList.remove('preventscroll');
}
function IntroModalHandler(){
    document.body.classList.add('preventscroll');
    document.querySelector('.intromodalwrap').style.display='block'
}
function IntroModalHandlerClose(){
    document.body.classList.remove('preventscroll');
    document.querySelector('.intromodalwrap').style.display='none'
}

//소설회차 수정버튼
$('span.modify').on("click", function () {
    $('div.modify').css('display', 'block');
    $('div.delete').css('display', 'none');
    $('div.change').css('display', 'none');
    $('div.ok').css('display', 'none');
    $('div.cancle').css('display', 'block');
})
//소설회차 삭제버튼
$('span.delete').on("click", function () {
    $('div.delete').css('display', 'block');
    $('div.modify').css('display', 'none');
    $('div.change').css('display', 'none');
    $('div.ok').css('display', 'block');
    $('div.cancle').css('display', 'none');
})
//소설회차 취소버튼
$('div.cancle').on("click", function () {
    $('div.cancle').css('display', 'none');
    $('div.delete').css('display', 'none');
    $('div.modify').css('display', 'none');
    $('div.change').css('display', 'block');
})
//소설회차 완료버튼
$('div.ok').on("click", function () {
    $('div.change').css('display','block');
    $('div.ok').css('display', 'none');
    $('div.delete').css('display', 'none');
    $('div.modify').css('display', 'none');
    $('div.cancle').css('display', 'none');
})

/*수정 아이콘 눌렀을 때 */
$('div.modify>img.modifyIcon').on("click",function () {
    let subnovelNumber=$(this).attr('id');
    location.href="novelModify?subNovelNumber="+subnovelNumber+"&novelNumber="+novelNumber;
})



function setStringNumber(count) {
    if(count >= 1000 && count < 10000){ //1k
        return (count / 1000) + "." + Math.round(count%1000/100) + "K";
    }
    else if(count >= 10000 && count < 100000){ //10k
        return (count / 1000) + "." + Math.round(count%1000/100) + "K";
    }
    else if(count >= 100000 && count < 1000000){ //100k
        return (count / 1000) + "." + Math.round(count%1000/100) + "K";
    }
    else if(count >= 1000000 && count < 10000000){ //1M
        return (count / 1000000) + "." + Math.round(count%1000000/100000) + "M";
    }
    else if(count >= 10000000 && count < 100000000){ //10M
        return (count / 1000000) + "." + Math.round(count%1000000/100000) + "M";
    }
    else if(count >= 100000000 && count < 1000000000){ //100M
        return (count / 1000000) + "." + Math.round(count%1000000/100000) + "M";
    }
    else if(count >= 1000000000){ //1B
        return (count / 1000000000) + "B";
    }
    return count+"";
}





//삭제버튼(체크박스)눌렀을때 클래스 부여
$('.deleteCheckBox').on("click",function(){
    if($(this).is(':checked')){
        $(this).addClass("checkDelete");
    }else{
        $(this).removeClass("checkDelete");
    }
})

//삭제 완료 버튼
$('.ok').on("click",function () {
    let array = new Array;
    $(".checkDelete").each(function(i, check){
        array[i] = $(check).attr("id");
    })
    let data = {"deleteNumber":array, "novelNumber":novelNumber};
    $.ajax({
        type:'post',
        url:'/novel/deleteSubNovel',
        data:JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        success:function (result) {
            location.href="novelRoundList?novelNumber="+novelNumber;
        },
        error:function () {
            alert("삭제 실패");
        }

    })
})

/*소설 찜하기*/
$('.myPick').on("click", function () {
    let novelHeart = 0;
    if($(this).attr('src')=="/images/icon/소설하트.png"){
        $(this).attr('src',"/images/icon/소설하트full.png");
        novelHeart=1;
    }else{
        $(this).attr('src',"/images/icon/소설하트.png");
        novelHeart=-1;
    }

    $.ajax({
        url:"/novel/myPick?num="+novelHeart+"&novelNumber="+novelNumber+"&userNumber="+userNumber,
        type:"get",
        success:function (result) {
            console.log(result);
        },
        error:function (error) {
            alert("찜하기 실패");
        },

    })

});

$('.Noveltt').on("click", function () {
    if($(this).hasClass("locked")){

    }
})


let href;
let subNovelNum;
/*소설회차 잠금 모달*/
$('.locked2').on("click", function (e) {
    e.preventDefault();
    $('.modal_background').css('display', 'block');
    // lockIcon=$(this).children('img');
    href=$(this).parent().attr('href');
    subNovelNum=$(this).parent().attr('name');

})
//후원 모달창 바깥영역 눌러서 닫기
$(document).mouseup(function (e){
    let container = $('.modal_background');
    let container2 = $('.modal_background2');
    if( container.has(e.target).length === 0){
        container.css('display','none');
    }
    if(container2.has(e.target).length === 0){
        container2.css('display','none');
        // location.href=href;
    }
});

//후원 모달창 '안볼래요'버튼 클릭시 닫기
$('.coinBtn2').on("click", function () {
    $('.modal_background').css('display','none');
})

//후원 코인 결제 눌렀을 때
$('.coinBtn1').on("click", function () {
    $('.modal_background').css('display', 'none');
    $('.modal_background2').css('display', 'block');

    $.ajax({
        type:"get",
        url:"/buyChapter/checkBalanceAndBuy?novelNumber="+novelNumber+"&subNovelNumber="+subNovelNum+"&userNumber="+userNumber+"",
        success:function (result) {
            console.log(result);
        },
        error:function (error) {
            console.log(error);
        }
    })
})
//결제 완료모달창 닫기
$('.goToRead').on("click", function () {
    $('.modal_background2').css('display', 'none');
    location.href=href;

})







//
//
//
//
// //
// // getSupportList(novelNumber, function (data) {
// //     console.log(data);
// // })
//
//
// // function ResRank(){
// //     ResRank= document.querySelector('.ResRank')
// //     table = document.querySelector('.table')
// //     cnt.slice(0,10)?.map((v,index) =>{
// //
// //         //  sponCnt = document.createTextNode(`${index}${v.id}님 ${v.sponCnt}개`)
// //
// //         ResRank.innerHTML +=
// //             `
// //
// //         <span class="rankCnt"> ${index+1}위 ${v.id}님 ${v.sponCnt}개  <span/>
// //         `
// //     })
// //
// //     cnt?.map((v,index)=>{
// //         table.innerHTML +=
// //             `
// //
// //         <tr>
// //              <th style="width: 33%">${index+1}위</th>
// //              <th style="width: 33%">${v.id}님</th>
// //              <th style="width: 33%"> ${v.sponCnt}개</th>
// //          </tr>
// //
// //
// //
// //
// //          `
// //     })
// //
// // }
//
// ///페이징 처리
// // const writeD = write();
// // writeDum()
// //
// // function writeDum(){
// //     NoveltotalCnt = document.createTextNode("전체(" +writeD.length+ ")개")
// //     document.querySelector('.NoveltotalCnt').append(NoveltotalCnt)
// //     Novel = document.querySelector('.Novel');
// //
// //     let current =0;
// //     let current10 = current+10
// //
// //
// //     writeD.slice(current,current10)?.map((v,index)=>{
// //
// //         Novel.innerHTML +=
// //             ` <li class="Novelli">
// //         <div class="NovelImg">
// //         <img src="./파댕이2.PNG" alt="">
// //
// //         </div>
// //
// //         <div class="NovelDEC">
// //             <div class="NovelDECS">
// //                 <div class="Noveltt">${v.Novel_title} ${index+1}화</div>
// //                 <div class="Novelday">${v.Novel_Date}</div>
// //             </div>
// //
// //         </div>`
// //
// //     })
// //
// //
// //
// // }
//
//
//
//
//
// //최신순
//
//
// let bb = document.querySelectorAll('.bb');
// function clickHandler() {
//     for (var i = 0; i < bb.length; i++){
//         bb[i].classList.remove('choose');
//     }
//     this.classList.add('choose');
// }
//
// for (var i = 0; i < bb.length; i++){
//     bb[i].addEventListener('click', clickHandler);
// }
//
//
//
// // 클릭 하트 변경
// let heartChange = document.querySelectorAll('.changImg');
// clickheartHandler();
//
//
// let clickheat =true;
// function clickheartHandler(clickheat){
//     for(i=0; i< heartChange.length; i++){
//         heartChange[i].addEventListener("click",function(){
//             clickheat;
//             if(!clickheat){
//                 this.setAttribute("src","https://static-page.kakao.com/static/common/icon_like_already.svg?b34ad60df8d04b48d10fbba10519e931")
//                 clickheat =true
//
//             }else{
//                 this.setAttribute("src","https://static-page.kakao.com/static/common/icon_like.svg?f9e9a51be34a0e0106b7c1e179d0b43e")
//                 clickheat =false
//             }
//
//
//         })
//
//     }
//
// }
