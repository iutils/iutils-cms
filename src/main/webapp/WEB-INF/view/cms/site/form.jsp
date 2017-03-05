<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
	<title>站点编辑</title>
	<%@ include file="../../include/head.jsp"%>
	<style type="text/css">
		.tpl-content-wrapper{margin-left:0}
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
							<div class="widget-title am-fl">站点编辑</div>
						</div>
						<div class="widget-body am-fr">
							<form class="am-form tpl-form-border-form" data-am-validator modelAttribute="site" action="${ctx}/cms/site/<c:choose><c:when test="${empty site.id}">create</c:when><c:otherwise>update</c:otherwise></c:choose>" method="post">
								<input type="hidden" name="id" value="${site.id}" />
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">网站名称：</label>
									<div class="am-u-sm-9">
										<input type="text" name="name" placeholder="如：程序员工具"
											   value="${site.name}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">网站图标：</label>
									<div class="am-u-sm-9">
										<div class="am-input-group">
											<input type="text" id="logo" name="logo" class="am-form-field" placeholder="网站Logo"
												   value="${site.logo}" readonly />
							      <span class="am-input-group-btn">
							      	<input type="file" name="file" id="filelogo" style="display: none;" />
							        <button class="am-btn am-btn-default" id="btnLogo" type="button">上传图片</button>
							      </span>
										</div>
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">小图标：</label>
									<div class="am-u-sm-9">
										<div class="am-input-group">
											<input type="text" id="icon" name="icon" class="am-form-field" placeholder="网站Logo"
												   value="${site.icon}" readonly />
							      <span class="am-input-group-btn">
							      	<input type="file" name="file" id="fileicon" style="display: none;" />
							        <button class="am-btn am-btn-default" id="btnIcon" type="button">上传图片</button>
							      </span>
										</div>
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">网站主题：</label>
									<div class="am-u-sm-9">
										<select name="theme" data="${site.theme}">
											<option value="default">默认主题</option>
										</select>
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">网站域名：</label>
									<div class="am-u-sm-9">
										<input type="text" name="domain" placeholder="如：iutils.cn"
											   value="${site.domain}" />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">关键字：</label>
									<div class="am-u-sm-9">
										<input type="text" name="keywords" placeholder="如：程序员工具"
											   value="${site.keywords}" />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">网站描述：</label>
									<div class="am-u-sm-9">
										<textarea rows="3" name="description" placeholder="网站描述">${site.description}</textarea>
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">版权信息：</label>
									<div class="am-u-sm-9">
										<input type="text" name="copyright" placeholder="如：CopyRight©2016 iutils.cn All Rights Reserved."
											   value="${site.copyright}" />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">备注信息：</label>
									<div class="am-u-sm-9">
										<textarea rows="3" name="remarks" placeholder="备注信息">${site.remarks}</textarea>
									</div>
								</div>
								<div class="am-form-group">
									<div class="am-u-sm-9 am-u-sm-push-3">
<shiro:hasPermission name="cms:site:update"><button type="submit" class="am-btn am-btn-primary">保存</button></shiro:hasPermission>
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
		initSelectValue(true);//初始化下拉框的值
		//触发选择文件
		$("#btnLogo").click(function(){
			$("#filelogo").click();
		});
		$("#btnIcon").click(function(){
			$("#fileicon").click();
		});
		//选择文件后
		$("#filelogo").change(function(){
			$.ajaxFileUpload({
					url: '${ctx}/upload/local',
					type: 'post',
					secureuri: false,
					fileElementId: 'filelogo',
					dataType: 'text',
					success: function (data, status)
					{
						data = JSON.parse(delHtmlTag(data));
						if(data.ret==1){
							$("#logo").val(data.data);
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
		$("#fileicon").change(function(){
			$.ajaxFileUpload({
					url: '${ctx}/upload/local',
					type: 'post',
					secureuri: false,
					fileElementId: 'fileicon',
					dataType: 'text',
					success: function (data, status)
					{
						data = JSON.parse(delHtmlTag(data));
						if(data.ret==1){
							$("#icon").val(data.data);
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
