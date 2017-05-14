/**
 * Created by Administrator on 2017/2/15.
 */
/**
 * 检索
 */
$(function(){
    search(1);
});

function search(page) {
    var searchContent = $("#searchContent").val();
    $.ajax({
            url: "/homepage/ajaxSearch",
            async: false,
            data: {searchContent: searchContent,page:page,size:5},
            dataType: "json",
            success: function (data) {
                var array = data.list;
                var listContent = "";
                array.forEach(function(item){
                    listContent+='<li class="list-group-item"><span class="badge searchRead-color"><a  href="/homepage/infoPage?fictionCode='+item.logicCode+'">点击阅读</a></span>' +
                        '<div class="row"><div class="col-md-2">' +
                        '<a href="/homepage/infoPage?fictionCode='+item.logicCode+'" target="_blank">' +
                        '<img class="searchImg" src="'+item.coverPhoto+'"></a>' +
                        '</div><div class="col-md-7"><h4>'+item.title+' <small>'+item.authorName+'</small>' +
                        '</h4><blockquote><em>'+item.fullDesc+'</em>' +
                        '<footer>最近更新: <cite title="Source Title">&lt;'+item.lastChapterName+'&gt;</cite>' +
                        '</footer></blockquote></div><div class="col-md-3"><p>阅读: '+item.fictionViews+'次</p>' +
                        '<p>字数: '+item.totalWord+'</p></div></div></li>';
                });
                $("#listContent").html(listContent);
                var maxPage = data.maxPage;
                $("#page").val(page);
                if(page>1){
                    $("#prePage").show();
                }else{
                    $("#prePage").hide();
                }
                if(maxPage>page){
                    $("#nextPage").show();
                }else{
                    $("#nextPage").hide();
                }
                
            },
            error: function () {
            },
            timeout: function () {
            }
        }
    );

}

/**
 * 后退
  */

function preSearch(){
    var page =$("#page").val();
    search(parseInt(page)-1);
}

/**
 * 前进
 */
function nextSearch(){
    var page =$("#page").val();
    search(parseInt(page)+1);
}