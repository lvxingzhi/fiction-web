/**
 * Created by Administrator on 2017/2/15.
 */
/**
 * 创建小说
 */
function createFiction() {
    $.ajax({
            url: "http://localhost:8080/adminManage/createFiction",
            async: false,
            data: $("#createFictionForm").serialize(),
            dataType: "json",
            type: "post",
            success: function (data) {
               alert(data);
            },
            error: function () {
            },
            timeout: function () {
            }
        }
    );

}