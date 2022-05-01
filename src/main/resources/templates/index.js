//배너

const slides = document.querySelector('.M_Banner_imgs');  //전체 슬라이드 컨테이너
const slideImg = document.getElementsByClassName('banner_img');  //모든 슬라이드들

const slideCount = slideImg.length; // 슬라이드 개수 
const prev = document.querySelector('.left'); //이전 버튼 
const next = document.querySelector('.right'); //다음 버튼


currentIdx =0;
mcurrentIdx = currentIdx-1;
pcurrentIdx =currentIdx+1;
lastslideCount= slideCount-1
function set (){
   currentIdx===slideCount?currentIdx=0:"";
   mcurrentIdx===slideCount?mcurrentIdx=0:"";
   pcurrentIdx===slideCount?pcurrentIdx=0:"";
   pcurrentIdx===-1?pcurrentIdx=lastslideCount:"";
   currentIdx===-1?currentIdx=lastslideCount:"";
   mcurrentIdx===-1?mcurrentIdx=lastslideCount:"";
  
   Mslide = slideImg[mcurrentIdx]
   mainslide = slideImg[currentIdx]
   Pslide = slideImg[pcurrentIdx]
   
}
///시작
window.onload=()=>{
//초기값 세팅
removes()
change()  

//오토 시작
auto ()
Illustrator()

}


//  slideImg[i] 클래스 삭제 중복방지
function removes(){
   for(i=0; i< slideCount;i++){
      slideImg[i].classList.remove('addd','leftadd','rightadd')
   }
}

next.addEventListener('click',function(){
   mcurrentIdx++
   currentIdx++
   pcurrentIdx++
   
   removes()
   change()
  
})



prev.addEventListener('click',function(){
   mcurrentIdx--;
   currentIdx--;
   pcurrentIdx--;
   set ()
   removes()
   change()
 
})



 function change(){
   set ()
   
   mainslide.classList.add('addd');
   Mslide.classList.add('leftadd')
   Pslide.classList.add('rightadd')
      
   }
   
   
//자동 슬라이드
function auto (){
   set();
   mcurrentIdx++
   currentIdx++
   pcurrentIdx++
   removes();
   change();

   setTimeout(auto, 4000);

}

//
RealTime()
function RealTime (){
let today = new Date()
let hour = today.getHours()
let RealMM = "";

if(hour ==0){RealMM="오후"}else if(hour <13){RealMM="오전"}else{RealMM="오후" }
hour = (hour==0)?12:hour;
if(hour <10){hour="0"+hour}
if(hour >12){hour=hour-12}
console.log(today)
const RealTime = document.createElement('a') 
writer = document.createTextNode("\n" +RealMM + hour+"시기준")
RealTime.append(writer)
document.querySelector('.RealTime').append(RealTime);

}

let tagspan = document.querySelectorAll('.tagspan');

function clickHandler() {  
     for (var i = 0; i < tagspan.length; i++){
        tagspan[i].classList.remove('clinkadd');
     }
     this.classList.add('clinkadd');
}

 for (var i = 0; i < tagspan.length; i++){
    tagspan[i].addEventListener('click', clickHandler);
 }








////////////////////////////



function makeHot(v,index,List){
    
   
    const divWrap =document.createElement('div')
    divWrap.className="divWrap"
    divWrap.id=`divWrap${index}`
  
    divWrap.onclick=ff
    
    const divimg =document.createElement('div')
    divimg.className="divimg"
    const divDesc =document.createElement('div')
    divDesc.className="divDesc"
    const divDescHead =document.createElement('div')
    divDescHead.className="divDescHead"
    const divDescRank =document.createElement('div')
    divDescRank.className="divDescRank" 
    const divDescTitle =document.createElement('div')
    divDescTitle.className="divDescTitle"       
    const pwirter = document.createElement('pwirter')
    pwirter.className="pwirter"    
    const divGenre =document.createElement('div')
    divGenre.className="divGenre"       
    const img = document.createElement('img')
    img.src=`https://image.tmdb.org/t/p/w500${v.poster_path}`;
    img.className  ="tagsimg"
    const RankSpan = document.createElement('span') 
    RankSpan.className ="RankSpan"  
    Ranking = document.createTextNode(`${index+1}위`)
    TitleSpan = document.createTextNode(`${v.title}`)
    writer = document.createTextNode(`${v.original_title}`)
    const GenerSpan = document.createElement('span') 
    GenerSpan.className="GenerSpan"
    GenerText =document.createTextNode(`#${index} #${v.vote_count} #${v.genre_ids[0]}`)     

    
   
    divWrap.append(divimg,divDesc)        
    divimg.append(img) 
    divDesc.append(divDescHead,pwirter,divGenre)
    divDescHead.append(divDescRank,divDescTitle)
    divDescRank.append(RankSpan)
    divDescTitle.append(TitleSpan)
    RankSpan.append(Ranking)
    pwirter.append(writer)
    divGenre.append(GenerSpan)
    GenerSpan.append(GenerText)
   
    List.appendChild(divWrap)

  
    //페이지 이동
function ff(){
    location.href=`index.html/${v.id}`
}
    
}






