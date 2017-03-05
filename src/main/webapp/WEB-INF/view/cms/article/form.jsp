<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<html>
<head>
    <title>文章表</title>
    <%@ include file="../../include/head.jsp" %>
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/3rd-lib/wangEditor/css/wangEditor.min.css">
    <style type="text/css">
        .tpl-content-wrapper{margin-left:0}
        .row-content{padding: 0;}
    </style>
</head>
<body>
<script src="${ctxStatic}/assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">文章编辑</div>
                        </div>
                        <div class="widget-body am-fr">
                            <form class="am-form tpl-form-border-form" data-am-validator
                                  action="${ctx}/cms/article/<c:choose><c:when test="${empty article.id}">create</c:when><c:otherwise>update</c:otherwise></c:choose>"
                                  method="post">
                                <input type="hidden" name="id" value="${article.id}"/>
                                <input type="hidden" name="categoryId" value="${article.categoryId}"/>

                                <div class="am-form-group">
                                    <label class="am-u-sm-2 am-form-label">文章标题：</label>

                                    <div class="am-u-sm-10">
                                        <input type="text" name="title" placeholder="文章标题"
                                               value="${article.title}" required/>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label class="am-u-sm-2 am-form-label">文章图片：</label>

                                    <div class="am-u-sm-10">
                                        <div class="am-input-group">
                                            <input type="text" id="image" name="image" class="am-form-field" placeholder="文章图片"
                                                   value="${article.image}" readonly/>
							      <span class="am-input-group-btn">
							      	<input type="file" name="file" id="file" style="display: none;"/>
							        <button class="am-btn am-btn-default" id="btnPicture" type="button">上传图片</button>
							      </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label class="am-u-sm-2 am-form-label">文章内容：</label>

                                    <div class="am-u-sm-10">
								<textarea id="content" name="content" rows="16" placeholder="请输入内容...">
                                    ${not empty article.articleData.content?article.articleData.content:''}
                                </textarea>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label class="am-u-sm-2 am-form-label">关键字：</label>

                                    <div class="am-u-sm-10">
                                        <input type="text" name="keywords" placeholder="文章来源"
                                               value="${article.keywords}"/>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label class="am-u-sm-2 am-form-label">文章来源：</label>

                                    <div class="am-u-sm-10">
                                        <input type="text" name="copyfrom" placeholder="文章来源"
                                               value="${article.articleData.copyfrom}"/>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label class="am-u-sm-2 am-form-label">允许评论：</label>

                                    <div class="am-u-sm-10">
                                        <select name="allowComment" data="${article.articleData.allowComment}">
                                            <option value="false">否</option>
                                            <option value="true">是</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label class="am-u-sm-2 am-form-label">备注信息：</label>

                                    <div class="am-u-sm-10">
                                        <textarea rows="5" name="remarks" placeholder="备注信息">${article.remarks}</textarea>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <div class="am-u-sm-10 am-u-sm-push-2">
                                        <shiro:hasPermission name="cms:article:update"><button type="submit" class="am-btn am-btn-primary">保存</button></shiro:hasPermission>
                                        <button type="button" class="am-btn am-btn-danger" onclick="closeModel(false)">关闭</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../../include/bottom.jsp"%>
<script type="text/javascript" src="${ctxStatic}/3rd-lib/wangEditor/js/wangEditor.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/custom/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="${ctxStatic}/custom/js/jq.editor.js"></script>
<script type="text/javascript">
    //当前地址
    var cctx = '${pageContext.request.contextPath}';
    $(document).ready(function () {
        //消息提醒
        var msg = '${msg}';
        if (msg != '') {
            showMsg(msg);
            closeModel(true);//关闭窗口
        }
        initSelectValue(true);//初始化下拉框的值
        //初始化编辑器
        $.fn.initEditor('${ctx}','${ctxStatic}','content');


        //触发选择文件
        $("#btnPicture").click(function () {
            $("#file").click();
        });
        //选择文件后
        $("#file").change(function () {
            $.ajaxFileUpload({
                url: '${ctx}/upload/local',
                type: 'post',
                secureuri: false,
                fileElementId: 'file',
                dataType: 'text',
                success: function (data, status) {
                    data = JSON.parse(delHtmlTag(data));
                    if (data.ret == 1) {
                        $("#image").val(data.data);
                    } else {
                        alert(data.msg);
                    }
                },
                error: function (data, status, e) {
                    alert(e);
                }
            });
        });
    });
</script>
</body>
</html>
