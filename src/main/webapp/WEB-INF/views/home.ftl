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
                            <#list hotList as item>
                                <div class="col-md-3 thumbnail">
                                    <img src="/resources/image/1.jpg"/>
                                    <p>${item.title}</p>
                                    <p>${item.authorName}</p>
                                    <p>${item.description}</p>
                                    <p>${item.createTime?string("yyyy-MM-dd HH:mm:ss")}</p>
                                </div>
                            </#list>
                            </div>
                        </div>
                    </div>
                    <div class="panel ">
                        <h3 class="title">全站精品</h3>
                        <div class="panel-body">
                            <div class="row ">

                            <#list list as item>
                                <div class="col-md-3 thumbnail">
                                    <img src="/resources/image/1.jpg"/>
                                    <p>${item.title}</p>
                                    <p>${item.authorName}</p>
                                    <p>${item.description}</p>
                                    <p>${item.createTime?string("yyyy-MM-dd HH:mm:ss")}</p>
                                </div>
                            </#list>

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
