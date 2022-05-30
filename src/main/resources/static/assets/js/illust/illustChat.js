let mysession = document.getElementById('hiddenuserNickName').value;

sessionStorage.setItem("mySession", mysession)
document.getElementById('ownUser').innerText = mysession


//회원목록
let findMembers = "";
$.ajax({
    url: "/list",
    dataType: "json",
    type: "get",
    async: false,
    success: function (data) {
        findMembers = data

    },
    error: function () {
        alert("실패");
    }
})

findMembers?.map((v) => {
    document.getElementById('dummyUl').innerHTML += `
            <li style="margin-top: 10px; ">${v}         </li> 
        `
})

//************************시작***************************************************
//채팅내역
let chatList = [];
$.ajax({
    url: `/chatList/${mysession}/${mysession}`,
    dataType: "json",
    type: "get",
    async: false,
    success: function (data) {
        chatList = data


    },
    error: function () {
        alert("실패");
    }
});


chatLists = document.getElementById('chatLists')
let chattingList = document.getElementById('chattingList')

if (chatList.length === 0) {
    chattingList.innerHTML += '<li class="nametd" style="list-style: none; margin-left: 20px;cursor: pointer">채팅내역이 존재하지 않음</li>'
    document.getElementById('chatWrapSecond').innerHTML = "<div style='position: absolute;top: 40%;left: 40%;'>채팅을시작해보세요</div>"
} else {
    chatList?.map((v) => {
        console.log(v)
        chattingList.innerHTML += `<li data-room=${v.roomName} class="nametd"  style="list-style: none; margin-left: 20px;font-size: 15px;font-weight: 500; margin-top: 20px;" > 
                            <a>${v.roomName}</a>  <span style="cursor: pointer" class="thischat">채팅시작 <input type="hidden" id="valuehidden" value="${v.roomName}"></span></li>`
        document.getElementById('chatWrapSecond').innerHTML = "<div style='position: absolute;top: 40%;left: 30%;'>채팅을시작하려면 상대방을 선택해주세요</div>"

    })
}


//처음 대화 시작
document.getElementById('dummyUl').addEventListener('click', function (e) {
    if (e.target.tagName === "LI") {
        let other = e.target.innerText
        처음대화(mysession,other)


    }
})

$(document).ready(function () {
    채팅방연결(mysession)
    채팅방내이름지우기(mysession)

})




const 채팅방연결 =(mysession) => {


    chattingList.addEventListener('click', function (e) {
        if (e.target.tagName === "LI") {
            roomNames = e.target.dataset.room
            roomNames.split("&")[0] === mysession ? 방만들기(roomNames) : 기존방연결(roomNames)
        }
    })
}

const 채팅방내이름지우기 =(mysession) => {
    let nametd = document.querySelectorAll('.nametd');
    //얘는 변수 바꿔도댐
    for (let i = 0; i < nametd.length; i++) {
        let receiverName = nametd[i].innerText
        let matchname = receiverName.match(mysession)
        let finl = receiverName.replace(matchname, '');
        let endremove = finl.match("&")
        let endfinal = finl.replace(endremove, '');
        let final = finl.split(' ')[0];
        final === mysession ? nametd[i].innerText = "나와의 채팅" : nametd[i].innerText = endfinal
    }
}


const 기존방연결 = (roomNames) => {

    let other = roomNames.split("&")[0]
    sessionStorage.setItem("other", other)
    sessionStorage.setItem("roomNames", roomNames)
    console.log(roomNames)
    $("#chatWrapSecond").load(`/rooms/${roomNames}`);

}


const 방만들기 = (roomNames) => {

    $.ajax({
        type: "POST",
        url: ` /room/new `,
        data: roomNames,
        contentType: "application/json",
        success: function () {


            let endremove = roomNames.match("&")
            let endfinal = roomNames.replace(endremove, '');
            let others = endfinal.match(mysession)
            let other = endfinal.replace(mysession, '');

            sessionStorage.setItem("other", other)
            sessionStorage.setItem("roomNames", roomNames)
            $("#chatWrapSecond").load(`/rooms/${roomNames}`);
        },
        error: function () {

            alert("방생성 실패 ");
        }
    })
}


const 처음대화 = (mysession,other) => {

      $.ajax({
        type: "POST",
        url: `/chatHistory/${mysession}/${other}`,
        contentType: "application/json",

        success: function () {

            let result = "";
            $.ajax({
                url: `/connectRoom/${mysession}/${other}`,
                dataType: "json",
                type: "get",
                async: false,
                success: function (data) {


                    result = data
                    let roomNames = result[0].roomName;
                        console.log(roomNames)

                    방만들기(roomNames);
                },

            });
        },
        error: function () {
            let roomNames = mysession +"&"+ other
            console.log(roomNames+"에러타입")
            방만들기(roomNames);
        }
    })};

