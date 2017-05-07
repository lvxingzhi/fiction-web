<#include "/common/head.ftl"/>
<div class="container">
    <div class="row ">
        <div class="panel ">
            <div class="panel-heading title"><h3>创建小说章节</h3></div>
            <div class="panel-body">
                <form id="createFictionChapterForm">
                <div class="row ">
                    <div class="col-md-12 ">
                        <ul class="list-group">
                            <li class="list-group-item">
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">小说ID</span>
                                    <input type="text" class="form-control" name="fictionCode" placeholder="小说ID"
                                           aria-describedby="basic-addon1">
                                </div>
                            </li>
                            <li class="list-group-item">
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">章节排列顺序</span>
                                    <input type="number" class="form-control" name="chapterSort" placeholder="章节排列顺序"
                                           aria-describedby="basic-addon1">
                                </div>
                            </li>
                            <li class="list-group-item">
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">章节名称</span>
                                    <input type="text" class="form-control" placeholder="章节名称" name="chapterName"
                                           aria-describedby="basic-addon1">
                                </div>
                            </li>
                            <li class="list-group-item">
                                <label for="basic-url">章节类型</label>
                                <select name="chapterType" >
                                    <option value="1">
                                        免费
                                    </option>
                                    <option value="2">
                                        收费
                                    </option>
                                </select>
                            </li>
                            <li class="list-group-item">
                                <label for="basic-url">章节内容</label>
                                <textarea type="text" class="form-control" placeholder="章节内容" name="chapterContent"
                                       aria-describedby="basic-addon1"></textarea>
                            </li>
                        </ul>
                        <div class="input-group" style="margin-bottom: 30px;margin-top: 20px;">
                            <span class="input-group-addon pointer-style" onclick="createFictionChapter();" >保存</span>
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
<script src="/resources/js/admin/createFictionChapter.js"></script>
</html>
