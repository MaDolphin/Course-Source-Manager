<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ page import="com.JavaEE.dao.CourseDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!-- BEGIN HEAD -->
<head>
    <title>Klass | 课程信息管理</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="css/backstage/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/backstage/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/backstage/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/backstage/style-metro.css" rel="stylesheet" type="text/css"/>
    <link href="css/backstage/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/backstage/style-responsive.css" rel="stylesheet" type="text/css"/>
    <link href="css/backstage/default.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="css/backstage/uniform.default.css" rel="stylesheet" type="text/css"/>
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link rel="stylesheet" type="text/css" href="css/backstage/select2_metro.css" />
    <link rel="stylesheet" href="css/backstage/DT_bootstrap.css" />
    <!-- END PAGE LEVEL STYLES -->
    <link rel="shortcut icon" href="images/backstage/favicon.ico" />
</head>
<!-- END HEAD -->
<%--Add Course--%>
<c:if test="${sessionScope.result_course_add != null}">
    <script  type="text/javascript">
        var msg = "${sessionScope.result_course_add}"
        if(msg == "true"){
            alert("Success! 添加课程成功！")
        }
        if(msg == "false"){
            alert("Error! 添加课程失败！")
        }
    </script>
</c:if>
<c:remove var="result_course_add" scope="session" />

<%--Delete Course--%>
<c:if test="${sessionScope.result_course_del != null}">
    <script  type="text/javascript">
        var msg = "${sessionScope.result_course_del}"
        if(msg == "true"){
            alert("Success! 删除课程成功！")
        }
        if(msg == "false"){
            alert("Error! 删除课程失败！")
        }
    </script>
</c:if>
<c:remove var="result_course_del" scope="session" />

<%--Edit Course--%>
<c:if test="${sessionScope.result_course_edit != null}">
    <script  type="text/javascript">
        var msg = "${sessionScope.result_course_edit}"
        if(msg == "true"){
            alert("Success! 修改课程成功！")
        }
        if(msg == "false"){
            alert("Error! 修改课程失败！")
        }
    </script>
</c:if>
<c:remove var="result_course_edit" scope="session" />

<%--Batch import Course--%>
<c:if test="${sessionScope.result_course_batch != null}">
    <script  type="text/javascript">
        var msg = "${sessionScope.result_course_batch}"
        if(msg == "true"){
            alert("Success! 批量导入课程成功！")
        }
        if(msg == "false"){
            alert("Error! 批量导入课程失败！")
        }
    </script>
</c:if>
<c:remove var="result_course_batch" scope="session" />

