<#include "/common/head.ftl"/>
<div class="container">
    <div class="row ">
        <div class="panel">
            <div class="panel-body read-color">
                <div class="col-md-1">

                </div>
                <main class="col-md-10">
                    <div class="row read-title">
                        <h3>
                        ${chapterInfo.chapterName}
                            <small>&lt;冒牌的猫&gt;</small>
                        </h3>
                    </div>
                    <div class="row read-content" id="fictionContent">
                    ${chapterInfo.chapterContentStr}
                    </div>
                    <div class="row read-foot">
                        <nav aria-label="...">
                            <ul class="pager">
                                <li class="previous"><a href="#"><span aria-hidden="true">&larr;</span> 后退</a></li>
                                <li class="next"><a href="#">前进 <span aria-hidden="true">&rarr;</span></a></li>
                            </ul>
                        </nav>
                    </div>
                </main>
                <div class="col-md-1">

                </div>
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
