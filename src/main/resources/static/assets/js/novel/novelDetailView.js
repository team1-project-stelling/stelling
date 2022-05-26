
textareaauto();


function textareaauto() {
    console.log("텍스트조절");
    $('textarea').each(function () {
        this.setAttribute('style', 'height:' + (this.scrollHeight) + 'px;overflow-y:hidden;');
    }).on('input', function () {
        this.style.height = 'fit-content';
        this.style.height = (this.scrollHeight) + 'px';
    });
}

//소설 텍스트 커스텀마이징
$('.colorDiv').on("click", function () {
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

/*폰트 크기 조절*/
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

/*줄간격 조절*/
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

/*글꼴선택*/
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

/*텍스트 모달*/
$('.textimg').on("click", function () {
    if ($('.textModal').css('display') == 'none') {
        $('.textModal').css('display', 'block');
    } else {
        $('.textModal').css('display', 'none');
    }
})


/*목록 사이드바*/
$(".listIcon").click(function () {
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
        $('.topheart').attr('src', '/images/icon/소설하트full.png');
        subNovelLikeCount({"subNovelNumber":subNovelNumber, "num":1}, function (likeCount) {
            $('.showLikeNum').html(likeCount);
        })
    } else {
        subNovelLikeCount({"subNovelNumber":subNovelNumber, "num":-1}, function (likeCount) {
            $('.showLikeNum').html(likeCount);
            $('.topheart').attr('src', "/images/icon/소설하트.png");
        })
    }
})

$('.topbell').on("click", function () {
    if ($(this).attr('src') == '/images/icon/후원코인.png') {
        $(this).attr('src', '/images/icon/후원코인full.png');
    } else {
        $(this).attr('src', '/images/icon/후원코인.png');
    }
})


/*댓글 아이콘 클릭시 댓글 쪽으로 스크롤 내리기*/
$('.mentIcon').on('click', function () {
    var location = document.querySelector(".ments").offsetTop;
    window.scrollTo({top:location, behavior:'smooth'});
})

$('.switch_label').select(function () {
    $('.ments').css('display', 'none');
})

/*댓글 숨기기*/
$('#switch').on('click', function () {
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




/*소설 회차 좋아요기능*/
function subNovelLikeCount(numbers, callback, error){
    $.ajax({
        type: "GET",
        url: "/novelDetail/"+numbers.subNovelNumber+"/"+ numbers.num,
        success: function(result){
            if(callback){
                callback(result);
            }
        },
        error: function(xhr, status, er){
            if(error){
            }
        }

    });
}


/*후원 버튼 모달*/
$('.coin').on("click", function () {
    console.log("눌림")
    $('.modal_background').css('display', 'block');
})

$(document).mouseup(function (e){
    $('.coin').attr('src', '/images/icon/후원코인.png');
    let container = $('.modal_background');
    if( container.has(e.target).length === 0){
        container.css('display','none');
    }
});


