let hasTahCk = false;
function hashTag() {
    let $form = $(nav_searchForm);
    if(!hasTahCk) {


        $('#nav_searchForm input ').css( 'textIndent', '26px');
        $('#search_all button.tagBtn').css('transform', 'translateX(-262px)')
        // 태그로검색하기위한 조건 변경
        $form.find("input[name='type']").val('tag');
        hasTahCk = true;
    }else if(hasTahCk){
        $('#nav_searchForm input ').css( 'textIndent', '20px');
        $('#search_all button.tagBtn').css('transform', 'translateX(0)')
        // 전체검색을 위한 조건 변경
        $form.find("input[name='type']").val('all');
        hasTahCk = false;
    }

}

$("form#nav_searchForm").submit(function () {
    if(!$("input[name='keyword']").val()){
        alert("검색어를 입력하세요!")
        return false;
    }
    return true;
})


/*$('.nav_searchForm_btn').on('click',function () {
    alert( $('#search_all').find("input[name='keyword']").val())
})*/
$('.eventMenu').on('click',function () {
    $('div.menuArea').slideToggle(450);
})
$('div.menuArea').hover(function () {
    $('body').on('scroll touchmove mousewheel', function(e) {
        console.log('123')

        e.preventDefault();
        e.stopPropagation();
        return false;
    });
},function () {
    $('body').off('scroll touchmove mousewheel');
})

