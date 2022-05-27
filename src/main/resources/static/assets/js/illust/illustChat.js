mysession = document.getElementById('hiddenuserNickName').value;
console.log(mysession)

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
        console.log(findMembers)
    },
    error: function () {
        alert("실패");
    }
})

findMembers?.map((v) => {
    document.getElementById('dummyUl').innerHTML += `
            <li style="margin-top: 10px; ">${v}         <span style="cursor: pointer" class="thischat">얘랑 채팅할랭 <input type="hidden" id="valuehidden" value="${v}"></span></li> 
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
        console.log(chatList)


    },
    error: function () {
        alert("실패");
    }
});
chatLists = document.getElementById('chatLists')


if (chatList.length === 0) {
    chatLists.innerHTML += '<li class="nametd" style="list-style: none; margin-left: 20px">채팅내역이 존재하지 않음</li>'
    document.getElementById('chatWrapSecond').innerHTML = "<div style='position: absolute;top: 40%;left: 40%;'>채팅을시작해보세요</div>"
} else {
    chatList?.map((v) => {
        console.log(v)
        chatLists.innerHTML += `<li class="nametd"  style="list-style: none;    margin-left: 20px;font-size: 15px;font-weight: 500; margin-top: 20px; >  닉네임:${v.roomName} </li>`
        document.getElementById('chatWrapSecond').innerHTML = "<div style='position: absolute;top: 40%;left: 30%;'>채팅을시작하려면 상대방을 선택해주세요</div>"

    })
}
removesession()

function removesession() {
    let nametd = document.querySelectorAll('.nametd');
    //얘는 변수 바꿔도댐
    for (let i = 0; i < nametd.length; i++) {
        let receiverName = nametd[i].innerText
        let matchname = receiverName.match(mysession)
        console.log(matchname)
        let finl = receiverName.replace(matchname, '');
        console.log(finl)
        nametd[i].innerText = finl

    }

}

let thischat = document.querySelectorAll(".thischat");
let dummyUl = document.querySelector('#dummyUl')

dummyUl.addEventListener('click', function (e) {
    if (e.target.tagName === "SPAN") {

        const other = e.target.lastChild.value
        sessionStorage.setItem("other", other)
        g(other)
    }
//    에이작스 시작


})


//처음 대화 시작
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
                    console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
                    console.log(roomNames)
                    console.log(other)

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

const makeRoom = (roomNames) => {
    $.ajax({
        type: "POST",
        url: ` /room/new `,
        data: roomNames,
        contentType: "application/json",
        success: function () {
            sessionStorage.setItem("roomNames", roomNames)
            $("#chatWrapSecond").load(`/rooms/${roomNames}`);
            //window.open(`/rooms/${roomNames}`, "_blank", "채팅", "width:300px  height: 400px, top=10, left=10");
        },
        error: function () {
            console.log(roomNames)
            alert("실패");
        }
    })
}



