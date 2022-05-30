

function deleteRoom() {
    $('.arrow').on('click', function () {


        thischat = document.querySelectorAll('.thischat')
        deleteRooms= document.querySelectorAll('.deleteRooms')

        if ($('.arrow>img').attr('src') == '/images/icon/화살표.png') {
            $('.arrow>img').attr('src', '/images/icon/위화살표.png')
            $('.delete').css('display', 'inline-block');

            for(let i=0; i<thischat.length;i++){
                thischat[i].setAttribute("clsss",deleteRooms)
            }



        } else {
            $('.delete').css('display', 'none');
            $('.arrow>img').attr('src', '/images/icon/화살표.png');
            for(let i=0; i<thischat.length;i++){
                deleteRooms[i].setAttribute("clsss",deleteRooms)
            }






        }

    })



}