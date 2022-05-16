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










// const data = search(91, RoundMake(), onerror);
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




            let str ='';
                str+="<img src='/novel/novelRoundInfo?novelNumber="+91+"'>";

            $('.x_ximg').html(str)


        getNovelVo(91,function (result) {
            // 제목
            let title= document.createElement('h2');
            let titletext=document.createTextNode(`${result.novelTitle}`)
            //조회수
            let cnt= document.createElement('h3');
            let cnttext=document.createTextNode(`${result.novelViewCountTotal}만명`)
            //카테고리
            let gener = document.createElement('span')
            gener.className="hashtagSpan"

                let hash = result.novelHashtag+"";
            // let genertext =document.createTextNode(`${result.novelHashtag}`);
            //
            // console.log(genertext.data)
            // console.log(genertext.data.split(','))
            // 작품소개
            modelHText = document.createTextNode(`${result.novelTitle}`)
            modelBText = document.createTextNode(`${result.novelIntro}`)

            // console.log(genertext);
            // console.log(genertext.data);
            // let NwriterText =document.createTextNode(result.original_title)
            // 이미지


            title.append(titletext)
            cnt.append(cnttext)
            let arr = new Array();
            arr = hash.split(" ");
            console.log(arr);

            for (var i = 0; i < arr.length; i++) {
                // let gener = document.createElement('span')

                let str="";
                str = "<span class='hashtagSpan'>#"+arr[i]+"</span>";
                $('.hashtag').append(str);
            }
            // gener.append('#'+genertext.split('  '))


            Noveltitle.append(title)
            watchCnt.append(cnt)
            // x_Desc_writer_N.append(NwriterText)

            introHead.append(modelHText)
            introbody.append(modelBText)
        } );





}




const cnt =ResCnt();
ResRank()
function ResRank(){
    ResRank= document.querySelector('.ResRank')
    table = document.querySelector('.table')
    cnt.slice(0,10)?.map((v,index) =>{

        //  sponCnt = document.createTextNode(`${index}${v.id}님 ${v.sponCnt}개`)

        ResRank.innerHTML +=
            `
        
        <span class="rankCnt"> ${index+1}위 ${v.id}님 ${v.sponCnt}개  <span/>  
        `
    })

    cnt?.map((v,index)=>{
        table.innerHTML +=
            ` 
    
        <tr>
             <th style="width: 33%">${index+1}위</th>
             <th style="width: 33%">${v.id}님</th>
             <th style="width: 33%"> ${v.sponCnt}개</th>
         </tr>




         `
    })

}

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


//댓글
const replyData = reply();
replyD()

function replyD(){
    ReplyToTal = document.querySelector(".ReplyToTal")
    const ReplyCmt = document.querySelector(".ReplyCmt")




    ReplyToTal.innerHTML += `${replyData.length}개`
    replyData.slice(0,10)?.map(v =>{

        ReplyCmt.innerHTML +=
            `
        <div class="ReplyCmtWrap">
        <div class="ReplyCmtDtail">
        <div class="ReplyImg">
        <img src="./파댕이.PNG" alt="">
            </div>
            <div class="ReplyDEC">
            <div class="ReplyIds">
            <div class="ReplyId">
            ${v.user.username}
            </div>
            <div class="ReplyDateWrap">
            <div class="ReplyDate"></div>
            </div>
            </div>
                
            <div class="ReplyText">
                    ${v.body}
                </div>
                <div class="ReplyLikeWrap">
                    <div class="ReplyLike">
                    
                    
                    <img src="https://static-page.kakao.com/static/common/icon_like.svg?f9e9a51be34a0e0106b7c1e179d0b43e" alt="" class="changImg">
                    
                    
                    </div>
                    <div class="ReplyLikeCnt">
                    ${v.postId}
                    </div>
                    
                    
                    </div>
                    </div>
                    <div class="ReplyDeclarWrap">
                    <div class="ReplyDeclar " >신고</div>
                    </div>
                    </div>
                    
                    </div>
                    
                    
                    `




    })

    const ReplyDeclar = document.querySelectorAll(".ReplyDeclar")
    for(i=0; i<ReplyDeclar.length;i++){
        ReplyDeclar[i].addEventListener('click',(e)=>{
            if (!confirm(e.composedPath()[2].childNodes[3].childNodes[1].childNodes[1].innerText +"님을 신고하시겠습니까?")) {

            } else {
                alert("신고완료");
            }




        })
    }
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
