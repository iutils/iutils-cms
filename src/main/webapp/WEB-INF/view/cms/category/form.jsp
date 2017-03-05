<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
	<title>栏目表</title>
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
							<div class="widget-title am-fl">栏目编辑</div>
						</div>
						<div class="widget-body am-fr">
							<form class="am-form tpl-form-border-form" data-am-validator modelAttribute="category" action="${ctx}/cms/category/<c:choose><c:when test="${empty category.id}">create</c:when><c:otherwise>update</c:otherwise></c:choose>" method="post">
								<input type="hidden" name="id" value="${category.id}" />
								<input type="hidden" name="siteId" value="${category.siteId}" />
								<input type="hidden" name="parentId" value="${category.parentId}" />
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">栏目名称：</label>
									<div class="am-u-sm-9">
										<input type="text" name="name" placeholder="栏目名称"
											   value="${category.name}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">栏目类型：</label>
									<div class="am-u-sm-9">
										<select name="module" data="${category.module}">
											<c:forEach items="${modules}" var="m">
												<option value="${m}">${m.info}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">自定义视图：</label>
									<div class="am-u-sm-9">
										<input type="text" name="customView" placeholder="自定义访问路径"
											   value="${category.customView}" />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">首页显示：</label>
									<div class="am-u-sm-9">
										<select name="showHome" data="${category.showHome}">
											<option value="false">否</option>
											<option value="true">是</option>
										</select>
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">有下级导航：</label>
									<div class="am-u-sm-9">
										<select name="isBy" data="${category.isBy}">
											<option value="false">否</option>
											<option value="true">是</option>
										</select>
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">排序：</label>
									<div class="am-u-sm-9">
										<input type="number" name="sort" placeholder="排序"
											   value="${category.sort}" />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">备注信息：</label>
									<div class="am-u-sm-9">
										<textarea rows="5" name="remarks" placeholder="备注信息">${category.remarks}</textarea>
									</div>
								</div>
								<div class="am-form-group">
									<div class="am-u-sm-9 am-u-sm-push-3">
										<shiro:hasPermission name="cms:category:update"><button type="submit" class="am-btn am-btn-primary">保存</button></shiro:hasPermission>
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
<script type="text/javascript">
	$(document).ready(function() {
		//消息提醒
		var msg = '${msg}';
		if(msg!=''){
			showMsg(msg);
			closeModel(true);//关闭窗口
		}
		initSelectValue(true);//初始化下拉框的值
	});
</script>
</body>
</html>
