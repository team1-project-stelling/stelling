
function login_check() {
    const uid = document.getElementById("uid");
    const pwd = document.getElementById("pwd");

    //아이디 입력 유무
    if (uid.value == "") {
        alert("아이디를 입력해주세요.")
        uid.focus();
        return false;
    };

    //비밀번호 입력 유무
    if (pwd.value == "") {
        alert("비밀번호를 입력해주세요.")
        return false;
    };

    document.joinForm.submit();
};


