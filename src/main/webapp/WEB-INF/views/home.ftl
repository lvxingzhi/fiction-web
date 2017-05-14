<#include "/common/head.ftl"/>
<div class="container">
    <div class="row ">
        <div class="panel">
            <div class="panel-body">
                <main class="col-md-9">
                    <div class="panel ">
                        <h3 class="title">最近更新</h3>
                        <div class="panel-body">
                            <div class="row " id="hotTableContent">
                            <#if timeFullList??>
                                <#list timeFullList as item>
                                    <div class="col-md-3 ">
                                        <a class="thumbnail"
                                           href="/homepage/infoPage?fictionCode=${item.logicCode}">
                                            <img class="home-head-img" src="${item.coverPhoto}"/>
                                            <div class="caption">
                                                <p class="line-width-text-title">${item.title}</p>
                                                <small class="line-width-text-author">作者:${item.authorName}</small>
                                                <p >简介:${item.subShortDesc}</p>
                                                <p>${item.createTime}</p>
                                            </div>
                                        </a>
                                    </div>
                                </#list>
                            </#if>
                            </div>
                        </div>
                    </div>
                    <div class="panel ">
                        <h3 class="title">热门书籍</h3>
                        <div class="panel-body">
                            <div class="row ">
                            <#if scoreFullList??>
                                <#list scoreFullList as item>
                                    <div class="col-md-3 ">
                                        <a class="thumbnail"
                                           href="/homepage/infoPage?fictionCode=${item.logicCode}">
                                            <img class="home-head-img" src="${item.coverPhoto}"/>
                                            <div class="caption">
                                                <p class="line-width-text">${item.title}</p>
                                                <small class="line-width-text-author" >作者:${item.authorName}</small>
                                                <p >简介:${item.subShortDesc}</p>
                                                <p>${item.createTime}</p>
                                            </div>
                                        </a>
                                    </div>
                                </#list>
                            </#if>
                            </div>
                        </div>
                    </div>
                </main>
            <#include "/common/right.ftl"/>
            </div>
        </div>

    </div>

</div>
<#include "/common/foot.ftl"/>
<script src="/resources/plugin/jquery/jquery.js"></script>
<script src="/resources/plugin/bootstrap/js/bootstrap.js"></script>
<#--<script src="/resources/plugin/bootstrap/js/npm.js"></script>-->
<script src="/resources/js/home/home.js"></script>

</html>
