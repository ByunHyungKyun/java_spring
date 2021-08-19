<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="cri" value="${pageMaker.cri }" />

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
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- jsGrid -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/jsgrid/jsgrid.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/jsgrid/jsgrid-theme.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  
</head>
<body class="hold-transition sidebar-mini">


			<section class="content">
			
			
			
				<div class="card">
					<div class="card-header with-border">
						<button type="button" class="btn btn-primary" onclick="OpenWindow('registForm.do','회원등록',800,700);">회원 등록</button>
						<div id="keyword" class="card-tools" style="width:550px;">
							<div class="input-group row">	
								<select class="form-control col-md-3" name="perPageNum" id="perPageNum"onchange="list_go();">
							  		<option value="10" >정렬개수</option>
							  		<option value="2" ${cri.perPageNum == 2 ? 'selected':''}>2개씩</option>
							  		<option value="3" ${cri.perPageNum == 3 ? 'selected':''}>3개씩</option>
							  		<option value="5" ${cri.perPageNum == 5 ? 'selected':''}>5개씩</option>
							  		
					  			</select>
					 			<select class="form-control col-md-3" name="searchType" id="searchType">
									<option value=""  ${cri.searchType eq '' ? 'selected':''}>검색구분</option>
									<option value="i"  ${cri.searchType eq 'i' ? 'selected':''}>아이디</option>
									<option value="p"  ${cri.searchType eq 'p' ? 'selected':''}>전화번호</option>
									<option value="e"  ${cri.searchType eq 'e' ? 'selected':''}>이메일</option>
								</select>
								<input  class="form-control" type="text" name="keyword" 
										placeholder="검색어를 입력하세요." value="${cri.keyword }"/>
								<span class="input-group-append">
									<button class="btn btn-primary" type="button" 
											id="searchBtn" data-card-widget="search" onclick="list_go(1);">
										<i class="fa fa-fw fa-search"></i>
									</button>
								</span>
							</div>
						</div>
					</div>
					<!-- /.card-header -->
					<div class="card-body">
						<div id="jsGrid1" class="jsgrid"
							style="position: relative; height: 100%; width: 100%;">
							<div class="jsgrid-grid-header jsgrid-header-scrollbar">
								<table class="jsgrid-table">
									<tr class="jsgrid-header-row">
										<th class="jsgrid-header-cell jsgrid-header-sortable"
											style="width: 150px;">아이디</th>
										<th
											class="jsgrid-header-cell jsgrid-align-right jsgrid-header-sortable"
											style="width: 50px;">이름</th>
										<th class="jsgrid-header-cell jsgrid-header-sortable"
											style="width: 200px;">주소</th>
										<th
											class="jsgrid-header-cell jsgrid-align-center jsgrid-header-sortable"
											style="width: 100px;">이메일</th>
										<th
											class="jsgrid-header-cell jsgrid-align-center jsgrid-header-sortable"
											style="width: 100px;">전화번호</th>
										<th
											class="jsgrid-header-cell jsgrid-align-center jsgrid-header-sortable"
											style="width: 100px;">등록일</th>
									</tr>
								</table>
							</div>
							<div class="jsgrid-grid-body" style="height: 600.875px;">
								<table class="jsgrid-table">
									<tbody>
										<c:if test="${not empty memberList }">
											<c:forEach items="${memberList }" var="member">
												<tr class="jsgrid-row">
													<td class="jsgrid-cell" style="width: 150px;">${member.id }</td>
													<td class="jsgrid-cell jsgrid-align-right"style="width: 50px;">${member.name }</td>
													<td class="jsgrid-cell" style="width: 200px;">${member.address }</td>
													<td class="jsgrid-cell jsgrid-align-center"style="width: 100px;">${member.email }</td>
													<td class="jsgrid-cell jsgrid-align-center"style="width: 100px;">${member.phone }</td>
													<td class="jsgrid-cell jsgrid-align-center"style="width: 100px;">
													<ftm:formatDate value="${member.regdate }" pattern="yyyy-MM-dd"/>
													</td>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${empty memberList }">
											<tr class="jsgrid-row">
												<td class="jsgrid-cell" style="width: 150px;">등록된 회원리스트가 없습니다</td>
												<td class="jsgrid-cell jsgrid-align-right"style="width: 50px;">등록된 회원리스트가 없습니다</td>
												<td class="jsgrid-cell" style="width: 200px;">등록된 회원리스트가 없습니다</td>
												<td class="jsgrid-cell jsgrid-align-center"style="width: 100px;">등록된 회원리스트가 없습니다</td>
												<td class="jsgrid-cell jsgrid-align-center"style="width: 100px;">등록된 회원리스트가 없습니다</td>
												<td class="jsgrid-cell jsgrid-align-center"style="width: 100px;">등록된 회원리스트가 없습니다</td>
											</tr>
										</c:if>
									</tbody>
								</table>
							</div>
							<div class="jsgrid-load-shader"
								style="display: none; position: absolute; inset: 0px; z-index: 1000;"></div>
							<div class="jsgrid-load-panel"
								style="display: none; position: absolute; top: 50%; left: 50%; z-index: 1000;">Please,
								wait...</div>
						</div>
					</div>
					<!-- /.card-body -->
				</div>
				<!-- /.card -->
					<div class="card-footer">
    					<c:set var="list_url" value="list.do" />
    					<%@ include file="/WEB-INF/views/common/pagination.jsp" %>	
    			</div>
				
			</section>
			<!-- /.content -->
		<script src="/resources/js/common.js" ></script>	
			
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
