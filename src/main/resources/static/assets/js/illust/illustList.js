let slides = document.querySelector('.slides'),
    slide = document.querySelectorAll('.slides li'),
    currentIdx= 0,
    slideCount = slide.length,


    slideWidth =200,
    slideMargin = 2;

if (window.matchMedia('(max-width: 400px)').matches) {

    slideMargin=5;
    slideWidth=81.5;
}
let  prevBtn = document.querySelector('.prev'),
    nextBtn = document.querySelector('.next');

makeClone();

console.log(slideWidth);

function makeClone() {
    for (let i=0; i<slideCount; i++){
        let cloneSlide = slide[i].cloneNode(true);
        slides.appendChild(cloneSlide);
    }
    for(let i=slideCount-1; i>=0; i--){
        let cloneSlide = slide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        slides.prepend(cloneSlide);
    }
    updateWidth();
    setInitialPos();
    setTimeout(function () {
        slides.classList.add('animated');
    }, 100);

}

function updateWidth() {
    let currentSlides = document.querySelectorAll('.slides li');
    let newSlideCount = currentSlides.length;
    let newWidth= (slideWidth+slideMargin)*newSlideCount - slideMargin+'px';
    slides.style.width = newWidth;
}
function setInitialPos() {
    let initialTranslateValue = -(slideWidth+slideMargin)*slideCount;
    slides.style.transform='translateX('+initialTranslateValue+'px)';


}

nextBtn.addEventListener('click', function () {
    moveSlide(currentIdx+1);
})
prevBtn.addEventListener('click',function () {
    moveSlide(currentIdx-1);
})

function moveSlide(num) {
    slides.style.left = -num * (slideWidth+slideMargin)+'px';
    currentIdx = num;
    // console.log(currentIdx, slideCount);
    if(currentIdx==slideCount || currentIdx== -slideCount){

        setTimeout(function () {
            slides.classList.remove('animated');
            slides.style.left='0px';
            currentIdx=0;
        },500);
        setTimeout(function () {
            slides.classList.add('animated');
        },600)
    }
}

let timer =undefined;

function autoSlide() {
    if(timer ==undefined){
        timer = setInterval(function () {
            moveSlide(currentIdx+1);
        },2000)
    }
}

autoSlide();

function stopSlide() {
    clearInterval(timer);

    timer =undefined;
    // console.log(timer);
}

slides.addEventListener('mouseenter',function () {
    stopSlide();
})
slides.addEventListener('mouseleave',function () {
    autoSlide();
})



/* 화살표 함수 */
const label = document.querySelector('.label');
const options = document.querySelectorAll('.optionItem');

// 클릭한 옵션의 텍스트를 라벨 안에 넣음
const handleSelect = (item) => {
    label.parentNode.classList.remove('active');
    label.innerHTML = item.textContent;
}
// 옵션 클릭시 클릭한 옵션을 넘김
options.forEach(option => {
    option.addEventListener('click', () => handleSelect(option))
})

// 라벨을 클릭시 옵션 목록이 열림/닫힘
label.addEventListener('click', () => {
    if(label.parentNode.classList.contains('active')) {
        label.parentNode.classList.remove('active');
    } else {
        label.parentNode.classList.add('active');
    }
})