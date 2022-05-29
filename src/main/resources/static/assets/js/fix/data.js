function search() {

    let result= "";
    $.ajax({
        url : "/main/bannerImg",

        dataType: "json",
        type: "get",
        async: false,
        success: function(data) {
            result= data
            console.log(result)
        },
        error: function (){alert("실패");}
    });
    return result;

}

 function illustImg() {
 
    let result= "";
    $.ajax({
      url : "/main/illustImg",
     
      dataType: "json",	
      type: "get",
      async: false,
      success: function(data) {
         result= data
          console.log(result)
      },
        error: function (){alert("실패");}
    });
    return result;
 
 }



 function write() { 
 
   let result= [];
   $.ajax({
     url : "/dummy/writeDummy.json",
    
     dataType: "json",	
     type: "get",
     async: false,
     success: function(data) {
        result= data
      
     },
       error: function (){alert("실패");}
   });
   return result;

}
function reply() { 
 
   let result= [];
   $.ajax({
     url : "https://dummyjson.com/comments",
    
     dataType: "json",	
     type: "get",
     async: false,
     success: function(data) {
        result= data.comments
      
     },
       error: function (){alert("실패");}
   });
   return result;

}