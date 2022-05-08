function search() { 

    let result= [];
    $.ajax({
      url : "https://api.themoviedb.org/3/movie/popular?api_key=84681a7022280cff3021d07fe9117b39&language=ko-KR",
     
      dataType: "json",	
      type: "get",
      async: false,
      success: function(data) {
         result= data.results
      },
        error: function (){alert("실패");}
    });
    return result;

 }




 