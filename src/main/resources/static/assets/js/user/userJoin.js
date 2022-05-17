

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


//아이디 가이드 열기
inputbox_1.addEventListener("click", e => {
    e.preventDefault();
    guidebox_1.style.display = "block";
});

inputbox_2.addEventListener("click", e => {
    e.preventDefault();
    guidebox_2.style.display = "block";
});

inputbox_3.addEventListener("click", e => {
    e.preventDefault();
    guidebox_3.style.display = "block";
});


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

//joinForm 유효성 검사
// function joinform_check() {
//     const uid = document.getElementById("userId");
//     const pwd = document.getElementById("userPw");
//     const repwd = document.getElementById("repwd");
//     const uname = document.getElementById("userNickName");
//     const male = document.getElementById("male");
//     const female = document.getElementById("female");
//     const mobile = document.getElementById("userPhoneNum");
//     const email_id = document.getElementById("userEmail");
//     const agree = document.getElementById("agree");
//
//     //유효성검사
//     const nickCheck = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$/;
//
//     const hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
//
//
//     //아이디 유효성
//     const idCheck = /^(?=.*[a-z0-9])[a-z0-9]{2,10}$/;
//     //
//     // if(!idCheck.test(uid.value)){
//     //     alert("아이디는 2-16글자 사이까지 입력 가능합니다.");
//     //     uid.focus();
//     //     return false;
//     // };
//
//     //닉네임 유효성
//
//     // const nickCheck = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,10}$/;
//
//     if (!nickCheck.test(uname.value)) {
//         alert("닉네임은 2자 - 10자 사이로 입력해주세요.")
//     };
//
//
//     //아이디 입력 유무
//     if (uid.value == "") {
//         alert("아이디를 입력해주세요.")
//         uid.focus();
//         return false;
//     };
//
//     //비밀번호 입력 유무
//     if (pwd.value == "") {
//         alert("비밀번호를 입력해주세요.")
//         return false;
//     };
//
//     //비밀번호 영문자 + 숫자 + 특수조합 (8~16자리 입력) 정규식
//     const pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
//
//     if (!pwdCheck.test(pwd.value)) {
//         alert("비밀번호는 영문자+숫자+특수문자가 포함된 8~16자리를 사용해주세요.");
//         pwd.focus();
//         return false;
//     };
//
//     //비밀번호 재확인
//     if (repwd.value !== pwd.value) {
//         alert("비밀번호가 일치하지 않습니다.");
//         repwd.focus();
//         return false;
//     };
//
//     //이름(닉네임) 입력 유무
//     if (uname.value == "") {
//         alert("이름을 입력해주세요.");
//         uname.focus();
//         return false;
//     };
//
//     // //성별 선택 유무
//     // //둘다 미체크시
//     // if (!female.checked && !male.checked) {
//     //     alert("성별을 선택해 주세요.");
//     //     female.focus();
//     //     return false;
//     // };
//
//
//     //숫자만 입력하는 정규식 (휴대폰번호 입력에 사용)
//     const reg = /^[0-9]+/g;
//     if (!reg.test(mobile.value)) {
//         alert("휴대폰번호는 숫자만 입력할 수 있습니다");
//         mobile.focus();
//         return false;
//     };
//
//
//     //약관동의 체크 유무
//     if (email_id.value == "") {
//         alert("이메일 주소를 입력해주세요.");
//         email_id.focus();
//         return false;
//     };
//
//
//     //약관동의 체크 유무
//     //체크박스 미체크시
//     if (agree.checked) {
//         alert("약관 동의를 체크해주세요.");
//         agree.focus();
//         return false;
//     };
//
//     document.joinForm.submit();
// };


//중복확인 버튼
function id_check() {
    const uid = document.getElementById("uid");

    if (uid.value == "") {
        alert("아이디를 입력해주세요");
    } else if (uid.value !== "leejihun") {
        alert("사용가능한 아이디입니다.");
    }else {
        alert("사용할 수 없거나 중복된 아이디 입니다.")
    }
};


//이메일 버튼
function email_check() {
    const email_id = document.getElementById("email_id");
    if (email_id.value =="") {
        alert("이메일을 입력해주세요.");
    }else if ( email_id.value !== "stelling@naver.com") {
        alert("사용가능한 이메일입니다.");
    }
    else {
        alert("이미 사용중인 이메일입니다.");
    }
};

function CV_checkIdPattern(str){

    const guidebox_1 = document.querySelector('.text_guide_1');
    const guidebox_2 = document.querySelector('.text_guide_2');
    const guidebox_3 = document.querySelector('.text_guide_3');
    const inputbox_1 = document.querySelector('#uid');
    const inputbox_2 = document.querySelector('#pwd');
    const inputbox_3 = document.querySelector('#repwd');
    const pattern1 = /[0-9]/; // 숫자
    const pattern2 = /[a-zA-Z]/; // 문자
    const pattern3 = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자

    const numtextyn = (pattern1.test(str) || pattern2.test(str));
    if(!numtextyn || pattern3.test(str) || str.length > 14) {
        guidebox_1.style.color = "green";
    } else {
        return true;
    }
}