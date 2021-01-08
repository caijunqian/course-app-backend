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
        let courseTime=[];
        function addMoreCourseTime() {
            let classroom = $('#classroom').val()
            let weekObj = $('#weekday option:selected')
            let weekday = weekObj.val()
            let weekdayText = weekObj.text()
            let startLesson = $('#startLesson').val()
            let endLesson = $('#endLesson').val()
            courseTime.push({classroom:classroom,weekday:weekday,startLesson:startLesson,endLesson:endLesson})
            $('#tbody').append(`
                <tr>
                    <td>\${classroom}</td>
                    <td>\${weekdayText}</td>
                    <td>\${startLesson}</td>
                    <td>\${endLesson}</td>
                </tr>
            `)
        }
        function submitForm() {
            let courseName = $('#courseName').val()
            let startWeek = $('#startWeek').val()
            let endWeek = $('#endWeek').val()
            let data={
                userId:${userId},
                courseName:courseName,
                startWeek:startWeek,
                endWeek:endWeek,
                courseTimes:courseTime,
            }
            $.ajax({
                url:"${pageContext.request.contextPath}/addCourse",
                method:'post',
                contentType:'application/json',
                data:JSON.stringify(data),
                success:function () {
                    console.log("success")
                    window.location.href="${pageContext.request.contextPath}/courses/"+${userId}
                }
            })
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
            <h2 class="sub-header">添加课程</h2>
            <form class="form-horizontal" method="post">
                <fieldset>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="courseName">课程名</label>
                        <div class="col-md-4">
                            <input class="form-control" id="courseName" type="text" name="a" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="startWeek">开始周次</label>
                        <div class="col-md-4">
                            <input class="form-control" id="startWeek" type="text" name="name" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="endWeek">结束周次</label>
                        <div class="col-md-4">
                            <input class="form-control" id="endWeek" type="text" name="grade" required/>
                        </div>
                    </div>
                    <hr/>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="classroom">教室</label>
                        <div class="col-md-4">
                            <input class="form-control" id="classroom" type="text" name="classroom2" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="weekday">星期几</label>
                        <div class="col-md-4">
                            <select class="form-control" id="weekday" name="weekday2">
                                <option value="1">星期一</option>
                                <option value="2">星期二</option>
                                <option value="3">星期三</option>
                                <option value="4">星期四</option>
                                <option value="5">星期五</option>
                                <option value="6">星期六</option>
                                <option value="7">星期日</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="startLesson">起始节</label>
                        <div class="col-md-4">
                            <input class="form-control" id="startLesson" type="text" name="startLesson2" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="endLesson">终止节</label>
                        <div class="col-md-4">
                            <input class="form-control" id="endLesson" type="text" name="endLesson2" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <input class="btn btn-info" type="button" value="添加" onclick="addMoreCourseTime()"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <input class="btn btn-primary" type="button" value="提交" onclick="submitForm()"/>
                            <input class="btn btn-warning" type="reset" value="重置"/>
                        </div>
                    </div>
                </fieldset>
            </form>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>教室</th>
                        <th>星期几</th>
                        <th>起始节</th>
                        <th>终止节</th>
                    </tr>
                    </thead>
                    <tbody id="tbody">

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


