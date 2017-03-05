<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
    <title>网站建设</title>
    <%@ include file="../../include/head.jsp"%>
    <link rel="stylesheet" href="${ctxStatic}/3rd-lib/jquery-ztree/css/zTreeStyle.css">
    <style type="text/css">
        .tpl-content-wrapper{margin-left:0}
        iframe{width: 100%;height: 100%;}
    </style>
</head>
<body>
<script src="${ctxStatic}/assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl"><a href="${ctx}/cms/category/list?siteId=${site.id}&parentId=0" target="content">网站结构</a></div>
                        </div>
                        <div class="widget-body widget-body-lg am-fr">
                            <div class="am-scrollable-horizontal">
                                <ul id="tree" class="ztree"></ul><!-- 资源树 -->
                            </div>
                        </div>
                    </div>
                </div>

                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <iframe name="content" id="content" src="${ctx}/cms/category/list?siteId=${site.id}&parentId=0" frameborder="0" scrolling="auto"></iframe>
                </div>

            </div>
        </div>
    </div>
</div>
<%@ include file="../../include/bottom.jsp"%>
<script src="${ctxStatic}/3rd-lib/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script>
    $(function () {
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback : {
                onClick : function(event, treeId, treeNode) {
                    if(treeNode.module=='nav'){
                        //导航模型
                       $("#content").attr("src","${ctx}/cms/category/list?siteId="+treeNode.siteId+"&parentId="+treeNode.id);
                    }else if(treeNode.module=='album'){
                        //相册模型
                        $("#content").attr("src","${ctx}/cms/album/list?categoryId="+treeNode.id);
                    }else if(treeNode.module=='link'){
                        //连接模型
                        $("#content").attr("src","${ctx}/cms/link/list?categoryId="+treeNode.id);
                    }else if(treeNode.module=='commodity'){
                        //商品模型
                        $("#content").attr("src","${ctx}/cms/commodity/list?categoryId="+treeNode.id);
                    }else{
                        //文章模型
                        $("#content").attr("src","${ctx}/cms/article/list?categoryId="+treeNode.id);
                    }
                }
            }
        };
        var zNodes =[
            <c:forEach items="${categoryList}" var="o" varStatus="status">
            { id:${o.id}, pId:${o.parentId}, name:"${o.name}", open:true,module:"${o.module}",siteId:${o.siteId}}<c:if test="${!status.last}">,</c:if>
            </c:forEach>
        ];
        $(document).ready(function(){
            var ztree = $.fn.zTree.init($("#tree"), setting, zNodes);
            ztree.expandAll(true);
        });
    });
</script>
</body>
</html>