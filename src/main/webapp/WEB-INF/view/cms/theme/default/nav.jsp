<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/view/cms/theme/include/taglib.jsp" %>
<html>
<head>
    <title>${site.name} - ${category.name}</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="am-container">
    <div class="content" id="content">
        <!-- 模块排版 -->
        <div class="am-g">
            <div class="am-u-sm-9" style="padding: 0px;padding-right: 1.1em;">
                <div class="am-panel am-panel-default" style="margin-top: 20px;">
                    <c:if test="${not empty categorys}">
                    <div class="title"><span>${categorys[0].name}</span></div>
                    <div class="am-panel-bd">
                        <!-- 文章内容 -->
                        <div id="blog-body">
                            <c:set var="categoryId" value="${param.categoryId}" />
                            <c:set var="docs" value="${cms:getArticleList(categoryId,1)}"/>
                            <c:forEach items="${docs}" var="doc">
                                ${doc.articleData.content}
                            </c:forEach>
                        </div>
                    </div>
                    </c:if>
                </div>
            </div>
            <div class="am-u-sm-3" style="padding: 0px;">
                <div class="am-panel am-panel-default" style="margin-top: 20px;">
                    <c:forEach var="categoryNext" items="${categoryNexts}">
                        <div class="title"><span>${categoryNext.name}</span></div>
                        <div class="am-panel-bd">
                            <ul class="am-list am-list-static class-list">
                                <c:forEach items="${cms:getNavListBy(categoryNext.id)}" var="nav" varStatus="status">
                                    <li style="padding:0;"><a href="${ctxF}/${category.id}/nav${urlSuffix}?categoryId=${nav.id}<c:if test="${not empty param.id}">&id=${param.id}</c:if>" class="am-text-truncate" <c:if test="${nav.id==param.categoryId}">style="color:#DD514C;"</c:if>><c:if test="${nav.id==param.categoryId}"><i class="am-icon-hand-o-right"></i></c:if> ${nav.name} </a> <a href="${ctxF}/${category.id}/${nav.id}/share${urlSuffix}<c:if test="${not empty param.id}">?id=${param.id}</c:if>" style="float:right;margin-top:-50px;border-bottom:none;"></a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>