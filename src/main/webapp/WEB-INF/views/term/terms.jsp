<%--
  Created by IntelliJ IDEA.
  User: Tsai
  Date: 2020/11/29
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <%@include file="../common/head.jsp" %>
    <script type="text/javascript">
        function createTerm() {
            let content=`
            <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/term">
                <fieldset>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="id1">学年</label>
                        <div class="col-md-4">
                            <input class="form-control" id="id1" type="text" name="years" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="tel">学期</label>
                        <div class="col-md-4">
                            <select class="form-control" name="upDown">
                              <option value="0">上学期</option>
                              <option value="1">下学期</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="msg">开学时间</label>
                        <div class="col-md-4">
                            <input class="form-control" id="msg" type="text" name="openTime" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <input class="btn btn-primary" type="submit" value="提交"/>
                            <input class="btn btn-warning" type="reset" value="重置"/>
                        </div>
                    </div>
                </fieldset>
            </form>
            `
            $('#myModalLabel').text("创建新学期");
            $('#modalBody').html(content);
        }
    </script>
</head>
<body>
<%--包含header代码--%>
<%@include file="../common/header.jsp" %>
<c:set var="siderBarItem" scope="page" value="term"/>

<div class="container-fluid">
    <div class="row">
        <%--包含sider代码--%>
        <%@include file="../common/sider.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">学期查看</h2>
            <h4 class="sub-header">
                <button class="btn btn-info" data-toggle="modal" data-target="#myModal"
                        onclick="createTerm()">
                    创建新学期
                </button>
            </h4>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>学年</th>
                        <th>学期</th>
                        <th>开学时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${terms!=null && terms.size()>0}">
                        <c:forEach var="obj" items="${terms}">
                            <tr style="${obj.cur==1?"color: red":""}">
                                <td>${obj.termId}</td>
                                <td>${obj.years}</td>
                                <td>${obj.upDown==0?"上":"下"}</td>
                                <td><fmt:formatDate value="${obj.openTime}" pattern="yyyy-MM-dd"/></td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div id="modalBody" class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>


