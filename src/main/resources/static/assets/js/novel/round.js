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










const data = search();
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
    
     data.slice(1,2)?.map((v)=>{
        
        let img= document.createElement('img');
        img.src=`https://image.tmdb.org/t/p/w500${v.poster_path}`;
        let imgs= document.createElement('img');
        imgs.src=`https://image.tmdb.org/t/p/w500${v.poster_path}`;


        //제목
        let title= document.createElement('h2');
        let titletext=document.createTextNode(`${v.title}`)
        //조회수
        let cnt= document.createElement('h3');
        let cnttext=document.createTextNode(`${v.vote_count}만명`)
        //카테고리
        let gener = document.createElement('span')
        gener.className="hashtagSpan"
        console.log((v.genre_ids).length)
            
        let genertext =document.createTextNode(`${v.genre_ids}`)
       
        console.log(genertext.data)
        console.log(genertext.data.split(','))   
        // 작품소개
        modelHText = document.createTextNode(`${v.title}`)
        modelBText = document.createTextNode(`${v.overview}`)


        let NwriterText =document.createTextNode(v.original_title)
        //이미지 
        
        
        title.append(titletext)
        cnt.append(cnttext)
        gener.append('#'+genertext.data.split(',')[0])
       
        hashtag.append(gener)
        Noveltitle.append(title)
        watchCnt.append(cnt)
        x_ximg.append(img)
        x_Desc_writer_N.append(NwriterText)

        introHead.append(modelHText)
        introbody.append(modelBText)
    })


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
        <img src="/images/파댕이2.PNG" alt="">

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
        <img src="/images/파댕이.PNG" alt="">
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
                    
                    
                    <img src="https://static-page.kakao.com/static/common/icon_like.svg?f9e9a51be34a0e0106b7c1e179d0b43e" alt="">
                    
                    
                    </div>
                    <div class="ReplyLikeCnt">
                    ${v.postId}
                    </div>
                    
                    
                    </div>
                    </div>
                    <div class="ReplyDeclarWrap">
                    <div class="ReplyDeclar" >신고</div>
                    </div>
                    </div>
                    
                    </div>
                    
                    
                    `
                    
                    
                 
                    
                })
                
        const ReplyDeclar = document.querySelectorAll(".ReplyDeclar")
        for(i=0; i<ReplyDeclar.length;i++){
        ReplyDeclar[i].addEventListener('click',(e)=>{


            alert(e.composedPath()[2].childNodes[3].childNodes[1].childNodes[1].innerText)


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