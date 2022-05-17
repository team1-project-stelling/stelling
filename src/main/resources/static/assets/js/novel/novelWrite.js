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
                // console.log(result);
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


$('.enter').on("click",function () {
    console.log("전송버튼눌림");
    let novelFile = new FormData();

    console.log($('textarea[name="novelContent"]').val());
    novelFile.method='POST';
    novelFile.action='/novel/novelWriter';
    novelFile.append("content", $('textarea[name="novelContent"]').val());
    novelFile.append("subNovelTitle",$('input[name="subNovelTitle"]').val());
    novelFile.append("novelNumber",109);
    novelFile.append("userNumber",1);
    novelFile.append("subNovelWriterComment",$("#subNovelWriterComment").val());
    $.ajax({
        type: "POST",
        url: "/novel/makeNovelFile",
        data:novelFile,
        processData: false,
        contentType: false,
        success: function(result, status, xhr){
         console.log(result);

        },
        error: function(xhr, status, er){
            if(er){
                console.log(er);
            }
        }
    });
})
