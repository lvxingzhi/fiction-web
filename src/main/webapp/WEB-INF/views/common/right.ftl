<sidebar class="col-md-3">
    <div class="widget">
        <h4 class="title">江湖阅读榜</h4>
        <ol>
        <#list viewsList as item>
            <li><a>[书名] ${item.title}</a></li>
        </#list>
        </ol>
    </div>
    <div class="widget">
        <h4 class="title">江湖新秀</h4>
        <ol>
        <#list newList as item>
            <li><a>[书名] ${item.title}</a></li>
        </#list>
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