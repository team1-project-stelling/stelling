$('.arrow').on('click', function () {

    if($('.arrow>img').attr('src') === '/images/icon/화살표.png'){
        $('.arrow>img').attr('src', '/images/icon/위화살표.png')
        $('.delete').css('display', 'inline-block');
    }else{
        $('.delete').css('display', 'none');
        $('.arrow>img').attr('src', '/images/icon/화살표.png');
    }

})
$('.chatBtn').on('click',function () {
    $('.chat').slideToggle();

})

$('.x').on('click', function () {
    $('.chat').slideToggle();
});


