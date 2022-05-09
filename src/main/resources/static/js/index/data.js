function search() { 

    let result= [];
    $.ajax({
      url : "https://api.themoviedb.org/3/movie/popular?api_key=84681a7022280cff3021d07fe9117b39&language=ko-KR",
     
      dataType: "json",	
      type: "get",
      async: false,
      success: function(data) {
         result= data.results
         console.log(result)
      },
        error: function (){alert("실패");}
    });
    return result;

 }


 function ResCnt() { 
 
    let result= [];
    $.ajax({
      url : "/dummy/Res.json",
     
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