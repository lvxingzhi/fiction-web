/**
 * Created by Administrator on 2017/2/15.
 */
/**
 * 页头检索
 */
function homeSearch() {
    var headContent = $("#headContent").val();
    window.open("/homepage/search?headContent="+headContent);
}