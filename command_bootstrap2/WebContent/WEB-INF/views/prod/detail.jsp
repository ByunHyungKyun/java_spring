<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>회원상세보기</title>

<body>
  <!-- Content Wrapper. Contains page content -->
  <div >
  	 <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>상세페이지</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">상품상세</i>
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	상세보기
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
  	</section>
    <!-- Main content -->
<section class="content">
      <!-- Default box -->
      <div class="card card-solid">
        <div class="card-body">
          <div class="row">
            <div class="col-12 col-sm-6">
              <div class="col-12">
                <img src="/member/getPicture.do?picture=${prod.img}" style="height: 600px" class="product-image" alt="Product Image">
              </div>
            </div>
            <div class="col-12 col-sm-6">
              <h3 class="my-3">${prod.name }</h3>
              <h3 class="my-3">${prod.price }원</h3>
              <hr>
              <p>${prod.detail }</p><br>
              <h4>배송정보 : ${prod.delivery }</h4><br>
              <h4 class="mt-3">배송비 :  <small>${prod.deliveryprice }원</small></h4><br>
              <h4>발송예정일 : <fmt:formatDate value="${prod.deliverydate }" pattern="yyyy-MM-dd"/> 까지</h4><br>
              <c:if test="${prod.qty  < 5}">
	               <div class="bg-red py-2 px-3 mt-4">
	                <h4 class="mb-0">
	                  	${prod.qty } 개 남음
	                </h4>
	              </div><br>
              </c:if>
              <c:if test="${prod.qty  >= 5}">
              <div class="bg-green py-2 px-3 mt-4">
                <h4 class="mb-0">
                  	${prod.qty } 개 남음
                </h4>
              </div>
               </c:if>
              <div class="mt-4">
                <div class="btn btn-primary btn-lg btn-flat" >
                  <i class="fas fa-cart-plus fa-lg mr-2"></i> 
                  	장바구니
                </div>&nbsp;&nbsp;&nbsp;&nbsp;
                <div class="btn btn-default btn-lg btn-flat">
                  <i class="fas fa-heart fa-lg mr-2"></i> 
                  	찜	
                </div>&nbsp;&nbsp;&nbsp;&nbsp;
                <div class="btn btn-default btn-lg btn-flat">
                  <i class="fas fa-envelope"></i> 
                 	 구매하기
                </div>
              </div>
            </div>
          </div>
          <div class="row mt-4">
            <nav class="w-100">
              <div class="nav nav-tabs" id="product-tab" role="tablist">
                <a class="nav-item nav-link active" id="product-desc-tab" data-toggle="tab" href="#product-desc" role="tab" aria-controls="product-desc" aria-selected="true">상세정보</a>
                <a class="nav-item nav-link" id="product-comments-tab" data-toggle="tab" href="#product-comments" role="tab" aria-controls="product-comments" aria-selected="false">Comments</a>
                <a class="nav-item nav-link" id="product-rating-tab" data-toggle="tab" href="#product-rating" role="tab" aria-controls="product-rating" aria-selected="false">상품평</a>
              </div>
            </nav>
            <div class="col-3"></div>
            <div class="col-6">
				<div class="tab-content p-12" id="nav-tabContent">
	              <div class="tab-pane fade show active" id="product-desc" role="tabpanel" aria-labelledby="product-desc-tab"> <img alt="안나오네"  src="/member/getPicture.do?picture=${prod.detailimg}" ></div> 
	              	<div class="tab-pane fade" id="product-comments" role="tabpanel" aria-labelledby="product-comments-tab">
	              			<div class="callout callout-info">
	              				<h4><i class="fas fa-info"></i> 상품 정보 : </h4>
	              				<br>
	              					상품평 등록 및 혜택 안내<br><br>
									일반 상품평 100p, 포토상품평 500p 적립 됩니다.<br><br>
									판매가격 2,000원 이하 상품의 포토상품평은 100p 적립되며, 일부 금액권은 포토상품평 작성 시 포인트 적립이 되지 않을 수 있습니다.<br><br>
									베스트 상품평 당첨 시 5,000p 를 지급해드립니다.<br><br>
									상품평 포인트는 상품평 작성일 기준 7일 후 적립됩니다.<br><br>
									작성해주신 상품평 및 사진은 상업적 용도로 활용될 수 있습니다.<br><br>
									상품평은 결제완료 후 90일이내 작성 가능합니다.<br><br>
									e티켓상품(모바일이용권 등)의 경우 실물 이용권이나 실제 이용하는 사진을 올려주셔야 합니다.<br><br>
									포토상품평 작성 포인트는 최초 작성 시 사진 첨부할 경우에만 적립 됩니다.<br><br>
									상품평 포인트 유효기간 안내<br><br>
									상품평 포인트는 적립일로부터 6개월 이내 사용가능하며, 유효기간이 만료된 포인트는 복구 불가능합니다.<br><br>
									주문취소, 반품요청 등으로 인한 소멸 포인트는 복구 불가능합니다.<br><br>
									포인트를 획득하기 위해 악의적인 의도로 상품평을 여러 개 남길 경우 포인트가 지급되지 않습니다.<br><br>
									(예시 : 캡쳐사진, 상품과 관계없는 사진, 동일사진 등)<br><br>
							</div>
					</div>
	              <div class="tab-pane fade" id="product-rating" role="tabpanel" aria-labelledby="product-rating-tab"> 
					<div class="timeline">
		              	<div class="time-label" id="repliesDiv">
		              		<span class="bg-green" >상품평 </span>
		              	</div>
	              	</div>
	              	<ul id="pagination" class="pagination justify-content-center m-0">
							
					</ul>
					<hr>
						<label for="newReplyWriter"></label>
						<input class="form-control" type="hidden" placeholder="USER ID"	 id="newReplyWriter" readonly value="${loginUser.id }"> 
						<label for="newReplyText">상품평</label>
						<input class="form-control" type="text"	placeholder="상품평을 적으시요" id="newReplyText">
						<br/>
						<button type="button" class="btn btn-primary" id="replyAddBtn" onclick="replyRegist_go();"><i class="fas fa-edit">상품평 등록</i></button>
	              </div>
	            </div>            
            </div>
            <div class="col-3"></div>
          </div>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
  <div id="modifyModal" class="modal modal-default fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" style="display:none;"></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>        
      </div>
      <div class="modal-body" data-rno>
        <p><input type="text" id="replytext" class="form-control"></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" id="replyModBtn" onclick="replyModify_go();">수정</button>
        <button type="button" class="btn btn-danger" id="replyDelBtn" onclick="replyRemove_go();">삭제</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>
  
  <form role="form">
  	<input type="hidden" name="pno" value="${prod.code }">
  </form>
  

  <%@ include file="./prodReply_js.jsp" %>







