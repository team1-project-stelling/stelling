function getSubNovelList(novelNumber, callback, error) {

    $.ajax({
        url : "/novel/getSubNovelList?novelNumber="+novelNumber,
        // dataType: "json",
        type: "GET",
        // async: false,
        success: function(result) {
            callback(result);
        },
        error: function (){alert("실패");}
    });


}

function getNovelVo(novelNumber, callback, error) {

    $.ajax({
        url : "/novel/getNovelVO/"+novelNumber,
        type: "GET",
        success: function(result) {
            callback(result);
        },
        error: function (){
            if(error){
                console.log(error);
            }
            alert("실패");}
    });
}


function getOrderBySubNovelList(novelNumber, callback, error){
    $.ajax({
             url : "/novel/orderBySubNovelList?novelNumber="+novelNumber,
             type: "get",
             success: function(result) {
                callback(result);

             },
               error: function () {
                   if (error) {
                       alert("실패");
                   }
               }
           });
}



 // function ResCnt() {
 //
 //    let result= [];
 //    $.ajax({
 //      url : "/dummy/Res.json",
 //
 //      dataType: "json",
 //      type: "get",
 //      async: false,
 //      success: function(data) {
 //         result= data
 //
 //      },
 //        error: function (){alert("실패");}
 //    });
 //    return result;
 //
 // }


//
//  function write() {
//
//    let result= [];
//    $.ajax({
//      url : "/support/getSupportList",
//      dataType: "json",
//      type: "get",
//      async: false,
//      success: function(data) {
//         result= data
//
//      },
//        error: function (){alert("실패");}
//    });
//    return result;
//
// }
function getReply(novelNumber, callback , error) {
 
   $.ajax({
     url : "/reply/getReplyLists/latest?novelNumber="+novelNumber,
     type: "get",
     success: function(replyDTO) {
        callback(replyDTO.replyVOList, replyDTO.userVOList);
        console.log(replyDTO.replyVOList);
      
     },
       error: function (){alert("실패");}
   });

}

function setStringNumber(count) {
    if(count >= 1000 && count < 10000){ //1k
        return (count / 1000) + "." + Math.round(count%1000/100) + "K";
    }
    else if(count >= 10000 && count < 100000){ //10k
        return (count / 1000) + "." + Math.round(count%1000/100) + "K";
    }
    else if(count >= 100000 && count < 1000000){ //100k
        return (count / 1000) + "." + Math.round(count%1000/100) + "K";
    }
    else if(count >= 1000000 && count < 10000000){ //1M
        return (count / 1000000) + "." + Math.round(count%1000000/100000) + "M";
    }
    else if(count >= 10000000 && count < 100000000){ //10M
        return (count / 1000000) + "." + Math.round(count%1000000/100000) + "M";
    }
    else if(count >= 100000000 && count < 1000000000){ //100M
        return (count / 1000000) + "." + Math.round(count%1000000/100000) + "M";
    }
    else if(count >= 1000000000){ //1B
        return (count / 1000000000) + "B";
    }
    return count+"";
}