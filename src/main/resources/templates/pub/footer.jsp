<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/pub/include.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="prourl" value="<%=basePath%>"></c:set>
<c:set var="proname" value="${pageContext.request.contextPath}"></c:set>
<div class="container" style="margin-top: 0px;">
    <div id="footer"><p>免责声明:如果侵犯了你的权益，请发邮件至：<fmt:message key="author"/>，我们会及时删除侵权内容，谢谢合作！</p>
        <p>Copyright © <f:formatDate value="<%=new Date()%>" pattern="yyyy"/> 蜀ICP备16028726号 <f:formatDate value="<%=new Date()%>" pattern="yyyy"/> All Rights Reserved.
            <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1272902876'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s19.cnzz.com/z_stat.php%3Fid%3D1272902876%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script>
        </p>
    </div>
</div>
