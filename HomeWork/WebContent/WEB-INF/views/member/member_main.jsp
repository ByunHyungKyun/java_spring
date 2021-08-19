<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty loginUser }">
	<jsp:forward page="/WEB-INF/views/member/member_main_client.jsp"></jsp:forward>
</c:if>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Starter</title>
  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="${pageContext.request.contextPath}/hwMain" class="nav-link">홈화면</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="${pageContext.request.contextPath}/hwList" class="nav-link">회원 리스트</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="${pageContext.request.contextPath}/hwSignUp" class="nav-link">회원 리스트 추가</a>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->
  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="#" class="brand-link">
      <span class="brand-text font-weight-light">Princebyun.inc</span>
    </a>
    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <!-- SidebarSearch Form -->
      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item menu-open">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                Starter Pages
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/hwMain" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>홈 화면</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/hwList" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>회원리스트</p>
                </a>
              </li>
               <li class="nav-item">
                <a href="${pageContext.request.contextPath}/hwSignUp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>회원리스트 추가</p>
                </a>
              </li>
            </ul>
          </li>
          
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">JSP 회원 CRUD 홈화면</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
    <!-- Main content -->
<section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
            <div class="callout callout-info">
              <h5><i class="fas fa-info"></i> 알림:</h5>
              관리자가 회원을 관리하기 위한 웹어플리케이션 홈화면 입니다!
            </div>
            <!-- Main content -->
            <div class="invoice p-3 mb-3">
              <!-- title row -->
              <div class="row">
                <div class="col-12">
                  <h4>
                    <i class="fas fa-globe"></i> princebyun, Inc.
                    <small class="float-right">Date: 15/05/2021</small>
                  </h4>
                </div>
                <!-- /.col -->
              </div>
              <!-- info row -->
              <div class="row invoice-info">
                <div class="col-sm-4 invoice-col">
                  From
                  <address>
                    <strong>BYUN, Inc.</strong><br>
                   	주공아파트, 130동102호<br>
                    대전광역시 중구 문화동, 보문산로161번길<br>
                    Phone: (010) 3360-0299<br>
                    Email: princebyun@naver.com
                  </address>
                </div>
                <!-- /.col -->
                <div class="col-sm-4 invoice-col">
                  To
                  <address>
                    <strong>DDIT, Inc.</strong><br>
                    영민빌딩 , 4층 403호<br>
                    대전광역시 중구 중앙로, 중앙로 76 <br>
                    Phone: (042) 222-8202<br>
                    Email: john.doe@example.com
                  </address>
                </div>
                <!-- /.col -->
                <div class="col-sm-4 invoice-col">
                  <b>ver. #000001</b><br>
                  <br>
                  <b>Order ID:</b> PC-14<br>
                  <b>Payment Due:</b> 15/05/2021<br>
                  <b>Account:</b> 123-34567
                </div>
                <!-- /.col -->
              </div>
              <!-- /.row -->
              <br>
              <br>
			<div class="row">
				<br>
				<h4>
                  	  최초 가입한 명예 회원 리스트
                </h4>
			</div>
              <!-- Table row -->
              <div class="row">
                <div class="col-12 table-responsive">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th>회원 아이디</th>
                      <th>회원 이메일</th>
                      <th>회원 전화번호</th>
                    </tr>
                    </thead>
                    <tbody>
                  	<c:if test="${not empty memberList }">
				<c:forEach items="${memberList }" var="member"  begin="1" end="4">
      			<tr>
	      			<td>
	      				<a href="${pageContext.request.contextPath}/hwSelect?id=${member.id }">${member.id }</a>
	      			</td>
      				<td>
      					${member.email }
      				</td>
      				<td>
      					${member.phone }
      				</td>
      			</tr>
      			</c:forEach>
      			</c:if>
      			<c:if test="${empty memberList }">
      				<tr>
	      			<td>
	      				회원리스트가 없습니다
	      			</td>
      				<td>
      					회원리스트가 없습니다
      				</td>
      				<td>
      					회원리스트가 없습니다
      				</td>
      			</tr>
      			</c:if>
                    </tbody>
                  </table>
                </div>
                <!-- /.col -->
              </div>
              <!-- /.row -->
				<br>
              <div class="row">
                <!-- accepted payments column -->
                <div class="col-6">
                  <p class="lead">Princebyun 주식회사 설립 목적:</p>
                  <p class="text-muted well well-sm shadow-none" style="margin-top: 10px;">
                    1월부터 시작된 대덕인재개발원에서 전자정부프레임 풀스택을 
                    위한 기본 회원 crud를 연습하기 위해 부트스트랩을 이용하여 회원을
                    관리하는 웹어플리케이션을 만들게 되었다 
                  </p>
                </div>
                <!-- /.col -->
                <div class="col-6">
                  <p class="lead">현재 날짜 &nbsp 17/05/2021</p>
                  <div class="table-responsive">
                    <table class="table">
                      <tbody><tr>
                        <th style="width:50%">가입 회원 수:</th>
                        <td>$250.30</td>
                      </tr>
                      <tr>
                        <th>Tax (9.3%)</th>
                        <td>$10.34</td>
                      </tr>
                      <tr>
                        <th>Shipping:</th>
                        <td>$5.80</td>
                      </tr>
                      <tr>
                        <th>Total:</th>
                        <td>$265.24</td>
                      </tr>
                    </tbody></table>
                  </div>
                </div>
                <!-- /.col -->
              </div>
              <!-- /.row -->
            </div>
            <!-- /.invoice -->
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->
  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="float-right d-none d-sm-inline">
      Anything you want
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->
<!-- REQUIRED SCRIPTS -->
<!-- jQuery -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>
</body>
</html>
