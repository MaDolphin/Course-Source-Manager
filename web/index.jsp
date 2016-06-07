<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ page import="com.JavaEE.service.UserService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Klass</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"  />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link type='text/css' rel='stylesheet' href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600'  >
  <link type="text/css" rel="stylesheet" href="css/stage/style.css"/>
  <link type="text/css" rel="stylesheet" href="css/stage/jquery-ui.min.css"/>
  <link type="text/css" rel="stylesheet" href="css/stage/module.search.css"/>
  <!-- jQuery and bootstrap -->
  <script type="text/javascript" src="js/stage/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/stage/jquery.min.js"></script>
  <script type="text/javascript" src="js/stage/jquery-ui.min.js"></script>
  <!-- start gallery -->
  <script type="text/javascript" src="js/stage/jquery.easing.min.js"></script>
  <script type="text/javascript" src="js/stage/jquery.mixitup.min.js"></script>

  <script type="text/javascript" src="js/stage/jquery.index.search.js"></script>

  <script type="text/javascript">
    $(function () {

      var filterList = {

        init: function () {

          // MixItUp plugin
          // http://mixitup.io
          $('#portfoliolist').mixitup({
            targetSelector: '.portfolio',
            filterSelector: '.filter',
            effects: ['fade'],
            easing: 'snap',
            // call the hover effect
            onMixEnd: filterList.hoverEffect()
          });

        },

        hoverEffect: function () {

          // Simple parallax effect
          $('#portfoliolist .portfolio').hover(
                  function () {
                    $(this).find('.label').stop().animate({bottom: 0}, 200, 'easeOutQuad');
                    $(this).find('img').stop().animate({top: -30}, 500, 'easeOutQuad');
                  },
                  function () {
                    $(this).find('.label').stop().animate({bottom: -40}, 200, 'easeInQuad');
                    $(this).find('img').stop().animate({top: 0}, 300, 'easeOutQuad');
                  }
          );

        }

      };

      // Run the show!
      filterList.init();

    });
  </script>
  <!-- Add fancyBox main JS and CSS files -->
  <link href="css/stage/module.magnific-popup.css" rel="stylesheet" type="text/css">
  <script src="js/stage/jquery.magnific-popup.js" type="text/javascript"></script>

</head>
<% ApplicationContext ctx= WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
  UserService userService = (UserService)ctx.getBean("userService");
  session.setAttribute("index_coulist",userService.queryallCoursesByNew12());
%>
<body>
<!-- start header -->
<div class="header_bg">
  <div class="wrap">
  <%@ include file="common/stage/header.jsp"%>
    <div class="header_btm">
      <div class="h_left">
        <h2 style="font-family: 微软雅黑;font-size: 36px;margin-bottom: 10px">欢迎来到课程资源世界</h2>
        <h2 style="font-family: 微软雅黑;font-size: 24px">Welcome to Course&Source!</h2>
      </div>
      <div class="clear"></div>
    </div>
  </div>
</div>

<div style="padding: 1%;background: white">
  <form class="form-wrapper cf" method="post" action="searchCourse.action">
    <input type="text" id="tags" name="couName" placeholder="课程名称..."  required>
    <button type="submit">查找课程</button>
  </form>
</div>

<!-- start main -->
<div class="main_bg">
  <div class="wrap">
    <div class="main">
      <!-- start popup -->
      <div id="small-dialog" class="mfp-hide">
      </div>
      <!-- end popup -->
      <!-- start gallery  -->
      <div class="container">
        <ul id="filters" class="clearfix">
          <li><span class="filter active" data-filter="app card icon logo web">全部课程</span></li> /
          <li><span class="filter" data-filter="app">艺术人文</span></li> /
          <li><span class="filter" data-filter="card">商务管理</span></li> /
          <li><span class="filter" data-filter="icon">数学逻辑</span></li> /
          <li><span class="filter" data-filter="logo">计算机科学</span></li> /
          <li><span class="filter" data-filter="web">自然科学</span></li>
        </ul>
        <div id="portfoliolist">
          <c:forEach items="${index_coulist}" var="cou">
            <c:if test="${cou.couType =='艺术人文'}">
              <a class="popup-with-zoom-anim" href="#small-dialog">
                <div class="portfolio app" data-cat="app">
                  <div class="portfolio-wrapper">
                    <img src="${pageContext.request.contextPath}${cou.couImage}" alt="Image 2" onclick="window.location.href='searchCourse.action?couName=${cou.couName}'" />
                    <div class="label">
                      <div class="label-text">
                        <p class="text-title">${cou.couName}</p>
                        <span class="text-category">${cou.couType}</span>
                      </div>
                      <div class="label-bg"></div>
                    </div>
                  </div>
                </div>
              </a>
            </c:if>
            <c:if test="${cou.couType =='商务管理'}">
              <a class="popup-with-zoom-anim" href="#small-dialog">
                <div class="portfolio card" data-cat="card">
                  <div class="portfolio-wrapper">
                    <img src="${pageContext.request.contextPath}${cou.couImage}" alt="Image 2" onclick="window.location.href='searchCourse.action?couName=${cou.couName}'"/>
                    <div class="label">
                      <div class="label-text">
                        <p class="text-title">${cou.couName}</p>
                        <span class="text-category">${cou.couType}</span>
                      </div>
                      <div class="label-bg"></div>
                    </div>
                  </div>
                </div>
              </a>
            </c:if>
            <c:if test="${cou.couType =='数学逻辑'}">
              <a class="popup-with-zoom-anim" href="#small-dialog">
                <div class="portfolio icon" data-cat="icon">
                  <div class="portfolio-wrapper">
                    <img src="${pageContext.request.contextPath}${cou.couImage}" alt="Image 2" onclick="window.location.href='searchCourse.action?couName=${cou.couName}'"/>
                    <div class="label">
                      <div class="label-text">
                        <p class="text-title">${cou.couName}</p>
                        <span class="text-category">${cou.couType}</span>
                      </div>
                      <div class="label-bg"></div>
                    </div>
                  </div>
                </div>
              </a>
            </c:if>
            <c:if test="${cou.couType =='计算机科学'}">
              <a class="popup-with-zoom-anim" href="#small-dialog">
                <div class="portfolio logo" data-cat="logo">
                  <div class="portfolio-wrapper">
                    <img src="${pageContext.request.contextPath}${cou.couImage}" alt="Image 2" onclick="window.location.href='searchCourse.action?couName=${cou.couName}'"/>
                    <div class="label">
                      <div class="label-text">
                        <p class="text-title">${cou.couName}</p>
                        <span class="text-category">${cou.couType}</span>
                      </div>
                      <div class="label-bg"></div>
                    </div>
                  </div>
                </div>
              </a>
            </c:if>
            <c:if test="${cou.couType =='自然科学'}">
              <a class="popup-with-zoom-anim" href="#small-dialog">
                <div class="portfolio web" data-cat="web">
                  <div class="portfolio-wrapper">
                    <img src="${pageContext.request.contextPath}${cou.couImage}" alt="Image 2" onclick="window.location.href='searchCourse.action?couName=${cou.couName}'"/>
                    <div class="label">
                      <div class="label-text">
                        <p class="text-title">${cou.couName}</p>
                        <span class="text-category">${cou.couType}</span>
                      </div>
                      <div class="label-bg"></div>
                    </div>
                  </div>
                </div>
              </a>
            </c:if>
          </c:forEach>

        </div>
      </div><!-- end container -->
    </div>
  </div>
</div>

<!-- start footer -->
<div>
  <%@ include file="common/stage/footer.jsp"%>
</div>
</body>
</html>
