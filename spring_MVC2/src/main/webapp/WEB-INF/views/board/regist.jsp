<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

    <!-- Main content -->
   <section class="content-header">
        <div class="container-fluid">
           <div class="row md-2">
              <div class="col-sm-6">
                 <h1>자유게시판 등록</h1>              
              </div>
              <div class="col-sm-6">
                 <ol class="breadcrumb float-sm-right">
                 <li class="breadcrumb-item">
                    <a href="list.do">
                       <i class="fa fa-dashboard"></i>자유게시판 등록
                    </a>
                 </li>
                 <li class="breadcrumb-item active">
                    등록
                 </li>              
            </ol>
              </div>
           </div>
        </div>
   </section>
    
  <!-- Main content -->
    <section class="content container-fluid">
      <div class="row justify-content-center">
         <div class="col-md-9" style="max-width:960px;">
            <div class="card card-outline card-info">
               <div class="card-header">
                  <h3 class="card-title p-1">자유게시판 등록</h3>
                  <div class ="card-tools">
                     <button type="button" class="btn btn-primary" id="registBtn" onclick="regist_go();">등 록</button>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <button type="button" class="btn btn-warning" id="cancelBtn" onclick="CloseWindow();" >취 소</button>
                  </div>
               </div><!--end card-header  -->
               <div class="card-body pad">
                  <form role="form" method="post" action="regist.do" name="registForm">
                     <div class="form-group">
                        <label for="title">제 목</label> 
                        <input type="text" id="title"
                           name='title' class="form-control" placeholder="제목을 쓰세요">
                     </div>                     
                     <div class="form-group">
                        <label for="writer">작성자</label> 
                        <input type="text" id="writer" readonly
                           name="writer" class="form-control" value="${loginUser.id }">
                     </div>
                     <div class="form-group">
                        <label for="content">내 용</label>
                        <textarea class="textarea" name="content" id="content" rows="20"
                           placeholder="1000자 내외로 작성하세요." style="display: none;"></textarea>
                     </div>
                  </form>
               </div><!--end card-body  -->
               <div class="card-footer" style="display:none">
               
               </div><!--end card-footer  -->
            </div><!-- end card -->            
         </div><!-- end col-md-12 -->
      </div><!-- end row -->
    </section>
    <!-- /.content -->
<!-- script가 실행되는 것은 라이브러리가 읽히기 전이므로 불가피하게 window.onload=function()을 걸게 됨 -->
<script>
window.onload=function(){
	 Summernote_start($('#content'));
}


function regist_go(){
	var form=document.registForm;
	if(form.title.value==""){
		alert("제목을 입력하셔야 합니다.");
		return;	
		
	}
	
	form.submit();
	
}


</script>

<%@ include file="/WEB-INF/views/common/summernote.jsp" %>



































