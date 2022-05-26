function getMyIllustList(userNumber, callback, error) {
    $.ajax({
       url : "/illust/getMyIllustList?userNumber="+userNumber,
       type: "GET",
       success: function (result) {
            callback(result);
       },
       error: function () {
           if (error) {
               alert("실패");
           }
       }
    });
}