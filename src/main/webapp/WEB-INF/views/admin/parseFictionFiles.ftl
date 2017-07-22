<#include "/common/head.ftl"/>
<div class="container">
    <div class="row ">
        <div class="panel ">
            <div class="panel-heading title"><h3>解析小说</h3></div>
            <div class="panel-body">
                <form id="parseFictionForm">
                <div class="row ">
                    <div class="col-md-12 ">
                        <ul class="list-group">
                            <li class="list-group-item">
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">文件名称</span>
                                    <input type="text" class="form-control" name="fileNames" placeholder="名称"
                                           aria-describedby="basic-addon1">
                                </div>
                            </li>
                        </ul>
                        <div class="input-group" style="margin-bottom: 30px;margin-top: 20px;">
                            <span class="input-group-addon pointer-style" onclick="parseFiction();" >保存</span>
                        </div>
                    </div>

                </div>
                </form>
            </div>
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
<script src="/resources/js/admin/parseFiction.js"></script>
</html>
