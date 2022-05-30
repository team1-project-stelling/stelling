const modal = document.querySelector('.modal');
const btnOpenPopup1 = document.querySelector('.btn-open-popup1');
const btnOpenPopup2 = document.querySelector('.btn-open-popup2');
const closeBtn = modal.querySelector(".btn_close");
const closeOk = modal.querySelector(".btn_ok");

btnOpenPopup1.addEventListener('click', (e) => {
    e.preventDefault();
    modal.style.display = 'block';
    $('body').css("overflow", "hidden");
});
btnOpenPopup2.addEventListener('click', (e) => {
    e.preventDefault();
    modal.style.display = 'block';
    $('body').css("overflow", "hidden");
});

closeBtn.addEventListener("click", e => {
    e.preventDefault();
    modal.style.display = "none";
    $('body').css("overflow", "scroll");
});

closeOk.addEventListener("click", e => {
    e.preventDefault();
    modal.style.display = "none";
    $('body').css("overflow", "scroll");
});

modal.addEventListener("click", e => {
    const evTarget = e.target;
    if(evTarget.classList.contains("modal")) {
        modal.style.display = "none";
        $('body').css("overflow", "scroll");
    };
});

const guidebox_1 = document.querySelector('.text_guide_1');
const guidebox_2 = document.querySelector('.text_guide_2');
const guidebox_3 = document.querySelector('.text_guide_3');
const guidebox_4 = document.querySelector('.text_guide_4');
const inputbox_1 = document.querySelector('#userId');
const inputbox_2 = document.querySelector('#userPw');
const inputbox_3 = document.querySelector('#repwd');
const inputbox_4 = document.querySelector('#userEmail');

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

inputbox_4.addEventListener("click", e => {
    e.preventDefault();
    guidebox_4.style.display = "block";
});

const phonecheck = document.querySelector('.phone_input');
const phoneBtn = document.querySelector('#phoneBtn');

phoneBtn.addEventListener("click", e => {
    e.preventDefault();
    phonecheck.style.display = "contents";
});

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

function joinform_check() {
    let check = true;
    const uid = document.getElementById("userId");
    const pwd = document.getElementById("userPw");
    const repwd = document.getElementById("repwd");
    const uname = document.getElementById("userNickName");
    const mobile = document.getElementById("userPhoneNum");
    const email_id = document.getElementById("userEmail");

    if (uid.value == "") {
        Swal.fire({
            icon: 'warning',
            text: '아이디를 확인해주세요.'
        });
        uid.focus();
        return false;
    }

    if (pwd.value == "") {
        Swal.fire({
            icon: 'warning',
            text: '비밀번호를 확인해주세요.'
        });
        pwd.focus();
        return false;
    }

    const pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;
    if (!pwdCheck.test(pwd.value)) {
        Swal.fire({
            icon: 'warning',
            text: '비밀번호를 확인해주세요.'
        });
        pwd.focus();
        return false;
    }

    if (repwd.value !== pwd.value) {
        Swal.fire({
            icon: 'warning',
            text: '비밀번호가 일치하지 않습니다.'
        });
        repwd.focus();
        return false;
    }

    if (uname.value == "") {
        Swal.fire({
            icon: 'warning',
            text: '닉네임을 확인해주세요.'
        });
        uname.focus();
        return false;
    }

    if (email_id.value == "") {
        Swal.fire({
            icon: 'warning',
            text: '이메일 주소를 확인해주세요.'
        });
        email_id.focus();
        return false;
    }

    const reg = /^[0-9]+/g;
    if (!reg.test(mobile.value)) {
        Swal.fire({
            icon: 'warning',
            text: '휴대폰번호를 확인해주세요.'
        });
        mobile.focus();
        return false;
    }

        document.joinForm.submit();

}



