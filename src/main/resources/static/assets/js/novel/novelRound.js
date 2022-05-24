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

/*수정,삭제 버튼*/
$('span.modify').on("click", function () {
    $('div.modify').css('display', 'block');
    $('div.delete').css('display', 'none');
    $('div.change').css('display', 'none');
    $('div.ok').css('display', 'none');
    $('div.cancle').css('display', 'block');
})

$('span.delete').on("click", function () {
    $('div.delete').css('display', 'block');
    $('div.modify').css('display', 'none');
    $('div.change').css('display', 'none');
    $('div.ok').css('display', 'block');
    $('div.cancle').css('display', 'none');
})
$('div.cancle').on("click", function () {
    $('div.cancle').css('display', 'none');
    $('div.delete').css('display', 'none');
    $('div.modify').css('display', 'none');
    $('div.change').css('display', 'block');

    // $('div.ok').css('display', 'none');
})

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
    location.href="novelModify?subNovelNumber="+subnovelNumber;
})

$('div.delete>input.deleteCheckBox').on("click", function () {
    let subnovelNumber = $(this).attr('id');

})


let count=0;
window.onscroll = function(e) {

    if((window.innerHeight + window.scrollY+1) >= document.body.offsetHeight) {

        const ReplyCmt =$(".ReplyCmt");
        const ReplySize = $('.replySize');
        console.log("이벤트 들어옴");
        getReplyListPageing(novelNumber,count,function (replyVOList, userVOList) {
            console.log(count);

            let str = "";
            let replyVO = replyVOList.content;
            let userVO = userVOList.content;
            ReplySize.html(replyVOList.totalElements+"개");

            if(replyVOList.content.length== null || replyVOList.content.length == 0 && replyVOList.content[0].replyNumber!=undefined){
                ReplyCmt.html("<p>등록된 댓글이 없습니다.</p>");
                return;
                }
                for (let i=0; i<replyVO.length; i++){
                    console.log("반복문");
                    let replyUploadDate =replyVO[i].replyUpdateDate+"";
                    str +="<div class='profilePlusText' style='position: relative;'>";
                    str +="<div class='Best'>Best</div>";
                    str +="<div>";
                    str +="<div class='profile'><img src='"+userVO[i].userFilePath+"'class='img'/></div>";
                    str +="</div>";
                    str +="<div style='width: 678px;'>";
                    str +="<div style='font-size: 12px;'>"+ userVO[i].userNickName +"</div>";
                    str +="<div>"+replyVO[i].replyContent+"</div>";
                    str +="</div>";
                    str +="<div>";
                    str +="<div style='text-align: right; display: flex;'>";
                    str +="<button class='mentBtns mentBtns1' style='margin-right: 6px; border-color:#cbcbcb; color:#cbcbcb;' data-replynum ='"+replyVO[i].replyNumber+"' type='button'>";
                    str +="<img src='/images/icon/좋아요.png' height='20' width='20' class='likeBtn'/>";
                    str +="<span style='vertical-align: super;'>"+replyVO[i].replyUp+"</span>";
                    str +="</button>";
                    str +="<button class='mentBtns siren' style='border-color: #ef6e73;' id='"+replyVO[i].replyNumber+"'><img src='/images/icon/사이렌full.png' height='20' width='20'/></button>";
                    str +="</div>";
                    str +="<div class='date'>";
                    str +=replyUploadDate.substring(0,10);
                    str +="</div>";
                    str +="</div>";
                    str +="</div>";
                 };
                console.log("반복문한회차끝");
            $('.ReplyCmt').append(str);
        });
        count++;
    }

}

/*댓글+유저 VOLIST 불러오기 */
function getReplyListPageing(novelNumber,page, callback, error) {

    $.ajax({
        type:"get",
        url:"/reply/getReplyUserDTO?novelNumber="+novelNumber+"&page="+page,
        success:function (ReplyUserDTO) {
            if(callback){
                callback(ReplyUserDTO.replyVOList, ReplyUserDTO.userVOList);
            }
        },
        error:function (error) {
            alert("댓글불러오기실패");
        },
    });
}





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






$('.deleteCheckBox').on("click",function(){
    if($(this).is(':checked')){
        $(this).addClass("checkDelete");
    }else{
        $(this).removeClass("checkDelete");
    }
})

/*삭제기능*/
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
    let num = 0;
    if($(this).attr('src')=="/images/icon/소설하트.png"){
        $(this).attr('src',"/images/icon/소설하트full.png");
        num=1;
    }else{
        $(this).attr('src',"/images/icon/소설하트.png");
        num=-1;
    }

    $.ajax({
        url:"/novel/myPick?num="+num+"&novelNumber="+novelNumber+"&userNumber="+userNumber,
        type:"get",
        success:function (result) {
            console.log(result);
        },
        error:function (error) {
            alert("찜하기 실패");
        },

    })

});


/*댓글 좋아요 기능*/
$('.ReplyCmt').on("click", "button.mentBtns1",function () {
    let replyNum=$(this).data("replynum");
    if ($(this).children('img').attr('src') == '/images/icon/좋아요full.png') {
        let $number = parseInt($(this).children('span').html());
        $(this).css('border-color', '#cbcbcb');
        $(this).css('color', '#cbcbcb');
        $(this).children('img').attr('src', '/images/icon/좋아요.png');
        $(this).children('span').html($number - 1);
        replyUp({"replyNum":replyNum, "num":-1}, function(result){
        });

    } else {

        let $number = parseInt($(this).children('span').html());
        $(this).css('border-color', '#5A94FF');
        $(this).css('color', '#5A94FF');
        $(this).children('img').attr('src', '/images/icon/좋아요full.png');
        $(this).children('span').html($number + 1);
        replyUp({"replyNum":replyNum, "num":1},function(result) {
        });
    }

});
/*댓글 좋아요기능 ajax*/
function replyUp(reply, callback, error){

    $.ajax({
        type: "GET",
        url: "/reply/"+reply.replyNum+"/"+reply.num,
        success: function(result, status, xhr){
            if(callback){
                callback(result);
            }
        },
        error: function(xhr, status, er){
            if(error){
                error(er);
            }
        }

    });
}

/*댓글 신고*/
$('.ReplyCmt').on("click", "button.siren",function () {
    Swal.fire({
        title: '해당 댓글을 신고하시겠습니까?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#ef6e73',
        cancelButtonColor: '#a8a8a8',
        confirmButtonText: '네',
        cancelButtonText: '아니요',
        fontSize : 15,
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire({
                confirmButtonColor: '#ef6e73',
                title:'신고되었습니다.'
            })
            $.ajax({
                type:"get",
                url:"/novelDetail/siren?replyNumber="+$(this).attr('id'),
                success:function (result) {
                    console.log(result);
                },
                error:function (error) {
                    alert("댓글 신고 실패");
                    console.log(error);
                }

            })

        }

    })
});










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
