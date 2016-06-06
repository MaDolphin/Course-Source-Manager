<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Klass | User</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/stage/button.css" rel="stylesheet" type="text/css"/>
    <link href="css/stage/module.menulist.css" rel="stylesheet" type="text/css"/>
    <link href="css/stage/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/stage/input.css" rel="stylesheet" type="text/css"/>
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
                    <div style="margin-left: 90px">
                        <form method="post" action="editUser">
                            <div style="height: 40px">
                                <span><label class="mylab">用户编号</label></span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span><input name="userId" type="text" class="cssInput" value="${sessionScope.user.userId}" readonly></span>
                            </div>
                            <div style="height: 40px">
                                <span><label class="mylab">用户名</label></span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span><input name="userName" type="text" class="cssInput" value="${sessionScope.user.userName}"></span>
                            </div>
                            <div style="height: 40px">
                                <span><label class="mylab">用户邮箱</label></span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span><input name="userEmail" type="email" class="cssInput" value="${sessionScope.user.userEmail}"></span>
                            </div>
                            <div style="height: 40px">
                                <span><label class="mylab">用户密码</label></span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span><input name="userPwd" type="password" class="cssInput" value="${sessionScope.user.userPwd}"></span>
                            </div>
                            <div style="height: 40px">
                                <span><label class="mylab">创建时间</label></span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span><input name="createTime" type="text" class="cssInput" readonly value="${sessionScope.user.createTime}"></span>
                            </div>
                            <br>
                            <div style="height: 40px;margin-left: 0px">
                                <span><input type="submit" class="button button-glow button-rounded button-caution" value="更改提交"></span>
                            </div>
                        </form>
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
