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
    chattingList.innerHTML += '<li class="nametd" style="list-style: none; margin-left: 20px">채팅내역이 존재하지 않음</li>'
    document.getElementById('chatWrapSecond').innerHTML = "<div style='position: absolute;top: 40%;left: 40%;'>채팅을시작해보세요</div>"
} else {
    chatList?.map((v) => {
                console.log(v)
        chattingList.innerHTML += `<li class="nametd"  style="list-style: none; margin-left: 20px;font-size: 15px;font-weight: 500; margin-top: 20px;" > 
                            <a>${v.roomName}</a>  <span style="cursor: pointer" class="thischat">채팅시작 <input type="hidden" id="valuehidden" value="${v}"></span></li>`
        document.getElementById('chatWrapSecond').innerHTML = "<div style='position: absolute;top: 40%;left: 30%;'>채팅을시작하려면 상대방을 선택해주세요</div>"

    })
}

removesession(mysession)

function removesession(mysession) {
    let nametd = document.querySelectorAll('.nametd');
    //얘는 변수 바꿔도댐
    for (let i = 0; i < nametd.length; i++) {
        let receiverName = nametd[i].innerText
        let matchname = receiverName.match(mysession)
        let finl = receiverName.replace(matchname, '');

        // console.log(finl.split(' '))
        let final  =finl.split(' ')[0];

        final===mysession? nametd[i].innerText ="나와의 채팅":nametd[i].innerText = finl


    }

}

let thischat = document.querySelectorAll(".thischat");


//기존채팅방 연결

const chatStart  = (mysession) =>{
    chattingList.addEventListener('click', function (e) {
        if (e.target.tagName === "LI") {
            let other = e.target.innerText.split(" ")[0]
            sessionStorage.setItem("other", other)



            roomNames= other+mysession
            comm(roomNames)
        }
    })}

chatStart(mysession)


//처음 대화 시작
document.getElementById('dummyUl').addEventListener('click',function (e) {
    if (e.target.tagName === "LI"){
        let other = e.target.innerText
        sessionStorage.setItem("other", other)
        g(other)

    }
})



function g(other) {
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


                    makeRoom(roomNames);
                },

            });
        },
        error: function () {

            let roomNames = mysession + other
            makeRoom(roomNames);
        }
    });
}



const  comm = (roomNames) => {
    sessionStorage.setItem("roomNames", roomNames)
    $("#chatWrapSecond").load(`/rooms/${roomNames}`);

}



const makeRoom = (roomNames) => {
    // 1. 서버가 시작되면 방을 무조건 새로 만들어야함
    // 2. 근데 우리는 방을 두개만들어서 쌍방이안됨
    // 솔루션
    // 1. 한명이 방을 무조건 만들어야하고
    // 2. 나머지 한명이 그방을 무조건 눌러들어가야함
    //


    $.ajax({
        type: "POST",
        url: ` /room/new `,
        data: roomNames,
        contentType: "application/json",
        success: function () {

            sessionStorage.setItem("roomNames", roomNames)
            $("#chatWrapSecond").load(`/rooms/${roomNames}`);
//    window.open(`/rooms/${roomNames}`, "_blank", "채팅", "width:300px  height: 400px, top=10, left=10");
        },
        error: function () {

            alert("실패");
        }
    })
}





