

//모달
//이용약관 동의 -> 약관보기 모달
const check = false;
const modal = document.querySelector('.modal');
const btnOpenPopup1 = document.querySelector('.btn-open-popup1');
const btnOpenPopup2 = document.querySelector('.btn-open-popup2');
const closeBtn = modal.querySelector(".btn_close");
const closeOk = modal.querySelector(".btn_ok");

btnOpenPopup1.addEventListener('click', (e) => {
    e.preventDefault();
    modal.style.display = 'block';
});
btnOpenPopup2.addEventListener('click', (e) => {
    e.preventDefault();
    modal.style.display = 'block';
});


//모달창 닫기 (닫기 버튼)
closeBtn.addEventListener("click", e => {
    e.preventDefault();
    modal.style.display = "none";
});

//모달창 닫기 (확인 버튼)
closeOk.addEventListener("click", e => {
    e.preventDefault();
    modal.style.display = "none";
});

//모달 바깥 영역 클릭 -> 닫기
modal.addEventListener("click", e => {
    const evTarget = e.target;
    if(evTarget.classList.contains("modal")) {
        modal.style.display = "none";
    };
});

const guidebox_1 = document.querySelector('.text_guide_1');
const guidebox_2 = document.querySelector('.text_guide_2');
const guidebox_3 = document.querySelector('.text_guide_3');
const inputbox_1 = document.querySelector('#userId');
const inputbox_2 = document.querySelector('#userPw');
const inputbox_3 = document.querySelector('#repwd');


// //아이디 가이드 열기
// inputbox_1.addEventListener("click", e => {
//     e.preventDefault();
//     guidebox_1.style.display = "block";
// });
//
// inputbox_2.addEventListener("click", e => {
//     e.preventDefault();
//     guidebox_2.style.display = "block";
// });
//
// inputbox_3.addEventListener("click", e => {
//     e.preventDefault();
//     guidebox_3.style.display = "block";
// });


//휴대폰 인증 펼치기
const phonecheck = document.querySelector('.phone_input');
const phoneBtn = document.querySelector('#phoneBtn');

phoneBtn.addEventListener("click", e => {
    e.preventDefault();
    phonecheck.style.display = "contents";
});



// 이용 약관 체크
window.onload = function(){
    let checkWrap = document.getElementById('checkWrap'),
        check = checkWrap.getElementsByTagName('input');
    checkWrap.addEventListener('click', function(e){
        let target = e.target,
            checkNum = 0;
        if(target === check[0]){
            if(target.checked){
                for(let i = 1;i < check.length;i++){
                    check[i].checked = true;
                };
            }else{
                for(let i = 1;i < check.length;i++){
                    check[i].checked = false;
                };
            };
        }else{
            for(let i = 1;i < check.length;i++){
                if(check[i].checked){
                    checkNum++;
                };
            };
            if(checkNum >= check.length - 1){
                check[0].checked = true;
            }else{
                check[0].checked = false;
            };
        };
    });
};









// document.querySelector("input[name='']").addEventListener("blur", function () {
//     const check = false;
//
// })

// joinForm 유효성 검사
function joinform_check() {
    const uid = document.getElementById("userId");
    const pwd = document.getElementById("userPw");
    const repwd = document.getElementById("repwd");
    const uname = document.getElementById("userNickName");
    const male = document.getElementById("male");
    const female = document.getElementById("female");
    const mobile = document.getElementById("userPhoneNum");
    const email_id = document.getElementById("userEmail");
    const agree = document.getElementById("agree");

    if (uid.value == "") { //해당 입력값이 없을 경우 같은말: if(!uid.value)
        alert("아이디를 입력하세요.");
        uid.focus(); //focus(): 커서가 깜빡이는 현상, blur(): 커서가 사라지는 현상
        return false; //return: 반환하다 return false:  아무것도 반환하지 말아라 아래 코드부터 아무것도 진행하지 말것
    };

    if (pwd.value == "") {
        alert("비밀번호를 입력하세요.");
        pwd.focus();
        return false;
    };

    //비밀번호 영문자+숫자+특수조합(8~25자리 입력) 정규식
    const pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;

    if (!pwdCheck.test(pwd.value)) {
        alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
        pwd.focus();
        return false;
    };

    if (repwd.value !== pwd.value) {
        alert("비밀번호가 일치하지 않습니다..");
        repwd.focus();
        return false;
    };

    if (uname.value == "") {
        alert("이름을 입력하세요.");
        uname.focus();
        return false;
    };
    //
    // if (!female.checked && !male.checked) { //둘다 미체크시
    //     alert("성별을 선택해 주세요.");
    //     female.focus();
    //     return false;
    // }

    const reg = /^[0-9]+/g; //숫자만 입력하는 정규식

    if (!reg.test(mobile.value)) {
        alert("전화번호는 숫자만 입력할 수 있습니다.");
        mobile.focus();
        return false;
    }

    if (email_id.value == "") {
        alert("이메일 주소를 입력하세요.");
        email_id.focus();
        return false;
    }

    // if (!agree.checked) { //체크박스 미체크시
    //     alert("약관 동의를 체크하세요.");
    //     agree.focus();
    //     return false;
    // }

    //입력 값 전송
    document.joinForm.submit(); //유효성 검사의 포인트
}
