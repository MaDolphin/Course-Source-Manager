<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link type="text/css" rel="stylesheet" href="css/stage/header.css"/>
<link type="text/css" rel="stylesheet" href="css/stage/module.login.css"/>
<script type="text/javascript" src="js/stage/bootstrap.min.js"></script>
<script type="text/javascript" src="js/stage/jquery.header.modal.login.js"></script>

<div class="header">
    <div class="logo">
        <h1><a href="index.jsp"><img src="images/stage/logo.png" alt=""/></a></h1>
    </div>
    <div class="h_right">
        <ul class="menu">
            <li><a href="adminMain.action">管理</a></li>
            <li><a href="index.jsp">首页</a></li>
            <li><a href="showCourse.action">课程</a></li>
            <c:if test="${sessionScope.user != null}">
                <li><a id="userbtn"  href="userIndex.action" class="login">你好，${sessionScope.user.userName}！</a></li>
                <li><a href="logout.action"  class="register">注销</a></li>
            </c:if>
            <c:if test="${sessionScope.user == null}">
                <li><a href="#loginmodal" id="modaltrigger_login" class="login">登录</a></li>
                <li><a href="#registermodal" id="modaltrigger_register" class="register">注册</a></li>
            </c:if>
        </ul>
        <div id="sb-search" class="sb-search">
            <form method="post" action="searchCourse.action">
                <input class="sb-search-input" placeholder="请输入你要寻找的课程名称" type="text" value="" name="couName" id="search">
                <input class="sb-search-submit" type="submit" value="">
                <span class="sb-icon-search"></span>
            </form>
        </div>
        <script src="js/stage/jquery.header.classie.js"></script>
        <script src="js/stage/jquery.header.uisearch.js"></script>
        <script>
            new UISearch(document.getElementById('sb-search'));
        </script>
    </div>
</div>

<div id="loginmodal" style="display:none;">
    <h1>用户登录</h1>
    <div id="divShow"></div>
    <form id="loginform" name="loginform" method="post">
        <label for="email">电子邮箱:</label>
        <input type="email" name="email" id="email" class="txtfield" placeholder="Email" tabindex="1">

        <label for="password">密码:</label>
        <input type="password" name="password" id="password" class="txtfield" placeholder="Password" tabindex="2">

        <div class="center">
            <input type="button" name="loginbtn" id="loginbtn" class="flatbtn-blu hidemodal" value="    登录    "  tabindex="3">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" name="forgotbtn" id="forgotbtn" class="flatbtn-red hidemodal" value="忘记密码"  tabindex="4">
        </div>
    </form>
</div>

<div id="registermodal" style="display:none;">
    <h1>用户注册</h1>
    <div id="div_show" class="warning"></div>
    <form id="registerform" name="registerform" method="post">
        <label for="email">电子邮箱:</label>
        <input type="email" name="registerEmail" id="registerEmail" class="txtfield" placeholder="Email Address" tabindex="1">

        <label for="password">用户名:</label>
        <input type="text" name="registerName" id="registerName" class="txtfield" placeholder="Name" tabindex="2">

        <label for="password">密码:</label>
        <input type="password" name="registerPassword" id="registerPassword" class="txtfield" placeholder="Password" tabindex="3">

        <div class="center">
            <input type="button" name="registerbtn" id="registerbtn" class="flatbtn-blu hidemodal" value="注册" tabindex="4">
        </div>
    </form>
</div>