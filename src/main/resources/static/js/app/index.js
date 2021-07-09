
//유효범위 관리 (var main~)
var main = {
    init : function() {
        var _this = this;

        //등록 버튼-save
        $('#btn-save').on('click', function () {
            _this.save();
        });

        //수정 버튼-update
        $('#btn-update').on('click', function () {
            _this.update();
        });

        //삭제 버튼-delete
    },

    //save
    save : function() {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },

    //update
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
           type: 'PUT',
           url: '/api/v1/posts/'+id,
           dataType: 'json',
           contentType:'application/json; charset=utf-8',
           data: JSON.stringify(data)
        }).done(function() {
           alert('글이 수정되었습니다.');
           window.location.href = '/';
        }).fail(function (error) {
           alert(JSON.stringify(error));
        });
    }

    //delete

};
main.init();