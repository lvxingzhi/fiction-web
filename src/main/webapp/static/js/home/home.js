/**
 * Created by Administrator on 2017/2/15.
 */
/**
 * 检索
 */
function search() {
    var searchContent = $("#searchContent").val();
    $.ajax({
            url: "http://localhost:8080/homepage/ajaxSearch",
            async: false,
            data: {searchContent: searchContent},
            dataType: "json",
            success: function (data) {
                var array = data.list;
                var hotTableContent = "";
                array.forEach(function(item){
                    hotTableContent+='<div class="col-md-3 thumbnail">' +
                        '<img src="/resources/image/1.jpg"/>' +
                        '<p>'+item.title+'</p>' +
                        '<p>'+item.description+'</p>' +
                        '</div>';
                });
                $("#hotTableContent").html(hotTableContent);
                
            },
            error: function () {
            },
            timeout: function () {
            }
        }
    );

}