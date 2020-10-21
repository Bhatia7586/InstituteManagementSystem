<!DOCTYPE html>
<%@page import="com.bean.StudentBean"%>
<%@page import="com.service.TechService"%>
<%@page import="com.bean.TechBean"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.service.TrainerService"%>
<%@page import="com.bean.TrainerBean"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">

<!-- Mirrored from educhamp.themetrades.com/demo/admin/courses.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:10:19 GMT -->
<head>

	<!-- META ============================================= -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="keywords" content="" />
	<meta name="author" content="" />
	<meta name="robots" content="" />
	
	<!-- DESCRIPTION -->
	<meta name="description" content="EduChamp : Education HTML Template" />
	
	<!-- OG -->
	<meta property="og:title" content="EduChamp : Education HTML Template" />
	<meta property="og:description" content="EduChamp : Education HTML Template" />
	<meta property="og:image" content="" />
	<meta name="format-detection" content="telephone=no">
	
	<!-- FAVICONS ICON ============================================= -->
	<link rel="icon" href="../error-404.html" type="image/x-icon" />
	<link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />
	
	<!-- PAGE TITLE HERE ============================================= -->
	<title>View Teachers</title>
	
	<!-- MOBILE SPECIFIC ============================================= -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.min.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
	
	<!-- All PLUGINS CSS ============================================= -->
	<link rel="stylesheet" type="text/css" href="assets/css/assets.css">
	<link rel="stylesheet" type="text/css" href="assets/vendors/calendar/fullcalendar.css">
	
	<!-- TYPOGRAPHY ============================================= -->
	<link rel="stylesheet" type="text/css" href="assets/css/typography.css">
	
	<!-- SHORTCODES ============================================= -->
	<link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">
	
	<!-- STYLESHEETS ============================================= -->
	<link rel="stylesheet" type="text/css" href="assets/css/style.css">
	<link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
	<link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
	
</head>
<body class="ttr-opened-sidebar ttr-pinned-sidebar">
<%

StudentBean sb = (StudentBean)session.getAttribute("studentUser");

if(sb == null)
{
	response.sendRedirect("loginStudent.jsp");	
}

HttpSession ses = request.getSession();
ses.setAttribute("studentUser", sb);


%>
<body class="ttr-opened-sidebar ttr-pinned-sidebar">
<body id="bg">
<div id="loading-icon-bx"></div>
	<!-- Header Top ==== -->
    <header class="header rs-nav">
		<div class="top-bar">
			<div class="container">
				<div class="row d-flex justify-content-between">
					<div class="topbar-left">
						<ul>
							<li><a href="faq-1.html"><i class="fa fa-question-circle"></i>Ask a Question</a></li>
						<!-- <li><a href="javascript:;"><i class="fa fa-envelope-o"></i>Support@website.com</a></li> -->	
						</ul>
					</div>
					<div class="topbar-right">
						<ul>
							<li>
								<select class="header-lang-bx">
									<option data-icon="flag flag-uk">English UK</option>
									<option data-icon="flag flag-us">English US</option>
								</select>
							</li>
							<li><%= sb.getFname() %></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="sticky-header navbar-expand-lg">
            <div class="menu-bar clearfix">
                <div class="container clearfix">
					<!-- Header Logo ==== -->
					<div class="menu-logo">
						<a href="studentIndex.jsp"><img src="assets/images/logo.png" alt=""></a>
					</div>
					<!-- Mobile Nav Button ==== -->
                    <button class="navbar-toggler collapsed menuicon justify-content-end" type="button" data-toggle="collapse" data-target="#menuDropdown" aria-controls="menuDropdown" aria-expanded="false" aria-label="Toggle navigation">
						<span></span>
						<span></span>
						<span></span>
					</button>
					<!-- Author Nav ==== -->
                    <div class="secondary-menu">
                        <div class="secondary-inner">
                            <ul>
								<li><a href="javascript:;" class="btn-link"><i class="fa fa-facebook"></i></a></li>
								<li><a href="javascript:;" class="btn-link"><i class="fa fa-google-plus"></i></a></li>
								<li><a href="javascript:;" class="btn-link"><i class="fa fa-linkedin"></i></a></li>
								<!-- Search Button ==== -->
								<li class="search-btn"><button id="quik-search-btn" type="button" class="btn-link"><i class="fa fa-search"></i></button></li>
							</ul>
						</div>
                    </div>
					<!-- Search Box ==== -->
                    <div class="nav-search-bar">
                        <form action="#">
                            <input name="search" value="" type="text" class="form-control" placeholder="Type to search">
                            <span><i class="ti-search"></i></span>
                        </form>
						<span id="search-remove"><i class="ti-close"></i></span>
                    </div>
					<!-- Navigation Menu ==== -->
                    <div class="menu-links navbar-collapse collapse justify-content-start" id="menuDropdown">
						<div class="menu-logo">
							<a href="studentIndex.jsp"><img src="assets/images/logo.png" alt=""></a>
						</div>
                        <ul class="nav navbar-nav">	
							<li class="active"><a href="javascript:;">HomePage <i class="fa fa-chevron-down"></i></a>
								<ul class="sub-menu">
									<li><a href="studentIndex.jsp">Home</a></li>
								</ul>
							 	
							</li>
							<li class="nav-dashboard"><a href="javascript:;">Dashboard <i class="fa fa-chevron-down"></i></a>
								<ul class="sub-menu">
									<li><a href="../studentIndex.jsp">Dashboard</a></li>
									<li><a href="viewTechnologiesStudent.jsp">View Technologies</a></li>
									<li><a href="viewTeachersStudent.jsp">View Teachers</a></li>
									<li><a href="viewCoursesStudent.jsp">Courses</a></li>
									<li><a href="addReviewStudent.jsp">Add Review</a></li>
									<li><a href="studentProfile.jsp">User Profile</a></li>
								</ul>
							</li>
							<li class="active"><a href="../studentIndex.jsp"> <-Back </a></li>
						</ul>
                    </div>
					<!-- Navigation Menu END ==== -->
                </div>
            </div>
        </div>
    </header>
