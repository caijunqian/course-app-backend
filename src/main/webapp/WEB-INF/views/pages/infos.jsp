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
        function createNew() {
            let content=`
            <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/info/addInfo">
                <fieldset>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="id1">学号</label>
                        <div class="col-md-4">
                            <input class="form-control" id="id1" type="text" name="num" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="id12">姓名</label>
                        <div class="col-md-4">
                            <input class="form-control" id="id12" type="text" name="name" required/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="msg">年级</label>
                        <div class="col-md-4">
                            <input class="form-control" id="msg" type="text" name="grade" required/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="msg2">班级</label>
                        <div class="col-md-4">
                            <input class="form-control" id="msg2" type="text" name="classes" required/>
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
            $('#myModalLabel').text("添加学生");
            $('#modalBody').html(content);
        }
    </script>
</head>
<body>
<%--包含header代码--%>
<%@include file="../common/header.jsp" %>
<c:set var="siderBarItem" scope="page" value="info"/>

<div class="container-fluid">
    <div class="row">
        <%--包含sider代码--%>
        <%@include file="../common/sider.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">学生查看</h2>
            <h4 class="sub-header">
                <button class="btn btn-info" data-toggle="modal" data-target="#myModal"
                        onclick="createNew()">
                    添加新学生
                </button>
            </h4>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>年级</th>
                        <th>班级</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${infos!=null && infos.size()>0}">
                        <c:forEach var="obj" items="${infos}">
                            <tr>
                                <td>${obj.userId}</td>
                                <td>${obj.num}</td>
                                <td>${obj.name}</td>
                                <td>${obj.grade}</td>
                                <td>${obj.classes}</td>
                                <td>
                                    <button class="btn btn-info" onclick="window.location.href='${pageContext.request.contextPath}/courses/${obj.userId}'">查看课程</button>
                                    <button class="btn btn-info" onclick="window.location.href='${pageContext.request.contextPath}/items/${obj.userId}'">查看事件</button>
                                </td>
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


