<sidebar class="col-md-3">
    <div class="widget" style="padding:21px 20px;">
        <h4 class="title">阅读榜</h4>
        <ol style="list-style:none;padding-left: 10px;">
        <#if viewsList??>
            <#list viewsList as item>
                <li><p onclick="javascript:window.open('/homepage/infoPage?fictionCode=${item.fictionCode}');" class="line-width-rank-text" >[${item.typeName}] ${item.fictionName}</p></li>
            </#list>
        </#if>
        </ol>
    </div>
    <div class="widget" style="padding:21px 20px;">
        <h4 class="title">评分榜</h4>
        <ol style="list-style:none;padding-left: 10px;">
        <#if scoreList??>
            <#list scoreList as item>
                <li><p onclick="javascript:window.open('/homepage/infoPage?fictionCode=${item.fictionCode}');" class="line-width-rank-text" >[${item.typeName}] ${item.fictionName}</p></li>
            </#list>
        </#if>
        </ol>
    </div>
    <div class="widget" style="padding:21px 20px;">
        <h4 class="title">飞鸽传书</h4>
        <ol style="list-style:none;padding-left: 10px;">
            <li><a>微信号:notenextday</a></li>
        </ol>
    </div>
    <div class="widget hide" style="padding:21px 20px;">
        <h4 class="title">滚动评论</h4>
        <ol style="list-style:none;padding-left: 10px;">
            <li><a class="line-width-rank-text">路人甲: 小说请多一些.</a></li>
            <li><a class="line-width-rank-text">路人乙: 新的小说站哦.</a></li>
            <li><a class="line-width-rank-text">路人丙: 好神奇,女生站.</a></li>
            <li><a class="line-width-rank-text">路人丁: 哈</a></li>
        </ol>
    </div>
</sidebar>