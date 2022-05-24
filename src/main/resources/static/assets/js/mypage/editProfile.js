// 썸네일
document.addEventListener('DOMContentLoaded', function(){
    //이미지파일만 보이게 설정
    var validateType = function(img){
        return (['image/jpeg','image/jpg','image/png'].indexOf(img.type) > -1);
    }

    var validateName = function(fname){
        let extensions = ['jpeg','jpg','png'];
        let fparts = fname.split('.');
        let fext = '';

        if(fparts.length > 1){
            fext = fparts[fparts.length-1];
        }

        let validated = false;

        if(fext != ''){
            extensions.forEach(function(ext){
                if(ext == fext){
                    validated = true;
                }
            });
        }
        return validated;
    }

    // 파일 선택 필드에 이벤트 리스너 등록
    document.getElementById('imageSelector').addEventListener('change', function(e){
        let elem = e.target;
        if(validateType(elem.files[0])){
            let preview = document.querySelector('.thumb'); // 미리보기 썸네일 <img> 엘리먼트 얻기
            preview.src = URL.createObjectURL(elem.files[0]); //파일 객체에서 이미지 데이터 가져옴.
            document.querySelector('.thumb').style.width ='110px';
            document.querySelector('.thumb').style.height ='110px';
            document.querySelector('.thumb').style.borderRadius ='10px';

            document.querySelector('.dellink').style.display = 'block'; // 이미지 삭제 링크 표시
            preview.onload = function() {
                URL.revokeObjectURL(preview.src); //URL 객체 해제
            }
        }else{
            console.log('이미지 파일이 아닙니다.');
        }
    });

    document.querySelector('.dellink').addEventListener('click', function(e){
        let dellink = e.target;
        let preview = document.querySelector('.thumb');
        preview.src = ''; // 썸네일 이미지 src 데이터 해제
        document.querySelector('.dellink').style.display = 'none';

        // document.querySelector('.imageSelector').value = '';
        // document.querySelector('.thumb').style.display='none';
        // document.querySelector('.imagePreview1').style.display='block';
        preview.src = '/images/default.png';
    });
});



//left_block 색변경
var active = document.getElementsByClassName("left");

function handleClick(event) {
    console.log(event.target);
    console.log(event.target.classList);

    active[0].classList.remove("clicked");
    if (event.target.classList[1] === "clicked") {
        event.target.classList.remove("clicked");
    } else {
        for (var i = 0; i < active.length; i++) {
            active[i].classList.remove("clicked");
        }

        event.target.classList.add("clicked");
    }
}
function init() {
    active[0].classList.add("clicked");
    for (var i = 0; i < active.length; i++) {
        active[i].addEventListener("click", handleClick);
    }
}
init();

//이메일 유효성검사
function validEmail(obj){
    if(validEmailCheck(obj)==false){
        $('#result_email').text("올바른 이메일 주소를 입력해주세요.");
        $('#result_email').css('color', 'red');
        obj.value='';
        obj.focus();
        return false;
    }else {
        $('#result_email').text("사용가능한 이메일 주소입니다.");
        $('#result_email').css('color', '#19ce60');
    }
}

function validEmailCheck(obj){
    var pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    return (obj.value.match(pattern)!=null)
}


//닉네임 유효성 검사
function validNick(obj){
    if(validNickCheck(obj)==false){
        $('#result_nick').text("2자 이상 10자 이하, 영어 또는 숫자 또는 한글만 사용 가능합니다.");
        $('#result_nick').css('color', 'red');
        obj.value='';
        obj.focus();
        return false;
    }else {
        $('#result_nick').text("사용가능한 닉네임 입니다.");
        $('#result_nick').css('color', '#19ce60');
    }
}

function validNickCheck(obj){
    //- 2자 이상 16자 이하, 영어 또는 숫자 또는 한글로 구성
    //* 특이사항 : 한글 초성 및 모음은 허가하지 않는다.
    var pattern = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,10}$/;
    // 공백 허용x
    var gap = /\s/g;
    return (obj.value.match(pattern || gap)!=null)
}

//휴대폰 유효성 검사
function validPhone(obj){
    if(validPhoneCheck(obj)==false){
        $('#result_phone').text("올바른 휴대폰 번호를 입력해 주세요.");
        $('#result_phone').css('color', 'red');
        obj.value='';
        obj.focus();
        return false;
    }else {
        $('#result_phone').text("사용 가능한 휴대폰 번호 입니다.");
        $('#result_phone').css('color', '#19ce60');
    }
}

function validPhoneCheck(obj){
    // '-' 없는 검사
    var pattern = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
    return (obj.value.match(pattern)!=null)
}

//프로필 이미지 로컬에 저장
$("input[type='file']").change(function(e){
    let inputFile = $("input[type='file']");
    let files = inputFile[0].files;
    let formData = new FormData();

    for(let i = 0; i < files.length; i++){
        formData.append("uploadFile", files[i]);
    }
    $.ajax({
        url: "/myPage/uploadAjaxAction",
        data: formData,
        type: "POST",
        // 현재 설정된 헤더 설정을 기본 방식으로 변경하지 못하도록 false로 설정
        processData: false,
        contentType: false,
        success: function(result){
            console.log(result);
            $(result).each(function (i, item) {
                $('input[name="userFileName"]').val(item.userFileName);
                $('input[name="userFilePath"]').val(item.userFilePath);
                $('input[name="userUuid"]').val(item.userUuid);
                console.log("등록됨");
                console.log($('input[name="userUploadPath"]').val());
            });
        }
    });
});