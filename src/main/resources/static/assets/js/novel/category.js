
$("form#searchForm").submit(function () {
    if(!$('input#searchFormInput').val()){

        alert('검색할 태그를 입력하세요!')
        return false;
    }
    return true;
})


let $categoryMenuItem = $('.categoryMenuItem')
// 시작은 전체페이지 조회
// 추후에 컨트롤러 연동으로 변경 현재 프론트 작업을 위한 임시 소스
/* 임시 소스 시작 */
// changeBorder($($categoryMenuItem[0]).text())
// $($categoryMenuItem[0]).css('border','2px solid #ef6e73')
// $($categoryMenuItem[0]).css('border-bottom','none')
// $($categoryMenuItem[0]).css('border-bottom','2px solid #ef6e73')
/* 임시 소스 종료 */


function changeMenuItem (novelStatus) {
    categoryMenuReset()
    $($categoryMenuItem[novelStatus]).css('border-bottom','none')
    $($categoryMenuItem[novelStatus]).css('border-bottom','2px solid #ef6e73')
}

/*$('.categoryMenuItem').on('click',function () {
    categoryMenuReset()
    // $(this).css('border','2px solid #ef6e73')
    $(this).css('border-bottom','none')
    $(this).css('border-bottom','2px solid #ef6e73')
    // $(this).css('border-bottom','none')
    // console.log($categoryMenuItem)
    // changeBorder($(this).text())

})*/
function categoryMenuReset() {
    $.each($categoryMenuItem, function (index, item) {
        $(item).css('border','none')
        // $(item).css('border','1px solid  #ef6e73 ')
    });
}


function changeBorder(text) {
    if(text == '전체'){
        $($categoryMenuItem[1]).css('border-bottom','2px solid #ef6e73')
        $($categoryMenuItem[2]).css('border-bottom','2px solid #ef6e73')
    }else if(text == '신작'){
        $($categoryMenuItem[0]).css('border-bottom','2px solid #ef6e73')
        $($categoryMenuItem[2]).css('border-bottom','2px solid #ef6e73')
    }else if(text== '완결'){
        $($categoryMenuItem[0]).css('border-bottom','2px solid #ef6e73')
        $($categoryMenuItem[1]).css('border-bottom','2px solid #ef6e73')
    }
}

/*$('div.OptionChange').on('click',function () {
    ResetOptionChange()
    $(this).find('img').attr('src', '/images/category/checkIcon.png' )
})*/

function ResetOptionChange() {
    $.each($('div.OptionChange'),function (index,item) {
        $(item).find('img').attr('src', '/images/category/optionPointIcon.png');
    })
}
$('#tagSearchList li').on('click',function () {
    resetTagSearchList();
    $(this).addClass('active')
})
function resetTagSearchList() {
    $.each($('#tagSearchList li'),function (index, item) {
        $(item).removeClass('active')
    })
}


function changeTagSearch(){
    $('#tagSearchList').toggle()
    $('#searchFormWrap').toggle()
}