//맵으로 다 가져와버리기

 img.slice(0,3)?.map((v,index)=>{
    let List = document.querySelector('.tags_left')
   
    makeHot(v,index,List);}
    )
 

img.slice(3,6)?.map((v,index)=>{
    let List = document.querySelector('.tags_middle')
    makeHot(v,index,List);
   
})  
img.slice(6,9)?.map((v,index)=>{
    let List = document.querySelector('.tags_right')
    makeHot(v,index,List);})  

  
    dataseting()
  function dataseting (){
    let divWraps = document.querySelectorAll('.divWrap')
    for(i=0; i<divWraps.length;i++){
        divWraps[i].setAttribute("data-value",'all ')
        
    }
    let divWrap0 =document.querySelectorAll('#divWrap0')
    for(i=0; i<divWrap0.length;i++){
    divWrap0[i].setAttribute("data-value",'all a')
    }
    let divWrap1 =document.querySelectorAll('#divWrap1')
    for(i=0; i<divWrap1.length;i++){
    divWrap1[i].setAttribute("data-value",'all b')
    }
    let divWrap2 =document.querySelectorAll('#divWrap2')
    for(i=0; i<divWrap2.length;i++){
     divWrap2[i].setAttribute("data-value",'all b c')
    }

let AllSpan = document.querySelectorAll('[data-value]')
let AllGrop = document.querySelectorAll('[data-group]')
let tagspan = document.querySelectorAll('.tagspan');
function AfiterHander(){
for(i=0; i<AllGrop.length;i++){
    
}
for(i=0; i<AllSpan.length;i++){
    console.log(AllSpan[i])
}
}



console.log(tagspan[1])


    }
///메인컨테이너

function main_sectionList(v,sectionList){
   
    
    const x_item =document.createElement('div')
    x_item.className="x_item"
    x_item.onclick=ff
    const x_item_img=document.createElement('div')
    x_item_img.className="x_item_img"
    const img = document.createElement('img')
    img.className="ximg"
    img.src=`https://image.tmdb.org/t/p/w500${v.poster_path}`;
    const h3= document.createElement('h3')
    const p = document.createElement('p')
    h3text = document.createTextNode(`${v.original_title}`)
    ptext=document.createTextNode(`${v.title}`)

    
    
    x_item.appendChild(x_item_img)
    x_item_img.appendChild(img)
    x_item.appendChild(h3)
    x_item.appendChild(p)
    h3.appendChild(h3text)
    p.appendChild(ptext)

    sectionList.appendChild(x_item)
    //페이지 지동
    function ff(){
        location.href=`index.html/${v.id}`
    }
        


}

img.slice(0,6)?.map((v)=>{
    const sectionList  = document.querySelector('.fisrtList')
    main_sectionList(v,sectionList);
})  
img.slice(1,7)?.map((v)=>{
    const sectionList  = document.querySelector('.secondList')
    main_sectionList(v,sectionList);
})  
img.slice(2,8)?.map((v)=>{
    const sectionList  = document.querySelector('.thirdList')
    main_sectionList(v,sectionList);
})  
img.slice(0,6).map((v)=>{
    const sectionList  = document.querySelector('.fourList')
    main_sectionList(v,sectionList);
    
})  

//일러스트 슬라이드
function Illustrator(){
    const lisls = document.querySelectorAll('#fourList div.x_item')
    const lisl = document.querySelector('#fourList')
    const lastli = lisl.lastElementChild.cloneNode(true);
    
    
    //요소복사
    const clone = () =>{
        let cloneslie = lisl.cloneNode(true)
        lisl.append(cloneslie)
    }
    
    
    //요소복사
    clone();
    //슬라이드 실행
    movemove()

//슬라이드 실행
function movemove(){
 lisl.animate([
 { transform: 'translatex(-50.5%)' }
  ],
   {
    duration: 20000,
    iterations: Infinity
   }
     )}}