<%

ArrayList<TrainerBean> li = new ArrayList<>();

TrainerService ts = new TrainerService();
li = ts.getAllTrainers();

String fname = null;

TechService tss = new TechService();

%>
	<!--Main container start -->
	<main class="ttr-wrapper">
		<div class="container-fluid">
			<div class="db-breadcrumb">
				<h4 class="breadcrumb-title">Teachers</h4>
				<ul class="db-breadcrumb-list">
					<li><a href="#"><i class="fa fa-home"></i>Home</a></li>
					<li>Teachers</li>
				</ul>
			</div>	
			<div class="row">
				<!-- Your Profile Views Chart -->
				<div class="col-lg-12 m-b30">
					<div class="widget-box">
						<div class="wc-title">
							<h4>Your Teachers</h4>
						</div>
						<div class="widget-inner">
<%
					for(TrainerBean t : li)
					{
%>							
							<div class="card-courses-list admin-courses">
								<div class="card-courses-media">
									<img src="assets/images/courses/pic1.jpg" alt=""/>
								</div>
								<div class="card-courses-full-dec">
									<div class="card-courses-title">
										<h4></h4>
									</div>
									<div class="card-courses-list-bx">
										<ul class="card-courses-view">
											<li class="card-courses-user">
												<div class="card-courses-user-pic">
													<img src="assets/images/testimonials/pic3.jpg" alt=""/>
												</div>
												<div class="card-courses-user-info">
													<h5>Teacher Name</h5>
													<h4><%= t.getT_fname() %> <%= t.getT_lname() %></h4>
												</div>
											</li>
											<li class="card-courses-categories">
												<h5>Email</h5>
												<h4><%= t.getT_email() %></h4>
											</li>
											<li class="card-courses-categories">
												<h5>Qualification</h5>
												<h4><%= t.getT_quali() %></h4>
											</li>
											
											
										</ul>
										<%
										
										HashMap<String,ArrayList<Integer>> me = ts.getTechnology(t.getTrainerid());
										
										ArrayList<Integer> al = me.get(t.getT_fname());
										
										
										%>
										<ul>
											<li class="card-courses-categories">
												<h5>Technologies</h5>
											<!--	<h4><%= me.get(t.getT_fname())%></h4> -->
												<%
													for(int a : al)
													{
														fname = tss.getTechById(a);
															
												%>
															<%= fname %>
												<% 		
												
														
													}
														
												
												%>
											</li>
										</ul>
									</div>
									<div class="row card-courses-dec">
										<div class="col-md-12">
											<h6 class="m-b10">Teacher Experience</h6>
											<p><%= t.getT_exp() %></p>	
										</div>
										<div class="col-md-12">
											<a href="#" class="btn green radius-xl outline">Approve</a>
											<a href="#" class="btn red outline radius-xl ">Cancel</a>
										</div>
									</div>
									
								</div>
							</div>
<%
					}

%>							
						</div>
					</div>
				</div>
				<!-- Your Profile Views Chart END-->
				<a href="../studentIndex.jsp"> <-Back </a>
			</div>
		</div>
	</main>
	<div class="ttr-overlay"></div>

<!-- External JavaScripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/vendors/bootstrap/js/popper.min.js"></script>
<script src="assets/vendors/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
<script src="assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
<script src="assets/vendors/magnific-popup/magnific-popup.js"></script>
<script src="assets/vendors/counter/waypoints-min.js"></script>
<script src="assets/vendors/counter/counterup.min.js"></script>
<script src="assets/vendors/imagesloaded/imagesloaded.js"></script>
<script src="assets/vendors/masonry/masonry.js"></script>
<script src="assets/vendors/masonry/filter.js"></script>
<script src="assets/vendors/owl-carousel/owl.carousel.js"></script>
<script src='assets/vendors/scroll/scrollbar.min.js'></script>
<script src="assets/js/functions.js"></script>
<script src="assets/vendors/chart/chart.min.js"></script>
<script src="assets/js/admin.js"></script>
<script src='assets/vendors/switcher/switcher.js'></script>
</body>

<!-- Mirrored from educhamp.themetrades.com/demo/admin/courses.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>