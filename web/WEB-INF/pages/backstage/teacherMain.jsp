<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-- BEGIN HEAD -->
<head>
    <title>Class Teacher Manager</title>
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
    <link href="css/backstage/jquery.gritter.css" rel="stylesheet" type="text/css"/>
    <link href="css/backstage/daterangepicker.css" rel="stylesheet" type="text/css"/>
    <link href="css/backstage/fullcalendar.css" rel="stylesheet" type="text/css"/>
    <link href="css/backstage/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="css/backstage/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <!-- END PAGE LEVEL STYLES -->
    <link rel="shortcut icon" href="images/backstage/favicon.ico"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
<!-- BEGIN HEADER -->
<%@ include file="/common/backstage/header.jsp"%>
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
            <li class="start active ">
                <a href="teacherMain.action">
                    <i class="icon-home"></i>
                    <span class="title">主页</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li class="">
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
        <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
        <div id="portlet-config" class="modal hide">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"></button>
                <h3>Widget Settings</h3>
            </div>
            <div class="modal-body">
                Widget settings form goes here
            </div>
        </div>
        <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
        <!-- BEGIN PAGE CONTAINER-->
        <div class="container-fluid">
            <!-- BEGIN PAGE HEADER-->
            <div class="row-fluid">
                <div class="span12">
                    <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                    <h3 class="page-title">
                        Dashboard
                        <small>statistics and more</small>
                    </h3>
                    <ul class="breadcrumb">
                        <li>
                            <i class="icon-home"></i>
                            <a href="index.html">主页</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <li><a href="#">系统状态</a></li>
                        <li class="pull-right no-text-shadow">
                            <div id="dashboard-report-range"
                                 class="dashboard-date-range tooltips no-tooltip-on-touch-device responsive"
                                 data-tablet="" data-desktop="tooltips" data-placement="top"
                                 data-original-title="Change dashboard date range">
                                <i class="icon-calendar"></i>
                                <span></span>
                                <i class="icon-angle-down"></i>
                            </div>
                        </li>
                    </ul>
                    <!-- END PAGE TITLE & BREADCRUMB-->
                </div>
            </div>
            <!-- END PAGE HEADER-->
            <div id="dashboard">
                <!-- BEGIN DASHBOARD STATS -->
                <div class="row-fluid">
                    <div class="span3 responsive" data-tablet="span6" data-desktop="span3">
                        <div class="dashboard-stat blue">
                            <div class="visual">
                                <i class="icon-comments"></i>
                            </div>
                            <div class="details">
                                <div class="number">
                                    1349
                                </div>
                                <div class="desc">
                                    New Feedbacks
                                </div>
                            </div>
                            <a class="more" href="#">
                                View more <i class="m-icon-swapright m-icon-white"></i>
                            </a>
                        </div>
                    </div>
                    <div class="span3 responsive" data-tablet="span6" data-desktop="span3">
                        <div class="dashboard-stat green">
                            <div class="visual">
                                <i class="icon-shopping-cart"></i>
                            </div>
                            <div class="details">
                                <div class="number">549</div>
                                <div class="desc">New Orders</div>
                            </div>
                            <a class="more" href="#">
                                View more <i class="m-icon-swapright m-icon-white"></i>
                            </a>
                        </div>
                    </div>
                    <div class="span3 responsive" data-tablet="span6  fix-offset" data-desktop="span3">
                        <div class="dashboard-stat purple">
                            <div class="visual">
                                <i class="icon-globe"></i>
                            </div>
                            <div class="details">
                                <div class="number">+89%</div>
                                <div class="desc">Brand Popularity</div>
                            </div>
                            <a class="more" href="#">
                                View more <i class="m-icon-swapright m-icon-white"></i>
                            </a>
                        </div>
                    </div>
                    <div class="span3 responsive" data-tablet="span6" data-desktop="span3">
                        <div class="dashboard-stat yellow">
                            <div class="visual">
                                <i class="icon-bar-chart"></i>
                            </div>
                            <div class="details">
                                <div class="number">12,5M$</div>
                                <div class="desc">Total Profit</div>
                            </div>
                            <a class="more" href="#">
                                View more <i class="m-icon-swapright m-icon-white"></i>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- END DASHBOARD STATS -->
                <div class="clearfix"></div>
                <div class="row-fluid">
                    <div class="span6">
                        <!-- BEGIN PORTLET-->
                        <div class="portlet solid bordered light-grey">
                            <div class="portlet-title">
                                <div class="caption"><i class="icon-bar-chart"></i>Site Visits</div>
                                <div class="tools">
                                    <div class="btn-group pull-right" data-toggle="buttons-radio">
                                        <a href="" class="btn mini">Users</a>
                                        <a href="" class="btn mini active">Feedbacks</a>
                                    </div>
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div id="site_statistics_loading">
                                    <img src="images/backstage/loading.gif" alt="loading"/>
                                </div>
                                <div id="site_statistics_content" class="hide">
                                    <div id="site_statistics" class="chart"></div>
                                </div>
                            </div>
                        </div>
                        <!-- END PORTLET-->
                    </div>
                    <div class="span6">
                        <!-- BEGIN PORTLET-->
                        <div class="portlet solid light-grey bordered">
                            <div class="portlet-title">
                                <div class="caption"><i class="icon-bullhorn"></i>Activities</div>
                                <div class="tools">
                                    <div class="btn-group pull-right" data-toggle="buttons-radio">
                                        <a href="" class="btn blue mini active">Users</a>
                                        <a href="" class="btn blue mini">Orders</a>
                                    </div>
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div id="site_activities_loading">
                                    <img src="images/backstage/loading.gif" alt="loading"/>
                                </div>
                                <div id="site_activities_content" class="hide">
                                    <div id="site_activities" style="height:100px;"></div>
                                </div>
                            </div>
                        </div>
                        <!-- END PORTLET-->
                        <!-- BEGIN PORTLET-->
                        <div class="portlet solid bordered light-grey">
                            <div class="portlet-title">
                                <div class="caption"><i class="icon-signal"></i>Server Load</div>
                                <div class="tools">
                                    <div class="btn-group pull-right" data-toggle="buttons-radio">
                                        <a href="" class="btn red mini active">
                                            <span class="hidden-phone">Database</span>
                                            <span class="visible-phone">DB</span></a>
                                        <a href="" class="btn red mini">Web</a>
                                    </div>
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div id="load_statistics_loading">
                                    <img src="images/backstage/loading.gif" alt="loading"/>
                                </div>
                                <div id="load_statistics_content" class="hide">
                                    <div id="load_statistics" style="height:108px;"></div>
                                </div>
                            </div>
                        </div>
                        <!-- END PORTLET-->
                    </div>
                </div>
            </div>
        </div>
        <!-- END PAGE CONTAINER-->
    </div>
    <!-- END PAGE -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<%@ include file="/common/backstage/footer.jsp"%>
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
<script src="js/backstage/jquery.vmap.js" type="text/javascript"></script>
<script src="js/backstage/jquery.vmap.russia.js" type="text/javascript"></script>
<script src="js/backstage/jquery.vmap.world.js" type="text/javascript"></script>
<script src="js/backstage/jquery.vmap.europe.js" type="text/javascript"></script>
<script src="js/backstage/jquery.vmap.germany.js" type="text/javascript"></script>
<script src="js/backstage/jquery.vmap.usa.js" type="text/javascript"></script>
<script src="js/backstage/jquery.vmap.sampledata.js" type="text/javascript"></script>
<script src="js/backstage/jquery.flot.js" type="text/javascript"></script>
<script src="js/backstage/jquery.flot.resize.js" type="text/javascript"></script>
<script src="js/backstage/jquery.pulsate.min.js" type="text/javascript"></script>
<script src="js/backstage/date.js" type="text/javascript"></script>
<script src="js/backstage/daterangepicker.js" type="text/javascript"></script>
<script src="js/backstage/jquery.gritter.js" type="text/javascript"></script>
<script src="js/backstage/fullcalendar.min.js" type="text/javascript"></script>
<script src="js/backstage/jquery.easy-pie-chart.js" type="text/javascript"></script>
<script src="js/backstage/jquery.sparkline.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="js/backstage/app.js" type="text/javascript"></script>
<script src="js/backstage/index.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
    jQuery(document).ready(function () {
        App.init(); // initlayout and core plugins
        Index.init();
        Index.initJQVMAP(); // init index page's custom scripts
        Index.initCalendar(); // init index page's custom scripts
        Index.initCharts(); // init index page's custom scripts
        Index.initChat();
        Index.initMiniCharts();
        Index.initDashboardDaterange();
        Index.initIntro();
    });
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
