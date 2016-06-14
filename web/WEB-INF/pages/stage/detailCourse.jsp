<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Klass | CourseInfo</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/stage/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/stage/module.menulist.css" rel="stylesheet" type="text/css"/>
    <link href="css/stage/button.css" rel="stylesheet" type="text/css"/>
    <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>
    <script type="text/javascript" src="js/stage/jquery.module.menulist.js"></script>
</head>

<c:if test="${sessionScope.result_joinInCourse != null}">
    <script  type="text/javascript">
        var msg = "${sessionScope.result_joinInCourse}"
        if(msg == "true"){
            alert("Success! 加入课程成功！")
        }
        if(msg == "false"){
            alert("Error! 加入课程失败！")
        }
    </script>
</c:if>
<c:remove var="result_joinInCourse" scope="session" />

<c:if test="${sessionScope.result_joinOutCourse != null}">
    <script  type="text/javascript">
        var msg = "${sessionScope.result_joinOutCourse}"
        if(msg == "true"){
            alert("Success! 退出课程成功！")
        }
        if(msg == "false"){
            alert("Error! 退出课程失败！")
        }
    </script>
</c:if>
<c:remove var="result_joinOutCourse" scope="session" />

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
            <h2 style="font-size: 36px;font-family: 微软雅黑;padding-bottom: 10px;margin-top: -60px">${sessionScope.detail_course_course.couName}</h2>
            <h2 style="font-size: 18px;font-family: 微软雅黑">${sessionScope.detail_course_course.startTime}</h2>
        </div>
    </div>
</div>

<style type="text/css">
    #myDiv{
        font-family: Arial;
        border: 2px solid #379082;
        border-radius: 20px;
        padding: 30px 30px;
        width: 330px;
        height: auto;
        background-color: whitesmoke;
        margin-left: -170px;
        margin-top: -710px;
    }
</style>
<!-- start main -->
<div class="main_bg">
    <div class="wrap">
        <div class="main">
            <div class="content" style="height: 900px">
                <div id="pdf" style="margin-left:200px;margin-top:0px;width: 880px;height: 710px">
                </div>
                <c:if test="${param.file != null}">
                    <div style="margin-left: 200px;margin-top: 20px">
                        <a href="downLoad.action?fileUrl=${param.file}"
                           class="button button-glow button-rounded button-raised button-primary" style="font-family: 微软雅黑">下载该资源文件</a>
                    </div>
                </c:if>


                <div id="myDiv">
                    <%--<div>--%>

                    <%--</div>--%>
                    <div class="sidebar">
                        <!-- start sap_tabs -->
                        <h4 style="font-size: large">课程资料</h4>
                        <div>
                            <ul id="accordion" class="accordion">
                                <li>
                                    <div class="link"><i class="fa fa-globe"></i>课件<i class="fa fa-chevron-down"></i></div>
                                    <ul class="submenu">
                                        <c:forEach items="${sessionScope.detail_course_sourceList}" var="src">
                                            <c:if test="${src.srcType =='课件'}">
                                                <li><a href="detailCourse.action?file=${src.srcUrl}">${src.srcName}</a></li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </li>

                                <li>
                                    <div class="link"><i class="fa fa-globe"></i>讲义<i class="fa fa-chevron-down"></i></div>
                                    <ul class="submenu">
                                        <c:forEach items="${sessionScope.detail_course_sourceList}" var="src">
                                            <c:if test="${src.srcType =='讲义'}">
                                                <li><a href="detailCourse.action?file=${src.srcUrl}">${src.srcName}</a></li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </li>
                                <li>
                                    <div class="link"><i class="fa fa-globe"></i>实验指导<i class="fa fa-chevron-down"></i></div>
                                    <ul class="submenu">
                                        <c:forEach items="${sessionScope.detail_course_sourceList}" var="src">
                                            <c:if test="${src.srcType =='实验指导'}">
                                                <li><a href="detailCourse.action?file=${src.srcUrl}">${src.srcName}</a></li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </li>
                                <li>
                                    <div class="link"><i class="fa fa-globe"></i>教学进度表<i class="fa fa-chevron-down"></i></div>
                                    <ul class="submenu">
                                        <c:forEach items="${sessionScope.detail_course_sourceList}" var="src">
                                            <c:if test="${src.srcType =='教学进度表'}">
                                                <li><a href="detailCourse.action?file=${src.srcUrl}">${src.srcName}</a></li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </ul>
                        </div>

                        <br>
                        <h4 style="font-size: large">课程作品</h4>
                        <div>
                            <ul id="accordion1" class="accordion">
                                <c:forEach items="${sessionScope.detail_course_productListItem}" var="proItem">
                                    <li>
                                        <div class="link"><i class="fa fa-globe"></i>${proItem.proName}<i class="fa fa-chevron-down"></i></div>
                                        <ul class="submenu">
                                            <c:forEach items="${sessionScope.detail_course_productList}" var="pro">
                                                <c:if test="${pro.proType =='简介'}">
                                                    <li><a href="detailCourse.action?file=${pro.proUrl}">作品简介</a></li>
                                                </c:if>
                                                <c:if test="${pro.proType =='内容'}">
                                                    <li><a href="detailCourse.action?file=${pro.proUrl}">作品内容</a></li>
                                                </c:if>
                                                <c:if test="${pro.proType =='其他'}">
                                                    <li><a href="detailCourse.action?file=${pro.proUrl}">其他</a></li>
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>

                        <div style="text-align: center">
                            <c:if test="${sessionScope.userExistCourse == false}">
                                <a href="joinInCourse.action?userId=${sessionScope.user.userId}&couId=${sessionScope.detail_course_course.couId}&startTime=${sessionScope.detail_course_course.startTime}"
                                   class="button button-glow button-rounded button-raised button-primary" style="font-family: 微软雅黑">参加该课程</a>
                            </c:if>
                            <c:if test="${sessionScope.userExistCourse == true}">
                                <a href="joinOutCourse.action?userId=${sessionScope.user.userId}&couId=${sessionScope.detail_course_course.couId}&startTime=${sessionScope.detail_course_course.startTime}"
                                   class="button button-glow button-rounded button-caution" style="font-family: 微软雅黑">退出该课程</a>
                            </c:if>
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

<script type="text/javascript" src="js/pdfobject.js"></script>
<script>
    PDFObject.embed("${pageContext.request.contextPath}${param.file}", "#pdf");
</script>
