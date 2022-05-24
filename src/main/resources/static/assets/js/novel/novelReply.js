
showList(subNovelNumber);
/*댓글 등록*/
$('.send').on("click", function () {
    let replyContent=$('textarea[name="replyContent"]').val();

    add({"novelNumber": novelNumber, "subNovelNumber": subNovelNumber,"replyContent": replyContent, "userNumber":userNumber},
        function (result) {
            console.log(result);
            showList(subNovelNumber);
        })
    $('textarea[name="replyContent"]').val("");

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


function showList(subNovelNumber){
    getList(subNovelNumber, function(replyVO, userVO ){

        let str = "";
        let replyArea = $('.replyWrap');

        if(replyVO == null || replyVO.length == 0){
            replyArea.html("<p>등록된 댓글이 없습니다.</p>");
            return;
        }
            for (let i=0; i<replyVO.length; i++){
            let replyUploadDate =replyVO[i].replyUploadDate+"";
            str +="<div class='profilePlusText' style='position: relative;'>";
            str +="<div class='Best'>Best</div>";
            str +="<div><!--프사, 아이디-->";
            str +="<div class='profile'><img src='"+userVO[i].userFilePath+"'class='img'/></div>";
            str +="</div>";
            str +="<div style='width: 678px;'>";
            str +="<div style='font-size: 12px;'>"+ userVO[i].userNickName +"</div>";
            str +="<div>"+replyVO[i].replyContent+"</div>";
            str +="</div>";
            str +="<div>";
            str +="<div style='text-align: right; display: flex;'>";
            str +="<button class='mentBtns mentBtns1' style='margin-right: 6px; border-color:#cbcbcb; color:#cbcbcb;' data-replynum ='"+replyVO[i].replyNumber+"' type='button'>";
            str +="<img src='/images/icon/좋아요.png' height='20' width='20' class='likeBtn'/>";
            str +="<span style='vertical-align: super;'>"+replyVO[i].replyUp+"</span>";
            str +="</button>";
            str +="<button class='mentBtns siren' id='"+replyVO[i].replyNumber+"' style='border-color: #ef6e73;'><img src='/images/icon/사이렌full.png' height='20' width='20'/></button>";
            str +="</div>";
            str +="<div class='date'>";
            str +=replyUploadDate.substring(0,10);
            str +="</div>";
            str +="</div>";
            str +="</div>";
        };


        replyArea.html(str);



    });
}

function getList(subNovelNumber, callback, error) {
    console.log(subNovelNumber);
    $.ajax({
        type: "GET",
        url: "/reply/list/" + subNovelNumber,
        success: function(replyDTO) {
            callback(replyDTO.replyVOList, replyDTO.userVOList);
        },
        error: function(xhr, status, er){
            if(error){
                error(er);
            }
        }
    });

}