<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Klass | User</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/stage/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/stage/button.css" rel="stylesheet" type="text/css"/>
    <link href="css/stage/module.menulist.css" rel="stylesheet" type="text/css"/>
    <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>
    <script type="text/javascript" src="js/stage/jquery.module.menulist.js"></script>
</head>

<c:if test="${sessionScope.result_edit_user != null}">
    <script  type="text/javascript">
        var msg = "${sessionScope.result_edit_user}"
        if(msg == "true"){
            alert("Success! 修改个人资料成功！")
        }
        if(msg == "false"){
            alert("Error! 修改个人资料失败！")
        }
    </script>
</c:if>
<c:remove var="result_edit_user" scope="session" />

<body>
<!-- start header -->
<div class="header_bg">
    <div class="wrap">
        <%@ include file="/common/stage/header.jsp"%>
        <div class="clear"></div>
    </div>
</div>
<!-- start slider -->
<div class="slider_bg">
    <div class="wrap">
        <div class="slider">
            <h2 style="font-size: 36px;font-family: 微软雅黑">${sessionScope.user.userName} 的个人主页</h2>
        </div>
    </div>
</div>
<!-- start main -->
<div class="main_bg">
    <div class="wrap">
        <div class="main">
            <div class="content">
                <!-- start blog_left -->
                <div class="blog_left">
                    <h2 style="font-size: 20px;font-family: 微软雅黑;font-weight: bold">作业列表</h2>
                    <br>
                    <div class="span12">
                        <c:forEach items="${sessionScope.user_index_homeworkList}" var="homework">
                            <div class="row" style="height: 80px">
                                <c:if test="${homework[5] == 0}">
                                    <div style="margin-top: 0px ;margin-left: -10px">
                                        <span class="glyphicon glyphicon-star" style="font-size: 20px;color: red"></span>
                                    </div>
                                </c:if>
                                <div style="margin-top: 0px ;margin-left: 0px">
                                    <p style="font-size: 20px;font-family: 微软雅黑">${homework[3]} </p>
                                </div>
                                <div style="margin-top: -52px ;margin-left: 150px">
                                    <p style="font-size: 20px;font-family: 微软雅黑">${homework[6]}</p>
                                </div>
                                <div style="margin-top: -45px ;margin-left: 300px">
                                    <img src="images/stage/date.png" alt="">
                                    <a class="date" style="font-size: 20px;font-family: 微软雅黑;font-weight: bold">${homework[2]}</a>
                                </div>
                                <div style="margin-top: -30px ;margin-left: 550px">
                                    <input type="button" href="" value="查看作业" onclick="window.location.href='showHomework.action?workId=${homework[0]}&userId=${sessionScope.user.userId}&fileUrl=${homework[4]}'"
                                           class="button button-glow button-rounded button-caution"
                                           style="font-size: 14px;font-family: 微软雅黑;font-weight: bold">
                                </div>
                                <div style="width: 700px">
                                    <hr style="margin-top: 5px">
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <!-- start blog_sidebar -->
                <div class="blog_sidebar">
                    <div class="sidebar">
                        <!-- start sap_tabs -->
                        <h4 style="font-size: large">信息管理</h4>
                        <div>
                            <ul id="accordion" class="accordion">
                                <li>
                                    <div class="link"><i class="fa fa-globe"></i>个人课程<i class="fa fa-chevron-down"></i></div>
                                    <ul class="submenu">
                                        <c:forEach items="${sessionScope.user_index_courseList}" var="cou">
                                            <li><a href="detailCourse.action?couId=${cou[0]}&startTime=${cou[2]}">${cou[1]}&nbsp;&nbsp;${cou[2]}</a></li>
                                        </c:forEach>
                                    </ul>
                                </li>
                                <li>
                                    <div class="link"><i class="fa fa-globe"></i>个人信息管理<i class="fa fa-chevron-down"></i></div>
                                    <ul class="submenu">
                                        <li><a href="editUserInfo.action?userId=${sessionScope.user.userId}">个人信息更改</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>

                        <script src="js/stage/jquery.min.js"></script>
                        <script src="js/stage/easyResponsiveTabs.js" type="text/javascript"></script>
                        <script type="text/javascript">
                            $(document).ready(function () {
                                $('#horizontalTab').easyResponsiveTabs({
                                    type: 'default', //Types: default, vertical, accordion
                                    width: 'auto', //auto or any width like 600px
                                    fit: true   // 100% fit in a container
                                });
                            });
                        </script>
                        <!-- end sap_tabs -->
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
</div>
<div>
    <%@ include file="/common/stage/footer.jsp"%>
</div>
</body>
</html>
