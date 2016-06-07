<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<!-- BEGIN HEAD -->
<head>
    <title>Klass | 课程信息管理</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
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
    <link rel="stylesheet" type="text/css" href="css/backstage/select2_metro.css"/>
    <link rel="stylesheet" href="css/backstage/DT_bootstrap.css"/>
    <link href="css/backstage/bootstrap-fileupload.css" rel="stylesheet" type="text/css"/>
    <link href="css/backstage/chosen.css" rel="stylesheet" type="text/css"/>
    <link href="css/backstage/profile.css" rel="stylesheet" type="text/css"/>
    <!-- END PAGE LEVEL STYLES -->
    <link rel="shortcut icon" href="images/backstage/favicon.ico"/>
</head>
<!-- END HEAD -->
<%--Source--%>
<c:if test="${sessionScope.result_source_add != null}">
    <script  type="text/javascript">
        var msg = "${sessionScope.result_source_add}"
        if(msg == "true"){
            alert("Success! 添加课程资源成功！")
        }
        if(msg == "false"){
            alert("Error! 添加课程资源失败！")
        }
    </script>
</c:if>
<c:remove var="result_source_add" scope="session" />

<c:if test="${sessionScope.result_source_del != null}">
    <script  type="text/javascript">
        var msg = "${sessionScope.result_source_del}"
        if(msg == "true"){
            alert("Success! 删除课程资源成功！")
        }
        if(msg == "false"){
            alert("Error! 删除课程资源失败！")
        }
    </script>
</c:if>
<c:remove var="result_source_del" scope="session" />

<%--Homework--%>
<c:if test="${sessionScope.result_homework_add != null}">
    <script  type="text/javascript">
        var msg = "${sessionScope.result_homework_add}"
        if(msg == "true"){
            alert("Success! 添加作业成功！")
        }
        if(msg == "false"){
            alert("Error! 添加作业失败！")
        }
    </script>
</c:if>
<c:remove var="result_homework_add" scope="session" />

<c:if test="${sessionScope.result_homework_del != null}">
    <script  type="text/javascript">
        var msg = "${sessionScope.result_homework_del}"
        if(msg == "true"){
            alert("Success! 删除作业成功！")
        }
        if(msg == "false"){
            alert("Error! 删除作业失败！")
        }
    </script>
</c:if>
<c:remove var="result_homework_del" scope="session" />

<%--Product--%>
<c:if test="${sessionScope.result_product_add != null}">
    <script  type="text/javascript">
        var msg = "${sessionScope.result_product_add}"
        if(msg == "true"){
            alert("Success! 添加作品成功！")
        }
        if(msg == "false"){
            alert("Error! 添加作品失败！")
        }
    </script>
</c:if>
<c:remove var="result_product_add" scope="session" />

<c:if test="${sessionScope.result_product_del != null}">
    <script  type="text/javascript">
        var msg = "${sessionScope.result_product_del}"
        if(msg == "true"){
            alert("Success! 删除作品成功！")
        }
        if(msg == "false"){
            alert("Error! 删除作品失败！")
        }
    </script>
</c:if>
<c:remove var="result_product_del" scope="session" />

