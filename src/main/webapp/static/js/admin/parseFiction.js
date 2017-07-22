/**
 * Created by Administrator on 2017/2/15.
 */
/**
 * 解析小说
 */
function parseFiction() {
    $.ajax({
            url: "/adminManage/parseFictionFiles",
            async: false,
            data: $("#parseFictionForm").serialize(),
            dataType: "json",
            type: "post",
            success: function (data) {
               if("0"==data.status){
                   alert("成功解析数量:"+data.data.data);
               }else{
                   alert("保存失败:"+data.message);
               }
            },
            error: function (data) {
                alert("保存错误:"+data.message);
            },
            timeout: function () {
                alert("保存超时");
            }
        }
    );

}