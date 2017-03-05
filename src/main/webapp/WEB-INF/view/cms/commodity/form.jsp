<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
	<title>商品表</title>
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
							<div class="widget-title am-fl">商品编辑</div>
						</div>
						<div class="widget-body am-fr">
							<form class="am-form tpl-form-border-form" data-am-validator modelAttribute="commodity" action="${ctx}/cms/commodity/<c:choose><c:when test="${empty commodity.id}">create</c:when><c:otherwise>update</c:otherwise></c:choose>" method="post">
								<input type="hidden" name="id" value="${commodity.id}" />
								<input type="hidden" name="categoryId" value="${commodity.categoryId}" />
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">商品货号：</label>
									<div class="am-u-sm-9">
										<input type="text" name="sn" placeholder="商品货号"
											   value="${commodity.sn}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">商品名称：</label>
									<div class="am-u-sm-9">
										<input type="text" name="name" placeholder="商品名称"
											   value="${commodity.name}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">品牌编号：</label>
									<div class="am-u-sm-9">
										<input type="text" name="brandId" placeholder="品牌编号"
											   value="${commodity.brandId}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">商品图片：</label>
									<div class="am-u-sm-9">
										<input type="text" name="img" placeholder="商品图片"
											   value="${commodity.img}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">商品价格：</label>
									<div class="am-u-sm-9">
										<input type="number" name="price" placeholder="商品价格"
											   value="${commodity.price}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">市场价格：</label>
									<div class="am-u-sm-9">
										<input type="number" name="market" placeholder="市场价格"
											   value="${commodity.market}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">商品库存：</label>
									<div class="am-u-sm-9">
										<input type="number" name="amount" placeholder="商品库存"
											   value="${commodity.amount}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">上架时间：</label>
									<div class="am-u-sm-9">
										<input type="text" name="time" data-am-datepicker placeholder="上架时间"
											   value="${commodity.time}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">上市时间：</label>
									<div class="am-u-sm-9">
										<input type="text" name="marketime" data-am-datepicker placeholder="上市时间"
											   value="${commodity.marketime}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">商品颜色：</label>
									<div class="am-u-sm-9">
										<input type="text" name="colour" placeholder="商品颜色"
											   value="${commodity.colour}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">是否上架：</label>
									<div class="am-u-sm-9">
										<select name="isShop" data="${commodity.isShop}">
											<option value="false">否</option>
											<option value="true">是</option>
										</select>
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">是否推荐：</label>
									<div class="am-u-sm-9">
										<select name="isRec" data="${commodity.isRec}">
											<option value="false">否</option>
											<option value="true">是</option>
										</select>
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">购买次数：</label>
									<div class="am-u-sm-9">
										<input type="number" name="count" placeholder="购买次数"
											   value="${commodity.count}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">是否新品：</label>
									<div class="am-u-sm-9">
										<select name="isNew" data="${commodity.isNew}">
											<option value="false">否</option>
											<option value="true">是</option>
										</select>
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">是否热卖：</label>
									<div class="am-u-sm-9">
										<select name="isHot" data="${commodity.isHot}">
											<option value="false">否</option>
											<option value="true">是</option>
										</select>
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">排序：</label>
									<div class="am-u-sm-9">
										<input type="text" name="sort" placeholder="排序"
											   value="${commodity.sort}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">商品描述：</label>
									<div class="am-u-sm-9">
										<input type="text" name="description" placeholder="商品描述"
											   value="${commodity.description}" required />
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">备注：</label>
									<div class="am-u-sm-9">
										<textarea rows="5" name="remarks" placeholder="备注信息">${commodity.remarks}</textarea>
									</div>
								</div>
								<div class="am-form-group">
									<div class="am-u-sm-9 am-u-sm-push-3">
									<shiro:hasPermission name="cms:commodity:update"><button type="submit" class="am-btn am-btn-primary">保存</button></shiro:hasPermission>
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
	});
</script>
</body>
</html>
