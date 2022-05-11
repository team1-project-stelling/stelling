function calc_length()
{
    let doc1 =$('.text').val();
    let rohn1 = doc1.length / 1024
    let rohn2 = rohn1 * 1000
    let rohn3 = parseInt(rohn2)
    let kb   = rohn3 /1000
    $('.box').html(kb);
    $('.box2').html(50);

    if(kb>50.000){
        alert("최대 50KB까지만 입력 가능합니다");
    }
}
function modal_close() {
    $('.modal').css('display', 'none');
    console.log($(this).classList);

}
function showfile(){
    $('.filebox').css('display', 'block');
}

$("#file").on('change',function(){
    var fileName = $("#file").val();
    $(".upload-name").val(fileName);
});
