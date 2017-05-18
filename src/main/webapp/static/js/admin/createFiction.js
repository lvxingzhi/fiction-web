/**
 * Created by Administrator on 2017/2/15.
 */
/**
 * 创建小说
 */
function createFiction() {
    $.ajax({
            url: "/adminManage/createFiction",
            async: false,
            data: $("#createFictionForm").serialize(),
            dataType: "json",
            type: "post",
            success: function (data) {
               if("0"==data.status){
                   alert("保存成功");
               }else{
                   alert("保存失败");
               }
            },
            error: function () {
                alert("保存错误");
            },
            timeout: function () {
                alert("保存超时");
            }
        }
    );

}