document.querySelectorAll(".drop-zone__input").forEach((inputElement) => {
    const dropZoneElement = inputElement.closest(".drop-zone");

    dropZoneElement.addEventListener("click", (e) => {
        inputElement.click();
    });
    inputElement.addEventListener("change", (e) => {
        if (inputElement.files.length) {
            updateThumbnail(dropZoneElement, inputElement.files[0]);
        }
    });
    dropZoneElement.addEventListener("dragover", (e) => {
        e.preventDefault();
        dropZoneElement.classList.add("drop-zone--over");

    });
    ["dragleave", "dragend"].forEach((type) => {
        dropZoneElement.addEventListener(type, (e) => {
            dropZoneElement.classList.remove("drop-zone--over");

        });
    });
    dropZoneElement.addEventListener("drop", (e) => {
        e.preventDefault();

        if (e.dataTransfer.files.length) {
            inputElement.files = e.dataTransfer.files;
            updateThumbnail(dropZoneElement, e.dataTransfer.files[0]);
        }

        dropZoneElement.classList.remove("drop-zone--over");
        document.querySelector('.drop_zone').style.border="none";
        // dropZoneElement.classList.add("drop-zone--over2");
    });
});

/*  /!**
   * Updates the thumbnail on a drop zone element.
   *
   * @param {HTMLElement} dropZoneElement
   * @param {File} file
   *!/*/
function updateThumbnail(dropZoneElement, file) {
    let thumbnailElement = dropZoneElement.querySelector(".drop-zone__thumb");

    // First time - remove the prompt
    if (dropZoneElement.querySelector(".drop-zone__prompt")) {
        dropZoneElement.querySelector(".drop-zone__prompt").remove();
    }

    // First time - there is no thumbnail element, so lets create it
    if (!thumbnailElement) {
        thumbnailElement = document.createElement("div");
        thumbnailElement.classList.add("drop-zone__thumb");
        dropZoneElement.appendChild(thumbnailElement);
    }

    thumbnailElement.dataset.label = file.name;

    // Show thumbnail for image files
    if (file.type.startsWith("image/")) {
        const reader = new FileReader();

        reader.readAsDataURL(file);
        reader.onload = () => {
            thumbnailElement.style.backgroundImage = `url('${reader.result}')`;
        };
    } else {
        thumbnailElement.style.backgroundImage = null;
    }
    dropZoneElement.classList.add("drop-zone--over2");
}

$(document).ready(function () {
    var tag = {};
    var counter = 0;

    // 입력한 값을 태그로 생성한다.
    function addTag (value) {
        tag[counter] = value;
        counter++; // del-btn 의 고유 id 가 된다.
    }

    // tag 안에 있는 값을 array type 으로 만들어서 넘긴다.
    function marginTag () {
        return Object.values(tag).filter(function (word) {
            return word !== "";
        });
    }

    // 서버에 제공
    $("#tag-form").on("submit", function (e) {
        var value = marginTag(); // return array
        $("#rdTag").val(value);

        $(this).submit();
    });

    $("#tag").on("keypress", function (e) {
        var self = $(this);

        //엔터나 스페이스바 눌렀을때 실행
        if (e.key === "Enter" || e.keyCode == 32) {

            var tagValue = self.val(); // 값 가져오기

            // 해시태그 값 없으면 실행X
            if (tagValue !== "") {

                // 같은 태그가 있는지 검사한다. 있다면 해당값이 array 로 return 된다.
                var result = Object.values(tag).filter(function (word) {
                    return word === tagValue;
                })

                // 해시태그가 중복되었는지 확인
                if (result.length == 0) {
                    //태그 6개 제한
                    if(counter>5){
                        alert("태그는 6개까지만 가능합니다.");
                    }else {

                        $("#tag-list").append("<li class='tag-item'>" +tagValue + "<span class='del-btn' idx='" + counter + "'>&nbsp;x</span></li>");
                        addTag(tagValue);
                        self.val("");
                    }
                } else {
                    alert("태그값이 중복됩니다.");
                }


            }
            e.preventDefault(); // SpaceBar 시 빈공간이 생기지 않도록 방지
        }
    });



    // 삭제 버튼
    // 인덱스 검사 후 삭제
    $(document).on("click", ".del-btn", function (e) {
        var index = $(this).attr("idx");
        tag[index] = "";
        $(this).parent().remove();
        counter--;
    });
})


$("input[type='file']").change(function(e){


    /* 메인이미지 저장하기*/
    let inputFile = $("input[type='file']");
    let files = inputFile[0].files;
    let formData = new FormData();

    for (let i = 0; i < files.length; i++) {
        formData.append("uploadFile", files[i]);
    }
    console.log(formData);

    /*formdata action으로 변경 */
    $.ajax({
        url: "/illust/uploadAjaxAction",
        data: formData,
        type: "POST",
        // 현재 설정된 헤더 설정을 기본 방식으로 변경하지 못하도록 false로 설정
        processData: false,
        contentType: false,
        success: function (result) {
            $(result).each(function (i, item) {
                $('input[name="illustFileName"]').val(item.illustFileName);
                $('input[name="illustFilePath"]').val(item.illustFilePath);
                $('input[name="illustUuid"]').val(item.illustUuid);
            })
        },
        error:function () {
        }
    });
})
/*form데이터 보내기*/
$('#upBtn').on("click", function () {

    let hashtag = $('#tag-list').text();
    hashtag = hashtag.replace(/x/gi, "");
    hashtag = hashtag.replace(/&nbsp/gi, ",");
    $('input[name="illustHashTag"]').val(hashtag);

    register.submit();
});

