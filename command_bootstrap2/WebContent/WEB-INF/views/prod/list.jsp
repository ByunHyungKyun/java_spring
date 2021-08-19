<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="pageMaker" value="${dataMap.pageMaker }" />
<c:set var="cri" value="${dataMap.pageMaker.cri }" />
<c:set var="prodList" value="${dataMap.prodList }" />

<head></head>

<title>공지목록</title>
<body>
	 <!-- Main content -->
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>상품목록</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>상품목록
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	목록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	 <!-- Main content -->
    <section class="content">		
		<div class="card">
			<div class="card-header with-border">
				<c:if test="${loginUser.authority == 'ROLE_ADMIN' }">
				<button type="button" class="btn btn-primary" id="registBtn" onclick="OpenWindow('prodInsert.do','공지등록',500,900);">상품등록</button>				
				</c:if>
				<div id="keyword" class="card-tools" style="width:450px;">
					<div class="input-group row">
						<select class="form-control col-md-4" name="perPageNum" id="perPageNum"
					  		onchange="list_go();">
					  		<option value="10" >정렬개수</option>
					  		<option value="15" ${cri.perPageNum == 15 ? 'selected':''}>15개씩</option>
					  		<option value="20" ${cri.perPageNum == 20 ? 'selected':''}>20개씩</option>
					  		<option value="30" ${cri.perPageNum == 30 ? 'selected':''}>30개씩</option>
					  		
					  	</select>						
						<select class="form-control col-md-4" name="searchType" id="searchType">
							<option value="n"  ${cri.searchType eq 'n' ? 'selected':'' }>이름 검색</option>
						</select>					
						<input  class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${param.keyword }"/>
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" onclick="list_go(1);" 
							data-card-widget="search">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					</div>
				</div>						
			</div>
			<div class="card-body pb-0">
			<c:if test="${empty prodList }" >
						<strong>해당 내용이 없습니다.</strong>
			</c:if>
          <div class="row d-flex align-items-stretch">
			<c:forEach items="${prodList }" var="prod">
            <div class="col-12 col-sm-3 col-md-3 d-flex align-items-stretch" >
              <div class="card" >
               <c:if test="${prod.qty  < 5}">   
		            <div class="ribbon-wrapper ribbon-lg" >
		                        <div class="ribbon bg-info">
		                         인기상품
		                        </div>
		            </div>
             	 </c:if>
             	   <c:if test="${prod.qty  >= 5}">   
		            <div class="ribbon-wrapper ribbon-lg" style="display:none;">
		                        <div class="ribbon bg-info">
		                         인기상품
		                        </div>
		            </div>
             	 </c:if>
                <div class="card-header text-muted border-bottom-0">
                  OST 목걸이
                </div>
                <div class="card-body pt-0">
                  <div class="row">
                    <div class="col-12">
                    
                      <img alt="안나오네" style="height: 200px" src="/member/getPicture.do?picture=${prod.img}"   onclick="detail_go('${prod.code}');">
                    </div>
                  </div>
                  <div class="row">
                  	<div class="col-12">
                      <div class="card-header text-muted border-bottom-0"  onclick="detail_go('${prod.code}');">
                 		${prod.name }
                		</div>
                      <p class="text-muted text-sm"  onclick="detail_go('${prod.code}');"><b>${prod.detail }</b></p>
                       <p class="text-muted text-sm"   onclick="detail_go('${prod.code}');"><b>${prod.price }원</b></p>
                        <p class="text-muted text-sm"  onclick="detail_go('${prod.code}');"><b>${prod.qty } 개 남음</b></p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </c:forEach>
          </div>
        </div>
			<div class="card-footer">
				<%@ include file="/WEB-INF/views/common/pagination.jsp" %>				
			</div>
		</div>
		
    </section>
    <!-- /.content -->

<script src="/resources/js/common.js" ></script>

<script type="text/javascript">

function detail_go(prodCode){
	
	location.href="<%=request.getContextPath() %>/member/prodDetail.do?prodCode="+prodCode;
	
}


</script>




</body>







