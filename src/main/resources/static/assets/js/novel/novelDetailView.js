textareaauto();

function textareaauto() {
    $('textarea').each(function () {
        this.setAttribute('style', 'height:' + (this.scrollHeight) + 'px;overflow-y:hidden;');
    }).on('input', function () {
        this.style.height = 'fit-content';
        this.style.height = (this.scrollHeight) + 'px';
    });
}

$('.colorDiv').on("click", function () {
    console.log($(this));
    console.log($(this).hasClass());
    if ($(this).hasClass('cd1')) {
        $('body').css('background-color', 'white');
        $('.novelContent').css('background-color', 'white');
        $('.whiteLine').css('background-color', 'white');
        $('.ments').css('color', 'black');
        $('.writerMent').css('color', 'black');
    } else if ($(this).hasClass('cd2')) {
        $('body').css('background-color', 'wheat');
        $('.novelContent').css('background-color', 'wheat');
        $('.whiteLine').css('background-color', 'wheat');
        $('.ments').css('color', 'black');
        $('.writerMent').css('color', 'black');
    } else if ($(this).hasClass('cd3')) {
        $('body').css('background-color', 'rgb(61,61,61)');
        $('.novelContent').css('background-color', 'rgb(61,61,61)');
        $('.whiteLine').css('background-color', 'rgb(61,61,61)');
        $('.ments').css('color', 'white');
        $('.writerMent').css('color', 'white');

    } else if ($(this).hasClass('cd4')) {
        $('.novelContent').css('color', 'white');
        $('.ments').css('color', 'white');
        $('.writerMent').css('color', 'white');
    } else if ($(this).hasClass('cd5')) {
        $('.novelContent').css('color', 'rgb(6 192 0)');
        $('.ments').css('color', 'rgb(6 192 0)');
        $('.writerMent').css('color', 'rgb(6 192 0)');
    } else if ($(this).hasClass('cd6')) {
        $('.novelContent').css('color', '#ef6e73');
        $('.ments').css('color', '#ef6e73');
        $('.writerMent').css('color', '#ef6e73');
    } else if ($(this).hasClass('cd7')) {
        $('.novelContent').css('color', 'rgb(61,61,61)');
        $('.ments').css('color', 'rgb(61,61,61)');
        $('.writerMent').css('color', 'rgb(61,61,61)');
    }



});

let count = 0;
let count2 = 0;
let fontSize = parseInt($('.novelContent').css('font-size').replace('px', ''));
let lineHeight = parseInt($('.novelContent').css('line-height').replace('px', ''));

$('.pmIcon').on("click", function () {

    console.log(fontSize);

    if ($(this).hasClass('p')) {

        fontSize += 1;
        $('.novelContent').css('font-size', fontSize);
        count += 1;
        $('.count1').html(count);
    } else if ($(this).hasClass('m')) {

        fontSize -= 1;
        $('.novelContent').css('font-size', fontSize);
        count -= 1;
        $('.count1').html(count);
    }

});

$('.line').on("click", function () {
    console.log(lineHeight)
    if ($(this).hasClass('p')) {
        lineHeight += 1;
        $('.novelContent').css('line-height', lineHeight + 'px');
        count2 += 1;
        $('.count2').html(count2);
    } else if ($(this).hasClass('m')) {
        lineHeight -= 1;
        $('.novelContent').css('line-height', lineHeight + 'px');
        count2 -= 1;
        $('.count2').html(count2);
    }

})


function selectFunction() {
    let selected = $('.fontSelect option:selected').val();

    if (selected == 'alice') {
        $('.novelContent').css('font-family', 'Elice Digital Baeum');
    } else if (selected == 'dobbie') {
        $('.novelContent').css('font-family', 'NanumHaengBogHanDoBi');
    } else if (selected == 'noto') {
        $('.novelContent').css('font-family', 'Noto Sans KR');
    }

}


$('.textimg').on("click", function () {
    if ($('.textModal').css('display') == 'none') {
        $('.textModal').css('display', 'block');
    } else {
        $('.textModal').css('display', 'none');
    }
})

$('.listIcon').on("click", function () {
    console.log($('.sidebar').css('right'));
    // $('.sidebar').animate({width:'toggle'});

})


$(".listIcon").click(function () {

    // $(this).toggleClass("div-close");

    if ($(this).hasClass('open')) {
        $(".slide-div").animate({right: "-400px"}, 500);
        $(this).removeClass('open');
    } else {
        $(".slide-div").animate({right: "0px"}, 500);
        $(this).addClass('open');
    }
});

$('.topheart').on("click", function () {
    if ($(this).attr('src') == '/images/icon/소설하트.png') {
        $(this).attr('src', '/images/icon/소설하트full.png');
    } else {
        $(this).attr('src', '/images/icon/소설하트.png');
    }
})

$('.topbell').on("click", function () {
    if ($(this).attr('src') == '/images/icon/종알림.png') {
        $(this).attr('src', '/images/icon/종알림full.png');
    } else {
        $(this).attr('src', '/images/icon/종알림.png');
    }
})



$('.mentIcon').on('click', function () {
    // console.log($('.ments').scrollHeight);
    var location = document.querySelector(".ments").offsetTop;
    window.scrollTo({top:location, behavior:'smooth'});
})

$('.switch_label').select(function () {
    $('.ments').css('display', 'none');
})


$('#switch').on('click', function () {
    console.log($('#switch:checked').css('background'));
    if($('#switch:checked').css('background')!=undefined){
        $('.ments').css('display', 'none');
        $('.writerMent').css('margin-bottom', '225px');
    }else{
        $('.ments').css('display', 'block');
        $('.writerMent').css('margin-bottom', '40px');
        var location = document.querySelector(".ments").offsetTop;
        window.scrollTo({top:location, behavior:'smooth'});
    }
});


$('.pink').on("click", function () {
    $('.pink').attr('src', '/images/icon/체크핑크.png');
    $('.gray').attr('src', '/images/icon/체크그레이.png');
})

$('.gray').on("click", function () {
    $('.pink').attr('src', '/images/icon/체크그레이.png');
    $('.gray').attr('src', '/images/icon/체크핑크.png');

})



$('.mentBtns1').on("click", function () {
    console.log($(this).children('img').attr('src'));


    if($(this).children('img').attr('src')=='/images/icon/좋아요full.png'){
        let $number = parseInt($(this).children('span').html());
        $(this).css('border-color','#cbcbcb');
        $(this).css('color','#cbcbcb');
        $(this).children('img').attr('src', '/images/icon/좋아요.png');
        $(this).children('span').html($number -1);

    }else {

        let $number = parseInt($(this).children('span').html());
        $(this).css('border-color', '#5A94FF');
        $(this).css('color', '#5A94FF');
        $(this).children('img').attr('src', '/images/icon/좋아요full.png');
        $(this).children('span').html($number + 1);

    }
});

