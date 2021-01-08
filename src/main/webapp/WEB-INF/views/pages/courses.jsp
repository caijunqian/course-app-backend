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
            <h2 class="sub-header">课程查看</h2>
            <h4 class="sub-header">
                <button class="btn btn-info" onclick="window.location.href='${pageContext.request.contextPath}/toAddCourse/${userId}'">
                    添加新课程
                </button>
            </h4>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>课程名</th>
                        <th>开始周数</th>
                        <th>结束周数</th>
                        <th>上课时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${courses!=null && courses.size()>0}">
                        <c:forEach var="obj" items="${courses}">
                            <tr>
                                <td>${obj.userId}</td>
                                <td>${obj.courseName}</td>
                                <td>${obj.startWeek}</td>
                                <td>${obj.endWeek}</td>
                                <td>
                                    <c:if test="${obj.courseTimes!=null && obj.courseTimes.size()>0}">
                                        <c:forEach var="obj" items="${obj.courseTimes}">
                                            星期${obj.weekday}
                                            ${obj.startLesson}-${obj.endLesson}节
                                            ${obj.classroom}<br>
                                        </c:forEach>
                                    </c:if>

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


