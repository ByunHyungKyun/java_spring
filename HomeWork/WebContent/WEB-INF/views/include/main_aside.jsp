<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link">
      <img src="<%=request.getContextPath() %>/resources/bootstrap/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">AdminLTE 3</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
        </div>
        <div class="info">
         		
         	<c:if test="${empty loginUser }">
				<div class="row">
					<a href="#">비회원</a>
					<button onclick="location.href='<%=request.getContextPath()%>/logout.do';"
						class="btn btn-xs btn-primary col-xs-3 " type="button">LOGIN</button>
				</div>
				<a href="#">tel : 비회원</a><br>
				<a href="#">email : 비회원></a>
			</c:if>
			
			<c:if test="${!empty loginUser }">
         	<div class="row">
         		<a href="#">${loginUser.name }</a>
         		<button onclick="location.href='<%=request.getContextPath()%>/logout.do';"
         		class="btn btn-xs btn-primary col-xs-3 " type="button">LOGOUT</button>
         	</div>
         	<a href="tel:${loginUser.phone }">tel : ${loginUser.phone }</a><br>
         	<a href="mailto:${loginUser.email }">email : ${loginUser.email }></a>
			</c:if>
         	
        </div>
      </div>


	<c:if test="${!empty loginUser }">
      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column subMenuList" data-widget="treeview" role="menu" data-accordion="false">
             <!--  sub-menu-list -->
        </ul>
      </nav>
      </c:if>
      
      <c:if test="${empty loginUser }">
      <nav class="mt-2" hidden="">
        <ul class="nav nav-pills nav-sidebar flex-column subMenuList" data-widget="treeview" role="menu" data-accordion="false">
             <!--  sub-menu-list -->
        </ul>
      </nav>
      </c:if>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
  