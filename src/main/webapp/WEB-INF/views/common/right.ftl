<sidebar class="col-md-3">
    <div class="widget">
        <h4 class="title">江湖阅读榜</h4>
        <ol>
        <#if viewsList??>
            <#list viewsList as item>
                <li><a href="/homepage/infoPage?fictionCode=${item.fictionCode}">[${item.typeName}] ${item.fictionName}</a></li>
            </#list>
        </#if>
        </ol>
    </div>
    <div class="widget">
        <h4 class="title">江湖评分榜</h4>
        <ol>
        <#if scoreList??>
            <#list scoreList as item>
                <li><a href="/homepage/infoPage?fictionCode=${item.fictionCode}">[${item.typeName}] ${item.fictionName}</a></li>
            </#list>
        </#if>
        </ol>
    </div>
    <div class="widget">
        <h4 class="title">飞鸽传书</h4>
        <ol>
            <li><a>微信号:weixinhao</a></li>
        </ol>
    </div>
    <div class="widget">
        <h4 class="title">滚动评论</h4>
        <ol>
            <li><a>礼拜太逗说: 这本小说写得太好了...</a></li>
            <li><a>金钱不多说: 这本小说写得太好了...</a></li>
            <li><a>瞄说: 这本小说写得太好了...</a></li>
            <li><a>龙儿说: 这本小说写得太好了...</a></li>
            <li><a>名字在哪说: 这本小说写得太好了...</a></li>
        </ol>
    </div>
</sidebar>