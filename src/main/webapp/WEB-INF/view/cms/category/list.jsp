<%@ page contentType="text/html;charset=UTF-8"%>
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
							<div class="widget-title am-fl">栏目管理</div>
						</div>
						<div class="widget-body am-fr">
							<div class="am-u-sm-12 am-u-md-3 am-u-lg-3">
								<div class="am-btn-toolbar">
									<div class="am-btn-group am-btn-group-xs">
										<shiro:hasPermission name="cms:category:create"><button type="button" class="am-btn am-btn-default am-btn-success"
												onclick="openModel(false,'${ctx}/cms/category/create?siteId=${page.entity.siteId}&parentId=${page.entity.parentId}')"><span class="am-icon-plus"></span> 新增
										</button></shiro:hasPermission>
									</div>
								</div>
							</div>
							<div class="am-u-sm-12 am-u-md-9 am-u-lg-9">
								<form id="searchForm" action="${ctx}/cms/category/list?siteId=${page.entity.siteId}&parentId=${page.entity.parentId}" method="post">
									<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
									<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
								</form>
							</div>
							<div class="am-u-sm-12">
								<table id="contentTable" class="am-table am-table-compact am-table-striped tpl-table-black">
									<thead>
									<tr>
										<th>栏目名称</th>
										<th>模块类型</th>
										<th>自定义视图</th>
										<th>首页显示</th>
										<th>有下级导航</th>
										<th>排序</th>
										<th>更新时间</th>
										<th>备注信息</th>
										<th>操作</th>
									</tr>
									</thead>
									<tbody>
									<c:forEach items="${page.list}" var="category">
										<tr>
											<td>${category.name}</td>
											<td>${category.module.info}</td>
											<td>${category.customView}</td>
											<td>${category.showHome?"是":"否"}</td>
											<td>${category.isBy?"是":"否"}</td>
											<td>${category.sort}</td>
											<td><fmt:formatDate value="${category.updateDate}"
																pattern="MM-dd HH:mm" /></td>
											<td>${category.remarks}</td>
											<td>
												<shiro:hasPermission name="cms:category:update"><a href="javascript:;" onclick="openModel(false,'${ctx}/cms/category/update?id=${category.id}')" title="编辑"><span class="am-icon-pencil"></span></a></shiro:hasPermission>
												<shiro:hasPermission name="cms:category:delete"><a href="${ctx}/cms/category/delete?id=${category.id}&pageNo=${page.pageNo}&pageSize=${page.pageSize}"
													onclick="return confirm('确认要删除该条数据吗？', this.href)" title="删除"><span class="am-text-danger am-icon-trash-o"></span></a></shiro:hasPermission></td>
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
			//刷新
			parent.location.reload();
		}
	});
</script>
</body>
</html>
