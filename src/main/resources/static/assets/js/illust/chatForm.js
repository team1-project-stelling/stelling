
deleteRoom()
function deleteRoom() {
    $('.arrow').on('click', function () {





        if ($('.arrow>img').attr('src') == '/images/icon/화살표.png') {
            $('.arrow>img').attr('src', '/images/icon/위화살표.png')
            $('.delete').css('display', 'inline-block');
            thischat = document.querySelectorAll('.thischat')
            for(let i=0; i<thischat.length;i++){
                thischat[i].innerHTML="<a>asdasd</a>"
                thischat[i].classList.add("deleteRooms")
                thischat[i].classList.remove("thischat")
                thischat[i].innerText = "방 나가기"
                deleteRooms= document.querySelectorAll('.deleteRooms')

                deleteRooms[i].addEventListener('click',function () {



                    roomName = this.dataset.room
                    console.log(roomName)

                    $.ajax({
                        url: `/deleteChat/${roomName}`,
                        dataType: "json",
                        type: "get",

                        success: function () {
                        alert("삭제완료")
                            console.log(roomName)
                            location.reload()

                           
                        },
                        error: function () {
                            console.log(roomName)
                        alert("삭제완료")
                            location.reload()
                        }
                    })
















                })
            }



        } else {
            deleteRooms= document.querySelectorAll('.deleteRooms')
            $('.delete').css('display', 'none');
            $('.arrow>img').attr('src', '/images/icon/화살표.png');
            for(let i=0; i<deleteRooms.length;i++){
                deleteRooms[i].classList.add("thischat")
                deleteRooms[i].classList.remove("deleteRooms")
                deleteRooms[i].innerText = "채팅"

            }






        }

    })



}