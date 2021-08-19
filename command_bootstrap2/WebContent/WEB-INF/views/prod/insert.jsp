<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<title>회원등록</title>
<body>
	<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper" >
  	 <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>상품 등록</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">상품 등록</i>
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
	<section class="content register-page">
	<div class="row">
	<form role="form" class="form-horizontal" action="regist2.do" method="post">	
	<div class="col-md-12">
          <div class="card card-primary">
            <div class="card-body">
							  <div class="row">								
								<div class="col-sm-6">
									<button type="button" id="registBtn" onclick="regist_go();" class="btn btn-block btn-outline-secondary">상품 등록하기</button>
							 	</div>
							 	
							 	<div class="col-sm-6">
									<button type="button" id="cancelBtn" onclick="CloseWindow();"
										class="btn btn-block btn-outline-danger">&nbsp;&nbsp;&nbsp;취 &nbsp;&nbsp;소&nbsp;&nbsp;&nbsp;</button>
								</div>
							</div>
							<br>
						            <div class="input-group mb-3">
						            <input type="hidden" name="picture" />
								<div class="mailbox-attachments clearfix" style="text-align: center;">
									<div class="mailbox-attachment-icon has-img" id="pictureView" style=" height: 200px; width: 140px; margin: 0 auto;" ></div><br>
									<div class="mailbox-attachment-info">
										<div class="input-group input-group-sm">
											<label for="inputFile" class=" btn btn-block btn-outline-warning">상품 사진 선택</label>
											<input id="inputFileName" class="form-control" type="text" name="tempPicture" disabled/>
											<span class="input-group-append-sm">											
												<button type="button" class="btn btn-info btn-sm btn-append" onclick="upload_go();"><i class="fas fa-save"></i>업로드</button>											
											</span>
										</div>
									</div>
								</div>
								<br />
							  </div>
              <div class="form-group">
                <label for="inputName">상품 이름</label>
                <input type="text" id="name" name="name" class="form-control" value="상품 이름을 입력하시오">
              </div>
              <div class="form-group">
                <label for="inputDescription">상품 간단 설명</label>
                <textarea id="detail" name="detail" class="form-control" rows="4">상품의 상세 정보를 입력하세요</textarea>
              </div>
              <div class="form-group">
                <label for="inputName">상품 가격</label>
                <input type="text" id="price" name="price" class="form-control" value="000,000">
              </div>
               <div class="form-group">
                <label for="inputName">배송 출발지</label>
                <input type="text" id="delivery" name="delivery" class="form-control" value="대덕인재 개발원">
              </div>
              <div class="form-group">
                <label for="inputClientCompany">배송비</label>
                <input type="text" id="deliveryprice" name="deliveryprice" class="form-control" value="2,500">
              </div>
               <div class="input-group mb-3" >
               <input type="hidden" name="picture2" />
								<div class="mailbox-attachments clearfix" style="text-align: center;">
									<div class="mailbox-attachment-icon has-img" id="pictureView2" style="height: 500px; width: 240px; margin: 0 auto;"></div>
									<div class="mailbox-attachment-info">
										<div class="input-group input-group-sm">
											<label for="inputFile2" class="btn btn-block btn-outline-success">상품상세 사진 선택</label>
											<input id="inputFileName2" class="form-control" type="text" name="tempPicture2" disabled/>
											<span class="input-group-append-sm">											
												<button type="button" class="btn btn-info btn-sm btn-append" onclick="upload_go2();"><i class="fas fa-save"></i>업로드</button>											
											</span>
										</div>
									</div>
								</div>
								<br />
							  </div>
              
            </div>
            <!-- /.card-body -->
        	</div>
          </div>
          <!-- /.card -->
        </form>
	</div>
		
	</section>		<!-- /.content -->
</div>
<!-- /.content-wrapper -->


<form role="imageForm" action="upload/picture.do" method="post" enctype="multipart/form-data">
	<input id="inputFile" name="pictureFile" type="file" class="form-control" onchange="picture_go();"
			style="display:none;">
	<input id="oldFile" type="hidden" name="oldPicture" value="" />
	<input type="hidden" name="checkUpload" value="0" />	
</form>
	
<form role="imageForm2" action="upload/picture.do" method="post" enctype="multipart/form-data">
	<input id="inputFile2" name="pictureFile2" type="file" class="form-control" onchange="picture_go2();"
			style="display:none;">
	<input id="oldFile2" type="hidden" name="oldPicture2" value="" />
	<input type="hidden" name="checkUpload2" value="0" />
</form>

<script src="/resources/js/member/regist2.js" ></script>

</body>






