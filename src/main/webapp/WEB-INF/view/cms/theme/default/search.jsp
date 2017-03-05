<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/view/cms/theme/include/taglib.jsp" %>
<html>
<head>
    <title>${site.name} - 搜索</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="am-container">
    <div class="content" id="content">
        <!-- 模块排版 -->
        <div class="am-g">
            <div class="am-u-sm-12" style="padding: 0px;">
                <div class="am-panel am-panel-default">
                    <c:set var="searchKey" value="<span style=color:red;>${page.key}</span>"></c:set>
                    <div class="title"><span>【${empty page.key?'全部':searchKey}】共搜索到${page.total}结果</span></div>
                    <div class="am-panel-bd" style="padding-bottom:30px;">
                        <!-- 文章内容 -->
                        <div id="blog-body">
                            <c:forEach items="${page.list}" var="article">
                                <article class="am-article">
                                    <div class="am-article-hd">
                                        <h1 class="am-article-title">
                                            <div class="category"><span>${article.category.name}</span></div>
                                                ${fn:replace(article.title,page.key, searchKey)}</h1>
                                        <p class="am-article-meta"><a href="#">${article.user.name}</a> <fmt:formatDate
                                                value="${article.updateDate}" pattern="yyyy-MM-dd"/></p>
                                    </div>
                                    <div class="am-article-bd">
                                            ${fn:replace(article.articleData.content,page.key, searchKey)}
                                    </div>
                                </article>
                                <hr>
                            </c:forEach>
                        </div>
                        <%@ include file="../../../utils/pagination.jsp"%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>