<!-- BEGIN BODY -->
<body class="page-header-fixed">
    <!-- BEGIN HEADER -->
    <%@ include file="/common/backstage/header.jsp" %>
    <!-- END HEADER -->
    <!-- BEGIN CONTAINER -->
    <div class="page-container">
        <!-- BEGIN SIDEBAR -->
        <div class="page-sidebar nav-collapse collapse">
            <!-- BEGIN SIDEBAR MENU -->
            <ul class="page-sidebar-menu">
                <li>
                    <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                    <div class="sidebar-toggler hidden-phone"></div>
                    <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                </li>
                <li class="">
                    <a href="adminMain.action">
                        <i class="icon-home"></i>
                        <span class="title">主页</span>
                        <span class="selected"></span>
                    </a>
                </li>
                <li class="active">
                    <a href="javascript:;">
                        <i class="icon-file-text"></i>
                        <span class="title">课程管理</span>
                        <span class="arrow "></span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="#">课程信息管理</a>
                        </li>
                        <li>
                            <a href="courseBatchImport.action">批量导入课程信息</a>
                        </li>
                    </ul>
                </li>
                <li class="">
                    <a href="javascript:;">
                        <i class="icon-user"></i>
                        <span class="title">教师管理</span>
                        <span class="arrow "></span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="teacherInfoManager.action">教师信息管理</a>
                        </li>
                        <li>
                            <a href="teacherBatchImport.action">批量导入教师信息</a>
                        </li>
                    </ul>
                </li>
                <li class="">
                    <a href="javascript:;">
                        <i class="icon-user"></i>
                        <span class="title">用户管理</span>
                        <span class="arrow "></span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="userInfoManager.action">用户信息管理</a>
                        </li>
                        <li>
                            <a href="userAuthority.action">权限审核</a>
                        </li>
                    </ul>
                </li>
                <li class="">
                    <a href="javascript:;">
                        <i class="icon-cogs"></i>
                        <span class="title">系统管理</span>
                        <span class="arrow "></span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="adminEditDetail.action">管理员管理</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- END SIDEBAR MENU -->
        </div>
        <!-- END SIDEBAR -->
        <!-- BEGIN PAGE -->
        <div class="page-content">
            <!-- BEGIN PAGE CONTAINER-->
            <div class="container-fluid">
                <!-- BEGIN PAGE HEADER-->
                <div class="row-fluid">
                    <div class="span12">
                        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                        <h3 class="page-title">
                            课程信息管理
                        </h3>
                        <ul class="breadcrumb">
                            <li>
                                <i class="icon-home"></i>
                                <a href="adminMain.action">主页</a>
                                <i class="icon-angle-right"></i>
                            </li>
                            <li>
                                <a href="#">课程管理</a>
                                <i class="icon-angle-right"></i>
                            </li>
                            <li>
                                <a href="#">课程信息管理</a>
                            </li>
                        </ul>
                        <!-- END PAGE TITLE & BREADCRUMB-->
                    </div>
                </div>
                <!-- END PAGE HEADER-->
                <!-- BEGIN PAGE CONTENT-->
                <div class="row-fluid">
                    <div class="span12">
                        <!-- BEGIN EXAMPLE TABLE PORTLET-->

                            <div class="portlet-body">
                                <div class="clearfix">
                                    <div class="btn-group">
                                        <button id="sample_editable_1_new" class="btn green" onclick="window.location.href='adminAddCourse.action'">
                                            添加课程 <i class="icon-plus"></i>
                                        </button>
                                    </div>
                                </div>
                                <table class="table table-striped table-bordered table-hover" id="sample_course">
                                    <thead>
                                    <tr>
                                        <th style="width:8px;"><input type="checkbox" class="group-checkable" data-set="#sample_course .checkboxes" /></th>
                                        <th>课程编号</th>
                                        <th class="hidden-480">课程名称</th>
                                        <th class="hidden-480">开课时间</th>
                                        <th class="hidden-480">课程类别</th>
                                        <th class="hidden-480">授课教师工号</th>
                                        <th class="hidden-480">课程状态</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${sessionScope.courseList}" var="cou">
                                            <tr class="odd gradeX">
                                                <td><input type="checkbox" class="checkboxes" value="1" /></td>
                                                <td class="hidden-480">${cou.couId}</td>
                                                <td class="hidden-480">${cou.couName}</td>
                                                <td class="center hidden-480">${cou.startTime}</td>
                                                <td class="hidden-480">${cou.couType}</td>
                                                <td class="hidden-480">${cou.couTea}</td>
                                                <c:if test="${cou.couStatus == 0}">
                                                    <td ><span class="label label-warning">已创建</span></td>
                                                </c:if>
                                                <c:if test="${cou.couStatus == 1}">
                                                    <td ><span class="label label-success">已开课</span></td>
                                                </c:if>
                                                <c:if test="${cou.couStatus == 2}">
                                                    <td ><span class="label label-info">已结课</span></td>
                                                </c:if>
                                                <td class="hidden-480">
                                                    <a href="adminShowCourse.action?couId=${cou.couId}&startTime=${cou.startTime}" class="btn mini blue"><i class="icon-share"></i> 查看</a>
                                                    <a href="adminEditCourse.action?couId=${cou.couId}&startTime=${cou.startTime}" class="btn mini purple"><i class="icon-edit"></i> 修改</a>
                                                    <a href="javascript:if(confirm('确认删除该课程吗?'))window.location='deleteCourse.action?couId=${cou.couId}&startTime=${cou.startTime}'" class="btn mini black"><i class="icon-trash"></i> 删除</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        <!-- END EXAMPLE TABLE PORTLET-->
                    </div>
                </div>
                <!-- END PAGE CONTAINER-->
            </div>
        </div>
        <!-- END PAGE -->
    </div>
    <!-- END CONTAINER -->
    <!-- BEGIN FOOTER -->
    <%@ include file="/common/backstage/footer.jsp" %>
    <!-- END FOOTER -->
    <!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
    <!-- BEGIN CORE PLUGINS -->
    <script src="js/backstage/jquery-1.10.1.min.js" type="text/javascript"></script>
    <script src="js/backstage/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
    <!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
    <script src="js/backstage/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
    <script src="js/backstage/bootstrap.min.js" type="text/javascript"></script>
    <!--[if lt IE 9]>
    <script src="js/backstage/excanvas.min.js"></script>
    <script src="js/backstage/respond.min.js"></script>
    <![endif]-->
    <script src="js/backstage/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="js/backstage/jquery.blockui.min.js" type="text/javascript"></script>
    <script src="js/backstage/jquery.cookie.min.js" type="text/javascript"></script>
    <script src="js/backstage/jquery.uniform.min.js" type="text/javascript" ></script>
    <!-- END CORE PLUGINS -->
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <script type="text/javascript" src="js/backstage/select2.min.js"></script>
    <script type="text/javascript" src="js/backstage/jquery.dataTables.js"></script>
    <script type="text/javascript" src="js/backstage/DT_bootstrap.js"></script>
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN PAGE LEVEL SCRIPTS -->
    <script src="js/backstage/app.js"></script>
    <script src="js/backstage/table-managed.js"></script>
    <script>
        jQuery(document).ready(function() {
            App.init();
            TableManaged.init();
        });
    </script>
</body>
<!-- END BODY -->
</html>
