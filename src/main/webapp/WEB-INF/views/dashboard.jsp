<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tsai
  Date: 2020/11/28
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="./common/head.jsp" %>

<%--    <script type="text/javascript">--%>
<%--        &lt;%&ndash;    根据登录的账号类型，决定显示哪个主界面    &ndash;%&gt;--%>
<%--        $(function () {--%>
<%--            if ('${sessionScope.ROLE}' === '仓库管理员')--%>
<%--                $('#sales').css('display', 'none');--%>
<%--            else--%>
<%--                $('#store').css('display', 'none');--%>
<%--        });--%>
<%--    </script>--%>
</head>
<body>
<%--包含header代码--%>
<%@include file="./common/header.jsp" %>
<c:set var="siderBarItem" scope="page" value="dashboard"/>


<c:choose>
    <c:when test="${sessionScope.ROLE=='销售管理员'}">
        <div id="sales" class="container-fluid">
            <div class="row">
                    <%--包含sider代码--%>
                <%@include file="./common/sider.jsp" %>

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Dashboard</h1>

                    <div class="row placeholders">
                        <div class="col-xs-6 col-sm-3 placeholder">
                            <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
                                 width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                            <h4>Label</h4>
                            <span class="text-muted">Something else</span>
                        </div>
                        <div class="col-xs-6 col-sm-3 placeholder">
                            <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
                                 width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                            <h4>Label</h4>
                            <span class="text-muted">Something else</span>
                        </div>
                        <div class="col-xs-6 col-sm-3 placeholder">
                            <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
                                 width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                            <h4>Label</h4>
                            <span class="text-muted">Something else</span>
                        </div>
                        <div class="col-xs-6 col-sm-3 placeholder">
                            <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
                                 width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                            <h4>Label</h4>
                            <span class="text-muted">Something else</span>
                        </div>
                    </div>

                    <h2 class="sub-header">销售员</h2>
                    <h4 class="sub-header">成交金额排名统计</h4>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>姓名</th>
                                <th>成交金额</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${statsOfSale!=null && statsOfSale.size()>0}">
                                <c:forEach var="obj" items="${statsOfSale}">
                                    <tr>
                                        <td>${obj.id}</td>
                                        <td>${obj.name}</td>
                                        <td>${obj.total==null?0:obj.total}</td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>
                    </div>

                    <h2 class="sub-header">客户</h2>
                    <h4 class="sub-header">成交金额排名统计</h4>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>姓名</th>
                                <th>成交金额</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${statsOfClient!=null && statsOfClient.size()>0}">
                                <c:forEach var="obj" items="${statsOfClient}">
                                    <tr>
                                        <td>${obj.id}</td>
                                        <td>${obj.name}</td>
                                        <td>${obj.total==null?0:obj.total}</td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>
                    </div>

                    <h2 class="sub-header">商品</h2>
                    <h4 class="sub-header">成交量排名统计</h4>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>名称</th>
                                <th>成交量</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${statsOfGoods!=null && statsOfGoods.size()>0}">
                                <c:forEach var="obj" items="${statsOfGoods}">
                                    <tr>
                                        <td>${obj.id}</td>
                                        <td>${obj.name}</td>
                                        <td>${obj.total==null?0:obj.total}</td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div id="store" class="container-fluid">
            <div class="row">
                    <%--包含sider代码--%>
                <%@include file="./common/sider2.jsp" %>

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Dashboard</h1>

                    <div class="row placeholders">
                        <div class="col-xs-6 col-sm-3 placeholder">
                            <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
                                 width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                            <h4>Label</h4>
                            <span class="text-muted">Something else</span>
                        </div>
                        <div class="col-xs-6 col-sm-3 placeholder">
                            <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
                                 width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                            <h4>Label</h4>
                            <span class="text-muted">Something else</span>
                        </div>
                        <div class="col-xs-6 col-sm-3 placeholder">
                            <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
                                 width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                            <h4>Label</h4>
                            <span class="text-muted">Something else</span>
                        </div>
                        <div class="col-xs-6 col-sm-3 placeholder">
                            <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
                                 width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                            <h4>Label</h4>
                            <span class="text-muted">Something else</span>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>





</body>
</html>
