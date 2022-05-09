let $rutin =$('.rutin');
let $free =$('.free');

$rutin.on("click", function () {
    $rutin.css('background-color', '#ef6273');
    $rutin.css('color', 'white');
    $rutin.css('border', 'none');

    $free.css('background-color', 'white');
    $free.css('color', '#ef6273');
    $free.css('border', '1px solid #ef6273');

    // $('.days').css('display', 'flex');
    $('.days').slideDown();
});


$free.on("click", function () {
    $free.css('background-color', '#ef6273');
    $free.css('color', 'white');
    $free.css('border', 'none');

    $rutin.css('background-color', 'white');
    $rutin.css('color', '#ef6273');
    $rutin.css('border', '1px solid #ef6273');

    // $('.days').css('display', 'none');
    $('.days').slideUp();
});




/* 화살표 함수 */
const label = document.querySelector('.label');
const options = document.querySelectorAll('.optionItem');

// 클릭한 옵션의 텍스트를 라벨 안에 넣음
const handleSelect = (item) => {
    label.parentNode.classList.remove('active');
    label.innerHTML = item.textContent;
}
// 옵션 클릭시 클릭한 옵션을 넘김
options.forEach(option => {
    option.addEventListener('click', () => handleSelect(option))
})

// 라벨을 클릭시 옵션 목록이 열림/닫힘
label.addEventListener('click', () => {
    if(label.parentNode.classList.contains('active')) {
        label.parentNode.classList.remove('active');
    } else {
        label.parentNode.classList.add('active');
    }
})

$(document).ready(function(){
    var fileTarget = $('#file');
    fileTarget.on('change', function(){ // 값이 변경되면
        var cur=$(".filebox input[type='file']").val();
        $(".upload-name").val(cur);
    });
});
$('.imgs').on("click", function () {
    let imgSrc =$(this).attr("src");
    $('.thumnail>img').attr('src',imgSrc);
    $('.thum').val("");
    $('.upload-name').val("");

});

function setThumbnail(event) {
    let reader = new FileReader();
    reader.onload = function(event) {
        let img = document.createElement("img");
        img.setAttribute("src", event.target.result);
        $('.thumnail>img').attr('src', $(img).attr('src'));
        // document.querySelector("div#image_container").appendChild(img);
    };
    reader.readAsDataURL(event.target.files[0]); }






$(document).ready(function () {
    var tag = {};
    var counter = 0;

    // 입력한 값을 태그로 생성한다.
    function addTag (value) {
        tag[counter] = value;
        counter++; // del-btn 의 고유 id 가 된다.
    }

    // tag 안에 있는 값을 array type 으로 만들어서 넘긴다.
    function marginTag () {
        return Object.values(tag).filter(function (word) {
            return word !== "";
        });
    }

    // 서버에 제공
    $("#tag-form").on("submit", function (e) {
        var value = marginTag(); // return array
        $("#rdTag").val(value);

        $(this).submit();
    });

    $("#tag").on("keypress", function (e) {
        var self = $(this);

        //엔터나 스페이스바 눌렀을때 실행
        if (e.key === "Enter" || e.keyCode == 32) {

            var tagValue = self.val(); // 값 가져오기

            // 해시태그 값 없으면 실행X
            if (tagValue !== "") {

                // 같은 태그가 있는지 검사한다. 있다면 해당값이 array 로 return 된다.
                var result = Object.values(tag).filter(function (word) {
                    return word === tagValue;
                })

                // 해시태그가 중복되었는지 확인
                if (result.length == 0) {
                    //태그 6개 제한
                    if(counter>5){
                        alert("태그는 6개까지만 가능합니다.");
                    }else {

                        $("#tag-list").append("<li class='tag-item'>" +tagValue + "<span class='del-btn' idx='" + counter + "'>&nbsp;x</span></li>");
                        addTag(tagValue);
                        self.val("");
                    }
                } else {
                    alert("태그값이 중복됩니다.");
                }


            }
            e.preventDefault(); // SpaceBar 시 빈공간이 생기지 않도록 방지
        }
    });

    // 삭제 버튼
    // 인덱스 검사 후 삭제
    $(document).on("click", ".del-btn", function (e) {
        var index = $(this).attr("idx");
        tag[index] = "";
        $(this).parent().remove();
        counter--;
    });
})