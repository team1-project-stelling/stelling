/*댓글 등록*/



$('.send').on("click", function () {
    let replyContent=$('textarea[name="replyContent"]').val();

    add({"novelNumber": novelNumber, "subNovelNumber": subNovelNumber,"replyContent": replyContent, "userNumber":userNumber},
        function (result) {
            console.log(result);
        })
})


function add(reply, callback, error) {
    console.log("reply add 실행")
    $.ajax({
        type: "POST",
        url: "/reply/add",
        data: JSON.stringify(reply),
        contentType: "application/json; charset=utf-8",
        success: function(result, status, xhr){
            if(callback){
                callback(result);
            }
        },
        error: function(xhr, status, er){
            if(error){
                error(er);
            }
        }
    });
}