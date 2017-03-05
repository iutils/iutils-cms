<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fnc" uri="/WEB-INF/tld/fnc.tld" %>
<%@taglib prefix="cms" uri="/WEB-INF/tld/cms.tld" %>
<%--<%@taglib prefix="faq" uri="/WEB-INF/tld/faq.tld" %>--%>
<c:set var="ctx" value="${pageContext.request.contextPath}${fnc:getConfig('adminPath')}"/>
<c:set var="ctxF" value="${pageContext.request.contextPath}${fnc:getConfig('frontPath')}"/>
<c:set var="rest" value="${pageContext.request.contextPath}${fnc:getConfig('restPath')}"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>
<c:set var="urlSuffix" value="${fnc:getConfig('urlSuffix')}"/>
<c:set var="dataSuffix" value="${fnc:getConfig('dataSuffix')}"/>