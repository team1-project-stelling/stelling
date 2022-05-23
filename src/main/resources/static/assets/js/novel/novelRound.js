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


let novelNumber = 109;
let novelOriginTitle = "";
RoundMake();



function RoundMake(){
    //모음
    let x_ximg = document.querySelector('.x_ximg')
    let Noveltitle = document.querySelector('.Noveltitle')
    let watchCnt = document.querySelector('.watchCnt')
    let hashtag = document.querySelector('.hashtag')
    let x_Desc_writer_N=document.querySelector('.x_Desc_writer_N')
    let introHead = document.querySelector('.introHead');
    let introbody =document.querySelector('.introbody');


            //소설 이미지
            let str ="<img src='/novel/novelRoundInfo?novelNumber="+novelNumber+"'>";
            $('.x_ximg').html(str)


            getNovelVo(novelNumber,function (result) {
            // 제목
            let title= document.createElement('h2');
            let titletext=document.createTextNode(`${result.novelTitle}`);
                novelOriginTitle =result.novelTitle;
            //카테고리
            let gener = document.createElement('span')
            gener.className="hashtagSpan"
            let hash = result.novelHashtag;
            //조회수
            let cnt= document.createElement('h3');
            let cnttext=document.createTextNode(setStringNumber(`${result.novelViewCountTotal}`+`명`));

            cnt.append(cnttext)
            // 작품소개
            modelHText = document.createTextNode(`${result.novelTitle}`)
            modelBText = document.createTextNode(`${result.novelIntro}`)

            // console.log(genertext);
            // console.log(genertext.data);
            // let NwriterText =document.createTextNode(result.original_title)
            // 이미지

            //요일 체크
            let days = "";
            if(`${result.novelMonday}`==1){
                days+="<span class='d_day d_dayColor'>월</span>";
            }else{
                days+="<span class='d_day'>월</span>";
            }
            if(`${result.novelTuesDay}`==1){
                days+="<span class='d_day d_dayColor'>화</span>";
            }else{
                days+="<span class='d_day'>화</span>";
            }
            if(`${result.novelWednesDay}`==1){
                days+="<span class='d_day d_dayColor'>수</span>";
            }else{
                days+="<span class='d_day'>수</span>";
            }
            if(`${result.novelThursDay}`==1){
                days+="<span class='d_day d_dayColor'>목</span>";
            }else{
                days+="<span class='d_day'>목</span>";
            } if(`${result.novelFriDay}`==1){
                days+="<span class='d_day d_dayColor'>금</span>";
            }else{
                days+="<span class='d_day'>금</span>";
            }
            if(`${result.novelSaturDay}`==1){
                days+="<span class='d_day d_dayColor'>토</span>";
            }else{
                days+="<span class='d_day'>토</span>";
            }
            if(`${result.novelSaturDay}`==1){
                days+="<span class='d_day d_dayColor'>일</span>";
            }else{
                days+="<span class='d_day'>일</span>";
            }
            $('.days').html(days);



            //해시태그
            let arr = hash.replace(/ /gi, ",").split(',');

            for (let i = 0; i < arr.length; i++) {
                let str="";
                str = "<span class='hashtagSpan'>#"+arr[i]+"</span>";
                $('.hashtag').append(str);
            }


            // x_Desc_writer_N.append(NwriterText)

            title.append(titletext)
            Noveltitle.append(title)
            watchCnt.append(cnt)
            introHead.append(modelHText)
            introbody.append(modelBText)



        } );





}


getSubNovelList(novelNumber, function (result) {
    console.log(result);
});

//소설 회차 리스트
getOrderBySubNovelList(novelNumber, function (result) {
    NoveltotalCnt = document.createTextNode("전체(" +result.length+ ")개");
    document.querySelector('.NoveltotalCnt').append(NoveltotalCnt);
    Novel = document.querySelector('.Novel');

    let current =0;
    let current10 = current+10

    result.forEach(function (subnovel, i) {

        let date=subnovel.subNovelUploadDate+"";
        date =date.substring(0, 10);

        Novel.innerHTML +=
            ` <li class="Novelli">
        <div class="NovelImg">
        <img src='/novel/novelRoundInfo?novelNumber=${novelNumber}'>
        </div>
        <div class="NovelDEC">
            <div class="NovelDECS">
                <div class="Noveltt">${novelOriginTitle} ${i+1}화</div>
                <div class="Novelday">${date}</div>
            </div>
        </div>`
    })


})


