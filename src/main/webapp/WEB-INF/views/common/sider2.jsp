<%--
  Created by IntelliJ IDEA.
  User: Tsai
  Date: 2020/11/29
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--处理侧边栏选中时的active问题--%>
<script type="text/javascript">
    $(function () {
        $('#${pageScope.siderBarItem}').addClass('active');
    });
</script>

<div class="col-sm-3 col-md-2 sidebar">
    <ul class="nav nav-sidebar">
        <li id="dashboard"><a href="${pageContext.request.contextPath}/home">控制面板 <span class="sr-only">(current)</span></a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li id="goods"><a href="${pageContext.request.contextPath}/goods">商品管理</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li id="invoices2"><a href="${pageContext.request.contextPath}/invoices2">发货单</a></li>
        <li id="purchase"><a href="${pageContext.request.contextPath}/purchase">进货单</a></li>
    </ul>

</div>
