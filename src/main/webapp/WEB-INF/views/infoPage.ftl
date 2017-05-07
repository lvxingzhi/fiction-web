<#include "/common/head.ftl"/>
<div class="container">
    <div class="row ">
        <div class="panel">
            <div class="panel-body">
                <main class="col-md-9">
                    <div class="panel ">
                        <div class="panel-body">
                            <div class="row " id="hotTableContent">
                                <div class="row">
                                    <div class="col-md-4">
                                        <a href="//book.qidian.com/info/131957" target="_blank"><img
                                                src="${fictionInfo.coverPhoto}"></a>
                                    </div>
                                    <div class="col-md-8">
                                        <h1>${fictionInfo.title}
                                            <small>${fictionInfo.authorName}</small>
                                        </h1>
                                        <blockquote class="height15">
                                            <p>简介: </p>
                                            <p>${fictionInfo.fullDesc}</p>
                                        </blockquote>
                                        <#if chapterList??>
                                            <#if (chapterList?size>0)>
                                                <a href="/homepage/contentPage?chapterCode=${chapterList[0].logicCode}">
                                                    <button type="button" class="btn btn-danger btn-lg">在线阅读</button>
                                                </a>
                                            </#if>
                                        </#if>
                                        <ul class="nav navbar-nav navbar-right">
                                            <li>
                                                <button type="button" class="btn btn-success">评分</button>
                                            </li>
                                            <li>&nbsp;</li>
                                            <li>
                                                <button type="button" class="btn btn-warning">分享</button>
                                            </li>
                                        </ul>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </main>
                <sidebar class="col-md-3">
                    <div class="">
                        <h4 class="title">网络评分</h4>
                        <h1 class="text-center">${(fictionInfo.fictionScore/fictionInfo.fictionScoreNum)?string("0.0")}
                            <small>分</small>
                        </h1>
                    </div>
                </sidebar>
            </div>
        </div>
    </div>
    <div class="row ">
        <div class="panel ">
            <div class="panel-heading title"><h3>作品目录</h3></div>
            <div class="panel-body">
                <#if chapterList??>
                    <#list chapterList as item>
                        <div class="col-md-4">
                            <p class="text-center "><a class="pointer-style" onclick="showChapterInfo('${item.logicCode}');">${item.chapterName}</a></p>
                        </div>
                    </#list>
                </#if>
            </div>
        </div>
    </div>
</div>
<#include "/common/foot.ftl"/>
<script src="/resources/plugin/jquery/jquery.js"></script>
<script src="/resources/plugin/bootstrap/js/bootstrap.js"></script>
<#--<script src="/resources/plugin/bootstrap/js/npm.js"></script>-->
<script src="/resources/js/home/home.js"></script>
<script src="/resources/js/infopage/infoPage.js"></script>
</html>
