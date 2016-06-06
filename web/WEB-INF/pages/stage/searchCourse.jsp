<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Klass | Course</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/stage/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/stage/button.css" rel="stylesheet" type="text/css"/>
    <link href="css/stage/module.menulist.css" rel="stylesheet" type="text/css"/>
    <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>
    <script type="text/javascript" src="js/stage/jquery.module.menulist.js"></script>
</head>
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
            <h2 style="font-size: 36px;font-family: 微软雅黑">课程列表</h2>
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
                    <div class="span12">
                        <c:if test="${fn:length(sessionScope.user_search_coulist) == 0}">
                            <div class="row" style="height: 200px">

                                <div style="width: 600px">
                                    <h1 style="font-size: 24px;font-family: 微软雅黑">无此课程</h1>
                                    <hr style="margin-top: 12px">
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${fn:length(sessionScope.user_search_coulist) != 0}">
                            <c:forEach items="${sessionScope.user_search_coulist}" var="cou">
                                <div class="row" style="height: 200px">
                                    <img src="${pageContext.request.contextPath}${cou.couImage}" class="img-rounded" width="200px" height="160px">
                                    <div style="margin-top: -150px ;margin-left: 250px">
                                        <p style="font-size: 24px;font-family: 微软雅黑">${cou.couName} </p>
                                        <p style="font-size: 12px;font-family: 微软雅黑">${cou.couInfo}</p>
                                        <br>
                                        <img src="images/stage/date.png" alt="">
                                        <a href="#" class="date" style="font-size: 16px;font-family: 微软雅黑;font-weight: bold">${cou.startTime}</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="button" href="" value="查看课程" onclick="window.location.href='detailCourse.action?couId=${cou.couId}&startTime=${cou.startTime}'"
                                               class="button button-glow button-rounded button-caution"
                                               style="font-size: 14px;font-family: 微软雅黑;font-weight: bold">
                                    </div>
                                    <div style="width: 600px">
                                        <hr style="margin-top: 12px">
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
                <!-- start blog_sidebar -->
                <div class="blog_sidebar">
                    <div class="sidebar">
                        <!-- start sap_tabs -->
                        <h4 style="font-size: large">课程分类</h4>
                        <div>
                            <ul id="accordion" class="accordion">
                                <li>
                                    <div class="link"><i class="fa fa-globe"></i>艺术人文<i class="fa fa-chevron-down"></i></div>
                                    <ul class="submenu">
                                        <c:forEach items="${sessionScope.user_coulistAll}" var="cou">
                                            <c:if test="${cou.couType =='艺术人文'}">
                                                <li><a href="searchCourse.action?couName=${cou.couName}">${cou.couName}</a></li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </li>
                                <li>
                                    <div class="link"><i class="fa fa-globe"></i>商务管理<i class="fa fa-chevron-down"></i></div>
                                    <ul class="submenu">
                                        <c:forEach items="${sessionScope.user_coulistAll}" var="cou">
                                            <c:if test="${cou.couType =='商务管理'}">
                                                <li><a href="searchCourse.action?couName=${cou.couName}">${cou.couName}</a></li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </li>
                                <li>
                                    <div class="link"><i class="fa fa-globe"></i>数学逻辑<i class="fa fa-chevron-down"></i></div>
                                    <ul class="submenu">
                                        <c:forEach items="${sessionScope.user_coulistAll}" var="cou">
                                            <c:if test="${cou.couType =='数学逻辑'}">
                                                <li><a href="searchCourse.action?couName=${cou.couName}">${cou.couName}</a></li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </li>
                                <li><div class="link"><i class="fa fa-globe"></i>计算机科学<i class="fa fa-chevron-down"></i></div>
                                    <ul class="submenu">
                                        <c:forEach items="${sessionScope.user_coulistAll}" var="cou">
                                            <c:if test="${cou.couType =='计算机科学'}">
                                                <li><a href="searchCourse.action?couName=${cou.couName}">${cou.couName}</a></li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </li>
                                <li><div class="link"><i class="fa fa-globe"></i>自然科学<i class="fa fa-chevron-down"></i></div>
                                    <ul class="submenu">
                                        <c:forEach items="${sessionScope.user_coulistAll}" var="cou">
                                            <c:if test="${cou.couType =='自然科学'}">
                                                <li><a href="searchCourse.action?couName=${cou.couName}">${cou.couName}</a></li>
                                            </c:if>
                                        </c:forEach>
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
                        <!-- start tag_nav -->
                        <h4 style="font-size: large">课程标签</h4>
                        <ul class="tag_nav">
                            <c:forEach items="${sessionScope.user_coulistAll}" var="cou">
                                <li><a href="searchCourse.action?couName=${cou.couName}">${cou.couName}</a></li>
                            </c:forEach>
                            <div class="clear"></div>
                        </ul>
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
