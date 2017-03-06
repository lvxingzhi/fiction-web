<#include "/common/head.ftl"/>
<div class="container">
    <div class="row ">
        <div class="panel">
            <div class="panel-body">
                <main class="col-md-9">
                    <div class="panel ">
                        <h3 class="title">人气连载</h3>
                        <div class="panel-body">
                            <div class="row " id="hotTableContent">
                            <#if fullList??>
                                <#list fullList as item>
                                    <div class="col-md-3 ">
                                        <a class="thumbnail"
                                           href="/homepage/infoPage?fictionCode=${item.logicCode}"><img
                                                src="/resources/image/1.jpg"/>
                                            <div class="caption">
                                                <p>${item.title}</p>
                                                <p>${item.authorName}</p>
                                                <p>${item.shortDesc}</p>
                                                <p>${item.createTime?string("yyyy-MM-dd HH:mm:ss")}</p>
                                            </div>
                                        </a>
                                    </div>
                                </#list>
                            </#if>
                            </div>
                        </div>
                    </div>
                    <div class="panel ">
                        <h3 class="title">全站精品</h3>
                        <div class="panel-body">
                            <div class="row ">
                            <#if fullList??>
                                <#list fullList as item>

                                    <div class="col-md-3 ">
                                        <a class="thumbnail"
                                           href="/homepage/infoPage?fictionCode=${item.logicCode}"><img
                                                src="/resources/image/1.jpg"/>
                                            <div class="caption">
                                                <p>${item.title}</p>
                                                <p>${item.authorName}</p>
                                                <p>${item.shortDesc}</p>
                                                <p>${item.createTime?string("yyyy-MM-dd HH:mm:ss")}</p>
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
