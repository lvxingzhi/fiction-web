<#include "/common/head.ftl"/>
<div class="container">
    <div class="row ">
        <div class="panel ">
            <div class="panel-heading title"><h3>创建小说</h3></div>
            <div class="panel-body">
                <form id="createFictionForm">
                <div class="row ">
                    <div class="col-md-12 ">
                        <ul class="list-group">
                            <li class="list-group-item">
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">名称</span>
                                    <input type="text" class="form-control" name="title" placeholder="名称"
                                           aria-describedby="basic-addon1">
                                </div>
                            </li>
                            <li class="list-group-item">
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">简介</span>
                                    <input type="text" class="form-control" name="shortDesc" placeholder="简介"
                                           aria-describedby="basic-addon1">
                                </div>
                            </li>
                            <li class="list-group-item">
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">图片路径(例如: /resources/image/a.jpg)</span>
                                    <input type="text" class="form-control" placeholder="图片路径" name="coverPhoto"
                                           aria-describedby="basic-addon1">
                                </div>
                            </li>
                            <li class="list-group-item">
                                <label for="basic-url">详细描述</label>
                                <select name="typeCode" >
                                    <option value="1">
                                        玄幻
                                    </option>
                                    <option value="2">
                                        奇幻
                                    </option>
                                    <option value="3">
                                        武侠
                                    </option>
                                    <option value="4">
                                        仙侠
                                    </option>
                                    <option value="5">
                                        都市
                                    </option>
                                    <option value="6">
                                        职场
                                    </option>
                                    <option value="7">
                                        军事
                                    </option>
                                    <option value="8">
                                        历史
                                    </option>
                                    <option value="9">
                                        游戏
                                    </option>
                                    <option value="10">
                                        体育
                                    </option>
                                    <option value="11">
                                        科幻
                                    </option>
                                    <option value="12">
                                        灵异
                                    </option>
                                    <option value="13">
                                        二次元
                                    </option>

                                </select>
                            </li>
                            <li class="list-group-item">
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">作者名称</span>
                                    <input type="text" class="form-control" placeholder="作者名称" name="authorName"
                                           aria-describedby="basic-addon1">
                                </div>
                            </li>
                            <li class="list-group-item">
                                <label for="basic-url">详细描述</label>
                                <input type="text" class="form-control" placeholder="详细描述" name="fullDesc"
                                       aria-describedby="basic-addon1">
                            </li>
                        </ul>
                        <div class="input-group" style="margin-bottom: 30px;margin-top: 20px;">
                            <span class="input-group-addon pointer-style" onclick="createFiction();" >保存</span>
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
<script src="/resources/js/admin/createFiction.js"></script>
</html>