//댓글 띄우기
getReply(novelNumber, function (replyVO, userVO) {
    const ReplyCmt =$(".ReplyCmt");
    let str = "";
    let replyArea = $('.replyWrap');

    if(replyVO == null || replyVO.length == 0){
        replyArea.html("<p>등록된 댓글이 없습니다.</p>");
        return;
    }
    for (let i=0; i<replyVO.length; i++){
        let replyUploadDate =replyVO[i].replyUploadDate+"";
        str +="<div class='profilePlusText' style='position: relative;'>";
        str +="<div class='Best'>Best</div>";
        str +="<div><!--프사, 아이디-->";
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
        str +="<button class='mentBtns siren' style='border-color: #ef6e73;'><img src='/images/icon/사이렌full.png' height='20' width='20'/></button>";
        str +="</div>";
        str +="<div class='date'>";
        str +=replyUploadDate.substring(0,10);
        str +="</div>";
        str +="</div>";
        str +="</div>";
    };
    ReplyCmt.html(str);
});





// const cnt =ResCnt();
//
// ResRank()
// function ResRank(){
//     ResRank= document.querySelector('.ResRank')
//     table = document.querySelector('.table')
//     cnt.slice(0,10)?.map((v,index) =>{
//
//         //  sponCnt = document.createTextNode(`${index}${v.id}님 ${v.sponCnt}개`)
//
//         ResRank.innerHTML +=
//             `
//
//         <span class="rankCnt"> ${index+1}위 ${v.id}님 ${v.sponCnt}개  <span/>
//         `
//     })
//
//     cnt?.map((v,index)=>{
//         table.innerHTML +=
//             `
//
//         <tr>
//              <th style="width: 33%">${index+1}위</th>
//              <th style="width: 33%">${v.id}님</th>
//              <th style="width: 33%"> ${v.sponCnt}개</th>
//          </tr>
//
//
//
//
//          `
//     })
//
// }

///페이징 처리
const writeD = write();
writeDum()

function writeDum(){
    NoveltotalCnt = document.createTextNode("전체(" +writeD.length+ ")개")
    document.querySelector('.NoveltotalCnt').append(NoveltotalCnt)
    Novel = document.querySelector('.Novel');

    let current =0;
    let current10 = current+10


    writeD.slice(current,current10)?.map((v,index)=>{

        Novel.innerHTML +=
            ` <li class="Novelli">
        <div class="NovelImg">
        <img src="./파댕이2.PNG" alt="">

        </div>
        
        <div class="NovelDEC">
            <div class="NovelDECS">
                <div class="Noveltt">${v.Novel_title} ${index+1}화</div>
                <div class="Novelday">${v.Novel_Date}</div>
            </div>
                
        </div>`

    })



}





//최신순


let bb = document.querySelectorAll('.bb');
function clickHandler() {
    for (var i = 0; i < bb.length; i++){
        bb[i].classList.remove('choose');
    }
    this.classList.add('choose');
}

for (var i = 0; i < bb.length; i++){
    bb[i].addEventListener('click', clickHandler);
}



// 클릭 하트 변경
let heartChange = document.querySelectorAll('.changImg');
clickheartHandler();


let clickheat =true;
function clickheartHandler(clickheat){
    for(i=0; i< heartChange.length; i++){
        heartChange[i].addEventListener("click",function(){
            clickheat;
            if(!clickheat){
                this.setAttribute("src","https://static-page.kakao.com/static/common/icon_like_already.svg?b34ad60df8d04b48d10fbba10519e931")
                clickheat =true

            }else{
                this.setAttribute("src","https://static-page.kakao.com/static/common/icon_like.svg?f9e9a51be34a0e0106b7c1e179d0b43e")
                clickheat =false
            }


        })

    }

}
