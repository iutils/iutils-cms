<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
	<title>站点管理</title>
	<%@ include file="../../include/head.jsp"%>
	<style>
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
							<div class="widget-title am-fl">站点管理</div>
						</div>
						<div class="widget-body am-fr">
							<div class="am-u-sm-12 am-u-md-3 am-u-lg-3">
								<div class="am-btn-toolbar">
									<div class="am-btn-group am-btn-group-xs">
										<shiro:hasPermission name="cms:site:create"><button type="button" class="am-btn am-btn-default am-btn-success"
												onclick="openModel(false,'${ctx}/cms/site/create')"><span class="am-icon-plus"></span> 新增
										</button></shiro:hasPermission>
									</div>
								</div>
							</div>
							<div class="am-u-sm-12 am-u-md-9 am-u-lg-9">
								<form id="searchForm" action="${ctx}/cms/site" method="post">
									<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
									<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
								</form>
							</div>
							<div class="am-u-sm-12">
								<table id="contentTable" class="am-table am-table-compact am-table-striped tpl-table-black">
									<thead>
									<tr>
										<th>站点名称</th>
										<th>主题</th>
										<th>关键字</th>
										<th>更新时间</th>
										<th>操作</th>
									</tr>
									</thead>
									<tbody>
									<c:forEach items="${page.list}" var="site">
										<tr>
											<td><a href="${ctxF}?id=${site.id}" target="_blank" title="打开网站">${site.name}<c:if test="${site.isDefault}">（默认）</c:if></a></td>
											<td>${site.theme}</td>
											<td>${site.keywords}</td>
											<td><fmt:formatDate value="${site.updateDate}"
																pattern="yyyy-MM-dd HH:mm:ss" /></td>
											<td>
												<c:if test="${!site.isDefault}">
													<shiro:hasPermission name="cms:site:default"><a href="${ctx}/cms/site/${site.id}/default?pageNo=${page.pageNo}&pageSize=${page.pageSize}"
													   onclick="return confirm('确认要设置该网站为默认吗？', this.href)" title="设置默认"><span class="am-text-warning am-icon-heart-o"></span></a></shiro:hasPermission>
												</c:if>
												<shiro:hasPermission name="cms:site:build"><a href="${ctx}/cms/site/build?id=${site.id}" title="网站建设"><span class="am-text-success am-icon-sitemap"></span></a></shiro:hasPermission>
												<shiro:hasPermission name="cms:site:update"><a href="javascript:;" onclick="openModel(false,'${ctx}/cms/site/update?id=${site.id}')" title="编辑"><span class="am-icon-pencil"></span></a></shiro:hasPermission>
												<shiro:hasPermission name="cms:site:delete"><a href="${ctx}/cms/site/${site.id}/delete?pageNo=${page.pageNo}&pageSize=${page.pageSize}"
													onclick="return confirm('确认要删除该网站吗？', this.href)" title="删除"><span class="am-text-danger am-icon-trash-o"></span></a></shiro:hasPermission></td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="am-u-lg-12 am-cf">
								<%@ include file="../../utils/pagination.jsp" %>
							</div>

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
		var msg = '${msg}';
		if(msg!=''){
			showMsg(msg);
		}
	});
</script>
</body>
</html>