<!-- BEGIN BODY -->
<body class="page-header-fixed" onload="message()">
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
                <a href="adminMain.jsp">
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
                        <a href="teacherClassManager.action?teaId=${sessionScope.teacher.teaId}">授课课程</a>
                    </li>
                </ul>
            </li>

            <li class="">
                <a href="javascript:;">
                    <i class="icon-cogs"></i>
                    <span class="title">信息管理</span>
                    <span class="arrow "></span>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a href="teacherEditDetail.action">个人信息</a>
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
                        授课课程管理
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
                            <a href="#">授课课程</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <li>
                            <a href="#">课程详情</a>
                        </li>
                    </ul>
                    <!-- END PAGE TITLE & BREADCRUMB-->
                </div>
            </div>
            <!-- END PAGE HEADER-->
            <!-- BEGIN PAGE CONTENT-->
            <div class="row-fluid">
                <!--BEGIN TABS-->
                <div class="span12">
                    <ul class="unstyled profile-nav span3">
                        <li><img src="${pageContext.request.contextPath}${sessionScope.teacherCourse.couImage}" alt=""/>
                    </ul>
                    <div class="span9">
                        <div class="row-fluid">
                            <div class="span8 profile-info">
                                <br>
                                <h1>${sessionScope.teacherCourse.couName}</h1>
                                <p>${sessionScope.teacherCourse.couInfo}</p>
                                <ul class="unstyled inline">
                                    <li><i class="icon-map-marker"></i>${sessionScope.teacherCourse.couId}</li>
                                    <li><i class="icon-calendar"></i>${sessionScope.teacherCourse.startTime}
                                    </li>
                                    <li><i class="icon-briefcase"></i>${sessionScope.teacherCourse.couType}</li>
                                </ul>
                            </div>
                            <!--end span8-->
                            <div class="span4">
                                <div class="portlet sale-summary">
                                    <div class="portlet-title">
                                        <div class="caption">课程统计</div>
                                    </div>
                                    <ul class="unstyled">
                                        <li>
                                                    <span class="sale-info">资源数量<i
                                                            class="icon-img-up"></i></span>
                                            <span class="sale-num">${fn:length(sessionScope.teacherSourceList)}</span>
                                        </li>
                                        <li>
                                                    <span class="sale-info">作业数量<i
                                                            class="icon-img-down"></i></span>
                                            <span class="sale-num">${fn:length(sessionScope.teacherWorkInfoList)}</span>
                                        </li>
                                        <li>
                                            <span class="sale-info">授课人数</span>
                                            <span class="sale-num">${fn:length(sessionScope.teacherCourseInfoList)}</span>
                                        </li>
                                        <li>
                                            <span class="sale-info">作品数量</span>
                                            <span class="sale-num">${fn:length(sessionScope.teacherProductList)}</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <!--end span4-->
                        </div>
                    </div>

                    <div class="tabbable tabbable-custom tabbable-custom-profile">
                        &nbsp;
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab_1_11" data-toggle="tab">课程资源</a></li>
                            <li class=""><a href="#tab_1_22" data-toggle="tab">作业列表</a></li>
                            <li class=""><a href="#tab_1_44" data-toggle="tab">作品展示</a></li>
                            <li class=""><a href="#tab_1_33" data-toggle="tab">参加用户</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1_11">
                                <div class="portlet-body">
                                    <div class="clearfix">
                                        <div class="btn-group">
                                            <button id="sample_source_1_new" class="btn green"
                                                    onclick="window.location.href='teacherAddSource.action?couId=${sessionScope.teacherCourse.couId}&startTime=${sessionScope.teacherCourse.startTime}'">
                                                添加资源 <i class="icon-plus"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <table class="table table-striped table-bordered table-hover"
                                           id="sample_source">
                                        <thead>
                                        <tr>
                                            <th style="width:8px;"><input type="checkbox"
                                                                          class="group-checkable"
                                                                          data-set="#sample_source .checkboxes"/>
                                            </th>
                                            <th>资源编号</th>
                                            <th class="hidden-480">资源名称</th>
                                            <th class="hidden-480">资源类型</th>
                                            <th class="hidden-480">资源格式</th>
                                            <th class="hidden-480">资源序号</th>
                                            <th class="hidden-480">上传时间</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${sessionScope.teacherSourceList}" var="source">
                                            <tr class="odd gradeX">
                                                <td><input type="checkbox" class="checkboxes" value="1"/>
                                                </td>
                                                <td class="hidden-480">${source.srcId}</td>
                                                <td class="hidden-480">${source.srcName}</td>
                                                <td class="hidden-480">${source.srcType}</td>
                                                <td class="hidden-480">${source.srcFormat}</td>
                                                <td class="hidden-480">${source.srcNo}</td>
                                                <td class="hidden-480">${source.uploadTime}</td>
                                                <td class="hidden-480">
                                                    <a href="pdfShow.action?file=${source.srcUrl}"
                                                       class="btn mini blue"><i
                                                            class="icon-share"></i> 查看</a>
                                                    <a href="javascript:if(confirm('确认删除吗?'))window.location='delSource.action?srcId=${source.srcId}'" class="btn mini black"><i
                                                            class="icon-trash"></i> 删除</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!--tab-pane-->
                            <div class="tab-pane" id="tab_1_22">
                                <div class="portlet-body">
                                    <div class="clearfix">
                                        <div class="btn-group">
                                            <button id="sample_homework_1_new" class="btn green"
                                                    onclick="window.location.href='teacherAddHomework.action?couId=${sessionScope.teacherCourse.couId}&startTime=${sessionScope.teacherCourse.startTime}'">
                                                添加作业 <i class="icon-plus"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <table class="table table-striped table-bordered table-hover"
                                           id="sample_homework">
                                        <thead>
                                        <tr>
                                            <th style="width:8px;"><input type="checkbox"
                                                                          class="group-checkable"
                                                                          data-set="#sample_homework .checkboxes"/>
                                            </th>
                                            <th>作业编号</th>
                                            <th class="hidden-480">作业名称</th>
                                            <th class="hidden-480">创建时间</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${sessionScope.teacherWorkInfoList}" var="work">
                                            <tr class="odd gradeX">
                                                <td><input type="checkbox" class="checkboxes" value="1"/>
                                                </td>
                                                <td class="hidden-480">${work.workId}</td>
                                                <td class="hidden-480">${work.workName}</td>
                                                <td class="hidden-480">${work.createTime}</td>
                                                <td class="hidden-480">
                                                    <a href="pdfShow.action?file=${work.workUrl}" class="btn mini blue"><i
                                                            class="icon-share"></i> 查看</a>
                                                    <a href="javascript:if(confirm('确认删除吗?'))window.location='delHomework.action?workId=${work.workId}'" class="btn mini black"><i
                                                            class="icon-trash"></i> 删除</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!--tab-pane-->
                            <div class="tab-pane" id="tab_1_33">
                                <div class="portlet-body">

                                    <table class="table table-striped table-bordered table-hover"
                                           id="sample_teacheruser">
                                        <thead>
                                        <tr>
                                            <th style="width:8px;"><input type="checkbox"
                                                                          class="group-checkable"
                                                                          data-set="#sample_teacheruser .checkboxes"/>
                                            </th>
                                            <th>用户编号</th>
                                            <th class="hidden-480">用户名</th>
                                            <th class="hidden-480">电子邮箱</th>
                                            <th class="hidden-480">参加课程时间</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${sessionScope.teacherCourseInfoList}"
                                                   var="couInfo">
                                            <tr class="odd gradeX">
                                                <td><input type="checkbox" class="checkboxes" value="1"/>
                                                </td>
                                                <td class="hidden-480">${couInfo[0]}</td>
                                                <td class="hidden-480">${couInfo[1]}</td>
                                                <td class="hidden-480">${couInfo[2]}</td>
                                                <td class="hidden-480">${couInfo[3]}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                </div>
                            </div>
                            <!--tab-pane-->
                            <div class="tab-pane" id="tab_1_44">
                                <div class="portlet-body">
                                    <div class="clearfix">
                                        <div class="btn-group">
                                            <button id="sample_product_1_new" class="btn green"
                                                    onclick="window.location.href='teacherAddProduct.action?couId=${sessionScope.teacherCourse.couId}&startTime=${sessionScope.teacherCourse.startTime}'">
                                                添加作品 <i class="icon-plus"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <table class="table table-striped table-bordered table-hover"
                                           id="sample_teacherproduct">
                                        <thead>
                                        <tr>
                                            <th style="width:8px;"><input type="checkbox"
                                                                          class="group-checkable"
                                                                          data-set="#sample_teacherproduct .checkboxes"/>
                                            </th>
                                            <th>作品编号</th>
                                            <th class="hidden-480">作品名称</th>
                                            <th class="hidden-480">作品类型</th>
                                            <th class="hidden-480">作品格式</th>
                                            <th class="hidden-480">作品序号</th>
                                            <th class="hidden-480">上传时间</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${sessionScope.teacherProductList}" var="pro">
                                            <tr class="odd gradeX">
                                                <td><input type="checkbox" class="checkboxes" value="1"/>
                                                </td>
                                                <td class="hidden-480">${pro.proId}</td>
                                                <td class="hidden-480">${pro.proName}</td>
                                                <td class="hidden-480">${pro.proType}</td>
                                                <td class="hidden-480">${pro.proFormat}</td>
                                                <td class="hidden-480">${pro.proNo}</td>
                                                <td class="hidden-480">${pro.createTime}</td>
                                                <td class="hidden-480">
                                                    <%--<c:if test="${pro.proFormat == 'doc' || 'docx' || 'ppt' ||'pptx' ||'xls' ||'xlsx' || 'pdf' || 'txt'}">--%>
                                                        <a href="pdfShow.action?file=${pro.proUrl}" class="btn mini blue"><i
                                                                class="icon-share"></i> 查看</a>
                                                    <%--</c:if>--%>
                                                    <a href="javascript:if(confirm('确认删除吗?'))window.location='delProduct.action?workId=${pro.proId}'" class="btn mini black"><i
                                                            class="icon-trash"></i> 删除</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!--tab-pane-->
                        </div>
                    </div>
                </div>
                <!--end row-fluid-->
                <!--END TABS-->
                <!-- END PAGE CONTENT-->
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
    <script src="js/backstage/jquery.uniform.min.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <script type="text/javascript" src="js/backstage/select2.min.js"></script>
    <script type="text/javascript" src="js/backstage/jquery.dataTables.js"></script>
    <script type="text/javascript" src="js/backstage/DT_bootstrap.js"></script>
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN PAGE LEVEL SCRIPTS -->
    <script src="js/backstage/app.js"></script>
    <script src="js/backstage/table-managed.js"></script>
    <script src="js/backstage/app.js"></script>
    <script>
        jQuery(document).ready(function () {
            App.init();
            TableManaged.init();
        });
    </script>
</body>
<!-- END BODY -->
</html>
