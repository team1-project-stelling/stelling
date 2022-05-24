/*소설작성 용량*/
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
}

function showfile(){
    $('.filebox').css('display', 'block');
}

/*소설 파일 불러오기*/
$("input[name='file']").on('change',function(){
    let file = $("#file")[0].files;
    let regex = new RegExp("(.*?)\.(txt|hwp)$");

    if(regex.test(file[0].name)){

        var fileName = $("#file").val();
        $(".upload-name").val(fileName);
        let formData = new FormData()
        console.log($("input[type='file']")[0].files[0])
        formData.enctype="multipart/form-data";
        formData.method='POST';
        formData.action='/novel/novelFileUpload';
        formData.append("file", $("input[name='file']")[0].files[0]);

        $.ajax({
            type: "POST",
            url: "/novel/novelFileUpload",
            processData: false,
            contentType: false,
            data: formData,
            success: function(result, status, xhr){
                $('.novelContent').val(result)
                calc_length();
            },
            error: function(xhr, status, er){
                if(er){
                    console.log(er);
                }
            }
        });

    }else{
        alert("업로드 할 수 없는 형식의 파일입니다.");
    }

});

/*임시저장 버튼 클릭시 세션에 값 저장*/
$('.temporarySave').on("click", function () {
    alert("임시저장되었습니다.");
    sessionStorage.setItem("content",$('textarea[name="novelContent"]').val());
    sessionStorage.setItem("subNovelWriterComment",$('textarea[name="subNovelWriterComment"]').val());
    sessionStorage.setItem("subNovelTitle",$('input[name="subNovelTitle"]').val());
})

/*세션 값 불러오기*/
getSession();

/*세션 값 불러오기*/
function getSession(){
    if(sessionStorage.getItem("content")){
        $('textarea[name="novelContent"]').val(sessionStorage.getItem("content"))
    }
    if(sessionStorage.getItem("subNovelWriterComment")){
        $('textarea[name="subNovelWriterComment"]').val(sessionStorage.getItem("subNovelWriterComment"));
    }
    if(sessionStorage.getItem("subNovelTitle")){
        $('input[name="subNovelTitle"]').val(sessionStorage.getItem("subNovelTitle"));
    }

}

$('.enter').on("click",function () {
    sessionStorage.clear();
    $('input[name="content"]').val($('textarea[name="novelContent"]').val());
    $('input[name="subNovelTitle"]').val($('input[name="subNovelTitle"]').val());
    $('input[name="novelNumber"]').val(novelNumber);
    $('input[name="userNumber"]').val(userNumber);
    $('input[name="subNovelWriterComment"]').val($("#subNovelWriterComment").val());

    $(novelWriteForm).submit();

})

$('.modifyEnter').on("click", function () {
    sessionStorage.clear();
    $('input[name="content"]').val($('textarea[name="modify_novelContent"]').val());
    $('input[name="subNovelTitle"]').val($('input[name="modify_sTitle"]').val());
    $('input[name="novelNumber"]').val(novelNumber);
    $('input[name="userNumber"]').val(userNumber);
    $('input[name="subNovelWriterComment"]').val($("textarea[name='modify_writerComment']").val());

    $(novelModifyForm).submit();

})

