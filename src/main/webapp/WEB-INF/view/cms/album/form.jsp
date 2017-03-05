<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
	<title>相册表</title>
	<%@ include file="../../include/head.jsp"%>
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
							<div class="widget-title am-fl">相册编辑</div>
						</div>
						<div class="widget-body am-fr">
							<form class="am-form tpl-form-border-form" data-am-validator modelAttribute="album" action="${ctx}/cms/album/<c:choose><c:when test="${empty album.id}">create</c:when><c:otherwise>update</c:otherwise></c:choose>" method="post">
								<input type="hidden" name="id" value="${album.id}" />
								<input type="hidden" name="categoryId" value="${album.categoryId}" />
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">标题：</label>
									<div class="am-u-sm-9">
										<input type="text" name="title" placeholder="标题"
											   value="${album.title}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">图片地址：</label>
									<div class="am-u-sm-9">
										<div class="am-input-group">
											<input type="text" id="image" name="image" class="am-form-field" placeholder="图片地址"
												   value="${album.image}"/>
									  <span class="am-input-group-btn">
										<input type="file" name="file" id="file" style="display: none;"/>
										<button class="am-btn am-btn-default" id="btnPicture" type="button">上传图片
										</button>
									  </span>
										</div>
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">备注：</label>
									<div class="am-u-sm-9">
										<textarea rows="5" name="remarks" placeholder="备注信息">${album.remarks}</textarea>
									</div>
								</div>
								<div class="am-form-group">
									<div class="am-u-sm-9 am-u-sm-push-3">
										<shiro:hasPermission name="cms:album:update"><button type="submit" class="am-btn am-btn-primary">保存</button></shiro:hasPermission>
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
<script type="text/javascript" src="${ctxStatic}/custom/js/ajaxfileupload.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//消息提醒
		var msg = '${msg}';
		if(msg!=''){
			showMsg(msg);
			closeModel(true);//关闭窗口
		}
		//触发选择文件
		$("#btnPicture").click(function(){
			$("#file").click();
		});
		//选择文件后
		$("#file").change(function(){
			$.ajaxFileUpload({
				url: '${ctx}/upload/local',
				type: 'post',
				secureuri: false,
				fileElementId: 'file',
				dataType: 'text',
				success: function (data, status)
				{
					data = JSON.parse(delHtmlTag(data));
					if(data.ret==1){
						$("#image").val(data.data);
					}else{
						alert(data.msg);
					}
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			});
		});
	});
</script>
</body>
</html>
