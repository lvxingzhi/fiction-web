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
                var listContent = "";
                array.forEach(function(item){
                    listContent+='<li class="list-group-item"><span class="badge"><a  href="/homepage/infoPage">点击阅读</a></span>' +
                        '<div class="row"><div class="col-md-2">' +
                        '<a href="//book.qidian.com/info/131957" target="_blank">' +
                        '<img class="searchImg" src="'+item.coverPhoto+'"></a>' +
                        '</div><div class="col-md-7"><h4>'+item.title+' <small>'+item.authorName+'</small>' +
                        '</h4><blockquote><em>'+item.fullDesc+'</em>' +
                        '<footer>最近更新: <cite title="Source Title">&lt;'+item.lastChapterName+'&gt;</cite>' +
                        '</footer></blockquote></div><div class="col-md-3"><p>阅读: '+item.fictionViews+'次</p>' +
                        '<p>字数: '+item.totalWord+'</p></div></div></li>';
                });
                $("#listContent").html(listContent);
                
            },
            error: function () {
            },
            timeout: function () {
            }
        }
    );

}