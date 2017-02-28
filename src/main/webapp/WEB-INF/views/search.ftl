<#include "/common/head.ftl"/>
<div class="container">
    <div class="row ">
        <div class="panel">
            <div class="panel-body">
                <main class="col-md-9">
                    <div class="panel ">
                        <h3 class="title">搜索</h3>
                        <div class="panel-body">
                            <div class="row " id="hotTableContent">
                                <ul class="nav nav-pills" role="tablist">
                                    <li role="presentation" class="active"><a href="#">全部</a></li>
                                    <li role="presentation"><a href="#">武侠</a></li>
                                    <li role="presentation"><a href="#">都市</a></li>
                                    <li role="presentation"><a href="#">言情</a></li>
                                    <li role="presentation"><a href="#">玄幻</a></li>
                                    <li role="presentation"><a href="#">其他</a></li>
                                </ul>

                                <div class="input-group" style="margin-bottom: 30px;margin-top: 20px;">
                                    <input type="text" class="form-control">
                                    <span class="input-group-addon">搜索</span>
                                </div>

                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <span class="badge">点击阅读</span>
                                        <div class="row">
                                        <div class="col-md-2">
                                            <a href="//book.qidian.com/info/131957" target="_blank"><img
                                                    src="//qidian.qpic.cn/qdbimg/349573/131957/150"></a>
                                        </div>
                                        <div class="col-md-7">
                                            <h4>谁是大英雄 <small>Mr.周</small></h4>
                                           <blockquote>
                                               <em>简介简介简介简介简介简介简介简介简介简介简介简介简介</em>
                                               <footer>最近更新:<cite title="Source Title">第三章&lt;咚的一声&gt;</cite></footer>
                                           </blockquote>
                                        </div>
                                        <div class="col-md-3">
                                            <p>阅读: 20023</p>
                                            <p>排行: 6</p>
                                            <p>字数: 1230444</p>
                                        </div>
                                        </div>
                                    </li>

                                </ul>

                                <nav aria-label="...">
                                    <ul class="pager">
                                        <li class="previous"><a href="#"><span aria-hidden="true">&larr;</span> 后退</a></li>
                                        <li class="next"><a href="#">前进 <span aria-hidden="true">&rarr;</span></a></li>
                                    </ul>
                                </nav>

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
